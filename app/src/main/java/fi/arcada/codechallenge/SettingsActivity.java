package fi.arcada.codechallenge;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    
    private EditText usernameEditText;
    private Switch darkModeSwitch;
    private Button saveButton;
    private SharedPreferences sharedPreferences;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        
        usernameEditText = findViewById(R.id.usernameEditText);
        darkModeSwitch = findViewById(R.id.darkModeSwitch);
        saveButton = findViewById(R.id.saveButton);
        
        sharedPreferences = getSharedPreferences("AppSettings", MODE_PRIVATE);
        
        String savedUsername = sharedPreferences.getString("username", "");
        boolean isDarkMode = sharedPreferences.getBoolean("darkMode", false);
        
        usernameEditText.setText(savedUsername);
        darkModeSwitch.setChecked(isDarkMode);
        
        saveButton.setOnClickListener(v -> saveSettings());
    }
    
    private void saveSettings() {
        String username = usernameEditText.getText().toString();
        boolean isDarkMode = darkModeSwitch.isChecked();
        
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putBoolean("darkMode", isDarkMode);
        editor.apply();
        
        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
        finish(); 
    }
} 