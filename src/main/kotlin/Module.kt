package org.example

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule1 = module {
    single {
        listOf(
            Country("USA", 331002651),
            Country("China", 1439323776),
            Country("India", 1380004385),
            Country("Indonesia", 273523615),
            Country("Pakistan", 220892340),
            Country("Brazil", 212559417),
            Country("Nigeria", 206139589),
            Country("Bangladesh", 164689383),
            Country("Russia", 145934462),
            Country("Mexico", 128932753)
        )
    }
}

val appModule2 = module {
    single {
        listOf(
            Country("Japan", 126476461),
            Country("Philippines", 109581078),
            Country("Egypt", 102334404),
            Country("Ethiopia", 114963588),
            Country("Vietnam", 97338579),
            Country("DR Congo", 89561403),
            Country("Turkey", 84339067),
            Country("Iran", 83992949),
            Country("Germany", 83783942),
            Country("Thailand", 69799978)
        )
    }
}

val countryModule = module {
    singleOf(::CountryPrinter)
}