package censor

trait Censor {
  var list = Map[String,String]()

  def blacklist(words:Map[String,String]) {
    this.list = words
  }

  def replaceWords(sentance:String):String = {
    ""
  }
}