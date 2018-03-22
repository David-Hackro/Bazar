package hackro.tutorials.com.bazar.di.components

import dagger.Component
import hackro.tutorials.com.bazar.di.modules.AppModule
import hackro.tutorials.com.bazar.di.modules.BazarModule
import hackro.tutorials.com.bazar.presentation.activity.MainActivity

@Component(modules = arrayOf(BazarModule::class, AppModule::class))
interface AppComponent {

  fun inject(mainActivity: MainActivity)
}