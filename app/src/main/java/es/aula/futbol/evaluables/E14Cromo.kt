// Sitúa el archivo en el paquete común; la carpeta organiza el material didáctico.
package es.aula.futbol
// Declara el modelo o componente que agrupa estas responsabilidades.
object E14Cromo {
 // Define title; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun title(raw: String, color: Int): String {
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(color in 0..2) { "Color inválido" }
  // Crea una referencia de solo lectura que se utilizará en los siguientes pasos.
  val clean = raw.trim()
  // Verifica una condición obligatoria; si falla, evita continuar con datos inválidos.
  require(clean.length in 1..28) { "Título de 1 a 28 caracteres" }
  // Devuelve este resultado al código que invocó la función.
  return clean
 // Cierra el bloque anterior y devuelve el control a su contexto.
 }
 // Define demo; sus parámetros indican los datos de entrada y el tipo final indica la salida.
 fun demo(): String = title("Mi jugador favorito",1)
// Cierra el bloque anterior y devuelve el control a su contexto.
}
