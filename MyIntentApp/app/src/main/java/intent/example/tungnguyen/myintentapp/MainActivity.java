package intent.example.tungnguyen.myintentapp;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText name, birth;
    Button btnSubmit, btnExit;
    TextView txtConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = (EditText) findViewById(R.id.name);
        birth = (EditText) findViewById(R.id.birth);
        txtConfirm = (TextView) findViewById(R.id.txtConfirm);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnExit = (Button) findViewById(R.id.btn_exit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long age = 2020 - Integer.parseInt(birth.getText().toString());
                Intent intent = new Intent(MainActivity.this, TargetActivity.class);
                intent.putExtra("message", "Name: " + name.getText().toString() + "\n Age: " + age);
                startActivityForResult(intent, 9999);
            }

        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 9999 && resultCode == RESULT_OK) {
            String result = data.getStringExtra("return").toString();
            txtConfirm.setText("Returned Information: " + result);
        }

    }
}
