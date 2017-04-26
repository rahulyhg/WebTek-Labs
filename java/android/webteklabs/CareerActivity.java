package android.webteklabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CareerActivity extends AppCompatActivity {

    TextView ctv;
    Button crbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career);

        crbt=(Button)findViewById(R.id.cbt);
        ctv=(TextView)findViewById(R.id.ctxt);

        crbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cai = new Intent(CareerActivity.this,CareerForm.class);
                startActivity(cai);
            }
        });

        ctv.setText(Html.fromHtml("<h1>CURRENT JOB OPENINGS</h1><br><br>"+
                "<h4>Client Servicing Executive</h4><br>" +
                "Experience: 1-3 years<br>" +
                "Location: Kolkata<br>" +
                "<br>" +
                "<h4>Magento Developer </h4><br>" +
                "Experience: Min. 3 years<br>" +
                "Location: Kolkata<br>" +
                "<br>" +
                "<h4>Business Development Manager <br>" +
                "(Client Acquisition) Skill Development and Trainings </h4><br>" +
                "Experience: Min. 2 years<br>" +
                "Location: Kolkata, Delhi, Hyderabad<br>" +
                "<br>" +
                "<h4>Business Development Manager <br>" +
                "(Client Acquisition) Digital Marketing </h4><br>" +
                "Experience: Min. 3 years<br>" +
                "Location: Kolkata, Delhi, Hyderabad<br>" +
                "<br>" +
                "<h4>Academic Counsellor cum Telecaller </h4><br>" +
                "Experience: 1-3 years<br>" +
                "Location: Kolkata, Delhi, Hyderabad, Chandigarh<br>" +
                "<br>" +
                "<h4>Java Trainer </h4><br>" +
                "Experience: Min. 1 year <br>" +
                "Location: Kolkata, Hyderabad"));
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
            Intent i= new Intent(CareerActivity.this,HomeActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
