package org.example

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.java.KoinJavaComponent.inject

fun main() {
    startKoin {
        modules(appModule2, countryModule)
    }

    val countryThingy = CountryThingy()
    countryThingy.printCountries()
}

class CountryThingy(): KoinComponent {
    private val countryPrinter: CountryPrinter by inject()
    fun printCountries() {
        countryPrinter.print()
    }
}

