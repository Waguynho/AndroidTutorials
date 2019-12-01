package com.sample.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.sample.myfirstapp.R;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewComponents();
    }

    private void initViewComponents() {
        Button btnShowJson = findViewById(R.id.btn_json_view);
        btnShowJson.setOnClickListener(this::showJson);

        Button btnFragments = findViewById(R.id.btn_go_to_fragments);
        btnFragments.setOnClickListener(this::goToFragments);

        Button btnAndroidComponents = findViewById(R.id.btn_android_components);
        btnAndroidComponents.setOnClickListener(this::goToAndroidComponents);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText =  findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void showJson(View view) {
        Intent intent = new Intent(this, JsonActivity.class);
        startActivity(intent);
    }

    public void goToFragments(View view) {
        Intent contentFragments = new Intent(this, ContentFragments.class);
        startActivity(contentFragments);
    }

    public void goToAndroidComponents(View view) {
        Intent androidComponentsActivity = new Intent(this, AndroidComponentsActivity.class);
        startActivity(androidComponentsActivity);
    }

}
