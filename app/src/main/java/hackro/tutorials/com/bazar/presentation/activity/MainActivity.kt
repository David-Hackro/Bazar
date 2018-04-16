package hackro.tutorials.com.bazar.presentation.activity

import android.support.v7.widget.GridLayoutManager
import com.reservamos.viajes.presentation.adapter.providersDetail.PostsAdapter
import hackro.tutorials.com.bazar.R
import hackro.tutorials.com.bazar.data.model.DataItem
import hackro.tutorials.com.bazar.presentation.BazarApplication
import hackro.tutorials.com.bazar.presentation.PresenterMain
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import android.support.v7.widget.StaggeredGridLayoutManager
import android.content.Intent







class MainActivity : BaseActivity(),PresenterMain.View{

  private lateinit var postAdapter : PostsAdapter
  private lateinit var lLayout: GridLayoutManager
  private var gaggeredGridLayoutManager: StaggeredGridLayoutManager? = null
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
    gaggeredGridLayoutManager  = StaggeredGridLayoutManager(2, 1)

    lLayout = GridLayoutManager(this, 2)
    list_post.setLayoutManager(gaggeredGridLayoutManager)
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

  override fun showDetailItem(dataItem: DataItem) {
    super.showDetailItem(dataItem)
    val intent = Intent(this, DetailItemActivity::class.java)

    //intent.putExtra("keyIdentifier", value)

    startActivity(intent)


  }
}
