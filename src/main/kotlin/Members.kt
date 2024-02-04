package org.example


data class PersonClothers( var clothes: List<Clothe>, val  amount :Int = 3 )

data class Clothe( var name :String,  val size :Char,  var color: java.awt.Color? )  // automatically generated methods:  equals(), hashCode(), toString() and copy()


open class Person{

    private lateinit var isWorking :BooleanArray

    private val name: String

    private var age: Any?

    constructor( nameReceived :String, ageReceived :Any?  ){
            this.name = nameReceived
            this.age = ageReceived
    }


    fun getName(  anywayValue : Any? = 4 ) : String{
            return this.name
    }
}


class Teste : Person, Vehicles.Car {

    constructor( nam: String, ag: Any? ) : super(nam, ag)

    override fun goToBacking() {
            println(" goToBacking on Teste class...")
    }
}