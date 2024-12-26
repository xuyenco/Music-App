package com.example.app_nhac.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_nhac.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Sign_up extends AppCompatActivity {
    EditText password_create, username_create, email_create;
    Button createBTN;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;//AuthStateListener:được sử dụng để lắng nghe những thay đổi trong trạng thái xác thực của người dùng.
    //Nó kích hoạt lệnh gọi lại khi người dùng đăng nhập hoặc đăng xuất.
    private FirebaseUser currentUser;//FirebaseUser :đại diện cho người dùng hiện được xác thực trong Firebase Authentication.
    // Biến này sẽ được sử dụng để lưu trữ thông tin về người dùng được xác thực sau khi họ đăng nhập.
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = db.collection("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        password_create = findViewById(R.id.password_create);
        username_create = findViewById(R.id.username_create_ET);
        email_create = findViewById(R.id.email_create);
        createBTN = findViewById(R.id.acc_signUp_btn);

        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //có được thông tin người dùng hiện tại :
                currentUser = firebaseAuth.getCurrentUser();
                //kiểm tra người dùng có đăng nhập hay không :
                if (currentUser != null) {

                } else {

                }

            }
        };
        createBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(email_create.getText().toString()) &&
                        !TextUtils.isEmpty(username_create.getText().toString()) &&
                        !TextUtils.isEmpty(password_create.getText().toString())) {
                    String email = email_create.getText().toString().trim();
                    String user = username_create.getText().toString().trim();
                    String pass = password_create.getText().toString().trim();
                    if (pass.length()<6){
                        Toast.makeText(Sign_up.this, "Mật khẩu phải lớn hơn 5 kí tự!", Toast.LENGTH_SHORT).show();
                    }
                    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                    if (!email.matches(emailPattern)) {
                        // Định dạng email không hợp lệ
                        Toast.makeText(Sign_up.this, "Địa chỉ email không hợp lệ",
                                Toast.LENGTH_SHORT).show();
                    }
                    CreateUserEmailAccount(user, pass, email);


                } else {
                    Toast.makeText(Sign_up.this, "Không được bỏ trông mục nào!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void CreateUserEmailAccount(String user, String pass, String email) {
        if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)) {
            firebaseAuth.createUserWithEmailAndPassword(email, pass).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Sign_up.this, "Bạn đã đăng kí thành công ",
                                        Toast.LENGTH_SHORT).show();
                            }
                            else if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                // Xử lý lỗi

                                // Địa chỉ email đã tồn tại
                                Toast.makeText(Sign_up.this, "Địa chỉ email đã tồn tại",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                // Xử lý lỗi khác
                                Toast.makeText(Sign_up.this, "Đã xảy ra lỗi khi đăng ký",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}