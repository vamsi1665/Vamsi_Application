package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class cgpalist extends AppCompatActivity {

    FirebaseFirestore db;
    TextView txtDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpalist);
        db=FirebaseFirestore.getInstance();

        txtDisplay = (TextView)findViewById(R.id.cgpatext);

        readSingleContact();

    }

    private void readSingleContact() {
        DocumentReference contact = db.collection("AddressBook").document("1");
        contact.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful())
                {
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder data = new StringBuilder("");
                    data.append("RA1511003020378: ").append(doc.getString("RA1511003020378"));
                    data.append("\nRA1511003020379: ").append(doc.getString("RA1511003020379"));
                    data.append("\nRA1511003020380: ").append(doc.getString("RA1511003020380"));
                    txtDisplay.setText(data.toString());
                }
            }
        });
    }

    private void addNewContact()
    {
        Map<String,Object> newContact = new HashMap<>();
        newContact.put("RA1511003020378","8.5");
        newContact.put("RA1511003020379","9.5");
        newContact.put("RA1511003020380","8.0");

        db.collection("AddressBook").document("1")
                .set(newContact)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(cgpalist.this, "Add new contact", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("error",e.getMessage());
                    }
                });

    }
}