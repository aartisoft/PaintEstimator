package edu.orangecoastcollege.cs273.phuynh101.paintestimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Display Help Activity
 */
public class HelpActivity extends AppCompatActivity {

    private TextView mGallonsTextView;

    /**
     * Create the UI
     * @param savedInstanceState settings from the previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        mGallonsTextView = (TextView) findViewById(R.id.gallonsTextView);
        mGallonsTextView.setText(getString(R.string.estimated_paint_required) +
                String.valueOf(getIntent().getExtras().getFloat("gallons")) + " gallons");
    }
}
