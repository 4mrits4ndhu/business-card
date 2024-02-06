package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF073030)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val image = painterResource(R.drawable.android_logo)
        Spacer(modifier = Modifier.padding(bottom = 150.dp))
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(0.3f)
        )


        Text(text = stringResource(R.string.my_name), fontSize = 40.sp, color = Color.White)
        Text(text = stringResource(R.string.my_title), fontSize = 15.sp, color = Color.Green)
        Spacer(modifier = Modifier.padding(bottom = 200.dp))
        Divider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))
        ContactRow(
            text = stringResource(R.string.my_phone_number),
            textBlur = 5.dp,
            icon = Icons.Rounded.Phone
        )
        Divider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))
        ContactRow(
            text = stringResource(R.string.linkedin_handle),
            icon = Icons.Rounded.Share
        )
        Divider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))
        ContactRow(
            text = stringResource(R.string.my_email),
            icon = Icons.Rounded.Email
        )
    }
}

@Composable
fun ContactRow(
    text: String,
    icon: ImageVector,
    textBlur: Dp = 0.dp
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Green,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = text,
            color = Color.Black,
            modifier = Modifier.weight(3f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF073042)
    ) {
        BusinessCardTheme {
            BusinessCard()
        }
    }
}
