package com.example.myaicte;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

public class DummyActivity extends AppCompatActivity {

    Button submit;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        submit= findViewById(R.id.submitBtn);
        firebaseDatabase= FirebaseDatabase.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataPoint= new DataPoint();
                dataPoint.set aicteId("1");
                dataPoint.setName("Vp");
                dataPoint.setClosed(false);
                dataPoint.setDistrict("Mumbai");
                dataPoint.setProgram("IF");

                String key= firebaseDatabase.getReference("Dummy").push().getKey();
//
//                firebaseDatabase.getReference("Dummy").child(key).child("otherApprovals").child("NRI").setValue()

                firebaseDatabase.getReference("Dummy").child(key).setValue(dataPoint).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
//                        Toast.makeText(DummyActivity.this, "Done", Toast.LENGTH_SHORT).show();

                        Faculty faculty= new Faculty();
                        faculty.setDesignation("professor");
                        faculty.setName("rvdxiuszj");
                        faculty.setfId("2");
                        faculty.setGender("Female");


                        firebaseDatabase.getReference("Dummy").child(key).child("Faculty").setValue(faculty).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(DummyActivity.this, "Faculty done", Toast.LENGTH_SHORT).show();
                            }
                        });



                    }
                });
            }
        });
    }
}

