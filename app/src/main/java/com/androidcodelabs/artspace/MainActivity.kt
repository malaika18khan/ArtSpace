package com.androidcodelabs.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidcodelabs.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {

    var currentImage by remember { mutableStateOf(1) }

    Column(modifier = Modifier){

        when (currentImage) {
            1 -> {
                Column(
                    modifier = Modifier
                        .padding(35.dp)

                ) {
                    Surface(
                        shadowElevation = 30.dp
                    ) {
                        ImageCard(R.drawable.vincent_guth_2016, R.string.pic_one_cd)
                    }
                }
                InfoBlock(R.string.artist_one, R.string.year_one)
                BtnBlock(onPrevious = {
                    currentImage = 6
                },
                    onNext = {
                        currentImage = 2
                    }
                )
            }
            2 -> {
                Column(
                    modifier = Modifier
                        .padding(35.dp)

                ) {
                    Surface(
                        shadowElevation = 30.dp
                    ) {
                        ImageCard(R.drawable.dave_2020, R.string.pic_two_cd)
                    }
                }
                InfoBlock(R.string.artist_two, R.string.year_two)
                BtnBlock(
                    onPrevious = {
                        currentImage = 1
                    },
                    onNext = {
                        currentImage = 3
                    }
                )
            }
            3 -> {
                Column(
                    modifier = Modifier
                        .padding(35.dp)

                ) {
                    Surface(
                        shadowElevation = 30.dp
                    ) {
                        ImageCard(R.drawable.nathan_anderson_2017, R.string.pic_three_cd)
                    }
                }
                InfoBlock(R.string.artist_three, R.string.year_three)
                BtnBlock(
                    onPrevious = {
                        currentImage = 2
                    },
                    onNext = {
                        currentImage = 4
                    }
                )
            }
            4 -> {
                Column(
                    modifier = Modifier
                        .padding(35.dp)

                ) {
                    Surface(
                        shadowElevation = 30.dp
                    ) {
                        ImageCard(R.drawable.peter_jan_rijpkema_2019, R.string.pic_four_cd)
                    }
                }
                InfoBlock(R.string.artist_four, R.string.year_four)
                BtnBlock(
                    onPrevious = {
                        currentImage = 3
                    },
                    onNext = {
                        currentImage = 5
                    }
                )
            }
            5 -> {
                Column(
                    modifier = Modifier
                        .padding(35.dp)

                ) {
                    Surface(
                        shadowElevation = 30.dp
                    ) {
                        ImageCard(R.drawable.riley_2020, R.string.pic_five_cd)
                    }
                }
                InfoBlock(R.string.artist_five, R.string.year_six)
                BtnBlock(
                    onPrevious = {
                        currentImage = 4
                    },
                    onNext = {
                        currentImage = 6
                    }
                )
            }
            6 -> {
                Column(
                    modifier = Modifier
                        .padding(35.dp)

                ) {
                    Surface(
                        shadowElevation = 30.dp
                    ) {
                        ImageCard(R.drawable.khamkeo_vilaysing_2018, R.string.pic_six_cd)
                    }
                }
                InfoBlock(R.string.artist_six, R.string.year_six)
                BtnBlock(onPrevious = {
                    currentImage = 5
                },
                    onNext = {
                        currentImage = 1
                    })
            }
    }

    }

}
@Composable
fun ImageCard(imageID: Int, contentDesc: Int) {
    Image(
        painter = painterResource(imageID),
        contentDescription = stringResource(id = contentDesc),
        modifier = Modifier
            .padding(30.dp)
            .fillMaxWidth()
            .size(150.dp, 400.dp)
    )
}

@Composable
fun InfoBlock(artist: Int, year: Int) {
    Column(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 10.dp)
            .background(color = colorResource(id = R.color.info_bg))
            .fillMaxWidth()
    ) {
        val provider = GoogleFont.Provider(
            providerAuthority = "com.google.android.gms.fonts",
            providerPackage = "com.google.android.gms",
            certificates = R.array.com_google_android_gms_fonts_certs
        )

        val fontName = GoogleFont("Lobster Two")

        val fontFamily = FontFamily(
            Font(googleFont = fontName, fontProvider = provider)
        )
        Text(
            text = stringResource(id = artist),
            fontFamily = fontFamily,
            fontSize = 30.sp,
            //fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp)
        )
        Text(
            text = stringResource(id = year),
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp)
        )
    }

}

@Composable
fun BtnBlock(onPrevious: () -> Unit, onNext: () -> Unit) {
    Column() {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Button(
                onClick = onPrevious,
                modifier = Modifier
                    .width(120.dp)

            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = onNext,
                modifier = Modifier.width(120.dp)
            ) {
                Text(text = "Next")

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}