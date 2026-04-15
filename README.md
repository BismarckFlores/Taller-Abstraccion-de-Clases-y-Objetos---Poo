# 🧩 Taller | Abstracción de Clases y Objetos

## 1. Problema Propuesto

Un hotel boutique necesita modernizar su sistema para administrar las reservas de sus instalaciones. El software debe permitir registrar la información detallada de los **huéspedes** (como su documento de identidad, nombre completo y correo electrónico).

El hotel cuenta con varias **habitaciones**, de las cuales es vital conocer su número, el tipo de habitación (individual, doble, suite), el precio por noche y su estado actual (disponible, ocupada o en mantenimiento).

Cuando un cliente desea hospedarse, el sistema debe generar una **reserva**. Esta reserva debe registrar la fecha de entrada (*check-in*), la fecha de salida (*check-out*), enlazar la habitación asignada al huésped y calcular automáticamente el costo total de la estadía. Además, el sistema debe permitir que la reserva cambie de estado a lo largo del tiempo (por ejemplo: pendiente, confirmada o cancelada).

## 2. Análisis del Problema

A partir del problema propuesto, se extraen las siguientes reglas de negocio que guiarán el diseño y el modelado orientado a objetos:

* **Gestión de Identidad:** Es importante rastrear a los huéspedes mediante identificadores únicos e información de contacto para futuras interacciones.
* **Control de Inventario y Estados:** Se debe administrar el catálogo de habitaciones, teniendo en cuenta que su disponibilidad es cambiante. El estado de la habitación dictará si puede ser asignada para una futura estadía para evitar sobreventas.
* **Lógica Transaccional:** El sistema debe gestionar las reservas, garantizando la correcta vinculación temporal entre un huésped y una habitación. Además, la reserva encapsula la lógica para calcular el costo total de la tarifa de la habitación por los días de estadía.

## 3. Contexto y Elementos Clave
* **Contexto:** Gestión hotelera, control de inventario de espacios físicos y atención al cliente.
* **Elementos clave:**
  * Las personas que solicitan el alojamiento (**Huéspedes**).
  * Los recursos físicos y limitados que se alquilan (**Habitaciones**).
  * El proceso transaccional que separa una habitación por un tiempo determinado bajo ciertas condiciones (**Reservas**).

## 4. Clases y Enumeradores Identificados
Para mantener la integridad de los datos y evitar errores tipográficos, se definen 3 clases principales y 3 estructuras de enumeración (`Enum`).

### Enumeradores (`<<enumeration>>`)
* `TipoHabitacion`: INDIVIDUAL, DOBLE, SUITE
* `EstadoHabitacion`: DISPONIBLE, OCUPADA, MANTENIMIENTO
* `EstadoReserva`: PENDIENTE, CONFIRMADA, CANCELADA, FINALIZADA

### Detalle de Clases (Atributos y Métodos)

| Paquete        | Clase          | Atributos (Variables)                                                                                                                                                                 | Métodos (Comportamientos)                                                                                                                                      |
|:---------------|:---------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **`modelo`** | **Huesped** | `- id: String`<br>`- nombreCompleto: String`<br>`- email: String`                                                                                                                      | *(Sin métodos, solo constructor y getters/setters)* |
| **`modelo`** | **Habitacion** | `- numero: Integer`<br>`- tipo: TipoHabitacion`<br>`- precioPorNoche: Double`<br>`- estado: EstadoHabitacion`                                                                         | *(Sin métodos, solo constructor y getters/setters)* |
| **`servicio`** | **Reserva** | `- id: Integer`<br>`- huesped: Huesped`<br>`- habitacion: Habitacion`<br>`- fechaCheckIn: LocalDate`<br>`- fechaCheckOut: LocalDate`<br>`- estado: EstadoReserva`<br>`- costoTotal: Double` | `+ realizarReserva(): void`<br>`+ cancelarReserva(): void`<br>`+ confirmarReserva(): void`<br>`+ finalizarReserva(): void`<br>`- calcularCostoTotal(): double` |

## 5. Relaciones entre las clases
* Un **Huesped** *realiza* cero, una o múltiples **Reservas** (Asociación `1` a `0..*`).
* Una **Reserva** *involucra* a una única **Habitacion** (Asociación `1` a `1`).

---
## 📂 Archivo del Modelo

[👉 Diagrama en Enterprise Architect](./Taller_Abstraccion.eap)

## 📂 Código Fuente

[👉 Código Fuente en Java](./Taller_Abstraccion/src/com/hotel/main/Main.java)