# Informe de validación de la entrega

## Ejecutado realmente
Se han ejecutado 16 pruebas estructurales de los ZIP con Python unittest: 0 fallos y 0 errores. Se comprueban integridad CRC, 16 ejemplos, 16 evaluables, separación de soluciones, enunciados/recursos, 54 métodos locales, 3 instrumentados, XML de manifiesto, JSON de muestras, conexión de los 16 módulos con la interfaz, registro Academia, objetos sin duplicación, igualdad de base y rutas seguras.

Estas pruebas revisan el empaquetado y ciertas relaciones de los archivos. NO compilan Kotlin, NO ejecutan la lógica de la aplicación y NO garantizan que toda función Android opere correctamente.

## No ejecutado
- Gradle/compilación APK: pendiente.
- 54 métodos de prueba JUnit locales Kotlin/JVM: pendientes.
- 3 métodos Android instrumentados: pendientes.
- Plan manual de sensores, micrófono, cámara y Bluetooth real: pendiente.

Motivo: este entorno no tiene Java, Gradle, kotlinc, SDK, adb ni emulador. No hay APK generado ni informe ficticio de tests Android superados.

## Reproducir
Las pruebas de distribución se ejecutan con Python desde una carpeta que contenga ambos ALUMNO.ZIP y PROFESOR.ZIP: extrae scripts/verificar_distribucion.py y ejecuta `python verificar_distribucion.py`.
Los comandos JUnit/Android están en README.md. Se incluye workflow GitHub Actions para ejecutar compilación y pruebas al subir el proyecto a un repositorio propio; no se ha subido ni ejecutado ese workflow desde aquí.

## Diferencia intencional por edición
ALUMNO contiene 16 TODO evaluables. Los tests del contrato y los casos límite de esos módulos fallan hasta implementar su solución. No es válido ignorarlos para entregar. PROFESOR implementa los 16 contratos. Ambas ediciones comparten los 16 ejemplos, interfaz y recursos. Debe verificarse la compilación antes de distribuir en el aula.

## Alcance de los tests
Los 54 tests locales son una primera batería pública, no cobertura exhaustiva. El código de red/SPP/grabación requiere pruebas adicionales; no se equipara probar un mensaje con establecer comunicación real. Los tests instrumentados de SQLite usan bases con nombre temporal y no borran la base del usuario. La prueba de arranque comprueba un control del menú, no un recorrido completo.
