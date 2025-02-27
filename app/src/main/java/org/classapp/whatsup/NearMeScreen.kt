package org.classapp.whatsup

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.widget.ConstraintLayout
import org.classapp.whatsup.ui.theme.WhatsUpTheme


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun NearMeScreenPreview() {
    NearMeScreen()
}
@Composable
fun NearMeScreen() {
    WhatsUpTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            // content on surface
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Events Near Me")
                LocationCoordinateDisplay(lat= "0.0", lon="0.0")
            }
        }
    }
}
@Composable
fun LocationCoordinateDisplay(lat: String, lon: String) {
    ConstraintLayout (modifier = Modifier.fillMaxWidth().padding(all = 8.dp)) {  val (goBtn, latField, lonField) = createRefs()

    Button( onClick = {/*TODO*/}, modifier = Modifier.constrainAs(goBtn){
        top.linkTo(parent.top, margin = 8.dp)
        end.linkTo(parent.end, margin = 0.dp)
        width = Dimension.wrapContent
    }) {
        Text(text = "GO")
    }
    OutlinedTextField(
            value = lat,
            label = { Text(text = "Latitude") },
            onValueChange = {},
            modifier = Modifier.constrainAs(latField) {
                top.linkTo(parent.top, margin = 0.dp)
                start.linkTo(parent.start, margin = 0.dp)
                end.linkTo(goBtn.start, margin = 8.dp)
                width = Dimension.fillToConstraints
            }
        )

        OutlinedTextField(
            value = lon, // Corrected from lat to lon
            label = { Text(text = "Longitude") },
            onValueChange = {},
            modifier = Modifier.constrainAs(lonField) {
                top.linkTo(latField.bottom, margin = 8.dp) // Positioned below latField
                start.linkTo(parent.start, margin = 0.dp)
                end.linkTo(goBtn.start, margin = 8.dp)
                width = Dimension.fillToConstraints
            }
        )
    }}






