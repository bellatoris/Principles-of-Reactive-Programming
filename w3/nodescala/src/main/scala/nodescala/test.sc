import scala.concurrent.Future
import nodescala._
import scala.language.postfixOps
import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global

val working = Future.run() { ct => Future {
  while (ct.nonCancelled) { println("working")
  }
  println("done") }
}
Future.delay(5 seconds) onSuccess {
  case _ => working.unsubscribe() }