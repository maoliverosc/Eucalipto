package co.comss.eucalipto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    /* vars */
    private ImageButton btnNodoUno, btnNodoDos, btnNodoTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // link objects
        btnNodoUno = (ImageButton) findViewById(R.id.btnNodoUno);
        btnNodoDos = (ImageButton) findViewById(R.id.btnNodoDos);
        btnNodoTres = (ImageButton) findViewById(R.id.btnNodoTres);

        // Button Node One
        btnNodoUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NodoUnoActivity.class));
            }
        });

        // Button Node Two
        btnNodoDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NodoDosActivity.class));

            }
        });

        // Button Node Three
        btnNodoTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NodoTresActivity.class));
            }
        });

        // end methods..
    }

    /* menu options */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // Acciones en items menu seleccionados.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuAboutUs) {

        }

        if (item.getItemId() == R.id.menuOpciones) {

        }
        if (item.getItemId() == R.id.menuSalir) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}

/* end code */