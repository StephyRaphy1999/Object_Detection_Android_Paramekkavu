package com.example.a_eye;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import Network.ApiClientCustom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Objects;

public class signupblind extends AppCompatActivity {
public EditText name,email,phone,address,password,cpassword;
public Button upload,signup;
public String namedata,emaildata, phonedata, addressdata, passworddata, cpassworddata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupblind);
        name=(EditText)findViewById(R.id.busername);
        email=(EditText)findViewById(R.id.bemail);
        phone=(EditText)findViewById(R.id.bphone);
        address=(EditText)findViewById(R.id.baddress);
        password=(EditText)findViewById(R.id.bpassword);
        cpassword=(EditText)findViewById(R.id.bcpassword);
        upload=(Button)findViewById(R.id.bupload);
        signup=(Button)findViewById(R.id.bsignup);
        signup.setOnClickListener(view -> {
            Log.d("API_Response", "****2222***");

            JsonObject registrationData =  regdata();
            if (registrationData != null) {
                Log.d("API_Response", "****2222***");
                try {
                    retrofit2.Call<JsonObject> call = ApiClientCustom.getInterface().blind(registrationData);
                    Log.d("API_Response", "****3333***");
                    call.enqueue(new Callback<JsonObject>() {
                        @Override
                        public void onResponse(retrofit2.Call<JsonObject> call, Response<JsonObject> response) {
                            JsonObject object = response.body();
                            String d=response.body().toString();
                            Gson gson = new Gson();
                            Toast.makeText(signupblind.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

//                            ResponseCommon responseCommon = gson.fromJson(object.toString(), ResponseCommon.class);
//                            Log.d("ResponseCode", responseCommon.getResponseCode());
//                            if (responseCommon.getResponseCode().equals("201")) {
//                                Toast.makeText(ureg.this, "Registered Successfully", Toast.LENGTH_LONG).show();
//                            } else {
//                                Toast.makeText(ureg.this, "User is already exist", Toast.LENGTH_LONG).show();
//                            }
                        }

                        @Override
                        public void onFailure(Call<JsonObject> call, Throwable t) {
                            // Handle API call failure
                            Log.e("API Failure", t.getMessage());
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JsonObject regdata(){
        JsonObject jsonObject = new JsonObject();
        namedata=name.getText().toString();
        if(namedata.isEmpty() || namedata.equals("")){
            Toast.makeText(this, "Enter Name Field", Toast.LENGTH_SHORT).show();
            return null;
        }
        else{
            jsonObject.addProperty("name", namedata);
        }
        emaildata=email.getText().toString();
        if(emaildata.isEmpty() || emaildata.equals("")) {
            Toast.makeText(this, "Enter Email Field", Toast.LENGTH_SHORT).show();
            return null;
        }
        else {
            jsonObject.addProperty("email", emaildata);
        }
        phonedata=phone.getText().toString();
        if(phonedata.isEmpty() || phonedata.equals("")) {
            Toast.makeText(this, "Enter phone Field", Toast.LENGTH_SHORT).show();
            return null;
        }
        else {
            jsonObject.addProperty("phone", phonedata);
        }
        addressdata=address.getText().toString();
        if(addressdata.isEmpty() || addressdata.equals("")) {
            Toast.makeText(this, "Enter address Field", Toast.LENGTH_SHORT).show();
            return null;
        }
        else {
            jsonObject.addProperty("address", addressdata);
        }
        passworddata=password.getText().toString();
        if(passworddata.isEmpty() || passworddata.equals("")) {
            Toast.makeText(this, "Enter password Field", Toast.LENGTH_SHORT).show();
            return null;
        }
        else {
            jsonObject.addProperty("password", passworddata);
        }
        cpassworddata=cpassword.getText().toString();
        if(cpassworddata.isEmpty() || cpassworddata.equals("")) {
            Toast.makeText(this, "Enter cpassword Field", Toast.LENGTH_SHORT).show();
            return null;
        }
        else {
            jsonObject.addProperty("cpassword", cpassworddata);
        }
//        if(!Objects.equals(cpassworddata, passworddata)){
//            Toast.makeText(this, "Enter correct password", Toast.LENGTH_SHORT).show();
//            return  null;
//        }else{
//            jsonObject.addProperty("cpassword", cpassworddata);
      //  }
    return jsonObject;
    }
}