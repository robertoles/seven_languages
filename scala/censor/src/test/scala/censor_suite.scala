import org.scalatest._
import censor._

class CensorSuite extends FunSuite {
  var words:Map[String,String] = Map()

  class TestCensor extends Censor {}

  test("censor with single word") {
    val censor = new TestCensor()
    censor.blacklist(Map("Shoot" -> "Plucky"))
    assert(censor.replaceWords("Dont Shoot me") === "Dont Plucky me")
  }

  test("censor with multiple words") {
    val censor = new TestCensor()
    censor.blacklist(Map("Shoot" -> "Plucky", "Darn" -> "Beans"))
    assert(censor.replaceWords("Darn Shoot me") === "Beans Plucky me")
  }
}