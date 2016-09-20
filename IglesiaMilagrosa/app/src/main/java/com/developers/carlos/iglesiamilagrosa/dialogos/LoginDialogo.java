package com.developers.carlos.iglesiamilagrosa.dialogos;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.developers.carlos.iglesiamilagrosa.R;

/**
 * Created by carlos on 16/09/16.
 */
public class LoginDialogo extends DialogFragment {
    private static final String TAG = LoginDialogo.class.getSimpleName();

    public LoginDialogo() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return createLoginDialogo();
    }

    /**
     * Crea un diálogo con personalizado para comportarse
     * como formulario de login
     *
     * @return Diálogo
     */
    public AlertDialog createLoginDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.dialogo_login, null);

        builder.setView(v);

        Button signin = (Button) v.findViewById(R.id.entrar_boton);



        signin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Loguear...
                        Toast.makeText(
                                getActivity(),
                                "Usuario o Contraseña incorrectas",
                                Toast.LENGTH_SHORT)
                                .show();
                        dismiss();
                    }
                }

        );

        return builder.create();
    }

}
