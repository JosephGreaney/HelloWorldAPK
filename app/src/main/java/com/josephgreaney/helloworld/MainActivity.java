package com.josephgreaney.helloworld;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //buttonCounter is used to count how many times the button has been pressed
    private int buttonCounter = 0;
    //activityMessage is used to pass a string to txtValue to show in the activity
    private String activityMessage = "Press the button...";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //txtValue is used to set the text in the main activity
        final TextView txtValue = (TextView) findViewById(R.id.screenText);
        txtValue.setText(activityMessage);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonCounter++;
                if(buttonCounter < 5) {
                    activityMessage = "You have pressed this button " + buttonCounter + " times now.";
                    /*Snackbar.make(view, "You have pressed this button " + buttonCounter + " times now.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();*/
                }
                else if(buttonCounter < 10) {
                    activityMessage = "Please stop pressing this button it doesn't do anything... " + buttonCounter;
                    /*Snackbar.make(view, "Please stop pressing this button it doesn't do anything... " + buttonCounter, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();*/
                }
                else if(buttonCounter < 30){
                    activityMessage = "You're not going to get a high score... " + buttonCounter;
                    /*Snackbar.make(view, "You're not going to get a high score... " + buttonCounter, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();*/
                }
                else {
                    activityMessage = "Congratulations! New High Score: " + buttonCounter;
                    /*Snackbar.make(view, "Congratulations! New High Score: " + buttonCounter, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();*/
                    setActivityBackgroundColor(0xFF009999);
                }
                txtValue.setText(activityMessage);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Used to change the background colour of an activity
     * @param color
     */
    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }
}
