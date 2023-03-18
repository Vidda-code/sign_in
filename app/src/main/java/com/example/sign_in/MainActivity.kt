package com.example.sign_in


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeScreen()
        }
    }
}

@Composable
fun WelcomeScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, top = 0.dp, bottom = 0.dp)
            .background(Color.White)
    ) {
        Text(
            text = stringResource(id = R.string.welcome),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 42.dp, bottom = 28.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 18.dp)
        ) {
            var emailValue by remember {
                mutableStateOf(TextFieldValue(""))
            }
            Text(
                text = stringResource(id = R.string.email),
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 5.dp, bottom = 9.dp)
            )
            OutlinedTextField(
                value = emailValue,
                onValueChange = { emailValue = it },
                placeholder = { Text(text = stringResource(id = R.string.email_hint)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(18)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 18.dp)
        ) {
            var password by remember {
                mutableStateOf(TextFieldValue(""))
            }
            var passwordVisibility by remember {
                mutableStateOf(false)
            }
            val icon = if (passwordVisibility)
                painterResource(id = R.drawable.design_ic_visibility)
            else
                painterResource(id = R.drawable.design_ic_visibility_off)

            Text(
                text = stringResource(id = R.string.password),
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 5.dp, bottom = 9.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = stringResource(id = R.string.password_hint)) },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(
                            painter = icon,
                            contentDescription = "Visibility Icon"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(18),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisibility) VisualTransformation.None
                else
                    PasswordVisualTransformation()
            )
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier

                .fillMaxWidth()
        ) {
            var checkedState by remember {
                mutableStateOf(false)
            }
            Checkbox(
                checked = checkedState,
                onCheckedChange = { checkedState = it },
            )
            Spacer(modifier = Modifier.width(0.dp))
            Text(
                text = stringResource(id = R.string.remember_me),
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.width(58.dp))

            Text(
                text = stringResource(id = R.string.forget_password),
                fontSize = 16.sp,
                color = Color.Red,
            )
        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .height(45.dp),
            shape = RoundedCornerShape(12),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.login_blue),
                contentColor = Color.White
            )

        ) {
            Text(text = stringResource(id = R.string.login))
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 65.dp)
                .fillMaxWidth()
        ) {
            Divider(thickness = 1.dp, color = Color.Black, modifier = Modifier.width(127.dp))
            Text(
                text = stringResource(id = R.string.or_with),
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
            )
            Divider(thickness = 1.dp, color = Color.Black, modifier = Modifier.width(127.dp))
        }



        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(45.dp),
            shape = RoundedCornerShape(18),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.fb_blue),
                contentColor = Color.White
            )
        ) {
            val facebookIcon = painterResource(id = R.drawable.facebook_icon)

            Image(
                painter = facebookIcon,
                contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.facebook),
                fontSize = 16.sp
            )

        }

        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .background(
                    Color.Unspecified,
                    shape = RoundedCornerShape(18),
                )
                .height(45.dp),
            shape = RoundedCornerShape(18)
        ) {
            val googleIcon = painterResource(id = R.drawable.google_icon)
            Image(
                painter = googleIcon,
                contentDescription = null,

                )
            Text(text = stringResource(id = R.string.google))
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.no_account))
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = stringResource(id = R.string.sign_up))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WelcomeScreen()
}