package net.ezra.ui.guide







import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_PLANT


@Composable
fun GuideScreen5( navController: NavHostController){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x1208F511))
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(shape = RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp))

            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent),

                    contentScale = ContentScale.Crop,

                    painter = painterResource(id = R.drawable.plant5),
                    contentDescription = ""
                )

            }

            Spacer(modifier = Modifier.height(7.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
            {
                Text(
                    "ZZ Plant",
                    fontSize = 25.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold

                )
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
            {
                Text(
                    " (Zamioculcas zamiifolia)",
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Light

                )
            }

            Spacer(modifier = Modifier.height(30.dp))


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
            {
                Text(
                    "Quick facts?",
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Light

                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .padding(2.dp)
                ) {
                    Spacer(modifier = Modifier.width(40.dp))

                    Column{
                        Card(
                            modifier = Modifier
                                .width(130.dp)
                                .height(150.dp),
                            colors = CardDefaults.cardColors(Color(0xffffffff))

                        ) {
                            Text(
                                text = "Height",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )

                            Image(
                                modifier = Modifier
                                    .size(60.dp, 60.dp)
                                    .background(Color.Transparent)
                                    .clip(RoundedCornerShape(16.dp)),

                                painter = painterResource(id = R.drawable.height),
                                contentDescription = ""
                            )
                            Text(
                                text = "2 - 3 ft",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )

                        }

                    }

                    Spacer(modifier = Modifier.width(40.dp))

                    Column{
                        Card(
                            modifier = Modifier
                                .width(120.dp)
                                .height(150.dp),
                            colors = CardDefaults.cardColors(Color(0xffffffff))

                        ) {
                            Text(
                                text = "Water",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )

                            Image(
                                modifier = Modifier
                                    .size(60.dp, 60.dp)
                                    .background(Color.Transparent)
                                    .clip(RoundedCornerShape(16.dp)),

                                painter = painterResource(id = R.drawable.water),
                                contentDescription = ""
                            )
                            Text(
                                text = " 2 - 3 inches ",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                    }
                }
            }


            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .padding(2.dp)
                ) {
                    Spacer(modifier = Modifier.width(40.dp))

                    Column{
                        Card(
                            modifier = Modifier
                                .width(130.dp)
                                .height(150.dp),
                            colors = CardDefaults.cardColors(Color(0xffffffff))

                        ) {
                            Text(
                                text = "Sun",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )

                            Image(
                                modifier = Modifier
                                    .size(60.dp, 60.dp)
                                    .background(Color.Transparent)
                                    .clip(RoundedCornerShape(16.dp)),

                                painter = painterResource(id = R.drawable.sun),
                                contentDescription = ""
                            )
                            Text(
                                text = "   tolerate lower indirect light",
                                fontSize = 17.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )

                        }

                    }

                    Spacer(modifier = Modifier.width(40.dp))

                    Column{
                        Card(
                            modifier = Modifier
                                .width(120.dp)
                                .height(150.dp),
                            colors = CardDefaults.cardColors(Color(0xffffffff))

                        ) {
                            Text(
                                text = "Soil",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )

                            Image(
                                modifier = Modifier
                                    .size(60.dp, 60.dp)
                                    .background(Color.Transparent)
                                    .clip(RoundedCornerShape(16.dp)),

                                painter = painterResource(id = R.drawable.soil),
                                contentDescription = ""
                            )
                            Text(
                                text = " well drained ",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.SemiBold,

                                )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(Color(0xffffffff))
                    .padding(10.dp)
            ) {

                Text(text = "he Zamioculcas zamiifolia, or ZZ Plant, is a tropical perennial native to Eastern Africa. It has become popular worldwide in recent years due to its tolerance of a wide range of conditions—a highly dependable houseplant, it can tolerate low light and has low water requirements. ",
                    fontSize = 19.sp,
                    fontFamily = FontFamily.Default,

                    )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { navController.navigate(ROUTE_PLANT) },
                    modifier = Modifier
                        .width(300.dp)



                ) {
                    Text(
                        text = "SHOP FOR -->",


                        )
                }

            }

        }
    }
}





