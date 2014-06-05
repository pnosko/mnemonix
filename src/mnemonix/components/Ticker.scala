package mnemonix.components

import rx.lang.scala._
/**
 * Created by Peter on 05-Jun-14.
 */
trait Ticker {
  val progress: Observable[Double]
}
