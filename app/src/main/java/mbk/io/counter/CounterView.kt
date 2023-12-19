package mbk.io.counter

interface CounterView {

    fun showCount(count:Int)

    fun changeVisible(isVisibility: Boolean)

    fun showToast(message: String)

    fun changeTextColor()

}