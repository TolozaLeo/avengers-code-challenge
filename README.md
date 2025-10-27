# Marvel app - code challenge

![Status](https://img.shields.io/badge/Estado-En%20desarrollo-yellow)
![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-blueviolet?logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-15-green?logo=android&logoColor=white)
![Compose](https://img.shields.io/badge/Jetpack_Compose-UI-orange?logo=jetpackcompose&logoColor=white)
![MVVM](https://img.shields.io/badge/Architecture-MVVM-informational)
![Coil](https://img.shields.io/badge/Coil-Image%20Loader-blue)
![Retrofit2](https://img.shields.io/badge/Retrofit2-Networking-orange)
![Dagger Hilt](https://img.shields.io/badge/Dagger_Hilt-DI-success)
![JUnit](https://img.shields.io/badge/JUnit-Testing-red)
![Mockk](https://img.shields.io/badge/Mockk-Mocking-lightgrey)
![Firebase](https://img.shields.io/badge/Firebase-Backend-yellow?logo=firebase&logoColor=white)

Aplicación móvil nativa Android para explorar héroes, villanos y eventos del universo Marvel.  
Los datos se obtienen de la API pública de Marvel Developer Portal.

🚧 **Estado del proyecto:** En desarrollo  
Este proyecto está en construcción constante: se añadirán nuevas funcionalidades y mejoras progresivamente.  

---

## 📌 Notas  
Este proyecto es un **desafío personal** como del tipo "code challenge" para profundizar en buenas prácticas de desarrollo Android, diseño de arquitectura y exploración de APIs públicas.  
Aquí demuestro mis conocimientos y mi forma de programar.

---

## ✨ Características (en progreso)
- 📖 Listado de personajes con información oficial.  
- 🔍 Detalles de cada héroe o villano.  
- 📅 Eventos llevados a cabo por Marvel.  
- 🎯 Navegación intuitiva.  
- 🧩 Arquitectura moderna: **Hexagonal + MVVM**.  
- 🔌 Inyección de dependencias con **Hilt**.  
- 🌐 Consumo de API con **Retrofit2**.  
- 🎨 UI declarativa con **Jetpack Compose**.
- 🔐 Autenticación de usuarios: registro e inicio de sesión seguro con Firebase OAuth.

---

## 🎨 Preview de la App
Aquí puedes ver un adelanto del diseño en Adobe XD:  

[👉 Ver diseño en Adobe XD](https://xd.adobe.com/view/610ea5ae-9964-46d1-bdce-d456a63a2ed6-345d/screen/399f5581-41f0-4a97-be39-80b4ced000bd)

---

## 🛠️ Tecnologías utilizadas
- **Lenguaje:** Kotlin  
- **UI:** Jetpack Compose  
- **Arquitectura:** Hexagonal + MVVM  
- **Inyección de dependencias:** Hilt  
- **Red:** Retrofit2 + Moshi
- **Navegación:** Navigation Component + Jetpack Compose  
- **Imágenes:** Coil  
- **Backend/Servicios:** Firebase  
- **Testing:** JUnit  

---

## 🚀 Roadmap
- [ ] Autenticación con Firebase (login de usuarios).  
- [ ] Testing unitario e instrumentado.  

---

## ⚙️ Instalación y configuración (Android)
1. Clonar el repositorio:  
   ```bash
   git clone https://github.com/TolozaLeo/avengers-code-challenge.git
   ```
2. Crear una cuenta en [Marvel Developer](https://developer.marvel.com/) y obtener tus API Keys.
3. Abrir el proyecto en Android Studio.
4. En el archivo local.properties agregar:
   ```bash
   MARVEL_PUBLIC_KEY=tu_public_key
   MARVEL_PRIVATE_KEY=tu_private_key
   ```
5. Ejecutar la app en un dispositivo o emulador Android.
