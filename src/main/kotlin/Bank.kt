class Bank(
    private var rubBalance: Double,
    private var usdBalance: Double,
    private var exchangeRate: Double = 70.0
) : BankInterface {

    private var cashRegisterCreated = false

    override fun sendRub(amount: Double): Double {
        return if (amount <= rubBalance) {
            rubBalance -= amount
            println("Банк отправил $amount рублей")
            amount
        } else {
            val availableRub = rubBalance
            rubBalance = 0.0
            println("Банк отправил $availableRub рублей (недостаточно средств для полной суммы)")
            availableRub
        }
    }

    override fun sendUsd(amount: Double): Double {
        return if (amount <= usdBalance) {
            usdBalance -= amount
            println("Банк отправил $amount долларов")
            amount
        } else {
            val availableUsd = usdBalance
            usdBalance = 0.0
            println("Банк отправил $availableUsd долларов (недостаточно средств для полной суммы)")
            availableUsd
        }
    }

    override fun receiveRub(amount: Double) {
        rubBalance += amount
        println("Банк получил $amount рублей")
    }

    override fun receiveUsd(amount: Double) {
        usdBalance += amount
        println("Банк получил $amount долларов")
    }

    override fun createCashRegister(): CashRegister {
        if (!cashRegisterCreated) {
            cashRegisterCreated = true
            return CashRegister(this)
        } else {
            throw IllegalStateException("Касса уже была создана для этого банка.")
        }
    }

    fun updateExchangeRate(newRate: Double) {
        exchangeRate = newRate
        println("Курс обмена обновлен: 1 USD = $exchangeRate RUB\n")
    }

    fun getExchangeRate(): Double = exchangeRate

    fun getRubBalance(): Double = rubBalance
    fun getUsdBalance(): Double = usdBalance
}

