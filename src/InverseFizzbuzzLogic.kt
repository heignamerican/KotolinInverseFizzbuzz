class InverseFizzbuzzLogic {
    class object {
        fun getInverseFizzbuzzMap(aStart: Int, aEnd: Int, aRule: Fizzbuzz3and5): Map<List<String>, Result> {
            return  (aStart..aEnd).flatMap { y-> IntRange(aStart, y - 1).map { x -> x..y } } // とりうるすべての fizzbuzz 入力数列候補
                    .map { x -> x.toList().filter { _-> aRule.isFizzbuzz(_) } } // fizzbuzz 数のみの数列へ変換
                    .filterNot { _ -> _.isEmpty() } // 空リストは不要
                    .groupBy { _ -> _ }.keySet() // 等しい入力数列ごとにグループ化。重複を取り除くナイスな方法が不明・・・
                    .map { x -> Pair(x.map { y -> aRule.toFizzbuzz(y) }, Result.from(x)) } // ここで逆 fizzbuzz の連想配列へ。以降、入力は fizzbuzz 文字列・出力が fizzbuzz 数列
                    .groupBy { _ -> _.first } // 等しい入力 fizzbuzz 文字列ごとでグループ化
                    .mapValues { entry -> entry.value.map { pair -> pair.second }.sortBy { _ -> _ }.first!! } // 解となる最小幅|開始数の入力 fizzbuzz 数列を返す
        }

        class Result(val start: Int, val end: Int): Comparable<Result> {
            class object {
                fun from(list: List<Int>): Result = Result(list.first!!, list.last!!)
            }
            /**
            * ソート順
            *  1. 幅が小さい
            *  2. 開始数が小さい
            */
            override fun compareTo(other: Result): Int {
                val lengthDiff = (end - start) - (other.end - other.start)
                return when(lengthDiff){
                    0 -> start - other.start
                    else -> lengthDiff
                }
            }
            fun toString(): String = when {
                start == end -> "[${start}]"
                else -> "[${start},${end}]"
            }
        }
    }
}