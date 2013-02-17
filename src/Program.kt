import java.util.Comparator

fun  main(args: Array<String>) {
    val tMap = InverseFizzbuzzLogic.getInverseFizzbuzzMap(1, 100, Fizzbuzz3and5()).mapValues { _ -> _.value.toString() }

    answer(tMap, listOf("hoge"))
    answer(tMap, listOf("fizz"))

    answer(tMap, listOf("Fizz"))
    answer(tMap, listOf("Buzz"))
    answer(tMap, listOf("FizzBuzz"))
    answer(tMap, listOf("Fizz", "Fizz", "Buzz"))
    answer(tMap, listOf("Fizz", "Buzz"))
    answer(tMap, listOf("Buzz", "Fizz"))
    answer(tMap, listOf("Fizz", "Buzz", "Fizz"))
    answer(tMap, listOf("Fizz", "Fizz"))
    answer(tMap, listOf("FizzBuzz", "Fizz"))
}

fun answer(aMap: Map<List<String>, String>, aInput: List<String>) =
        println("${aInput} => ${aMap.getOrElse(aInput, {() -> "Not found." })}")

class Fizzbuzz3and5: FizzbuzzRule {
    override val mVals: Array<Pair<Int, String>> = array(Pair(3, "Fizz"), Pair(5, "Buzz"))
}