package mx.ipn.escom.reporte.vista.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.gambo.demo_proyecto.R;


public class GeneralFragment extends Fragment {
    private Spinner mes,dia;
    private RadioButton anual,mensual,semanal;
    public GeneralFragment() {
        // Required empty public constructor
    }
    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_general, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mes = (Spinner) getView().findViewById(R.id.mes);
        dia = (Spinner) getView().findViewById(R.id.dia);
        anual = (RadioButton) getView().findViewById(R.id.anual);
        mensual = (RadioButton) getView().findViewById(R.id.mensual);
        semanal = (RadioButton) getView().findViewById(R.id.semanal);
        anual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarPeriodo(v);
            }
        });
        mensual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarPeriodo(v);
            }
        });
        semanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarPeriodo(v);
            }
        });
        mes.setEnabled(false);
        dia.setEnabled(false);

    }

    public void cambiarPeriodo(View view){
        switch(view.getId()){
            case R.id.anual:
                mes.setEnabled(false);
                dia.setEnabled(false);
                break;
            case R.id.mensual:
                mes.setEnabled(true);
                dia.setEnabled(false);
                break;
            case R.id.semanal:
                mes.setEnabled(true);
                dia.setEnabled(true);
        }
    }

}
