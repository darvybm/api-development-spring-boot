**Título de la charla:**

# Creación de APIs REST con Spring Boot y MongoDB: Buenas Prácticas desde el Desarrollo hasta el Despliegue

<p align="center">
  <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white" alt="Java Badge" />
  <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Boot Badge" />
  <img src="https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white" alt="Spring Security Badge" />
  <img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white" alt="JWT Badge" />
  <img src="https://img.shields.io/badge/MongoDB-47A248?style=for-the-badge&logo=mongodb&logoColor=white" alt="MongoDB Badge" />
  <img src="https://img.shields.io/badge/REST%20API-005571?style=for-the-badge&logo=postman&logoColor=white" alt="REST API Badge" />
  <img src="https://img.shields.io/badge/ModelMapper-FF69B4?style=for-the-badge" alt="ModelMapper Badge" />
  <img src="https://img.shields.io/badge/Lombok-B71C1C?style=for-the-badge&logo=lombok&logoColor=white" alt="Lombok Badge" />
</p>


## 1. ¿Qué es una API, cómo funciona y para qué sirve?

Una **API (Application Programming Interface)** permite que diferentes aplicaciones se comuniquen entre sí mediante reglas definidas. En particular, una **API REST (Representational State Transfer)** es un tipo de API que usa HTTP para realizar operaciones como GET, POST, PUT y DELETE, permitiendo a los clientes interactuar con un servidor de manera rápida y estructurada. En este tutorial, vamos a crear una API REST para gestionar productos, usuarios y categorías.

![image](https://github.com/user-attachments/assets/5d1c6ade-17f7-4c57-80ee-66692e488c31)


### 2. ¿Qué es Spring/Spring Boot y cómo se va a utilizar?

**Spring** es un marco para desarrollar aplicaciones en Java que simplifica la creación de aplicaciones complejas. **Spring Boot** es una extensión que facilita el desarrollo al manejar gran parte de la configuración. En esta API, usaremos Spring Boot para configurar y desplegar rápidamente el servicio. Además, **Spring Security** se empleará para añadir seguridad mediante autenticación con **JWT (JSON Web Tokens)**, y **MongoDB** se utilizará como base de datos no relacional para almacenar la información de nuestros productos, usuarios y categorías.


### 3. Modelado de Datos para la API

Para esta API, modelaremos tres entidades:

- **User**: Representa a los usuarios del sistema, quienes podrán interactuar con la API mediante roles y autenticación.
- **Category**: Agrupa los productos en categorías específicas.
- **Product**: Almacena la información de los productos, como nombre, descripción, precio y cantidad en stock.

Cada entidad se relaciona y permite la organización lógica de los datos.

![image](https://github.com/user-attachments/assets/0d8e4ff4-63f7-4a17-9b65-ffd54ee7c105)


### 4. Primera Buena Práctica: Estructura de Carpetas

Organizar bien el código mejora la legibilidad y el mantenimiento. Seguiremos una estructura estandarizada:

- `config`: Archivos de configuración, como los relacionados con la seguridad o la base de datos.
- `controller`: Define los puntos de entrada de la API para que los usuarios realicen peticiones.
- `dto`: Define los objetos de transferencia de datos (**DTOs**) que gestionan las entradas y salidas de los datos.
- `exception`: Contiene clases para manejar las excepciones personalizadas.
- `model`: Representa las entidades o clases que modelan los datos de la API.
- `repository`: Interactúa con la base de datos.
- `service`: Define la lógica de negocio.
- `utils`: Funcionalidades de utilidad que pueden ser reutilizadas en diferentes partes de la aplicación.

**Convenciones de nombres**: Es recomendable mantener las carpetas en minúsculas y en singular para facilitar la navegación y consistencia. En Java, las clases y métodos deben seguir la convención CamelCase, lo cual mejora la claridad del código y hace que sea fácil de leer.

![image](https://github.com/user-attachments/assets/ed1604b8-445a-4c3f-97a4-f8a66303d65a)


### 5. Desarrollo de la API en Spring Boot

La API en Spring Boot se construye utilizando controladores y métodos HTTP:

- **Controlador**: Es el punto de entrada que procesa las solicitudes y las dirige a los servicios correspondientes.
- **Métodos HTTP**: 
  - `@GetMapping`: Para obtener datos.
  - `@PostMapping`: Para crear datos.
  - `@PutMapping`: Para actualizar datos.
  - `@DeleteMapping`: Para eliminar datos lógicamente en esta API.

Ejemplo básico de controlador:

```java
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    
    private final ProductService productService;
    private final CustResponseBuilder custResponseBuilder;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        List<ProductResponse> products = productService.getAll();
        return custResponseBuilder.ok(products);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse product = productService.save(productRequest);
        return custResponseBuilder.ok(product, "Product created successfully");
    }
}
```


### 6. Buena Práctica: Dividir los Servicios en Interfaces e Implementaciones

En lugar de implementar directamente la lógica de negocio en la clase de servicio, se define una **interfaz** para establecer los métodos que se van a implementar. Luego, se crea una **clase de implementación** para cada servicio:

```java
public interface ProductService {
    ProductResponse save(ProductRequest productRequest);
    ProductResponse getById(UUID id);
    List<ProductResponse> getAll();
    ProductResponse update(UUID id, ProductRequest productRequest);
    void delete(UUID id);
}
```

Esto hace que la lógica de negocio sea **más modular** y **fácil de probar**, ya que podemos usar múltiples implementaciones o simulaciones en los tests.



### 7. Segmentación en Capas

La API se divide en capas para hacer el código más mantenible:

- **Repositorio**: Maneja las consultas y la persistencia de datos.
- **Servicio**: Contiene la lógica de negocio y se comunica con el repositorio.
- **Controlador**: Expone los puntos de acceso de la API.

Esto facilita que cada capa se enfoque en una responsabilidad específica, promoviendo el principio de **separación de intereses**.



### 8. Uso de DTOs (Data Transfer Objects)

Para estructurar las solicitudes y respuestas, se utilizan **DTOs**, que encapsulan los datos y permiten controlar mejor lo que se envía y recibe a través de la API. En este caso:

- **ProductRequest**: Define los datos necesarios para crear o actualizar un producto.
- **ProductResponse**: Define los datos que se devolverán al cliente, excluyendo datos sensibles como `deleted`.

Esto asegura que solo los datos relevantes y seguros sean expuestos o procesados por la API.



### 9. Estandarización de las Respuestas

Se recomienda tener un formato de respuesta estandarizado. Por ejemplo, un `CustResponseBuilder` puede estandarizar los mensajes y el formato de las respuestas, facilitando la lectura y el uso de la API para los clientes:

```java
public class CustResponseBuilder {
    public ResponseEntity<?> ok(Object data) {
        return ResponseEntity.ok(new ApiResponse(true, data, null));
    }

    public ResponseEntity<?> ok(Object data, String message) {
        return ResponseEntity.ok(new ApiResponse(true, data, message));
    }
}
```



### 10. Uso Correcto de Métodos HTTP

El uso adecuado de métodos HTTP es esencial:

- **POST**: Para crear nuevos recursos.
- **PUT**: Para actualizar recursos existentes.
- **DELETE**: Para eliminación lógica.
  
Esto evita sobrecargar un método (por ejemplo, POST) con responsabilidades para las que no fue diseñado.



### 11. Uso de Lombok sin @Data

Para reducir el código repetitivo, usamos Lombok. Sin embargo, es mejor evitar `@Data`, que genera muchos métodos innecesarios y puede causar problemas de rendimiento. Es preferible usar solo las anotaciones necesarias, como `@Getter` y `@Setter`.

```java
@Getter
@Setter
public class Product {
    private UUID id;
    private String name;
    private String description;
    private Double price;
}
```


### 12. Manejo de Excepciones Personalizadas

Crear excepciones personalizadas permite manejar errores de forma controlada y enviar mensajes claros al cliente. Por ejemplo:

```java
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, String field, Object value) {
        super(String.format("%s not found with %s: '%s'", resource, field, value));
    }
}
```

Esto proporciona una **experiencia de usuario coherente** al interactuar con la API.



