package org.example


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"

    var pessoa =  Person( "ferdinando", 19  );

    var  clothes =  PersonClothers(
                                         listOf<Clothe>( Clothe("t-shirt", 'M', null)    ),
                                        1
                           );

     //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello,  "+pessoa.getName(  null ) + "!    \n")

    println(" content:  ${clothes.clothes.get(0).name} ");



    for (  i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i");
    }
}


data class PersonClothers( var clothes: List<Clothe>, val  amount :Int = 3 );

data class Clothe( var name :String,  val size :Char,  var color: java.awt.Color? );


class Person{

         private lateinit var isWorking :BooleanArray;

         private val name: String;

         private  var age: Any?;

         constructor( nameReceived :String, ageReceived :Any?  ){
                this.name = nameReceived
                this.age = ageReceived;
        }


        fun getName(  anywayValue : Any? = 4 ) : String{
             return this.name;
       }
}