package org.example

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
    var tripled = negatives.map {  it *3 } //

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