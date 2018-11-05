package com.example.supriyak.cleanindia;


        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.content.Intent;
        import android.support.v7.widget.CardView;
        import android.view.View;
        import android.widget.Button;

        import android.widget.ImageView;
        import android.widget.TextView;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private ImageView canLocation;
    private ImageView notify;
    private ImageView valid;
    private ImageView statistics;
    private Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        canLocation = (ImageView) findViewById(R.id.canLocation);
        notify = (ImageView) findViewById(R.id.notify);
        statistics = (ImageView) findViewById(R.id.statistics);
        valid = (ImageView) findViewById(R.id.valid);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        //adding listener to button
        canLocation.setOnClickListener(this);
        notify.setOnClickListener(this);
        statistics.setOnClickListener(this);
        valid.setOnClickListener(this);
        buttonLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //if logout is pressed
        if(view == buttonLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(AdminActivity.this, MainActivity.class));
        }
        if(view == canLocation)
        {
            startActivity(new Intent(AdminActivity.this, LocationActivity.class));
        }
        if(view == notify)
        {
            startActivity(new Intent(AdminActivity.this, NotificationActivity.class));
        }
        if(view == statistics)
        {
            startActivity(new Intent(AdminActivity.this, StatisticsActivity.class));
        }
        if(view == valid)
        {
            startActivity(new Intent(AdminActivity.this, ValidationActivity.class));
        }
    }
}
