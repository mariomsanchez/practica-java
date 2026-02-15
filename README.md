# Prueba Técnica: Microservicio de consulta de estado del equipaje

## Descripción del Problema

Debes construir un microservicio en **Spring Boot** que gestione la información y el estado del equipaje facturado de los pasajeros de los vuelos. El sistema se basa en una hipotética (irreal) nueva tecnología de etiquetas con sensores que permiten conocer el estado (ubicación) de cada bulto en tiempo real desde su facturación hasta su recogida.

Se usará "bulto" o "equipaje" como sinónimos, para referirnos a cada unidad facturada. Por ejemplo, un mismo pasajero puede facturar más de un bulto o equipaje, pero cada uno tendrá un código distinto.

Este servicio será la **fuente de verdad** (*source of truth*) para diversos sistemas consumidores, como las aplicaciones del personal de tierra, la app de seguimiento para pasajeros y los sistemas de reclamación de equipaje.

Para el diseño del servicio, considera que en un despliegue en producción se ejecutaría en **Amazon ECS**, utilizando **API Gateway** y **Amazon Aurora (PostgreSQL)**. Sin embargo, para esta prueba, utilizarás una base de datos en memoria.

## Requisitos Funcionales

Tu API REST debe permitir las siguientes operaciones:

1.  Registrar un bulto de equipaje en el sistema, que será llamado al ponerle la etiqueta en el mostrador de facturación. Deberá estar asociado a un vuelo y un pasajero pero **NO** necesitas gestionar las entidades para vuelos y pasajeros, basta con que definas un código único para cada una de ellos.
2.  Obtener la información de un equipaje específico por su identificador.
3.  Actualizar el estado de un equipaje (por ejemplo, si está en la bodega, o en la cinta 4 del aeropuerto destino).
4.  Filtrar equipajes por diferentes criterios: al menos se podrán filtrar por identificador de pasajero o de vuelo, por rango de fecha/hora de facturación, y por estado.

**(Opcional / Extra) Definición de Tarea para Despliegue en AWS:** Como un extra muy valorado, se pide la creación de una Task Definition de Amazon ECS. Crea un fichero en formato JSON que describa cómo se ejecutaría este microservicio en AWS. No es necesario que sea funcional, sino que demuestre tu comprensión de los conceptos.

## Requerimientos Adicionales

-   **Lógica de Negocio**: Tu servicio debe validar, como mínimo, las siguientes reglas. Si identificas otras reglas lógicas para este dominio, siéntete libre de añadirlas y documentarlas:
    -   Valida que la fecha de facturación sea correcta (según tus criterios)
    -   Que la fecha de recogida del equipaje por parte de su propietario sea posterior a la de facturación.
    -   Que un pasajero no pueda tener más de 3 bultos de equipaje facturados al mismo tiempo.

-   **Libertad de Diseño**: Tienes total libertad para definir el modelo de datos, sus atributos, los posibles estados, así como la estructura de paquetes y el nombramiento de clases. Recuerda que sólo debes contemplar la gestión de la entidad maleta, sin relación con los vuelos o los pasajeros.

-   **Base de Datos**: El proyecto debe usar una base de datos en memoria **H2** para facilitar la corrección de la prueba.

-   **Arquitectura**: La solución debe seguir una **arquitectura en capas** bien definida.

-   **Testing**: Se valorará muy positivamente la inclusión de tests que validen la lógica de negocio.

-   **Documentación**: Añade al archivo NOTAS.md las decisiones de diseño que has tomado, las asunciones realizadas y cómo ejecutar tu proyecto.

-   **Versiones**: Puedes usar la versión de Java y de Spring que prefieras, defínelas en el pom.xml.

## Pasos para Empezar

Para comenzar a trabajar, sigue estas instrucciones. Primero, **acepta la invitación** que has debido recibir por correo electrónico para tener acceso de escritura en este repositorio.

**1. Clona el Repositorio**

Una vez aceptada la invitación, clona el repositorio en tu máquina local.

```bash
git clone https://github.com/URL-DEL-REPOSITORIO/nombre-del-repositorio.git
```

**2. Entra en el Directorio del Proyecto**

Navega hasta la carpeta que acabas de crear.

```bash
cd nombre-del-repositorio
```

**3. Crea tu Rama de Trabajo**

Es **muy importante** que no trabajes directamente sobre la rama `main`. Crea una nueva rama para desarrollar tu solución de manera iterativa.

```bash
git checkout -b nombre-rama
```

Ya puedes abrir el proyecto en tu IDE favorito y empezar a trabajar en tu rama. Recuerda hacer `commits` pequeños y frecuentes para que podamos ver tu progreso.

## Criterios de Evaluación

Se evaluará:

* **Claridad y calidad** del código.
* **Diseño de la arquitectura** y separación de responsabilidades.
* Correcta implementación de la **lógica de negocio**.
* **Historial de commits**: Se valorará positivamente un desarrollo iterativo, reflejado en un historial de git con commits pequeños e incrementales que muestren tu proceso de trabajo. Se evaluará negativamente la entrega de la solución en un único commit.
* Calidad de los **tests**.
* Claridad de la **documentación** en el fichero `NOTAS.md`.
* **Toma de decisiones**: Es posible que tengas dudas de cómo diseñar la solución, o de alguna funcionalidad en concreto. Se valorará que seas proactivo/a y documentes en el fichero de `NOTAS.md` esas decisiones y asunciones que tomes.

## Entrega

Ve _pusheando_ el progreso a medida que vayas desarrollando. No pasa nada si son soluciones parciales, nos gustará ver cómo te fuiste aproximando a la solución. 

Un vez termines, o si te quedas sin tiempo, deja puesto un pull request de tu rama contra la rama `main` con lo que lleves.

¡Mucha suerte!
