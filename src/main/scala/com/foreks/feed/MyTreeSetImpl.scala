package com.foreks.feed

import java.util.Comparator
import scala.collection.mutable.ListBuffer

class MyTreeSetImpl[T](var value :T) extends AbstractTreeSet[T] {

  private  var leftChild : MyTreeSetImpl[T]=null
  private var rightChild : MyTreeSetImpl[T]=null
  private var root: Boolean = false 
  var comparator: Comparator[T] = null
  
  
  def this(strategy :String ,value :T , comprator : Comparator[T]){
    this(value)
    super.setStrategy(strategy)
    this.comparator=comprator
    this.root=true
  }
  def this (strategy : String , comprator : Comparator[T]){
    this(null.asInstanceOf[T])
    super.setStrategy(strategy)
    this.comparator=comprator
  }
  def this (strategy : TreeTraversal[T],value :T , compator : Comparator[T]){
    this(value)
    super.setStrategy(strategy)
    this.comparator=compator
    this.root=true
  }
  
  override def add(value :T ){
    if(this.getRoot()==false){
      this.setValue(value)
      this.setRoot(true)
    }else if(this.comparator.compare(value, this.getValue())<=0){
      if(this.getLeftChild()==null){
        this.leftChild=new MyTreeSetImpl[T](super.getStrategy(),value,this.comparator)
      }else {
        this.getLeftChild().add(value)
      }
    }else {
      if(this.getRightChild()==null){
        this.rightChild= new MyTreeSetImpl[T](super.getStrategy(),value,this.comparator)
      }else {
        this.getRightChild().add(value)
      }
    }
  }
  override def contains(value :T):Boolean = { 
    var t : MyTreeSetImpl[T] = this
    if(this.getRoot()==true){
      while(t != null){
        if(t.comparator.compare(value, t.getValue())==0){
          return true
        }else if(t.comparator.compare(value, t.getValue())<0){
          t=t.getLeftChild()
        }else {
          t=t.getRightChild()
        }
      }
    }
    return false 
  }
  override def remove(value : T) : Boolean={
    var del : DeleteNode[T]= new DeleteNode[T]
    return del.deleteNode(this, value)
  }
  
  override def size() :Integer={
    var array =new ListBuffer[T]
    this.traverse((i:T) => array +=i)
    return array.length
  }
  
  override def toArray() : ListBuffer[T] ={
    var array =new ListBuffer[T]
    this.traverse((i:T) => array+=i)
    return array
  }
  
  override def toString() : String ={
    var sb :StringBuilder =new StringBuilder()
    this.traverse((i:T) => sb.append(i.toString()+"-") ) 
    return sb.toString()
  }
  
  override def traverse(traversal : Generated.Consumer[T]){
    super.getStrategy().traverse(this, traversal)
  }
  
  override def updateValue(value : T, newValue : T) : Boolean={
    var bool: Boolean = remove(value)
    if(bool==true){
      add(newValue)
      return true
      }
    return false 
  }
  
  override def getValue():T ={
    return this.value
  }
  
  override def setValue(value2 : T){
    this.value=value2
  }
  
  override def getLeftChild() : MyTreeSetImpl[T]={
    return leftChild
  }
  
  override def setLeftChild(leftChild : MyTreeSetImpl[T]){
    this.leftChild=leftChild
  }
  
  override def getRightChild(): MyTreeSetImpl[T]={
    return rightChild
  }
  
  override def setRightChild(rightChild : MyTreeSetImpl[T]){
    this.rightChild=rightChild
  }
  
  override def getRoot():Boolean={
    return root
  }
  
  override def setRoot(root: Boolean){
    this.root=root
  }
}