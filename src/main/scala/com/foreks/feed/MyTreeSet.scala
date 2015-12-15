package com.foreks.feed

import scala.collection.mutable.ListBuffer


 trait MyTreeSet[T] {
  
  def  add(value :T)
  
  def contains(value : T) :Boolean
  
  def remove(value : T) : Boolean
  
  def size() :Integer
  
  def toArray() : ListBuffer[T]
  
  def toString() : String 
  
  def traverse(consumer : Generated.Consumer[T])
  
  def updateValue(value : T, newValue : T) : Boolean
  
  def getValue():T
  
  def setValue(value : T)
  
  def getLeftChild() : MyTreeSetImpl[T]
  
  def setLeftChild(leftChild : MyTreeSetImpl[T])
  
  def getRightChild(): MyTreeSetImpl[T]
  
  def setRightChild(rightChild : MyTreeSetImpl[T])
  
  def getRoot():Boolean
  
  def setRoot(root: Boolean)
}