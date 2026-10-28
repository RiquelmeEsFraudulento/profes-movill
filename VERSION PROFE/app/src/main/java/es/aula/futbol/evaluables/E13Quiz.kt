// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E13Quiz {
 // Define build; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun build(rows: List<Player>, count: Int): List<Question> {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(count > 0 && rows.map { it.id }.distinct().size == rows.size) { "Catálogo inválido" }
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(rows.size >= count) { "Faltan jugadores" }
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val clubs = rows.map { it.club }.distinct()
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(clubs.size >= 2) { "Faltan clubes" }
  // Devuelve este resultado al código que invocó la función.
  return rows.take(count).map { p -> Question(p.id,"¿En qué club está ${p.name}?",listOf(p.club,clubs.first { it != p.club }).sorted(),p.club) }
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = build(Seed.players,5).joinToString("\n") { it.text }
// Cierra el bloque anterior y devuelve el control a su contexto.
}
