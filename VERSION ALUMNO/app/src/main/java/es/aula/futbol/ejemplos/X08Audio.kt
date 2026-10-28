// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X08Audio {
 // Define canPlay; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun canPlay(prepared: Boolean, recording: Boolean): Boolean {
  // Devuelve este resultado al código que invocó la función.
  return prepared && !recording
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = canPlay(true,false).toString()
 // Define playbackState; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun playbackState(prepared: Boolean,recording: Boolean): String {
  // Devuelve este resultado al código que invocó la función.
  return if(recording) "Grabando: no reproducir" else if(canPlay(prepared,false)) "Listo para reproducir" else "Preparando o sin audio"
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define durationLabel; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun durationLabel(seconds: Int): String {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(seconds>=0)
  // Devuelve este resultado al código que invocó la función.
  return "%02d:%02d".format(seconds/60,seconds%60)
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
// Cierra el bloque anterior y devuelve el control a su contexto.
}
