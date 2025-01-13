package bluefox.mobileapps.stocktracing.loginModule

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import bluefox.mobileapps.stocktracing.databinding.ActivityLoginBinding
import bluefox.mobileapps.stocktracing.loginModule.apiFunctions.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        dummyData()
        onClickListeners()
    }

    private fun onClickListeners()
    {
        binding.btLogin.setOnClickListener {
//           CallIntent.gotoHomeActivity(this,false,this)
        }
    }

    private fun dummyData()
    {
        loginViewModel.validateLogin()
        validateObserver()
    }

    private fun validateObserver()
    {
        loginViewModel.getLoginResponse().observe(this) {
            Log.e("Test",it.toString())
        }
    }
}