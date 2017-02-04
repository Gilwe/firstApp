package com.example.gilad.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
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


public class MainActivity extends BaseActivity implements GestureDetector.OnDoubleTapListener,
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

        Intent intent;

        if (message.equals("Foofy"))
        {
            intent = new Intent(this, DisplayMessageActivity.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
        else if (message.equals("Video"))
        {
            intent = new Intent(this, ListActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this.getApplicationContext(),"Not Foofy",Toast.LENGTH_LONG).show();

            Button b = (Button) findViewById(R.id.btnSend);
            b.setText(button_msg);
        }
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
