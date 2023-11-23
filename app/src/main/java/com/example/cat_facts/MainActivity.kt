package com.example.cat_facts

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cat_facts.models.CatFacts
import com.example.cat_facts.models.Post
import com.example.cat_facts.models.PostItem
import com.example.cat_facts.models.User
import com.example.cat_facts.ui.theme.Cat_factsTheme
import com.example.cat_facts.utils.RetrofitInstance
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

class MainActivity : ComponentActivity() {


    @OptIn(DelicateCoroutinesApi::class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cat_factsTheme {
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .clickable { sendRequest() }

                ) {

                    sendRequest()
//                    var fact by remember {
//                        mutableStateOf(CatFacts())
//                    }
//                    val scope = rememberCoroutineScope()


                    factsss(click = { sendRequest() })
                }
            }
        }


    }

    private fun sendRequest() {
        GlobalScope.launch(Dispatchers.IO) {

            val response =
                RetrofitInstance.dummyData.getRandomPosts(
                    User(
                        email = "dsfd",
                        name = "sfsd",
                        password = "sdfd"
                    )
                )



            if (response.isSuccessful && response.body() != null) {
                withContext(Dispatchers.Main)
                {
                    Toast.makeText(
                        applicationContext,
                        response.body().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}

@Composable
fun factsss(click: () -> Unit) {
    Button(onClick = click) {

    }
}
