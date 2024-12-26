package com.example.app_nhac.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_nhac.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    Button loginBtn,createAccountBtn;
    private EditText emailEt,passEt;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser currentUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn=findViewById(R.id.email_signin);
        emailEt=findViewById(R.id.email);
        passEt=findViewById(R.id.password);
        //Firebase Aythentication
        firebaseAuth=FirebaseAuth.getInstance();
        loginBtn.setOnClickListener(v->{
            LogEmailPassUser(
                    emailEt.getText().toString().trim(),
                    passEt.getText().toString().trim()
            );
        });


        createAccountBtn=findViewById(R.id.creat_account);
        //  emailEt=findViewById(R.id.email_create);
        //passEt=findViewById(R.id.password_create);
        createAccountBtn.setOnClickListener(v-> {
                    //onClick
                    Intent intent=new Intent(Login.this, Sign_up.class);
                    startActivity(intent);
                }
        );
    }
    private void LogEmailPassUser(String email,String pass){
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)){
            //kiểm tra sự tồn tại :
            firebaseAuth.signInWithEmailAndPassword(email,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {//nếu kiểm tra thành công thì sẽ thực hiện đăng nhập
                    FirebaseUser user=firebaseAuth.getCurrentUser();
                    Intent i=new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                }
            }) .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    // Đăng nhập không thành công, xử lý lỗi
                    Toast.makeText(Login.this, "Đăng nhập không thành công: " + e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            });;
        }
    }
}