package com.sebastian.paginasamarillasapp_sebas.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sebastian.paginasamarillasapp_sebas.R;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView nombre_text;
    private TextView id_text;
    private TextView categoria_text;
    private String email_text;
    private TextView telefono_text;
    private TextView info_text;
    private TextView direcion_text;
    private String numerotexto;

    private static final int PERMISSIONS_REQUEST = 100;
    private static final int PERMISSIONS_REQUEST2 = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.picture_image);
        nombre_text = findViewById(R.id.name_text);
        telefono_text = findViewById(R.id.phone_text);
        direcion_text = findViewById(R.id.direction_text);

        email_text = this.getIntent().getExtras().getString("email");

        nombre_text.setText(this.getIntent().getExtras().getString("name"));
        direcion_text.setText(this.getIntent().getExtras().getString("address"));
        telefono_text.setText(this.getIntent().getExtras().getString("phone"));

        //telefono_text.setText(this.getIntent().getExtras().getString("phone"));

    }

    public void callNumber(View view){


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_REQUEST);
        }else {
            openCallApplication();
        }

    }
    public void smgNumber(View view){

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PERMISSIONS_REQUEST2);
        }else {
            sendSMSApplication();
        }

    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        switch (requestCode) {
            case PERMISSIONS_REQUEST: {
                if (permissions[0].equals(Manifest.permission.CALL_PHONE)) {
                    if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        openCallApplication();
                    }else{
                        Toast.makeText(this, "CALL_PHONE permissions declined!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            case PERMISSIONS_REQUEST2: {
                if (permissions[0].equals(Manifest.permission.SEND_SMS)) {
                    if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        sendSMSApplication();
                    }else{
                        Toast.makeText(this, "SEND SMS permissions declined!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    //Para las llamadas
    public void openCallApplication(){
        String phoneNumber = telefono_text.getText().toString();
        if(phoneNumber.isEmpty()){
            Toast.makeText(this, "Phone number required!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phoneNumber));

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
            startActivity(intent);
    }


    //Solo esto para internet
    public void openBrowserApplication(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(direcion_text.getText().toString()));
        startActivity(intent);
    }


    //Para los mensajes
    public void sendSMSApplication(){
        String phoneNumber = telefono_text.getText().toString();
        if(phoneNumber.isEmpty()){
            Toast.makeText(this, "Phone number required!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:"+phoneNumber));

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED)
            startActivity(intent);
    }

    public void sendEmail(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.fromParts("mailto",email_text,null));
        startActivity(intent);
    }
    public void shareInfo(View view){
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, nombre_text.getText().toString());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }


}
