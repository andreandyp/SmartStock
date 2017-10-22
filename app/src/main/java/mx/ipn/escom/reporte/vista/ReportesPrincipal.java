package mx.ipn.escom.reporte.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.gambo.demo_proyecto.R;

public class ReportesPrincipal extends AppCompatActivity {
    private Button reportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes_principal);
        reportes = (Button) findViewById(R.id.reportes);
    }

    public void verReportes(View view){
        Intent rep = new Intent(this, ReportesActivity.class);
        finish();
        startActivity(rep);
    }
}
