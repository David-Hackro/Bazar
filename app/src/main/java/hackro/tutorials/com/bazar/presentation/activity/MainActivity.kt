package hackro.tutorials.com.bazar.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hackro.tutorials.com.bazar.R

class MainActivity : BaseActivity() {

  override  fun initView (){

    initializeDagger()
    initializePresenter()
    //presenter.initialize()

  }

  private fun initializeDagger() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  private fun initializePresenter() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getLayoutId(): Int {
    return  R.layout.activity_main
  }

}
