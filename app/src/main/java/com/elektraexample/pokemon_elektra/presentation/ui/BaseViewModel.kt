package  com.elektraexample.pokemon_elektra.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.elektraexample.pokemon_elektra.utils.Event

import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    protected val baseDisposable = CompositeDisposable()

    private val _showLoading = MutableLiveData<Event<Unit>>()
    val showLoading get() = _showLoading

    private val _hideLoading = MutableLiveData<Event<Unit>>()
    val hideLoading get() = _hideLoading

    private val _serviceError = MutableLiveData<Event<String?>>()
    val serviceError get() = _serviceError

    private val _connectionError = MutableLiveData<Event<Unit>>()
    val connectionError get() = _connectionError



    protected fun showLoading() {
        _showLoading.postValue(Event(Unit))
    }

    protected fun hideLoading() {
        _hideLoading.postValue(Event(Unit))
    }

    protected fun serviceError(message: String?) {
        hideLoading()
        _serviceError.postValue(Event(message))
    }


    override fun onCleared() {
        baseDisposable.dispose()
        super.onCleared()
    }



}