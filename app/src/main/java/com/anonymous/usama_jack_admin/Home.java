package com.anonymous.usama_jack_admin;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import dmax.dialog.SpotsDialog;

public class Home extends AppCompatActivity {
    private TextView noOfusers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        noOfusers = findViewById(R.id.noOfUsers);

        final android.app.AlertDialog waitingDialog = new SpotsDialog.Builder().setContext(Home.this).build();
        waitingDialog.show();

        DatabaseReference userNode = FirebaseDatabase.getInstance().getReference("User's Database");

        userNode.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                long size = snapshot.getChildrenCount();
                noOfusers.setText(String.valueOf(size));
                waitingDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //You can Handle Some Errors Here!
            }
        });
    }
}