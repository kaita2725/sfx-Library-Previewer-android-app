package id.ac.umn.uts_35715;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnProfile, btnLibrary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        btnProfile = (Button) findViewById(R.id.Profile);
        btnLibrary = (Button) findViewById(R.id.Library);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentProfile = new Intent(MainActivity.this,
                        ProfileActivity.class);
                startActivityForResult(intentProfile, 1);
            }
        });

        btnLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(MainActivity.this,
                        LoginActivity.class);
                startActivityForResult(intentLogin, 1);
            }
        });
    }
}