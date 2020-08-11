 package listview.casestudy4.tungnguyen.listviewappextend;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

 public class MainActivity extends ListActivity {
     EditText etNhap;
     Button btnNhap;
     ArrayList<String> myList;
     ArrayAdapter<String> adapter;
     TextView ketqua;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         etNhap = findViewById(R.id.et_Input);
         btnNhap = findViewById(R.id.btn_input);
         ketqua = findViewById(R.id.tv_banner);
         myList = new ArrayList<String>();
         adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList);

         setListAdapter(adapter);

         btnNhap.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 myList.add(etNhap.getText()+" ");
                 adapter.notifyDataSetChanged();
             }
         });
     }

     @Override
     protected void onListItemClick(ListView l, View v, int position, long id) {
         super.onListItemClick(l, v, position, id);
         String item = (String)getListAdapter().getItem(position);
         ketqua.setText("position: " +position +"; value:"+item);
     }
 }