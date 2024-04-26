package input

fun List<InputRuleResult>.firstUnfulfilled(): InputRuleResult? = filter { !it.isFulfilled }.maxByOrNull { it.priority }

