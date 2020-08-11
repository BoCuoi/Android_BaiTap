package test.nguyenlexuantung15026121.nguyenlexuantung15026121;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MyDialog extends DialogFragment {

    private List<String> mSelectedItems;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mSelectedItems = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chon so thich");
        builder.setMultiChoiceItems(R.array.like_array, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                String[] items = getActivity().getResources().getStringArray(R.array.like_array);
                if (isChecked) {
                    mSelectedItems.add(items[i]);
                } else if (mSelectedItems.contains(items[i])) {
                    mSelectedItems.remove(items[i]);
                }
            }
        });

        builder.setPositiveButton("Nhap", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String final_select = "";
                for (String item : mSelectedItems) {
                    final_select = final_select + "\n" + item;
                }

            }
        });
        builder.setNegativeButton("Huy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }
}
