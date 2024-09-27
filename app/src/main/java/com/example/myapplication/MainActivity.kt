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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.BerryRed
import com.example.myapplication.ui.theme.Blue
import com.example.myapplication.ui.theme.Charcoal
import com.example.myapplication.ui.theme.Green
import com.example.myapplication.ui.theme.LightBlue
import com.example.myapplication.ui.theme.LimeGreen
import com.example.myapplication.ui.theme.Magenta
import com.example.myapplication.ui.theme.MintGreen
import com.example.myapplication.ui.theme.OliveGreen
import com.example.myapplication.ui.theme.Purple40
import com.example.myapplication.ui.theme.Red
import com.example.myapplication.ui.theme.Salmon
import com.example.myapplication.ui.theme.SkyBlue
import com.example.myapplication.ui.theme.Taupe
import com.example.myapplication.ui.theme.Teal
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScreenA()
        }
    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ShowDesign(){
    ButtonAndCard()
}
@Composable
fun ButtonAndCard(){
    Column(modifier = Modifier.fillMaxSize()) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .border(1.dp, Color.Black)
            .background(Color.Yellow)) {

            Text("Button-Card-Switch-Checkbox", modifier = Modifier.padding(10.dp),
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
                        .padding(5.dp, 0.dp, 5.dp, 5.dp)
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
                // floating button with text ,its called extended floating button
                ExtendedFloatingActionButton(
                    onClick = { },
                    containerColor = Color.LightGray,
                    icon = {
                        Icon(
                            Icons.Filled.Refresh,
                            "Extended floating action button.",
                            tint = MintGreen
                        )
                    },
                    text = { Text(text = "Extended FAB", color = Color.Blue) },
                    modifier = Modifier.padding(5.dp)
                )
                //==== text button to show snack bar ======//
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                    TextButton(
                        onClick = {
                        },
                        modifier = Modifier
                            .padding(5.dp)
                            .border(
                                3.dp, Brush.linearGradient(colors = listOf(Color.Cyan, Color.Yellow)),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(5.dp)
                    ) {
                        Text("Text Button")
                    }
                Button(onClick = {

                },
                    shape = CutCornerShape(0.dp,30.dp,30.dp,0.dp),
                    modifier = Modifier.padding(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(red=50, green = 82, blue = 123))
                ) { Text("Goto Next Screen") }


            }
            Column {
                //==== elevated card =======//
                ElevatedCard(
                    colors = CardDefaults.elevatedCardColors(Color.Transparent),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(3.dp)
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
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(5.dp)
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
                    modifier = Modifier
                        .padding(8.dp)
                        .background(
                            Brush.horizontalGradient(listOf(Color.Blue, Color.Magenta)),
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Text("Show Alert")
                }
                if (showAlert){
                    MyAlertDialog(onDismissRequest = {showAlert=!showAlert}, onConfirm = {
                        accept=true
                        showAlert=false})
                }


                //======== here implement the Switch and Checkbox ========//
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
                    var selected by remember { mutableStateOf(false) }
                    var checked by remember { mutableStateOf(false) }
                    SwitchItem {
                        selected=!selected
                    }
                    // here we implement the check box item ======//
                    Checkbox{ checked=!checked }
                    Text(if(checked) "Checked" else "Unchecked")
                }
                //====== floating button for counting the value ======//
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                    var count by remember { mutableIntStateOf(0) }
                    FloatingActionButton(
                        onClick = { count++
                            count %= 10000
                                  },
                        shape = RoundedCornerShape(15.dp), modifier = Modifier.padding(5.dp),
                        contentColor = Green,
                    ) {
                        Icon(Icons.Default.Add, "")
                    }
                    //====== here we implement badge Box =======//
                    BadgedBox(
                        badge = {
                            if (count >= 0) {
                                Badge(
                                    containerColor = Color.Red,
                                    contentColor = Color.White
                                ) {
                                    Text("$count")
                                }
                            }
                        }
                    ) {
                        Icon(Icons.Default.MailOutline, "")
                    }
                }

            }
        }
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .background(Color.Cyan)
            .border(1.dp, Color.Black)) {
            Text("Various Chip", modifier = Modifier.padding(10.dp),
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center
            )
        }
        //========= divider ========//
        HorizontalDivider(thickness = 2.dp, color = Taupe, modifier = Modifier.padding(2.dp))
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
        //========== here the  slider and Progress Indication =============//
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .background(Color(0xFF53BDA5))
            .border(1.dp, Color.Black)) {
            Text("Slider and Progress Indicator", modifier = Modifier.padding(10.dp),
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center,
            )
        }
        //======= here the slider implementation,and the time taken by the progress bar to complete ======//
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)){

            //========this column is for Simple slider and linear progress indicator=======//

            var slider1value by remember { mutableFloatStateOf(0f) }
            val range=0..10
            var slider1Finished by remember { mutableStateOf(false) }
            Column(modifier = Modifier
                .fillMaxWidth(.5f)
                .padding(1.dp)) {
                Slider(
                    value = slider1value,
                    onValueChange = {slider1value=it},
                    onValueChangeFinished = {slider1Finished=true},
                    valueRange = range.first.toFloat()..range.last.toFloat(),
                    steps = range.last - range.first -1,
                    colors = SliderDefaults.colors(
                        thumbColor = BerryRed,
                        activeTrackColor = Red
                    )
                )
                Text(text = if(slider1Finished) slider1value.toInt().toString() else slider1value.toInt().toString())

                //========= liner progress bar =========//
                if (slider1Finished) {
                    LinerProgressbar((slider1value.toInt())){
                        slider1Finished=false
                    }
                }
            }

            //====== this column is for range slider and circular progress indicator======//

            var slider2value by remember { mutableStateOf(0f..10f) }
            var slider2Finished by remember { mutableStateOf(false) }
            var time2 by remember { mutableFloatStateOf(0f) }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp)) {
                RangeSlider(
                    value = slider2value,
                    onValueChange = {slider2value=it},
                    onValueChangeFinished = {
                        slider2Finished=true
                        time2=slider2value.endInclusive - slider2value.start },
                    valueRange = range.first.toFloat()..range.last.toFloat(),
                    colors = SliderDefaults.colors(
                        thumbColor = SkyBlue,
                        activeTrackColor = MintGreen
                    )
                )
                Text(text = if(slider2Finished) (time2).toString() else time2.toString())
                //========== circular progress =========//
                if (slider2Finished) {
                    CircularProgress (time2.toInt()){
                        slider2Finished=false
                    }
                }
            }
        }
    }
}
@Composable
fun MyAlertDialog(onDismissRequest:()->Unit,onConfirm:()->Unit){
    Dialog(onDismissRequest = {onDismissRequest()}){
        ElevatedCard() {
            Column(Modifier.background(Color.Transparent)) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Yellow)
                    .border(1.dp, Color.Black)) {
                    Icon(Icons.Default.Warning, "", modifier = Modifier
                        .height(80.dp)
                        .size(50.dp), tint = Color.Red)
                }
                Text("Confirmed Permission?",
                    Modifier
                        .background(Color.Transparent)
                        .fillMaxWidth()
                        .padding(5.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.DarkGray
                )
                Text("We need your permission to perform sensitive task.Are you sure?",
                    Modifier
                        .background(Color.Transparent)
                        .fillMaxWidth()
                        .padding(2.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic,
                    fontSize = 18.sp
                )
                Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp)) {
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
@Composable
fun LinerProgressbar(time:Int,onComplete:()->Unit){
    var value by remember { mutableFloatStateOf(0f) }
    LaunchedEffect(time) {
        value = 0f
        for(i in 0..time){
            delay(1000)
            value+=(1f/time)
        }
        value = 1f
        onComplete()
    }
    LinearProgressIndicator(
            progress = { value },
            color =  Red,
            trackColor = OliveGreen
        )
}
@Composable
fun CircularProgress(time: Int, onComplete: () -> Unit) {
    var value by remember { mutableFloatStateOf(0f) }
    LaunchedEffect(time) {
        value = 0f
        for(i in 0..time){
            delay(1000)
            value+=(1f/time)
        }
        value = 1f
        onComplete()
    }
    CircularProgressIndicator(
        progress = { value },
        modifier = Modifier.width(64.dp),
        color = LightBlue,
        trackColor = Magenta,
        strokeCap = StrokeCap.Round
    )
}
@Composable
fun SwitchItem(onSelected:()->Unit){
    var checked by remember { mutableStateOf(false) }
    Switch(
        checked = checked,
        onCheckedChange = { checked=it
                          onSelected()},
        //==== these are for custom design ====//
        thumbContent = {
            if (checked){
                Icon(Icons.Default.Done,"", tint = Color.Green)
            }else{
                Icon(Icons.Default.Close,"", tint = Color.Red)
            }
        },
        colors = SwitchDefaults.colors(
            checkedTrackColor = LimeGreen,
            checkedThumbColor = Color.White,
            uncheckedTrackColor = Salmon,
            uncheckedThumbColor =  Color.White
        )
    )
}
@Composable
fun Checkbox(onChecked: () -> Unit) {

    var checked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = checked,
            colors = CheckboxDefaults.colors(
                checkedColor = Green,
                checkmarkColor = Color.White,
                uncheckedColor = Red,
            ),
            onCheckedChange = {
                checked = it
                onChecked()
            }
        )
    }
}



