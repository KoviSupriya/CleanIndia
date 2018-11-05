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

public class DriverhomeActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    //view objects
    private ImageView canLocation;
    private ImageView feedback;
    private TextView textViewUserEmail;
    private Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driverhome);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        canLocation = (ImageView) findViewById(R.id.canLocation);
        feedback = (ImageView) findViewById(R.id.feedback);
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        textViewUserEmail.setText("Welcome "+user.getEmail());
        //adding listener to button
        canLocation.setOnClickListener(this);
        feedback.setOnClickListener(this);
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
            startActivity(new Intent(DriverhomeActivity.this, MainActivity.class));
        }
        if(view == canLocation)
        {
            startActivity(new Intent(DriverhomeActivity.this, LocationActivity.class));
        }
        if(view == feedback)
        {
            startActivity(new Intent(DriverhomeActivity.this, FeedbackActivity.class));
        }
    }
}



