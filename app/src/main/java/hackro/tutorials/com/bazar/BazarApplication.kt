package hackro.tutorials.com.bazar

import android.app.Application
import android.content.Context
import hackro.tutorials.com.bazar.di.components.AppComponent
import hackro.tutorials.com.bazar.di.components.DaggerAppComponent
import hackro.tutorials.com.bazar.di.modules.AppModule
import hackro.tutorials.com.bazar.di.modules.BazarModule

/**
 * Created by macbookpro on 20/03/18.
 */
class BazarApplication : Application() {

    private lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .bazarModule(BazarModule())
                .build()
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }


}