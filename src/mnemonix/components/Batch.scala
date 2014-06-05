package mnemonix.components

trait Batch {

}

object Batch {
  def create: Batch = {
    new Batch {}
  }
}
//
//trait BatchState {
//  def remaining: Int
//  def pair: (String, String)
//  def nextState: BatchState
//}
//
//case class BasicBatchState(cards: CardSet) extends BatchState {
//  def remaining: bat
//}
//
//object BatchState {
//  def apply(b: Batch) = new BatchState {}
//}
