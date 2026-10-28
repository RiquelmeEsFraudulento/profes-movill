// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object X10Colecciones {
 // Define addMember; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun addMember(ids: List<Int>, id: Int): List<Int> {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(id > 0); return (ids + id).distinct()
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = addMember(listOf(1),1).toString()
 // Define removeMember; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun removeMember(ids: List<Int>,id: Int): List<Int> = ids.filter { it!=id }
 // Define replaceMember; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun replaceMember(ids: List<Int>,oldId: Int,newId: Int): List<Int> {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(newId>0)
  // Devuelve este resultado al código que invocó la función.
  return ids.map { if(it==oldId) newId else it }.distinct()
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define describe; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun describe(ids: List<Int>): String = "Lista de seguimiento: ${ids.size} integrantes"

// Cierra el bloque anterior y devuelve el control a su contexto.
}
