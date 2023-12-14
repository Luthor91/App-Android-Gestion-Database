package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapp.rest.CategoryRest;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        RecyclerView recyclerView = findViewById(R.id.categoriesList);
        CategoryRest discountRest=new CategoryRest(recyclerView,this);
        discountRest.execute();
    }
}