import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import input.InputRule
import input.InputRuleBuilder
import input.InputRuleResult
import input.InputType
import input.firstUnfulfilled


@Composable
fun OutlinedField(
    value: String,
    onValueChange: (String) -> Unit,
    rules: List<InputRule> = remember { InputRuleBuilder(InputType.Input).build() },
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardActions: KeyboardActions = KeyboardActions(),
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    readOnly: Boolean = false,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    textStyle: TextStyle = LocalTextStyle.current,
    shape: Shape = OutlinedTextFieldDefaults.shape,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    label: @Composable (() -> Unit)? = null,
    supportingText: @Composable ((rules: List<InputRuleResult>) -> Unit)? = { ruleList ->
        if (value.isNotEmpty()){
            ruleList.firstUnfulfilled()?.let { rule ->
                Text(rule.description)
            }
        }
    },
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    placeholder: String? = null,

) {


    val ruleResults = remember(value, rules) {
        rules.map { it.toRuleResult(value) }
    }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        isError = ruleResults.firstUnfulfilled() != null && value.isNotEmpty(),
        modifier = modifier,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        supportingText = { supportingText?.invoke(ruleResults) },
        readOnly = readOnly,
        enabled = enabled,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors,
        textStyle = textStyle,
        placeholder = {
             Text(placeholder ?: "")
        },
    )

}
