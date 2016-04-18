package com.example.rsg.virtualremote;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class RemoteViewActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle b = getIntent().getExtras();
        String value = b.getString("remoteName");

        ImageView img = (ImageView) findViewById(R.id.remotePicture);

        ContextWrapper cw = new ContextWrapper(getApplicationContext());

        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);


        Bitmap bitmap = BitmapFactory.decodeFile(directory+"/"+value);
        img.setImageBitmap(bitmap);

        img.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){

            Log.d("coordinates",  "X VALUE OF TOUCH: " + String.valueOf(event.getX()));
            Log.d("coordinates",  "Y VALUE OF TOUCH: " + String.valueOf(event.getY()));
        }
        return true;
    }

}
