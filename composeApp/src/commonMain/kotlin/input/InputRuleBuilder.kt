package input


class InputRuleBuilder(private val inputType: InputType) {
    private val rules = mutableListOf<InputRule>()

    fun build(): List<InputRule> = rules.toList()


    fun minLength(length: Int, priority: Priority = Priority.Low): InputRuleBuilder {
        rules.add(InputRule.minLength(this.inputType, length, priority))
        return this
    }

    fun containsLowercase(priority: Priority = Priority.Low): InputRuleBuilder {
        rules.add(InputRule.containsLowercase(inputType, priority))
        return this
    }

    fun containsUppercase(priority: Priority = Priority.Low): InputRuleBuilder {
        rules.add(InputRule.containsUppercase(inputType, priority))
        return this
    }


    fun containsDigit(priority: Priority = Priority.Low): InputRuleBuilder {
        rules.add(InputRule.containsDigit(inputType, priority))
        return this
    }

    fun containsSpecialCharacter(priority: Priority = Priority.Low): InputRuleBuilder {
        rules.add(InputRule.containsSpecialCharacter(inputType, priority))
        return this
    }


    fun maxLength(length: Int, priority: Priority = Priority.Low): InputRuleBuilder {
        rules.add(InputRule.maxLength(inputType, length, priority))
        return this
    }

    fun containsOnlyDigits(priority: Priority = Priority.Low): InputRuleBuilder {
        rules.add(InputRule.containsOnlyDigits(inputType, priority))
        return this
    }

    fun containsNoDigits(priority: Priority = Priority.Low): InputRuleBuilder {
        rules.add(InputRule.containsNoDigits(inputType, priority))
        return this
    }

    fun isUserName(priority: Priority = Priority.Low): InputRuleBuilder {
        rules.add(InputRule.isUserName(inputType, priority))
        return this
    }

    fun isEmail(priority: Priority = Priority.Low): InputRuleBuilder {
        rules.add(InputRule.isEmail(inputType, priority))
        return this
    }

    fun isInt(priority: Priority = Priority.Low): InputRuleBuilder {
        rules.add(InputRule.isInteger(inputType, priority))
        return this
    }
}

