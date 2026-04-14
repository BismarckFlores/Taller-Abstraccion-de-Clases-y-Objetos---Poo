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

## 4. Clases Relevantes Identificadas (Para modelado en Enterprise Architect)
1. `Huesped`
2. `Habitacion`
3. `Reserva`

---
## 📂 Archivo del Modelo

[👉 Diagrama en Enterprise Architect](./Taller_Abstraccion.eap)

## 📂 Código Fuente

[👉 Código Fuente en Java](./Taller_Abstraccion/src)