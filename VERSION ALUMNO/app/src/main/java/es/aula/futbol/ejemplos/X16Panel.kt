// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X16Panel {
 // Define total; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun total(rows: List<Player>): Int {
  // Devuelve este resultado al código que invocó la función.
  return rows.size
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = total(Seed.players).toString()
 // Define favorites; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun favorites(rows: List<Player>,marks: Map<Int,Mark>): List<Player> = rows.filter { marks[it.id]?.favorite==true }
 // Define summary; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun summary(rows: List<Player>,marks: Map<Int,Mark>): String {
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val selected=favorites(rows,marks)
  // Devuelve este resultado al código que invocó la función.
  return "Total: ${total(rows)}. Favoritos: ${selected.size}. Son recuentos personales."
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }

// Cierra el bloque anterior y devuelve el control a su contexto.
}
