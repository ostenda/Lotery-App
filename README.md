
# Lottery App

## Overview

Lottery App is an Android application that displays lottery draw results and allows users to view randomly generated lottery tickets to see if they have won. The app uses Jetpack Compose for the UI, Gson for JSON parsing, and Navigation Compose for navigation.

## Features

- Display a list of lottery draws.
- View details of a specific lottery draw after clicking on one of them
- Generate and display random lottery tickets.
- Check if a ticket is a winning ticket based on the draw results.

## Prerequisites

To run this application, you will need:

- Android Studio (latest version recommended)
- An Android device or emulator running Android API level 21 or higher

## Installation

### Clone the Repository
```bash
git clone https://github.com/ostenda/lotteryapp.git
```

### Open the Project in Android Studio
1. Open Android Studio.
2. Select "Open an existing Android Studio project".
3. Navigate to the cloned repository and select the project.

### Build the Project
- Allow Android Studio to build the project and download any necessary dependencies.

## Running the Application

### Run on an Emulator
1. Open Android Studio.
2. Go to `Run > Run 'app'`.
3. Select an existing emulator or create a new one if none exist.

### Run on a Physical Device
1. Connect your Android device to your computer via USB.
2. Ensure USB debugging is enabled on your device.
3. Go to `Run > Run 'app'` and select your device.

## Testing

### Unit Tests

To run unit tests:

1. Open the project in Android Studio.
2. Navigate to the `src/test/java` directory.
3. Right-click on the test files or directory and select `Run 'Tests in ...'`.

### Instrumented Tests

To run instrumented tests:

1. Open the project in Android Studio.
2. Navigate to the `src/androidTest/java` directory.
3. Right-click on the test files or directory and select `Run 'Tests in ...'`.

## Tools Used

- **Android Studio**: Integrated development environment for Android development.
- **Gradle**: Build automation system used to compile, build, and run tests.
- **JUnit**: Testing framework used for unit tests.
- **Espresso**: UI testing framework used for instrumented tests.

## Notes

- Ensure your Android Studio and dependencies are up to date to avoid any compatibility issues.
- The JSON data for lottery draws is located in the `assets` directory.
- If you encounter any issues, please feel free to open an issue on the GitHub repository.



