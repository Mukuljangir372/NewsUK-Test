## NewsUK Test

### Project UI Requirements
- [x] Display list of coins and details.
- [x] Order entries alphabetically by name.
- [x] Display a divider between each entry.
- [x] Display any extra coin info in some kind of popup/fragment.
- [x] Provide some kind of refresh option that reloads the list.
- [x] Display an error message if the list cannot be loaded (e.g. no network)
- [x] Animate list items


### Project Essential Requirements
- [x] Written the app using Kotlin only
- [x] Used Jetpack Compose for UI
- [x] Used Kotlin Coroutines
- [x] Written unit tests for repository and viewmodels
- [x] Avoided using any 3rd party libraries
- [x] Delivered final project via Git


### Architecture
1. Model View View Model - Stores data and updates the views and models accordingly.
2. Clean architecture - Data, Domain, Presentation - VM and UI layers.


### Libraries And Frameworks
1. Kotlin - Language used in android apps.
2. Jetpack Compose - Jetpack Compose is Android’s modern toolkit for building native UI.
3. Kotlin Coroutines - Fetching async data along flow.
4. Kotlin Coroutines Flow - A cold asynchronous data stream that sequentially emits values.
6. ViewModel - Stores UI-related data that isn't destroyed on UI changes.
7. Dependency Injection (DI) - Hilt - Easier way to incorporate Dagger DI into Android apps.
8. Retrofit - A type-safe HTTP client for Android and Java.
9. Room - For caching data within the app
11. Mockito - Mocking object injections, unit testing the viewmodel and repositories
