package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"

    var pessoa =  Person( "ferdinando", 19  );
     //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello,  "+pessoa.getName(  null ) + "!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i");
    }
}


class Person{

         private lateinit var isWorking :Integer;

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