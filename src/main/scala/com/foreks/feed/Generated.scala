package com.foreks.feed
import java.{ util => ju }, ju.{ stream => jus, function => juf }, jus._
import scala.annotation.unchecked.{ uncheckedVariance => uV }
object Generated {
   implicit final class Consumer[-T](f: T => Object) extends juf.Consumer[T @uV] { def accept(x: T): Unit = f(x) }
}