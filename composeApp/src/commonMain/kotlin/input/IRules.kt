package input

//TODO implement an interface
sealed interface InputRules {
    data class MinLength(val length: Int, val priority: Priority = Priority.Low) : InputRules
    data class ContainsLowercase(val priority: Priority = Priority.Low) : InputRules
    data class ContainsUppercase(val priority: Priority = Priority.Low) : InputRules
    data class ContainsDigit(val priority: Priority = Priority.Low) : InputRules
    data class ContainsSpecialCharacter(val priority: Priority = Priority.Low) : InputRules
    data class MaxLength(val length: Int, val priority: Priority = Priority.Low) : InputRules
    data class ContainsOnlyDigits(val priority: Priority = Priority.Low) : InputRules
    data class ContainsNoDigits(val priority: Priority = Priority.Low) : InputRules
    data class IsUserName(val priority: Priority = Priority.Low) : InputRules
    data class IsEmail(val priority: Priority = Priority.Low) : InputRules
}
