package com.smartstock;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

public class ReportesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);
    }

    public void mostrarDatePicker(View view){
        Bundle args = new Bundle();
        args.putInt("boton",view.getId());
        DialogFragment fragment = new FechaHoraFragment();
        fragment.setArguments(args);
        fragment.show(getSupportFragmentManager(), "datePicker");
    }
}
