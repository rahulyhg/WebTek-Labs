package android.webteklabs;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class RSActivity extends AppCompatActivity {


    private DbHelper mHelper;
    private SQLiteDatabase dataBase;
    String name,phone,course,amount,id2,s2="";
    TextView tv;
    Cursor mCursor2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs);

        tv=(TextView)findViewById(R.id.r);

        mHelper=new DbHelper(RSActivity.this);
        dataBase = mHelper.getWritableDatabase();
        mCursor2 = dataBase.rawQuery("SELECT * FROM " + DbHelper.TABLE_NAME2, null);


        if (mCursor2.moveToFirst()) {
            do {
                id2=mCursor2.getString(mCursor2.getColumnIndex(DbHelper.KEY_I2));
                name=mCursor2.getString(mCursor2.getColumnIndex(DbHelper.KEY_Ename));
                phone=mCursor2.getString(mCursor2.getColumnIndex(DbHelper.KEY_Ephone));
                course=mCursor2.getString(mCursor2.getColumnIndex(DbHelper.KEY_Ecourse));
                amount=mCursor2.getString(mCursor2.getColumnIndex(DbHelper.KEY_Eamount));
                s2=s2+" "+id2+" "+name+" "+phone+" "+course+" "+amount+"\n";
            } while (mCursor2.moveToNext());
        }
        tv.setText(s2);
        mCursor2.close();
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
            Intent i= new Intent(RSActivity.this,HomeActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
