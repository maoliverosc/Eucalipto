package co.comss.eucalipto;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

public class NodoTresActivity extends AppCompatActivity {
    /* vars */
    private ActionBar actionBar;
    private GraphView TempGraph, PlagasGraph, MalezaGraph, HumedadGraph;
    /* end vars */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nodo_tres);

        TempGraph = (GraphView) findViewById(R.id.TempGraph);
        HumedadGraph = (GraphView) findViewById(R.id.HumedadGraph);
        PlagasGraph = (GraphView) findViewById(R.id.PlagasGraph);
        MalezaGraph = (GraphView) findViewById(R.id.MalezaGraph);

        // Action Bar
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Temp Graph
        LineGraphSeries<DataPoint> TempSeries = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 2),
                new DataPoint(2, 3),
                new DataPoint(3, 4),
                new DataPoint(4, 3),
                new DataPoint(5, 3),
                new DataPoint(6, 2),
                new DataPoint(7, 1),
                new DataPoint(8, 0)
        });
        TempGraph.addSeries(TempSeries);

        // Humedad Graph
        PointsGraphSeries<DataPoint> humedadSeries = new PointsGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 1),
                new DataPoint(2, 2),
                new DataPoint(3, 2),
                new DataPoint(4, 2),
                new DataPoint(5, 2),
                new DataPoint(6, 1),
                new DataPoint(7, 1),
                new DataPoint(8, 1)
        });
        HumedadGraph.addSeries(humedadSeries);

        // Plagas Graph
        BarGraphSeries<DataPoint> PlagasBars = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 2),
                new DataPoint(2, 2),
                new DataPoint(3, 2)
        });
        PlagasGraph.addSeries(PlagasBars);

        // styling
        PlagasBars.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        PlagasBars.setSpacing(50);
        // draw values on top
        PlagasBars.setDrawValuesOnTop(true);
        PlagasBars.setValuesOnTopColor(Color.RED);
        //series.setValuesOnTopSize(50);

        // Maleza Graph
        BarGraphSeries<DataPoint> MalezaBars = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 3),
                new DataPoint(2, 0),
                new DataPoint(3, 3)
        });
        MalezaGraph.addSeries(MalezaBars);

        MalezaBars.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        MalezaBars.setSpacing(50);
        MalezaBars.setDrawValuesOnTop(true);
        MalezaBars.setValuesOnTopColor(Color.RED);

        // end
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}

/* end code */