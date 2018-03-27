package hackro.tutorials.com.bazar.data.repository

import hackro.tutorials.com.bazar.data.model.ResponseListPost
import hackro.tutorials.com.bazar.data.remote.AppRemoteData
import rx.Observable
import javax.inject.Inject

/**
 * Created by macbookpro on 20/03/18.
 */
class AppRepository : DataSource {

  private var remoteData: AppRemoteData

  @Inject constructor(remoteData: AppRemoteData) {
    this.remoteData = remoteData
  }


  override fun getPostsFB(): Observable<ResponseListPost> {
    return remoteData.getPostsFB()
  }

}