package net.ezra.ui.add

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import net.ezra.navigation.ROUTE_ADD
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_PLANT
import java.util.UUID


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column ( modifier = Modifier
                    .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    val context = LocalContext.current.applicationContext
                    androidx.compose.material3.TopAppBar(
                        title = { Text(text = "Plantare") },
                        navigationIcon = {
                            androidx.compose.material3.IconButton(onClick = {
                                Toast.makeText(
                                    context,
                                    "You have clicked a home Icon",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }) {
                                Image(
                                    modifier = Modifier
                                        .size(100.dp, 100.dp)
                                        .background(Color.Transparent)
                                        .clip(CircleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ADD) { inclusive = true }
                                            }
                                        },

                                    painter = painterResource(id = net.ezra.R.drawable.leaf),
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
                            androidx.compose.material3.IconButton(onClick = {
                                Toast.makeText(
                                    context,
                                    "You have clicked on the search Icon",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }) {
                                androidx.compose.material3.Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = "search",
                                    tint = Color.White
                                )
                            }

                            androidx.compose.material3.IconButton(onClick = {
                                Toast.makeText(
                                    context,
                                    "You have clicked on the person Icon",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }) {
                                androidx.compose.material3.Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "person",
                                    tint = Color.White
                                )

                            }
                        })
                }
            }
            Column(

                modifier = Modifier.padding(15.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Text( "Product Details", fontSize = 30.sp)

                var photoUri: Uri? by remember { mutableStateOf(null) }
                val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                    photoUri = uri
                }

                var Name by rememberSaveable {
                    mutableStateOf("")
                }


                var location by rememberSaveable {
                    mutableStateOf("")
                }

                var price by rememberSaveable {
                    mutableStateOf("")
                }

                var contact by rememberSaveable {
                    mutableStateOf("")
                }



                OutlinedTextField(
                    value = Name,
                    onValueChange = { Name = it },
                    label = { Text(text = "product Name") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )



                OutlinedTextField(
                    value = location,
                    onValueChange = { location= it },
                    label = { Text(text = "location") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )

                OutlinedTextField(
                    value = price,
                    onValueChange = { price= it },
                    label = { Text(text = "price") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )




                OutlinedTextField(
                    value = contact,
                    onValueChange = { contact= it },
                    label = { Text(text = "contact") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()

                )




                if (photoUri != null) {
                    //Use Coil to display the selected image
                    val painter = rememberAsyncImagePainter(
                        ImageRequest
                            .Builder(LocalContext.current)
                            .data(data = photoUri)
                            .build()
                    )

                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(150.dp)
                            .fillMaxWidth()
                            .border(1.dp, Color.Gray),
                        contentScale = ContentScale.Crop,

                        )
                }


                OutlinedButton(onClick = {
                    photoUri?.let { uploadImageToFirebaseStorage(it, Name, location, price, contact,) }


                },
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFF386FFA)
                    ),

                    ) {

                    Text(text = "upload")


                }

                OutlinedButton(
                    onClick = {
                        launcher.launch(
                            PickVisualMediaRequest(
                                //Here we request only photos. Change this to .ImageAndVideo if you want videos too.
                                //Or use .VideoOnly if you only want videos.
                                mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                            )
                        )
                    }
                ) {
                    Text("Attach Image [REQUIRED]",
                        color = Color.Black
                    )
                }

            }

        }
    }
}










fun uploadImageToFirebaseStorage(imageUri: Uri, Name: String, location:String, price:String, contact:String) {
    val storageRef = FirebaseStorage.getInstance().reference
    val imageRef = storageRef.child("images/${UUID.randomUUID()}")

    val uploadTask = imageRef.putFile(imageUri)
    uploadTask.continueWithTask { task ->
        if (!task.isSuccessful) {
            task.exception?.let {
                throw it
            }
        }
        imageRef.downloadUrl
    }.addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val downloadUri = task.result
            saveToFirestore(downloadUri.toString(), Name, location, price, contact)
        } else {


        }
    }
}

fun saveToFirestore(imageUrl: String, Name: String, location:String, price:String, contact: String) {
    val db = Firebase.firestore
    val imageInfo = hashMapOf(
        "imageUrl" to imageUrl,
        "Name" to Name,
        "location" to location,
        "price" to price,
        "contact" to contact,

    )




    db.collection("Sell")
        .add(imageInfo)
        .addOnSuccessListener {



        }
        .addOnFailureListener {
            // Handle error
        }
}








