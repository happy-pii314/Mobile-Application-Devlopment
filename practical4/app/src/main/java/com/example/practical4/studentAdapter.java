package com.example.practical4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class studentAdapter extends RecyclerView.Adapter<studentAdapter.ViewHolder> {

    ArrayList<student> students;

    public studentAdapter(ArrayList<student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        student student = students.get(position);

        holder.txtName.setText(student.name);
        holder.txtAddress.setText(student.address);
        holder.imgStudent.setImageResource(student.image);

        holder.btnDelete.setOnClickListener(v -> {
            students.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, students.size());
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtAddress;
        ImageView imgStudent;
        Button btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            imgStudent = itemView.findViewById(R.id.imgStudent);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}