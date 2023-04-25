import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import android.widget.Toast

class FirebaseAuthClass {
    private var mAuth: FirebaseAuth? = null

    init {
        mAuth = FirebaseAuth.getInstance()
    }

    fun signUpNewUser(email: String, password: String, context: Context) {
        mAuth!!.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign up success, update user's profile
                    val user = mAuth!!.currentUser
                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setDisplayName("New User")
                        .build()

                    user!!.updateProfile(profileUpdates)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // User profile updated
                                Toast.makeText(context, "Sign up successful!", Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    // Sign up fails
                    try {
                        throw task.exception!!
                    } catch (e: FirebaseAuthUserCollisionException) {
                        Toast.makeText(context, "This email address is already registered!", Toast.LENGTH_SHORT).show()
                    } catch (e: FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(context, "Invalid email address or password!", Toast.LENGTH_SHORT).show()
                    } catch (e: Exception) {
                        Toast.makeText(context, "Sign up fails!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }
}