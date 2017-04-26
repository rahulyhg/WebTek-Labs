package android.webteklabs;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CareerForm extends AppCompatActivity {

    Button cfbt;
    private EditText cn,cp,cs;
    private DbHelper mHelper;
    private SQLiteDatabase dataBase;
    String N,P,S;
    String state[]={"Choose Your State","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Delhi","Goa","Gujarat","Haryana","Himachal Pradesh",
            "Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland",
            "Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_form);

        cfbt=(Button)findViewById(R.id.fbt);
        cn=(EditText)findViewById(R.id.fet1);
        cp=(EditText)findViewById(R.id.fet3);
        cs=(EditText)findViewById(R.id.fet7);

        mHelper=new DbHelper(CareerForm.this);
        dataBase=mHelper.getWritableDatabase();
        final ContentValues values=new ContentValues();

        Spinner sp=(Spinner)findViewById(R.id.fsp);

        ArrayAdapter Adapter = new ArrayAdapter<String>(CareerForm.this,R.layout.spinner,state);
        sp.setAdapter(Adapter);

        cfbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                N=cn.getText().toString().trim();
                P=cp.getText().toString().trim();
                S=cs.getText().toString().trim();

                try{
                    values.put(DbHelper.KEY_Cname,N);
                    values.put(DbHelper.KEY_Cphone,P);
                    values.put(DbHelper.KEY_Csub,S);

                    dataBase.insert(DbHelper.TABLE_NAME3, null, values);
                    Toast.makeText(getApplicationContext(), "Your Application is Submitted!", Toast.LENGTH_LONG).show();
                    Intent eai = new Intent(CareerForm.this, HomeActivity.class);
                    startActivity(eai);
                    dataBase.close();
                    finish();
                }catch (Exception e) {
                    // TODO: handle exception
                    Toast.makeText(getApplicationContext(), (CharSequence) e, Toast.LENGTH_LONG).show();
                    System.out.println(e);
                    Intent eai = new Intent(CareerForm.this, EnrollmentActivity.class);
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
            Intent i= new Intent(CareerForm.this,HomeActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
