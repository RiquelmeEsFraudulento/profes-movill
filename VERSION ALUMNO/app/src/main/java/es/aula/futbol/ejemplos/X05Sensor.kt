// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X05Sensor {
 // Define first; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun first(rows: List<Player>): Player? {
  // Devuelve este resultado al código que invocó la función.
  return rows.firstOrNull()
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = first(Seed.players)?.name ?: "Vacío"
 // Define magnitude; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun magnitude(x: Float,y: Float,z: Float): Float = kotlin.math.sqrt(x*x+y*y+z*z)
 // Define shouldTrigger; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun shouldTrigger(magnitude: Float, now: Long, last: Long): Boolean = magnitude>22f && now-last>2000
 // Define describeMotion; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun describeMotion(): String {
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val acceleration=magnitude(20f,20f,0f)
  // Devuelve este resultado al código que invocó la función.
  return "¿Avisar?: ${shouldTrigger(acceleration,5000,0)}"
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
// Cierra el bloque anterior y devuelve el control a su contexto.
}
