trait FizzbuzzRule{
    val mVals: Array<Pair<Int, String>>

    fun isFizzbuzz(aNumber: Int): Boolean = mVals.any { _ -> aNumber % _.first == 0 }
    fun toFizzbuzz(aNumber: Int): String = mVals.filter { _ -> aNumber % _.first == 0 }.map{ _ -> _.second }.makeString(separator = "")
}