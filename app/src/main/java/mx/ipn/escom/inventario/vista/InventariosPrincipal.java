package mx.ipn.escom.inventario.vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.gambo.demo_proyecto.R;

import mx.ipn.escom.inventario.vista.fragment.InventarioFragment;

public class InventariosPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventarios_principal);

        InventarioFragment inventarioFragment = (InventarioFragment)
                getFragmentManager().findFragmentById(R.id.inventario_container);

        if (inventarioFragment == null) {
            inventarioFragment = inventarioFragment.newInstance();
            getFragmentManager().beginTransaction().add(R.id.inventario_container, inventarioFragment).commit();
        }
    }
}
