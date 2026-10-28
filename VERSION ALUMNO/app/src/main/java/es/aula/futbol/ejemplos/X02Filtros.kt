// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X02Filtros {
 // Define search; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun search(rows: List<Player>, query: String): List<Player> {
  // Devuelve este resultado al código que invocó la función.
  return rows.filter { TextKey.of(it.name).contains(TextKey.of(query)) }
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = search(Seed.players,"mbappe").joinToString { it.name }
 // Define byClub; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun byClub(rows: List<Player>, club: String): List<Player> = rows.filter { it.club == club }
 // Define emptyMessage; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun emptyMessage(rows: List<Player>): String = if(rows.isEmpty()) "No hay coincidencias" else "${rows.size} coincidencias"
 // Define searchAndDescribe; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun searchAndDescribe(rows: List<Player>, query: String): String {
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val found=search(rows,query)
  // Devuelve este resultado al código que invocó la función.
  return emptyMessage(found)+"\n"+found.joinToString("\n") { it.name }
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
// Cierra el bloque anterior y devuelve el control a su contexto.
}
