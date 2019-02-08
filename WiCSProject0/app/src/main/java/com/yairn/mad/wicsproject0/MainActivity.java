package com.yairn.mad.wicsproject0;

// yair25
// https://github.com/txcsmad

import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton button0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        button0 = findViewById(R.id.button0);
        recyclerView = findViewById(R.id.recyclerView);
        ArrayList<Integer> container = new ArrayList<>();
        container.add(0);


        setUpRV(container);

    }

    private void setUpRV(ArrayList<Integer> container) {
        recyclerView.setHasFixedSize(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        WiCSAdapter adapter = new WiCSAdapter(container);
        recyclerView.setAdapter(adapter);

    }

    public void onClickCameraButton(View view) {
        Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        try {
            if(camIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(camIntent, 0);
            }
        } catch (Exception e) {
            Toast.makeText(this, "No Camera App Found", Toast.LENGTH_LONG).show();
        }
    }

}
