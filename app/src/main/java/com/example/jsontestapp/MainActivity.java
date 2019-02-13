package com.example.jsontestapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

TextView tv1,tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv_name);
        tv2=findViewById(R.id.tv_fam);
        tv3=findViewById(R.id.tv_username);

    }
//----------------Получение токена-----------------------------
public void clickbtntoken(View view) {

        final Request_Login loginCredential = new Request_Login();

    loginCredential.login = "test";
    loginCredential.pass = "123";

        NetworkService.getInstance()
                .getJSONApi()
                .sendLoginRequest(loginCredential)
                .enqueue(new Callback<Response_token>() {
                    @Override
                    public void onResponse(@NonNull Call<Response_token> call,
                                           @NonNull Response<Response_token> response) {

                        tv1.setText(response.body().getToken());

                    }

                    @Override
                    public void onFailure(Call<Response_token> call, Throwable t) {
                        tv1.setText("NO");
                    }
                });
        }

//---------------------Получение User Data------------------------
    public void click_userdata(View view) {
        tv1.setText("");

                NetworkService.getInstance()
                .getJSONApi()
                .getUser()
                .enqueue(new Callback<Response_User>() {
                    @Override
                    public void onResponse(Call<Response_User> call, Response<Response_User> response) {


                        String id = response.body().getId();
                        String firstname = response.body().getFirstName();
                        String lastname = response.body().getLastName();
                        String username = response.body().getUserName();
                        String email = response.body().getEmail();
                        String role = response.body().getRole();
                        String phone = response.body().getPhone();
                        String address = response.body().getAddress();
                        String info = response.body().getInfo();

                        //tv1.append(id + "\n");
                        tv1.setText(firstname);
                        tv2.setText(lastname);
                        tv3.setText(username);
                       /* tv1.append(lastname + "\n");
                        tv1.append(username + "\n");
                        tv1.append(email + "\n");
                        tv1.append(role +"\n");
                        tv1.append(phone + "\n");
                        tv1.append(address + "\n");
                        tv1.append(info + "\n");*/
                    }
                    @Override
                    public void onFailure(Call<Response_User> call, Throwable t) {
                        tv1.setText("NO");
                    }
                });

    }
}