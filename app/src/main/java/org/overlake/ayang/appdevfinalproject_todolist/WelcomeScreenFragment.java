package org.overlake.ayang.appdevfinalproject_todolist;

import static org.overlake.ayang.appdevfinalproject_todolist.AddCategoryDialogFragment.CATEGORY_KEY;
import static org.overlake.ayang.appdevfinalproject_todolist.AddCategoryDialogFragment.CATEGORY_NAME;
import static org.overlake.ayang.appdevfinalproject_todolist.AddTaskDialogFragment.REQ_KEY;
import static org.overlake.ayang.appdevfinalproject_todolist.AddTaskDialogFragment.TASK_DESCRIPTION;
import static org.overlake.ayang.appdevfinalproject_todolist.AddTaskDialogFragment.URGENT;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import org.overlake.ayang.appdevfinalproject_todolist.database.Category;
import org.overlake.ayang.appdevfinalproject_todolist.database.SisDatabase;
import org.overlake.ayang.appdevfinalproject_todolist.database.SisDatabaseDao;
import org.overlake.ayang.appdevfinalproject_todolist.database.Task;
import org.overlake.ayang.appdevfinalproject_todolist.databinding.FragmentSecondBinding;
import org.overlake.ayang.appdevfinalproject_todolist.databinding.FragmentWelcomeScreenBinding;

public class WelcomeScreenFragment extends Fragment {

    private FragmentWelcomeScreenBinding binding;
    private SisDatabaseDao mDao;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false);

        SisDatabase database = Room.databaseBuilder(getContext(),SisDatabase.class,"SISDatabase").allowMainThreadQueries().build();
        mDao = database.getDao();
        binding.categoryRecyclerView.setAdapter(new WelcomeScreenAdapter(mDao, this));

        AddCategoryDialogFragment dialog = new AddCategoryDialogFragment();

        binding.addCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show(getParentFragmentManager(), null);
            }
        });

        FragmentManager fm = getParentFragmentManager();
        fm.setFragmentResultListener(CATEGORY_KEY, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                mDao.addCategory(new Category(result.getString(CATEGORY_NAME)));
            }
        });

        return binding.getRoot();

    }

}