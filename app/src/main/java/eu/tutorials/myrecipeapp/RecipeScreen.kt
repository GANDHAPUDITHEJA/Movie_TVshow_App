package eu.tutorials.myrecipeapp

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(modifier: Modifier = Modifier,
                 viewstate:MainViewModel.RecipeState
                 ,navigateToDetail:(Category)->Unit){
    val recipeViewModel: MainViewModel = viewModel()
    Box(modifier = Modifier.fillMaxSize()){
        when{
            viewstate.loading ->{
                ShimmerLayout()
            }

            viewstate.error != null ->{
                Text("ERROR OCCURRED")
            }
            else ->{
                CategoryScreen(categories = viewstate.list,navigateToDetail )
            }
        }
    }
}

@Composable
fun CategoryScreen(categories: List<Category>,navigateToDetail: (Category) -> Unit){
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(categories){
                category ->
            CategoryItem(category = category,navigateToDetail)
        }
    }
}

@Composable
fun CategoryItem(category: Category,navigateToDetail: (Category) -> Unit){
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize().clickable { navigateToDetail(category) },
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )
        Text(
            text = category.strCategory,
            color = Color.White,
            style = TextStyle(fontWeight = FontWeight.Bold),
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun ShimmerLayout() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(10) {
            ShimmerCategoryItem()
        }
    }
}

@Composable
fun ShimmerCategoryItem() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Shimmer for image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shimmerEffect()
        )
        // Shimmer for text
        Box(
            modifier = Modifier
                .padding(top = 4.dp)
                .fillMaxWidth(0.6f)
                .height(20.dp)
                .shimmerEffect()
        )
    }
}

// Add this shimmer effect modifier function
@Composable
fun Modifier.shimmerEffect(): Modifier {
    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val brush = Brush.linearGradient(
        colors = listOf(
            Color.LightGray.copy(alpha = 0.6f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.6f)
        ),
        start = Offset(translateAnim, translateAnim),
        end = Offset(translateAnim + 500f, translateAnim + 500f)
    )

    return this.then(
        Modifier.background(brush = brush, shape = RoundedCornerShape(8.dp))
    )
}