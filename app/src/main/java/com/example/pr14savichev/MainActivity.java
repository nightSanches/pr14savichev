package com.example.pr14savichev;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.SuggestionRangeSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AlertDialog;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Surname;
    TextView TextStepTwo;
    RadioGroup NumberofLessons;
    CheckBox[] Muscles;
    EditText Height;
    EditText Weight;
    RadioGroup Gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void AlertDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("OK", (dialog, which) -> dialog.cancel());

        AlertDialog alter = builder.create();
        alter.show();
    }

    public void GoToReg(View view){
        setContentView(R.layout.step_1);
        Name = findViewById(R.id.Name);
        Surname = findViewById(R.id.Surname);
    }
    public void GoToTwo(View view){
        String Name = this.Name.getText().toString();
        String Surname = this.Surname.getText().toString();

        if(Name.isEmpty() || Surname.isEmpty()){
            AlertDialog("Ошибка!", "Заполните все данные");
            return;
        }

        setContentView(R.layout.step_2);
        TextStepTwo = findViewById(R.id.TextStepTwo);
        NumberofLessons = findViewById(R.id.NumberofLessons);
    }
    public void GoToThree(View view){
        TextStepTwo.setText("Отлично, "+ Name.getText().toString() +"\nКак часто вы готовы заниматься спортом?");

        if(NumberofLessons.getCheckedRadioButtonId() == -1){
            AlertDialog("Ошибка!", "Заполните все данные");
            return;
        }

        setContentView(R.layout.step_3);

        Muscles = new CheckBox[4];
        Muscles[0] = findViewById(R.id.Back);
        Muscles[1] = findViewById(R.id.Biceps);
        Muscles[2] = findViewById(R.id.Triceps);
        Muscles[3] = findViewById(R.id.Calf);
    }
    public void GoToFour(View view){
        if(!Muscles[0].isChecked() & !Muscles[1].isChecked() & !Muscles[2].isChecked() & !Muscles[3].isChecked())
        {
            AlertDialog("Ошибка!", "Необходимо выбрать минимум одну позицию.");
            return;
        }

        setContentView(R.layout.step_4);

        Weight = findViewById(R.id.Weight);
        Height = findViewById(R.id.Height);
    }
    public void GoToFive(View view){
        String Weight = this.Weight.getText().toString();
        String Height = this.Height.getText().toString();

        if(Weight.isEmpty() || Height.isEmpty())
        {
            AlertDialog("Ошибка!", "Необходимо заполнить все данные.");
            return;
        }

        setContentView(R.layout.step_5);
        Gender = findViewById(R.id.Gender);
    }
    public void GoToMain(View view){
        setContentView(R.layout.main);
        if(Gender.getCheckedRadioButtonId() == -1){
            AlertDialog("Ошибка!", "Необходимо указать пол.");
            return;
        }
        setContentView(R.layout.main);

        if(!Muscles[0].isChecked()){
            FrameLayout fl = findViewById(R.id.FrameBack);
            fl.setVisibility(View.GONE);
        }

        if(!Muscles[1].isChecked()){
            FrameLayout fl = findViewById(R.id.FrameBiceps);
            fl.setVisibility(View.GONE);
        }

        if(!Muscles[2].isChecked()){
            FrameLayout fl = findViewById(R.id.FrameTriceps);
            fl.setVisibility(View.GONE);
        }

        if(!Muscles[3].isChecked()){
            FrameLayout fl = findViewById(R.id.FrameCalf);
            fl.setVisibility(View.GONE);
        }
    }

    public void GoToBack(View view){
        String youtubeUrl = "https://youtu.be/6rr4sfFVCNo?si=eK86IRjhKGKq01rD";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl));
        startActivity(browserIntent);
    }
    public void GoToTriceps(View view){
        String youtubeUrl = "https://youtu.be/UhAt45tuirk?si=-xmXwnbNe57Rlv7c";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl));
        startActivity(browserIntent);
    }
    public void GoToBiceps(View view){
        String youtubeUrl = "https://youtu.be/VwUYKfmXVTU?si=z-tlD5Y_nGLsW91r";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl));
        startActivity(browserIntent);
    }
    public void GoToCalf(View view){
        String youtubeUrl = "https://youtu.be/keZS8eEoBAs?si=1c-uGSLgvSKRNLRo";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl));
        startActivity(browserIntent);
    }
}