package hackro.tutorials.com.bazar.data.repository

import hackro.tutorials.com.bazar.data.model.ResponseListPost
import hackro.tutorials.com.bazar.data.remote.AppRemoteData
import rx.Observable

/**
 * Created by macbookpro on 20/03/18.
 */
class AppRepository : DataSource {

    private lateinit var remoteData: AppRemoteData

    override fun getPostsFB(): Observable<ResponseListPost> {
        return remoteData.getPostsFB()
    }

}