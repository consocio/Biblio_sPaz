package com.example.consocio.bibliospaz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.consocio.bibliospaz.Utils.Login;
import com.pixplicity.easyprefs.library.Prefs;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText usr, pass;
    private Button login;
    private String token;
    private static final BibliospazApi bibliospazApi = new ApiService().init();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usr = findViewById(R.id.user);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
                if (!(token == null)) {
                    startActivity(new Intent(MainActivity.this, Home.class));
                } else {
                    Toast.makeText(getApplicationContext(), "LOGIN ERROR", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void Login() {
        String email;
        String pwd;

        email = usr.getText().toString();
        pwd = pass.getText().toString();
        Login login = new Login(email, pwd);
        Call<Login> call = bibliospazApi.newLogin(login);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Codice errore:" + response.code(), Toast.LENGTH_SHORT).show();
                }

                Login loginResponse = response.body();

                if (!(loginResponse.getSuccess() == "false")) {
                    String content = "";
                    content += "Code: " + response.code() + "\n";
                    content += "Access Token = " + loginResponse.getAccess_token() + "\n";
                    content += "Expires = " + loginResponse.getExpires_in() + "\n";
                    content += "Name = " + loginResponse.getName() + "\n";
                    content += "Surname = " + loginResponse.getSurname() + "\n" + "\n";


                    token += loginResponse.getAccess_token();
                    Prefs.putString("token", token);
                    Log.d("prova", "prefs " + Prefs.getString("token", null));


                } else {
                    Toast.makeText(getApplicationContext(), "Credenziali errate", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
