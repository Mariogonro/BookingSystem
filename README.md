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

## Proyecto Integrador: Implementar la capa de persistencia con Spring Data MongoDB.
Parte 1: Configuración y conexión con el cluster de MongoDB

1: Se crea el cluster de tu proyecto con la configuración requerida para poderte conectar desde tu proyecto de Spring Boot:
- Crear el cluster.
- Crear el usuario y contraseña con acceso al cluster.
- Agregar el acceso desde cualquier lugar al cluster.
  
2: Se agrega la dependencia de spring-boot-starter-data-mongodb a tu pom.xml

3: Agrega la variable de entorno a tu proyecto para la configuración la URI de conexión de MongoDB.

4: Ejecuta tu aplicación y verifica la conexión con tu cluster de MongoDB.

Parte 2: Implementando tus documentos y repositorios para almacenar tus datos en MongoDB

- Se implementa la clase Document del modelo que quieres almacenar en tu base de datos con sus respectivos atributos.
- Se crea la respectiva Interfaz del Repositorio para el documento creado en 1.
- Se implementa la interfaz y el servicio para realizar las operaciones CRUD sobre el modelo almacenado en la base de datos.
- Se agrega la anotación @Service a el controlador respectivo e implementa la lógica para utilizar el servicio que te permite almacenar y consultar los datos desde el cluster de MongoDB.
- Se ejecuta tu proyecto y utiliza Postman para verificar el correcto funcionamiento de los respectivos Endpoints y verifica que la información sea almacenada en MongoDB Atlas.

