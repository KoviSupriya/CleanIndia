package com.example.supriyak.cleanindia;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.google.firebase.auth.FirebaseAuth;


public class Trashcan1Activity extends AppCompatActivity implements View.OnClickListener {


    private Button tc1;
    private FirebaseAuth firebaseAuth;

    //progress dialog
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trashcan1);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        tc1 = (Button) findViewById(R.id.tc1);
        tc1.setOnClickListener(this);
    }

    @Override

    public void onClick(View view) {
        if (view == tc1) {
            startActivity(new Intent(Trashcan1Activity.this, OptionActivity.class));
        }
    }
}