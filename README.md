   
## **Proyecto Operación Fuego de Quásar**

Este proyecto es una aplicación en Java que resuelve el desafío de la Operación Fuego de Quásar. La aplicación permite determinar la ubicación y el mensaje de auxilio de una nave a partir de la información recibida en diferentes satélites. Se utiliza Spring Boot como framework de desarrollo y MongoDB como base de datos para almacenar la información.


<p align="center">
  <img src="https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/a1558f69d68788a5236e7d8ff412960f38bc0695dfecd04b.png" alt="Descripción de la imagen">
</p>



## **Uso:**

Esta aplicación se encuentra desplegada en una instancia de oracle compute, para probar cada endpoint desde cualquier parte, simplemente accede a la URL de Swagger que se menciona posteriormente y utiliza la interfaz de Swagger para interactuar con los diferentes endpoints de la aplicación Operación Fuego de Quásar. Desde allí, podrás realizar pruebas, enviar solicitudes y recibir respuestas según la funcionalidad proporcionada por cada endpoint.

La disponibilidad y accesibilidad de la aplicación y las herramientas dependen del estado y la configuración de la instancia de Oracle Compute en Oracle Cloud.

## **Swagger:**

*   [http://129.151.117.132:8080/swagger-ui/index.html#/](http://129.151.117.132:8080/swagger-ui/index.html#/)

Al acceder a esta URL, se abrirá la interfaz de Swagger, que proporciona una documentación detallada de los endpoints disponibles en la aplicación Operación Fuego de Quásar. Desde Swagger, se pueden probar los endpoints y ver su descripción, parámetros y respuestas.

## **Mongo-express:**

*   [http://129.151.117.132:8081/db/quasar/](http://129.151.117.132:8081/db/quasar/)
    *   _**user:**_ ui-root
    *   _**password:**_ ui-password

Al acceder a esta URL, se abrirá la interfaz de Mongo Express para la base de datos "quasar" en MongoDB. Desde Mongo Express, se pueden administrar y visualizar los datos almacenados en la base de datos.

## **Ejecución entorno local**

### **Requisitos:**

Asegúrate de tener los siguientes requisitos antes de ejecutar el proyecto en entorno local:

Java 11 o superior

Docker y Docker Compose

Puertos 8081, 9500, 27017

### **Proceso:**

*   Clona el repositorio a tu máquina local

```plaintext
git clone https://github.com/tu-usuario/quasar-fire-operation.git
```

*   Ingresa al directorio del proyecto

```plaintext
cd quasar-fire-operation
```

*   Accede a la carpet **docker** y levanta los contenedores de mongo y mongo-express

```plaintext
docker-compose up -d mongo mongo-express
```

*   Construye el archivo JAR:

```plaintext
./mvnw clean package
```

*   Una vez que hayas construido el archivo JAR, puedes ejecutar la API localmente utilizando el siguiente comando:

```plaintext
java -jar target/quasar-fire-operation.jar
```

## **API**

La API Quasar Fire Operation proporciona los siguientes endpoints:

### **Obtener la posición y el mensaje secreto**

*   Método: **POST**
*   Ruta: **/api/v1/quasar/topsecret**
*   Descripción: Este servicio permite obtener la posición y el mensaje secreto de la nave.
*   Parámetros de entrada:
    *   Cuerpo (application/json):

```plaintext
{
  "satellites": [
    {
      "name": "kenobi",
      "distance": 100.0,
      "message": ["este", "", "", "mensaje", ""]
    },
    {
      "name": "skywalker",
      "distance": 115.5,
      "message": ["", "es", "", "", "secreto"]
    },
    {
      "name": "sato",
      "distance": 142.7,
      "message": ["este", "", "un", "", ""]
    }
  ]
}
```

### **Actualizar la distancia y el mensaje de un satélite específico.**

*   Método: **POST**
*   Ruta: **/api/v1/quasar/topsecret\_split/{satelliteName}**
*   Descripción: Permite actualizar la distancia y el mensaje de un satélite específico.
*   Parámetros de entrada:
    *   Cuerpo (application/json):

```plaintext

{
  "distance": 100.0,
  "message": ["este", "", "", "mensaje", ""]
}
```

### **Obtener la posición y el mensaje secreto previamente registrados.**

*   Método: **GET**
*   Ruta: **/api/v1/quasar/topsecret\_split**
*   Descripción:  Permite obtener la posición y el mensaje secreto a partir de la información previamente registrada de los satélites.

## **Pruebas**

El proyecto incluye pruebas unitarias utilizando JUnit 5 y Mockito. Para ejecutar las pruebas, puedes utilizar el siguiente comando:

```plaintext
./mvnw test
```

## **Diagramas**

<br>
<p align="center">
  <img src="https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/8341e74581d1b11946b7b93da60c2b6493f5ab110c22e22f.png" alt="Descripción de la imagen">
</p>

<p align="center">
  <img src="https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/3c5d8fba7e8418c71dc91ef35de36f2354a6c46bfb1d378a.png" alt="Descripción de la imagen">
</p>

<p align="center">
  <img src="https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/0e4631f2a62f971d2ef6386e88ad625ba1a9af23a3f540a7.png" alt="Descripción de la imagen">
</p>

<p align="center">
  <img src="https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/5c03523e2fb47384a83d985d88f15033e6539001a1ca53e0.png" alt="Descripción de la imagen">
</p>

<p align="center">
  <img src="https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/1c0dc8b08478422e607aecfabd2093196113676a78ae90fb.png" alt="Descripción de la imagen">
</p>

<p align="center">
  <img src="https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/956702c2366513625f364e05b66556ac47af7e54da18a4f6.png" alt="Descripción de la imagen">
</p>

<p align="center">
  <img src="https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/229204429d1554b54a74fcb28d95f73cb9179708e76b31a4.png" alt="Descripción de la imagen">
</p>


## **Arquitectura:**

La arquitectura del proyecto de Operación Fuego de Quásar sigue un enfoque basado en microservicios. Está compuesta por los siguientes componentes:

**Microservicio principal**: Este microservicio es responsable de recibir las solicitudes HTTP, procesar la información y devolver la posición de la nave y el mensaje decodificado. Está implementado en Java utilizando el framework Spring Boot.

**Base de datos MongoDB**: Se utiliza una base de datos MongoDB para almacenar la información de los satélites y sus mensajes. El microservicio interactúa con la base de datos para almacenar y recuperar la información necesaria.

**Mongo Express**: Es una interfaz de usuario web que permite visualizar y administrar la base de datos MongoDB de manera sencilla. Se utiliza para facilitar la verificación y manipulación de los datos almacenados.

La comunicación entre los componentes se realiza a través de solicitudes HTTP utilizando el protocolo RESTful. El microservicio principal expone endpoints para recibir las solicitudes POST y GET, y se encarga de procesar los datos utilizando algoritmos específicos para determinar la posición y el mensaje. La información necesaria para realizar estos cálculos se almacena y recupera de la base de datos MongoDB.

El proyecto también incluye pruebas unitarias para garantizar la calidad y el correcto funcionamiento del código. Estas pruebas se ejecutan utilizando JUnit 5 y Mockito, y se centran en verificar el comportamiento esperado de los diferentes componentes.

Además, se utiliza Docker y Docker Compose para facilitar la ejecución del proyecto en diferentes entornos y simplificar la configuración de los servicios necesarios, como la base de datos MongoDB y Mongo Express.

Esta arquitectura modular y basada en microservicios permite una mayor flexibilidad, escalabilidad y mantenibilidad del proyecto. Cada componente tiene responsabilidades específicas y puede ser desarrollado, probado y desplegado de manera independiente, lo que facilita la evolución y la gestión del sistema en su conjunto.

## **Conclusiones:**

Este proyecto puede servir como base para la implementación de sistemas más complejos de rastreo de naves espaciales o comunicaciones en tiempo real. Se pueden realizar mejoras adicionales, como la autenticación y autorización de la API, la implementación de un mecanismo de persistencia más robusto o la integración con otros sistemas.