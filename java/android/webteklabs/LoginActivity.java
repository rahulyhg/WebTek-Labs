package android.webteklabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button rsbt,cebt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        rsbt=(Button)findViewById(R.id.reg);
        rsbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rsi = new Intent(LoginActivity.this,RSActivity.class);
                startActivity(rsi);
            }
        });

        cebt=(Button)findViewById(R.id.career);
        cebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cei = new Intent(LoginActivity.this,CEActivity.class);
                startActivity(cei);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent i= new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
