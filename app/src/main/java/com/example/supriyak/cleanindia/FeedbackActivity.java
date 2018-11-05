package com.example.supriyak.cleanindia;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.RadioButton;
        import android.widget.Spinner;
        import android.widget.TextView;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;


public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewUserEmail;
    private Spinner trashid;
    private RadioButton rb1;
    private RadioButton rb2;
    String SpinnerValue;
    String[] Trashid = {"--Select Node --","Node1 - Trashcan 1","Node2 - Trashcan 2","Node2 - Trashcan 3"};
    private FirebaseAuth firebaseAuth;

    //progress dialog
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        trashid = (Spinner) findViewById(R.id.trashid);
        progressDialog = new ProgressDialog(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(FeedbackActivity.this, android.R.layout.simple_list_item_1, Trashid);
        trashid.setAdapter(adapter);
        textViewUserEmail.setText(user.getEmail());
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        trashid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                SpinnerValue = (String) trashid.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void onRadioButtonClicked(View view) {
        final String email = textViewUserEmail.getText().toString().trim();
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        progressDialog.show();
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {

            case R.id.rb1:
                if (checked) {

                    DatabaseReference fDatabase = FirebaseDatabase.getInstance().getReference().child("Feedback");
                    DatabaseReference currentUserDB = fDatabase.child(firebaseAuth.getCurrentUser().getUid());
                    currentUserDB.child("Email").setValue(email);
                    currentUserDB.child("Trashcanid").setValue(trashid.getSelectedItem());
                    currentUserDB.child("Feedback").setValue(rb1.getText());
                    startActivity(new Intent(getApplicationContext(), GivefeedActivity.class));
                    break;
                }
            case R.id.rb2:
                if (checked) {
                    DatabaseReference fDatabase = FirebaseDatabase.getInstance().getReference().child("Feedback");
                    DatabaseReference currentUserDB = fDatabase.child(firebaseAuth.getCurrentUser().getUid());
                    currentUserDB.child("Email").setValue(email);
                    currentUserDB.child("Trashcanid").setValue(trashid.getSelectedItem());
                    currentUserDB.child("Feedback").setValue(rb1.getText());
                    startActivity(new Intent(getApplicationContext(), GivefeedActivity.class));
                    break;
                }
        }

    }
    @Override
    public void onClick(View view) {
        if (view == rb1) {
            onRadioButtonClicked(view);
        }
        if (view == rb2) {
            onRadioButtonClicked(view);
        }
    }
}
