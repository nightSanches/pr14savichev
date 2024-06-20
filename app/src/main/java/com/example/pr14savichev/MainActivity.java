package com.example.pr14savichev;

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
        // Создает и отображает диалоговое окно с заданным заголовком и сообщением.
        // Диалоговое окно не может быть отменено и содержит кнопку “OK”, которая закрывает диалог.
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
    }
}