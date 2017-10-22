package mx.ipn.escom.reporte.vista.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gambo.demo_proyecto.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParticularFragment extends Fragment {


    public ParticularFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_particular, container, false);
    }

}
