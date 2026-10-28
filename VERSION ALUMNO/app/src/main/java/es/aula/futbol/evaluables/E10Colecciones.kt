// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E10Colecciones {
 // Define add; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun add(names: List<String>, name: String): List<String> {
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val clean = name.trim()
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(clean.length in 1..40) { "Nombre de 1 a 40 caracteres" }
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(names.none { TextKey.of(it) == TextKey.of(clean) }) { "Colección repetida" }
  // Devuelve este resultado al código que invocó la función.
  return names + clean
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = add(listOf("Promesas"),"Mi once").joinToString()
// Cierra el bloque anterior y devuelve el control a su contexto.
}
