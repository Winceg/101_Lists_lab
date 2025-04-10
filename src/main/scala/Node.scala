class Node(var item: String, var next: Node) {
  override def toString: String = {
    s">> $item"
  }
}

class LinkedList {
  var head: Node = null

  def addToStart(s: String): Unit = {
    head = new Node(s, head)
  }

  def removeFirstElement(): Unit = {
    if (head != null) head = head.next
  }

  def getLastElement(): Node = {
    def lastElement(n: Node): Node = {
      if (n == null) null
      else {
        if (n.next == null) n else lastElement(n.next)
      }
    }

    lastElement(head)
  }

  def addToEnd(s: String): Unit = {
    if (getLastElement() != null) getLastElement().next = new Node(s, null) else addToStart(s)
  }

  def isPresent(e: String): Boolean = {
    def present(n: Node): Boolean = {
      if (n != null) {
        if (n.item == e) true
        else {
          if (n.next != null) present(n.next) else false
        }
      } else false
    }

    present(head)
  }

  def getSize(): Int = {
    def getSizeRec(n: Node): Int = {
      var res: Int = 1
      if (n == null) {
        res = 0
      }
      else {
        if (n != null && n.next != null) {
          res += getSizeRec(n.next)
        }
      }
      res
    }

    getSizeRec(head)
  }

  override def toString: String = {
    def getNode(n: Node): String = {
      var res: String = ""
      if (n != null) {
        res = n.item
        if (n != null && n.next != null) {
          res += " -> " + getNode(n.next)
        } else {
          res += " -> null"
        }
      } else {
        res += "null"
      }
      res
    }

    s"List content (size ${getSize()}) : ${getNode(head)}"
    //s"List : ${if(head != null) getNode(head) else "null"}"
    //s"List content (Size ${getSize}) : ${if(head == null) "null" else s"${head.item} -> ${if(head == null || head.next == null) "null" else head.next.item}"}"
  }

  def findElement(s: String): Node = {
    def present(n: Node): Node = {
      if (n != null) {
        if (n.item == s) n
        else {
          if (n.next != null) present(n.next) else null
        }
      } else null
    }

    present(head)
  }

  def swapElements(e1: String, e2: String): Unit = {
    if (isPresent(e1) && isPresent(e2)) {
      var temp: String = e1
      println(s"e1: $e1 - e2: $e2 - elem1: ${findElement(e1).item} - elem2: ${findElement(e2).item}")
      findElement(e2).item = e1
      findElement(e1).item = e2
      println(s"e1: $e1 - e2: $e2 - elem1: ${findElement(e1).item} - elem2: ${findElement(e2).item}")
      println("...............")
    } else {
      println("Une ou les deux escales n'existent pas sur l'itinéraire.")
    }
  }

  def removeLastElement(): Unit = {
    if(getLastElement() != null) {
      removeElement(getLastElement().item)
    }
  }

  def removeElement(s: String): Unit = {
    if (isPresent(s)) {
      def remove(n: Node): Node = {
        if (n.item == s) {
          return n.next
        }
        n.next = remove(n.next)
        n
      }

      head = remove(head)
      println(s"Suppression de $s sur l'itinéraire")
    } else {
      println("L'escale n'existe pas sur l'itinéraire.")
    }
  }

  def insertAfter(before: String, after: String): Unit = {
    if (findElement(before) != null) {
      var newNode: Node = new Node(after, findElement(before).next)
      findElement(before).next = newNode
    }
  }

}

object LinkedList extends App {
  var flightList: LinkedList = new LinkedList
  println(flightList)
  flightList.addToStart("Rome")
  println(flightList)
  flightList.addToStart("Paris")
  println(flightList)
  flightList.addToStart("Tokyo")
  println(flightList)
  flightList.addToStart("JFK")
  println(flightList)
  flightList.addToStart("Osaka")
  println(flightList)
  flightList.addToStart("Stockholm")
  println(flightList)

  flightList.removeFirstElement()
  println(flightList)

  println(flightList.getLastElement())
  println(flightList)

  flightList.addToEnd("Genève")
  println(flightList)
  var etape: String = "Sion"
  println(s"Est-ce que $etape est dans l'itinéraire ? ${flightList.isPresent(etape)}")
  etape = "Rome"
  println(s"Est-ce que $etape est dans l'itinéraire ? ${flightList.isPresent(etape)}")
  println(flightList.findElement(etape))

  println(flightList)
  flightList.swapElements(etape, "Tokyo")
  println(flightList)
  flightList.insertAfter("Paris", "Shangai")
  println(flightList)
  flightList.removeElement("Osaka")
  println(flightList)
  flightList.removeElement("Tokyo")
  println(flightList)

  flightList.removeLastElement()
  println(flightList)

  println("...........................")
  var n = new LinkedList()
  n.addToEnd("Cathy")
  n.addToEnd("Bob")
  n.addToEnd("Alice")
  println(n)
  n.swapElements("Alice", "Bob")
  println(n)
  n.swapElements("Cathy", "Alice")
  println(n)
  n.swapElements("Alice", "Cathy")
  println(n)
}