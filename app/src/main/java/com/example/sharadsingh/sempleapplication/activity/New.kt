package com.example.sharadsingh.sempleapplication.activity




class New : MyInterface {
    override val test: Int = 25
    override fun foo() = "Lol"
    fun main(args: Array<String>) {
        val obj = New()
        println("test = ${obj.test}")
        print("Calling hello(): ")

        obj.hello()

        print("Calling and printing foo(): ")
        println(obj.foo())
    }
}