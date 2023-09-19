# **Final Laboratorio III**

El objetivo de este trabajo final es la implementación de un conjunto de API’s REST en la
plataforma Java, utilizando el framework Spring Boot que vimos durante el cursado de la
materia.

## Servicios expuestos:
### Product:
* POST /products --> Crar producto
* GET /products --> Retornar todos los productos
* GET /products/id --> Retornar producto segun id
* GET /products/filter?categoria=""&marca=""&tipo_producto="" --> Retornar producto filtrando por categoria y/o marca y/o tipo producto
* PUT /products/id --> Modificar producto
* DELETE /products/id --> Eliminar producto


### Category:
* POST /categories --> Crear categoria
* GET /categories --> Retornar todas las categorias
* GET /categories/id --> Retornar categoria según id
* GET /categories/order/1AC731?order_by="asc" (o "desc") --> Retornar producto de una categoria ordenando por precio ascendente o descendente
* PUT /categories/id --> Modificar categoria
* DELETE /categories/id --> Eliminar categoria


###Documentación publica POSTMAN
##https://documenter.getpostman.com/view/18076612/2s9YC8wr4Y
