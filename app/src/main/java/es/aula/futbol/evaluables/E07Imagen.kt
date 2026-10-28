// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E07Imagen {
 // Define filename; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun filename(id: Int, extension: String): String {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(id > 0) { "ID positivo" }
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(extension in setOf("png","jpg")) { "Formato no admitido" }
  // Devuelve este resultado al código que invocó la función.
  return "jugador_${id}.$extension"
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = filename(7,"png")
// Cierra el bloque anterior y devuelve el control a su contexto.
}
