package com.example.supriyak.cleanindia;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.content.Intent;
        import android.widget.ImageView;

        import com.google.firebase.auth.FirebaseAuth;


public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView si1;
    private ImageView driver1;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        firebaseAuth = FirebaseAuth.getInstance();
        //FirebaseUser user = firebaseAuth.getCurrentUser();

        si1 = (ImageView) findViewById(R.id.si);
        driver1 = (ImageView) findViewById(R.id.driver);
        si1.setOnClickListener(this);
        driver1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == si1) {
            startActivity(new Intent(this, RegisterActivity.class));
        }
        if (view == driver1) {
            startActivity(new Intent(this, RegisterActivity.class));
        }


    }
}