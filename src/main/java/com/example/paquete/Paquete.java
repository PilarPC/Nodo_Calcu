package com.example.paquete;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Paquete  implements Serializable {


    public Paquete(String mensaje, int puertoEmisor, char IDdireccion, char codigoOperacion, String huellaCliente, String huellaServidor) {
        this.mensaje = mensaje;
        this.puertoEmisor = puertoEmisor;
        this.IDdireccion = '0';
        this.codigoOperacion = '0';
        this.huellaCliente = " ";
        this.huellaServidor = " ";

    }
    public String getClon() {
        return clon;
    }

    public void setClon(String clon) {
        this.clon = clon;
    }

    public String clon="";
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getPuertoEmisor() {
        return puertoEmisor;
    }

    public void setPuertoEmisor(int puertoEmisor) {
        this.puertoEmisor = puertoEmisor;
    }

    public char getIDdireccion() {
        return IDdireccion;
    }

    public void setIDdireccion(char IDdireccion) {
        this.IDdireccion = IDdireccion;
    }

    public char getCodigoOperacion() {
        return codigoOperacion;
    }

    public void setCodigoOperacion(char codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }


    public String getHuellaCliente() {return huellaCliente;}

    public void setHuellaCliente(String huellaCliente) {this.huellaCliente = huellaCliente;}


    public String getHuellaServidor() { return huellaServidor;}

    public void setHuellaServidor(String huellaServidor) {this.huellaServidor = huellaServidor;}

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getAcuse() {
        return acuse;
    }

    public void setAcuse(String acuse) {
        this.acuse = acuse;
    }

    public String getTiempoAcuse() {
        return tiempoAcuse;
    }

    public void setTiempoAcuse(String tiempoAcuse) {
        this.tiempoAcuse = tiempoAcuse;
    }

    public int getAcusesRecibidos() {
        return acusesRecibidos;
    }

    public void setAcusesRecibidos(int acusesRecibidos) {
        this.acusesRecibidos = acusesRecibidos;
    }

    public HashMap<String, Integer> getMapaHuellasDeServidores() {
        return mapaHuellasDeServidores;
    }

    public void setMapaHuellasDeServidores(HashMap<String, Integer> mapaHuellasDeServidores) {
        this.mapaHuellasDeServidores = mapaHuellasDeServidores;
    }

    public int getAcusesActualizadosSuma() {
        return acusesActualizadosSuma;
    }

    public void setAcusesActualizadosSuma(int acusesActualizadosSuma) {
        this.acusesActualizadosSuma = acusesActualizadosSuma;
    }

    public int getAcusesActualizadosResta() {
        return acusesActualizadosResta;
    }

    public void setAcusesActualizadosResta(int acusesActualizadosResta) {
        this.acusesActualizadosResta = acusesActualizadosResta;
    }

    public int getAcusesActualizadosMultiplicacion() {
        return acusesActualizadosMultiplicacion;
    }

    public void setAcusesActualizadosMultiplicacion(int acusesActualizadosMultiplicacion) {
        this.acusesActualizadosMultiplicacion = acusesActualizadosMultiplicacion;
    }

    public int getAcusesActualizadosDivision() {
        return acusesActualizadosDivision;
    }

    public void setAcusesActualizadosDivision(int acusesActualizadosDivision) {
        this.acusesActualizadosDivision = acusesActualizadosDivision;
    }


    public String mensaje;
    int acusesActualizadosSuma=2;
    int acusesActualizadosResta=1;
    int acusesActualizadosMultiplicacion=3;
    int acusesActualizadosDivision=4;


    public int puertoEmisor;
    char IDdireccion;
    char codigoOperacion;

    String huellaCliente;
    String huellaServidor;

    String evento;


    String acuse;


    String tiempoAcuse = " ";

    int acusesRecibidos = 0;

    HashMap<String, Integer> mapaHuellasDeServidores = new HashMap<>();

}
