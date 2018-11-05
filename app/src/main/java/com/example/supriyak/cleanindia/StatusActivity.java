package com.example.supriyak.cleanindia;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class StatusActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tcstatus;
    private TextView empdis;
    private TextView status;
    private FirebaseAuth firebaseAuth;
    Dustbin climate;

    //progress dialog
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        //tcstatus = (TextView) findViewById(R.id.tcstatus);
        //empdis = (TextView) findViewById(R.id.empdis);
       status = (TextView) findViewById(R.id.status);

        tcstatus.setOnClickListener(this);

    }

    private void showStatus()
    {

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference().child("Node1");
        //final distance = rootRef.
        //final String dis = rootRef.push().getKey();
        rootRef.addValueEventListener(new ValueEventListener() {
            @Override

            // final String distance = status.getText().toString().trim();
            //final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Sensor1");
            // final String val = mDatabase.push().getKey();
            // mDatabase.child("Distance").addValueEventListener(new ValueEventListener() {
            //  @Override
            public void onDataChange(DataSnapshot dataSnapshot)

            {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    // final Status distance = new Status();
                    // distance.setDistance(distance);;
                    //  climate.setDistance(int di);

                   Dustbin climate = ds.getValue(Dustbin.class);

                    climate.getDistance();

                    //You could extract the values of object using the getter methods
                    //and display it in your GUI.



                    // rootRef.child("Distance").setValue(dataSnapshot.getValue(Status.class));
                    //   dis.getDistance();
                    ((TextView)findViewById(R.id.status)).setText(climate.getDistance());

                    // status.setText(String.valueOf(climate));



                    //
                    //Status Distance = dataSnapshot.getValue(Status.class);
                    //status.setText(String.valueOf(Distance));
                    //status.setText(String.valueOf(val));



                    // Status Distance = dataSnapshot.getValue(Status.class);
                    // ((TextView)findViewById(R.id.status)).setText(Distance.getDistance());


                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view == tcstatus) {

            showStatus();
        }
    }
}