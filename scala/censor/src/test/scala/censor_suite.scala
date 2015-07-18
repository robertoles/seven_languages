import org.scalatest._
import censor._

class CensorSuite extends FunSuite {
  var words:Map[String,String] = Map()

  class TestCensor extends Censor {}

  test("censors single word") {
    val censor = new TestCensor()
    censor.blacklist(Map("Shoot" -> "Plucky"))
    assert(censor.replaceWords("Dont Shoot me") === "Dont Plucky me")
  }

  
}