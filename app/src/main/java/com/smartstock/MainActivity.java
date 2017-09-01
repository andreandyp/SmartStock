package com.smartstock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button reportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reportes = (Button) findViewById(R.id.reportes);
    }

    public void verReportes(View view){
        Intent rep = new Intent(this, ReportesActivity.class);
        finish();
        startActivity(rep);
    }
}
