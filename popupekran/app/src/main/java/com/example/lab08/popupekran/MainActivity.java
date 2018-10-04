package com.example.lab08.popupekran;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button butonGonder;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Nesneler ilişkilendirildi.
        butonGonder = findViewById(R.id.buttonGonder);
        imageView = findViewById(R.id.imageView);


        //ImageView e tıklandığında Toast mesajı ekranda belirecek
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "imageview e basıldı", Toast.LENGTH_SHORT).show();
            }
        });

        //Gönder butonuna uzun basıldığında bu kısım çalışacak
        //Bu kısımda AlertDialog un kendi tasatımının dışında bizim tasarladığımız xml dosyası görüntülenir.
        butonGonder.setOnLongClickListener(new View.OnLongClickListener() {
            //butona uzun basınca aktif olur
            @Override
            public boolean onLongClick(View v) {

                //AlertDialog tanımlandı
                AlertDialog.Builder pencere = new AlertDialog.Builder(MainActivity.this);

                LayoutInflater layoutInflater = getLayoutInflater();
                //popup ekranı gelmesi için yapıldı
                pencere.setView(layoutInflater.inflate(R.layout.popupekran,null));
                //popupekran xml ini gönderiyoruz
                pencere.setIcon(R.drawable.ic_launcher_background);
                pencere.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                pencere.show();


                return false;
            }
        });

    }
}
