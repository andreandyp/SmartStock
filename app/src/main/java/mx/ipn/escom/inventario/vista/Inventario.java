package mx.ipn.escom.inventario.vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.gambo.demo_proyecto.R;

import mx.ipn.escom.inventario.vista.fragment.InvetarioEquipoFragment;

public class Inventario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);

        InvetarioEquipoFragment invetarioEquipoFragment= (InvetarioEquipoFragment) getFragmentManager().findFragmentById(R.id.inventario_equipo_container);

        if(invetarioEquipoFragment == null){
            invetarioEquipoFragment= invetarioEquipoFragment.newInstance();
            getFragmentManager().beginTransaction().add(R.id.inventario_equipo_container,invetarioEquipoFragment).commit();
        }

    }
}
