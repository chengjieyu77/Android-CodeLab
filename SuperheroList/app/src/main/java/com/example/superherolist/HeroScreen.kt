package com.example.superherolist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.example.superherolist.model.Hero
import com.example.superherolist.model.HeroesRepository
import com.example.superherolist.ui.theme.Shapes

@Composable
fun HeroScreen(modifier: Modifier = Modifier){
    val superHeroList = HeroesRepository.heroes
    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp),

    ) {
        items(superHeroList){hero->
            CardItem(hero = hero)
            Spacer(modifier = modifier.height(8.dp))
        }
    }
}

@Preview
@Composable
fun CardItem(hero: Hero = Hero(
    nameRes = R.string.hero1,
    descriptionRes = R.string.description1,
    imageRes = R.drawable.android_superhero1
),
             modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .clip(Shapes.medium)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth()
                .padding(16.dp),
           verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = modifier.weight(1f)) {
                Text(text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall)
                Text(text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 2
                )
            }
            //Spacer(modifier = modifier.width(16.dp))
            Image(painter = painterResource(id = hero.imageRes),
                contentDescription = "hero picture",
                modifier = modifier
                    .clip(Shapes.small)
                    .requiredSize(72.dp)

            )
        }
    }
}