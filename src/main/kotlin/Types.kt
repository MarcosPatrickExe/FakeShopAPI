package org.example

import kotlin.math.log

object Types {   // a singleton object
     const val pi: Double = 3.14334445456884
}

inline fun getCrossProduct(  X: Double, Y: Double, X2: Double, Y2: Double  ) :Double =  (X * X2) - (Y * Y2);


fun vargars(){

     fun printPokemons( vararg  messages :String ){
          println("values:  \n ")
          for( mess in messages)  println( mess)
     }

     fun printPokemonsByType( vararg  messages :String, title :String ){
          println("values:  \n ")
          for( mess in messages)  println( mess)
     }

     fun log( vararg entries : String ){
          printPokemons( *entries ); // sending vararg to other vararg argument func
     }

     printPokemons( "Tyranitar", "Charizard", "Pikachu", "Dragonite")
     printPokemonsByType( "Hitmonlee", "Machamp", "", "Gallade", "Poliwrath", title = "Fighters pokemons" )
     log( "Lapras", "Shedinja", "Rhyhorn" )


}
