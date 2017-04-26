package android.webteklabs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public int imgi = 0;
    ImageView slidingimage;
    public int[] imgid = {R.drawable.img11,R.drawable.img21,R.drawable.img31,R.drawable.img41};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final Handler mHandler = new Handler();
        final Runnable mUpdateResults = new Runnable() {
            public void run() {
                AnimateandSlideShow();
            }
        };
        int delay = 1000; // delay for img_2 sec.
        int period = 2000; // repeat every img_5 sec.

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                mHandler.post(mUpdateResults);
            }
        }, delay, period);
    }

    private void AnimateandSlideShow() {

        slidingimage = (ImageView) findViewById(R.id.ImageView);
        slidingimage.setImageResource(imgid[imgi % imgid.length]);
        imgi++;
        Animation rotateimage = AnimationUtils.loadAnimation(this,
                R.anim.fadein);

        slidingimage.startAnimation(rotateimage);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment=null;

        if (id == R.id.about) {
            Intent ai = new Intent(HomeActivity.this,AboutActivity.class);
            startActivity(ai);
        } else if (id == R.id.enrollment) {
            Intent ei = new Intent(HomeActivity.this,EnrollmentActivity.class);
            startActivity(ei);
        } else if (id == R.id.career) {
            Intent ci = new Intent(HomeActivity.this,CareerActivity.class);
            startActivity(ci);
        } else if (id == R.id.contact) {
            Intent coi = new Intent(HomeActivity.this,ContactActivity.class);
            startActivity(coi);
        } else if (id == R.id.fb) {
            Intent fi=new Intent(Intent.ACTION_VIEW,Uri
                    .parse("https://www.facebook.com/WebTekLabsPvtLtd"));
            startActivity(fi);
        } else if (id == R.id.twt) {
            Intent ti=new Intent(Intent.ACTION_VIEW,Uri
                    .parse("https://twitter.com/webteklabs"));
            startActivity(ti);
        } else if (id == R.id.in) {
            Intent ii=new Intent(Intent.ACTION_VIEW,Uri
                    .parse("https://www.linkedin.com/in/webteklabsprivatelimited"));
            startActivity(ii);
        } else if (id == R.id.p) {
            Intent pi=new Intent(Intent.ACTION_VIEW,Uri
                    .parse("https://www.pinterest.com/WebTekLabss"));
            startActivity(pi);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings2) {
            Intent i= new Intent(HomeActivity.this,StaffActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
