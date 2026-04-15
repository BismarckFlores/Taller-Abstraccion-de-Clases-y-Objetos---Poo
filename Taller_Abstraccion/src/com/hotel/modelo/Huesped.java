package com.hotel.modelo;

public class Huesped {
    private String id;
    private String nombreCompleto;
    private String email;

    public Huesped() {}

    public Huesped(String id, String nombreCompleto, String email) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "===== Huesped =====\n" +
                "Id: " + id  + "\n" +
                "Nombre: " + nombreCompleto + "\n" +
                "Email: " + email + "\n" +
                "===================";
    }
}