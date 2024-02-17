package org.example

import Vehicle

// ====== FILE FOR DECLARATION CLASSES =========

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


class Teste : Person, Vehicle.Car {
    constructor( nam: String, ag: Any? ) : super(nam, ag)

    override fun goToBacking() {
            println(" goToBacking on Teste class...")
    }
}


//================== Generics  ====================

class MutableStack<E> ( vararg items: E  ){

    private var elements :MutableList<E> = items.toMutableList();

    fun push( newElement: E ) = this.elements.add( newElement );
    fun peek(): E = this.elements.last();
    fun pop(): E = this.elements.removeAt( elements.size-1 );
    fun isEmpty() :Boolean = this.elements.isEmpty()
    fun getSize() :Int = this.elements.size;

    override fun toString(): String {
          return "MutableStack( ${elements.joinToString()} ) "
    }
}

class Example

class Pokemons<V, PokeTypes> {

    private val pokemons :HashMap<V, PokeTypes>;

    constructor( newAnimals: HashMap<V, PokeTypes> ){
            this.pokemons = newAnimals;
    }

    public fun getPokes() :HashMap<V, PokeTypes>{
          return this.pokemons;
    }

    operator fun iterator():  MutableIterator<MutableMap.MutableEntry<V, PokeTypes>>{ // making class iterable
           return this.pokemons.iterator()
    }
}





/*
    List<out T> in Kotlin is equivalent to List<? extends T> in Java.
    List<in T> in Kotlin is equivalent to List<? super T> in Java
*/
