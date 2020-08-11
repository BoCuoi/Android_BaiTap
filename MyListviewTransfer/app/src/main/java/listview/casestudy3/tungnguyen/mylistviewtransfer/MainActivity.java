package listview.casestudy3.tungnguyen.mylistviewtransfer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> myList;
    private ArrayAdapter<String> adapter;
    private ListView list;
    private Button btnNhap;
    private EditText etNhap;
    private TextView tvKetqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNhap = (EditText) findViewById(R.id.et_Input);
        list = (ListView) findViewById(R.id.lv_output);
        tvKetqua = (TextView) findViewById(R.id.tv_banner);
        myList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);

        list.setAdapter(adapter);

        btnNhap = (Button) findViewById(R.id.btn_input);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.add(etNhap.getText() + "");
                adapter.notifyDataSetChanged();
            }
        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                list.getChildAt(arg2).setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                String msg = "position: " + arg2;
                msg += "; value :" + arg0.getItemAtPosition(arg2).toString();
                tvKetqua.setText(msg);
            }
        });
    }
}
