package com.sebastian.paginasamarillasapp_sebas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import com.sebastian.paginasamarillasapp_sebas.R;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        searchView.setQueryHint("Buscar...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
                public boolean onQueryTextSubmit(String query) {
                    //Toast.makeText(getApplication(), query + " Enviado!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("query", query);
                    startActivity(intent);
                    return false;
                }

            @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
        });
    }
}
