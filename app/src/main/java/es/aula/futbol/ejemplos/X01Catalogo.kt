// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X01Catalogo {
 // Define addOne; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun addOne(rows: List<Player>, player: Player): List<Player> {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(rows.none { it.id == player.id }); return rows + player
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = addOne(Seed.players, Seed.extra.first()).size.toString()
 // Define validSource; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun validSource(player: Player): Boolean = player.source.startsWith("https://") && player.name.isNotBlank()
 // Define preview; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun preview(player: Player): String = "${player.name} · ${player.club} · ${player.position}"
 // Define addAndDescribe; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun addAndDescribe(rows: List<Player>, player: Player): String {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(validSource(player)) { "Comprueba nombre y fuente" }
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val updated=addOne(rows,player)
  // Devuelve este resultado al código que invocó la función.
  return "Antes: ${rows.size}. Después: ${updated.size}. Añadido: ${preview(player)}"
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
// Cierra el bloque anterior y devuelve el control a su contexto.
}
