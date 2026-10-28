// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X04Comparador {
 // Define sameClub; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun sameClub(a: Player, b: Player): Boolean {
  // Devuelve este resultado al código que invocó la función.
  return a.club == b.club
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = sameClub(Seed.players[0],Seed.players[1]).toString()
 // Define identity; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun identity(player: Player): String = "${player.name} | ${player.club} | ${player.position}"
 // Define describePair; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun describePair(a: Player,b: Player): String {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(a.id!=b.id) { "Elige dos jugadores distintos" }
  // Devuelve este resultado al código que invocó la función.
  return identity(a)+"\n"+identity(b)+"\nMismo club: "+sameClub(a,b)
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
// Cierra el bloque anterior y devuelve el control a su contexto.
}
