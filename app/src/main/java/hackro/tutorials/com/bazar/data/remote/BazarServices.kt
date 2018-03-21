package hackro.tutorials.com.bazar.data.remote

import hackro.tutorials.com.bazar.data.model.ResponseListPost
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable
import java.util.*

/**
 * Created by macbookpro on 20/03/18.
 */
interface BazarServices{

    @GET("") fun getPostsFB(): Observable<ResponseListPost>
}