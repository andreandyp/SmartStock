package com.smartstock;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class FechaHoraFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private int origen;
    private EditText texto;

    public FechaHoraFragment(){

    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int año = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);

        origen = getArguments().getInt("boton");
        View view = getView();
        texto = (EditText) view.findViewById(origen);

        return new DatePickerDialog(getActivity(), this, año, mes, dia);
    }

    public void onDateSet(DatePicker view, int año, int mes, int dia) {
        texto.setText(dia+"/"+mes+"/"+año);
    }
}