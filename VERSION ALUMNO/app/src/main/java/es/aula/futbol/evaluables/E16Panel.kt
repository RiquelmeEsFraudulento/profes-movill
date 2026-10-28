// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E16Panel {
 // Define counts; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun counts(rows: List<Player>): Map<String, Int> {
  // Devuelve este resultado al código que invocó la función.
  return rows.distinctBy { it.id }.groupingBy { it.club }.eachCount().toSortedMap()
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = counts(Seed.players).toString()
// Cierra el bloque anterior y devuelve el control a su contexto.
}
