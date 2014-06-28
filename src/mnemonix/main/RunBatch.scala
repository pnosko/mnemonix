package mnemonix.main

import org.scaloid.common._
import mnemonix.components._
import scala.language.postfixOps

class RunBatch extends SActivity {
//  val batch = Batch.create
  var current = ("One", "Two")
//
//  val ticker: Ticker = Ticker.create(Preferences())
//
//  var progressBar: SProgressBar = _
//
//  def init {
//    ticker.progress.subscribe(updateTimeProgress(_))
//  }
//
//  def updateTimeProgress(portion: Double) {
//    this.progressBar.setProgress((portion * 100).toInt)
//  }
//
//  def skipToNext {
//    this.ticker.skip
//  }

  onCreate {
    contentView = new SVerticalLayout {
      STextView("0")

      STextView(current._1)
      STextView(current._2)
      SProgressBar()
      SButton(R.string.card_skip)
    }  padding 20.dip
  }
}
