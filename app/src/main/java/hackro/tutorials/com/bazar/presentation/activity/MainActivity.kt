package hackro.tutorials.com.bazar.presentation.activity

import android.support.v7.widget.GridLayoutManager
import com.reservamos.viajes.presentation.adapter.providersDetail.PostsAdapter
import hackro.tutorials.com.bazar.R
import hackro.tutorials.com.bazar.data.model.DataItem
import hackro.tutorials.com.bazar.presentation.BazarApplication
import hackro.tutorials.com.bazar.presentation.PresenterMain
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(),PresenterMain.View{

  private lateinit var postAdapter : PostsAdapter
  private lateinit var lLayout: GridLayoutManager
  @Inject lateinit var presenter: PresenterMain

  override  fun initView (){

    initializeDagger()
    initializePresenter()
    initAdapter()
    initRecycler()
    presenter.initialize()

  }

  fun initAdapter(){
    postAdapter = PostsAdapter(presenter)
  }

  fun initRecycler(){
    lLayout = GridLayoutManager(this, 2)
    list_post.setLayoutManager(lLayout)
    list_post.setAdapter(postAdapter)
  }



  private fun initializeDagger() {
    val app = application as BazarApplication
    app.getAppComponent().inject(this)
  }

  private fun initializePresenter() {
    presenter.setView(this)
  }

  override fun getLayoutId(): Int {
    return  R.layout.activity_main
  }

  override fun showListPostFb(list: List<DataItem?>?) {
      postAdapter.addListPosts(list)
  }

  override fun showLoading() {
  }

  override fun hideLoading() {
  }

  override fun showError(message: String) {
  }
}
