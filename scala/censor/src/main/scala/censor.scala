package censor

trait Censor {
  var words = Map[String,String]()

  def blacklist(words:Map[String,String]) {
    this.words = words
  }

  def replaceWords(sentance:String):String = {
    this.words.foldLeft(sentance){(result, replacement) => result.replaceAll(replacement._1, replacement._2)}
  }
}