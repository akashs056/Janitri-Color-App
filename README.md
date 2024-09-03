# Color List Application

This application demonstrates the use of Jetpack Compose for building a UI, following the MVVM architecture pattern, and integrating local and cloud databases for storing and syncing color data.

## Features

- **Display Colors List Screen:**
  - Implemented a screen to display a list of colors using Jetpack Compose.
  - Designed according to the specifications provided in the [Figma link](https://www.figma.com/design/8CKetBfN4eKMr51RLa796l/Android-Task---Intern?node-id=0-1&node-type=CANVAS&t=mfvu6f7ge3JGQa6f-0).

- **MVVM Architecture Pattern:**
  - Applied the MVVM architecture pattern to separate concerns and manage UI-related data in a lifecycle-conscious way.
  - Utilized ViewModel to handle UI-related data and business logic.

- **Cloud Database Integration:**
  - Integrated Firebase Firestore Database for cloud storage of color data.

- **Offline Support with RoomDB:**
  - Implemented Room Database to store color data locally for offline access.
  - Ensured that the color list is displayed even without internet connectivity by retrieving data from RoomDB.

- **Add Color Functionality:**
  - Added functionality to generate and store a new random color with parameters `{ color : “#AABBFF” , time : 1683798291864 }` in the local RoomDB upon clicking the “Add Color” button.
  - Used Jetpack Compose’s `FloatingActionButton` for adding new colors.

- **Sync Data with Server:**
  - Implemented a “Sync” button to send the entries of colors from the local RoomDB to Firebase Firestore Database.
  - Ensured that the local database is updated after successful synchronization.

- **Pending Count Display:**
  - Displayed the number of pending entries beside the sync icon.
  - Updated this count dynamically every time data is synced with the server.

- **Dependency Injection:**
  - Utilized Hilt for dependency injection to manage ViewModel and Repository instances.
  - Ensured better performance and scalability by providing dependencies in a modular and testable manner.

## Dependencies

- **Jetpack Compose** for UI development.
- **Room Database** for local storage.
- **Firebase Realtime Database** for cloud storage.
- **Hilt** for dependency injection.

## Setup Instructions

1. **Clone the Repository:**
    ```bash
    git clone https://github.com/akashs056/Jantri-Color-App.git
    cd Jantri-Color-App
    ```

2. **Add Firebase Configuration:**
    - Download the `google-services.json` file from your Firebase project.
    - Place the `google-services.json` file in the `app` directory of your project.

3. **Sync Gradle:**
    - Open the project in Android Studio.
    - Sync the Gradle files to ensure all dependencies are resolved.

4. **Run the Application:**
    - Build and run the application on an emulator or physical device.
