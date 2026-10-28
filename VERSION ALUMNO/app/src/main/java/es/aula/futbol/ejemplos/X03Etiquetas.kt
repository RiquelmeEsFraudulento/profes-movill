// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X03Etiquetas {
 // Define favorite; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun favorite(mark: Mark): Mark {
  // Devuelve este resultado al código que invocó la función.
  return mark.copy(favorite = !mark.favorite)
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = favorite(Mark()).toString()
 // Define withNote; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun withNote(mark: Mark, text: String): Mark {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(text.length<=4000) { "Nota demasiado larga" }
  // Devuelve este resultado al código que invocó la función.
  return mark.copy(note=text.trim())
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define sample; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun sample(): Mark {
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val original=Mark(false,"Observación anterior")
  // Devuelve este resultado al código que invocó la función.
  return favorite(withNote(original,"Nueva observación"))
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
// Cierra el bloque anterior y devuelve el control a su contexto.
}
