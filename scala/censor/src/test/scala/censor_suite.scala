import org.scalatest._
import censor._
import java.io.File

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

  test("censor with words from file") {
    val censor = new TestCensor()
    var dir = new File("").getAbsolutePath()
    var file = new File(dir, "src/test/assets/words.txt").toString()
    censor.blacklistFromFile(file)
    assert(censor.replaceWords("Darn Shoot me") === "Beans Plucky me")
  }
}