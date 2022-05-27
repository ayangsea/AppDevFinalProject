package org.overlake.ayang.appdevfinalproject_todolist;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import org.overlake.ayang.appdevfinalproject_todolist.database.Category;
import org.overlake.ayang.appdevfinalproject_todolist.database.SisDatabaseDao;
import java.util.List;

public class WelcomeScreenAdapter extends RecyclerView.Adapter<WelcomeScreenAdapter.WelcomeScreenViewHolder>{

    List<Category> mCategories;
    WelcomeScreenFragment mfragment;
    public static final String CATEGORY_ID = "category_id";

    public WelcomeScreenAdapter(SisDatabaseDao dao, WelcomeScreenFragment welcomeScreenFragment) {
        dao.getCategories().observe(welcomeScreenFragment, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                mCategories = categories;
                notifyDataSetChanged();
            }
        });
        mfragment = welcomeScreenFragment;
    }

    @NonNull
    @Override
    public WelcomeScreenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_category, parent, false);
        return new WelcomeScreenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WelcomeScreenViewHolder holder, int position) {
        Category category = mCategories.get(position);
        holder.categoryName.setText(category.name);
        holder.GoArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt(CATEGORY_ID, category.categoryID);
                NavHostFragment.findNavController(mfragment).navigate(R.id.action_welcomeScreenFragment_to_FirstFragment, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mCategories != null) {
            return mCategories.size();
        } else {
            return 0;
        }
    }

    protected class WelcomeScreenViewHolder extends RecyclerView.ViewHolder {

        public TextView categoryName;
        public ImageButton GoArrow;

        public WelcomeScreenViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.category_name);
            GoArrow = itemView.findViewById(R.id.GoArrow);
        }
    }
}
