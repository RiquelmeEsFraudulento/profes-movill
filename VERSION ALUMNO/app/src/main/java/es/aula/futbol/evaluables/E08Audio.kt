// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E08Audio {
 // Define next; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun next(current: Int, size: Int, direction: Int): Int? {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(direction == -1 || direction == 1) { "Dirección inválida" }
  // Evalúa la condición y ejecuta únicamente el camino correspondiente.
  if (size <= 0) return null
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(current in 0 until size) { "Índice inválido" }
  // Devuelve este resultado al código que invocó la función.
  return Math.floorMod(current + direction, size)
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = next(0,3,-1).toString()
// Cierra el bloque anterior y devuelve el control a su contexto.
}
