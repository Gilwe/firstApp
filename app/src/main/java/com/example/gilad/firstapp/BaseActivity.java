package com.example.gilad.firstapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

/**
 * Created by Gilad on 03/02/2017.
 */

public class BaseActivity extends AppCompatActivity {
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
}
