package com.example.hifzdiary;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class studentAdapter extends RecyclerView.Adapter<studentAdapter.MyVH> {

    List<Student> studentList;
    public studentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public studentAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.studen_single, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull studentAdapter.MyVH holder, int position) {
        holder.data=studentList.get(position);
        holder.textViewName.setText(holder.data.getStudent_name());
        holder.textViewRoll.setText(holder.data.getStudent_roll());
        holder.textViewClass.setText(holder.data.getStudent_class());
       holder.student_image.setImageResource(holder.data.getStudent_image_id());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewRoll;
        TextView textViewClass;

        ImageView student_image;
        Student data;
        public MyVH(@NonNull View itemView) {
            super(itemView);
           textViewName=itemView.findViewById(R.id.textViewFriendName);
           textViewRoll=itemView.findViewById(R.id.textViewDate);
           textViewClass=itemView.findViewById(R.id.textViewCity);
           student_image=itemView.findViewById(R.id.imageViewFriendPicture);

        }
    }
}