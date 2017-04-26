package android.webteklabs;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EnrollmentActivity extends AppCompatActivity {

    Button efbt;
    private EditText en,ep,ec,ea;
    private DbHelper mHelper;
    private SQLiteDatabase dataBase;
    String N,P,C,A;
    String state[]={"Choose Your State","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Delhi","Goa","Gujarat","Haryana","Himachal Pradesh",
            "Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland",
            "Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
    String centre[]={"Choose Your Centre","Delhi","Hyderabad","Kolkata-Lee Road","Kolkata-Saltlake"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollment);

        efbt=(Button)findViewById(R.id.ebt);
        en=(EditText)findViewById(R.id.eet1);
        ep=(EditText)findViewById(R.id.eet2);
        ec=(EditText)findViewById(R.id.eet5);
        ea=(EditText)findViewById(R.id.eet10);

        mHelper=new DbHelper(EnrollmentActivity.this);
        dataBase=mHelper.getWritableDatabase();
        final ContentValues values=new ContentValues();

        Spinner sp1=(Spinner)findViewById(R.id.esp1);

        ArrayAdapter Adapter1 = new ArrayAdapter<String>(EnrollmentActivity.this,R.layout.spinner,state);
        sp1.setAdapter(Adapter1);

        Spinner sp2=(Spinner)findViewById(R.id.esp2);

        ArrayAdapter Adapter2 = new ArrayAdapter<String>(EnrollmentActivity.this,R.layout.spinner,centre);
        sp2.setAdapter(Adapter2);

        efbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                N=en.getText().toString().trim();
                P=ep.getText().toString().trim();
                C=ec.getText().toString().trim();
                A=ea.getText().toString().trim();

                try{
                    values.put(DbHelper.KEY_Ename,N);
                    values.put(DbHelper.KEY_Ephone,P);
                    values.put(DbHelper.KEY_Ecourse,C);
                    values.put(DbHelper.KEY_Eamount, A);
                    dataBase.insert(DbHelper.TABLE_NAME2, null, values);
                    Toast.makeText(getApplicationContext(), "Your Application is Submitted!", Toast.LENGTH_LONG).show();
                    Intent eai = new Intent(EnrollmentActivity.this, HomeActivity.class);
                    startActivity(eai);
                    dataBase.close();
                    finish();
            }catch (Exception e) {
            // TODO: handle exception
            Toast.makeText(getApplicationContext(), (CharSequence) e, Toast.LENGTH_LONG).show();
            System.out.println(e);
                    Intent eai = new Intent(EnrollmentActivity.this, EnrollmentActivity.class);
                    startActivity(eai);
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
            Intent i= new Intent(EnrollmentActivity.this,HomeActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
