package com.imran.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Toast;

import com.imran.roomdatabase.adapter.Adapter;
import com.imran.roomdatabase.model.Dataget;

import java.util.ArrayList;
import java.util.List;

public class Show_data extends AppCompatActivity {
MyDatabase myDatabase;
private RecyclerView recyclerView;
List<Dataget> llist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        myDatabase= Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"userDB")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        recyclerView=findViewById(R.id.recycler);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(layoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        showdata();
    }

    private void showdata()
    {
        List<User> list=myDatabase.myDAO().getuser();

        String info="";

        for(User user:list)
        {
            String phone=String.valueOf(user.getPhoneno());
            String name=user.getName();
            String email=user.getEmail();

            llist.add(new Dataget(name,email,phone));
            //Toast.makeText(this, ""+phone+"\n"+name+"\n"+email, Toast.LENGTH_SHORT).show();
        }
        Adapter adapter=new Adapter(llist);
        recyclerView.setAdapter(adapter);
    }
}