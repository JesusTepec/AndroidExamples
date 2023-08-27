package ui

import android.content.Intent
import com.example.apptest.App
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.apptest.R
import com.example.apptest.databinding.ActivityLoginBinding
import com.example.apptest.ui.MainActivity
import es.dmoral.toasty.Toasty
import com.example.apptest.viewmodel.LoginViewModel
import com.example.apptest.viewmodel.factory.LoginVMFactory
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    @Inject
    lateinit var factory: LoginVMFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).appCompoment.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
        setupListeners()
    }

    private fun setupListeners() {
        binding.buttonSend.setOnClickListener {
            validateDataLogin(
                binding.inputEmail.text.toString(),
                binding.inputPassword.text.toString()
            )
        }
    }

    private fun validateDataLogin(email: String, password: String) {
        if (email.isNotBlank() && password.isNotBlank()) {
            doLogin(email, password)
        } else {
            Toasty.error(this, "El campo Email o Pasword no deben quedar vacios").show()
        }
    }

    private fun doLogin(email: String, password: String) {
        viewModel.login(email, password).observe(this, {
            it?.let { isLogin ->
                if (isLogin) {
                    Toasty.success(this@LoginActivity, "Bienvenido").show()
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                }
                else
                    Toasty.error(
                        this@LoginActivity,
                        "Algo salio mal, vuelva a intentar por favor",
                        Toast.LENGTH_LONG
                    ).show()
            }
        })
    }
}