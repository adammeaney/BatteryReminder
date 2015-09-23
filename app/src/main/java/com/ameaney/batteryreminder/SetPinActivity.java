package com.ameaney.batteryreminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ameaney.pinhandler.OnPinFinishedListener;
import com.ameaney.pinhandler.PinStorage;
import com.ameaney.pinhandler.PinView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SetPinActivity extends AppCompatActivity
{
    @Bind(R.id.pinView)
    protected PinView _firstPin;

    @Bind(R.id.pinViewConfirm)
    protected PinView _secondPin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_set_pin);

        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Set Pin");

        PinStorage storage = new PinStorage();
        if (storage.hasPin(this))
        {
            Toast.makeText(this, "Show Auth", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, AuthActivity.class);
            startActivity(intent);
            finish();
        }

        _firstPin.setOnPinFinishedListener(new OnPinFinishedListener()
        {
            @Override
            public void pinEntered(String pin)
            {
                _secondPin.requestFocus();
            }
        });
    }

    public void savePin(String pin)
    {
        if (pin.equals(_firstPin.getPin()))
        {
            PinStorage storage = new PinStorage();
            if (storage.setPin(this, pin))
            {
                // Go to main page
                Toast.makeText(this, "Main", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(
                        this,
                        "Pin was unable to be saved. Please close the app and try again.",
                        Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(
                    this,
                    "Pins do not match.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
