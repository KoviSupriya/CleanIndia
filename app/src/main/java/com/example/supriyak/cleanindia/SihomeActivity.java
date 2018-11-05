package com.example.supriyak.cleanindia;

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


public class SihomeActivity extends AppCompatActivity implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private ImageView canLocation;
    private ImageView notify;
    private ImageView statistics;
    private TextView textViewUserEmail;
    private Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sihome);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        canLocation = (ImageView) findViewById(R.id.canLocation);
        notify = (ImageView) findViewById(R.id.notify);
        statistics = (ImageView) findViewById(R.id.statistics);
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        textViewUserEmail.setText("Welcome "+user.getEmail());
        //adding listener to button
        canLocation.setOnClickListener(this);
        notify.setOnClickListener(this);
        statistics.setOnClickListener(this);
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
            startActivity(new Intent(SihomeActivity.this, MainActivity.class));
        }
        if(view == canLocation)
        {
            startActivity(new Intent(SihomeActivity.this, LocationActivity.class));
        }
        if(view == notify)
        {
            startActivity(new Intent(SihomeActivity.this, NotificationActivity.class));
        }
        if(view == statistics)
        {
            startActivity(new Intent(SihomeActivity.this, StatisticsActivity.class));
        }
    }
}


