package com.example.gilad.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnDoubleTapListener,
                                                               GestureDetector.OnGestureListener{
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public final static String button_msg = "Sending...";

    private TextView myMessage;
    private GestureDetector myGes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Links this java file to the XML file
        setContentView(R.layout.activity_main);
        this.myMessage = (TextView) findViewById(R.id.textView3);
        this.myGes = new GestureDetector(this,this);
        this.myGes.setOnDoubleTapListener(this);

    }

    public void sendMessage(View view)
    {

        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();

        if (message.equals("Foofy"))
        {
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this.getApplicationContext(),"Not Foofy",Toast.LENGTH_LONG).show();

            Button b = (Button) findViewById(R.id.btnSend);
            b.setText(button_msg);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        LinearLayout main_view = (LinearLayout) findViewById(R.id.main_view);

        switch (item.getItemId())
        {
            case R.id.menu_red:
                {
                    if (switchChecked(item))
                        main_view.setBackgroundColor(Color.RED);
                    return true;
                }

            case R.id.menu_blue:
            {
                if (switchChecked(item))
                    main_view.setBackgroundColor(Color.BLUE);
                return true;
            }

            case R.id.menu_green:
            {
                if (switchChecked(item))
                    main_view.setBackgroundColor(Color.GREEN);
                return true;
            }

            default: return super.onOptionsItemSelected(item);
        }
    }

    private boolean switchChecked(MenuItem item)
    {
        if (item.isChecked())
            item.setChecked(false);
        else
            item.setChecked(true);

        return item.isChecked();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.myGes.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        this.myMessage.setText("onSingleTapConfirmed");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        this.myMessage.setText("onDoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        this.myMessage.setText("onDoubleTapEvent");
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        this.myMessage.setText("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        this.myMessage.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        this.myMessage.setText("onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        this.myMessage.setText("onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        this.myMessage.setText("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        this.myMessage.setText("onFling");
        return false;
    }
}
