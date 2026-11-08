<h1 align="center"> IMCalculator </h1>

<p align="center">
An Android Body Mass Index (BMI) calculator built with Kotlin and XML. <br/>
</p>

<br>

<p align="center">
  <img alt="IMCalculator banner showing the welcome, input, and result screens" src=".github/banner-imcalculator.png" width="100%">
</p>

## 🚀 Technologies

This project was developed with the following technologies and tools:

- Kotlin
- XML
- Android SDK
- Material Components
- Gradle
- Android Studio

## 💻 Project

**IMCalculator** is an Android application that calculates Body Mass Index (BMI) from weight in kilograms and height in meters.

After a welcome screen, users enter their measurements and receive their BMI, displayed to two decimal places, along with a weight classification. The app also lets users return to the calculation screen with empty fields to perform a new calculation.

The project was developed to practice Android development with **Kotlin** and interface design with **XML**.

### Features and applied concepts

- **Welcome screen:** a gradient background and a brief transition to the calculation screen.
- **Input validation:** checks for empty, invalid, or non-positive values, with support for decimal commas and decimal points.
- **BMI calculation:** weight in kilograms divided by the square of height in meters.
- **Result screen:** BMI formatted to two decimal places and a classification with color feedback.
- **New calculation:** a Recalculate button returns to the previous screen with the weight and height fields cleared.
- **Screen navigation:** Activities and Intents handle navigation and pass the calculated BMI between screens.
- **XML interface:** ConstraintLayout, rounded input fields, vector icons, gradient backgrounds, and Material Components.

## ▶️ Running the project

### Prerequisites

- [Git](https://git-scm.com/)
- Android Studio compatible with the project's Gradle and Android Gradle Plugin versions
- Android SDK Platform 37
- JDK 25 for the Gradle daemon, as configured in `gradle/gradle-daemon-jvm.properties`
- An emulator or physical device running Android 7.0 (API 24) or later

### Cloning the repository

```bash
git clone https://github.com/GustavoFSCode/IMCalculator.git
cd IMCalculator
```

### Running with Android Studio

1. Open the `IMCalculator` folder in Android Studio.
2. Wait for Gradle sync to finish and install any requested SDK components.
3. Create and start an emulator in **Device Manager**, or connect a physical device with **USB debugging** enabled.
4. Select the device and click **Run ▶**.

### Running from the terminal

With the JDK and Android SDK configured and an emulator running or a device connected, run the following command from the project root:

**Windows — PowerShell:**

```powershell
.\gradlew.bat installDebug
```

**Linux or macOS:**

```bash
chmod +x gradlew
./gradlew installDebug
```

After installation, open **IMCalculator** from the device's app list.

You can also run these commands in the VS Code or Cursor terminal, provided your Android environment is configured.
