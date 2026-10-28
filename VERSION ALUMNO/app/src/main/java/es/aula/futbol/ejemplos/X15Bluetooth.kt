// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X15Bluetooth {
 // Define line; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun line(player: Player): String {
  // Devuelve este resultado al código que invocó la función.
  return "${player.id};${player.name};${player.club}\n"
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = line(Seed.players.first())
 // Define validateLine; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun validateLine(text: String): Boolean {
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val fields=text.trim().split(';')
  // Devuelve este resultado al código que invocó la función.
  return fields.size==3 && fields[0].toIntOrNull()!=null && fields[1].isNotBlank() && fields[2].isNotBlank()
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define roundTrip; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun roundTrip(player: Player): Boolean = validateLine(line(player))

// Cierra el bloque anterior y devuelve el control a su contexto.
}
