package com.hotel.main;

import com.hotel.enums.EstadoHabitacion;
import com.hotel.enums.EstadoReserva;
import com.hotel.enums.TipoHabitacion;
import com.hotel.modelo.Habitacion;
import com.hotel.modelo.Huesped;
import com.hotel.servicio.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Huesped> huespedes = new ArrayList<>();
    static List<Habitacion> habitaciones;
    static List<Reserva> reservas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void esperarTecla() {
        System.out.println("\nPresione Enter para continuar...");
        sc.nextLine();
    }

    public static void main(String[] args) {
        huespedes = new ArrayList<>(List.of(
                new Huesped("a001", "Pedro Pascal", "Pd@gmail.com"),
                new Huesped("a002", "Natalie Portman", "Np@gmail.com"),
                new Huesped("a003", "Scarlett Johansson", "Sj@gmail.com"),
                new Huesped("a004", "Chris Evans", "Ce@gmail.com")
        ));

        habitaciones = new ArrayList<>(List.of(
                new Habitacion(1, TipoHabitacion.INDIVIDUAL, 100.0),
                new Habitacion(2, TipoHabitacion.INDIVIDUAL, 90.0),
                new Habitacion(3, TipoHabitacion.DOBLE, 150.0),
                new Habitacion(4, TipoHabitacion.DOBLE, 140.0),
                new Habitacion(5, TipoHabitacion.SUITE, 300.0)
        ));

        int seleccion;
        do {
            System.out.println("\n=== Sistema de Reservas de Hotel ===");
            System.out.println("1. Huespedes");
            System.out.println("2. Habitaciones");
            System.out.println("3. Reservas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            seleccion = sc.nextInt();
            sc.nextLine();

            switch (seleccion) {
                case 1 -> huespedes();
                case 2 -> habitaciones();
                case 3 -> reservas();
                case 4 -> System.out.println("Saliendo del sistema. ¡Hasta luego!");
                default -> System.err.println("Opción no válida. Intente nuevamente.");
            }
        } while (seleccion != 4);
    }

    public static void huespedes() {
        int seleccion;
        while (true) {
            System.out.println("\n=== Gestión de Huespedes ===");
            System.out.println("1. Agregar Huesped");
            System.out.println("2. Listar Huespedes");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            seleccion = sc.nextInt();
            sc.nextLine();

            switch (seleccion) {
                case 1 -> {
                    System.out.print("Ingrese el ID del Huesped: ");
                    String id = sc.nextLine();
                    System.out.print("Ingrese el nombre completo del Huesped: ");
                    String nombreCompleto = sc.nextLine();
                    System.out.print("Ingrese el email del Huesped: ");
                    String email = sc.nextLine();

                    Huesped nuevoHuesped = new Huesped(id, nombreCompleto, email);
                    huespedes.add(nuevoHuesped);
                    System.out.println("¡Huesped agregado exitosamente!");

                    esperarTecla();
                }
                case 2 -> {
                    System.out.println("\n--- Lista de Huespedes ---");
                    if (huespedes.isEmpty()) {
                        System.out.println("No hay huéspedes registrados.");
                    } else {
                        for (Huesped h : huespedes) System.out.println(h);
                    }

                    esperarTecla();
                }
                case 3 -> {
                    return;
                }
                default -> System.err.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static void habitaciones() {
        int seleccion;

        while (true) {
            System.out.println("\n=== Gestión de Habitaciones ===");
            System.out.println("1. Listar Habitaciones");
            System.out.println("2. Listar Habitaciones Disponibles");
            System.out.println("3. Listar Habitaciones en Mantenimiento");
            System.out.println("4. Listar Habitaciones Ocupadas");
            System.out.println("5. Finalizar Mantenimiento");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            seleccion = sc.nextInt();
            sc.nextLine();

            if (seleccion == 6) {
                return;
            } else if (seleccion == 5) {
                System.out.print("\nIngrese el número de la habitación que ya está lista: ");
                int numHabitacion = sc.nextInt();
                sc.nextLine();

                boolean encontrada = false;
                for (Habitacion h : habitaciones) {
                    if (h.getNumero() == numHabitacion) {
                        encontrada = true;
                        if (h.getEstado() == EstadoHabitacion.MANTENIMIENTO) {
                            h.setEstado(EstadoHabitacion.DISPONIBLE);
                            System.out.println("¡Listo! La habitación " + numHabitacion + " vuelve a estar DISPONIBLE.");
                        } else {
                            System.out.println("Error: La habitación no está en mantenimiento. Su estado actual es: " + h.getEstado());
                        }
                    }
                }

                if (!encontrada) {
                    System.out.println("Error: No existe la habitación número " + numHabitacion);
                }

                esperarTecla();
                break;
            }

            boolean encontradas = false;

            for (Habitacion h : habitaciones) {
                if (seleccion == 1) {
                    System.out.println(h);
                    encontradas = true;
                } else if (seleccion == 2) {
                    if (h.getEstado() == EstadoHabitacion.DISPONIBLE) {
                        System.out.println(h);
                        encontradas = true;
                    }
                } else if (seleccion == 3) {
                    if (h.getEstado() == EstadoHabitacion.MANTENIMIENTO) {
                        System.out.println(h);
                        encontradas = true;
                    }
                } else if (seleccion == 4) {
                    if (h.getEstado() == EstadoHabitacion.OCUPADA) {
                        System.out.println(h);
                        encontradas = true;
                    }
                } else {
                    System.err.println("Opción no válida. Intente nuevamente.");
                    break;
                }
            }

            if (!encontradas) System.err.println("No se encontraron habitaciones en esta categoría.");

            esperarTecla();
        }
    }

    public static void reservas() {
        int seleccion;

        while (true) {
            System.out.println("\n=== Gestión de Reservas ===");
            System.out.println("1. Listar Reservas");
            System.out.println("2. Crear Reserva");
            System.out.println("3. Actualizar Estado de Reserva");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            seleccion = sc.nextInt();
            sc.nextLine();

            switch (seleccion) {
                case 1 -> listarReservas();
                case 2 -> {
                    System.out.println("\n--- Crear Nueva Reserva ---");
                    System.out.print("Ingrese el ID del Huesped: ");
                    String idHuesped = sc.nextLine();

                    Huesped huesped = null;
                    for (Huesped h : huespedes) {
                        if (h.getId().equals(idHuesped)) {
                            huesped = h;
                            break;
                        }
                    }

                    if (huesped == null) {
                        System.out.println("Error: Huesped no encontrado. Por favor, registre al huésped antes de crear la reserva.");
                        break;
                    }

                    System.out.print("Ingrese el número de la Habitación a reservar: ");
                    int numHabitacion = sc.nextInt();

                    Habitacion habitacionElegida = null;
                    for (Habitacion h : habitaciones) {
                        if (h.getNumero() == numHabitacion && h.getEstado() == EstadoHabitacion.DISPONIBLE) {
                            habitacionElegida = h;
                            break;
                        }
                    }

                    if (habitacionElegida == null) {
                        System.out.println("Error: La habitación no existe o no está disponible.");
                        break;
                    }

                    System.out.println("¿Para cuándo es la reserva?");
                    System.out.println("1. Para hoy (" + LocalDate.now() + ")");
                    System.out.println("2. Fecha futura (Programar)");
                    System.out.print("Seleccione: ");
                    int opcionFecha = sc.nextInt();
                    sc.nextLine();

                    LocalDate checkIn;
                    if (opcionFecha == 2) {
                        System.out.print("Ingrese año (YYYY): "); int anio = sc.nextInt();
                        System.out.print("Ingrese mes (1-12): "); int mes = sc.nextInt();
                        System.out.print("Ingrese día (1-31): "); int dia = sc.nextInt();
                        sc.nextLine();
                        checkIn = LocalDate.of(anio, mes, dia);

                        if (checkIn.isBefore(LocalDate.now())) {
                            System.err.println("Error: No puede programar una reserva para una fecha pasada.");
                            break;
                        }
                    } else {
                        checkIn = LocalDate.now();
                    }

                    System.out.print("¿Cuántas noches se hospedará?: ");
                    int noches = sc.nextInt();

                    if (noches <= 0) {
                        System.err.println("Error: El número de noches debe ser mayor a cero.");
                        break;
                    }

                    LocalDate checkOut = checkIn.plusDays(noches);
                    int idReserva = reservas.size() + 1;

                    Reserva nuevaReserva = new Reserva(idReserva, huesped, habitacionElegida, checkIn, checkOut);

                    nuevaReserva.realizarReserva();

                    reservas.add(nuevaReserva);
                    System.out.println("¡Reserva #" + idReserva + " creada exitosamente!");

                    sc.nextLine();
                    esperarTecla();
                }
                case 3 -> {
                    System.out.println("\n--- Actualizar Reserva ---");
                    System.out.print("Ingrese el ID de la reserva a modificar: ");
                    int idRes = sc.nextInt();
                    sc.nextLine();

                    Reserva reservaEncontrada = null;
                    for (Reserva r : reservas) {
                        if (r.getId() == idRes) {
                            reservaEncontrada = r;
                            break;
                        }
                    }

                    if (reservaEncontrada == null) {
                        System.out.println("Error: Reserva no encontrada.");
                        break;
                    }
                    var estado = reservaEncontrada.getEstado();

                    if (estado == EstadoReserva.FINALIZADA || estado == EstadoReserva.CANCELADA) {
                        System.err.println("Error: No se pueden modificar reservas que ya han sido finalizadas o canceladas.");
                        esperarTecla();
                        break;
                    }

                    System.out.println("Reserva actual: Estado -> " + reservaEncontrada.getEstado());
                    if (estado == EstadoReserva.PENDIENTE) {
                        System.out.println("1. Confirmar Pago");
                        System.out.println("2. Cancelar Reserva");
                    }
                    if (estado == EstadoReserva.CONFIRMADA) System.out.println("3. Finalizar (Check-out)");
                    System.out.print("Elija la acción: ");
                    int accion = sc.nextInt();
                    sc.nextLine();

                    if (estado == EstadoReserva.PENDIENTE) {
                        if (accion == 1) {
                            reservaEncontrada.confirmarReserva();
                            System.out.println("¡Éxito! El pago ha sido confirmado.");
                        } else  if (accion == 2) {
                            reservaEncontrada.cancelarReserva();
                            System.out.println("¡Reserva cancelada correctamente!");
                        }
                    } else if (accion == 3) {
                        if (estado == EstadoReserva.CONFIRMADA ) {
                            reservaEncontrada.finalizarReserva();
                            System.out.println("¡Check-out realizado con éxito! Habitación liberada.");
                        }
                    }

                    esperarTecla();
                }
                case 4 -> {
                    return;
                }
                default -> System.err.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static void listarReservas() {
        int seleccion;
        while (true) {
            System.out.println("\n=== Listar Reservas ===");
            System.out.println("1. Todas las Reservas");
            System.out.println("2. Reservas Pendientes");
            System.out.println("3. Reservas Confirmadas");
            System.out.println("4. Reservas Canceladas");
            System.out.println("5. Reservas Finalizadas");
            System.out.println("6. Volver");
            System.out.print("Seleccione una opción: ");
            seleccion = sc.nextInt();
            sc.nextLine();

            if (seleccion == 6) return;

            System.out.println("\n--- Resultados ---");
            boolean encontradas = false;

            for (Reserva r : reservas) {
                if (seleccion == 1) {
                    System.out.println(r);
                    encontradas = true;
                } else if (seleccion == 2 && r.getEstado() == EstadoReserva.PENDIENTE) {
                    System.out.println(r);
                    encontradas = true;
                } else if (seleccion == 3 && r.getEstado() == EstadoReserva.CONFIRMADA) {
                    System.out.println(r);
                    encontradas = true;
                } else if (seleccion == 4 && r.getEstado() == EstadoReserva.CANCELADA) {
                    System.out.println(r);
                    encontradas = true;
                } else if (seleccion == 5 && r.getEstado() == EstadoReserva.FINALIZADA) {
                    System.out.println(r);
                    encontradas = true;
                }
            }

            if (!encontradas) {
                System.out.println("No se encontraron reservas en esta categoría.");
            }

            esperarTecla();
        }
    }
}