package com.velocityauto.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PHONE = "0676589756";
    private static final String WHATSAPP = "2789451908";
    private static final String EMAIL = "Masikolitha@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button callButton = findViewById(R.id.callButton);
        Button whatsappButton = findViewById(R.id.whatsappButton);
        Button emailButton = findViewById(R.id.emailButton);

        callButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + PHONE));
            startActivity(intent);
        });

        whatsappButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://wa.me/" + WHATSAPP));
            startActivity(intent);
        });

        emailButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + EMAIL));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Vehicle Service Enquiry");
            startActivity(intent);
        });
    }
}
