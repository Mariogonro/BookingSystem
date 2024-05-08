## Proyecto Integrador: configuración inicial Booking System REST API.

Para esta primera parte se siguieron los siguientes pasos:

- Crear un repositorio en Github para tu proyecto.
- Crear un proyecto base utilizando Spring Initializr con las siguientes características:
- Maven Project.
- Language Java.
- Última versión de Spring Boot predeterminada.
- Java Versión 21.
- Agregar en la parte derecha la dependencia de Spring Web.

Crea un nuevo paquete llamado controller.health y adentro crea la clase HealthController con el siguiente código:

- Se realiza el primer commit con el código de tu proyecto a tu repositorio.
- Se ejecuta la aplicación en tu dispositivo y verifica que funciona correctamente accediendo el siguiente endpoint:
- http://localhost:8080/health

## Proyecto Integrador: Implementa el controlador y servicio de tu API REST.

Se define la interfaz del servicio y crea una implementación utilizando un HashMap para realizar las operaciones CRUD sobre los usuarios:

- Create
- Read
- Update
- Delete

Se configura la implementación del Servicio de Usuarios para que sea inyectable con @Service

Se implementa el Controlador de Usuarios inyectando el servicio de usuarios y manejando los diferentes métodos requeridos para implementar el CRUD:

- GET
- POST
- PUT
- DELETE

Se ejecuta tu proyecto y utiliza Postman para verificar el correcto funcionamiento de los respectivos Endpoints.

