package aspectosprofesionales.metroapp;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by xabier on 6/04/15.
 */
public class SalirAhora extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salir_ahora);


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}