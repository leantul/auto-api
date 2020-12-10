# Listar unidades
Muestra todas las unidades creadas, junto con el modelo del auto, la lista de adicionales que incluye y su precio.

**URL** : `/unit`

**Parámetros** : `Ninguno`

**Método** : `GET`

**Ejemplo:**
```json
[
  {
    "unitID": 1,
    "auto": {
      "name": "Familiar",
      "price": 245000.00,
      "autoId": 2
    },
    "additionalList": [
      {
        "additionalID": 3,
        "name": "Sistemas de frenos ABS",
        "price": 14000.00
      },
      {
        "additionalID": 4,
        "name": "Airbag",
        "price": 7000.00
      }
    ],
    "price": 266000.00
  },
  {
    "unitID": 2,
    "auto": {
      "name": "Sedán",
      "price": 230000.00,
      "autoId": 1
    },
    "additionalList": [
      {
        "additionalID": 3,
        "name": "Sistemas de frenos ABS",
        "price": 14000.00
      },
      {
        "additionalID": 4,
        "name": "Airbag",
        "price": 7000.00
      },
      {
        "additionalID": 2,
        "name": "Aire Acondicionado",
        "price": 20000.00
      }
    ],
    "price": 271000.00
  }
]
```
