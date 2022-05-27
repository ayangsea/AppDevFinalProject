package org.overlake.ayang.appdevfinalproject_todolist;
import static org.overlake.ayang.appdevfinalproject_todolist.AddTaskDialogFragment.REQ_KEY;
import static org.overlake.ayang.appdevfinalproject_todolist.AddTaskDialogFragment.TASK_DESCRIPTION;
import static org.overlake.ayang.appdevfinalproject_todolist.AddTaskDialogFragment.URGENT;
import static org.overlake.ayang.appdevfinalproject_todolist.WelcomeScreenAdapter.CATEGORY_ID;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.room.Room;
import org.overlake.ayang.appdevfinalproject_todolist.database.SisDatabase;
import org.overlake.ayang.appdevfinalproject_todolist.database.SisDatabaseDao;
import org.overlake.ayang.appdevfinalproject_todolist.database.Task;
import org.overlake.ayang.appdevfinalproject_todolist.databinding.FragmentListBinding;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    private int mCategoryID;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        mCategoryID = getArguments().getInt(CATEGORY_ID);


        SisDatabase database = Room.databaseBuilder(getContext(),SisDatabase.class,"SISDatabase").allowMainThreadQueries().build();
        SisDatabaseDao dao = database.getDao();
        binding.recycler.setAdapter(new ListAdapter(dao, this, mCategoryID));

        AddTaskDialogFragment dialog = new AddTaskDialogFragment();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show(getParentFragmentManager(), null);
            }
        });

        binding.clearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dao.nukeTasks(mCategoryID);
            }
        });

        FragmentManager fm = getParentFragmentManager();
        fm.setFragmentResultListener(REQ_KEY, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                dao.addTask(new Task(result.getString(TASK_DESCRIPTION), result.getBoolean(URGENT), mCategoryID));
            }
        });
        return binding.getRoot();
    }
}