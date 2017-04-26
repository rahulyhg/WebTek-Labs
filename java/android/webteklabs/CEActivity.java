package android.webteklabs;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class CEActivity extends AppCompatActivity {

    private DbHelper mHelper;
    private SQLiteDatabase dataBase;
    String name,phone,sub,id3,s1="";
    TextView tv;
    Cursor mCursor3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ce);

        tv=(TextView)findViewById(R.id.c);

        mHelper=new DbHelper(CEActivity.this);
        dataBase = mHelper.getWritableDatabase();
        mCursor3 = dataBase.rawQuery("SELECT * FROM " + DbHelper.TABLE_NAME3, null);


        if (mCursor3.moveToFirst()) {
            do {
                id3=mCursor3.getString(mCursor3.getColumnIndex(DbHelper.KEY_I3));
                name=mCursor3.getString(mCursor3.getColumnIndex(DbHelper.KEY_Cname));
                phone=mCursor3.getString(mCursor3.getColumnIndex(DbHelper.KEY_Cphone));
                sub=mCursor3.getString(mCursor3.getColumnIndex(DbHelper.KEY_Csub));
                s1=s1+" "+id3+" "+name+" "+phone+" "+sub+"\n";
            } while (mCursor3.moveToNext());
        }
        tv.setText(s1);
        mCursor3.close();
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
            Intent i= new Intent(CEActivity.this,HomeActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
