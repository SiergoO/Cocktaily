# Cocktaily
A simple clean architecture app that allows users to explore a list of cocktails fetched from a public API. Users can view the details of each cocktail, including the preparation steps and ingredients, making it a convenient resource for cocktail enthusiasts and bartenders.

## Features
- Fetches the list of alcoholic cocktails from "theCocktailDB" API (https://www.thecocktaildb.com/api.php).
- Provides an extensive selection of alcoholic cocktails to choose from.
- Displays detailed preparation instructions and ingredients for each cocktail in a convenient and user-friendly manner.
- Implements the Material 3 color palette for a modern and visually appealing interface.

## Technologies and Approaches
- **Kotlin 100%**: The entire application is written in Kotlin, harnessing its modern features and advantages.
- **No XML layouts**: Instead of using XML layouts, the app leverages the power of Jetpack Compose.
- **Clean Architecture**: The app follows the principles of Clean Architecture.
- **MVI Pattern**: Cocktaily adopts the Model-View-Intent (MVI) pattern, which provides a unidirectional data flow and a clear separation of state and UI logic. It was decided not to use a feature module architecture because of the simplicity of the project and the large amount of common data for different potential features.
- **Dependency Injection**: The Koin library is used for dependency injection. It is pretty easy to use, understand and implement, especially for small projects.
- **Kotlin Coroutines**: The app utilizes Kotlin Coroutines for asynchronous and non-blocking programming, enhancing performance and responsiveness.
- **REST API Interaction**: Cocktaily communicates with a REST API to retrieve weather data, providing users with up-to-date information.

## Libraries and Frameworks Used
- **Jetpack Compose**: The modern UI toolkit that enables building beautiful and responsive user interfaces.
- **Kotlin Coroutines**: The Kotlin library for asynchronous programming and handling concurrency in a simplified manner.
- **Kotlin Serialization**: A library for serializing Kotlin objects to and from JSON.
- **Ktor**: A 100% Kotlin networking library used for making HTTP requests and interacting with the REST API regularly updated and with a bunch of additional and convenient functionality.
- **Koin**: A lightweight dependency injection framework for Kotlin.
- **OrbitMVI**: A library that facilitates the implementation of the MVI pattern in Android applications.
- **Splash screen**: A feature that displays an initial loading screen with branding elements while the app is loading.