package hackro.tutorials.com.bazar.presentation

import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * Created by macbookpro on 27/03/18.
 */
open class  Utils{

    open fun formatDate(date: String): String{
        try {

            val dt = SimpleDateFormat("YYYY-mm-dd'T'hh:mm:ss")
            val date = dt.parse(date)
            val dt1 = SimpleDateFormat("hh:mm a")
            return dt1.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return ""
    }


}