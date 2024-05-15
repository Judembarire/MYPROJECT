package net.ezra.ui.myplant





import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import net.ezra.R
import net.ezra.navigation.ROUTE_COMM
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_PLANT
import net.ezra.ui.community.CommScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantScreen(
    navController: NavHostController,
) {

    Scaffold(

        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    item() {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(
                                    shape = RoundedCornerShape(
                                        bottomEnd = 15.dp,
                                        bottomStart = 15.dp
                                    )
                                )

                        ) {
                            val context = LocalContext.current.applicationContext
                            TopAppBar(
                                title = { Text("Plantare") },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        Toast.makeText(
                                            context,
                                            "You have clicked a home Icon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }) {
                                        Image(
                                            modifier = Modifier
                                                .size(80.dp, 80.dp)
                                                .background(Color.Transparent)
                                                .clip(CircleShape),

                                            painter = painterResource(id = R.drawable.leaf),
                                            contentDescription = ""
                                        )
                                    }
                                },
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = Color(0x2C08F511),
                                    titleContentColor = Color.Black,
                                    navigationIconContentColor = Color.Black
                                ),
                                actions = {
                                    IconButton(onClick = {
                                        Toast.makeText(
                                            context,
                                            "You have clicked on the search Icon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }) {
                                        Icon(
                                            imageVector = Icons.Filled.Search,
                                            contentDescription = "search",
                                            tint = Color.White
                                        )
                                    }

                                    IconButton(onClick = {
                                        Toast.makeText(
                                            context,
                                            "You have clicked on the person Icon",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }) {
                                        Icon(
                                            imageVector = Icons.Filled.Person,
                                            contentDescription = "person",
                                            tint = Color.White
                                        )

                                    }
                                })
                        }

                        Spacer(modifier = Modifier.height(15.dp))


                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(5.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .padding(2.dp)
                                    .background(Color(0xffffffff))
                            ) {
                                Column {
                                    Row {
                                        Card(
                                            modifier = Modifier
                                                .width(230.dp)
                                                .height(100.dp),
                                            colors = CardDefaults.cardColors(Color(0x6D72FA78))

                                        ) {
                                            Row (
                                                modifier = Modifier
                                                    .width(200.dp)
                                                    .height(30.dp),

                                                ){

                                                Text(
                                                    "Triostar",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,

                                                    )
                                            }
                                            Row (
                                                modifier = Modifier
                                                    .width(200.dp)
                                                    .height(30.dp),

                                                ){

                                                Text(
                                                    "Location :Nairobi",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,

                                                    )
                                            }

                                            Row (
                                                modifier = Modifier
                                                    .width(200.dp)
                                                    .height(30.dp),

                                                ){

                                                Text(
                                                    "Contact:07844443",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,

                                                    )
                                            }
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.width(40.dp))

                                Column {
                                    Card(
                                        modifier = Modifier
                                            .width(107.dp)
                                            .height(90.dp),
                                        colors = CardDefaults.cardColors(Color(0xffffffff))

                                    ) {
                                        Image(
                                            modifier = Modifier
                                                .size(150.dp, 150.dp)
                                                .background(Color.Transparent)
                                                .clip(RoundedCornerShape(16.dp)),

                                            painter = painterResource(id = R.drawable.plant2),
                                            contentDescription = "",

                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                }
                            }
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(5.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .padding(2.dp)
                                    .background(Color(0xffffffff))
                            ) {
                                Column {
                                    Row {
                                        Card(
                                            modifier = Modifier
                                                .width(230.dp)
                                                .height(100.dp),
                                            colors = CardDefaults.cardColors(Color(0x6D72FA78))

                                        ) {
                                            Row (
                                                modifier = Modifier
                                                    .width(200.dp)
                                                    .height(30.dp),

                                            ){

                                            Text(
                                                "Spiderplant",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold,

                                            )
                                                }
                                            Row (
                                                modifier = Modifier
                                                    .width(200.dp)
                                                    .height(30.dp),

                                                ){

                                                Text(
                                                    "Location :kakamega",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,

                                                    )
                                            }

                                            Row (
                                                modifier = Modifier
                                                    .width(200.dp)
                                                    .height(30.dp),

                                                ){

                                                Text(
                                                    "Contact:07896543",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,

                                                    )
                                            }
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.width(40.dp))

                                Column {
                                    Card(
                                        modifier = Modifier
                                            .width(107.dp)
                                            .height(90.dp),
                                        colors = CardDefaults.cardColors(Color(0xffffffff))

                                    ) {
                                        Image(
                                            modifier = Modifier
                                                .size(150.dp, 150.dp)
                                                .background(Color.Transparent)
                                                .clip(RoundedCornerShape(16.dp)),

                                            painter = painterResource(id = R.drawable.spiderplant),
                                            contentDescription = "",

                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                }
                            }
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(5.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .padding(2.dp)
                                    .background(Color(0xffffffff))
                            ) {
                                Column {
                                    Row {
                                        Card(
                                            modifier = Modifier
                                                .width(230.dp)
                                                .height(100.dp),
                                            colors = CardDefaults.cardColors(Color(0x6D72FA78))

                                        ) {
                                            Row (
                                                modifier = Modifier
                                                    .width(200.dp)
                                                    .height(30.dp),

                                                ){

                                                Text(
                                                    "Spiderplant",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,

                                                    )
                                            }
                                            Row (
                                                modifier = Modifier
                                                    .width(200.dp)
                                                    .height(30.dp),

                                                ){

                                                Text(
                                                    "Location :Nairobi",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,

                                                    )
                                            }

                                            Row (
                                                modifier = Modifier
                                                    .width(200.dp)
                                                    .height(30.dp),

                                                ){

                                                Text(
                                                    "Contact:078911111",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,

                                                    )
                                            }
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.width(40.dp))

                                Column {
                                    Card(
                                        modifier = Modifier
                                            .width(107.dp)
                                            .height(90.dp),
                                        colors = CardDefaults.cardColors(Color(0xffffffff))

                                    ) {
                                        Image(
                                            modifier = Modifier
                                                .size(150.dp, 150.dp)
                                                .background(Color.Transparent)
                                                .clip(RoundedCornerShape(16.dp)),

                                            painter = painterResource(id = R.drawable.spiderplant),
                                            contentDescription = "",

                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                }
                            }
                        }


                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(5.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .padding(2.dp)
                                    .background(Color(0xffffffff))
                            ) {
                                Column {
                                    Row {
                                        Card(
                                            modifier = Modifier
                                                .width(230.dp)
                                                .height(100.dp),
                                            colors = CardDefaults.cardColors(Color(0x6D72FA78))

                                        ) {
                                            Row (
                                                modifier = Modifier
                                                    .width(200.dp)
                                                    .height(30.dp),

                                                ){

                                                Text(
                                                    "EnglishIvy",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,

                                                    )
                                            }
                                            Row (
                                                modifier = Modifier
                                                    .width(200.dp)
                                                    .height(30.dp),

                                                ){

                                                Text(
                                                    "Location :Meru",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,

                                                    )
                                            }

                                            Row (
                                                modifier = Modifier
                                                    .width(200.dp)
                                                    .height(30.dp),

                                                ){

                                                Text(
                                                    "Contact:078781111",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,

                                                    )
                                            }
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.width(40.dp))

                                Column {
                                    Card(
                                        modifier = Modifier
                                            .width(107.dp)
                                            .height(90.dp),
                                        colors = CardDefaults.cardColors(Color(0xffffffff))

                                    ) {
                                        Image(
                                            modifier = Modifier
                                                .size(150.dp, 150.dp)
                                                .background(Color.Transparent)
                                                .clip(RoundedCornerShape(16.dp)),

                                            painter = painterResource(id = R.drawable.plant6),
                                            contentDescription = "",

                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                }
                            }
                        }
                    }

                }
            }

        },

        bottomBar = { BottomBar(navController = navController)  }
    )

}






@Composable
fun BottomBar(navController: NavHostController) {

    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)),
        elevation = 10.dp
    )
    {
        BottomNavigationItem(icon = {
            androidx.compose.material.Icon(imageVector = Icons.Default.Home, "")
        },
            label = { androidx.compose.material.Text(text = "Home") },
            selected = (selectedIndex.value == 0),
            onClick = {
                navController.navigate(ROUTE_HOME) {
                    popUpTo(ROUTE_PLANT) { inclusive = true }
                }
            })
        BottomNavigationItem(icon = {
            androidx.compose.material.Icon(imageVector = Icons.Default.Favorite, "")
        },
            label = { androidx.compose.material.Text(text = "plants") },
            selected = (selectedIndex.value == 1),
            onClick = {
                navController.navigate(ROUTE_PLANT) {
                    popUpTo(ROUTE_PLANT) { inclusive = true }
                }
            })
        BottomNavigationItem(icon = {
            androidx.compose.material.Icon(imageVector = Icons.Default.Person, "")
        },
            label = { androidx.compose.material.Text(text = "Community") },
            selected = (selectedIndex.value == 2),
            onClick = {
                navController.navigate(ROUTE_COMM) {
                    popUpTo(ROUTE_PLANT) { inclusive = true }
                }
            })
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    PlantScreen(rememberNavController())
}









