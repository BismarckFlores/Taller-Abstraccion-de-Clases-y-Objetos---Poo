package com.hotel.modelo;

import com.hotel.enums.EstadoHabitacion;
import com.hotel.enums.TipoHabitacion;

public class Habitacion {

    private int numero;
    private TipoHabitacion tipo;
    private double precioPorNoche;
    private EstadoHabitacion estado;

    public Habitacion() {}

    public Habitacion(int numero, TipoHabitacion tipo, double precioPorNoche) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.estado = EstadoHabitacion.DISPONIBLE;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "===== Habitacion =====\n" +
                "Id:" + numero + "\n" +
                "Tipo:" + tipo + "\n" +
                "Precio por Noche: " + precioPorNoche + "\n" +
                "Estado: " + estado + "\n" +
                "======================";
    }
}
