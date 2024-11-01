fun main() {

    val bank = Bank(100000.0, 1000.0)

    val cashRegister = bank.createCashRegister()

    val dollars = cashRegister.exchangeRubToUsd(63000.0)
    println("Человек получил $dollars долларов\n")

    println("Остаток рублей в банке: ${bank.getRubBalance()}")
    println("Остаток долларов в банке: ${bank.getUsdBalance()}\n\n")

    val rubles = cashRegister.exchangeUsdToRub(100.0)
    println("Человек получил $rubles рублей\n")

    println("Остаток рублей в банке: ${bank.getRubBalance()}")
    println("Остаток долларов в банке: ${bank.getUsdBalance()}\n\n")

    val temp1 = cashRegister.exchangeRubToUsd(21000.0)
    println("Человек получил $temp1 долларов\n")

    println("Остаток рублей в банке: ${bank.getRubBalance()}")
    println("Остаток долларов в банке: ${bank.getUsdBalance()}\n\n")

    bank.updateExchangeRate(100.0)

    val temp2 = cashRegister.exchangeUsdToRub(10.0)
    println("Человек получил $temp2 рублей\n")

    println("Остаток рублей в банке: ${bank.getRubBalance()}")
    println("Остаток долларов в банке: ${bank.getUsdBalance()}")
}
