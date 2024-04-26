package input

/**
 * Represents the result of a [InputRule], when applied to an input.
 * @param description The description of the rule.
 * @param isFulfilled Whether the rule is fulfilled.
 * @param priority The Priority of the rule (optional).
 */

data class InputRuleResult(
    val description: String,
    val isFulfilled: Boolean,
    val priority: Int = 0
)