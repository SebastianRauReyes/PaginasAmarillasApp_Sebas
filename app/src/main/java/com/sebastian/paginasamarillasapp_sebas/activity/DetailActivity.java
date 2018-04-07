package com.sebastian.paginasamarillasapp_sebas.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.sebastian.paginasamarillasapp_sebas.R;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView nombre_text;
    private TextView id_text;
    private TextView categoria_text;
    private TextView email_text;
    private TextView telefono_text;
    private TextView info_text;
    private TextView direcion_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.picture_image);
        nombre_text = findViewById(R.id.name_text);
      //  id_text = findViewById(R.id.id_text);
        categoria_text = findViewById(R.id.category_text);
       // email_text = findViewById(R.id.email_text);
        telefono_text = findViewById(R.id.phone_text);
      //  info_text = findViewById(R.id.info_text);
       // direcion_text = findViewById(R.id.address_text);



        nombre_text.setText(this.getIntent().getExtras().getString("name"));
        categoria_text.setText(this.getIntent().getExtras().getString("category"));
        telefono_text.setText(this.getIntent().getExtras().getString("phone"));







    }
}
