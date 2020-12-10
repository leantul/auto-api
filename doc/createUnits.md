# Crear unidades
Crea las unidades basándose en el modelo del auto elegido y sus adicionales. Calcula y devuelve el precio de la unidad creada.

**URL** : `/unit`

**Método** : `POST`

**Ejemplo:**
```json
{
  "auto": {
    "autoId": 1
  	},
  "additionalList": [
      {
        "additionalID": 3			
      },
      {
        "additionalID": 4
      },
      {
        "additionalID": 2
      }
  ]
}
