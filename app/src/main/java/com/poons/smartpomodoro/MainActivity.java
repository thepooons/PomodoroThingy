package com.poons.smartpomodoro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // declarations
    TextView timer4pomo;
    SeekBar timeDuration;
    TextView timeDurationText;
    Button okButton;
    int prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declarations
        prog = 25;
        timer4pomo =  findViewById(R.id.time4pomo);
        timer4pomo.setText("⏰ set time duration for pomodoro");

        timeDuration = findViewById(R.id.timeDuration);
        timeDuration.setMax(60);
        timeDuration.setProgress(5);

        timeDurationText = findViewById(R.id.timeDurationText);
        timeDurationText.setText("" + prog);

        timeDuration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                prog = progress;
                timeDurationText.setText("" + prog);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        okButton = findViewById(R.id.button1);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity(prog);
            }
        });
    }

    public void openNewActivity(int prog) {
        Intent intent = new Intent(this, PomoTimerActivity.class);
        intent.putExtra("prog", prog);
        startActivity(intent);
    }
}
