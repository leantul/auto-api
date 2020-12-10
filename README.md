# auto-api :car:
API REST que permite crear, modificar, eliminar y listar automóviles de una fábrica para todos sus modelos y variantes.

## Host API :computer:
* https://api-auto.herokuapp.com/

## Documentación 📄
* [Swagger-ui](https://swagger.io/) - https://api-auto.herokuapp.com/swagger-ui.html

### Unidades

* [Listar unidades](doc/listUnits.md) : `GET /unit/`
* [Crear unidad](doc/createUnits.md) : `POST /unit/`
* [Obtener una unidad](doc/getUnit.md) : `GET /unit/{unitId}/`
* [Actualizar una unidad](doc/updateUnit.md) : `PUT /unit/{unitId}/`
* [Eliminar una unidad](doc/deleteUnit.md) : `DELETE /unit/{unitId}/`

### Autos

* [Listar autos](doc/listAutos.md) : `GET /auto/`
* [Obtener un auto](doc/getUnit.md) : `GET /auto/{autoId}/`

### Adicionales

* [Listar adicionales](doc/listAdditional.md) : `GET /additional/`
* [Obtener un adicional](doc/getAdditional.md) : `GET /additional/{additionalId}/`

### Estadísticas

* [Obtener estadísticas](doc/getStats.md) : `GET /stats/`

## Construido con 🛠️

* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Spring](https://spring.io/) - Spring Framework
* [Swagger](https://swagger.io/) - Documentación
* [Heroku](https://heroku.com/) - Plataforma cloud
* [JUnit](https://junit.org/) - Tests
* [MySQL](https://www.mysql.com/) - Base de datos
