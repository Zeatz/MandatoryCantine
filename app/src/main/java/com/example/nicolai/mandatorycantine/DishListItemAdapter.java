package com.example.nicolai.mandatorycantine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class DishListItemAdapter extends ArrayAdapter<Dishes> {
    private int resource;

    public DishListItemAdapter(Context context, int resource, List<Dishes> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Dishes dishes = getItem(position);
        String title = dishes.getTitle();
        String description = dishes.getDescription();

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dishlistlayout, parent, false);
        }

        TextView titleView = (TextView) convertView.findViewById(R.id.dishlist_item_title);
        TextView descriptionView = (TextView) convertView.findViewById(R.id.dishlist_item_description);
        titleView.setText(title);
        descriptionView.setText(description);
        return convertView;
    }
}
