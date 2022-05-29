package mcm.edu.ph.liston_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class wage_info extends AppCompatActivity implements View.OnClickListener {

    EditText hourinfo, employee;
    Button btnregular,btnprobitionary,btnpartime,btnnext;
    TextView typeofemployee;
    Variables numbers=new Variables();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wageinfo);

        //Buttons
        btnregular = findViewById(R.id.BtnRegular);
        btnpartime = findViewById(R.id.BtnPartTime);
        btnnext = findViewById(R.id.BtnCalculate);
        btnprobitionary = findViewById(R.id.BtnProbitionary);
        //Texts
        hourinfo = findViewById(R.id.HourInfo);
        employee = findViewById(R.id.EmployeeInfo);
        //Textview
        typeofemployee = findViewById(R.id.Choose);

        //setOnClick
        btnregular.setOnClickListener(this);
        btnpartime.setOnClickListener(this);
        btnnext.setOnClickListener(this);
        btnprobitionary.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.BtnRegular:
                numbers.setEmployeeType("Regular");
                typeofemployee.setText("Regular");
                break;
            case R.id.BtnPartTime:
                numbers.setEmployeeType("Part-time");
                typeofemployee.setText("Part-Time");
                break;
            case R.id.BtnProbitionary:
                numbers.setEmployeeType("Probationary");
                typeofemployee.setText("Probationary");
                break;
            case R.id.BtnCalculate:
                if (numbers.getEmployeeType() == "") {
                    Toast.makeText(wage_info.this, "Enter the fields that required", Toast.LENGTH_SHORT).show();
                } else {
                    numbers.setName(String.valueOf(typeofemployee.getText()));
                    numbers.setPart(Double.parseDouble(hourinfo.getText().toString()));
                    Intent intent = new Intent(this, Reports.class);
                    intent.putExtra("name", numbers.getName());
                    intent.putExtra("type", numbers.getEmployeeType());
                    intent.putExtra("hours", numbers.getPart());
                    startActivity(intent);



                }

        }

    }

}