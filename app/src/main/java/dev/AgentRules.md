## AgentsRules.
Esta es una aplicación para aprender sobre el uso de firebase e implementacion de sus funciones.
Es un proyecto universitario, poco profesional y que no va a escalar más de lo que está actualmente, por lo tanto la prioridad es el desarrollo de funcionalidades, no es tan importante mantener buenas prácticas de programación.

# Descripción del proyecto:
- La aplicación cuenta con dos pantallas principales: 1. Lista de personajes de Disney. 2. Panel de control de Firebase.
- La lista de personajes se obtiene desde la api: "https://disneyapi.dev/"; al seleccionar a un personaje, se navega a la pantalla de detalles sobre ese personaje.
- El panel de control cuenta con botones que cada uno lanza una acción distinta para hacer uso de distintos artefactos de Firebase, como forzar un crash para verlo en la consola de Firebase, o un botón que se pueda habilitar y deshabilitar con Firebase Remote config.
- También se debe aplicar autenticacion de usuarios a travez de la UI proporcionada por Firebase.

# Tecnologías
- Kotlin como lenguaje de programación.
- Jetpack Compose para la UI.
- Material 3 como sistema de diseño.
- Dagger Hilt para inyeccion de dependencias.
- KSP para generar dependencias que generen código, NO KAPT.
- Api de "https://disneyapi.dev/".
- Firebase como BaaS: 
    Google Analytics, Generar al menos 2 eventos manuales + 2 user properties que se van a usar para filtrar informes.
    Crashlytics, Generar al menos 2 acciones que disparen Crashes.
    Remote config, Generar al menos 2 configuraciones.
    Authentication, Implementar la autenticación de email +  servicio de terceros (Google).
    Base de datos, Implementar Firestore.
    Cloud Storage, Relacionar las imágenes (Thumbails) de los personajes a la base de datos.

# Arquitectura
- Arquitectura hexagonal por capas recomedada para Android: DOMAIN, DATA, UI.
- MVVM.

# Reglas
- Respondé siempre en español.
- No modificar las implementaciones de las librerías o ficheros gradle presentes, solo podés agregar nuevas que necesites a demanda, pero no modificar las existentes, si lo crees extrictamente necesario, pedile al usuario que lo haga manualmente.
- No es necesario hacer Tests a menos que te lo especifique el usuario.
- Siempre que termines de generar código, compilalo para ver si hay errores, para eso usá compileDebugKotlin.