package censor
import scala.io.Source

trait Censor {
  var words = Map[String,String]()

  def blacklist(words:Map[String,String]) {
    this.words = words
  }

  def blacklistFromFile(fileName:String) {
    this.words = Source.fromFile(fileName).getLines().map{pair => 
      var result = pair.split(":") 
      new Tuple2(result(0), result(1))
    }.toMap
  }

  def replaceWords(sentance:String):String = {
    this.words.foldLeft(sentance) { (result, replacement) => 
      result.replaceAll(replacement._1, replacement._2)
    }
  }
}