package com.nguyenoanh.managerstudent.util;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.nguyenoanh.managerstudent.Database.InforStudent;

import java.util.ArrayList;
import java.util.List;

public class StudentDiffUtil extends DiffUtil.Callback {

    List<InforStudent> oldList;
    List<InforStudent> newList;
    public StudentDiffUtil(List<InforStudent> oldList, List<InforStudent> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getId() == newList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        //you can return particular field for changed item.
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
