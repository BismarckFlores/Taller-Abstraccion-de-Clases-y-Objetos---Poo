package com.hotel.servicio;

import com.hotel.enums.EstadoHabitacion;
import com.hotel.enums.EstadoReserva;
import com.hotel.modelo.Habitacion;
import com.hotel.modelo.Huesped;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private int id;
    private Huesped huesped;
    private Habitacion habitacion;

    private LocalDate fechaCheckIn;
    private LocalDate fechaCheckOut;

    private EstadoReserva estado;
    private double costoTotal;

    public Reserva() {}

    public Reserva(int id, Huesped huesped, Habitacion habitacion, LocalDate fechaCheckIn, LocalDate fechaCheckOut) {
        this.id = id;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.estado = EstadoReserva.PENDIENTE;
    }

    public void realizarReserva() {
        calcularCostoTotal();
        this.habitacion.setEstado(EstadoHabitacion.OCUPADA);
    }

    private void calcularCostoTotal() {
        long noches = ChronoUnit.DAYS.between(fechaCheckIn, fechaCheckOut);
        this.costoTotal = noches * habitacion.getPrecioPorNoche();
    }

    public void confirmarReserva() {
        switch (this.estado) {
            case PENDIENTE -> this.estado = EstadoReserva.CONFIRMADA;
            default -> {}
        }
    }

    public void cancelarReserva() {
        switch (this.estado) {
            case PENDIENTE, CONFIRMADA -> {
                this.estado = EstadoReserva.CANCELADA;
                this.habitacion.setEstado(EstadoHabitacion.DISPONIBLE);
            }
            default -> {}
        }
    }

    public void finalizarReserva() {
        switch (this.estado) {
            case CONFIRMADA -> {
                this.estado = EstadoReserva.FINALIZADA;
                this.habitacion.setEstado(EstadoHabitacion.MANTENIMIENTO);
            }
            default -> {}
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaCheckIn() {
        return fechaCheckIn;
    }

    public void setFechaCheckIn(LocalDate fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

    public LocalDate getFechaCheckOut() {
        return fechaCheckOut;
    }

    public void setFechaCheckOut(LocalDate fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        return "===== Reserva =====\n" +
                "Id: " + id + "\n" +
                "Huesped: " + huesped.getNombreCompleto() + "\n" +
                "Habitacion: #" + habitacion.getNumero() + "\n" +
                "FechaCheckIn: " + fechaCheckIn + "\n" +
                "FechaCheckOut: " + fechaCheckOut + "\n" +
                "Estado: " + estado + "\n" +
                "Costo Total: " + costoTotal + "\n" +
                "===================";
    }
}
