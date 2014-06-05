package mnemonix.main

import org.scaloid.common._
import mnemonix.components._

class RunBatch extends SActivity {
  val batch = Batch.create
  //var progress = BatchState(batch)
  var index = 0
  var current = ("One", "Two")


  onCreate {
    contentView = new SVerticalLayout {
      STextView(index.toString)

      STextView(current._1)
      STextView(current._2)
    }
  }
}
