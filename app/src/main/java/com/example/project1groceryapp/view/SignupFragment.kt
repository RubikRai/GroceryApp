package com.example.project1groceryapp.view

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.project1groceryapp.R
import com.example.project1groceryapp.databinding.FragmentSignupBinding
import org.json.JSONObject

class SignupFragment : Fragment() {

    lateinit var binding:FragmentSignupBinding

    lateinit var requestQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestQueue = Volley.newRequestQueue(this.context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(layoutInflater,container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.buttonAlreadyHaveAnAccount.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.frame_layout_create_account_page, LoginFragment())?.addToBackStack("goToLogIn")?.commit()
        }

        binding.imageviewClose.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.frame_layout_create_account_page, StartFragment())?.addToBackStack("goToStartPage")?.commit()
        }

        binding.buttonSignup.setOnClickListener{
            saveUserDetails()
        }

    }

    private fun saveUserDetails() {
        var userDetails = JSONObject()
        userDetails.put("FirstName", binding.edittextFirstName.text.toString())
       // userDetails.put("LastName", binding.edittextLastName.text.toString())
        //userDetails.put("Address", binding.edittextAddress.text.toString())
        userDetails.put("Mobile", binding.edittextMobile.text.toString())
        userDetails.put("email", binding.edittextEmail.text.toString())
        userDetails.put("Password", binding.edittextPassword.text.toString())

        val pd = ProgressDialog(this.context)
        pd.setMessage("Please wait while we register your details>>>")
        pd.setCancelable(false)

        val request = JsonObjectRequest(
            Request.Method.POST,
            "https://grocery-second-app.herokuapp.com/api/auth/register",
            userDetails,
            {response ->
                var error = response.getBoolean("error")
                var message = response.getString("message")
                Toast.makeText(context,"User has been registered successfully",Toast.LENGTH_SHORT).show()

                pd.dismiss()
            },
            {error ->
                Toast.makeText(context, "The user could not be registered successfully",Toast.LENGTH_SHORT).show()
                pd.dismiss()
            }

        )
        requestQueue.add(request)
        pd.show()
    }


}