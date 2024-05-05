package com.example.coursesgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coursesgrid.data.DataSource
import com.example.coursesgrid.model.Topic
import com.example.coursesgrid.ui.theme.CoursesGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesGridApp()
        }
    }
}
@Composable
fun CoursesGridApp(){
    CoursesGridTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val topics = DataSource.topics
            CoursesGrid(topics = topics)
        }
    }
}

@Composable
fun CoursesGrid(modifier: Modifier = Modifier,
                topics:List<Topic>){
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 160.dp)) {
        items(topics){topic ->
            CoursesCard(course = topic,
                modifier = modifier)
        }
    }
}


@Composable
fun CoursesCard(modifier :Modifier = Modifier,
                course: Topic){
    Card(modifier = modifier.padding(8.dp)) {
        Row(
           // modifier.height(60.dp)
        ) {
            Image(painter = painterResource(id = course.imageSrc),
                contentDescription = stringResource(id = course.name),
                contentScale = ContentScale.FillHeight,
                modifier = modifier.size(68.dp))

            Column(
                modifier = modifier
                    .padding(horizontal = 16.dp)
                    .height(68.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(text = stringResource(id = course.name),
                    style = MaterialTheme.typography.bodyMedium)
                Row(
                    modifier = modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription ="grain icon" ,
                        tint = Color.Black,
                        modifier = modifier.size(20.dp))
                    Text(text = course.count.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier= modifier.padding(start = 4.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun CourseCardPreview(){
    CoursesCard(
        course = Topic(
            name = R.string.photography,
            imageSrc = R.drawable.photography,
            count = 321
        )
    )
}
