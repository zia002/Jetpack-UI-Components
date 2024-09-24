package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastCbrt
import androidx.compose.ui.window.Dialog

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShowDesign()
        }
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ShowDesign(){
    ButtonAndCard()
    //MyAlertDialog(onDismissRequest = {}, onConfirm = {})
}
@Composable
fun ButtonAndCard(){
    Column(modifier = Modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth().padding(6.dp).border(1.dp,Color.Black).background(Color.Yellow)) {
            Text("Button and Card Design", modifier = Modifier.padding(10.dp),
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center
                )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Column() {
                // filled tonal button
                FilledTonalButton(
                    onClick = {},
                    colors = ButtonDefaults.filledTonalButtonColors(
                        containerColor = Color.Transparent,
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .padding(5.dp,0.dp,5.dp,5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            brush = Brush.sweepGradient(
                                colors = listOf(
                                    Color.Cyan,
                                    Color.Blue,
                                    Color.Magenta,
                                    Color.Yellow
                                )
                            )
                        ),
                    elevation = ButtonDefaults.filledTonalButtonElevation(defaultElevation = 10.dp),
                ) {
                    Text(text = "Tonal Button", color = Color.White, fontWeight = FontWeight.Bold)
                }
                // outline button
                OutlinedButton(
                    onClick = {},
                    shape = RectangleShape,
                    border = BorderStroke(2.dp, Color.Black),
                    modifier = Modifier.padding(5.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
                ) {
                    Text("Outline Button")
                }
                //elevated Button
                ElevatedButton(
                    onClick = {},
                    modifier = Modifier.padding(5.dp),
                    shape = CutCornerShape(10.dp),
                    colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.Yellow),
                    elevation = ButtonDefaults.elevatedButtonElevation(pressedElevation = 10.dp)

                ) {
                    Text("Cut Corner")
                }
                //text button
                TextButton(
                    onClick = {},
                    modifier = Modifier.padding(5.dp).border(
                        5.dp, Brush.linearGradient(colors = listOf(Color.Cyan, Color.Yellow)),
                        shape = RoundedCornerShape(8.dp)
                    )
                        .padding(5.dp)
                ) {
                    Text("Text Button ")
                }
                // floating button
                FloatingActionButton(
                    onClick = {},
                    shape = CircleShape, modifier = Modifier.padding(5.dp),
                    contentColor = Color.Red,
                ) {
                    Icon(Icons.Default.Delete, "")
                }
                // floating button with text ,its called extended floating button
                ExtendedFloatingActionButton(
                    onClick = { },
                    containerColor = Color.LightGray,
                    icon = {
                        Icon(
                            Icons.Filled.Add,
                            "Extended floating action button.",
                            tint = Color.Magenta
                        )
                    },
                    text = { Text(text = "Extended FAB", color = Color.Blue) },
                    modifier = Modifier.padding(5.dp)
                )

            }
            Column {
                //==== elevated card =======//
                ElevatedCard(
                    colors = CardDefaults.elevatedCardColors(Color.Transparent),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth().height(100.dp).padding(3.dp)
                        .background(
                            Brush.linearGradient(listOf(Color.Yellow, Color.Red)),
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Text(
                            "Elevated Card",
                            fontStyle = FontStyle.Italic,
                            fontFamily = FontFamily.Monospace
                        )
                    }
                }
                //=====Outlined card======//
                OutlinedCard(
                    border = BorderStroke(
                        2.dp,
                        Brush.linearGradient(
                            colors = listOf(
                                Color.Magenta,
                                Color.Cyan,
                                Color.Blue,
                                Color.Green,
                                Color.Yellow,
                                Color.Magenta
                            )
                        )
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth().height(100.dp).padding(5.dp)
                ) {
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        Text(
                            "OutLine Card",
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                var showAlert by remember{ mutableStateOf(false) }
                var accept by remember { mutableStateOf(false) }
                Button(colors = ButtonDefaults.buttonColors(Color.Transparent),
                    onClick = {showAlert=!showAlert},
                    modifier = Modifier.padding(8.dp).background(Brush.horizontalGradient(listOf(Color.Blue,Color.Magenta)), shape = RoundedCornerShape(8.dp))
                ) {
                    Text("Show Alert")
                }
                if (showAlert){
                    MyAlertDialog(onDismissRequest = {showAlert=!showAlert}, onConfirm = {
                        accept=true
                        showAlert=false})
                }
            }
        }
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth().padding(6.dp).background(Color.Cyan).border(1.dp,Color.Black)) {
            Text("Various Chip", modifier = Modifier.padding(10.dp),
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center
            )
        }
        Row() {
            //=== AssistChip =====//
            AssistChip(
                modifier = Modifier.padding(3.dp),
                onClick = {},
                leadingIcon = { Icon(painter = painterResource(R.drawable.ic_launcher_foreground),"", Modifier.size(20.dp)) },
                label = {Text("AssistChip")}
            )
            //==== filter Chip ====//
            var selected by remember { mutableStateOf(false) }
            FilterChip(
                modifier = Modifier.padding(3.dp),
                onClick = { selected = !selected },
                label = {
                    Text(
                        text=if (selected) "Clicked" else "Filter" ,
                        color=if (selected) Color.Black else Color.White
                    )
                },
                selected = selected,
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color.Green,
                    containerColor = Color.Red
                ),
                leadingIcon = {
                    if (selected) {
                        Icon(Icons.Filled.Done, contentDescription = null, tint = Color.Black)
                    } else {
                        Icon(Icons.Filled.Close, contentDescription = null, tint = Color.White)
                    }
                }
            )
            //=== suggestion Chip ====//
            ElevatedSuggestionChip(
                onClick = {},
                label = {Text("Suggestion Chip")},
                Modifier.padding(3.dp),
            )
        }
        
    }
}
@Composable
fun MyAlertDialog(onDismissRequest:()->Unit,onConfirm:()->Unit){
    Dialog(onDismissRequest = {onDismissRequest()}){
        ElevatedCard() {
            Column(Modifier.background(Color.Transparent)) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth().background(Color.Yellow).border(1.dp,Color.Black)) {
                    Icon(Icons.Default.Warning, "", modifier = Modifier.height(80.dp).size(50.dp), tint = Color.Red)
                }
                Text("Confirmed Permission?",Modifier.background(Color.Transparent).fillMaxWidth().padding(5.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.DarkGray
                )
                Text("We need your permission to perform sensitive task.Are you sure?",Modifier.background(Color.Transparent).fillMaxWidth()
                    .padding(2.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic,
                    fontSize = 18.sp
                )
                Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth().padding(3.dp)) {
                    Button(onClick = { onConfirm() },
                        shape = CutCornerShape(30.dp,0.dp,0.dp,30.dp),
                        modifier = Modifier.width(100.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(red=0, green = 128, blue = 0))
                        ) { Text("Yes") }
                    Button(onClick = { onDismissRequest() },
                        shape = CutCornerShape(0.dp,30.dp,30.dp,0.dp),
                        modifier = Modifier.width(100.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD1001F))
                        ) { Text("No") }
                }
            }
        }
    }
}