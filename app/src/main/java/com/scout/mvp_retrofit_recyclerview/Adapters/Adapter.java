package com.scout.mvp_retrofit_recyclerview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.scout.mvp_retrofit_recyclerview.Model.ModelUsers;
import com.scout.mvp_retrofit_recyclerview.R;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {
    Context context;
    ArrayList<ModelUsers> list;

    public Adapter(Context context, ArrayList<ModelUsers> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_users, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ModelUsers user = list.get(position);

        // Set data to viewHolder
        holder.user_id.setText(user.getUserId());
        holder.user_name.setText(user.getUserName());
        holder.name.setText(user.getName());
        holder.user_email.setText(user.getUserEmail());
        holder.website.setText(user.getWebsite());
    }

    @Override
    public int getItemCount() {
        return(list!=null? list.size() : 0);
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.user_id)
        TextView user_id;
        @BindView(R.id.user_name)
        TextView user_name;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.user_email)
        TextView user_email;
        @BindView(R.id.website)
        TextView website;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
