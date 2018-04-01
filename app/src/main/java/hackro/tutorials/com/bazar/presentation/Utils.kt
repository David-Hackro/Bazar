package hackro.tutorials.com.bazar.presentation

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by macbookpro on 27/03/18.
 */
open class  Utils{

    open fun formatDate(date: String): String{
        try {

            val dt = SimpleDateFormat("YYYY-mm-dd'T'hh:mm:ss")
            val date = dt.parse(date)

            val dt1 = SimpleDateFormat("hh:mm a")


            var diferencie = (Date().time - date.time )/ (60 * 60 * 1000)

            if(diferencie <= 2067){
                return "Hace "+ diferencie.toString() + "  Horas"
            }else{

                return dt1.format(date)
            }

        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return ""
    }



   open fun getTitle(text: String): String {


       /* --------------------------------*/
       try {

           var parts = text.split("\n$")

           if(parts.isEmpty()){
               parts = text.split("\\n$")
           }

           return parts[0]

       } catch (e: Exception) {
           return ""
       }
    }

   open fun getPrice(text: String): String {
        try {

            var parts = text.split("\$", " - ")

            return "$"+parts[1]

        } catch (e: Exception) {
            return ""
        }

    }


    fun getLocalitation(text: String): String {
        try {

            var parts = text.split(" - ", "\\n\\n")

            return parts[1]

        } catch (e: Exception) {
            return ""
        }
    }


    open fun getDescription(text: String): String {
        try {
            var parts = text.split("\\n\\n")

            return parts[1]
        } catch (e: Exception) {
            return ""
        }

    }

}