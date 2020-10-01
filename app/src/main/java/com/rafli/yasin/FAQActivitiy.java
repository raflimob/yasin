package com.rafli.yasin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FAQActivity extends AppCompatActivity {

    ImageView b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahlil);

        b=(ImageView)findViewById(R.id.backtahlil);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Tahlil.this,MainActivity.class));
            }
        });
    }
}
