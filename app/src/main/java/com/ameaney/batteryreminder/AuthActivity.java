package com.ameaney.batteryreminder;

import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_auth);

        getSupportActionBar().setTitle("Enter Pin");
    }

    public void checkPin(String pin)
    {
        PinStorage storage = new PinStorage();

        if (storage.confirmPin(this, pin))
        {
            Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SetupActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(this, "Pin did not match saved pin.", Toast.LENGTH_SHORT).show();
        }
    }
}
