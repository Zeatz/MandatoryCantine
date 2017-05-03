package com.example.nicolai.mandatorycantine;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main2ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    protected void onStart(){
        super.onStart();
        ReadTask task = new ReadTask();
        task.execute("http://anbo-canteen.azurewebsites.net/Service1.svc/dishes");
    }

    private class ReadTask extends ReadHttpTask {
        @Override
        protected void onPostExecute(CharSequence charSequence) {
            super.onPostExecute(charSequence);
            //messageTextView.setText(charSequence);
            final List<Dishes> dishes = new ArrayList<>();
            try {
                JSONArray array = new JSONArray(charSequence.toString());
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    double alcohol = obj.getDouble("Alcohol");
                    double carbohydrates = obj.getDouble("Carbohydrates");
                    String description = obj.getString("Description");
                    int energy = obj.getInt("Energy");
                    int id = obj.getInt("Id");
                    int fat = obj.getInt("Fat");
                    String pictureUrl = obj.getString("PictureUrl");
                    double price = obj.getDouble("Price");
                    double protein = obj.getDouble("Protein");
                    String title = obj.getString("Title");
                    double weight = obj.getDouble("Weight");
                    Dishes dish = new Dishes(alcohol, carbohydrates, description, energy, id, fat, pictureUrl, price, protein, title, weight);
                    dishes.add(dish);
                }
                ListView listView = (ListView) findViewById(R.id.main_dish_listview);
                //ArrayAdapter<Book> adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, dishes);
                DishListItemAdapter adapter = new DishListItemAdapter(getBaseContext(), R.layout.dishlistlayout, dishes);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getBaseContext(), DishActivity.class);
                        intent.putExtra("DISH", dishes.get((int) id));
                        startActivity(intent);
                    }
                });
            } catch (JSONException ex) {
                Log.e("DISH", ex.getMessage());
            }
        }

}
}
