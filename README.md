# Movie & TV Show Discovery App

A modern Android app built with Jetpack Compose for discovering movies and TV shows using Watchmode API.

## ✨ Features

- **Dual Content**: Browse both movies and TV shows with tab navigation
- **Modern UI**: Jetpack Compose with Material Design 3
- **Smooth Loading**: Custom shimmer effects during data fetch
- **Error Handling**: User-friendly error states with retry options
- **Clean Architecture**: MVVM with repository pattern

## 🛠️ Tech Stack

- **Kotlin** - Programming language
- **Jetpack Compose** - Declarative UI
- **Retrofit & Coroutines** - Networking
- **Koin** - Dependency Injection
- **Coil** - Image loading
- **Navigation Compose** - In-app navigation


## 📱 Screens

### Home Screen
- Tab layout (Movies/TV Shows)
- Grid/List view with posters
- Shimmer loading animation
- Error handling with retry

### Details Screen
- Title information
- Poster display
- Metadata (year, type, rating)

## 🔧 Installation

1. Clone repository
2. Get API key from [Watchmode](https://www.watchmode.com/)
3. Add key in `TitleRepository.kt`:


📁 Project Structure

```kotlin
app/src/main/java/com/example/moviediscovery/
├── data/
│   ├── models/          # Data classes
│   ├── repository/      # Data layer
│   └── network/         # API service
├── presentation/
│   └── viewmodels/      # Business logic
├── ui/
│   ├── screens/         # Composable screens
│   └── components/      # UI components
└── di/                  # Dependency injection
```

🚀 Key Components
Data Model

```
data class Title(
    val id: String,
    val title: String,
    val type: TitleType,
    val year: Int?,
    val poster: String?
)
```
📦 Dependencies
```
// Core
implementation("androidx.core:core-ktx:1.12.0")
implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")

// Compose
implementation("androidx.activity:activity-compose:1.8.0")
implementation(platform("androidx.compose:compose-bom:2023.10.01"))

// Networking
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")

// DI
implementation("io.insert-koin:koin-android:3.5.0")

// Image Loading
implementation("io.coil-kt:coil-compose:2.4.0")
```

🔄 API Integration
Parallel API calls for movies and TV shows

Coroutines for asynchronous operations

Robust error handling

Type-safe API responses

🎯 Performance Features
Efficient Compose recomposition

Image caching with Coil

Lifecycle-aware coroutines

Minimal state updates


