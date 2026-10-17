package com.example.tugas_userinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp

@Composable
fun BiodataScreen() {
    Box(modifier = Modifier.fillMaxSize()) {

        // LAPISAN BAWAH: Scaffold berisi gambar latar
        Scaffold(
            containerColor = colorResource(R.color.screen_background)
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Image(
                    painter = painterResource(R.drawable.bg_neon),
                    contentDescription = stringResource(R.string.desc_background),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(R.dimen.image_header_height))
                )
                PageIndicator(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(dimensionResource(R.dimen.indicator_padding))
                )
            }
        }

        // LAPISAN ATAS: Box form yang mengapung di atas Scaffold
        FloatingForm(modifier = Modifier.align(Alignment.TopCenter))
    }
}

@Composable
private fun FloatingForm(modifier: Modifier = Modifier) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var birthDate by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    val selectedSkills = remember { mutableStateListOf<String>() }
    val skills = stringArrayResource(R.array.skill_options)

    val isFormValid = firstName.isNotBlank() && lastName.isNotBlank() &&
            email.isNotBlank() && birthDate.isNotBlank() &&
            experience.isNotBlank() && selectedSkills.isNotEmpty()

    val formShape = RoundedCornerShape(dimensionResource(R.dimen.form_corner))

    Box(
        modifier = modifier
            .padding(top = dimensionResource(R.dimen.form_offset_top))
            .fillMaxWidth()
            .shadow(dimensionResource(R.dimen.form_elevation), formShape)
            .background(colorResource(R.color.form_background), formShape)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(dimensionResource(R.dimen.form_padding)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.spacing_field)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.form_title),
                color = colorResource(R.color.form_title),
                fontSize = dimensionResource(R.dimen.text_title).value.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.form_subtitle),
                color = colorResource(R.color.form_subtitle),
                fontSize = dimensionResource(R.dimen.text_subtitle).value.sp
            )
