

package com.foreks.feed

import java.util.Comparator

object Traverse {
  var tree : MyTreeSetImpl[Integer]=new MyTreeSetImpl[Integer]("postorder",Comparator.naturalOrder())
  def main(args: Array[String]): Unit = {
    addTree()
    println(tree.size())
    println(tree.toString())
    var list = tree.toArray()
    list.toStream.foreach { x => println(x+" * ") }
  }
  def addTree(){
    tree.add(10)
    tree.add(20)
    tree.add(40)
    tree.add(5)
  }
}