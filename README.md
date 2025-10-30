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
```kotlin

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

📁 Project Structure

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




