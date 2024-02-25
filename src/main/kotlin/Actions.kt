package org.example
import Vehicle
import Vehicle.*

// ======  FILE FOR DECLARATION OF FUNCTIONS  =========

inline fun getCrossProduct(  X: Double, Y: Double, X2: Double, Y2: Double  ) :Double =  (X * X2) - (Y * Y2);

fun vargars(){

    fun printPokemons( vararg  messages :String ){
        println("values:  \n ")
        for( mess in messages)  println( mess)
    }

    fun printPokemonsByType( vararg  messages :String, title :String ){
        println("\n values: ")
        for( mess in messages)  println( mess)
    }

    fun log( vararg entries : String ){
        printPokemons( *entries ); // sending vararg to other vararg argument func
    }

    fun checkIsNullable( value :String? ) : Any {
        return value?.length ?:  "Yes"  // using the Elvis operator to indentify the nullable value. If value is null, returns 'false'
    }

    printPokemons( "Tyranitar", "Charizard", "Pikachu", "Dragonite")
    printPokemonsByType( "Hitmonlee", "Machamp", "", "Gallade", "Poliwrath", title = "Fighters pokemons" )
    log( "Lapras", "Shedinja", "Rhyhorn" )
    print("\nTEST  is nullable?  "+checkIsNullable( null ) );
}

fun <Z> mutableStackOf( vararg elements: Z) = MutableStack( *elements )

// When statement
fun cases( obj : Any){
        when( obj ){
                1 -> println(" is number one \n")
                "Hello" -> println(" Greeting \n")
                is Long -> println(" is a Long type \n")
                !is String -> println(" Not a String \n")
                else -> println(" Unknown \n")
        }
}

// When expression
fun whenAssign( obj :Any) : Any{

      val result = when(obj) {
             1 -> "one"
             "Hello" -> 1
             is Long -> false
             else -> 42
      }

      return result
}

fun maxValue( A: Int, B:Int) = if( A > B)  A else B  // if expession form, as "ternary operator"



 fun addIssue( currentIssues :MutableSet<String>, newIssue:String ) :Boolean{
        return  currentIssues.add( newIssue );
}
fun getStatusLog( isAdded:Boolean ) = if (isAdded) "registered correctly" else "marked as duplicate and rejected. "


fun funUtilsCollections(){
    val numbers  = listOf(1, -2, 3, -4, -7)
    val positives = numbers.filter { x -> x > 0  } // filtering number more high than zero
    val negatives = numbers.filter { it < 0} //the "it" expression defines that the boolean result expression between parameter and right-side value will be returned

    println("\n Lista de botões: ")
    println("numbers:  $numbers")
    println("positives:  $positives")
    println("negatives:  $negatives")

    println("\n\n Applying transformation to values of list with map: ")
    var doubled = positives.map { it -> it *2 } // redundant form
    var tripled = negatives.map {  it *3 } // indicated use

    println("\n Lista de numeros duplicados e triplicados:  ")
    println("positives duplicate number:  $doubled")
    println("negatives tripled numbers:  $tripled")

    val anyNegative :Boolean = numbers.any { it < 0 };
    val anyGT6 = numbers.any{ it > 6}
    print("\n numbers:  [$numbers]")
    println("Is there any number less than 0:  $anyNegative")
    println("\nIs there any number greater than 6:  $anyGT6")

    println("\n\n Using FlatMap that transforms lists items into in iterables:  ")
    val accessories = listOf( "shirts", "shoes", "pants", "cap" )
    val accessories2 = listOf( "wristwatch", "glasses", "chain", "bracelet" )
    val cart = listOf( accessories, accessories2)

    val normalMap : List<List<String>> = cart.map { it }
    val flatMap :List<String> = cart.flatMap { it }

    println("normal map:  $normalMap")
    println("flat map:  $flatMap")
}


fun usingDataClasses(){
    var user = User("Chris", 17);
    var secondUser = User("Chris",  id=17);
    var thirdUser = User(name= "Veronica", 10);

    println("=> Equals data class 'User':  $user");
    println("user == secondUser: ${user == secondUser}");  // true ( using equals() method overred implicity )
    println("user == thirdUser: ${user == thirdUser}");     // false

    println("\n=> Hashcode of data class User:   $user")
    println("user hashcode: "+user.hashCode()) // 2017699962
    println("second user hashcode: ${secondUser.hashCode()}") // 2017699962
    println("third user hashcode: ${thirdUser.hashCode()}") // 486777349

    // using the 'copy' for create a different memory reference as new instance of object but with identical properties and values
    println("\n=> Copy of reference data class User:   $user")
    println("user copy value: "+user.copy())                                          // { name="Chris",   id: 17 }
    println("user == user.copy: ${user == user.copy()}")               // true
    println("user === user.copy: ${user === user.copy()}")             // false
    println("user copy with name:  ${user.copy(name = "Victor")} ")   // { name="Victor",   id: 17 }
    println("user copy with id: ${user.copy(id = 29)}")                        // { name="Chris",   id: 29 }

    println("user first propertie:  ${user.component1()} ")                   // name= Chris
    println("user second propertie: ${user.component2() }")               //  id: 20
}


fun rentPriceWithObjectExpression( standard: Int, festivityDays: Int, specialDays : Int) : Unit{

    val dayRates = object {
          var standard: Int? = null
          var festivity: Int = 50 * festivityDays
          var special: Int = 100 * specialDays
          val example :Boolean? = null
    }

    val total = ((dayRates.standard ?: 0) + dayRates.festivity + dayRates.special );

    println("total price is: $total");
}


object Player{ // declaring a object with singleton pattern
    fun takeParams( username: String, password: String){
         println("the player '$username' has been login with password '$password''");
    }
}
fun useObjectDeclaration(){
    Player.takeParams("player tauz", "rap_Geek_123")
    // using a object Player as a singleton object pattern

    // using object for create a anonymous class to implements AirPlaine 'Fly()' method
    var plane = ( object : AirPlaine{
        override fun fly() {
            println(" Airplane flying.....")
        }
    })
    plane.fly()

    // using lambda expression to override the abstract method 'goToBacking' of interface 'Car'
    var car = Vehicle.Car {
        println(" Car going to back.....")
    }
    car.goToBacking();


    // overriding two methods of super interface Vehicles
    var genericVehicle = ( object: Vehicle  {
        override fun accelerate(   acceleration :Int  ) :Unit {
            println(" Airplane flying.....")
        }

        final override fun speed(   speed :Int  ) :String {  //  prohibit re-overriding
            println(" Airplane flying.....")
            return  speed.toString()
        }
    })
    genericVehicle.accelerate( 12);
    genericVehicle.speed(27)
}


//================== Functions Types =====================
fun InfixFunctions(){

    infix fun Int.timesOf( str: String) = str.repeat(this) // this is the first number before 'times'
    println("  using the infix function:   5 times 'Bye'   ");
    println("  "+(5 timesOf "Bye"));

    // the infix function native of Kotlin is the 'to' that creates a Pair object implicitly
    val pair = "Ferrari" to "Katrina"
    println("\n  infix 'to' to generate a Pair object:  $pair")

    // example of how 'to' works
    infix fun String.onto( secondString :String ) = Pair(this, secondString ) // this is the first String
    var keyVal = "McLaren" onto "Lucas"
    println("\n  value of 'McLaren onto Lucas':   $keyVal")

    val sophia = User("Sophia", id= 17)
    val claudia = User( name = "claudia", 20)

    // using a infix functions with Custom objects:
    sophia liked claudia


    println("\n\n======== Operator functions ============\n");

                            // 'times' represents the operator '*'
    operator fun Int.times(  word: String ) = word.repeat( this )
    println("  using operator fun to:  2 * Bye   =>  ${  2 * "Bye"  }");

                  // 'get' represents the operator '[...]'
    operator fun String.get( range: IntRange ) = this.substring( range)
    val str = "Always forgive your elements; nothing annoys them so much! "
    println("\n  using operator fun to str[0..14]  => ${ str[0..14] }");
}



//================== High Order Funcs =====================
fun highOrdeFunctions( X:List<Int>,  Y: List<Int>, sumTotal: ( List<Int>, List<Int>) ->  Int ): String   {
      return  sumTotal( X , Y).toString();
}





// =============== FORs ======================

/*
fun rangesWithIntChar(){

    for(i in 0..3){ // 0, 1, 2, 3
        print(i)
    }
    println();
    for(i in 0 until 3){ // 0, 1, 2
        print(i)
    }
    println();
    for(i in 2..8 step 3){ // 2, 5, 8
        print(i)
    }
    println();
    for(i in 3 downTo 0){ // 3, 2, 1, 0
        print(i)
    }
    println();
    for( c in 'a' .. 'h'){ // a, b, c, d, e, f, g, h
        print(c)
    }
    println();
    for( c in 'z' downTo 's'){ // z, y, x, w, v, u, t, s
        print(c)
    }
    println();
    for( c in 'z' downTo 's' step 2){ // z, x, v, t
        print(c)
    }
    println();

    if( 6 in 1.. 10){ println("number six is in range! ") }

    if( 16 !in 1.. 10){ println("number sixteen is not in range from 6 o 10!  ") }
}
*/