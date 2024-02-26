package org.example
import Vehicle
import Vehicle.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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
    private var token = "sdssddddw3434334343"
    fun takeParams( username: String, password: String){
         println("the player '$username' has been login with password $password  and token: '${this.token}''");
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



//===================== High Order Funcs =======================
fun templateFunc( X:List<Int>,  Y: List<Int>, scalarProduct: ( List<Int>, List<Int>) ->  Int ): String   {
      return  scalarProduct( X , Y).toString();
}

fun highOrdeFunctionsAsParameter( ){
    val vetorA = listOf( 3,  -5);
    val vetorB = listOf( -20 , 35 )

    fun funScalarProduct( a : List<Int>, b: List<Int> ) =  (a[0] * b[0])  +  (a[1] * b[1])

    var result = templateFunc( X= vetorA , Y= vetorB, ::funScalarProduct   ); // sending a callback function with ::
    println("  the Scalar product between a( 3, -5)  and   b( -20, 35) is:  $result")

    // alternative 2:  replacing the callback function
    var result2 = templateFunc( vetorA , vetorB) {
            a:List<Int>, b:List<Int>    ->    a[0]*b[0]    //  ( a, b) -> a[0] * b[0]
    }
    // or using func dynamic declaration
    println("  alternative result a(3) * b(-20):   $result2 ");
}


fun highOrderFunctionsAsReturn() : (Double) -> Long {

    // declaring a function
    fun square( n1:Double ) = (n1 * n1).toLong() // OR:   fun square( n1:Double ): Long {  return (n1 * n1).toLong()  }

    // returning the func reference
    return ::square // returning a function "square() "
}



//===================== Lambda funcs =======================
fun lambdaFunExamples(){

             // typing the lambda func
    val upperCase1: (String) -> String = { str: String -> str.uppercase()  }

              // no typing the lambda with inferred of type parameter
    val upperCase2: (String) -> String = { str -> str.uppercase()  } // erternal inference

             // typing the lambda with inferred return type
    val upperCase3 = { str :String -> str.uppercase()  } // internal inference

            // using 'it' reference to only ONE parameter function:
    val upperCase4 :(String) -> String = { it.uppercase() }

          // adding the uppercase function reference directly to variable
    val upperCase5 :(String) -> String = String::uppercase

    println(" ${upperCase1("type word in uppercase! ")}  \n" +
                " ${upperCase2("type word in uppercase! ")}  \n" +
                " ${upperCase3("type word in uppercase! ")}  \n" +
                " ${upperCase4("type word in uppercase! ")}  \n" +
                " ${upperCase5("type word in uppercase! ")}  \n");
}




//=============== Extension funcs and Propetiers =======================
data class Item( val name: String, val price: Float );

data class Order( val items : Collection<Item> )

// using a extension properties for class 'Order'
val Order.commaDelimitedItemNames: String get() = items.map{ it.name }.joinToString()
// overwriting the Get() func


fun extensionsFunctions(){

    // adding the extensions functions to class 'Order'
    fun Order.maxPricedItemValue() : Float = this.items.maxByOrNull { it.price }?.price ?: 0F ;
    // OR
    /*
    fun Order.maxPricedItemValue() : Float {
         var valu :Item? =  this.items.maxByOrNull { it.price }

         if( valu ==null)
             return 0F

         return valu.price
    }
    */

    fun Order.maxPricedItemName() :String = this.items.maxByOrNull { it.price }?.name ?: "NO_PRODUCTS"

    val order = Order(
            listOf(
                    Item("Bread", 25.5f ),
                    Item("Wine", 29.1f ),
                    Item("Water", 5.1f ),
            )
    )
    println("Max priced item value: ${order.maxPricedItemValue()}" );
    println("Max priced item name: ${order.maxPricedItemName()}" );
    println("Items:  ${order.commaDelimitedItemNames}" );
}




//=============== Extension Funcs Generics=======================

fun extensionsFunctionsGenerics(){

    println("\n    [ Extension Functions Generics: ]  ");
      fun  <T> T?.nullSafeToString() = this?.toString() ?: "Absence of value because is NULL"
      var isNull = null.nullSafeToString()
      println(" 'null.nullSafeToString' =>  $isNull")
      println(" 'kotlin.nullSafeToString' =>  ${ "Kotlin".nullSafeToString() } ")
}
//==================== END =================================




//=============== Extension Funcs Generics=======================
// declaring the suspend function
suspend fun doSomethingUsefulOne()  = coroutineScope{
    launch {
        println(" processing data.....");
        delay(3000L)
        println(" DATA LOADED !!!  ")
    }
}

fun executeTheSuspendFunc() = runBlocking {
    // should be called only from a coroutine function scope
    println(" Starting reading asynchronous data ")
    doSomethingUsefulOne();
}

class User2(val id: Int, val name: String)

/*
 * No Kotlin, a declaração de um objeto (por meio da palavra-chave object)
 * é uma maneira concisa e eficaz de implementar o padrão Singleton.
 */
object UserManager {

    private val users = mutableListOf<User>()

    fun addUser( user: User) {
        this.users.add(user);
        // TODO("Implementar a lógica de adicionar um novo usuário na lista mutável $users.")
    }


    fun listUsers() {
        this.users.forEach { println("${it.id} - ${it.name}") }
        println(this.users);

        /// TODO("Implementar a impressão dos $users, seguindo o padrão definido no enunciado.")
    }
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