package aspectosprofesionales.metroapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by xabier on 6/04/15.
 */
public class LineasMetro extends Activity{


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lineas_metro);


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
