package mx.ipn.escom.controlacceso.vista;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import mx.ipn.escom.R;
import mx.ipn.escom.codigoqr.vista.EscanearQRActivity;
import mx.ipn.escom.inventario.InventariosActivity;
import mx.ipn.escom.reporte.vista.ReportesActivity;

public class InicioUsuarioActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        prepararDB();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void prepararDB() {
        SQLiteDatabase bd = openOrCreateDatabase("Inventarios", MODE_PRIVATE, null);

        bd.execSQL("CREATE TABLE IF NOT EXISTS `Inventario` (\n" +
                "  `idInventario` INT NOT NULL,\n" +
                "  `idUsuario` INT NOT NULL,\n" +
                "  `nb_nombre` VARCHAR(45) NOT NULL,\n" +
                "  `tx_descripcion` VARCHAR(150) NOT NULL,\n" +
                "  PRIMARY KEY (`idInventario`),\n" +
                "  CONSTRAINT `fk_inventario_usuario`\n" +
                "    FOREIGN KEY (`idUsuario`)\n" +
                "    REFERENCES `Usuario` (`idUsuario`))\n");

        bd.execSQL("CREATE TABLE IF NOT EXISTS `Tipo_Dispositivo` (\n" +
                "  `idTipo` INT NOT NULL,\n" +
                "  `nb_tipo` VARCHAR(45) NOT NULL,\n" +
                "  `tx_descripcion` VARCHAR(75) NOT NULL,\n" +
                "  `activo` TINYINT NOT NULL,\n" +
                "  PRIMARY KEY (`idTipo`))\n");

        bd.execSQL("CREATE TABLE IF NOT EXISTS `Dispositivo` (\n" +
                "  `idDispositivo` VARCHAR(25) NOT NULL,\n" +
                "  `idTipo` INT NOT NULL,\n" +
                "  `nb_dispositivo` VARCHAR(45) NOT NULL,\n" +
                "  `marca` VARCHAR(45) NOT NULL,\n" +
                "  PRIMARY KEY (`idDispositivo`),\n" +
                "  CONSTRAINT `fk_dispositivo_tipo`\n" +
                "    FOREIGN KEY (`idTipo`)\n" +
                "    REFERENCES `Tipo_Dispositivo` (`idTipo`))\n");

        bd.execSQL("CREATE TABLE IF NOT EXISTS `inventario_dispositivo` (\n" +
                "  `idInventario` INT NOT NULL,\n" +
                "  `idDispositivo` VARCHAR(25) NOT NULL,\n" +
                "  PRIMARY KEY (`idInventario`, `idDispositivo`),\n" +
                "  CONSTRAINT `fk_Inventario_dispositivo`\n" +
                "    FOREIGN KEY (`idInventario`)\n" +
                "    REFERENCES `Inventario` (`idInventario`)\n" +
                "    ON DELETE NO ACTION,\n" +
                "  CONSTRAINT `fk_Inventario_Dispositivoo`\n" +
                "    FOREIGN KEY (`idDispositivo`)\n" +
                "    REFERENCES `Dispositivo` (`idDispositivo`))\n");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.inventario) {
            startActivity(new Intent(this, InventariosActivity.class));
        } else if (id == R.id.reportes) {
            startActivity(new Intent(this, ReportesActivity.class));
        } else if (id == R.id.codigoqr) {
            startActivity(new Intent(this, EscanearQRActivity.class));
        } else if (id == R.id.admin) {
            startActivity(new Intent(this, ConfigurarCuenta.class));
        } else if (id == R.id.salir) {
            startActivity(new Intent(this, InicioSesionActivity.class));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
