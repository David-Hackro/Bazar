package hackro.tutorials.com.bazar.data.remote

import hackro.tutorials.com.bazar.data.model.ResponseListPost
import retrofit2.http.GET
import rx.Observable

/**
 * Created by macbookpro on 20/03/18.
 */
interface BazarServices {

  @GET("getpostsfb") fun getPostsFB(): Observable<ResponseListPost>
}