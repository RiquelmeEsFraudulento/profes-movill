// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E01Catalogo {
 // Define addTeam; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun addTeam(current: List<Player>, incoming: List<Player>): List<Player> {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(incoming.isNotEmpty()) { "El equipo está vacío" }
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(incoming.map { TextKey.of(it.club) }.distinct().size == 1) { "Usa un solo club por lote" }
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(incoming.all { it.id > 0 && it.name.isNotBlank() && it.club.isNotBlank() && it.position in setOf("Portero","Defensa","Centrocampista","Delantero") && it.source.startsWith("https://") }) { "Datos incompletos" }
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val combined = current + incoming
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(combined.map { it.id }.distinct().size == combined.size) { "ID repetido" }
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(combined.map { TextKey.of(it.club)+":"+TextKey.of(it.name) }.distinct().size == combined.size) { "Jugador duplicado" }
  // Devuelve este resultado al código que invocó la función.
  return combined
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = addTeam(Seed.players, Seed.extra).size.toString()
// Cierra el bloque anterior y devuelve el control a su contexto.
}
