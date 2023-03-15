package karazin.scala.users.group.week1.homework

/* 
  Custom implementation of Option (Maybe monad in Haskell)
  Implemented via Scala 3 way for Algebraic Data Types (ADT)
  
  Resources:
  * https://en.wikipedia.org/wiki/Algebraic_data_type
  * https://docs.scala-lang.org/scala3/book/types-adts-gadts.html
*/
import reflect.Selectable.reflectiveSelectable

object adt:

  enum ErrorOr[+V]:

    case Value(value: V)
    case Error(error: Throwable)


    /*
      The method is used for defining execution pipelines
      Provide a type parameter, an argument and a result type

      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
    */
    def flatMap[U](f: V => ErrorOr[U]): ErrorOr[U] = this match {
      case Value(value) => f(value)
      case Error(error) => Error(error)
    }


    /*
      The method is used for changing the internal object
      Provide a type parameter, an argument and a result type

      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
     */
    def map[U](f: V => U): ErrorOr[U] = this match {
      case Value(value) => Value(f(value))
      case Error(error) => Error(error)
    }


  // Companion object to define constructor
  object ErrorOr:
    /*
      Provide a type parameter, an argument and a result type

      Make sure that in case of failing the method with exception
      no exception is thrown but the case for an error is returned
    */

    def apply[V](f: => V): ErrorOr[V] =
      try Value(f) catch { case e: Throwable => Error(e) }