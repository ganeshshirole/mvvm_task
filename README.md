Android Kotlin MVVM Example
This is a simple Android application demonstrating the MVVM architecture pattern using Kotlin.

Features
MVVM Architecture: Separation of concerns using Model-View-ViewModel pattern.
LiveData: Lifecycle-aware observable data holder class.
ViewModel: Store and manage UI-related data in a lifecycle-conscious way.
Coroutines: For managing background threads with simplified code and reducing needs for callbacks.
Retrofit: Type-safe HTTP client for Android and Java.
Repository Pattern: Abstracts the data sources from the rest of the application.
Modules
The project is structured as follows:

app: Contains the UI (View) layer, including activities, fragments, and adapters.
data: Implements the Repository pattern and provides data from various sources (e.g., network, local).
domain: Defines the business logic and data models (entities) used in the application.
presentation: Implements ViewModels and exposes LiveData to be used by the UI layer.
Libraries Used
Android Architecture Components: ViewModel, LiveData
Retrofit & OkHttp for REST API communication
Coroutines for asynchronous programming
Gson for JSON serialization/deserialization
Glide for image loading
Requirements
Android Studio Arctic Fox (or newer)
Android SDK version 21+
Kotlin version 1.5.0+
