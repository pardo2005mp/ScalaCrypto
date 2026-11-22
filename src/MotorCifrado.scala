import scala.util.Try

object MotorCifrado:

  // Función de orden superior que recibe una estrategia de cifrado.
  def procesarMensaje(
      mensaje: String,
      clave: Int,
      cifrado: (Char, Int) => Char
  ): Try[String] =

    Try {
      require(mensaje != null, "El mensaje no puede ser nulo")
      require(mensaje.nonEmpty, "El mensaje no puede estar vacío")

      // Transformar cada caracter sin modificar el mensaje original.
      mensaje.map(caracter => cifrado(caracter, clave))
    }