package hackro.tutorials.com.bazar.domain.usecase

import android.support.annotation.NonNull
import hackro.tutorials.com.bazar.data.repository.AppRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by macbookpro on 20/03/18.
 */
class GetPostFB : UseCase{

  private lateinit var appRepository: AppRepository

  @Inject constructor(appRepository: AppRepository) {
    this.appRepository = appRepository
  }

  override fun buildObservableUseCase(): Observable<*> {
    return appRepository.getPostsFB()
  }

}