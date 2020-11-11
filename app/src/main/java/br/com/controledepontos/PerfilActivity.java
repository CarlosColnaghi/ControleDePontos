package br.com.controledepontos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        ImageView imgVoltar = findViewById(R.id.imgVoltar);
        imgVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        
        BarChart barGrafico = findViewById(R.id.barGrafico);
        ArrayList<BarEntry> entradas = new ArrayList<>();
        entradas.add(new BarEntry(3f, 0));
        entradas.add(new BarEntry(3f, 1));
        BarDataSet bardataset = new BarDataSet(entradas, "Cells");
        bardataset.setBarSpacePercent(80f);
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Extras");
        labels.add("Normais");
        bardataset.setValueTextColor(R.color.fundo);
        bardataset.setValueTextSize(13);
        barGrafico.getAxisLeft().setDrawGridLines(false);
        barGrafico.getXAxis().setDrawGridLines(false);
        barGrafico.getAxisRight().setDrawGridLines(false);
        barGrafico.getAxisRight().setDrawAxisLine(false);
        barGrafico.getAxisLeft().setDrawAxisLine(false);
        barGrafico.getXAxis().setTextSize(13);
        barGrafico.getXAxis().setTextColor(R.color.fundo);
        barGrafico.getAxisLeft().setDrawLabels(false);
        barGrafico.getAxisRight().setDrawLabels(false);
        barGrafico.setDescription("");
        barGrafico.getLegend().setEnabled(false);
        BarData dado = new BarData(labels, bardataset);
        barGrafico.setData(dado);
        bardataset.setColors(Collections.singletonList(R.color.fundo));
        barGrafico.animateY(2500);
    }
}