package id.ac.umn.uts_35715;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Integer> sfx = new ArrayList<>();
    private ArrayList<String> sfxName = new ArrayList<>();
    private ArrayList<String> desc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_library);

        Intent loginIntent = getIntent();
        if(loginIntent.hasExtra("nameInput"))
        {
            Bundle openhere = getIntent().getExtras();
            String s = openhere.getString("nameInput");
            setTitle(s);
            s = loginIntent.getStringExtra("nameInput");
            Toast.makeText(this, "Selamat datang, " + s, Toast.LENGTH_LONG).show();
        }
        else{
            setTitle("Library");
        }

        content();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        Adapter adapter = new Adapter(this, sfx, sfxName, desc);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.Main)
        {
            Intent intentMain = new Intent(LibraryActivity.this,
                    MainActivity.class);
            startActivityForResult(intentMain, 1);
        }
        else if(item.getItemId() == R.id.Profile)
        {
            Intent intentProfile = new Intent(LibraryActivity.this,
                    ProfileActivity.class);
            startActivityForResult(intentProfile, 1);
        }
        else
            {
                return super.onOptionsItemSelected(item);
            }
        return true;
    }

    public void content()
    {
        sfx.add(R.raw.cherry_brown_key);
        sfxName.add("cherry brown key");
        desc.add("Keyboard ASMR");

        sfx.add(R.raw.cherry_red_key);
        sfxName.add("cherry red key");
        desc.add("Keyboard ASMR");

        sfx.add(R.raw.mouse_clicks);
        sfxName.add("just ordinary mouse clicks");
        desc.add("mouse clicks ASMR");

        sfx.add(R.raw.gameboy_advance_sp_boot);
        sfxName.add("gameboy advanced SP boot");
        desc.add("retro boot");

        sfx.add(R.raw.rubik);
        sfxName.add("Rubik shuffle");
        desc.add("Rubik scramble sound");
    }
}
