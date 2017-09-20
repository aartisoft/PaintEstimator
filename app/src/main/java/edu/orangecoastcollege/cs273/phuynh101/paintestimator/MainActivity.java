package edu.orangecoastcollege.cs273.phuynh101.paintestimator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Connections from Controller to View
    private EditText mLengthEditText;
    private EditText mWidthEditText;
    private EditText mHeightEditText;

    private EditText mDoorsEditText;
    private EditText mWindowsEditText;

    private TextView mGallonsTextview;

    //Connections from Controller to Model
    //member variable for the model
    private InteriorRoom mRoom = new InteriorRoom();

    //member variable for SharedPreference;
    private SharedPreferences mPrefs;

    private void loadSharedPreferences()
    {
        mPrefs = getSharedPreferences("edu.orangecoastcollege.cs273.phuynh101.PaintEstimator", MODE_PRIVATE);

        if(mPrefs != null)
        {
            //load all the room information
            mRoom.setDoors(mPrefs.getInt("doors",0));
            mDoorsEditText.setText(String.valueOf(mRoom.getDoors()));

            mRoom.setWindows(mPrefs.getInt("windows", 0));
            mWindowsEditText.setText(String.valueOf(mRoom.getWindows()));

            mRoom.setHeight(mPrefs.getFloat("height", 0.0f));
            mHeightEditText.setText(String.valueOf(mRoom.getHeight()));

            mRoom.setWidth(mPrefs.getFloat("width", 0.0f));
            mWidthEditText.setText(String.valueOf(mRoom.getWidth()));

            mRoom.setLength(mPrefs.getFloat("length", 0.0f));
            mLengthEditText.setText(String.valueOf(mRoom.getLength()));
        }
    }

    private void saveSharedPreferences()
    {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.clear();
        editor.putFloat("length", mRoom.getLength());
        editor.putFloat("width", mRoom.getWidth());
        editor.putFloat("height", mRoom.getHeight());
        editor.putInt("windows", mRoom.getWindows());
        editor.putInt("doors", mRoom.getDoors());
        //Save the changes to the SharedPreferences  file
        editor.commit();

    }
    private void initializeViews()
    {
        mLengthEditText = (EditText) findViewById(R.id.lengthEditText);
        mWidthEditText = (EditText) findViewById(R.id.widthEditText);
        mHeightEditText = (EditText) findViewById(R.id.heightEditText);
        mDoorsEditText = (EditText) findViewById(R.id.doorsEditText);
        mWindowsEditText = (EditText) findViewById(R.id.windowsEditText);
        mGallonsTextview = (TextView) findViewById(R.id.gallonsTextView);

    }

    /**
     * initialize views and load SharedPreferences
     * @param savedInstanceState settings from the previous state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        loadSharedPreferences();
    }

    /**
     * compute gallons
     * @param v the view that triggers the event
     */
    protected  void computeGallons(View v)
    {
        //update the model then calculate
        mRoom.setLength(Float.parseFloat(mLengthEditText.getText().toString()));
        mRoom.setWidth(Float.parseFloat(mWidthEditText.getText().toString()));
        mRoom.setHeight(Float.parseFloat(mHeightEditText.getText().toString()));
        mRoom.setWindows(Integer.parseInt(mWindowsEditText.getText().toString()));
        mRoom.setDoors(Integer.parseInt(mDoorsEditText.getText().toString()));

        mGallonsTextview.setText(getString(R.string.interior_surface_area_text) +
                String.valueOf(mRoom.totalSurfaceArea()) + "\n" +
                getString(R.string.gallons_needed_text) + mRoom.gallonsOfPaintRequired());

        saveSharedPreferences();
    }

    /**
     * go to help activity
     * @param v view that triggers the event
     */
    protected void gotoHelp(View v)
    {
        //Construct an Explicit intent to go to HelpActivity
        //specify where to start and where we are going
        Intent helpIntent = new Intent(this, HelpActivity.class);
        helpIntent.putExtra("gallons", mRoom.gallonsOfPaintRequired());
        startActivity(helpIntent);

    }
}
