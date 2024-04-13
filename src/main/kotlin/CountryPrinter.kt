package org.example


class CountryPrinter(private val countries: List<Country>) {
    fun print() {
        countries.forEach { println("${it.name}: ${it.population}") }
    }
}