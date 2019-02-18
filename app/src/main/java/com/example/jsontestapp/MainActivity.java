package com.example.jsontestapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

TextView tv_name,tv_familia,tv_username,tv_email,
    tv_role,tv_phone,tv_address,tv_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        tv_name=findViewById(R.id.tv_name_out);
        tv_familia=findViewById(R.id.tv_familia_out);
        tv_username=findViewById(R.id.tv_username_out);
        tv_email=findViewById(R.id.tv_email_out);
        tv_role=findViewById(R.id.tv_role_out);
        tv_phone=findViewById(R.id.tv_phone_out);
        tv_address=findViewById(R.id.tv_address_out);
        tv_info=findViewById(R.id.tv_info_out);
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

                        tv_name.setText(response.body().getToken());

                    }

                    @Override
                    public void onFailure(Call<Response_token> call, Throwable t) {
                        tv_name.setText("NO");
                    }
                });
        }

//---------------------Получение User Data------------------------
    public void click_userdata(View view) {
        Toast toast =Toast.makeText(getApplicationContext(),"идёт загрузка данных", Toast.LENGTH_SHORT);
        toast.show();

                NetworkService.getInstance()
                .getJSONApi()
                .getUser()
                .enqueue(new Callback<Response_User>() {
                    @Override
                    public void onResponse(Call<Response_User> call, Response<Response_User> response) {

                        String firstname = response.body().getFirstName();
                        String lastname = response.body().getLastName();
                        String username = response.body().getUserName();
                        String email = response.body().getEmail();
                        String role = response.body().getRole();
                        String phone = response.body().getPhone();
                        String address = response.body().getAddress();
                        String info = response.body().getInfo();
                        tv_name.setText(firstname);
                        tv_familia.setText(lastname);
                        tv_username.setText(username);
                        tv_email.setText(email);
                        tv_role.setText(role);
                        tv_phone.setText(phone);
                        tv_address.setText(address);
                        tv_info.setText(info);
                    }

                    @Override
                    public void onFailure(Call<Response_User> call, Throwable t) {
                        Toast toast =Toast.makeText(getApplicationContext(),
                                "Проблемы с сетью, проверьте соединение", Toast.LENGTH_LONG);
                        toast.show();
                    }
                });

    }
}