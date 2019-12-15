package com.example.dagger2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dagger2demo.components.DaggerMyComponent;
import com.example.dagger2demo.components.MyComponent;
import com.example.dagger2demo.modules.SharedPrefModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences sharedPreferences;
    MyComponent myComponent;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putBoolean("hahaha", false);
            }
        });
        myComponent = DaggerMyComponent.builder().sharedPrefModule(new SharedPrefModule(this)).build();
        myComponent.inject(this);
    }
}
