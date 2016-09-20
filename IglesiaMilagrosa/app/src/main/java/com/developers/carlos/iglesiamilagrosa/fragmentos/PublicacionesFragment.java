package com.developers.carlos.iglesiamilagrosa.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developers.carlos.iglesiamilagrosa.R;
import com.developers.carlos.iglesiamilagrosa.adaptadores.AdaptadorPublicaciones;
import com.developers.carlos.iglesiamilagrosa.modelos.PublicacionData;

/**
 * A simple {@link Fragment} subclass.
 */
public class PublicacionesFragment extends Fragment {

    private static final String ARG_TAB_NUMERO = "tab_numero";

    /**
     * Creación prefabricada de un {@link PublicacionesFragment}
     */
    public static PublicacionesFragment nuevaInstancia(int tab) {
        PublicacionesFragment fragment = new PublicacionesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TAB_NUMERO, tab);
        fragment.setArguments(args);
        return fragment;
    }


    public PublicacionesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragment = inflater.inflate(R.layout.fragment_publicaciones, container, false);
        RecyclerView recyclerView = (RecyclerView) fragment.findViewById(R.id.mi_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        inicializarFragmento(recyclerView);
        return fragment;
    }

    public void inicializarFragmento(RecyclerView recyclerView){
        int tab_numero = getArguments().getInt(ARG_TAB_NUMERO);
        switch (tab_numero) {

            case 1: recyclerView.setAdapter(new AdaptadorPublicaciones(PublicacionData.PUBLICACIONES));
                    break;
            case 2: recyclerView.setAdapter(new AdaptadorPublicaciones(PublicacionData.PUBLICACIONES_FAVORITAS));
                    break;
        }
    }

}
