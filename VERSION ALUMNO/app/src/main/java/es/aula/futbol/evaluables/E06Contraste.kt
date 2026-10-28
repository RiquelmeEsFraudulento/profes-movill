// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E06Contraste {
 // Define parameters; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun parameters(value: Float): Pair<Float, Float> {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(value.isFinite() && value in 0f..3f) { "Contraste entre 0 y 3" }
  // Devuelve este resultado al código que invocó la función.
  return value to 128f * (1f - value)
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = parameters(1.4f).toString()
// Cierra el bloque anterior y devuelve el control a su contexto.
}
