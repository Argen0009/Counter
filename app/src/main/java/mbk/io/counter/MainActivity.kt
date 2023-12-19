package mbk.io.counter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import mbk.io.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {

    lateinit var binding: ActivityMainBinding

    val presenter = Injector.getPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
        presenter.attachView(this)
    }

    private fun initClickers() {
        with(binding) {
            incBtn.setOnClickListener {
                presenter.increment()
            }
            decBtn.setOnClickListener {
                presenter.decrement()
            }
            changeVisible.setOnClickListener {
                presenter.changeVisible()
            }
        }
    }

    override fun showCount(count: Int) {
        binding.resultTv.text = count.toString()
    }

    override fun changeVisible(isVisible: Boolean) {
        binding.resultTv.isVisible = isVisible
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeTextColor() {
        binding.resultTv.setTextColor(ContextCompat.getColor(this, R.color.green))
    }

}