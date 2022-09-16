package com.shopbook.shopbook

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShopBookApplication

fun main(args: Array<String>) {
	runApplication<ShopBookApplication>(*args)
}
