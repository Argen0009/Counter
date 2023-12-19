package mbk.io.counter

class CounterModel {
    var count = 0

    var isVisible = true

    fun changeVisibility(isVisible :Boolean){
        this.isVisible = isVisible
    }

    fun inc(): Boolean {
        count++
        return count == 10 || count == 15
    }

    fun dec() {
        count--
    }
}