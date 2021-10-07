package id.ac.umn.uts_35715;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class mediaPlayer extends AppCompatActivity {
    private TextView sfxName, desc;
    private Button btnploy;
    private static MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);

        Intent libraryIntent = getIntent();
        Bundle mediaView = getIntent().getExtras();
        String s = mediaView.getString("name");
        setTitle(s);
        s = libraryIntent.getStringExtra("name");

        sfxName = (TextView) findViewById(R.id.Title);
        desc = (TextView) findViewById(R.id.desc);

        sfxName.setText(mediaView.getString("name"));
        desc.setText(mediaView.getString("desc"));

        btnploy = (Button) findViewById(R.id.Play);

        btnploy.setOnClickListener(new View.OnClickListener() {
            final Integer ploysfx = getIntent().getIntExtra("sfx", 0);
            @Override
            public void onClick(View view) {
                mp = MediaPlayer.create(getApplicationContext(), ploysfx);
                mp.start();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(mp != null) {
            mp.release();
            mp = null;
        }
    }

}
