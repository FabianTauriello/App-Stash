package io.github.fabiantauriello.appstash.presenter

import java.lang.ref.WeakReference

// V = type of the view that the presenter communicates with
abstract class BasePresenter<V> {
    // I've used a weak reference because typically the concrete view is an activity
    // or fragment class and we need those view objects to be correctly garbage collected
    // when they are destroyed (e.g. when user rotates the device).
    private var view: WeakReference<V>? = null

    fun setView(view: V) {
        this.view = WeakReference(view)
    }

    protected fun getView(): V? = view?.get()
}