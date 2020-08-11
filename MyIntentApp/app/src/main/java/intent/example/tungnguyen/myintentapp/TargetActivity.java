package intent.example.tungnguyen.myintentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TargetActivity extends AppCompatActivity {
    TextView txtResult;
    Button btnExit;
    EditText confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        //setContentView(R.layout.activity_target);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnExit = (Button) findViewById(R.id.btn_exit);
        confirm = (EditText) findViewById(R.id.et_Confirm);

        // Get the transferred data from source activity.
        String st = getIntent().getStringExtra("message");
//        Intent intent = getIntent();
//        String message = intent.getStringExtra("message");
        txtResult.setText(st);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                finish();
                String strConfirm = confirm.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("return", strConfirm);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
