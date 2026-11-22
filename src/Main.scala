import scala.util.{Try, Success, Failure}
import MotorCifrado.procesarMensaje

// Presentar el resultado mediante pattern matching.
def mostrarResultado(etiqueta: String, resultado: Try[String]): Unit =
  resultado match
    case Success(mensaje) =>
      println(s"$etiqueta: $mensaje")

    case Failure(error) =>
      println(s"$etiqueta: ${error.getMessage}")

@main def iniciar(): Unit =

  println("SCALACRYPTO")

  // Prueba del cifrado César.
  println("\n1. CIFRADO CESAR")
  println("Mensaje original: FUNCIONAL")
  println("Clave: 3")

  val cesar = procesarMensaje(
    "FUNCIONAL", 3, CifradoCesar.transformar)

  val cesarDescifrado = cesar.flatMap(mensaje =>
    procesarMensaje(mensaje, -3, CifradoCesar.transformar))

  mostrarResultado("Mensaje cifrado", cesar)
  mostrarResultado("Mensaje descifrado", cesarDescifrado)

  // Prueba del cifrado XOR.
  println("\n2. CIFRADO XOR")
  println("Mensaje original: scala")
  println("Clave: 5")

  val xor = procesarMensaje(
    "scala", 5, CifradoXOR.transformar)

  val xorDescifrado = xor.flatMap(mensaje =>
    procesarMensaje(mensaje, 5, CifradoXOR.transformar))

  mostrarResultado("Mensaje cifrado", xor)
  mostrarResultado("Mensaje descifrado", xorDescifrado)

  // Pruebas del manejo de excepciones.
  println("\n3. MANEJO DE ERRORES")

  mostrarResultado("Mensaje vacío",
    procesarMensaje("", 3, CifradoCesar.transformar))

  mostrarResultado("Mensaje nulo",
    procesarMensaje(null, 3, CifradoCesar.transformar))

  mostrarResultado("Clave inválida César",
    procesarMensaje("SCALA", 100, CifradoCesar.transformar))

  mostrarResultado("Clave inválida XOR",
    procesarMensaje("scala", 200, CifradoXOR.transformar))

  mostrarResultado("Caracter no soportado",
    procesarMensaje("SCALA@", 3, CifradoCesar.transformar))

  mostrarResultado("Caracter fuera de ASCII",
    procesarMensaje("ñ", 5, CifradoXOR.transformar))