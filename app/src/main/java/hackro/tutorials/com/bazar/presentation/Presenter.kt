package hackro.tutorials.com.bazar.presentation

open class Presenter<T : Presenter.View> {

    private var view: T? = null

    open fun setView(view: T) {
        this.view = view
    }

    open fun getView(): T? {
        return view
    }

    open fun initialize() {

    }

    interface View {

        fun showLoading()

        fun hideLoading()

        fun showError(message: String)
    }
}