package input


class InputRule(
    private val description: String,
    private val priority: Priority,
    val predicate: (input: String) -> Boolean,
) {
    fun copy(
        description: String = this.description,
        priority: Priority = this.priority,
        predicate: (input: String) -> Boolean = this.predicate,
    ) = InputRule(description, priority, predicate)

    fun toRuleResult(input: String) =
        InputRuleResult(description, predicate(input), priority.ordinal)

    companion object {

        fun minLength(
            inputType: InputType,
            length: Int,
            priority: Priority = Priority.Low
        ) = InputRule("${inputType.type} must be at least $length characters long", priority) {
            it.length >= length
        }


        fun containsLowercase(
            inputType: InputType,
            priority: Priority = Priority.Low
        ) = InputRule(
            "${inputType.type} must contain at least one lowercase character",
            priority
        ) {
            it.any { char -> char.isLowerCase() }
        }


        fun containsUppercase(
            inputType: InputType,
            priority: Priority = Priority.Low
        ) = InputRule(
            "${inputType.type} must contain at least one uppercase character",
            priority
        ) {
            it.any { char -> char.isUpperCase() }
        }


        fun containsDigit(
            inputType: InputType,
            priority: Priority = Priority.Low
        ) = InputRule("${inputType.type} must contain at least one digit", priority) {
            it.any { char -> char.isDigit() }
        }


        fun containsSpecialCharacter(
            inputType: InputType,
            priority: Priority = Priority.Low
        ) = InputRule("${inputType.type} must contain at least one special character", priority) {
            it.any { char -> char.isLetterOrDigit().not() }
        }


        fun maxLength(
            inputType: InputType,
            length: Int,
            priority: Priority = Priority.Low
        ) = InputRule("${inputType.type} must be at most $length characters long", priority) {
            it.length <= length
        }


        fun containsOnlyDigits(
            inputType: InputType,
            priority: Priority = Priority.Low
        ) = InputRule("${inputType.type} must contain only digits", priority) {
            it.all { char -> char.isDigit() }
        }

        fun containsNoDigits(
            inputType: InputType,
            priority: Priority = Priority.Low
        ) = InputRule("${inputType.type} must not contain any digit", priority) {
            it.all { char -> char.isDigit().not() }
        }

        fun isUserName(
            inputType: InputType,
            priority: Priority = Priority.Low
        ) = InputRule("${inputType.type} must be a valid username", priority) {
            it.length >= 6 && it.all { char -> char.isLetter() } && !it.contains('@')
        }

        fun isEmail(
            inputType: InputType,
            priority: Priority = Priority.Low
        ) = InputRule("${inputType.type} must be a valid email", priority) {
            it.matches(Regex("^[\\w\\-\\.+]+@([\\w-]+\\.)+[\\w-]{2,}$"))
        }

        fun isPhoneNumber(
            inputType: InputType,
            priority: Priority = Priority.Low
        ) = InputRule("${inputType.type} must be a valid phone number", priority) {
            it.matches(Regex("^[0-9]{10}$"))
        }

        fun isZipCode(
            inputType: InputType,
            priority: Priority = Priority.Low
        ) = InputRule("${inputType.type} must be a valid zip code", priority) {
            it.matches(Regex("^[0-9]{5}$"))
        }

        fun isState(
            inputType: InputType,
            priority: Priority = Priority.Low
        ) = InputRule("${inputType.type} must be a valid state", priority) {
            it.matches(Regex("^[A-Z]{2}$"))
        }

        fun isInteger(
            inputType: InputType,
            priority: Priority = Priority.Low
        ) = InputRule("${inputType.type} must be a valid integer", priority) {
            it.toIntOrNull() != null
        }

        //add more custom InputRules...

    }


}



