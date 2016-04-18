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
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by brian on 4/18/16.
 */
public class ChangeRemoteActivity extends AppCompatActivity implements View.OnClickListener {
    String value;
    File directory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle b = getIntent().getExtras();
        value = b.getString("remoteName");

        ContextWrapper cw = new ContextWrapper(getApplicationContext());

        directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
    }


        @Override
    public void onClick(View v) {
        int id = v.getId();

        switch(id) {
            case R.id.buttonDeleteRemote:
                File todel = new File(directory+"/"+value);
                todel.delete();
                getIntent().finish();

            case R.id.buttonChangeName:
                File tomv= new File(directory+"/"+value);
                EditText newname = (EditText) findViewById(R.id.textChangeName);
                File newfile = new File(directory+"/"+newname.getText().toString());
                tomv.renameTo(newfile);
                getIntent().finish();
        }
    }
}
