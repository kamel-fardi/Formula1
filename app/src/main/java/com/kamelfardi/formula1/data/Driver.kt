package com.kamelfardi.formula1.data

data class Driver(
    val driverId: String,
    val permanentNumber: String,
    val code: String,
    val url: String,
    val givenName: String,
    val familyName: String,
    val dateOfBirth: String,
    val nationality: String,
    val constructorName: String,
    val backgroundColor : Long
)
