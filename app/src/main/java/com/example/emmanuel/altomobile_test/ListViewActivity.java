package com.example.emmanuel.altomobile_test;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.emmanuel.altomobile_test.animal_utils.Animal;
import com.example.emmanuel.altomobile_test.animal_utils.AnimalAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;  //List from Listview
    private String connectionAnimalURL = "https://dl.dropboxusercontent.com/u/820149/data.json";
    private Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView) findViewById(R.id.listView);
        
        new AnimalParse().execute();

    }

    private class AnimalParse extends AsyncTask<String,String,AnimalAdapter>{

        @Override
        protected AnimalAdapter doInBackground(String... params) {

            AnimalAdapter adapter = null;

            try {

                String json = ConnectionManager.GetInstance().GetResponse(connectionAnimalURL);

                //Parse json to List
                gson = new Gson();
                List<Animal> list = gson.fromJson(json, new TypeToken<List<Animal>>(){}.getType());

                //Create Adapter
                adapter = new AnimalAdapter(getBaseContext(),android.R.layout.simple_list_item_1,list);

                //Log.d("Response",json);
            } catch (IOException e) {
                Log.d("ERROR", "Could not load Json from url");
                e.printStackTrace();
            }

            return adapter;
        }

        @Override
        protected void onPostExecute(final AnimalAdapter animalAdapter) {
            listView.setAdapter(animalAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Animal tempAnimal = animalAdapter.getItem(position);
                    Toast.makeText(getApplicationContext(), String.valueOf(tempAnimal.getLife()), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
