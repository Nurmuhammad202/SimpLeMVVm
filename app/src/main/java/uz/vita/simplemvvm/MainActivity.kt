package uz.vita.simplemvvm

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.vita.simplemvvm.data.local.room.model.Address
import uz.vita.simplemvvm.data.local.room.model.User

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val user = User()
        val address = Address("Bog'ishamol", "sa", "TOshkent", 1)
        user.userId = 1
        user.firstName = "nur"
        user.address = address
        mainViewModel.saveUserLocal(user)


        mainViewModel.getUserLocal().observe(this) {
            it.forEach { user ->
                Log.e(TAG, "onCreate: $user")
            }
        }

    }
}