package com.example.paresh.myapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView,textView2,textView3;
    EditText editText,editText2,editText3;
    Button btnSave;
    SharedPreferences pref;
    private static final String Name="name ";
    private static final String Address=" address";
    private static final String Phone="phone ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref=getSharedPreferences("MyApp",MODE_PRIVATE);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        btnSave=findViewById(R.id.btnSave);
        getPreviouslySavedValue();

    }

    private void getPreviouslySavedValue() {
        String name=pref.getString(Name," ");
        String address=pref.getString(Address," ");
        String phone=pref.getString(Phone," ");
        editText.setText(name);
        editText2.setText(address);
        editText3.setText(phone);
    }

    public void Save(View view) {
        String name=editText.getText().toString().trim();
        String address=editText2.getText().toString().trim();
        String phone =editText3.getText().toString().trim();

        SharedPreferences.Editor editor=pref.edit();
        editor.putString(Name,name);
        editor.putString(Address,address);
        editor.putString(Phone,phone);
        editor.commit();

    }
}
