package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText messageWebsite;
    private EditText messageLocation;
    private EditText messageShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageWebsite = findViewById(R.id.messageETWebsite);
        messageLocation = findViewById(R.id.messageETLocation);
        messageShare = findViewById(R.id.messageETShare);

    }

    public void Website(View view) {
        String web = messageWebsite.getText().toString();
        Uri url = Uri.parse(web);
        Intent intent = new Intent(Intent.ACTION_VIEW, url);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("Implicit Intents", "Error Message");
        }
    }

    public void Location(View view) {
        String locate = messageLocation.getText().toString();
        Uri url = Uri.parse("geo:0,0?q=" +locate);
        Intent intent = new Intent(Intent.ACTION_VIEW, url);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Log.d("Implicit Intents", "Error Message");
        }
    }

    public void Share(View view) {
        String txt = messageShare.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();
    }
}