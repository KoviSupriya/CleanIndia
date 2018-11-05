package com.example.supriyak.cleanindia;

        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Adapter;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.Spinner;
        import com.google.firebase.auth.FirebaseAuth;
        import java.util.ArrayList;
        import android.widget.ArrayAdapter;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;



public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinnerType;
    private Button buttonRegister;
    private EditText etFirstname;
    private EditText etLastname;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText etCpassword;
    private EditText etEmpId;
    private EditText etLocation;
    private EditText etPhone;
    String SpinnerValue;
    String[] SPINNERVALUES = {"--Select Employee Type--","Sanitary Inspector","Truck Driver"};
    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //progress dialog
    private ProgressDialog progressDialog;
    private FirebaseAuth.AuthStateListener AuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();
        etFirstname = (EditText) findViewById(R.id.etFirstname);
        etLastname = (EditText) findViewById(R.id.etLastname);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        etCpassword = (EditText) findViewById(R.id.etCpassword);
        etEmpId = (EditText) findViewById(R.id.etEmpId);
        etLocation = (EditText) findViewById(R.id.etLocation);
        etPhone = (EditText) findViewById(R.id.etPhone);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        spinnerType = (Spinner) findViewById(R.id.spinnerType);
        progressDialog = new ProgressDialog(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterActivity.this, android.R.layout.simple_list_item_1, SPINNERVALUES);
        spinnerType.setAdapter(adapter);

        //attaching click listener
        buttonRegister.setOnClickListener(this);
        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                SpinnerValue = (String)spinnerType.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void registerUser() {

        final String Firstname = etFirstname.getText().toString().trim();
        final String Lastname = etLastname.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        final String Cpassword = etCpassword.getText().toString().trim();
        final String EmpId = etEmpId.getText().toString().trim();
        final String Location = etLocation.getText().toString().trim();
        final String Phone = etPhone.getText().toString().trim();
        final String Spinnervalue = spinnerType.toString().trim();
        if (TextUtils.isEmpty(Firstname)) {
            Toast.makeText(this, "Please enter valid firstname", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(Lastname)) {
            Toast.makeText(this, "Please enter valid lastname", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter valid email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter correct password", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(Cpassword)) {
            Toast.makeText(this, "Re-enter correct password", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(EmpId)) {
            Toast.makeText(this, "Please enter valid empid", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(Location)) {
            Toast.makeText(this, "Please enter atleast one location", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(Phone)) {
            Toast.makeText(this, "Please enter valid mobile number", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();
//logging in the user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //if the task is successfull
                        if (task.isSuccessful()) {

                            firebaseAuth.createUserWithEmailAndPassword(email, password);

                            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
                            DatabaseReference currentUserDB = mDatabase.child(firebaseAuth.getCurrentUser().getUid());
                            currentUserDB.child("Firstname").setValue(Firstname);
                            currentUserDB.child("Email").setValue(email);
                            currentUserDB.child("EmpType").setValue(spinnerType.getSelectedItem());
                            currentUserDB.child("EmpId").setValue(EmpId);
                            currentUserDB.child("Location").setValue(Location);
                            currentUserDB.child("Phone").setValue(Phone);
                            String Spinnervalue = String.valueOf(spinnerType.getSelectedItem());
                            if (Spinnervalue.contentEquals("Sanitary Inspector")) {
                                startActivity(new Intent(RegisterActivity.this, SihomeActivity.class));
                            }
                            if (Spinnervalue.contentEquals("Truck Driver")) {
                                DatabaseReference dDatabase = FirebaseDatabase.getInstance().getReference().child("DriverInfo");
                                currentUserDB = dDatabase.child(firebaseAuth.getCurrentUser().getUid());
                                currentUserDB.child("Firstname").setValue(Firstname);
                                currentUserDB.child("Email").setValue(email);
                                currentUserDB.child("EmpType").setValue(spinnerType.getSelectedItem());
                                currentUserDB.child("EmpId").setValue(EmpId);
                                currentUserDB.child("Location").setValue(Location);
                                currentUserDB.child("Phone").setValue(Phone);
                                startActivity(new Intent(RegisterActivity.this, DriverhomeActivity.class));
                            }

                        } else {
                            Toast.makeText(RegisterActivity.this, "Error Registering user..", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view)
    {
        if(view == buttonRegister)
        {
            registerUser();
        }
    }
}


