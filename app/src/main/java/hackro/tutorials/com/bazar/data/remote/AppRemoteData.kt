package hackro.tutorials.com.bazar.data.remote

import hackro.tutorials.com.bazar.data.repository.DataSource
import hackro.tutorials.com.bazar.data.model.ResponseListPost
import org.jetbrains.annotations.NotNull
import retrofit2.Retrofit
import rx.Observable
import javax.inject.Inject

/**
 * Created by macbookpro on 20/03/18.
 */
class AppRemoteData @Inject constructor(@NotNull private var retrofitBazar: Retrofit) : DataSource {

    override fun getPostsFB(): Observable<ResponseListPost> {
        return retrofitBazar.create(BazarServices::class.java).getPostsFB()
    }
}