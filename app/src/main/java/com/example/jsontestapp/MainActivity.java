package com.example.jsontestapp;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class MainActivity extends AppCompatActivity {
TextView tv1;
EditText etLogin, etpsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=findViewById(R.id.tv_result);
        etLogin=findViewById(R.id.editLogin);
        etpsw=findViewById(R.id.editPassword);
    }

    public void clicktest(View view) {

        RequestLogin loginCredential = new RequestLogin();

        //Получаем логин и пароль из EditText'ов
        loginCredential.login = (etLogin.getText().toString());//"test";
        loginCredential.pass = (etpsw.getText().toString());//"123";
        //проверяем логин пароль на стороне клиента
      if (loginCredential.login.equals("test") &&(loginCredential.pass.equals("123"))) {
            NetworkService.getInstance()
                    .getJSONApi()
                    .sendLoginRequest(loginCredential)
                    .enqueue(new Callback<Response_token>() {
                        @Override
                        public void onResponse(@NonNull Call<Response_token> call, @NonNull Response<Response_token>
                                response) {
                            tv1.setText("Добро пожаловать");

                            // Получаем токен и присваеваем его текстовому полю response.body().getToken());

                            //делаем задержку перед переключением на вторую страницу

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent=new Intent(MainActivity.this, NextPageActivity.class);
                                    startActivity(intent);
                                }
                            },2000);


                    }


                        @Override
                        public void onFailure(Call<Response_token> call, Throwable t) {
                            tv1.setText("Нет связи с сервером");
                            t.printStackTrace();
                        }
                    });
        } else tv1.setText("Неверный логин или пароль");
    }
}
