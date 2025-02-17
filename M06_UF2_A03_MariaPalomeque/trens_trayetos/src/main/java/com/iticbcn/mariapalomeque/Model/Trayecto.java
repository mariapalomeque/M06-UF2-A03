package com.iticbcn.mariapalomeque.Model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="trayecto")
public class Trayecto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrayecto;
     @Column
    private double precio;
    @Column
    private String llegada;
    @Column
    private String salida;
    @Column
    private String hora;
    @Column
    private int capacidad;

    public int getIdTrayecto(){
        return idTrayecto;
    }

    public void setIdTrayecto(int idTrayecto) {
        this.idTrayecto = idTrayecto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Trayecto(){
        
    }

    public Trayecto(int idTrayecto, double precio, String llegada, String salida, String hora, int capacidad) {
        this.idTrayecto = idTrayecto;
        this.precio = precio;
        this.llegada = llegada;
        this.salida = salida;
        this.hora = hora;
        this.capacidad = capacidad;
    }

    
}
