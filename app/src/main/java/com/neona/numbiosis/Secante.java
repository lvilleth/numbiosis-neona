package com.neona.numbiosis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;

public class Secante extends AppCompatActivity implements  View.OnClickListener {
    double raiz;
    GraphHandler handler;
    EditText função , x0,x1,tol,n;
    String funçãoS,x0S,x1S,tolS,nS;//variaveis para captação dos dados introduzidos pelo usuário
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secante);//tela que estamos usando

        Button btn_calcular_secante = (Button) findViewById(R.id.btn_calcular_secante);//instanciamos o botão da tela
        btn_calcular_secante.setOnClickListener((View.OnClickListener ) this); //colocamos ele pra ser "escutado"


    }

    @Override
    public void onClick(View view) {

        função = (EditText) findViewById(R.id.editText_função_secante); //instanciamos as caixas de texto da tela
        x0 = (EditText) findViewById(R.id.editText_x0_secante);
        x1 = (EditText) findViewById(R.id.editText_x1_secante);
        tol = (EditText) findViewById(R.id.editText_tol_secante);
        n = (EditText) findViewById(R.id.editText_n_secante);

        switch(view.getId()){
            case R.id.btn_calcular_secante://caso o click seja no botão calcular

                GraphView graph2 = (GraphView) findViewById(R.id.graph2); // instanciamos o gráfico

                funçãoS = função.getText().toString();   //capturamos o que foi digitado na caixa de texto da função
                x0S = x0.getText().toString();   //capturamos o que foi digitado na caixa de texto da função
                x1S = x1.getText().toString();   //capturamos o que foi digitado na caixa de texto da função
                tolS = tol.getText().toString();   //capturamos o que foi digitado na caixa de texto da função
                nS = n.getText().toString();

                double x0, x1, tol;
                int n;
                n = Integer.parseInt(nS);
                x0 = Double.parseDouble(x0S);
                x1 = Double.parseDouble(x1S);
                tol = Double.parseDouble(tolS);


                raiz = Raiz.secante(funçãoS,x0,x1,tol,n);

                handler = new GraphHandler(funçãoS, graph2);
                handler.initSerieFuncao();
                handler.initSerieRaizes();
                handler.initSerieRaizFinal(raiz);
                handler.initGraph();

        }
    }
}
