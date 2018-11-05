package com.example.supriyak.cleanindia;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Adapter;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.Spinner;
        import android.widget.Toast;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import java.util.ArrayList;
        import java.util.List;

        import android.widget.ArrayAdapter;

public class LocationActivity extends AppCompatActivity implements View.OnClickListener
{
    private Spinner spinnerLocation;
    private Spinner spinnersubLocation;
    private Button buttonDnodes;
    private FirebaseAuth firebaseAuth;


    //progress dialog
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        firebaseAuth = FirebaseAuth.getInstance();
        buttonDnodes = (Button) findViewById(R.id.buttonDnodes);
        spinnerLocation = (Spinner) findViewById(R.id.spinnerLocation);
        spinnersubLocation = (Spinner) findViewById(R.id.spinnersubLocation);
        spinnerLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                       long arg3) {
                String sp1= String.valueOf(spinnerLocation.getSelectedItem());
                // Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();
                if(sp1.contentEquals("Tirupati")) {
                    List<String> list = new ArrayList<String>();
                    list.add("--select--");
                    list.add("Gandhi Nagar");
                    list.add("Busstand");
                    list.add("Balaji colony");
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(LocationActivity.this, android.R.layout.simple_spinner_item, list);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    adapter.notifyDataSetChanged();
                    spinnersubLocation.setAdapter(adapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        buttonDnodes = (Button) findViewById(R.id.buttonDnodes);

        progressDialog = new ProgressDialog(this);

        //attaching click listener
        buttonDnodes.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view == buttonDnodes){
            finish();
            startActivity(new Intent(getApplicationContext(), NodeActivity.class));

        }

    }
}
