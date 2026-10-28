// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X09Alineacion {
 // Define validTrio; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun validTrio(rows: List<Player>): Boolean {
  // Devuelve este resultado al código que invocó la función.
  return rows.size == 3 && rows.map { it.id }.distinct().size == 3
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = validTrio(Seed.players.take(3)).toString()
 // Define addToTrio; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun addToTrio(rows: List<Player>,player: Player): List<Player> {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(rows.size<3) { "Trío completo" }
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(rows.none { it.id==player.id }) { "Repetido" }
  // Devuelve este resultado al código que invocó la función.
  return rows+player
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define saveDraft; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun saveDraft(rows: List<Player>): List<Int> = rows.map { it.id }

// Cierra el bloque anterior y devuelve el control a su contexto.
}
