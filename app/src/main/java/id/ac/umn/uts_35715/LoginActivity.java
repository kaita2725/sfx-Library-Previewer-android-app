package id.ac.umn.uts_35715;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity{
    private EditText nameInput;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setTitle("LOGIN");
        nameInput = (EditText) findViewById(R.id.Name);
        btnNext = (Button) findViewById(R.id.btnNext);
        String s = nameInput.getText().toString();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(nameInput.getText())){
                    nameInput.setError("Harap Di isi");
                } else {
                    //give warning
                    continueToLibrary();
                }
            }
        });
    }

    public String continueToLibrary() {
        //redirect to Library Activity
        Intent intentLogin = new Intent(LoginActivity.this, LibraryActivity.class);
        String s = nameInput.getText().toString();
        intentLogin.putExtra("nameInput", s);
        startActivity(intentLogin);
        return null;
    }

}
