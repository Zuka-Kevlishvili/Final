package com.example.finalproject

class User {

    var id : Int = 0
    var name : String = ""
    var age : Int = 0
    var height : Int = 0
    var weight : Int = 0

    constructor(name : String, age : Int, height : Int, weight : Int) {
        this.name = name
        this.age = age
        this.height = height
        this.weight = weight
    }

    constructor() {
    }

}