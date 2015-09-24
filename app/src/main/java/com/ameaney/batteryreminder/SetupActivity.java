package com.ameaney.batteryreminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SetupActivity extends AppCompatActivity
{
    @Bind(R.id.reminderType)
    protected Spinner _reminderType;

    @Bind(R.id.reminderDestination)
    protected EditText _destination;

    @Bind(R.id.saveButton)
    protected Button _saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        ButterKnife.bind(this);

        String[] types = new String[] { ReminderType.Email.toString(), ReminderType.Phone.toString(), ReminderType.SMS.toString() };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                types);

        _reminderType.setAdapter(adapter);
        _reminderType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                _destination.setHint(parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                Toast.makeText(parent.getContext(), "Invalid result. Please tell me what you just did.", Toast.LENGTH_SHORT).show();
            }
        });

        _saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(v.getContext(), "Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
