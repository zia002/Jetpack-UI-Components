package com.example.myapplication

import android.view.WindowInsets
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.Grape
import com.example.myapplication.ui.theme.Green
import com.example.myapplication.ui.theme.OliveGreen
import com.example.myapplication.ui.theme.Violet
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import com.example.myapplication.ui.theme.BerryRed
import com.example.myapplication.ui.theme.Blue
import com.example.myapplication.ui.theme.LimeGreen
import com.example.myapplication.ui.theme.Magenta
import com.example.myapplication.ui.theme.Orange
import com.example.myapplication.ui.theme.Red
import com.example.myapplication.ui.theme.SkyBlue
import com.example.myapplication.ui.theme.Taupe
import com.example.myapplication.ui.theme.Teal
import com.example.myapplication.ui.theme.Yellow


@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showSystemUi = true)
@Composable
fun ScreenA(){
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    var showSheet by remember{ mutableStateOf(false) }
    val navController= rememberNavController()
    val scope= rememberCoroutineScope()
    val drawerState= rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet() {
                ShowNavigationDrawer()
            }
        },
        gesturesEnabled = true,
        scrimColor = Taupe

    ) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ) { innerPadding ->
            //====== design here the app UI =====//
            Column(modifier = Modifier.padding(innerPadding).fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                //======== this is the top bar  of the screen =========//
                Row(modifier = Modifier.fillMaxWidth().background(OliveGreen,)) {
                    //===== this button is responsible for drawer ======//
                    Button(
                        onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        },
                        modifier = Modifier.background(Color.Transparent, shape = RectangleShape),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = OliveGreen,
                            contentColor = Color.Black
                        )
                    ) {
                        Icon(Icons.Default.Menu, "", modifier = Modifier.size(35.dp))
                    }
                    Spacer(Modifier.weight(1f))
                    //===== this button is responsible for Bottom sheet======//
                    Button(onClick = {
                            showSheet = true
                        },
                        modifier = Modifier.background(Color.Transparent, shape = RectangleShape),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = OliveGreen,
                            contentColor = Color.Black
                        )
                    ) {
                        Icon(Icons.Default.AccountBox, "", modifier = Modifier.size(35.dp))
                    }
                }
                //======== here the central items ========//
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    //====== text with style tag ====//
                    Text("Hello Zia", modifier = Modifier.padding(6.dp).fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        color = BerryRed,
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(5f,7f)
                            )
                        ),
                        textDecoration = TextDecoration.Underline,

                    )
                }
                //======  text with BuildAnnotatedString =====//
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(textGeometricTransform = TextGeometricTransform(2f,.3f),color = Green, fontSize = 40.sp, shadow = Shadow(color = Color.Red, offset = Offset(4f,4f)))){
                            append("A")
                        }
                        append("ndroid  ")
                        withStyle( style = SpanStyle(color = LimeGreen, fontSize = 40.sp,shadow = Shadow(color = Color.Black, offset = Offset(4f,4f))))
                        {
                            append("D")
                        }
                        withStyle(style = SpanStyle(brush = Brush.linearGradient(colors = listOf(Blue,
                            Grape,Green, BerryRed, Yellow)))){
                         append("evelopment")
                        }
                    },
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text("Its a marquee Lorem ipsum dolor sit amet " +
                        "Consectetur adipiscing elit" +
                        "Sed do eiusmod tempor incididunt",
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth().basicMarquee().border(border = BorderStroke(1.dp,
                        Color.Black)).padding(3.dp),
                )
                UserInput(){}
                Box(Modifier.fillMaxWidth().background(Teal).height(50.dp).border(width = 1.dp, Color.Black),
                    contentAlignment = Alignment.Center
                    ){
                    Text("Image and Graphics",Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
                        fontSize = 23.sp, color = Color.White, fontWeight = FontWeight.Bold,
                        style = TextStyle(shadow = Shadow(Color.Black, offset = Offset(3f,4f), blurRadius = 2f))
                        )
                }
                ImageAndGraphics()
            }
        }
    }
    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showSheet = false
            },
            sheetState = sheetState
        ) {
            BottomSheetDesign()
        }
    }

}
@Composable
fun BottomSheetDesign(){
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
        Icon(Icons.Default.AccountCircle,"", modifier = Modifier.fillMaxWidth().size(50.dp))
        Text("Account Detail's", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 25.sp)
        HorizontalDivider(thickness = 2.dp, color = Color.Black, modifier = Modifier.padding(8.dp,0.dp,8.dp,0.dp))
        Text("Author: Mohammad Zia", textAlign =TextAlign.Center, modifier = Modifier.fillMaxWidth().padding(10.dp), fontSize = 20.sp, fontStyle = FontStyle.Italic, fontFamily = FontFamily.Serif , color = Grape)
        Text("Chittagong University of Engineering Technology", textAlign =TextAlign.Center, modifier = Modifier.fillMaxWidth().padding(4.dp), fontSize = 18.sp, fontStyle = FontStyle.Normal, fontFamily = FontFamily.Serif , color = Violet, fontWeight = FontWeight.Bold)

    }
}
@Composable
fun ShowNavigationDrawer(){
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().height(120.dp).background(Brush.linearGradient(
            listOf( Yellow,
            OliveGreen, Orange, Yellow,
                OliveGreen, LimeGreen)))
        ) {
            Column(modifier = Modifier.padding(5.dp)) {
                Text(
                    "Title ",
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    fontFamily = FontFamily.Serif
                )
                Text(
                    "Sub Title ",
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Cursive
                )
            }
        }
        ItemCompose("Home",Icons.Default.Home){}
        ItemCompose("Cart",Icons.Default.ShoppingCart){}
        //======= control here date picker ========//
        ItemCompose("Date Picker",Icons.Default.DateRange){

        }
        //======= Control here time picker ========//
        Row(modifier = Modifier.padding(5.dp).fillMaxWidth().clickable{

        },
            verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(R.drawable.time), "",Modifier.padding(0.dp,0.dp,20.dp,0.dp).size(40.dp))
            Text("Time Picker", textAlign = TextAlign.Center, modifier = Modifier, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        HorizontalDivider(thickness = 1.dp, modifier = Modifier.padding(6.dp))
        Text("Communication",modifier = Modifier.padding(5.dp,8.dp,0.dp,15.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            color = Color.DarkGray
        )
        ItemCompose("Call",Icons.Default.Call){}
        ItemCompose("Email",Icons.Default.Email){}
        ItemCompose("Share",Icons.Default.Share){}

    }
}
@Composable
fun ItemCompose(text:String,imageVector: ImageVector,onClick:()->Unit){
    Row(modifier = Modifier.padding(5.dp).fillMaxWidth().clickable(onClick=onClick), verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector, "",Modifier.padding(0.dp,0.dp,20.dp,0.dp).size(40.dp))
        Text(text, textAlign = TextAlign.Center, modifier = Modifier, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}
@Composable
fun UserInput(onDone:()->Unit){
    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    Column(Modifier.fillMaxWidth()) {
        //====== Outlined TextField ======//
        OutlinedTextField(value=value2, onValueChange = {value2=it},
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth().padding(20.dp,10.dp,20.dp,10.dp),
            textStyle = TextStyle(Brush.linearGradient(listOf(BerryRed,
                Red, Orange,SkyBlue, Violet,Grape, Yellow)), fontSize = 20.sp),
            leadingIcon = { Icon(Icons.Default.Email,"") },
            prefix = { Text("@") },
            suffix = { Text("@student.cuet.ac.bd") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Blue, unfocusedBorderColor = OliveGreen,
                focusedTextColor = Violet, unfocusedTextColor = Magenta
                )
            )
        //====== simple text field =====//
        TextField(value = value1, onValueChange = { value1 = it },
            modifier = Modifier.padding(20.dp,10.dp,20.dp,10.dp).fillMaxWidth().background(Color.Transparent),
            label = { Text("Password") },
            textStyle = TextStyle(color = Blue),
            placeholder = { Text("Enter Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                onDone()
            })
        )
    }
}
@Composable
fun ImageAndGraphics(){
    Image(painter = painterResource(R.drawable.img),"", modifier = Modifier.padding(5.dp))
}
