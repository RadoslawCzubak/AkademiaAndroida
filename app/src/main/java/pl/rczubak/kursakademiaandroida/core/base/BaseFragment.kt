package pl.rczubak.kursakademiaandroida.core.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : BaseViewModel>(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    abstract val viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        initObservers()
        bindViewModelToLifecycle()
    }

    private fun bindViewModelToLifecycle() {
        lifecycle.addObserver(viewModel)
    }

    open fun initViews() {}

    open fun initObservers() {
        observeMessage()
        observeUIState()
    }

    private fun observeMessage() {
        viewModel.message.observe(viewLifecycleOwner) { message ->
            showToast(message)
        }
    }

    private fun observeUIState() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                UIState.Pending -> handlePendingState()
                UIState.Idle -> handleIdleState()
            }
        }
    }

    open fun handleIdleState() {}

    open fun handlePendingState() {}

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    protected fun showToast(@StringRes stringRes: Int) {
        showToast(getString(stringRes))
    }
}