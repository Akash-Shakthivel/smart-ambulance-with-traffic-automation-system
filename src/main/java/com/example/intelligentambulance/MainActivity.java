package com.example.intelligentambulance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private TextView text1,text2,text3,text4;
    private EditText edit1,edit2;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference= FirebaseDatabase.getInstance().getReference("Intelligent Ambulance");

        text1=findViewById(R.id.textView2);
        text2=findViewById(R.id.textView4);
        text3=findViewById(R.id.textView6);
        text4=findViewById(R.id.textView8);
        edit1=findViewById(R.id.edittext);
        edit2=findViewById(R.id.edittext2);
        submit=findViewById(R.id.Submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editdata1 =edit1.getText().toString().trim();
                String editdata2 =edit2.getText().toString().trim();

                databaseReference.child("Destination").setValue(editdata1);
                databaseReference.child("Your location").setValue(editdata2);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String data1=snapshot.child("Ambulance Status").getValue(String.class);
                String data2=snapshot.child("Arriving Status").getValue(String.class);
                String data3=snapshot.child("Arriving Time").getValue(String.class);
                String data4=snapshot.child("Total distance").getValue(String.class);

                text1.setText(data1);
                text2.setText(data2);
                text3.setText(data3);
                text4.setText(data4);

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }
}