var nameList: List[String] = List("Jean", "Paul", "Marc", "Bob")
var searchedName: String = "Paul"

println(if (nameList.contains(searchedName)) nameList(nameList.indexOf(searchedName)) + " est dans la liste" else searchedName + " n'est pas dans la liste")

var nameList2: List[String] = nameList.filter(_ != "Paul")

println(nameList2.mkString(" "))
var nameList3: List[String] = nameList :+ ("Marie")
println(nameList.mkString(" "))
println(nameList2.mkString(" "))
println(nameList3.mkString(" "))




var AnameList: Array[String] = Array("Jean", "Paul", "Marc", "Bob")
var searchedName: String = "Paul"

println(if (AnameList.contains(searchedName)) AnameList(nameList.indexOf(searchedName)) + " est dans la liste" else searchedName + " n'est pas dans la liste")

var AnameList2: Array[String] = AnameList.filter(_ != "Paul")

println(AnameList2.mkString(" "))
var AnameList3: Array[String] = AnameList :+ ("Marie")
println(AnameList.mkString(" "))
println(AnameList2.mkString(" "))
println(AnameList3.mkString(" "))