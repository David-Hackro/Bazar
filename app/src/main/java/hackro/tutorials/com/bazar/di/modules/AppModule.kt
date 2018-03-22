package hackro.tutorials.com.bazar.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by macbookpro on 20/03/18.
 */

@Module
class AppModule(var application: Application) {

  @Singleton @Provides fun providesApplication(): Application {
    return application
  }
}