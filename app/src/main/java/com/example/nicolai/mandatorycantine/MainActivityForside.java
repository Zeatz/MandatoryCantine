package com.example.nicolai.mandatorycantine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivityForside extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMenu(View view){
        Intent intent = new Intent(this, Main2ActivityMenu.class);
        startActivity(intent);
    }
    public void onClickRate(View view){
        Intent intent = new Intent(this, Main3ActivityLogIn.class);
        startActivity(intent);
    }
    public void onClickTakeAway(View view){
        Intent intent = new Intent(this, Main3ActivityTakeAway.class);
        startActivity(intent);
    }
    public void onClickPointsMenu(View view){
        Intent intent = new Intent(this, PointsMenu.class);
        startActivity(intent);
    }

    public void onClickAddUser(View view){
        Intent intent = new Intent(this, AddUser.class);
        startActivity(intent);
    }
}
