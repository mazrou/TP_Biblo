package com.khaldi.biblo.ui.model

import java.util.*

data class Seance(
    val module: Module?  ,
    val time : String? =null ,

)

fun getListSeance() : List<Seance> {
 return listOf(
  Seance(
   Module("TDM" , utility = "Technique de devlopement Mobile" , 50 ,Teacher("Batata" , "Soufiane", "Maitre assistan") )
      , "08:30 - 12:30")
 )
}
