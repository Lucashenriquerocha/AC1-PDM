package com.example.ac1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgQuestion1, rgQuestion2, rgQuestion3;
    private TextView tvResultado;
    private TextView tvFb1;
    private TextView tvFb2;
    private TextView tvFb3;
    private Button botValidar, botReset;

    private int[] respostasCorretas = {0, 1, 2};
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgQuestion1 = findViewById(R.id.rgQuestion1);
        rgQuestion2 = findViewById(R.id.rgQuestion2);
        rgQuestion3 = findViewById(R.id.rgQuestion3);
        tvResultado = findViewById(R.id.tvResultado);
        tvFb1 = findViewById(R.id.tvFb1);
        tvFb2 = findViewById(R.id.tvFb2);
        tvFb3 = findViewById(R.id.tvFb3);
        botValidar = findViewById(R.id.botValidar);
        botReset = findViewById(R.id.botReset);

        botValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarRespostas();
            }
        });

        botReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetQuiz();
            }
        });
    }

    private void validarRespostas() {
        score = 0;

        // if das respostas
        if (rgQuestion1.getCheckedRadioButtonId() != -1) {
            int selectedAnswer1 = rgQuestion1.indexOfChild(findViewById(rgQuestion1.getCheckedRadioButtonId()));
            if (selectedAnswer1 == respostasCorretas[0]) {
                score++;
                tvFb1.setText("Resposta Correta!");
            }
            else{
                tvFb1.setText("A Resposta Correta era Neil Armstrong!");
            }
        }

        if (rgQuestion2.getCheckedRadioButtonId() != -1) {
            int selectedAnswer2 = rgQuestion2.indexOfChild(findViewById(rgQuestion2.getCheckedRadioButtonId()));
            if (selectedAnswer2 == respostasCorretas[1]) {
                score++;
                tvFb2.setText("Resposta Correta!");
            }
            else {
                tvFb2.setText("A Resposta Correta era Monte Everest!");
            }
        }

        if (rgQuestion3.getCheckedRadioButtonId() != -1) {
            int selectedAnswer3 = rgQuestion3.indexOfChild(findViewById(rgQuestion3.getCheckedRadioButtonId()));
            if (selectedAnswer3 == respostasCorretas[2]) {
                score++;
                tvFb3.setText("Resposta Correta!");
            }
            else{
                tvFb3.setText("A Resposta Correta era 100 ºC!");
            }
        }

        tvResultado.setText(score + "/3 perguntas.");
    }

    private void resetQuiz() {
        rgQuestion1.clearCheck();
        rgQuestion2.clearCheck();
        rgQuestion3.clearCheck();
        tvResultado.setText("");
        tvFb1.setText("");
        tvFb2.setText("");
        tvFb3.setText("");
        score = 0;
    }
}
