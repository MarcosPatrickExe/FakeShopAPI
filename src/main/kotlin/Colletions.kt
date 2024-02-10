package org.example

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

