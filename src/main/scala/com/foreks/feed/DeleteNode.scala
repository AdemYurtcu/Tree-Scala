package com.foreks.feed

class DeleteNode[T] {
  var parent: MyTreeSetImpl[T] = null
  var changeNode: MyTreeSetImpl[T] = null
  var replecement: MyTreeSetImpl[T] = null
  var right: Boolean = false
  var left: Boolean = false

  def deleteNode(node: MyTreeSetImpl[T], value: T): Boolean = {
    if (node.getRoot() == false) {
      return false
    }
    if (node.comparator.compare(node.getValue(), value) == 0) {
      if (node.getLeftChild() == null && node.getRightChild() == null) {
        if (parent != null) {
          if (this.right == true) {
            this.parent.setRightChild(changeNode)
          } else {
            parent.setLeftChild(changeNode)
          }
        } else {
          node.setRoot(false)
        }
      }
      if (node.getLeftChild() != null && node.getRightChild() != null) {
        right=false
        left =false
        node.setValue(minNodeValue(node))
        return true
      }
      if (node.getLeftChild() != null) {
        if (this.parent != null) {
          if (this.left == true) {
            this.parent.setLeftChild(node.getLeftChild());
          } else {
            this.parent.setRightChild(node.getLeftChild());
          }
          return true;
        } else {
          node.setValue(node.getLeftChild().getValue());
          node.setLeftChild(this.changeNode);
          return true;
        }
      }
      if (node.getRightChild() != null) {
        if (this.parent != null) {
          if (this.right == true) {
            this.parent.setRightChild(node.getRightChild());
          } else {
            this.parent.setLeftChild(node.getRightChild());
          }
          return true;
        } else {
          node.setValue(node.getRightChild().getValue());
          node.setRightChild(this.changeNode);
          return true;
        }
      }
    }
    this.parent = node;
    if (node.comparator.compare(node.getValue(), value) > 0) {
      this.left = true;
      this.right = false;
      return deleteNode(node.getLeftChild(), value);
    }
    if (node.comparator.compare(node.getValue(), value) < 0) {
      this.right = true;
      this.left = false;
      return deleteNode(node.getRightChild(), value);
    }
    return false;
  }

  def minNodeValue(node: MyTreeSetImpl[T]): T = {
    if (node.getLeftChild() == null) {
      val value: T = node.getValue()
      if (node.getRightChild() != null) {
        if (this.left == false) {
          this.replecement.setRightChild(node.getRightChild());
          return value;
        } else {
          this.replecement.setLeftChild(node.getRightChild());
          return value;
        }
      } else {
        if (this.left == false) {
          this.replecement.setRightChild(changeNode);
          return value;
        } else {
          this.replecement.setLeftChild(changeNode);
          return value;
        }
      }
    }
    replecement = node
    if (right == false) {
      right = true
      return minNodeValue(node.getRightChild())
    } else {
      left = true
      return minNodeValue(node.getLeftChild())
    }
  }
}