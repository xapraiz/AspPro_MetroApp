package aspectosprofesionales.metroapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;


public class MainActivity extends Activity {

    List<Estation> estations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast t1=Toast.makeText(getApplicationContext(),"Inicializando",Toast.LENGTH_SHORT);
        t1.show();

        try {
            XMLPullParserHandler parser= new XMLPullParserHandler();
            estations=parser.parse(getAssets().open("metroBilbao.xml"));

        }catch (IOException e){
            e.printStackTrace();
        }

        Toast t2=Toast.makeText(getApplicationContext(),"Número de estaciones: " + estations.size(),Toast.LENGTH_SHORT);
        t2.show();

        final Intent i=new Intent(this, SalirAhora.class);
        final Button bAhora = (Button) findViewById(R.id.Bahora);
        bAhora.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(i);
            }
        });

        final Intent i2 = new Intent(this, Planificar.class);
        final Button bPlanificar = (Button) findViewById(R.id.Bplanificar);
        bPlanificar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(i2);

            }
        });

        final Intent i3 = new Intent(this, LineasMetro.class);
        final Button bMapa = (Button) findViewById(R.id.Bmapa);
        bMapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(i3);

            }
        });

        final Button bSalir = (Button) findViewById(R.id.Bsalir);
        bMapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //destroy
                android.os.Process.killProcess(android.os.Process.myPid());

            }
        });


    }

    public void onDestroy(){
        super.onDestroy();

    }
}
