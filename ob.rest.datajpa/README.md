## Spring Boot

Proyecto Spring Boot con las dependencias / starters:
Starters para persistencia:
* H2
* Spring Data JPA
Starters para web:
* Spring Web
* Spring Boot Dev tools

Aplicacion API REST con acceso a base de datos H2 para persistir la informacion.

El acceso se puede realizar desde Postman o Navegador.

## Entidad Book

1. Book
2. BookRepository
3. BookController
   1. Buscar todos los libros
   2. Buscar un solo libro
   3. Crear un nuevo libro
   4. Actualizar un libro existente
   5. Borrar un libro
   6. Borrar todos los libros



Anotaciones extra:
1. Siguiendo las indicaciones del tutorial de openbootcamp tuve problemas al incluir la libreria swagger al proyecto. Para solucionarlo segui las indicaciones de este post de stack overflow: ("https://stackoverflow.com/questions/70059018/swagger-2-issue-spring-boot") y este otro: ("https://stackoverflow.com/questions/72301571/swagger-error-springboot-could-not-resolve-view-with-name-forward-swagger-ui-i")