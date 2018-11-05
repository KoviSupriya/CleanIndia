package com.example.supriyak.cleanindia;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.google.firebase.auth.FirebaseAuth;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sms;
    private Button feed;
    private FirebaseAuth firebaseAuth;

    //progress dialog
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        sms = (Button) findViewById(R.id.sms);
        feed = (Button) findViewById(R.id.feed);
        sms.setOnClickListener(this);
        feed.setOnClickListener(this);
    }

    @Override

    public void onClick(View view) {
        if (view == sms) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://console.firebase.google.com/u/0/project/clean-india-7044f/notification/compose"));
            startActivity(browserIntent);
        }
        if (view == feed) {
            startActivity(new Intent(NotificationActivity.this, ViewfeedbackActivity.class));
        }
    }
}

