package eu.tutorials.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Creates a Retrofit instance, which is responsible for handling API requests and responses
private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/") // Base URL of the API
    .addConverterFactory(GsonConverterFactory.create())  // Adds a Gson converter to automatically parse JSON data into Kotlin objects
    .build()

// Creates an instance of the ApiService interface to make API requests
val recipeService = retrofit.create(ApiService::class.java)

// Defines an interface for the API service
// The Retrofit library will generate the implementation of this interface automatically
interface ApiService {

    // This function is used to fetch recipe categories from the API
    // @GET specifies that it's an HTTP GET request, and the endpoint is "categories.php"
    // suspend keyword makes this function a suspending function to be called from a coroutine
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse  // The function returns a CategoriesResponse, which should match the structure of the API response
}
