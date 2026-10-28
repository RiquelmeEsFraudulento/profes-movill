// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E12Cache {
 // Define resolve; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun resolve(remote: List<Player>?, saved: List<Player>, error: String?): CacheResult {
  // Evalúa la condición y ejecuta únicamente el camino correspondiente.
  if (remote != null && error == null) return CacheResult(remote,false,"Actualizado")
  // Devuelve este resultado al código que invocó la función.
  return CacheResult(saved,true,if (saved.isEmpty()) "Sin datos: ${error ?: "sin conexión"}" else "Datos guardados: ${error ?: "sin conexión"}")
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = resolve(null,Seed.players,"sin red").message
// Cierra el bloque anterior y devuelve el control a su contexto.
}
