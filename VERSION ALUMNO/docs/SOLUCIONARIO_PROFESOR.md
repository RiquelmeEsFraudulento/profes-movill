# Solucionario del profesor

Misma aplicación y mismos enunciados; cambia exclusivamente la implementación de los 16 evaluables y esta guía. No hay respuestas ocultas en ALUMNO.

## E01. Más equipos reales
Archivo: E01Catalogo.kt. Ejemplo: X01Catalogo.kt.

Contrato: Añadir dos clubes con al menos cinco jugadores verificados por club. No inventes posiciones ni estadísticas.

### Implementación de referencia
```kotlin
fun addTeam(current: List<Player>, incoming: List<Player>): List<Player> {
require(incoming.isNotEmpty()) { "El equipo está vacío" }
require(incoming.map { TextKey.of(it.club) }.distinct().size == 1) { "Usa un solo club por lote" }
require(incoming.all { it.name.isNotBlank() && it.club.isNotBlank() && it.position in setOf("Portero","Defensa","Centrocampista","Delantero") && it.source.startsWith("https://") }) { "Datos incompletos" }
val combined = current + incoming
require(combined.map { it.id }.distinct().size == combined.size) { "ID repetido" }
require(combined.map { TextKey.of(it.club)+":"+TextKey.of(it.name) }.distinct().size == combined.size) { "Jugador duplicado" }
return combined
}
```

### Corrección
Comprueba: Lote vacío rechazado; ID duplicado rechazado; Dos clubes añadidos y persistidos; Cada ficha nueva tiene fuente. Ejecuta E01Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X01. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E02. Buscar, filtrar y ordenar
Archivo: E02Filtros.kt. Ejemplo: X02Filtros.kt.

Contrato: Combina texto, club, posición y favoritos; añade orden ascendente y descendente.

### Implementación de referencia
```kotlin
fun filter(rows: List<Player>, query: String, club: String, position: String, favorites: Set<Int>, onlyFavorites: Boolean, descending: Boolean): List<Player> {
val key = TextKey.of(query)
val result = rows.filter { (key.isEmpty() || TextKey.of(it.name).contains(key)) && (club.isEmpty() || it.club == club) && (position.isEmpty() || it.position == position) && (!onlyFavorites || it.id in favorites) }.sortedBy { TextKey.of(it.name) }
return if (descending) result.reversed() else result
}
```

### Corrección
Comprueba: MBAPPÉ y mbappe encuentran el mismo jugador; Filtros combinados respetados; Lista vacía controlada; Orden inverso correcto. Ejecuta E02Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X02. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E03. Etiquetas y valoración personal
Archivo: E03Etiquetas.kt. Ejemplo: X03Etiquetas.kt.

Contrato: Guarda hasta cinco etiquetas únicas y una valoración personal de 0 a 5; nunca la presentes como estadística oficial.

### Implementación de referencia
```kotlin
fun mark(original: Mark, tags: List<String>, rating: Int): Mark {
require(rating in 0..5) { "Valoración entre 0 y 5" }
val clean = tags.map { it.trim() }.filter { it.isNotEmpty() }.distinctBy { TextKey.of(it) }
require(clean.size <= 5 && clean.all { it.length <= 24 }) { "Máximo cinco etiquetas de 24 caracteres" }
return original.copy(tags = clean, rating = rating)
}
```

### Corrección
Comprueba: Etiquetas equivalentes no se repiten; Se conservan nota y favorito; Valor 6 rechazado; Persistencia comprobada. Ejecuta E03Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X03. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E04. Comparar fichas sin inventar datos
Archivo: E04Comparador.kt. Ejemplo: X04Comparador.kt.

Contrato: Compara entre dos y cuatro jugadores distintos mostrando nombre, club y posición. No inventes quién es mejor.

### Implementación de referencia
```kotlin
fun compare(rows: List<Player>): String {
require(rows.size in 2..4) { "Selecciona de dos a cuatro" }
require(rows.map { it.id }.distinct().size == rows.size) { "No repitas jugador" }
return rows.joinToString("\n") { "${it.name} | ${it.club} | ${it.position}" }
}
```

### Corrección
Comprueba: Dos y cuatro fichas válidas; Una ficha rechazada; Duplicados rechazados; No se inventan estadísticas. Ejecuta E04Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X04. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E05. Sorpresa respetando filtros
Archivo: E05Sensor.kt. Ejemplo: X05Sensor.kt.

Contrato: Elige solo entre candidatos visibles; controla lista vacía y usa un índice para que la regla sea comprobable.

### Implementación de referencia
```kotlin
fun choose(candidates: List<Player>, index: Int): Player? {
if (candidates.isEmpty()) return null
return candidates[Math.floorMod(index, candidates.size)]
}
```

### Corrección
Comprueba: Vacío devuelve null; Índice negativo válido; Resultado pertenece a candidatos; Sensor se libera al pausar. Ejecuta E05Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X05. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E06. Filtro de contraste reversible
Archivo: E06Contraste.kt. Ejemplo: X06Contraste.kt.

Contrato: Valida un contraste entre 0 y 3. La pantalla aplicará tu regla a una copia conservando el original.

### Implementación de referencia
```kotlin
fun parameters(value: Float): Pair<Float, Float> {
require(value.isFinite() && value in 0f..3f) { "Contraste entre 0 y 3" }
return value to 128f * (1f - value)
}
```

### Corrección
Comprueba: Contraste 1 no cambia el nivel; NaN y fuera de rango rechazados; Original recuperable; Filtro visible. Ejecuta E06Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X06. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E07. Imagen persistente por jugador
Archivo: E07Imagen.kt. Ejemplo: X07Imagen.kt.

Contrato: Define rutas privadas seguras por ID; conecta captura/importación con recuperación tras reinicio.

### Implementación de referencia
```kotlin
fun filename(id: Int, extension: String): String {
require(id > 0) { "ID positivo" }
require(extension in setOf("png","jpg")) { "Formato no admitido" }
return "jugador_${id}.$extension"
}
```

### Corrección
Comprueba: Ruta no manipulable; Formato inválido rechazado; Imagen reaparece al reiniciar; Otra ficha no cambia. Ejecuta E07Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X07. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E08. Playlist y comentarios de voz
Archivo: E08Audio.kt. Ejemplo: X08Audio.kt.

Contrato: Calcula siguiente/anterior sin salir de rango. Integra con el reproductor y los audios grabados del jugador.

### Implementación de referencia
```kotlin
fun next(current: Int, size: Int, direction: Int): Int? {
require(direction == -1 || direction == 1) { "Dirección inválida" }
if (size <= 0) return null
require(current in 0 until size) { "Índice inválido" }
return Math.floorMod(current + direction, size)
}
```

### Corrección
Comprueba: Anterior desde 0 vuelve al último; Vacío devuelve null; Error de medio controlado; Permiso rechazado no cierra app. Ejecuta E08Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X08. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E09. Once inicial 4-3-3
Archivo: E09Alineacion.kt. Ejemplo: X09Alineacion.kt.

Contrato: Valida once jugadores distintos y reparto 1 portero, 4 defensas, 3 centrocampistas y 3 delanteros. Implementa sustitución visual.

### Implementación de referencia
```kotlin
fun validate(rows: List<Player>): Boolean {
if (rows.size != 11 || rows.map { it.id }.distinct().size != 11) return false
val groups = rows.groupingBy { it.position }.eachCount()
return groups == mapOf("Portero" to 1,"Defensa" to 4,"Centrocampista" to 3,"Delantero" to 3)
}
```

### Corrección
Comprueba: Once correcto aceptado; Duplicado rechazado; Reparto incorrecto rechazado; Borrador incompleto guardado. Ejecuta E09Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X09. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E10. Colecciones múltiples
Archivo: E10Colecciones.kt. Ejemplo: X10Colecciones.kt.

Contrato: Crea nombres únicos ignorando tildes/mayúsculas y espacios. Vincula jugadores sin duplicarlos.

### Implementación de referencia
```kotlin
fun add(names: List<String>, name: String): List<String> {
val clean = name.trim()
require(clean.length in 1..40) { "Nombre de 1 a 40 caracteres" }
require(names.none { TextKey.of(it) == TextKey.of(clean) }) { "Colección repetida" }
return names + clean
}
```

### Corrección
Comprueba: Nombre vacío rechazado; Nombre equivalente rechazado; Integrantes sin duplicados; Borrado independiente. Ejecuta E10Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X10. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E11. Copia de seguridad validada
Archivo: E11Copia.kt. Ejemplo: X11Copia.kt.

Contrato: Exporta y restaura favoritos/notas; valida antes de escribir. Conserva los jugadores ausentes de la copia.

### Implementación de referencia
```kotlin
fun restore(current: Map<Int, Mark>, text: String, known: Set<Int>): Map<Int, Mark> {
val incoming = Wire.decode(text, known)
return current + incoming
}
```

### Corrección
Comprueba: Copia válida recuperada; JSON inválido no escribe; Cancelación no escribe; Datos ausentes conservados. Ejecuta E11Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X11. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E12. Datos guardados sin conexión
Archivo: E12Cache.kt. Ejemplo: X12Cache.kt.

Contrato: Distingue respuesta válida vacía de error. Mantén último resultado al fallar la descarga.

### Implementación de referencia
```kotlin
fun resolve(remote: List<Player>?, saved: List<Player>, error: String?): CacheResult {
if (remote != null && error == null) return CacheResult(remote,false,"Actualizado")
return CacheResult(saved,true,if (saved.isEmpty()) "Sin datos: ${error ?: "sin conexión"}" else "Datos guardados: ${error ?: "sin conexión"}")
}
```

### Corrección
Comprueba: Error conserva cache; Remoto vacío válido en helper; Primera apertura sin datos controlada; Fecha de actualización visible al actualizar. Ejecuta E12Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X12. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E13. Reto de cinco preguntas
Archivo: E13Quiz.kt. Ejemplo: X13Quiz.kt.

Contrato: Crea cinco preguntas de club sin jugadores repetidos, dos opciones distintas y exactamente una correcta.

### Implementación de referencia
```kotlin
fun build(rows: List<Player>, count: Int): List<Question> {
require(count > 0 && rows.map { it.id }.distinct().size == rows.size) { "Catálogo inválido" }
require(rows.size >= count) { "Faltan jugadores" }
val clubs = rows.map { it.club }.distinct()
require(clubs.size >= 2) { "Faltan clubes" }
return rows.take(count).map { p -> Question(p.id,"¿En qué club está ${p.name}?",listOf(p.club,clubs.first { it != p.club }).sorted(),p.club) }
}
```

### Corrección
Comprueba: Cinco jugadores distintos; Opciones distintas y una correcta; Doble pulsación no suma; Mejor resultado conservado. Ejecuta E13Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X13. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E14. Diseñar y compartir cromo
Archivo: E14Cromo.kt. Ejemplo: X14Cromo.kt.

Contrato: Valida título de hasta 28 caracteres y uno de tres colores. Integra previsualización y compartir imagen.

### Implementación de referencia
```kotlin
fun title(raw: String, color: Int): String {
require(color in 0..2) { "Color inválido" }
val clean = raw.trim()
require(clean.length in 1..28) { "Título de 1 a 28 caracteres" }
return clean
}
```

### Corrección
Comprueba: Título vacío rechazado; Nombre largo encaja en cromo; Previsualización correcta; Otra app abre el PNG. Ejecuta E14Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X14. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E15. Intercambio con confirmación
Archivo: E15Bluetooth.kt. Ejemplo: X15Bluetooth.kt.

Contrato: Codifica colección con versión; valida tamaño e IDs, confirma recepción con ACK y permite cancelar.

### Implementación de referencia
```kotlin
fun decode(text: String, known: Set<Int>): List<Int> {
require(text.toByteArray(Charsets.UTF_8).size <= 8192) { "Mensaje demasiado grande" }
val root = org.json.JSONObject(text)
require(root.getInt("version") == 1) { "Versión incorrecta" }
val ids = root.getJSONArray("ids")
val result = (0 until ids.length()).map { ids.getInt(it) }
require(result.isNotEmpty() && result.distinct().size == result.size && result.all { it in known }) { "IDs inválidos" }
return result
}
```

### Corrección
Comprueba: Versión incorrecta rechazada; ID desconocido rechazado; Recepción demostrada; Cancelación y espera máxima. Ejecuta E15Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X15. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

## E16. Panel de mi colección
Archivo: E16Panel.kt. Ejemplo: X16Panel.kt.

Contrato: Agrupa por club sin duplicar IDs y muestra recuentos de tu colección, no estadísticas deportivas. Añade una ampliación propia.

### Implementación de referencia
```kotlin
fun counts(rows: List<Player>): Map<String, Int> {
return rows.distinctBy { it.id }.groupingBy { it.club }.eachCount().toSortedMap()
}
```

### Corrección
Comprueba: Vacío produce mapa vacío; ID repetido cuenta una vez; Recuento por club correcto; Ampliación documentada. Ejecuta E16Test y el recorrido manual. Un resultado correcto del helper no acredita por sí solo el requisito de hardware o la documentación de datos. Acepta implementaciones equivalentes.

### Ayuda gradual
Primero pide explicar entradas/salida. Después señala el ejemplo X16. Finalmente revisa un caso válido y uno de error. No reduzcas la evaluación a memorizar esta solución.

