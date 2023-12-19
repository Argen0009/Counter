package mbk.io.counter

class Injector {
    companion object{

        fun getPresenter()= Presenter()

        fun getModel() = CounterModel()
    }
}