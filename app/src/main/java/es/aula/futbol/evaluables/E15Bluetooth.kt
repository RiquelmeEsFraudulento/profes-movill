// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E15Bluetooth {
 // Define decode; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun decode(text: String, known: Set<Int>): List<Int> {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(text.toByteArray(Charsets.UTF_8).size <= 8192) { "Mensaje demasiado grande" }
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val root = org.json.JSONObject(text)
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(root.getInt("version") == 1) { "Versión incorrecta" }
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val ids = root.getJSONArray("ids")
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val result = (0 until ids.length()).map { ids.getInt(it) }
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(result.isNotEmpty() && result.distinct().size == result.size && result.all { it in known }) { "IDs inválidos" }
  // Devuelve este resultado al código que invocó la función.
  return result
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = decode("{\"version\":1,\"ids\":[1,2]}",setOf(1,2)).toString()
// Cierra el bloque anterior y devuelve el control a su contexto.
}
