// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X14Cromo {
 // Define initials; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun initials(player: Player): String {
  // Devuelve este resultado al código que invocó la función.
  return player.name.split(" ").take(2).joinToString("") { it.take(1) }
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = initials(Seed.players.first())
 // Define fitTitle; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun fitTitle(text: String,maxLength: Int): String {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(maxLength>0)
  // Devuelve este resultado al código que invocó la función.
  return text.trim().take(maxLength)
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define label; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun label(player: Player): String = "${initials(player)} · ${player.name}"

// Cierra el bloque anterior y devuelve el control a su contexto.
}
