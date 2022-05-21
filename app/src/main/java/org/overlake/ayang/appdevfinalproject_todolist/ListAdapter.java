package org.overlake.ayang.appdevfinalproject_todolist;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import org.overlake.ayang.appdevfinalproject_todolist.database.SisDatabaseDao;
import org.overlake.ayang.appdevfinalproject_todolist.database.Task;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>{

    List<Task> mTasks;

    public ListAdapter(SisDatabaseDao dao, ListFragment listFragment) {
        dao.getTasks().observe(listFragment, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                mTasks = tasks;
                notifyDataSetChanged();
            }
        });
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_task, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Task task = mTasks.get(position);
        holder.description.setText(task.taskDescription);
    }

    @Override
    public int getItemCount() {
        if (mTasks != null) {
            return mTasks.size();
        } else {
            return 0;
        }
    }

    protected class ListViewHolder extends RecyclerView.ViewHolder {

        public TextView description;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            CardView cardView = itemView.findViewById(R.id.task_view);
            description = cardView.findViewById(R.id.task_description);
        }
    }
}
