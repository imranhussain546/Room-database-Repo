package com.imran.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    EditText ename, eemail ,ephone;
    Button register,show,update,delete;
    static MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase= Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"userDB")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        ename=findViewById(R.id.name);
        eemail=findViewById(R.id.email);
        ephone=findViewById(R.id.phone);

        register=findViewById(R.id.register);
        show=findViewById(R.id.show);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedata();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getdata();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updatedata();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletedata();
            }
        });

    }

    public void savedata()
    {


        int phoneno=Integer.parseInt(ephone.getText().toString());
        String name= ename.getText().toString();
        String email=eemail.getText().toString();

        User user=new User();
        user.setPhoneno(phoneno);
        user.setName(name);
        user.setEmail(email);

        myDatabase.myDAO().adduser(user);

        Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();

        ename.setText("");
        eemail.setText("");
        ephone.setText("");
    }

    public void getdata()
    {
        Intent intent=new Intent(this,Show_data.class);
        startActivity(intent);


    }

    public void updatedata()
    {
        int phoneno=Integer.parseInt(ephone.getText().toString());
        String name= ename.getText().toString();
        String email=eemail.getText().toString();

        User user=new User();
        user.setPhoneno(phoneno);
        user.setName(name);
        user.setEmail(email);

        myDatabase.myDAO().updateuser(user);

        Toast.makeText(this, "Data updated Successfully", Toast.LENGTH_SHORT).show();

        ename.setText("");
        eemail.setText("");
        ephone.setText("");
    }

    public void deletedata()
    {
        int phoneno=Integer.parseInt(ephone.getText().toString());

        User user=new User();
                user.setPhoneno(phoneno);

                myDatabase.myDAO().deleteuser(user);

        Toast.makeText(this, "Delete data Successfully", Toast.LENGTH_SHORT).show();
    }
}