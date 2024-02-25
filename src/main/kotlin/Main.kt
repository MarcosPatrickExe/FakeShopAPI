package org.example
import Vehicle
import Vehicle.*;
import java.awt.Color;
import java.util.Vector

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val namee = "Kotlin"
    var pessoa = Person("ferdinando", ageReceived = 19);
    var clothes = PersonClothers(
        listOf<Clothe>(
            Clothe("t-shirt", 'M', null),
            Clothe(name = "blue jeans", size = 'G', color = Color.blue)
        ),
        1
    );

    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello,  " + pessoa.getName(null) + "!    \n")

    println(" content:  ${clothes.clothes.get(0).name} ");

    println(" getCrossProduct:  ${getCrossProduct(X = 2.4, Y = 34.3, X2 = 2.3, Y2 = 3.1)}  ")


    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i");
    }

    println("\n ============== varargs ==================== \n");
    vargars();

    println("\n \n ============== Generics ==================== \n");

    var myStack = MutableStack<String>(
        "Empoleon",
        "Pinsir",
        "Infernape",
        "Torterra",
        "Drapion",
        "Murkrow",
        "Honchkrow",
        "Excadrill",
        "Gabite"
    );

    myStack.push("Togetic")
    println(myStack)
    println(" last element: {$myStack.peek()} ")

    for (i in 1..myStack.getSize()) {
        println(" removing element: ${myStack.pop()} ");
    }

    val mutablesByFun =
        mutableStackOf<String>("Eevee", "Flareon", "Vaporeon", "Umbreon", "Joteon", "Glaceon", "Leafeon");
    println(mutablesByFun);

    // OU TBM:
    val ages: MutableList<Int> = mutableListOf<Int>(23, 15, 45, 17, 65, 18, 19, 20);
    val agesCopy: List<Int> = ages
    ages.add(78)
    ages.add(101)
    println("\nNew values addited to 'ages'. See now the values of 'agesCopy' below: ");

    agesCopy.forEach { item -> print("$item, "); }
    println(
        "Max value: ${
            maxValue(
                agesCopy.get(index = 1),
                agesCopy.get(2)
            )
        } "
    );

    // agesCopy.add()  is forbbiden! The List type é unmutable

    println("\n \n============== Flow control ==================== \n");

    println("When Statement")
    cases(obj = 23L)

    println("When Expression \n ${whenAssign(Example())}");


    println("\n ============== Iterating ==================== \n");

    val pokemons = HashMap<String, PokeTypes>();
    pokemons.put("Blastoise", PokeTypes.WATER)
    pokemons.put("Ursaring", PokeTypes.NORMAL)
    pokemons.put("Salamence", PokeTypes.DRAGON)
    pokemons.put("Ekans", PokeTypes.POISON)

    var pokes = Pokemons(pokemons)

    for (poke in pokes.getPokes()) {
        println(" pokemon name is  ${poke.toPair().first}  of type  ${poke.toPair().second} ")
    }
    //rangesWithIntChar();


    println("\n ============== Collections ==================== \n");
    useColletions();

    val openIssues: MutableSet<String> = mutableSetOf("uniqueDescr1", "uniqueDescription", "unique", "unique 2");
    val issueDuplicated = "unique"

    println(
        "\n-> Adding value to Set collection:  \n${
            getStatusLog(
                addIssue(currentIssues = openIssues, newIssue = "uniqueDesc4")
            )
        }"
    );
    println(
        "\n-> Adding value to the Set with duplicated values:  \n${
            getStatusLog(
                addIssue(currentIssues = openIssues, newIssue = issueDuplicated)
            )
        }"
    );


    println("\n================= MAPs ====================\n");
    println("-> Listing initial players'.... \n");
    getListPlayers();

    println("\n-> Updanting score of the player 'John'.... ");
    updateScore("John");
    updateScore(playerId = "Brenda"); // example using the nomead example
    getListPlayers();


    println("\n================= collection util funcs ====================\n");
    funUtilsCollections()

    println("\n================= Polymorphism ====================\n");

    val tiger: Tiger = SiberianTiger("from malasiaaaaaa")
    tiger.roar();


    println("\n\n================= Data class ====================\n");
    usingDataClasses();


    println("\n\n================= Enums ====================\n");
    val red: Colors = Colors.RED
    println(red);                                                // RED
    println(red.containsRed());                       // true
    println(Colors.BLUE.containsRed())        // false
    println(Colors.YELLOW.containsRed())  // true
    println(Colors.GREEN.containsRed())   // false


    println("================= Sealed classes ====================\n");
    val cat: Mammal = Cat("Sebastian")
    greetMammal(Human("Mariana", "worker") as Mammal);
    greetMammal(cat as Mammal);


    println("\n\n================= Object keyword ====================\n");
    rentPriceWithObjectExpression(10, festivityDays = 2, 1);
    useObjectDeclaration();
    Tiger.toHunt();


    println("\n\n======== Funções de Escopo (Let, Run, With, Apply, Also funcs ) ============\n");
    println(" [ USING Let FUNCTION:  ] ");

    val empty = "example text".let { value ->
        println(value.toLowerCase());
        value.isEmpty();// always the last instruction line will be returned to variable!
    }
    // OR
    val empty2 = "any word here".let {
        println(it)
        it.isEmpty()// always the last instruction line will be returned to variable!
    }
    println("empty is $empty  //  empty2 is $empty2");  // empty is false // empty2 is false

    empty2?.let {// execute this code escope when value not be a null
            firstParameter ->
        empty.let { secondParameter ->
            println(
                "show this message when empty2, or '$firstParameter', not be a " +
                        "null value and '$secondParameter' might be a null or a " +
                        "anyway value  "
            );
        }
    }

    println("\n [ USING Run FUNCTION: ] ");
    // differently of the Let, the Run() contains a 'this' reference to object that was referenced
    // instead the "it" variable. The "this" refers to the object that is calling the run(), as: objectName.run()

    val userrr: User? = User(name = " Alex", 29);

    var nameOfUserLength = userrr?.run {                                               // without 'this'
        println("the name of user is ${this.name} and ID is '${id}'");
        this.name.length
    } ?: 0  // using the elvis operator to return 0 if 'usr' is null
    println("\n name user received from run() return: $nameOfUserLength ");


    println("\n [ USING With FUNCTION: ] ");

    val machine: Machine = Machine(name = "Automotive robot", listOf(10, 10, 2), 30, id = 32332L);
    with(machine) {
        println("accessing by a fun With() the machine '$name' , his ID is equals '$id' and power is $powerWatts ");
    }

    // alternative:
    machine.run {
        println("accessing by a fun Run() the machine '$name' , his ID is equals '$id' and power is $powerWatts \" ");
    }
    // instead of println("....... ${playerTwo.name} ....... ${playerTwo.id} ");


    println("\n [ USING Apply FUNCTION: ] ");
    // apply allows change the properties of object

    var machine2 = Machine();

    var idChecked: Boolean =
        machine2.apply { // apply() requires that constructor properties must be declared with 'var' instead 'val'
            name = "Jake"
            dimensions = listOf(23, 213, 89)
            this.id = 182  // also you can be use 'this' too
            powerWatts = 300
        }.checkIdMachine()   // calling method of class 'Machine'

    println(
        "now, using 'Apply()' func, machine name is ${machine.name}, ID: '${machine.id}', " +
                "powerWatts: ${machine.powerWatts} and dimensions: ${machine.dimensions}"
    );

    machine2.let { machineReference ->
        idChecked.let {
            if (it == true)
                println("ID of machine ${machineReference.name} is so high")
            else
                println("ID of machine ${machineReference.name} is so low")
        }
    }

    println("\n [ USING Also FUNCTION: ] ");
    // this fun Also() looks Let() fun with 'it' variable already declared implicitly,
    //  but it returns a object reference as Apply() function to do a additional action

    var newMachine = Machine(name = "Chappie", null, 2000, id = 238238).also {
        it.writeCreationlog(obj = it) // sending the recently Machine() instance created
    }


    println("\n\n======== Infix functions ============\n");
    InfixFunctions();


    println("\n\n======== High-Order functions ============\n");
    highOrdeFunctionsAsParameter()


    val funReturned: (Double) -> Long =
        highOrderFunctionsAsReturn() // Getting the function from 'highOrderFunctionsAsReturn( )'
    println(
        "\n  value of de fun 'funReturned()'  sending the 27.5 as parameter " +
                "and it square is  =>\n  ${funReturned(27.5)}"
    );


    println("\n\n======== Lambda functions ============\n");
    lambdaFunExamples();


    println("======== Extension functions ============\n");
    extensionsFunctions()
}





