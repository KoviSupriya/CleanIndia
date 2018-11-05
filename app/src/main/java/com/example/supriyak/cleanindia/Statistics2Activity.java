package com.example.supriyak.cleanindia;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.google.firebase.auth.FirebaseAuth;


public class Statistics2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button tc2;
    private Button tc3;
    private FirebaseAuth firebaseAuth;

    //progress dialog
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics2);

        firebaseAuth = FirebaseAuth.getInstance();
        tc2 = (Button) findViewById(R.id.tc2);
        tc3 = (Button) findViewById(R.id.tc3);
        tc2.setOnClickListener(this);
        tc3.setOnClickListener(this);

    }
    @Override

    public void onClick(View view) {
        if (view == tc2) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://thingspeak.com/channels/436973/charts/1?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&title=Node+2+contain+pink+Dustbin+with+sensor&type=line&xaxis=Date&yaxis=Empty+Distance+in+Pink+dustbin"));
            startActivity(browserIntent);
        }
        if (view == tc3) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://thingspeak.com/channels/436973/charts/2?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&title=Node+2+contain+green+Dustbin+with+sensor&type=line&xaxis=Date&yaxis=Empty+Distance+in+Green+dustbin"));
            startActivity(browserIntent);
        }
    }
}