package TungNguyen.CalculationApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText valueA, valueB;
    private TextView result;
    private Button btn_sum, btn_subtract, btn_multi, btn_divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueA = (EditText) findViewById(R.id.valueA);
        valueB = (EditText) findViewById(R.id.valueB);
        result = (TextView) findViewById(R.id.Result);
        btn_sum = (Button) findViewById(R.id.btn_Sum);
        btn_subtract = (Button) findViewById(R.id.btn_Subtract);
        btn_multi = (Button) findViewById(R.id.btn_Multi);
        btn_divide = (Button) findViewById(R.id.btn_Divide);

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valueA.getText().toString().trim().isEmpty() && valueB.getText().toString().trim().isEmpty()) {
                    result.setText(String.valueOf(Float.parseFloat(valueA.getText().toString().trim()
                            + Float.parseFloat((valueB.getText().toString().trim())))));
                } else {
                    result.setText("Vui lòng nhập lại");
                }
            }
        });

        btn_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(String.valueOf(Float.parseFloat(valueA.getText().toString().replaceAll("\\s+", ""))
                        - Float.parseFloat((valueB.getText().toString().replaceAll("\\s+", "")))));
            }
        });

        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(String.valueOf(Float.parseFloat(valueA.getText().toString().replaceAll("\\s+",""))
                        * Float.parseFloat((valueB.getText().toString().replaceAll("\\s+","")))));
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(String.valueOf(Float.parseFloat(valueA.getText().toString().replaceAll("\\s+",""))
                        / Float.parseFloat((valueB.getText().toString().replaceAll("\\s+","")))));
            }
        });
    }
}