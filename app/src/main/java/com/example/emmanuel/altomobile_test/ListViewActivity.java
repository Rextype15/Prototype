package com.example.emmanuel.altomobile_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;  //List from Listview
    private String[] array;     //Days ARRAY

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView) findViewById(R.id.listView);
        setList();

        //Add action to ListView Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tempToastString = "Days " + String.valueOf(position+1);

                Toast.makeText(getApplicationContext(), tempToastString, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Generate days + nuimber array and Fill ListView
    private void setList() {
        String listWord = "Day";
        this.array = new String[31];
        for (int i = 1; i <= 31; i++){
            this.array[i-1] = listWord + " " + String.valueOf(i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,this.array);
        this.listView.setAdapter(adapter);
    }
}
