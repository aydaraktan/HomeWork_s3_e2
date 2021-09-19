package com.example.homework_s3_e2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button btn;
private Button send;
private EditText address, subject, text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);

        send =  findViewById(R.id.button3);
        address = findViewById(R.id.emailaddress);
        subject = findViewById(R.id.emailsubject);
        text = findViewById(R.id.emailtext);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra("android.intent.extras.CAMERA_CAPTURE", 0);
                startActivity(intent);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(address.getText().toString().isEmpty()|| subject.getText().toString().isEmpty() || text.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"введите поле",Toast.LENGTH_SHORT).show();
                }else {
                    String to = address.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, text.getText().toString());

                        startActivity(intent);
                }


            }
        });

}
}