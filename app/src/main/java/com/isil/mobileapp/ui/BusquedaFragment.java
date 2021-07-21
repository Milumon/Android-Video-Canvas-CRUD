package com.isil.mobileapp.ui;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.isil.mobileapp.R;
import com.isil.mobileapp.adapter.AutoAdapter;
import com.isil.mobileapp.datos.DatosSQLite;
import com.isil.mobileapp.model.Auto;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BusquedaFragment extends Fragment implements View.OnClickListener{

    RecyclerView mlvBusqueda;
    RecyclerView autoRecycler;
    AutoAdapter autoAdapter;
    Button mbtnBuscar;


    TextInputEditText mtetPlaca;
    List<Auto> autoList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_busqueda, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mlvBusqueda = view.findViewById(R.id.lvBusqueda);
        leerDatos();


        // boton para registrar
        mbtnBuscar = view.findViewById(R.id.btnBuscar);
        mbtnBuscar.setOnClickListener(this);

        // inputs

        mtetPlaca = view.findViewById(R.id.tetPlaca);


    }

    private void leerDatos() {

        DatosSQLite datosSQLite = new DatosSQLite(getActivity());
        Cursor cursor = datosSQLite.mostrarTodo(datosSQLite);
        Integer count = 0;
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    System.out.println(cursor.getString(cursor.getColumnIndex("idauto")));
                    Auto auto = new Auto();
                    auto.setIdAuto(cursor.getString(cursor.getColumnIndex("idauto")));
                    auto.setMarca(cursor.getString(cursor.getColumnIndex("marca")));
                    auto.setModelo(cursor.getString(cursor.getColumnIndex("modelo")));
                    auto.setPlaca(cursor.getString(cursor.getColumnIndex("placa")));
                    auto.setPropietario(cursor.getString(cursor.getColumnIndex("propietario")));
                    autoList.add(auto);


                }while(cursor.moveToNext());
            }
        }
        setAutoRecycler(autoList);

    }

    private void setAutoRecycler(List<Auto> autoList){
        Log.e("FOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO", autoList.toString());
        autoRecycler = mlvBusqueda;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        autoRecycler.setLayoutManager(layoutManager);
        autoAdapter = new AutoAdapter(getContext(), autoList);
        autoRecycler.setAdapter(autoAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBuscar:
                buscarPorPlaca();
                break;
        }
    }

    private void buscarPorPlaca() {
        // obtener dato
        String placa = mtetPlaca.getText().toString();


        autoRecycler = mlvBusqueda;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        autoRecycler.setLayoutManager(layoutManager);
        List<Auto> finalList = autoList.stream().filter(x -> x.getPlaca().contains(placa)).collect(Collectors.toList());
        autoAdapter = new AutoAdapter(getContext(), finalList);

        if(finalList.size() == 0){
            Toast.makeText(getActivity(), "No se encontraron resultados", Toast.LENGTH_LONG).show();
        }

        autoRecycler.setAdapter(autoAdapter);
    }
}