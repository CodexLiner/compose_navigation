package com.paragon.navigation
object DeepLinks {
    private const val baseUri = "http://meenagopal24.live"
    val HOME = "$baseUri/route?route=home"
    val profile = "$baseUri/route?route=profile"
    val settings = "$baseUri/route?route=settings"
    val book = "$baseUri/route?route=book&data={data}"
}