package com.nguyenoanh.managerstudent.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyenoanh.managerstudent.Database.InforStudent;
import com.nguyenoanh.managerstudent.R;
import com.nguyenoanh.managerstudent.util.StudentDiffUtil;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class InforStudentAdapter extends RecyclerView.Adapter<InforStudentAdapter.ViewHolder> {
    private Context context;
    private List<InforStudent> list;

    public InforStudentAdapter(Context context, List<InforStudent> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from (context);
        View view = inflater.inflate (R.layout.item_student, viewGroup, false);

        return new InforStudentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        InforStudent itemNew = list.get (i);

        holder.tvName.setText (itemNew.getName ());
        holder.tvDate.setText (itemNew.getDate ());

        holder.tvGender.setText (itemNew.getSpecial ());
        holder.tvAddress.setText ((itemNew.getAddress ()));
        holder.tvSpecial.setText (itemNew.getSpecial ());
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        CircleImageView profileImage;
        TextView tvName, tvDate, tvGender, tvAddress, tvSpecial;

        public ViewHolder(@NonNull View itemView) {
            super (itemView);

            profileImage = (CircleImageView) itemView.findViewById (R.id.imv_profile);

            tvName = (TextView) itemView.findViewById (R.id.tv_name);
            tvDate = (TextView) itemView.findViewById (R.id.tv_date);
            tvGender = (TextView) itemView.findViewById (R.id.tv_gender);
            tvAddress = (TextView) itemView.findViewById (R.id.tv_address);
            tvSpecial = (TextView) itemView.findViewById (R.id.tv_special);

            itemView.setOnClickListener (this);
        }

        @Override
        public void onClick(View view) {
        }
    }

    public void addTasks(List<InforStudent> newLists) {
        StudentDiffUtil studentDiffUtil = new StudentDiffUtil (list, newLists);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(studentDiffUtil);
        list.clear();
        list.addAll(newLists);
        diffResult.dispatchUpdatesTo(this);
    }

    @Override
    public int getItemCount() {
        return list.size ();
    }
    public InforStudent getItem(int position) {
        return list.get(position);
    }

}
