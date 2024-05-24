import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import input.InputRuleBuilder
import input.InputType
import input.Priority
import input.rememberEmailRuleList
import input.rememberPriorityRuleList
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }

        var userName by remember { mutableStateOf("") }
        var input by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        val userNameRules = remember {
            InputRuleBuilder(InputType.Username)
                .minLength(6)
                .maxLength(20)
                .containsNoDigits(Priority.High)
                .build()
        }

        val passwordRules = remember {
            InputRuleBuilder(InputType.Password)
                .containsSpecialCharacter()
                .containsUppercase()
                .containsDigit()
                .containsLowercase()
                .minLength(8)
                .maxLength(22)
                .build()
        }


        val intRules = remember {
            InputRuleBuilder(InputType.Input)
                .isInt()
                .build()
        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }

            AnimatedVisibility(showContent) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    OutlinedField(
                        value = userName,
                        onValueChange = { userName = it },
                        rules = intRules,
                        placeholder = InputType.Username.type
                    )

                    OutlinedField(
                        value = input,
                        onValueChange = { input = it },
                        rules = rememberPriorityRuleList(),
                        placeholder = InputType.Input.type
                    )

                    OutlinedField(
                        value = email,
                        onValueChange = { email = it },
                        rules = rememberEmailRuleList(),
                        placeholder = InputType.Email.type
                    )

                    OutlinedField(
                        value = password,
                        onValueChange = { password = it },
                        rules = passwordRules,
                        placeholder = InputType.Password.type
                    )
                }
            }
        }
    }
}

