package test.nguyenlexuantung15026121.nguyenlexuantung15026121;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InfoActivity extends AppCompatActivity {
    EditText etName, etAddress;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        etName = (EditText) findViewById(R.id.et_Name);
        etAddress = (EditText) findViewById(R.id.et_Address);
        btnSubmit = (Button) findViewById(R.id.btn_Back);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(InfoActivity.this, MainActivity.class);
//                intent.putExtra("message", "Name: " + etName.getText().toString() + "\n Age: " + etAddress);
//                startActivityForResult(intent, 7777);
                String info = "Ten: " + etName.getText().toString() + "\n Dia chi: " + etAddress.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("return", info);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}
