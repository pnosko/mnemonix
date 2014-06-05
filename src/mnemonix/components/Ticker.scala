package mnemonix.components

import rx.lang.scala._
import org.scaloid.common._
import scala.concurrent.duration._

trait Ticker {
  type WordPair = (String, String)

  val progress: Observable[Double]
  val next: Observable[WordPair]
  def start: Unit
  def skip: Unit
}

object Ticker {
  def create(prefs: Preferences): Ticker = {
//    val step = prefs.cardShowIntervalMillis(MnemonixConstants.defaultCardShowIntervalMillis)
//    val stepCount = prefs.batchSize(MnemonixConstants.defaultBatchSize)
    new Ticker {
      val progress: Observable[Double] = Observable.never //Observable.interval(step milliseconds).take(stepCount)
      val next: Observable[WordPair] = Observable.never
      def start = {}
      def skip = {}
    }
  }
}