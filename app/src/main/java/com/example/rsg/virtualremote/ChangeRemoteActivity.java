package com.example.rsg.virtualremote;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

/**
 * Created by brian on 4/18/16.
 */
public class ChangeRemoteActivity extends AppCompatActivity implements View.OnClickListener {
    private String value;
    private File directory;
    private Button deleteRemote, changeName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle b = getIntent().getExtras();
        value = b.getString("remoteName");

        //getting buttons
        deleteRemote = (Button) findViewById(R.id.buttonDeleteRemote);
        changeName = (Button) findViewById(R.id.buttonChangeName);
        deleteRemote.setOnClickListener(this);
        changeName.setOnClickListener(this);

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
                Intent intent = new Intent(this, EditRemote.class);
                startActivity(intent);

            case R.id.buttonChangeName:
                File tomv= new File(directory+"/"+value);
                EditText newname = (EditText) findViewById(R.id.textChangeName);
                File newfile = new File(directory+"/"+newname.getText().toString());
                tomv.renameTo(newfile);
        }
    }
}
