package android.webteklabs;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StaffActivity extends AppCompatActivity {

    Button lbt,rbt;
    private EditText id1,password1,id2,password2,password3;
    private DbHelper mHelper;
    private SQLiteDatabase dataBase;
    String Id1,Pwd1,Id2,Pwd2,Pwd3,id,pwd;
    Cursor mCursor1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        lbt=(Button)findViewById(R.id.slbt);
        rbt=(Button)findViewById(R.id.srbt);
        id1=(EditText)findViewById(R.id.slet1);
        password1=(EditText)findViewById(R.id.slet2);
        id2=(EditText)findViewById(R.id.sret1);
        password2=(EditText)findViewById(R.id.sret2);
        password3=(EditText)findViewById(R.id.sret3);

        mHelper=new DbHelper(StaffActivity.this);
        dataBase=mHelper.getWritableDatabase();
        final ContentValues values=new ContentValues();
        mCursor1 = dataBase.rawQuery("SELECT * FROM " + DbHelper.TABLE_NAME1, null);

        lbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Id1=id1.getText().toString().trim();
                Pwd1=password1.getText().toString().trim();
                if (mCursor1.moveToFirst()) {
                    do {
                        id=mCursor1.getString(mCursor1.getColumnIndex(DbHelper.KEY_ID));
                        pwd=mCursor1.getString(mCursor1.getColumnIndex(DbHelper.KEY_Password));
                        if(Id1.equals(id)&&Pwd1.equals(pwd)){
                            Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_LONG).show();
                            Intent li = new Intent(StaffActivity.this,LoginActivity.class);
                            startActivity(li);
                        }
                        else{
                            Intent li = new Intent(StaffActivity.this, StaffActivity.class);
                            startActivity(li);
                        }
                    } while (mCursor1.moveToNext());
                }
                else{
                    Toast.makeText(getApplicationContext(), "Login Failed!\n  Try Again!", Toast.LENGTH_LONG).show();
                    Intent li = new Intent(StaffActivity.this, StaffActivity.class);
                    startActivity(li);
                }
                mCursor1.close();
            }
        });

        rbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Id2=id2.getText().toString().trim();
                Pwd2=password2.getText().toString().trim();
                Pwd3=password3.getText().toString().trim();
                if(Pwd2.equals(Pwd3)) {
                    try
                    {
                        values.put(DbHelper.KEY_ID, Id2);
                        values.put(DbHelper.KEY_Password, Pwd2);
                        dataBase.insert(DbHelper.TABLE_NAME1, null, values);
                        dataBase.close();
                        Toast.makeText(getApplicationContext(), "Registration Successful!", Toast.LENGTH_LONG).show();
                        Intent ri = new Intent(StaffActivity.this, StaffActivity.class);
                        startActivity(ri);
                    }
                    catch (Exception e) {
                        // TODO: handle exception
                        Toast.makeText(getApplicationContext(), (CharSequence) e, Toast.LENGTH_LONG).show();
                        System.out.println(e);
                        Intent ri = new Intent(StaffActivity.this, StaffActivity.class);
                        startActivity(ri);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Incorrect Password!", Toast.LENGTH_LONG).show();
                    Intent ri = new Intent(StaffActivity.this, StaffActivity.class);
                    startActivity(ri);
                }
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
            Intent i= new Intent(StaffActivity.this,HomeActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
