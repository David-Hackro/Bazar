package hackro.tutorials.com.bazar.presentation.activity

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.reservamos.viajes.presentation.adapter.providersDetail.ImageAdapter
import hackro.tutorials.com.bazar.R
import hackro.tutorials.com.bazar.presentation.BazarApplication
import hackro.tutorials.com.bazar.presentation.presenter.PresenterDetailItem
import kotlinx.android.synthetic.main.activity_detail_item.*
import javax.inject.Inject
import android.support.v7.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailItemActivity : BaseActivity(), PresenterDetailItem.View{

    private lateinit var imageAdapter : ImageAdapter
    lateinit var lLayout  : LinearLayoutManager

    @Inject lateinit var presenter : PresenterDetailItem

    override fun initView() {
        super.initView()
        initializeDagger()
        initializePresenter()
        initAdapter()
        initRecycler()
        hideToolbar()
        presenter.initialize()

    }

    private fun hideToolbar() {
        getSupportActionBar()!!.hide()
    }


    private fun initializeDagger() {
        val app = application as BazarApplication
        app.getAppComponent().inject(this)
    }

    private fun initializePresenter() {
        presenter.setView(this)
    }


    fun initAdapter(){
        imageAdapter = ImageAdapter(presenter)
    }

    fun initRecycler(){
        lLayout = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        //lLayout = GridLayoutManager(this, 1)
        rv_gallery.setLayoutManager(lLayout )
        rv_gallery.setAdapter(imageAdapter)
    }


    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_detail_item
    }

    override fun showImages(listImages: List<String>) {
        imageAdapter.addListImages(listImages)
    }

    override fun showImageProfile(url: String) {
        Glide.with(this).load(url).apply(RequestOptions.circleCropTransform()).into(img_profile);
    }

}
