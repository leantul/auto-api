# Obtener estadísticas
Devuelve un Json con las estadísticas de la cantidad de automóviles y las distintas características:

**URL** : `/stats`

**Parámetros** : `Ninguno`

**Método** : `GET`

**Ejemplo:**
```json
{
  "cars": [
    {
      "model": "Familiar",
      "count": 1,
      "percent": 50.0
    },
    {
      "model": "Sedán",
      "count": 1,
      "percent": 50.0
    }
  ],
  "additionalStats": [
    {
      "model": "Sistemas de frenos ABS",
      "count": 2,
      "percent": 40.0
    },
    {
      "model": "Airbag",
      "count": 2,
      "percent": 40.0
    },
    {
      "model": "Aire Acondicionado",
      "count": 1,
      "percent": 20.0
    }
  ],
  "count_car": 2
}
