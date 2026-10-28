// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E02Filtros {
 // Define filter; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun filter(rows: List<Player>, query: String, club: String, position: String, favorites: Set<Int>, onlyFavorites: Boolean, descending: Boolean): List<Player> {
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val key = TextKey.of(query)
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val result = rows.filter { (key.isEmpty() || TextKey.of(it.name).contains(key)) && (club.isEmpty() || it.club == club) && (position.isEmpty() || it.position == position) && (!onlyFavorites || it.id in favorites) }.sortedBy { TextKey.of(it.name) }
  // Devuelve este resultado al código que invocó la función.
  return if (descending) result.reversed() else result
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = filter(Seed.players, "", "FC Barcelona", "Delantero", emptySet(), false, false).joinToString { it.name }
// Cierra el bloque anterior y devuelve el control a su contexto.
}
