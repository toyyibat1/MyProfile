import android.content.Context
import android.content.SharedPreferences
/**
 * Class for Shared Preference
 */
class PrefManager internal constructor(context:Context) {
    internal var context:Context
    val email: String?
        get() {
            val sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
            return sharedPreferences.getString("Email", "email")
        }
    val isUserLogedOut:Boolean
        get() {
            val sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
            val isEmailEmpty = sharedPreferences.getString("Email", "")?.isEmpty()
            val isPasswordEmpty = sharedPreferences.getString("Password", "")?.isEmpty()
            return isEmailEmpty!! || isPasswordEmpty!!
        }
    init{
        this.context = context
    }
    fun saveLoginDetails(email:String, password:String) {
        val sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("Email", email)
        editor.putString("Password", password)
        editor.commit()
    }
}