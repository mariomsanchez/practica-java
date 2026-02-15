# NOTAS.md

## Commit: init project

- Inicialización del proyecto Spring Boot.
- Estructura base de carpetas según arquitectura DDD/hexagonal:
    - domain / application / adapters / config / exception
- Dependencias configuradas: Spring Boot, H2, JPA, Lombok, MapStruct, Validation, JUnit 5, Mockito.
- Aplicación mínima con `@SpringBootApplication` para verificar arranque.



## Commit: create baggage entity
- Se creó la entidad Baggage con los atributos: id, flightCode, passengerCode, checkInDate, collectionDate, status.
- Enum BaggageStatus con los estados: CHECKED_IN, IN_HOLD, IN_TRANSIT, ON_CAROUSEL, COLLECTED.
- Validaciones básicas: la fecha de check-in no puede ser nula, la fecha de recogida debe ser posterior al check-in.
- Método para actualizar el estado del equipaje.
- Pruebas unitarias para la creación de la entidad, validación de fechas y actualización de estado.