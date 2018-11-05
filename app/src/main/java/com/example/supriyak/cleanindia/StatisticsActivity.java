package com.example.supriyak.cleanindia;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.CardView;
        import android.view.View;

        import com.google.firebase.auth.FirebaseAuth;

public class StatisticsActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView node1;
    private CardView node2;
    private FirebaseAuth firebaseAuth;

    //progress dialog
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        node1 = (CardView) findViewById(R.id.node1);
        node2 = (CardView) findViewById(R.id.node2);
        node1.setOnClickListener(this);
        node2.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view == node1){
            startActivity(new Intent(StatisticsActivity.this, Statistics1Activity.class));
        }

        if(view == node2){
            finish();
            startActivity(new Intent(StatisticsActivity.this, Statistics2Activity.class));
        }
    }
}
