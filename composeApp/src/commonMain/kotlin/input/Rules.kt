package input

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberPriorityRuleList() = remember {
    InputRuleBuilder(InputType.Input)
        .containsSpecialCharacter(Priority.Low)
        .containsUppercase(Priority.Mid)
        .containsDigit(Priority.High)
        .build()
}

@Composable
fun rememberEmailRuleList() = remember {
    InputRuleBuilder(InputType.Email)
        .isEmail()
        .build()
}


@Composable
fun rememberLastNameRuleList() = remember {
    InputRuleBuilder(InputType.LastName)
        .containsUppercase()
        .containsLowercase()
        .minLength(8)
        .maxLength(22)
        .build()
}
