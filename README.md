# Marvel app - code challenge
## 📑 Table of Contents
- 🇪🇸 [Versión en Español](#versión-en-español)
- 🇬🇧 [English Version](#english-version)

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

---------------------------------------------------------------------------------------------------------------------------------------------
# 🇪🇸 Versión en Español

Aplicación móvil nativa Android para explorar héroes, villanos y eventos del universo Marvel.  
Los datos se obtienen de la API pública de Marvel Developer Portal.

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

---
---
---
---

# 🇬🇧 English Version

Android native mobile application for exploring heroes, villains, and events from the **Marvel Universe**.  
Data is retrieved from the **Marvel Developer Portal public API**.

---

## 📌 Notes  
This project is a **personal challenge**, similar to a "code challenge," created to deepen my understanding of **Android development best practices**, **architectural design**, and **public API integration**.  
Here I showcase both my technical knowledge and my approach to programming.

---

## ✨ Features (in progress)
- 📖 Character list with official information.  
- 🔍 Detailed view for each hero or villain.  
- 📅 Marvel universe events.  
- 🎯 Intuitive navigation.  
- 🧩 Modern architecture: **Hexagonal + MVVM**.  
- 🔌 Dependency injection with **Hilt**.  
- 🌐 API consumption using **Retrofit2**.  
- 🎨 Declarative UI with **Jetpack Compose**.  
- 🔐 User authentication: secure sign-up and login with **Firebase OAuth**.

---

## 🎨 App Preview  
You can see a preview of the design in Adobe XD:  

[👉 View Design in Adobe XD](https://xd.adobe.com/view/610ea5ae-9964-46d1-bdce-d456a63a2ed6-345d/screen/399f5581-41f0-4a97-be39-80b4ced000bd)

---

## 🛠️ Technologies Used  
- **Language:** Kotlin  
- **UI:** Jetpack Compose  
- **Architecture:** Hexagonal + MVVM  
- **Dependency Injection:** Hilt  
- **Networking:** Retrofit2 + Moshi  
- **Navigation:** Navigation Component + Jetpack Compose  
- **Images:** Coil  
- **Backend/Services:** Firebase  
- **Testing:** JUnit  

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

## ⚙️ Installation & Setup (Android)
1. Clone the repository:  
   ```bash
   git clone https://github.com/TolozaLeo/avengers-code-challenge.git
      ```
2. Create an account at [Marvel Developer](https://developer.marvel.com/) and obtain your API keys.
3. Open the project in Android Studio.
4. Add the following lines to your local.properties file:
   ```bash
   MARVEL_PUBLIC_KEY=your_public_key
   MARVEL_PRIVATE_KEY=your_private_key
   ```
5. Run the app on an Android device or emulator.
