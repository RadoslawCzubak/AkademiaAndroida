package pl.rczubak.kursakademiaandroida.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

open class BaseViewModel : ViewModel() {

    private val _uiState = MutableLiveData<UIState>(UIState.Idle)
    val uiState: LiveData<UIState> = _uiState

    private val _message by lazy {
        LiveEvent<String>()
    }
    val message: LiveData<String> = _message

    protected fun showMessage(message: String) {
        _message.value = message
    }

    protected fun setPendingState() {
        _uiState.value = UIState.Pending
    }

    protected fun setIdleState() {
        _uiState.value = UIState.Idle
    }

    protected fun handleFailure(throwable: Throwable) {
        throwable
            .message?.let {
                showMessage(it)
            }
    }
}