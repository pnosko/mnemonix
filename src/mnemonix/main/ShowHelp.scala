package mnemonix.main

import org.scaloid.common._

class ShowHelp extends SActivity {

  onCreate {
    contentView = new SVerticalLayout {
      STextView(R.string.help_text).<<.wrap.>>
      STextView(R.string.help_begin)
      SButton(R.string.help_begin_button).onClick(startActivity[RunBatch])
    }  padding 20.dip
  }
}
