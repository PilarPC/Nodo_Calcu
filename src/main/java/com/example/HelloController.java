package com.example;

import com.example.paquete.Paquete;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloController implements Runnable {

    @FXML
    private VBox VbHistorial;
    @FXML
    private Label idNodo;

    public int PUERTO_ACTUAL = 0;
    int puerto_Nodo = 11000;
    int numeroNodo = 1;
    int puertosNodos[] = {11000, 11001, 11002, 11003, 11004};

    public void initialize() {
        Thread hilo1 = new Thread(this);
        hilo1.start();
    }

    @Override
    public void run() {


        while (true) {
            String numeroNodoImprime = numeroNodo + "";
            try {
                ServerSocket misocketNodo = new ServerSocket(puerto_Nodo);
                PUERTO_ACTUAL = puerto_Nodo;

                Platform.runLater(() -> {
                    idNodo.setText("NODO: " + numeroNodoImprime + " puerto: " + PUERTO_ACTUAL);
                });
                while (true) {
                    //RECIBIR
                    Socket misocketC = misocketNodo.accept();
                    ObjectInputStream flujoEntradaC = new ObjectInputStream(misocketC.getInputStream());
                    Paquete paqueteRecibido = (Paquete) flujoEntradaC.readObject();
                    Platform.runLater(() -> {
                        VbHistorial.getChildren().add(new Label("Tipo de direccion: " + paqueteRecibido.getIDdireccion()+ " El Operacopn " + paqueteRecibido.getCodigoOperacion() + "\n"));
                    });
                   // System.out.println(paqueteRecibido.getMensaje() + " " + paqueteRecibido.getPuertoEmisor() + " " + paqueteRecibido.getIDdireccion() + " Estoy recibiendo en el puerto " + PUERTO_TEMPORAL);


                    if(paqueteRecibido.getIDdireccion() != 'N'){//si la direccion no es de un nodo
                        //se lo mando al resto de nodos
                        mandarNodos(paqueteRecibido);
                    }
                    if (paqueteRecibido.getCodigoOperacion() == 'a' | paqueteRecibido.getCodigoOperacion() == 'b' | paqueteRecibido.getCodigoOperacion() == 'c' | paqueteRecibido.getCodigoOperacion() == 'd') {

                        //MANDO SERVIDOR
                        paqueteRecibido.setIDdireccion('N');
                        mandarServidores(paqueteRecibido);

                    } else if (paqueteRecibido.getCodigoOperacion() == 'm') {//Si el mensaje que llega es de un servidor getIDdireccion=S cuyo codigo de operacion es m
                        //MANDO A CALCULADOA
                        System.out.println("Mando a caluladoras");
                        System.out.println("ACUSE recibido " + paqueteRecibido.getAcuse() );
                        paqueteRecibido.setIDdireccion('N');
                        mandarCalculadoras(paqueteRecibido);
                    }

                    misocketC.close();
                }

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e);
                numeroNodo++;
                puerto_Nodo++;

            }
        }

    }

    void mandarNodos(Paquete paqueteRecibido){
        for (int pNodo : puertosNodos) {//le enviamos el mensaje a los nodos
            if (PUERTO_ACTUAL == pNodo) {
                //System.out.println("estoy en el nodo actual");
            } else {
                try {
                    Socket flujoSalidaN = new Socket("127.0.0.1", (pNodo));
                    ObjectOutputStream paqueteSalidaN = new ObjectOutputStream(flujoSalidaN.getOutputStream());
                    paqueteRecibido.setIDdireccion('N');
                    //paqueteRecibido.setPuertoEmisor(pNodo);
                    paqueteRecibido.setPuertoEmisor(PUERTO_ACTUAL);
                    paqueteSalidaN.writeObject(paqueteRecibido);
                    flujoSalidaN.close();
                    paqueteSalidaN.close();
                } catch (IOException e) {
                   // System.out.println(e);
                   // System.out.println("servidor apagado: " + pNodo);
                }
            }
        }
    }
    void mandarServidores(Paquete paqueteRecibido) {
        int puertoServidor = 13000 + numeroNodo - 1;
        try {
            //mandar SERVIDOR
            Socket flujoSalidaS = new Socket("127.0.0.1", puertoServidor);
            ObjectOutputStream paqueteSalida = new ObjectOutputStream(flujoSalidaS.getOutputStream());
            paqueteSalida.writeObject(paqueteRecibido);
            flujoSalidaS.close();
            String enviarPS = puertoServidor + "";
            Platform.runLater(() -> {
                VbHistorial.getChildren().add(new Label("Se mamdo resultado a : " + puertoServidor + "\n"));
            });
            System.out.println("se mando resultado a ");

        } catch (IOException e) {
            //System.out.println(" Servidor no está a la escucha");
        }
    }

    void mandarCalculadoras(Paquete paqueteRecibido) {
        int puertoCliente = 12000 + numeroNodo - 1;
        try {
            Socket flujoSalidaC = new Socket("127.0.0.1", puertoCliente);
            ObjectOutputStream paqueteSalida = new ObjectOutputStream(flujoSalidaC.getOutputStream());
            paqueteSalida.writeObject(paqueteRecibido);
            flujoSalidaC.close();
            Platform.runLater(() -> {
                VbHistorial.getChildren().add(new Label("Se mamdo resultado a : " + puertoCliente + "\n"));
            });
            //System.out.println("se mando resultado a " + puertoCliente);
        } catch (IOException e) {
            //System.out.println(puertoCliente + " Cliente no está a la escucha");
        }
    }


}
