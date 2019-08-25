package com.example.voicehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView outputText;
    private EditText inputText;
    private Button sendButton;
    //Голос:
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = findViewById(R.id.TextOutput);
        inputText = findViewById(R.id.TextInput);
        sendButton = findViewById(R.id.SendButton);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR)
                    tts.setLanguage(new Locale("en"));
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputString = inputText.getText().toString();
                inputText.setText("");
                outputText.append("\n>>" + inputString);
                String answer = AI.getAnswer(inputString);
                tts.speak(answer, TextToSpeech.QUEUE_FLUSH, null, null);
                outputText.append("\n<<" + answer);
            }
        });
    }
}
