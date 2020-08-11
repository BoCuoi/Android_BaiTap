package listviewselect.example.tungnguyen.listviewapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends ListActivity {
    String[] presidents;
    TextView tvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        tvShow = (TextView) findViewById(R.id.tv_show);
        ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setTextFilterEnabled(true);
        presidents = getResources().getStringArray(R.array.presidents_array);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, presidents));
    }

    public void onClick(View view) {
        ListView listView = getListView();

        String itemsSelected = "Selected Items: \n";
        for (int i = 0; i < listView.getCount(); i++) {
            if (listView.isItemChecked(i)) {
                itemsSelected += listView.getItemAtPosition(i) + "\n";
            } else {
                itemsSelected.replace(listView.getItemAtPosition(i).toString(), "");
            }

        }
        tvShow.setText(itemsSelected);
        Toast.makeText(this, itemsSelected, Toast.LENGTH_SHORT).show();
    }
}
