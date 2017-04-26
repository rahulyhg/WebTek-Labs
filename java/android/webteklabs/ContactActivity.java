package android.webteklabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    TextView cotv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        cotv=(TextView)findViewById(R.id.cotxt);
        cotv.setText(Html.fromHtml("<h1>Training Centres of WebTek Labs Pvt. Ltd.</h1><br>" +
                "<b>Delhi Training Centre:</b><br>" +
                "GN-12, 1st Floor, Shivaji Enclave, Rajouri Garden, <br>" +
                "New Delhi 110027, India <br>" +
                "Ph No.: +91-11-45001200/201, +91 8826008972 <br><br>" +
                "<b>Hyderabad Centre: </b><br>" +
                "3-6-198, Vasavi Sreemukh, <br>" +
                "Beside KFC, Himayat Nagar, <br>" +
                "Hyderabad-500029<br>" +
                "Contact - 18002124700<br>" +
                "<br>" +
                "<b>Kolkata Training Centre:</b><br>" +
                "4, Lee Road, Vaibhav Building, 5th Floor, <br>" +
                "Near Rabindra Sadan Metro Station, <br>" +
                "Kolkata 700 020, West Bengal. <br>" +
                "Contact: +91-033-30515400, 9007056569, 8420074893 <br><br>" +
                "BD-44, Sector-1, Salt Lake, Near Tank Number-4, <br>" +
                "Kolkata 700-064, India <br>" +
                "Contact: +91-33-65011271, 9831829641, 9007766321 <br><br><br>" +
                "<h1>Corporate Offices of WebTek Labs Pvt. Ltd.</h1><br>" +
                "<b>Delhi Branch : </b><br>" +
                "GN-12, 1st Floor, Shivaji Enclave, Rajouri Garden, <br>" +
                "New Delhi 110027, India <br>" +
                "Ph No.: +91-11- 45001 200/201, +918826008972 <br><br>" +
                "<b>Kolkata Branch: </b><br>" +
                "4, Lee Road, Vaibhav Building, 5th Floor, <br>" +
                "Near Rabindra Sadan Metro Station, <br>" +
                "Kolkata 700 020, West Bengal. <br>" +
                "Contact: +91-033-30515400, 9007056569, 8420074893 <br><br>" +
                "<b>Mumbai Branch: </b><br>" +
                "Office No. 922 <br>" +
                "9th Floor, P. J. Tower Building, Dalal Street <br>" +
                "Mumbai-400001<br>" +
                "Contact - 9619427174<br>" +
                "<br>" +
                "<b>Dubai-U.A.E Branch:</b><br>" +
                "401 SHK, Rashid Bldg R114,<br>" +
                "Near Shangr-La Hotel, <br>" +
                "SHK. Zayed Road <br>" +
                "P.O. Box 30301"));
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
            Intent i= new Intent(ContactActivity.this,HomeActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
