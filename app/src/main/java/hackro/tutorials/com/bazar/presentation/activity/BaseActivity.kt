package hackro.tutorials.com.bazar.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife

/**
 * Created by macbookpro on 19/03/18.
 */

abstract class BaseActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayoutId())
    initView()

  }

  public open fun initView() {
    bindView()
  }


  fun bindView() {
    ButterKnife.bind(this)
  }

  abstract fun getLayoutId(): Int

}