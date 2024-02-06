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

      val result = when(obj){
             1 -> "one"
             "Hello" -> 1
             is Long -> false
             else -> 42
      }

      return result
}

fun max( A: Int, B:Int) = if( A > B) A else B  // if expession form, as "ternary operator"




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