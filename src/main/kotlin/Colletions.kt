package org.example


// ===================== MUTABLE LIST ===========================
val systemUsers: MutableList<PokeTypes> = mutableListOf( PokeTypes.NORMAL, PokeTypes.FIGHT, PokeTypes.BUG)
val sudoers:  List<PokeTypes> = systemUsers  // read-only list copy of 'systemUsers'

fun addSystemPokemon(  poke :PokeTypes   ){
      systemUsers.add( poke);
}
fun getPokemonList( ): List<PokeTypes>{
     return sudoers;
}

fun useColletions(){

    addSystemPokemon( PokeTypes.ELETRIC );
    println(" list of amount pokemons types:   ${getPokemonList().size }  ");

    getPokemonList().forEach {
          type -> println( "some useful info on user: $type " );
    }
}




// ===================== HASH MAP ===========================
const val PLAYERS_AND_SCORE :Int = 15
val PlayersPoints :MutableMap<String, Int> = mutableMapOf(   "John"  to 18,     "Elizabeth" to 27,        "Razor" to 5  )
                                        //     it's that :    ......... mutableMapOf(   Pair("John", 18),   Pair("Elizabeth", 27),    Pair("Razor", 5)  )
val PlayerPointsCopy  = PlayersPoints;

fun updateScore( playerId: String ){
        if(   PlayersPoints.containsKey(playerId)   ){
              println( "Updating the ''PlayersPoints'  MapList...." )
              var newScore :Int = PlayersPoints.getValue( playerId ) +PLAYERS_AND_SCORE;
              PlayersPoints[playerId] =  newScore
              println( "The player $playerId now has the value:  $newScore");
        }else{
              println("Not found a player with ID: $playerId.... ");
        }
}

fun geListPlayers(){
    PlayerPointsCopy.forEach{
            (k, v) -> println("player $k points: $v")
    }
}


fun funUtilsCollections(){
        val numbers  = listOf(1, -2, 3, -4, -7)
        val positives = numbers.filter { x -> x > 0  } // filtering number more high than zero
        val negatives = numbers.filter { it < 0} //the "it" expression defines that the boolean result expression will be returned

        println("\n Lista de botões: ")
        println("numbers:  $numbers")
        println("numbers:  $positives")
        println("numbers:  $negatives")
}

