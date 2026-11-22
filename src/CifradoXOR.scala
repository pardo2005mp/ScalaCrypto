object CifradoXOR:

  val transformar: (Char, Int) => Char = (caracter, clave) =>

    // Validar que la clave y el caracter pertenezcan al rango ASCII.
    require(clave >= 0 && clave <= 127,
      "La clave XOR debe estar entre 0 y 127")

    require(caracter.toInt <= 127,
      s"Caracter no soportado: $caracter")

    // Aplicar la operación XOR y convertir el resultado a Char.
    (caracter.toInt ^ clave).toChar