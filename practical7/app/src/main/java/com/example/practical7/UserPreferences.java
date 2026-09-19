package com.example.practical7;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class UserPreferences {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;

    public UserPreferences(Context context) {

        this.context = context;

        preferences = context.getSharedPreferences("UserData", Context.MODE_PRIVATE);

        editor = preferences.edit();
    }

    // Save Data here
    public void saveData(String username, String password) {

        editor.putString("username", username);
        editor.putString("password", password);

        editor.apply();

        Toast.makeText(context, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
    }

    // Get Username
    public String getUsername() {

        return preferences.getString("username", "");
    }

    // Get Password
    public String getPassword() {

        return preferences.getString("password", "");
    }
}