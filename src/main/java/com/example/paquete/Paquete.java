package com.example.paquete;

import java.io.Serializable;

public class Paquete  implements Serializable {


    public Paquete(String mensaje, int puertoEmisor, char IDdireccion, char codigoOperacion, String huellaCliente, String huellaServidor) {
        this.mensaje = mensaje;
        this.puertoEmisor = puertoEmisor;
        this.IDdireccion = '0';
        this.codigoOperacion = '0';
        this.huellaCliente = " ";
        this.huellaServidor = " ";

    }

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


    public String mensaje;
    public int puertoEmisor;
    char IDdireccion;
    char codigoOperacion;

    String huellaCliente;
    String huellaServidor;

    String evento;


    String acuse;


    String tiempoAcuse = " ";

    int acusesRecibidos = 0;


}
