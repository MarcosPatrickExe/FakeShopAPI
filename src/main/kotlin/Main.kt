package org.example
import Vehicle
import Vehicle.*;
import java.awt.Color;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    var pessoa =  Person( "ferdinando", 19  );
    var  clothes =  PersonClothers(
                                         listOf<Clothe>(
                                                 Clothe("t-shirt", 'M', null),
                                                 Clothe(name  = "blue jeans", size = 'G', color= Color.blue )
                                         ),
                           1
   );


    // using anonymous class to implements AirPlaine 'Fly()' method
    var plane = ( object : AirPlaine{
            override fun fly() {
                 println(" Airplane flying.....")
            }
    })
    plane.fly()

    // using lambda expression to subscribe the abstract method 'goToBacking'
    var car = Vehicle.Car {
            println(" Car going to back.....")
    }
    car.goToBacking();


    // overriding two methods of super interface Vehicles
    var genericVehicle = ( object: Vehicle {
            override fun accelerate(   acceleration :Int  ) :Unit {
                   println(" Airplane flying.....")
            }

            final override fun speed(   speed :Int  ) :String {  //  prohibit re-overriding
                   println(" Airplane flying.....")
                   return  speed.toString()
            }
    })
    genericVehicle.accelerate( 12);
    genericVehicle.speed(27)


     //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello,  "+pessoa.getName(  null ) + "!    \n")

    println(" content:  ${clothes.clothes.get(0).name} ");

    println(" getCrossProduct:  ${getCrossProduct( X=2.4,  Y = 34.3, X2 = 2.3, Y2 =3.1  ) }  ")


    for (  i in 1..5) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
             println("i = $i");
    }

    println("\n ============== varargs ==================== \n");

    vargars();


    println("\n \n ============== Generics ==================== \n");

    var myStack  = MutableStack<String>(  "Empoleon", "Pinsir", "Infernape", "Torterra", "Drapion",  "Murkrow", "Honchkrow", "Excadrill", "Gabite" );

    myStack.push("Togetic")
    println( myStack )
    println( " last element: {$myStack.peek()} " )

    for( i in 1..myStack.getSize() ){
         println( " removing element: ${myStack.pop()} ");
    }

    val mutablesByFun = mutableStackOf<String>(   "Eevee", "Flareon", "Vaporeon", "Umbreon", "Joteon",  "Glaceon", "Leafeon"   );
    println( mutablesByFun);

    // OU TBM:
    val ages: MutableList<Int> = mutableListOf<Int>( 23, 15, 45, 17, 65, 18, 19, 20 );
    val agesCopy: List<Int> = ages
    ages.add(78)
    ages.add(101)
    println(  "\nNew values addited to 'ages'. See now the values of 'agesCopy' below: ");

    agesCopy.forEach {  item -> print("$item, "); }
    println("Max value: ${
            maxValue( 
                    agesCopy.get(index =1 ),
                    agesCopy.get(2)
            )
    } ");

    // agesCopy.add()  is forbbiden! The List type é unmutable

    println("\n \n============== Flow control ==================== \n");

    println("When Statement")
    cases( obj = 23L )

    println("When Expression \n ${whenAssign(  Example()  )}");


    println("\n ============== Iterating ==================== \n");

    val pokemons = HashMap<String, PokeTypes>();
    pokemons.put("Blastoise", PokeTypes.WATER )
    pokemons.put("Ursaring",  PokeTypes.NORMAL )
    pokemons.put("Salamence",  PokeTypes.DRAGON )
    pokemons.put("Ekans",  PokeTypes.POISON )

    var pokes  = Pokemons( pokemons )

    for (poke  in  pokes.getPokes() ){
            println(" pokemon name is  ${ poke.toPair().first}  of type  ${ poke.toPair().second} "  )
    }
    //rangesWithIntChar();


    println("\n ============== Collections ==================== \n");
    useColletions();

    val openIssues : MutableSet<String> = mutableSetOf("uniqueDescr1", "uniqueDescription", "unique", "unique 2");
    val issueDuplicated= "unique"

    println("\n-> Adding value to Set collection:  \n${
          getStatusLog(
                addIssue(  currentIssues = openIssues,  newIssue = "uniqueDesc4") 
          )
    }");
    println("\n-> Adding value to the Set with duplicated values:  \n${
        getStatusLog(
               addIssue(  currentIssues = openIssues,  newIssue = issueDuplicated)
        )
    }");


    println("\n================= MAPs ====================\n");
    println("-> Listing initial players'.... \n");
    getListPlayers();

    println("\n-> Updanting score of the player 'John'.... ");
    updateScore( "John" );
    updateScore( playerId = "Brenda" ); // example using the nomead example
    getListPlayers();


    println("\n================= collection util funcs ====================\n");
    funUtilsCollections()

    println("\n================= Polymorphism ====================\n");

    val tiger :Tiger = SiberianTiger( "from malasiaaaaaa")
    tiger.roar();


    println("\n\n================= Data class ====================\n");
    usingDataClasses();


    println("\n\n================= Enums ====================\n");
    val red :Colors = Colors.RED
    println( red );                                                // RED
    println( red.containsRed() );                       // true
    println( Colors.BLUE.containsRed() )        // false
    println( Colors.YELLOW.containsRed() )  // true
    println( Colors.GREEN.containsRed() )   // false


    println("\n\n================= Sealed classes ====================\n");
    val cat :Mammal =  Cat("Sebastian" )
    greetMammal(  Human("Mariana", "worker") as Mammal );
    greetMammal(  cat as Mammal );


    println("\n\n================= Object keyword ====================\n");
    rentPrice( 10, 2, 1);

}






