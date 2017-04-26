package android.webteklabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    TextView atv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        atv=(TextView)findViewById(R.id.atxt);
        atv.setText(Html.fromHtml("WebTek Labs Pvt. Ltd. is recognized as a leading IT solution providing organization with a dynamic and fast growing team of diversely talented individuals. Incorporated in 2001, in our aim to provide the best talent, we initially started with Recruitment & Staffing services. We paralleled this by providing knowledge and skill development certification training programs. WebTek Certified Tester (WCT) Program that aims to provide IT companies trained software Testers has reached soaring heights of recognition over the years. Few years later after its inception, WebTek Labs added Software development & testing services to the portfolio.<br>" +
                "<br>" +
                "Having partnered and worked with some of the leading names across Education, IT, ITES, Banking, Insurance, Aviation, Retail, Healthcare, Hospitality, Media, Manufacturing and FMCG sectors, WebTek Labs has explored business opportunities in software solutions with the Government, Corporate and Institutes.<br>" +
                "<br>" +
                "With over a decade of experience we create and deliver high-impact solutions, enabling our clients to achieve their business goals and enhance their competitiveness. In our pursuit of excellence, WebTek's Research & Development team consistently innovates to provide up-to-date solutions keeping in pace with changing times. Our mission is for businesses to leverage the internet and mobility to work smarter and grow faster. We work as your outsourcing and consulting partner. Our business verticals are:<br>" +
                "<br>" +
                "<b>    > Recruitment & Staffing</b><br><br>" +
                "<b>    > Software Development and Testing Services</b><br><br>" +
                "<b>    > Digital Marketing</b><br><br>" +
                "<b>    > Enterprise Mobility</b><br><br>" +
                "<b>    > Certifications & Trainings for Career Management</b><br><br>" +
                "<b>    > Software solutions</b><br><br>" +
                "<br>" +
                "<b>OUR VISION</b> is to lead in the creation and delivery of innovative solutions and services that enable our clients to win in the changing world of work.<br>" +
                "<br>" +
                "<b>OUR TEAM</b> has expertise ranging from design to development, training to placements and solutions to implementaion. We combine this knowledge with proactive thinking and strategic planning to approach new challenges with your overall business objectives in mind. WebTek Lab's management team brings together a wealth of experience in both technological and organizational development that is critical in helping our customers achieve their goals."));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent i= new Intent(AboutActivity.this,HomeActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
