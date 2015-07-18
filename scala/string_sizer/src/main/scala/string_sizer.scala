package stringsizer

class StringSizer() {
  def totalStringSize(strings:List[String]):Int = {
    strings.foldLeft(0)((size, string) => size + string.length)
  }
}