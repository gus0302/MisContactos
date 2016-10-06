package com.gustaav.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Gustavo Alvarado", "56726622", "gustaav@gmail.com"));
        contactos.add(new Contacto("Albert Einstein", "56989726", "alberte@gmail.com"));
        contactos.add(new Contacto("Isaac Newton", "41265479", "newton_i@gmail.com"));
        contactos.add(new Contacto("Julio Verne", "34567893", "jules_verne@gmail.com"));
        contactos.add(new Contacto("Leonardo Da Vinci", "56781354", "leo_1567@gmail.com"));

        ArrayList<String> nombresContacto = new ArrayList<>();

        for (Contacto contacto: contactos)
        {
            nombresContacto.add(contacto.getNombre());

        }

        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());

                startActivity(intent);
                finish();

            }
        });
    }
}
