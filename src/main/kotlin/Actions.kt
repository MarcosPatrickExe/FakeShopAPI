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


fun cases( obj : Any){
        when( obj ){
                1 -> println(" is number one \n")
                "Hello" -> println(" Greeting \n")
                is Long -> println(" is a Long type \n")
                !is String -> println(" Not a String \n")
                else -> println(" Unknown \n")
        }
}

fun whenAssign( obj :Any) : Any{

      val result = when(obj){
             1 -> "one"
             "Hello" -> 1
             is Long -> false
             else -> 42
      }

      return result
}