package nguyenlexuantung.mycontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etName, etAddress, etPhone;
    Button btnSave, btnClear, btnShow;
    public static final String USER_PREF = "USER_PREF";
    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_ADDRESS = "KEY_ADDRESS";
    public static final String KEY_PHONE = "KEY_PHONE";
    ArrayList<String> lst = new ArrayList<>();
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.et_Name);
        etAddress = (EditText) findViewById(R.id.et_Address);
        etPhone = (EditText) findViewById(R.id.et_Phone);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnShow = (Button) findViewById(R.id.btnShow);


    }

    public void save(View v) {
        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        String add = etAddress.getText().toString();
        String filename = etName.getText().toString();

        sp = getSharedPreferences(filename, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString(KEY_NAME, name);
        editor.putString(KEY_ADDRESS, add);
        editor.putString(KEY_PHONE, phone);

        editor.commit();

        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }

    public void clear(View v) {
        etName.setText("");
        etAddress.setText("");
        etPhone.setText("");
    }

    public void show(View v) {
        StringBuilder str = new StringBuilder();
        if (sp.contains(KEY_NAME)) {
            etName.setText(sp.getString(KEY_NAME, ""));
        }
        if (sp.contains(KEY_ADDRESS)) {
            etAddress.setText(sp.getString(KEY_ADDRESS, ""));
        }
        if (sp.contains(KEY_PHONE)) {
            etPhone.setText(sp.getString(KEY_PHONE, ""));
        }
    }
}