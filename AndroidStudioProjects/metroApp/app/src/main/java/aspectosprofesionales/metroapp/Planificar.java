package aspectosprofesionales.metroapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by xabier on 6/04/15.
 */
public class Planificar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planificar_viaje);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
