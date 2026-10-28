// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X06Contraste {
 // Define grayWeights; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun grayWeights(): List<Float> {
  // Devuelve este resultado al código que invocó la función.
  return listOf(0.213f,0.715f,0.072f)
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = grayWeights().toString()
 // Define grayPixel; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun grayPixel(red: Int,green: Int,blue: Int): Int {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(listOf(red,green,blue).all { it in 0..255 })
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val w=grayWeights()
  // Devuelve este resultado al código que invocó la función.
  return (red*w[0]+green*w[1]+blue*w[2]).toInt().coerceIn(0,255)
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define describePixel; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun describePixel(): String = "Rojo puro se aproxima a gris ${grayPixel(255,0,0)}. El procesamiento real está en MediaArt.gray."

// Cierra el bloque anterior y devuelve el control a su contexto.
}
