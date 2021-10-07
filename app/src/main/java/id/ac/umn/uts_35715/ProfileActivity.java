package id.ac.umn.uts_35715;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private TextView Ref1, Ref2, Ref3, Ref4, Ref5, Ref6, Ref7, Ref8, Ref9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Ref1 = (TextView) findViewById(R.id.Ref1);
        Ref2 = (TextView) findViewById(R.id.Ref2);
        Ref3 = (TextView) findViewById(R.id.Ref3);
        Ref4 = (TextView) findViewById(R.id.Ref4);
        Ref5 = (TextView) findViewById(R.id.Ref5);
        Ref6 = (TextView) findViewById(R.id.Ref6);
        Ref7 = (TextView) findViewById(R.id.Ref7);
        Ref8 = (TextView) findViewById(R.id.Ref8);
        Ref9 = (TextView) findViewById(R.id.Ref9);

        Ref1.setMovementMethod(LinkMovementMethod.getInstance());
        Ref2.setMovementMethod(LinkMovementMethod.getInstance());
        Ref3.setMovementMethod(LinkMovementMethod.getInstance());
        Ref4.setMovementMethod(LinkMovementMethod.getInstance());
        Ref5.setMovementMethod(LinkMovementMethod.getInstance());
        Ref6.setMovementMethod(LinkMovementMethod.getInstance());
        Ref7.setMovementMethod(LinkMovementMethod.getInstance());
        Ref8.setMovementMethod(LinkMovementMethod.getInstance());
        Ref9.setMovementMethod(LinkMovementMethod.getInstance());


    }
}
