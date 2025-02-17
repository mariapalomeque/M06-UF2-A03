package com.iticbcn.mariapalomeque.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "compania")
public class Compania {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compania")
    private int idCompania;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "localidad", nullable = false)
    private String localidad;

    @OneToMany(mappedBy = "compania", cascade = CascadeType.ALL,fetch=FetchType.EAGER, orphanRemoval = true)
    private List<Reserva> reservas;
   
    public Compania() {
    }

    public Compania(String nombre, String localidad) {
        this.nombre = nombre;
        this.localidad = localidad;
    }

    public int getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(int idCompania) {
        this.idCompania = idCompania;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Compania [idCompania=" + idCompania + ", nombre=" + nombre + ", localidad=" + localidad + ", reservas=" + reservas + "]";
    }
}
