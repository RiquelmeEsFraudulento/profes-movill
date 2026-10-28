// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E11Copia {
 // Define restore; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun restore(current: Map<Int, Mark>, text: String, known: Set<Int>): Map<Int, Mark> {
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val incoming = Wire.decode(text, known)
  // Devuelve este resultado al código que invocó la función.
  return current + incoming
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = restore(emptyMap(),Wire.encode(mapOf(1 to Mark(true,"Nota"))),setOf(1)).toString()
// Cierra el bloque anterior y devuelve el control a su contexto.
}
