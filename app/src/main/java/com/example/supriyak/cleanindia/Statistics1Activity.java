package com.example.supriyak.cleanindia;

        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

public class Statistics1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics1);
    }
    public void open(View view)
    {

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://thingspeak.com/channels/436960/charts/1?bgcolor=%23ffffff&color=%23d62020&dynamic=true&type=line&yaxismax=100&yaxismin=0"));
        startActivity(browserIntent);
    }
}
