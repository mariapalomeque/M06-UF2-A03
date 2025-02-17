package com.iticbcn.mariapalomeque.Model;

public class Tren {
    private int idtren;
    private String modelo;
    private String nombre;

    public Tren(){

    }

    public Tren(int idtren, String modelo, String nombre) {
        this.idtren = idtren;
        this.modelo = modelo;
        this.nombre = nombre;
    }

    public int getIdtren() {
        return idtren;
    }

    public void setIdtren(int idtren) {
        this.idtren = idtren;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}
