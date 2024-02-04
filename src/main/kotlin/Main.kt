package org.example
import Vehicles;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    var pessoa =  Person( "ferdinando", 19  );
    var  clothes =  PersonClothers(
                                         listOf<Clothe>( Clothe("t-shirt", 'M', null)    ),
                                        1
                           );


    // using anonymous class to implements AirPlaine 'Fly()' method
    var plane = ( object : Vehicles.AirPlaine{
            override fun Fly() {
                 println(" Airplane flying.....")
            }
    })

    // using lambda expression to subscribe the abstract method 'goToBacking'
    var car = Vehicles.Car {
            println(" Car going to back.....")
    }

    // overriding two methods of super interface Vehicles
    var genericVehicle = ( object: Vehicles{
            override fun accelerate(   acceleration :Int  ) :Unit {
                   println(" Airplane flying.....")
            }

            final override fun speed(   speed :Int  ) :String {  //  prohibit re-overriding
                   println(" Airplane flying.....")
                   return  speed.toString()
            }
    })


     //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello,  "+pessoa.getName(  null ) + "!    \n")

    println(" content:  ${clothes.clothes.get(0).name} ");

    println(" getCrossProduct:   ${getCrossProduct( X=2.4,  Y = 34.3, X2 = 2.3, Y2 =3.1  ) }  ")


    for (  i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i");
    }
}


data class PersonClothers( var clothes: List<Clothe>, val  amount :Int = 3 )

data class Clothe( var name :String,  val size :Char,  var color: java.awt.Color? )  // automatically generated methods:  equals(), hashCode(), toString() and copy()


open class Person{

        private lateinit var isWorking :BooleanArray

        private val name: String

        private  var age: Any?

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
