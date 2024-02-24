package org.example

import Vehicle

// ====== FILE FOR DECLARATION CLASSES =========

data class PersonClothers( var clothes: List<Clothe>, val  amount :Int = 3 )

data class Clothe( var name :String,  val size :Char,  var color: java.awt.Color? )  // automatically generated implicity methods:  equals(), hashCode(), toString() and copy()
// os campos declarados nos construtores ja sao automaticamente reconhecidos pelos metodos da classe Object comentados acima.



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


/// exemplo de polimorfismo
open class  Tiger( val origin :String, var color: String ){
     fun roar() {
          println("Tiger roar sound from: $origin with color $color")
     }

    companion object { // creating a anonymous internal class
            private var color :Colors = Colors.ORANGE;
            fun toHunt(){ // method of the class and not of the instance!
                  print("tiger is to hunting! Tiger color is ${this.color} \n")
            }
    }
}
class SiberianTiger( roar:String) : Tiger( origin = roar, color= "black")
// or: class SiberianTiger( roar:String) : Tiger( origin = roar, "black")
// ===========================


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

data class User( var name: String, var id: Int ){
        override fun equals( other: Any? ) = other is User && other.id == this.id
}

sealed class Mammal( var name: String ); // A sealed class only can be extended by subclasses when are the same package

class Cat( val catName: String ) : Mammal( name= catName )
class Human( val humanName :String, val job: String ): Mammal( humanName )

fun greetMammal( mammal: Mammal ) :Unit{
         when( mammal ){
                is Cat -> println("Hello ${ mammal.name }! ")
                is Human -> println("Hello ${mammal.name}! You're working as a ${mammal.job} ")
        }
}


data class  Machine  <D>( var name :String, var dimensions: Any?,  var powerWatts :Int  ){
                                        // every Data Classes requires a primary constructor as above

    constructor() : this( "", dimensions=  listOf(0, 0, 0), 20 )
    //  overload of the constructor class
}