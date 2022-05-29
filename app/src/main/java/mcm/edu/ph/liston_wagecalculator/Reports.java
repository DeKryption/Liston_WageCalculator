package mcm.edu.ph.liston_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Reports extends AppCompatActivity {
    TextView Employee,Overtimeinfo,Hours,Overtimepay,Regularpay,Overall;
    Variables numbers=new Variables();
    Methods methods=new Methods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_reports);
        getSupportActionBar().hide();

        Intent intent = getIntent();
        numbers.setName(intent.getStringExtra("name"));
        numbers.setEmployeeType(intent.getStringExtra("type"));
        numbers.setPart(intent.getDoubleExtra("hours", numbers.getPart()));

        //Texts
        Employee = findViewById(R.id.Employee);
        Overtimeinfo = findViewById(R.id.OverTimeHours);
        Hours = findViewById(R.id.HoursRendered);
        Overtimepay = findViewById(R.id.OverTimePay);
        Regularpay = findViewById(R.id.RegularPay);
        Overall = findViewById(R.id.OverallPay);

        //Methods
        double part = methods.solveEF(numbers.getPart());
        double regular = methods.solveRegular(numbers.getEmployeeType(), numbers.getPart(), part);
        double overtime = methods.solveTime(numbers.getEmployeeType(), part);
        double all = methods.solveTotal(part, overtime);
        Employee.setText(numbers.getName() + " (" + numbers.getEmployeeType() + ")");
        Hours.setText("Hours rendered: " + numbers.getPart());
        Overtimeinfo.setText("Overtime hours: " + part);
        Regularpay.setText("Regular Wage: " + regular);
        Overtimeinfo.setText("Overtime wage: " + all);
        Overall.setText(String.valueOf(all));

    }
}