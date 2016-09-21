package com.example.emmanuel.altomobile_test.animal_utils;

import android.content.Context;

import android.widget.ArrayAdapter;

import java.util.List;

//Class created in case Adapter Behaviour need to be modified.
public class AnimalAdapter extends ArrayAdapter<Animal>{

    private Context context;
    private List<Animal> values;

    public AnimalAdapter(Context context, int resource, List<Animal> objects) {
        super(context, resource, objects);
        this.context = context;
        this.values = objects;
    }
}
