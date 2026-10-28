// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E03Etiquetas {
 // Define mark; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun mark(original: Mark, tags: List<String>, rating: Int): Mark {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(rating in 0..5) { "Valoración entre 0 y 5" }
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val clean = tags.map { it.trim() }.filter { it.isNotEmpty() }.distinctBy { TextKey.of(it) }
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(clean.size <= 5 && clean.all { it.length <= 24 }) { "Máximo cinco etiquetas de 24 caracteres" }
  // Devuelve este resultado al código que invocó la función.
  return original.copy(tags = clean, rating = rating)
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = mark(Mark(),listOf("Técnica"," técnica "),4).toString()
// Cierra el bloque anterior y devuelve el control a su contexto.
}
