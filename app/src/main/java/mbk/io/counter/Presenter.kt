package mbk.io.counter

class Presenter {

    private var model = Injector.getModel()

    private lateinit var view: CounterView

    fun increment() {
        val shouldShowToastOrChangeColor = model.inc()
        view.showCount(model.count)

        if (shouldShowToastOrChangeColor) {
            when (model.count) {
                10 -> view.showToast("Поздравляем!")
                15 -> view.changeTextColor()
            }
        }
    }

    fun changeVisible() {
        if (model.isVisible) {
            model.changeVisibility(false)
        } else {
            model.changeVisibility(true)
        }
        view.changeVisible(model.isVisible)
    }

    fun attachView(view: CounterView) {
        this.view = view
    }

    fun decrement() {
        model.dec()
        view.showCount(model.count)
    }
}