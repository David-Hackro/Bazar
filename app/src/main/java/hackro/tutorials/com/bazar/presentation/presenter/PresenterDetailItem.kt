package hackro.tutorials.com.bazar.presentation.presenter

import hackro.tutorials.com.bazar.data.model.DataItem
import hackro.tutorials.com.bazar.domain.usecase.GetPostFB
import javax.inject.Inject

open class PresenterDetailItem : Presenter<PresenterDetailItem.View> {

    @Inject constructor() : super() {

    }


    override  fun initialize(){
        showListImages()
    }

    private fun showListImages() {
        val list = listOf("https://http2.mlstatic.com/celular-usado-para-refaccion-samsung-note-5-D_NQ_NP_811355-MLM26497554258_122017-F.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Samsung_Galaxy_Note_4_black_with_S_Pen.jpg/220px-Samsung_Galaxy_Note_4_black_with_S_Pen.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3kttM-qq2l5JYFuEMEInL5wnOOvuU84bT82GpIMiIpziYoAUp",
                "https://http2.mlstatic.com/samsung-galaxy-note-5-dorado-32gb-sm-n920c-sin-caja-D_NQ_NP_272905-MLV25113795937_102016-F.jpg",
                "https://http2.mlstatic.com/celular-samsung-galaxy-j5-usado-D_NQ_NP_757394-MCO26421502127_112017-F.jpg")

        getView().showImages(list)

    }


    interface View : Presenter.View {
        fun showImages(listImages :List<String>)
    }

    fun onItemOnClick(url: String) {}

}