package com.sebastian.paginasamarillasapp_sebas.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sebastian.paginasamarillasapp_sebas.R;

public class DetailActivity extends AppCompatActivity {

    private TextView nombre_text;
    private TextView info_text;

    private String   email_text;
    private String   telefono_text;
    private String   direcion_text;

    private static final int PERMISSIONS_CALL  = 100;
    private static final int PERMISSIONS_SMS = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

                email_text    = this.getIntent().getExtras().getString("email");
                direcion_text = this.getIntent().getExtras().getString("address");
                telefono_text = this.getIntent().getExtras().getString("phone");


                nombre_text = findViewById(R.id.name_text);
                info_text   = findViewById(R.id.info_text);

                nombre_text.setText(this.getIntent().getExtras().getString("name"));
                info_text.setText(this.getIntent().getExtras().getString("info"));

    }

    //-----------------------------------------------------------------------------------------------------------------------------------------
    //----- Ask Permission Call
    public void callNumber(View view){

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, PERMISSIONS_CALL);
        }else {

                openCallApplication();
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------
    //----- Ask Permission SMS
    public void smgNumber(View view){

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PERMISSIONS_SMS);
        }else {
            openSMSApplication();
        }

    }

    //-----------------------------------------------------------------------------------------------------------------------------------------
    //----- Permission Request ------
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        switch (requestCode) {
            case PERMISSIONS_CALL: {
                if (permissions[0].equals(Manifest.permission.CALL_PHONE)) {
                    if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        openCallApplication();
                    }else{
                        Toast.makeText(this, "CALL_PHONE permissions declined!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            case PERMISSIONS_SMS: {
                if (permissions[0].equals(Manifest.permission.SEND_SMS)) {
                    if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        openSMSApplication();
                    }else{
                        Toast.makeText(this, "SEND SMS permissions declined!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------
    //----- Make Call
    public void openCallApplication(){
        String phoneNumber = telefono_text;
        if(phoneNumber.isEmpty()){
            Toast.makeText(this, "Phone number required!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phoneNumber));

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
            startActivity(intent);
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------
    //----- Send SMS
    public void openSMSApplication(){
        String phoneNumber = telefono_text;
        if(phoneNumber.isEmpty()){
            Toast.makeText(this, "Phone number required!", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:"+phoneNumber));

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED)
            startActivity(intent);
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------
    //----- Open Browser
    public void openBrowserApplication(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(direcion_text));
        startActivity(intent);
    }


    //-----------------------------------------------------------------------------------------------------------------------------------------
    //----- Send Email
    public void sendEmail(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.fromParts("mailto",email_text,null));
        startActivity(intent);
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------
    //----- Share Info
    public void shareInfo(View view){
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, nombre_text.getText().toString());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }


}
