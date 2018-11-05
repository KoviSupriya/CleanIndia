package com.example.supriyak.cleanindia;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView Cadmin1;
    private ImageView si1;
    private ImageView driver1;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        Cadmin1 = (ImageView) findViewById(R.id.Cadmin);
        si1 = (ImageView) findViewById(R.id.si);
        driver1 = (ImageView) findViewById(R.id.driver);
        Cadmin1.setOnClickListener(this);
        si1.setOnClickListener(this);
        driver1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == Cadmin1)
        {
            finish();
            startActivity(new Intent(this, AdminActivity.class));

        }

        if(view == si1) {

            finish();
            if (firebaseAuth.getCurrentUser() != null) {
                //close this activity
                // finish();
                startActivity(new Intent(SelectActivity.this, SihomeActivity.class));
            } else {
                startActivity(new Intent(SelectActivity.this, RegistrationActivity.class));
            }

        }
        if(view == driver1)
        {
            finish();
            if (firebaseAuth.getCurrentUser() != null) {
                //close this activity
                //finish();

                startActivity(new Intent(SelectActivity.this, DriverhomeActivity.class));
            }
            else{
                startActivity(new Intent(SelectActivity.this, RegistrationActivity.class));
            }

        }
    }
}

