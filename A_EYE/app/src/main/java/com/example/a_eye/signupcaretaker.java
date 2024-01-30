package com.example.a_eye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class signupcaretaker extends AppCompatActivity {
    public EditText name,email,phone,address,password,cpassword;
    public Button upload,signup;
    public String namedata,emaildata, phonedata, addressdata, passworddata, cpassworddata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupcaretaker);
        name=(EditText)findViewById(R.id.cusername);
        email=(EditText)findViewById(R.id.cemail);
        phone=(EditText)findViewById(R.id.cphone);
        address=(EditText)findViewById(R.id.caddress);
        password=(EditText)findViewById(R.id.cpassword);
        cpassword=(EditText)findViewById(R.id.ccpassword);
        upload=(Button)findViewById(R.id.cupload);
        signup=(Button)findViewById(R.id.csignup);
    }
    public void regdata(){
        namedata=name.getText().toString();
        if(namedata.isEmpty() || namedata.equals("")){
            Toast.makeText(this, "Enter Name Field", Toast.LENGTH_SHORT).show();
        }
        emaildata=email.getText().toString();
        if(emaildata.isEmpty() || emaildata.equals("")) {
            Toast.makeText(this, "Enter Email Field", Toast.LENGTH_SHORT).show();
        }
        phonedata=phone.getText().toString();
        if(phonedata.isEmpty() || phonedata.equals("")) {
            Toast.makeText(this, "Enter phone Field", Toast.LENGTH_SHORT).show();
        }
        addressdata=address.getText().toString();
        if(addressdata.isEmpty() || addressdata.equals("")) {
            Toast.makeText(this, "Enter address Field", Toast.LENGTH_SHORT).show();
        }
        passworddata=password.getText().toString();
        if(passworddata.isEmpty() || passworddata.equals("")) {
            Toast.makeText(this, "Enter password Field", Toast.LENGTH_SHORT).show();
        }
        cpassworddata=cpassword.getText().toString();
        if(cpassworddata.isEmpty() || cpassworddata.equals("")) {
            Toast.makeText(this, "Enter cpassword Field", Toast.LENGTH_SHORT).show();
        }
        if(!Objects.equals(cpassworddata, passworddata)){
            Toast.makeText(this, "Enter correct password", Toast.LENGTH_SHORT).show();
        }
    }
}