import org.scalatest._
import stringsizer._

class StringSizerSuite extends FunSuite {
  test("sizing 3 strings") {
    val sizer = new StringSizer
    val size = sizer.totalStringSize(List("one", "two", "three"))
    assert(size === 11)
  }

  test("sizing 4 strings") {
    val sizer = new StringSizer
    val size = sizer.totalStringSize(List("one", "two", "three", "four"))
    assert(size === 15)
  }
}