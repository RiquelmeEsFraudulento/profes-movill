// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X12Cache {
 // Define hasCache; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun hasCache(saved: List<Player>): Boolean {
  // Devuelve este resultado al código que invocó la función.
  return saved.isNotEmpty()
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = hasCache(Seed.players).toString()
 // Define label; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun label(saved: List<Player>,timestamp: String): String {
  // Devuelve este resultado al código que invocó la función.
  return if(hasCache(saved)) "${saved.size} guardados. Fecha: $timestamp" else "Todavía no hay datos guardados"
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define onFailure; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun onFailure(saved: List<Player>): CacheResult = CacheResult(saved,true,label(saved,"desconocida"))

// Cierra el bloque anterior y devuelve el control a su contexto.
}
