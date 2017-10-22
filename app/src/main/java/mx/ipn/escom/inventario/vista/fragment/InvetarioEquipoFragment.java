package mx.ipn.escom.inventario.vista.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.gambo.demo_proyecto.R;

import mx.ipn.escom.producto.vista.Activity_Producto;
import mx.ipn.escom.producto.vista.RegistrarProducto;

/**
 * Created by gambo on 08/09/2017.
 */

public class InvetarioEquipoFragment extends Fragment {

    private ListView inventarioViews;
    private ArrayAdapter<String> listInventarioAdapters;
    private ImageView registrarImageView;


    public InvetarioEquipoFragment() {
    }

    public static InvetarioEquipoFragment newInstance() {
        InvetarioEquipoFragment fragments = new InvetarioEquipoFragment();
        return fragments;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Gets parámetros
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_inventario_equipo, container, false);

        inventarioViews = (ListView) root.findViewById(R.id.equipo_list);
        registrarImageView=(ImageView) root.findViewById(R.id.imageView18);

        String[] listProductos = {"Producto 1", "Producto 2", "Producto 3", "Producto 4", "Producto 5"};

        listInventarioAdapters = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listProductos);

        inventarioViews.setAdapter(listInventarioAdapters);

        inventarioViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                System.err.println(getActivity());
                Intent intent = new Intent(getActivity(), Activity_Producto.class);
                //based on item add info to intent
                startActivity(intent);
                getActivity().finish();
            }
        });

        registrarImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),RegistrarProducto.class);
                startActivity(intent);
            }
        });

        return root;
    }

}
