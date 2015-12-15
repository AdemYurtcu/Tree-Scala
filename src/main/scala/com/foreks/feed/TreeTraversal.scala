package com.foreks.feed

trait TreeTraversal[T] {
  def traverse (t : MyTreeSet[T],cons : Generated.Consumer[T])
  
}