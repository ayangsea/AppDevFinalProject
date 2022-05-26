package org.overlake.ayang.appdevfinalproject_todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import org.overlake.ayang.appdevfinalproject_todolist.databinding.FragmentAddCategoryBinding;
import org.overlake.ayang.appdevfinalproject_todolist.databinding.FragmentAddTaskBinding;

public class AddCategoryDialogFragment extends DialogFragment {

    public static final String CATEGORY_KEY = "category_info";
    public static final String CATEGORY_NAME = "category_name";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        FragmentAddCategoryBinding binding = FragmentAddCategoryBinding.inflate(getLayoutInflater());
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder
                .setView(binding.getRoot())
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String name = binding.categoryNameForDialog.getText().toString();
                        Bundle bundle = new Bundle();
                        bundle.putString(CATEGORY_NAME, name);
                        getParentFragmentManager().setFragmentResult(CATEGORY_KEY, bundle);
                        Toast.makeText(getActivity(), "Category Successfully Added", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", null);

        return builder.create();
    }
}
