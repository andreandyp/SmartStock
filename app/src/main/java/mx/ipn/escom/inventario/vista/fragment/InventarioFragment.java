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

import mx.ipn.escom.R;

import mx.ipn.escom.inventario.vista.ConfigurarInventario;
import mx.ipn.escom.inventario.vista.Inventario;

public class InventarioFragment extends Fragment {

    private ListView inventarioView;
    private ArrayAdapter<String> listInventarioAdapter;
    private ImageView registrarImageView;

        public InventarioFragment(){
        }

        public static InventarioFragment newInstance(){
            InventarioFragment fragment=new InventarioFragment();
            return  fragment;
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
            View root = inflater.inflate(R.layout.fragment_leads, container, false);

            inventarioView=(ListView) root.findViewById(R.id.leads_list);
            registrarImageView=(ImageView) root.findViewById(R.id.registrar);


            String[] listProductos={"Inventario 1","Inventario 2","Inventario 3","Inventario 4","Inventario 5"};

            listInventarioAdapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,listProductos);

            inventarioView.setAdapter(listInventarioAdapter);

            inventarioView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Object item = parent.getItemAtPosition(position);
                    System.err.println(getActivity());
                    Intent intent = new Intent(getActivity(),Inventario.class);
                    //based on item add info to intent
                    startActivity(intent);
                    getActivity().finish();
                }
        });

            registrarImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getActivity(),ConfigurarInventario.class);
                    startActivity(intent);
                }
            });

            return root;
        }
}
