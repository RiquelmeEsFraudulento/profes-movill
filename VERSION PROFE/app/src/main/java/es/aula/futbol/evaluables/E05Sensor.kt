// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E05Sensor {
 // Define choose; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun choose(candidates: List<Player>, index: Int): Player? {
  // Evalúa la condición y ejecuta únicamente el camino correspondiente.
  if (candidates.isEmpty()) return null
  // Devuelve este resultado al código que invocó la función.
  return candidates[Math.floorMod(index, candidates.size)]
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = choose(Seed.players.filter { it.club == "FC Barcelona" },0)?.name ?: "Sin candidatos"
// Cierra el bloque anterior y devuelve el control a su contexto.
}
