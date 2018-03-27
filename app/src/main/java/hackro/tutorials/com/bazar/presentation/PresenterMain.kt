package hackro.tutorials.com.bazar.presentation

import hackro.tutorials.com.bazar.data.model.DataItem
import hackro.tutorials.com.bazar.data.model.ResponseListPost
import hackro.tutorials.com.bazar.domain.DefaultSubscriber
import hackro.tutorials.com.bazar.domain.usecase.GetPostFB
import javax.inject.Inject

/**
 * Created by macbookpro on 21/03/18.
 */
open class PresenterMain : Presenter<PresenterMain.View>{

    private var getPostFB: GetPostFB

    @Inject constructor(getPostFB: GetPostFB) : super() {
        this.getPostFB = getPostFB
    }

    override  fun initialize(){
        getItemsFB()
    }

    private fun getItemsFB() {
        getPostFB.execute(getPostFbFromObserver())
    }




    inner class getPostFbFromObserver : DefaultSubscriber<ResponseListPost>() {
        override fun onCompleted() {
            super.onCompleted()
            getView().hideLoading()
        }

        override fun onError(e: Throwable) {
            super.onError(e)
            getView().hideLoading()
            getView().showError(e.message.toString())

        }

        override fun onNext(response: ResponseListPost) {
            super.onNext(response)
            getView().showListPostFb(response.data)
        }
    }


    override fun setView(view: View) { super.setView(view) }


    interface View : Presenter.View {
        fun showListPostFb(list: List<DataItem?>?)
    }

    }