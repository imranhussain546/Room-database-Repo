package com.imran.roomdatabase.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imran.roomdatabase.R;
import com.imran.roomdatabase.model.Dataget;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {


    private List<Dataget> dataget;
    public Adapter(List<Dataget> dataget)
    {
        this.dataget=dataget;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayout,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position)
    {
        String name=dataget.get(position).getName();
        String email=dataget.get(position).getEmail();
        String phone=dataget.get(position).getPhone();
        holder.setdata(name,email,phone);

    }

    @Override
    public int getItemCount() {
        return dataget.size();
    }

    class Viewholder extends RecyclerView.ViewHolder
    {
        TextView t1,t2,t3;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.tv1);
            t2=itemView.findViewById(R.id.tv2);
            t3=itemView.findViewById(R.id.tv3);
        }
        private  void setdata(String name,String email,String phone)
        {
            t1.setText("Name:-"+name);
            t2.setText("Email:-"+email);
            t3.setText("Phone:-"+phone);
        }
    }
}
