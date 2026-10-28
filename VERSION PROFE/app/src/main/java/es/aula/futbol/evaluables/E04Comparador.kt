// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E04Comparador {
 // Define compare; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun compare(rows: List<Player>): String {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(rows.size in 2..4) { "Selecciona de dos a cuatro" }
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(rows.map { it.id }.distinct().size == rows.size) { "No repitas jugador" }
  // Devuelve este resultado al código que invocó la función.
  return rows.joinToString("\n") { "${it.name} | ${it.club} | ${it.position}" }
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = compare(Seed.players.take(2))
// Cierra el bloque anterior y devuelve el control a su contexto.
}
