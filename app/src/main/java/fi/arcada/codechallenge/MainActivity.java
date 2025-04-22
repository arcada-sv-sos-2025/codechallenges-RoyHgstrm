package fi.arcada.codechallenge;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView helloTextView;
    private Button calculateButton;
    private Button calculateModeButton;
    private Button settingsButton;
    private ArrayList<Double> numbers;
    private SharedPreferences sharedPreferences;
    private int appCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("AppCounterPrefs", MODE_PRIVATE);
        appCounter = sharedPreferences.getInt("appCounter", 0);
        appCounter++; 
        
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("appCounter", appCounter);
        editor.apply();

        helloTextView = findViewById(R.id.hello);
        calculateButton = findViewById(R.id.calculateButton);
        calculateModeButton = findViewById(R.id.calculateModeButton);
        settingsButton = findViewById(R.id.settingsButton);
        
        numbers = new ArrayList<>();
        numbers.add(1.0);
        numbers.add(2.0);
        numbers.add(3.0);
        numbers.add(4.0);
        numbers.add(5.0);

        numbers.add(2.0);
        numbers.add(2.0);

        calculateButton.setOnClickListener(v -> calculate());
        calculateModeButton.setOnClickListener(v -> calculateMode());
        settingsButton.setOnClickListener(v -> openSettings());
        
        helloTextView.setText(String.format("App opened %d times", appCounter));
    }

    private void calculate() {
        double mean = Statistics.calcMean(numbers);
        helloTextView.setText(String.format("Mean: %.2f", mean));
    }
    
    private void calculateMode() {
        double mode = Statistics.getMode(numbers);
        helloTextView.setText(String.format("Mode: %.2f", mode));
    }
    
    private void openSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}