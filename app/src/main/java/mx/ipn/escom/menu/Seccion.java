package mx.ipn.escom.menu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gambo.demo_proyecto.R;

/**
 * Created by gambo on 05/09/2017.
 */

public class Seccion extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.seccion, container, false);

        return rootView;
    }
}
