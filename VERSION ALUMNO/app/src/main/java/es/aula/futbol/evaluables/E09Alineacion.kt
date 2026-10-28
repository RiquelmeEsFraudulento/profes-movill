// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E09Alineacion {
 // Define validate; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun validate(rows: List<Player>): Boolean {
  // Evalúa la condición y ejecuta únicamente el camino correspondiente.
  if (rows.size != 11 || rows.map { it.id }.distinct().size != 11) return false
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val groups = rows.groupingBy { it.position }.eachCount()
  // Devuelve este resultado al código que invocó la función.
  return groups == mapOf("Portero" to 1,"Defensa" to 4,"Centrocampista" to 3,"Delantero" to 3)
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = validate(Seed.players.take(11)).toString()
// Cierra el bloque anterior y devuelve el control a su contexto.
}
