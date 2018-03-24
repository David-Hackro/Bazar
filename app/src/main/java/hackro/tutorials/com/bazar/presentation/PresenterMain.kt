package hackro.tutorials.com.bazar.presentation

import android.support.annotation.NonNull
import hackro.tutorials.com.bazar.data.model.DataItem
import hackro.tutorials.com.bazar.data.model.ResponseListPost
import hackro.tutorials.com.bazar.domain.DefaultSubscriber
import hackro.tutorials.com.bazar.domain.usecase.GetPostFB
import javax.inject.Inject

/**
 * Created by macbookpro on 21/03/18.
 */
open class PresenterMain : Presenter<PresenterMain.View>{

    private lateinit  var getPostFB: GetPostFB

    @Inject constructor(@NonNull getPostFB: GetPostFB) : super() {
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
        }

        override fun onError(e: Throwable) {
            super.onError(e)

        }

        override fun onNext(response: ResponseListPost) {
            super.onNext(response)

            getView()!!.showListPostFb(response.data)
        }
    }


    override fun setView(view: View) {
        super.setView(view)
    }

    override fun getView(): View? {
        return super.getView()
    }

    open interface View : Presenter.View {
        fun showListPostFb(list: List<DataItem?>?)
    }

    }