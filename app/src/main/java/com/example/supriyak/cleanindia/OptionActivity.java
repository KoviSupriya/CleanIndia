package com.example.supriyak.cleanindia;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.google.firebase.auth.FirebaseAuth;

public class OptionActivity extends AppCompatActivity implements View.OnClickListener {

    private Button location;
    private Button status;
    private FirebaseAuth firebaseAuth;

    //progress dialog
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        location = (Button) findViewById(R.id.location);
        status = (Button) findViewById(R.id.status);
        location.setOnClickListener(this);
        status.setOnClickListener(this);
    }
    @Override

    public void onClick(View view) {
        if (view == location) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://thingspeak.com/channels/436960/maps/channel_show"));
            startActivity(browserIntent);

        }
        if (view == status) {
            startActivity(new Intent(OptionActivity.this, StatusActivity.class));
        }
    }
}
