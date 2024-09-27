package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.Teal

@Preview(showSystemUi = true)
@Composable
fun ImageGraphics(){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(Modifier.fillMaxWidth().background(Teal).height(50.dp).border(width = 1.dp, Color.Black),contentAlignment = Alignment.Center){
            Text("Image and Graphics",Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
                fontSize = 23.sp, color = Color.White, fontWeight = FontWeight.Bold,
                style = TextStyle(shadow = Shadow(Color.Black, offset = Offset(3f,4f), blurRadius = 2f))
            )
        }
        Image(painter = painterResource(R.drawable.img),"", modifier = Modifier.padding(5.dp))


    }
}