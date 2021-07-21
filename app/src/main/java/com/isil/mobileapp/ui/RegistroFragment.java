package com.isil.mobileapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.isil.mobileapp.R;
import com.isil.mobileapp.datos.DatosSQLite;
import com.isil.mobileapp.model.Auto;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RegistroFragment extends Fragment implements View.OnClickListener{

    TextInputEditText mtetMarca, mtetModelo, mtetPlaca, mtetPropietario;
    Button mbtnRegistrar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // text Inputs
        mtetMarca = view.findViewById(R.id.tetMarca);
        mtetModelo = view.findViewById(R.id.tetModelo);
        mtetPlaca = view.findViewById(R.id.tetPlaca);
        mtetPropietario = view.findViewById(R.id.tetPropietario);

        // boton para registrar
        mbtnRegistrar = view.findViewById(R.id.btnRegistrar);
        mbtnRegistrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegistrar:
                registrarAuto();
                break;
        }
    }

    private void registrarAuto() {

        String marca = mtetMarca.getText().toString();
        String modelo = mtetModelo.getText().toString();
        String placa = mtetPlaca.getText().toString();
        String propietario = mtetPropietario.getText().toString();
        DatosSQLite datosSQLite = new DatosSQLite(getActivity());
        String autonumerico = datosSQLite.registrarAuto(datosSQLite, marca, modelo, placa, propietario);
        Toast.makeText(getActivity(), String.valueOf(autonumerico), Toast.LENGTH_SHORT).show();
        mtetMarca.setText("");
        mtetModelo.setText("");
        mtetPlaca.setText("");
        mtetPropietario.setText("");
        mtetMarca.requestFocus();

    }
}