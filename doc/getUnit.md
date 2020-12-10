# Obtener unidad por id
Muestra todas las unidades creadas, junto con el modelo del auto, la lista de adicionales que incluye y su precio.

**URL** : `/unit/{unidId}`

**Parámetros** : `unitId` es el id de la unidad a recuperar.

**Método** : `GET`

**Ejemplo obteniendo unidad con unitId = 1:**
```json
{
  "unitID": 1,
  "auto": {
    "name": "Familiar",
    "price": 245000,
    "autoId": 2
  },
  "additionalList": [
    {
      "additionalID": 3,
      "name": "Sistemas de frenos ABS",
      "price": 14000
    },
    {
      "additionalID": 4,
      "name": "Airbag",
      "price": 7000
    }
  ],
  "price": 266000
}
