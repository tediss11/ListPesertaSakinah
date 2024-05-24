package com.example.listpesertasakinah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listpesertasakinah.data.Peserta
import com.example.listpesertasakinah.data.parapeserta
import com.example.listpesertasakinah.ui.theme.ListPesertaSakinahTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListPesertaSakinahTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ListPesertaSakinahApp()
                }

            }
        }
    }
}

@Composable
fun ListPesertaSakinahApp(){
    Scaffold (
        modifier = Modifier

        ,
        topBar = {
            ListPesertaSakinahTopAppBar()
        },
        bottomBar = {
            BottomNavigation()
        }
    ) { it ->
        LazyColumn (
            contentPadding = it){
            items(parapeserta){
                PesertaItem(peserta = it,
                            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }

    }
}

@Composable
fun PesertaItem(
    peserta: Peserta,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier) {
        Column(
            modifier = Modifier

        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                PesertaIcon(peserta.imageResourceId)
                PesertaInformation(peserta.name, peserta.number, peserta.age, peserta.place_of_birth )
                Spacer(modifier = Modifier.weight(1f))
                PesertaItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )

            }
        }
    }
}

@Composable
private fun PesertaItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(R.drawable.icons8_forward_50), contentDescription = "",
            tint = MaterialTheme.colorScheme.secondary

        )

    }

}

@Composable
fun PesertaIcon(
    @DrawableRes pesertaIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(pesertaIcon),
        contentDescription = null
    )
}

@Composable
fun PesertaInformation(
    @StringRes pesertaName: Int,
    @StringRes pesertaNumber: Int,
    pesertaAge: Int,
    @StringRes pesertaTl: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row (modifier = modifier){
            Text(
                fontWeight = FontWeight.Bold,
                text = stringResource(pesertaName),
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                fontWeight = FontWeight.Bold,
                text = stringResource(pesertaNumber),
                style = MaterialTheme.typography.titleMedium,

            )

        }

        Row (modifier = Modifier) {

            Text(
                text = stringResource(R.string.age, pesertaAge),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = modifier.size(5.dp))

            Text(
                text = stringResource(R.string.dot, pesertaAge),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = modifier.size(5.dp))

            Text(
                text = stringResource(pesertaTl),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPesertaSakinahTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Column (
                modifier = Modifier

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        fontWeight = FontWeight.Bold,
                        text = stringResource(R.string.title),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        painter = painterResource(R.drawable.page_info_24dp_fill0_wght400_grad0_opsz24), contentDescription = "",
                        Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
//                Spacer(modifier = modifier.size(5.dp))
                Text(
                    text = stringResource(R.string.information),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray

                )
            }

        },
        modifier = modifier
    )
}

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                imageVector = Icons.Default.Home, contentDescription = "",
                tint = Color.Gray
            )
            Text(
                textAlign = TextAlign.Center,
                text = "Home",
                color = Color.Gray,
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                imageVector = Icons.Default.Search, contentDescription = "",
                tint = Color.Gray
            )
            Text(
                textAlign = TextAlign.Center,
                text = "Search",
                color = Color.Gray,
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                imageVector = Icons.Default.Person, contentDescription = "",
                tint = Color.Gray
            )
            Text(
                textAlign = TextAlign.Center,
                text = "Profile",
                color = Color.Gray,
            )
        }
    }
}

@Preview
@Composable
fun ListPesertaSakinahPreview (){
    ListPesertaSakinahTheme (darkTheme = false){
        ListPesertaSakinahApp()

    }
}

@Preview
@Composable
fun ListPesertaSakinahDarkThemePreview() {
    ListPesertaSakinahTheme(darkTheme = true) {
        ListPesertaSakinahApp()

    }

}
