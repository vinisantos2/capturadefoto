package com.example.cadastro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static int CAPTURAR_IMAGEM = 1;
    ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagem = (ImageView) findViewById(R.id.imageView);
    }
    public void abrirCamera(View v){
        Intent fotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(fotoIntent, CAPTURAR_IMAGEM);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAPTURAR_IMAGEM ){
            if(resultCode == RESULT_OK){
                Toast.makeText(getApplicationContext(), "Imagem capturada", Toast.LENGTH_LONG).show();
                Bundle bundle = data.getExtras();
                Bitmap imagemBitmap = (Bitmap) bundle.get("data");
                imagem.setImageBitmap(imagemBitmap);
            }
        }else{
            Toast.makeText(getApplicationContext(), "Imagem não capturada", Toast.LENGTH_LONG).show();
        }

    }
}