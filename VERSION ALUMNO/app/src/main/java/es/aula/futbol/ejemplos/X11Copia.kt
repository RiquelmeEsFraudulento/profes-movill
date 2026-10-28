// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X11Copia {
 // Define noteJson; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun noteJson(id: Int, note: String): String {
  // Devuelve este resultado al código que invocó la función.
  return org.json.JSONObject().put("id",id).put("note",note).toString()
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = noteJson(1,"Observación")
 // Define readNote; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun readNote(text: String): Pair<Int,String> {
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val root=org.json.JSONObject(text)
  // Devuelve este resultado al código que invocó la función.
  return root.getInt("id") to root.getString("note")
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define roundTrip; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun roundTrip(): Boolean {
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val original="Nota con ñ"
  // Devuelve este resultado al código que invocó la función.
  return readNote(noteJson(1,original)).second==original
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }

// Cierra el bloque anterior y devuelve el control a su contexto.
}
