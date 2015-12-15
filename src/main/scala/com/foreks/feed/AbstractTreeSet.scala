package com.foreks.feed

import org.omg.CORBA.Object
import java.util.Objects

abstract class AbstractTreeSet[T] extends MyTreeSet[T]{
  
  protected var strategy : TreeTraversal[T]=null;
  
  private var  inorder : TreeTraversal[T]= new TreeTraversal[T]{
    def traverse (tree :MyTreeSet[T] , traverser : Generated.Consumer[T]){
      if(tree.getRoot()==true){
        Objects.requireNonNull(tree)
        if(null != tree.getLeftChild()){
          inorder.traverse(tree.getLeftChild(), traverser)
        }
        traverser.accept(tree.getValue())
        if(null!=tree.getRightChild()){
          inorder.traverse(tree.getRightChild(), traverser)
        }
      }
    }
  }
  private var preorder : TreeTraversal[T] = new TreeTraversal[T]{
    def traverse (tree : MyTreeSet[T], traverser : Generated.Consumer[T]){
       if(tree.getRoot()==true){
        traverser.accept(tree.getValue())
        if(null != tree.getLeftChild()){
          preorder.traverse(tree.getLeftChild(), traverser)
        }
        
        if(null!=tree.getRightChild()){
          preorder.traverse(tree.getRightChild(), traverser)
        }
      }
    }
  }
  private var postorder : TreeTraversal[T]= new TreeTraversal[T]{
    def traverse( tree : MyTreeSet[T], traverser : Generated.Consumer[T]){
       if(tree.getRoot()==true){
        if(null != tree.getLeftChild()){
          postorder.traverse(tree.getLeftChild(), traverser)
        }
        if(null!=tree.getRightChild()){
          postorder.traverse(tree.getRightChild(), traverser)
        }
        traverser.accept(tree.getValue())
      }
    }
  }
  
  var map = Map("inorder"->inorder, "preorder"->preorder, "postorder"->postorder)
  
  def setStrategy(strategy : String){
    this.strategy=map(strategy)
  }
  def setStrategy(strategy : TreeTraversal[T]){
    this.strategy=strategy
  }
  def getStrategy():TreeTraversal[T]={
    return strategy
  }
}