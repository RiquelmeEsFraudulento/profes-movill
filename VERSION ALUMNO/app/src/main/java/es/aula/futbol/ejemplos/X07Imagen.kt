// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X07Imagen {
 // Define temporaryName; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun temporaryName(id: Int): String {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(id > 0); return "preview_$id.png"
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = temporaryName(1)
 // Define formats; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun formats(): Map<String,String> = mapOf("png" to "image/png","jpg" to "image/jpeg")
 // Define mime; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun mime(extension: String): String = formats()[extension] ?: error("Formato no admitido")
 // Define describe; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun describe(id: Int): String = "Vista temporal: ${temporaryName(id)}. PNG es un formato, no solo una extensión."

// Cierra el bloque anterior y devuelve el control a su contexto.
}
