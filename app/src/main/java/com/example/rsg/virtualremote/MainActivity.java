package com.example.rsg.virtualremote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button addRemote;
    private Button selectRemote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        addRemote = (Button) findViewById(R.id.buttonAddRemote);
        selectRemote = (Button) findViewById(R.id.buttonSelectRemote);

        addRemote.setOnClickListener(this);
        selectRemote.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch(id) {
            case R.id.buttonAddRemote:
                Intent addRemoteIntent = new Intent(this, TakePictureActivity.class);
                startActivity(addRemoteIntent);
                break;
            case R.id.buttonSelectRemote:
                Intent selectRemoteIntent = new Intent(this, SelectRemoteActivity.class);
                startActivity(selectRemoteIntent);
                break;
        }
    }
}
