package com.example.supriyak.cleanindia.firebase;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;



public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = "MyFirebaseIDService";
    @Override
    public void onTokenRefresh() {
        //getting registration token
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        //displaying token on logcat
        // FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token:" + refreshedToken);

        //sendRegistartionToserver(refreshedToken);

    }
    // private void sendRegistartionToserver(String token)
    //{
    //you can implement this method to store the token on your server
    // }
}