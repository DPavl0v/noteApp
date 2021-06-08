package com.example.NoteApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddANote extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference myRef;
    private Button btnBack, btnAddANote;
    private EditText note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_a_note);
        init();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddANote.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnAddANote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase = FirebaseDatabase.getInstance();
                myRef = firebaseDatabase.getReference();
                myRef.push().setValue(note.getText().toString());
                Toast.makeText(getApplicationContext(), "Note has been created", Toast.LENGTH_LONG).show();


            }
        });
        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                note.setText("");
            }
        });
    }

    private void init() {

        btnAddANote = findViewById(R.id.button);
        btnBack = findViewById(R.id.button2);
        note = findViewById(R.id.editText);
    }
}