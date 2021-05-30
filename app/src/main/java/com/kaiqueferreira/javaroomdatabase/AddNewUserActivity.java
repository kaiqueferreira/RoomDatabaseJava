package com.kaiqueferreira.javaroomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kaiqueferreira.javaroomdatabase.db.AppDatabase;
import com.kaiqueferreira.javaroomdatabase.model.User;

public class AddNewUserActivity extends AppCompatActivity {

    EditText firstNameInput,lastNameInput;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        firstNameInput = findViewById(R.id.fistNameInput);
        lastNameInput = findViewById(R.id.lastNameInput);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNewUser(firstNameInput.getText().toString(),
                        lastNameInput.getText().toString());
            }
        });
    }

    private  void saveNewUser(String firstName, String lastName) {
        AppDatabase db = AppDatabase.getInstanceDB(this.getApplicationContext());
        User user = new User();
        user.firstName = firstName;
        user.lastName = lastName;
        db.userDao().insertUser(user);
        finish();
    }
}