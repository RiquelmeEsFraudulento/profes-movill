// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X13Quiz {
 // Define correct; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun correct(answer: String, expected: String): Boolean {
  // Devuelve este resultado al código que invocó la función.
  return answer == expected
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = correct("Real Madrid","Real Madrid").toString()
 // Define oneQuestion; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun oneQuestion(player: Player,otherClub: String): Question {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(otherClub!=player.club)
  // Devuelve este resultado al código que invocó la función.
  return Question(player.id,"¿Dónde juega ${player.name}?",listOf(player.club,otherClub),player.club)
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define score; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun score(answer: String,question: Question): Int = if(correct(answer,question.answer)) 1 else 0

// Cierra el bloque anterior y devuelve el control a su contexto.
}
