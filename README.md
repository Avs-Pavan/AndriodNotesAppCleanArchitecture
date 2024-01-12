# Android Notes App - Clean Architecture with Hilt, MVVM, and Room DB

## Overview

This Android Notes App is designed with a clean architecture approach, incorporating Hilt for dependency injection, MVVM for the presentation layer, and Room DB for local data storage. The project structure follows a modular organization for better maintainability and scalability.

## Project Structure

The project structure is organized into different modules to separate concerns and promote a clean architecture design:

- **app**: Contains the main components of the application, including the `MainActivity` and the `NoteApp` class.
  
- **commons**: Holds common utilities, constants, exceptions, and mappers used across different modules.
  - *Constants.kt*: Defines application-wide constants.
  - *exceptions*: Contains custom exceptions like `InvalidNoteException`.
  - *mappers*: Includes mappers for converting between different data representations.

- **data**: Manages data-related components, including local data sources and repositories.
  - *localdatasource*: Contains Room Database-related components such as `NoteDao`, `NoteDataBase`, and `NoteEntity`.
  - *repository*: Houses the `NoteRepository` responsible for coordinating data operations.

- **di**: Handles Dependency Injection modules using Hilt.
  - *AppModule.kt*: Provides application-level dependencies.
  - *RepositoryModule.kt*: Handles repository-level dependencies.
  - *UseCaseModule.kt*: Manages use case-level dependencies.

- **domain**: Represents the domain layer containing business logic, models, repository interfaces, and use cases.
  - *model*: Defines the data models, such as `Note`.
  - *repository*: Contains the repository interface `INoteRepository`.
  - *usecases*: Includes use cases for adding, deleting, and retrieving notes.

- **presentation**: Implements the MVVM architecture for the presentation layer.
  - *NotesViewModel.kt*: Manages UI-related data and communicates with the domain layer.
  - *screens*: Contains different UI screens, such as `NoteListScreen`.
  - *components*: Includes reusable UI components like `AddNotesBottomSheet` and `NoteCard`.
  - *state*: Defines the state management classes, like `NotesState`.

- **ui**: Manages UI-related resources, such as themes and colors.
  - *theme*: Defines the color, theme, and type resources for the UI.

## Getting Started

To get started with the project, follow these steps:

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the application on an emulator or physical device.

## Dependencies

The project relies on the following major dependencies:

- Hilt for dependency injection.
- Room DB for local data storage.
- ViewModel and LiveData for UI-related data management.

Make sure to check the individual module's build.gradle files for a comprehensive list of dependencies.

## Contribution Guidelines

If you would like to contribute to the project, please follow the contribution guidelines provided in the CONTRIBUTING.md file.

## License

This project is licensed under the [MIT License](LICENSE.md).

## Acknowledgments

Special thanks to all contributors and open-source projects that made this application possible.

Happy coding!
