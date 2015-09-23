package com.ameaney.batteryreminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ameaney.pinhandler.PinStorage;
import com.ameaney.pinhandler.PinView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AuthActivity extends AppCompatActivity
{
    @Bind(R.id.pinView)
    protected PinView _pinView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_auth);

        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Enter Pin");
    }

    public void checkPin(String pin)
    {
        PinStorage storage = new PinStorage();

        if (storage.confirmPin(this, pin))
        {
            // Go to main activity
            Toast.makeText(this, "Main", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Pin did not match saved pin.", Toast.LENGTH_SHORT).show();
        }
    }
}
