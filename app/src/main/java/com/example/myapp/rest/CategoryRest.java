package com.example.myapp.rest;

import android.content.Context;
import android.os.AsyncTask;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.adapter.CategoryAdapter;
import com.example.myapp.dta.CategoryDto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CategoryRest extends AsyncTask<Character,Void, Void> {
    private RecyclerView recyclerView;
    private List<CategoryDto> discounts=new ArrayList<>();
    private Context mContext;
    //private final Handler handler = new Handler(Looper.getMainLooper());
    public CategoryRest(RecyclerView recyclerView, Context mContext) {
        this.recyclerView = recyclerView;
        this.mContext=mContext;

    }

    @Override
    protected Void doInBackground(Character... strings) {
        try {  String data="";
                URL url = new URL("http://10.0.2.2:8080/TP03-1.0-SNAPSHOT/api/Category");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    data = data + line;
                }
                JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject JO= (JSONObject) jsonArray.get(i);
                CategoryDto discount = new CategoryDto(JO.getInt("id"),
                        JO.getString("title"),
                        JO.getString("webTitle"),
                        JO.getInt("leval"));
                discounts.add(discount);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
            CategoryAdapter adapter = new CategoryAdapter(this.mContext, discounts);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
    }
}
