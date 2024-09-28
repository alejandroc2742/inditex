# 📣Aplicacion de Precios - Inditex📣

Este proyecto es una API desarrollada en Spring Boot 3 con Java 17, que ofrece un servicio para obtener el precio de un producto en funcion de la fecha de aplicacion, la marca y el producto.

## Caracteristicas principales🔆

### Arquitectura Hexagonal (Ports and Adapters):🗼

El proyecto sigue una arquitectura hexagonal, donde las distintas capas estan separadas y desacopladas. Las capas principales son:

-   Los servicios se encuentran en el paquete com.inditex.prices.application.service
-   Los controladores REST estan ubicados en el paquete com.inditex.prices.infrastructure.adapter.in.rest
-   Las entidades que interactuan con la base de datos estan en el paquete com.inditex.prices.infrastructure.adapter.out.persistence.entity

### Validacion con ArchUnit:🔎

ArchUnit es una biblioteca para validar la arquitectura de aplicaciones Java. Se han implementado pruebas con ArchUnit para asegurar el cumplimiento de reglas arquitectonicas, tales como:

-   **servicesShouldResideInServicePackage**: Este método valida que todas las clases de servicio deben residir en el paquete  `..service..`. Garantiza que los servicios estén correctamente organizados dentro de su capa específica.
    
-   **repositoriesShouldResideInRepositoryPackage**: Este método asegura que todas las clases relacionadas con repositorios estén ubicadas en el paquete  `..repository..`, manteniendo la consistencia en la estructura de persistencia de datos.
    
-   **mappersShouldResideInMapperPackage**: Este método verifica que todas las clases de mapeo (mappers) se encuentren en el paquete  `..mapper..`. Adicionalmente, valida que los mappers sean interfaces y estén anotados con  `@Mapper`  de MapStruct.
    

### Patron Builder:🗿

Se ha implementado el Patron Builder en las clases de dominio e infraestructura para garantizar la creacion controlada de instancias.

-   El modelo de dominio (Price) fue desarrollado manualmente, evitando dependencias de frameworks externos.
-   El modelo de infraestructura (PriceEntity) emplea Lombok para simplificar su construccion.

### Cobertura de codigo:📈

El proyecto cuenta con una cobertura de pruebas superior al 90%, lo que garantiza la calidad del codigo y la funcionalidad de los servicios ofrecidos. Los informes de JaCoCo se encuentran en la ruta target/site/index.html.

### Spring Boot Actuator:📤

Se ha integrado Spring Boot Actuator para proporcionar monitoreo y gestion. Actuator permite verificar la salud de la aplicacion, acceder a metricas y obtener informacion del entorno, facilitando el mantenimiento y la optimizacion del servicio.

### Swagger UI:🔨

Se ha integrado Swagger UI para facilitar la interacción con otros equipos de desarrollo y para documentar los endpoints REST de la API. Swagger UI es accesible en la ruta  `/swagger-ui.html`  una vez que la aplicación está en ejecución.

El contrato de la API se encuentra almacenado en  `/infrastructure/src/main/resources/api.yaml`, desde el cual se generan tanto la interfaz del controlador como lo DTO (Data Transfer Object) que se devuelve al usuario.

### Formato de fechas:⌛️

Los endpoints que reciben fechas como parametro utilizan el formato ISO 8601 (yyyy-MM-dd’T’HH:mm

). Este formato es soportado automaticamente por Spring, facilitando el uso de la API.

### MapStruct:➿

Se utilizo MapStruct para facilitar el mapeo de objetos en Java al generar automaticamente el codigo en tiempo de compilacion. Esto reduce la necesidad de conversiones manuales, ahorra tiempo y mejora el rendimiento al evitar el uso de reflexion.

### Dockerizacion:⚓️

El proyecto incluye un Dockerfile para empaquetar y desplegar la aplicacion facilmente en cualquier entorno compatible con Docker.

#### Instrucciones para construir y ejecutar el contenedor Docker:⚓️

-   Construir la imagen: 

> docker build -t inditex-prices-app .

-   Ejecutar la aplicacion: 

> docker run -p 8080:8080 inditex-prices-app

-   La aplicacion estara disponible en:  

> [http://localhost:8080/prices](http://localhost:8080/prices)

### Patrones de diseño:🏁

Se ha empleado el patron Builder tanto para el modelo de dominio como para el de infraestructura:

-   El modelo de dominio fue implementado manualmente para tener un mayor control sobre su diseno.
-   El modelo de infraestructura fue desarrollado utilizando Lombok, lo que permite simplificar el codigo y reducir la cantidad de codigo repetitivo.

### Colecciones de Postman:▶️

Se han añadido colecciones de Postman para facilitar las pruebas del servicio. Las colecciones se encuentran en la ruta: src/main/resources/postman/prices_collection.json

#### Como importar la coleccion a Postman:

-   Abrir Postman.
-   Hacer clic en el boton “Import” en la esquina superior izquierda.
-   Seleccionar la pestaña “File” y elegir el fichero prices_collection.json.
-   Hacer clic en “Import” para cargar la coleccion. Una vez importada, se podran realizar las pruebas definidas en la coleccion.

### Licencia:🍻

Este proyecto esta bajo la Licencia GPL.