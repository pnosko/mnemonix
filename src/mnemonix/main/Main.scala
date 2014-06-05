package mnemonix.main

import org.scaloid.common._
import mnemonix.components._

class Main extends SActivity {
  lazy val prefs = Preferences()
  lazy val isFirstRun: Boolean = prefs.executionCount(0) == 1

  def init {
    val ec = prefs.executionCount(0)
    prefs.executionCount = ec + 1

    if (isFirstRun) {
      prefs.batchSize = MnemonixConstants.defaultBatchSize
      prefs.cardShowIntervalMillis = MnemonixConstants.defaultCardShowIntervalMillis

      showHelp
    }
  }

  def askToRate = {
    val ec = prefs.executionCount(0)
    prefs.executionCount = ec + 1
    if (ec % 50 == 49 && !prefs.wontRate(false)) {
      new AlertDialogBuilder(null, "Please take a moment to rate it.") {
        positiveButton("Rate it", {
          //openUri("market://details?id=com.mnemonix.android")
          prefs.wontRate = true
        })
        neutralButton("Remind me later")
        negativeButton("No thanks", {
          prefs.wontRate = true
        })
      }.show()
    }
  }

  def showHelp {
    startActivity[ShowHelp]
  }

  onCreate {
    contentView = new SVerticalLayout {
      SButton(R.string.start_batch, { startActivity[RunBatch] })
      SButton(R.string.settings)
      SButton(R.string.help).onClick(showHelp)
      SButton(R.string.stats)
    } padding 20.dip
  }

  onStart {
    init
    showHelp
    askToRate
  }

}
