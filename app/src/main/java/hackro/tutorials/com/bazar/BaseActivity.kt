package hackro.tutorials.com.bazar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by macbookpro on 19/03/18.
 */

abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId().toInt())
    }

      abstract  fun  getLayoutId():Integer

}