package test.nguyenlexuantung15026121.nguyenlexuantung15026121;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    Button btnInfo, btnLike;
    MyDialog mydialog;

    private List<String> mSelectedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = (TextView) findViewById(R.id.tv_Result);
        btnInfo = (Button) findViewById(R.id.btn_info);
        btnLike = (Button) findViewById(R.id.btn_like);

//        mydialog = new Dialog(this);
//        mydialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        mydialog.setContentView();
//        mydialog.show();
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivityForResult(intent, 9999);
            }
        });
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog = new MyDialog();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 9999 && resultCode == RESULT_OK) {
            String result = data.getStringExtra("return").toString();
            tvResult.setText("Thong tin: \n" + result);
        }

    }

}
