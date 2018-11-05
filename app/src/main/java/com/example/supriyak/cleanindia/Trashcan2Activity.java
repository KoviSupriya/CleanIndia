package com.example.supriyak.cleanindia;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.google.firebase.auth.FirebaseAuth;


public class Trashcan2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button tc2;
    private Button tc3;
    private FirebaseAuth firebaseAuth;

    //progress dialog
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trashcan2);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        tc2 = (Button) findViewById(R.id.tc2);
        tc3 = (Button) findViewById(R.id.tc3);
        tc2.setOnClickListener(this);
        tc3.setOnClickListener(this);
    }

    @Override

    public void onClick(View view) {
        if (view == tc2) {
            startActivity(new Intent(Trashcan2Activity.this, Option1Activity.class));
        }
        if (view == tc3) {
            startActivity(new Intent(Trashcan2Activity.this, Option2Activity.class));
        }
    }
}
