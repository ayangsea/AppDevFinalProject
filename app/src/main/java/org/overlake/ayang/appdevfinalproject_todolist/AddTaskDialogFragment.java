package org.overlake.ayang.appdevfinalproject_todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import org.overlake.ayang.appdevfinalproject_todolist.databinding.FragmentAddTaskBinding;

public class AddTaskDialogFragment extends DialogFragment {

    public static final String TASK_DESCRIPTION = "task_description";
    public static final String URGENT = "urgent";
    public static final String REQ_KEY = "add_task";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        FragmentAddTaskBinding binding = FragmentAddTaskBinding.inflate(getLayoutInflater());
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder
                .setView(binding.getRoot())
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String taskDescription = binding.taskDescription.getText().toString();
                        boolean urgent = false;
                        if (binding.checkBox.isChecked()) {
                            urgent = true;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString(TASK_DESCRIPTION, taskDescription);
                        bundle.putBoolean(URGENT, urgent);
                        getParentFragmentManager().setFragmentResult(REQ_KEY, bundle);
                        Toast.makeText(getActivity(), "Task Successfully Added", Toast.LENGTH_SHORT).show();
                    }
                })
        .setNegativeButton("Cancel", null);

        return builder.create();
    }
}
