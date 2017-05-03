package com.example.nicolai.mandatorycantine;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AddUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
    }

    public void addBook2(View view) {
        String email = ((EditText) findViewById(R.id.add_email)).getText().toString();
        String firstName = ((EditText) findViewById(R.id.add_FirstName)).getText().toString();
        String lastName = ((EditText) findViewById(R.id.add_LastName)).getText().toString();
        String passWord = ((EditText) findViewById(R.id.add_Password)).getText().toString();
        String pictureURL = "";
        //String jsonDocument =
        //        "{\"Title\":\"" + title + "\", \"Author\":\"" + author + "\", \"Publisher\":\"" + publisher + "\", \"Price\":" + price + "}";

        TextView messageView = (TextView) findViewById(R.id.add_user_message);
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Email", email);
            jsonObject.put("Firstname", firstName);
            jsonObject.put("Lastname", lastName);
            jsonObject.put("Password", passWord);
            jsonObject.put("PictureUrl", pictureURL);
            String jsonDocument = jsonObject.toString();
            messageView.setText(jsonDocument);
            PostUserTask task = new PostUserTask();
            task.execute("http://anbo-canteen.azurewebsites.net/Service1.svc/customers", jsonDocument);
        } catch (JSONException ex) {
            messageView.setText(ex.getMessage());
        }
        finish();
    }



    private class PostUserTask extends AsyncTask<String, Void, CharSequence> {
        //private final String JsonDocument;

        //PostBookTask(String JsonDocument) {
        //    this.JsonDocument = JsonDocument;
        //}

        @Override
        protected CharSequence doInBackground(String... params) {
            String urlString = params[0];
            String jsonDocumet = params[1];
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
                osw.write(jsonDocumet);
                osw.flush();
                osw.close();
                int responseCode = connection.getResponseCode();
                if (responseCode / 100 != 2) {
                    String responseMessage = connection.getResponseMessage();
                    throw new IOException("HTTP response code: " + responseCode + " " + responseMessage);
                }
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line = reader.readLine();
                return line;
            } catch (MalformedURLException ex) {
                cancel(true);
                String message = ex.getMessage() + " " + urlString;
                Log.e("USER", message);
                return message;
            } catch (IOException ex) {
                cancel(true);
                Log.e("USER", ex.getMessage());
                return ex.getMessage();
            }
        }
        @Override
        protected void onPostExecute(CharSequence charSequence) {
            super.onPostExecute(charSequence);
            TextView messageView = (TextView) findViewById(R.id.add_user_message);
            messageView.setText(charSequence);
        }

        @Override
        protected void onCancelled(CharSequence charSequence) {
            super.onCancelled(charSequence);
            TextView messageView = (TextView) findViewById(R.id.add_user_message);
            messageView.setText(charSequence);
        }
    }


}
