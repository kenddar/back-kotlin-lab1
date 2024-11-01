class CashRegister(private val bank: Bank) : CashRegisterInterface {

    private var exchangeRate: Double = bank.getExchangeRate()

    override fun exchangeRubToUsd(amount: Double): Double {
        exchangeRate = bank.getExchangeRate()
        val usdAmount = amount / exchangeRate
        val exchangedUsd = bank.sendUsd(usdAmount)
        val actualRubNeeded = exchangedUsd * exchangeRate
        bank.receiveRub(actualRubNeeded)
        println("Касса обменяла $actualRubNeeded рублей на $exchangedUsd долларов")
        return exchangedUsd
    }

    override fun exchangeUsdToRub(amount: Double): Double {
        exchangeRate = bank.getExchangeRate()
        val rubAmount = amount * exchangeRate
        val exchangedRub = bank.sendRub(rubAmount)
        val actualUsdNeeded = exchangedRub / exchangeRate
        bank.receiveUsd(actualUsdNeeded)
        println("Касса обменяла $actualUsdNeeded долларов на $exchangedRub рублей")
        return exchangedRub
    }
}