# Animal Kingdom Explorer

This README provides comprehensive documentation for the "Animal Kingdom Explorer" Android application project. It covers usage, features, technical details, project structure, contributing guidelines, licensing, and screenshots.

## Introduction

The "Animal Kingdom Explorer" Android application enables users to explore information about animals and species. It offers features for adding new animals and species to the database, leveraging modern Android development practices such as Hilt for dependency injection, Room for data persistence, Kotlin Flow and LiveData for managing UI-related data, ViewModel for handling UI-related logic, and the repository pattern for separating concerns.

## Usage

The application provides intuitive interfaces for adding new animals and species. Follow these steps to use the add operation feature:

1. Launch the application on your device or emulator.

2. Click on assignment 7 to go into the project

3. Navigate to the "Animal Details" or "Species Details" section.

4. Click on the FloatingActionButton (FAB) to add a new animal or species. 

5. Fill in the required information in the displayed dialog.

6. Click on the save button to insert the new animal or species into the database.

## Features

- **Add Operation for Animals:**
    - Add new animals with name, habitat, and diet information.
    - Validate user inputs and ensure all fields are filled before saving.
    - Utilize Kotlin Flow and LiveData for asynchronous database operations.

- **Add Operation for Species:**
    - Add new species with name and description information.
    - Validate user inputs and ensure all fields are filled before saving.
    - Utilize Kotlin Flow and LiveData for asynchronous database operations.

- **ViewModel and LiveData:**
    - Use ViewModel and LiveData to manage UI-related data.
    - Perform database operations asynchronously using Kotlin Flow and LiveData.

- **Repository Pattern:**
    - Implement the repository pattern to separate data access logic from the rest of the application.
    - Provide a clean and consistent API for accessing and manipulating data.

## Technical Details

- **Hilt:** Utilized for dependency injection, providing a standard way to manage dependencies and improve code maintainability.

- **Room Database:** Used for local data persistence, providing a robust and efficient solution for storing and managing application data.

- **Kotlin Flow:** Employed for asynchronous data streams, offering a modern and reactive approach to handling data flow in Android applications.

- **LiveData:** Used alongside Kotlin Flow for observing changes in data and updating the UI accordingly, ensuring a responsive and reactive user experience.

- **ViewModel:** Used to manage UI-related data and handle user interactions, ensuring separation of concerns and facilitating easier testing and maintenance.

- **Repository Pattern:** Implemented to abstract data access and provide a clean API for interacting with data sources, promoting code reuse and maintainability.

## Project Structure

The project follows a standard MVVM (Model-View-ViewModel) architecture with a modularized and organized structure. Here's an overview of the main components and directories:

- **assignment7**: Contains the main application module.
    - **di**: Houses dependency injection related classes, including Hilt modules.
    - **data**: Includes data-related classes such as repositories, data sources.
    - **model**: Includes data models.
    - **persistence**: Includes database configuration, data access layers.
    - **ui**: Contains UI-related components such as fragments, activities, adapters, and view models.
    - **res**: Contains resources such as layouts, drawables, strings, and other assets.

## Screenshots

Include screenshots of the application UI to give users a visual representation of the features and functionality.

![Screenshot 1](../screenshots/assignment7/assignment7.png)
