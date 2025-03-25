package fi.arcada.codechallenge;

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
    private ArrayList<Double> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloTextView = findViewById(R.id.hello);
        calculateButton = findViewById(R.id.calculateButton);
        
        numbers = new ArrayList<>();
        numbers.add(1.0);
        numbers.add(2.0);
        numbers.add(3.0);
        numbers.add(4.0);
        numbers.add(5.0);

        calculateButton.setOnClickListener(v -> calculate());
    }

    private void calculate() {
        double mean = Statistics.calcMean(numbers);
        helloTextView.setText(String.format("Mean: %.2f", mean));
    }
}