package com.example.telefonodinero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.math.BigInteger;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {
    TextView contador;
    BigInteger num;
    BigInteger valorclick = BigInteger.ONE;
    BigInteger costebillete = new BigInteger("100");
    Button botonMejora1;
    ImageView coin_image;

    BigInteger n = BigInteger.ONE;
    BigInteger incrementoAutomatico = BigInteger.ONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = findViewById(R.id.textocontador);
        botonMejora1 = findViewById(R.id.button);
        coin_image = findViewById(R.id.imageView);
        Actualizar();
    }

    public void Actualizar() {
        contador.setText(num.toString());
    }

    public void sumar(View v) {
        ScaleAnimation fade_in = new ScaleAnimation(0.7f, 1.2f, 0.7f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        fade_in.setDuration(100);
        coin_image.startAnimation(fade_in);
        num = num.add(valorclick);
        contador.setText(num.toString());
    }

    public void mejora1(View v) {
        if (num.compareTo(costebillete) >= 0) {
            num = num.subtract(costebillete);
            valorclick = valorclick.add(BigInteger.ONE);
            contador.setText(num.toString());
            costebillete = costebillete.add(new BigInteger("20"));
            botonMejora1.setText(costebillete.toString() + " coins");
        }
    }
}
