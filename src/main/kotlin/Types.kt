package org.example

// ====== FILE FOR DECLARATION OF TYPES ENUMs =========

object Types {   // a singleton object
     const val pi: Double = 3.14334445456884
}

enum class PokeTypes{
       NORMAL, FIGHT,  PSYCHIC, GHOST, DARK, BUG, FLYING,
       ELETRIC, GROUND, WATER, GRASS, FIRE, ROCK, STEEL,
       POISON, DRAGON, FAIRY, ICE
}


enum class Colors( val rgb :Int){
        RED(0xFF0000),
        GREEN( 0x00FF00),
        BLUE( 0x0000FF),
        YELLOW( 0xFFFF00);

        fun containsRed() = (this.rgb and 0xFF0000 != 0)
}


