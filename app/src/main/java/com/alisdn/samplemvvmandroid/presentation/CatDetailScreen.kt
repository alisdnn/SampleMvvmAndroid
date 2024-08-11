package com.alisdn.samplemvvmandroid.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.alisdn.samplemvvmandroid.domain.CatViewModel

@Composable
fun CatDetailScreen(
    viewModel: CatViewModel = hiltViewModel(),
    catId: String?
) {
    val cats by viewModel.cats.collectAsState()
    val cat = cats.find { it.id == catId }

    Scaffold { innerPadding ->

    if (cat != null) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
                    .padding(bottom = innerPadding.calculateBottomPadding())
            ) {
                Image(
                    painter = rememberImagePainter(cat.url),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(32.dp)
                        .fillMaxWidth()
                        .aspectRatio(1f)
                )

                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Cat ID: ")
                        }
                        append(cat.id)
                    }
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Dimensions: ")
                        }
                        append("${cat.width}x${cat.height}")
                    }
                )

                if (!cat.breeds.isNullOrEmpty()) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Weight: ")
                            }
                            append("Imperial: ${cat.breeds[0].weight?.imperial}, Metric: ${cat.breeds[0].weight?.metric}")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("ID: ")
                            }
                            append(cat.breeds[0].id)
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Name: ")
                            }
                            append(cat.breeds[0].name)
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Vetstreet URL: ")
                            }
                            append(cat.breeds[0].vetstreet_url)
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Temperament: ")
                            }
                            append(cat.breeds[0].temperament)
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Origin: ")
                            }
                            append(cat.breeds[0].origin)
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Country Codes: ")
                            }
                            append(cat.breeds[0].country_codes)
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Country Code: ")
                            }
                            append(cat.breeds[0].country_code)
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Description: ")
                            }
                            append(cat.breeds[0].description)
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Life Span: ")
                            }
                            append("${cat.breeds[0].life_span} years")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Indoor: ")
                            }
                            append(if (cat.breeds[0].indoor == 1) "Yes" else "No")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Lap: ")
                            }
                            append(if (cat.breeds[0].lap == 1) "Yes" else "No")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Alternative Names: ")
                            }
                            append(cat.breeds[0].alt_names?.ifEmpty { "None" })
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Adaptability: ")
                            }
                            append("${cat.breeds[0].adaptability}")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Affection Level: ")
                            }
                            append("${cat.breeds[0].affection_level}")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Child Friendly: ")
                            }
                            append("${cat.breeds[0].child_friendly}")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Dog Friendly: ")
                            }
                            append("${cat.breeds[0].dog_friendly}")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Energy Level: ")
                            }
                            append("${cat.breeds[0].energy_level}")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Grooming: ")
                            }
                            append("${cat.breeds[0].grooming}")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Health Issues: ")
                            }
                            append("${cat.breeds[0].health_issues}")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Intelligence: ")
                            }
                            append("${cat.breeds[0].intelligence}")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Shedding Level: ")
                            }
                            append("${cat.breeds[0].shedding_level}")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Social Needs: ")
                            }
                            append("${cat.breeds[0].social_needs}")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Stranger Friendly: ")
                            }
                            append("${cat.breeds[0].stranger_friendly}")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Vocalisation: ")
                            }
                            append("${cat.breeds[0].vocalisation}")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Experimental: ")
                            }
                            append(if (cat.breeds[0].experimental == 1) "Yes" else "No")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Hairless: ")
                            }
                            append(if (cat.breeds[0].hairless == 1) "Yes" else "No")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Natural: ")
                            }
                            append(if (cat.breeds[0].natural == 1) "Yes" else "No")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Rare: ")
                            }
                            append(if (cat.breeds[0].rare == 1) "Yes" else "No")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Rex: ")
                            }
                            append(if (cat.breeds[0].rex == 1) "Yes" else "No")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Suppressed Tail: ")
                            }
                            append(if (cat.breeds[0].suppressed_tail == 1) "Yes" else "No")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Short Legs: ")
                            }
                            append(if (cat.breeds[0].short_legs == 1) "Yes" else "No")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Wikipedia URL: ")
                            }
                            append(cat.breeds[0].wikipedia_url)
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Hypoallergenic: ")
                            }
                            append(if (cat.breeds[0].hypoallergenic == 1) "Yes" else "No")
                        }
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Reference Image ID: ")
                            }
                            append(cat.breeds[0].reference_image_id)
                        }
                    )


                }
            }
        } else {
            Text(text = "Cat not found")
        }
    }

}
