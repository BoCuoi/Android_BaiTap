package listview.casestudy5.tungnguyen.managermentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etId, etName;
    Button btnNhap;
    RadioGroup radGroup;
    ListView lstEmployee;
    ArrayList<Employee> arrE=new ArrayList<Employee>();
    ArrayAdapter<Employee> arrayAdapter=null;

    Employee employee=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etId=findViewById(R.id.edt_ma);
        etName=findViewById(R.id.edt_ten);
        btnNhap=findViewById(R.id.btn_nhap);
        radGroup=findViewById(R.id.radigr);
        list=findViewById(R.id.list_item);
        arrayAdapter =new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1,arrE);
        list.setAdapter(arrayAdapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nhap();
            }
        });
    }
    public void  nhap(){
        int radId=radGroup.getCheckedRadioButtonId();
        String id =edt_id.getText()+"";
        String name=edt_name.getText()+"";
        if (radId==R.id.rd_chinh){
            employee=new EmployeePFullTime();

        }else {
            employee=new EmployeerPartTime();
        }
        employee.setId(id);
        employee.setName(name);
        arrE.add(employee);
        arrayAdapter.notifyDataSetChanged();

    }
}
