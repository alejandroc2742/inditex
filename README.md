# Aplicación de Precios - Inditex 📢
Este proyecto es una API desarrollada en Spring Boot 3 con Java 17, que ofrece un servicio para obtener el precio de un producto en función de la fecha de aplicación, la marca y el producto.

## Características principales 🚀
### Arquitectura Hexagonal (Ports and Adapters): 

El proyecto sigue una arquitectura hexagonal, donde las distintas capas están separadas y desacopladas.
- Los **servicios** se encuentran en el paquete **com.inditex.prices.application.service**
- Los **controladores** REST están ubicados en el paquete **com.inditex.prices.infrastructure.adapter.in.rest**
- Las **entidades** que interactúan con la base de datos están en el paquete **com.inditex.prices.infrastructure.adapter.out.persistence.entity**

### 🚀 Validación con ArchUnit: 🚀
ArchUnit es una biblioteca para validar la arquitectura de aplicaciones Java, permitiendo definir y verificar reglas sobre la estructura y las dependencias del código.
Para asegurar el cumplimiento de las reglas de arquitectura, se han implementado pruebas con ArchUnit, como:
- **servicesShouldNotDependOnControllers**: Garantiza que los servicios no dependan de los controladores.
- **controllersShouldDependOnServices:** Valida que los controladores dependan de los servicios, pero no al revés.
- **entitiesShouldBePublic**: Verifica que las entidades sean públicas.

- **servicesShouldBeAnnotatedWithService**
Este test verifica que todas las clases en el paquete com.inditex.prices cuyo nombre termina en "**Service**" estén anotadas con @Service.


### 🚀 Cobertura de código: 🚀

El proyecto cuenta con una cobertura de pruebas superior al 90%, lo que garantiza la calidad del código y la funcionalidad de los servicios ofrecidos.


### 🚀Spring Boot Actuator:🚀

Se ha integrado Spring Boot Actuator en la aplicación para proporcionar monitoreo y gestión. Actuator permite verificar la salud de la aplicación, acceder a métricas y obtener información del entorno, facilitando el mantenimiento y la optimización del servicio.


### 🚀Swagger UI:🚀

Se ha integrado Swagger UI para facilitar la interacción con otros equipos de desarrollo y la documentación de los endpoints REST.
Se puede acceder a Swagger UI en la ruta **/swagger-ui.html** cuando la aplicación esté en ejecución.
### 🚀Formato de fechas:🚀

Los endpoints que reciben fechas como parámetro utilizan el formato ISO 8601 (yyyy-MM-dd'T'HH:mm:ss). Este formato es soportado automáticamente por Spring, facilitando el uso de la API.

### 🚀MapStruct🚀 
Fue usado ya que facilita el mapeo de objetos en Java al generar automáticamente código en tiempo de compilación, eliminando la necesidad de escribir conversiones manuales. Esto ahorra tiempo, reduce errores y mejora el rendimiento al evitar el uso de reflexión.

### 🔩Dockerización🔩
Este proyecto incluye un Dockerfile que permite empaquetar y desplegar la aplicación fácilmente en cualquier entorno compatible con Docker.


#### Instrucciones para construir y ejecutar el contenedor Docker:

 - Crear el jar
 Ejecutar sobre la carpeta del proyecto:

> mvn clean install

 - Construir la imagen

> docker build -t inditex-prices-app .
 - Ejecutar la aplicación:
> docker run -p 8080:8080 inditex-prices-app
 - La aplicación estará disponible en 
> http://localhost:8080/prices
### 🔩Patrones de diseño🔩
Se ha empleado el patrón Builder tanto para el modelo de dominio como para el de infraestructura:

- El modelo de dominio fue implementado manualmente, evitando el uso de frameworks o librerías externas, para tener un mayor control sobre su diseño.

- El modelo de infraestructura fue desarrollado utilizando Lombok, lo que permite simplificar el código y reducir la cantidad de código repetitivo, facilitando su mantenimiento.

### 🔩Colecciones de Postman🔩

Se han añadido colecciones de Postman para facilitar las pruebas del servicio. Las colecciones se encuentran en la ruta:

    src/main/resources/postman/prices_collection.json


#### 🔩Cómo importar la colección a Postman🔩

- Abrir Postman.
- Hacer clic en el botón "Import" en la esquina superior izquierda.
- Seleccionar la pestaña "File" y elegir el fichero `prices_collection.json`.
- Hacer clic en "Import" para cargar la colección.

Una vez importada, se podrán realizar las pruebas definidas en la colección.

## Autor ✒️


* **Luis Alejandro Céspedes**  - [alejandroc2742](https://github.com/alejandroc2742/)

### Licencia
Este proyecto está bajo la Licencia GPL.
