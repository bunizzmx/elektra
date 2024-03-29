package  com.elektraexample.pokemon_elektra.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.elektraexample.pokemon_elektra.utils.Event

import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {

    private val _showLoading = MutableLiveData<Event<Unit>>()
    val showLoading get() = _showLoading

    private val _hideLoading = MutableLiveData<Event<Unit>>()
    val hideLoading get() = _hideLoading

}