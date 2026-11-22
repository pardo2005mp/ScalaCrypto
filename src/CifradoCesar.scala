object CifradoCesar:

  val transformar: (Char, Int) => Char = (caracter, clave) =>

    require(clave >= -25 && clave <= 25,
      "La clave César debe estar entre -25 y 25")

    // Identificar si el caracter es una letra mayúscula o minúscula.
    val base =
      if caracter >= 'A' && caracter <= 'Z' then 'A'
      else if caracter >= 'a' && caracter <= 'z' then 'a'
      else throw new IllegalArgumentException(
        s"Caracter no soportado: $caracter")

    // Aplicar el desplazamiento circular del alfabeto.
    val posicion = caracter - base
    val desplazamiento = ((posicion + clave) % 26 + 26) % 26

    (base + desplazamiento).toChar