package mx.ipn.escom.producto.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import mx.ipn.escom.R;

public class RegistrarProducto extends AppCompatActivity {
    private Spinner equipoSpinner;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_producto);

        textView1=(TextView) findViewById(R.id.textView43);
        textView2=(TextView) findViewById(R.id.textView44);
        textView3=(TextView) findViewById(R.id.textView45);

        equipoSpinner=(Spinner) findViewById(R.id.spinner);

        ArrayAdapter spinnerAdapter=ArrayAdapter.createFromResource(this,R.array.equipo,android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        equipoSpinner.setAdapter(spinnerAdapter);



        equipoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String select=equipoSpinner.getSelectedItem().toString();
                TextView miTextView = new TextView(getApplicationContext());
                Toast.makeText(RegistrarProducto.this,equipoSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                if(select.equals("Escritorio")){
                    textView1.setText("CPU");
                    textView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent= new Intent(RegistrarProducto.this,Formulario_CPU.class);
                            startActivity(intent);
                        }
                    });
                    textView2.setText("Monitor(es)");
                    textView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent= new Intent(RegistrarProducto.this,Formulario_Monitor.class);
                            startActivity(intent);
                        }
                    });
                    textView3.setText("Perifericos");
                    textView3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent= new Intent(RegistrarProducto.this,Formulario_Perifericos.class);
                            startActivity(intent);
                        }
                    });
                }else if(select.equals("Portatil")){
                    textView1.setText("Portatil");
                    textView2.setText("Perifericos");
                    textView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent= new Intent(RegistrarProducto.this,Formulario_Perifericos.class);
                            startActivity(intent);
                        }
                    });
                    textView3.setText("");
                }else if(select.equals("Portatil")){
                    textView1.setText("Especificar Producto y/o periférico");
                    textView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent= new Intent(RegistrarProducto.this,Formulario_Perifericos.class);
                            startActivity(intent);
                        }
                    });
                    textView2.setText("");
                    textView3.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
}
