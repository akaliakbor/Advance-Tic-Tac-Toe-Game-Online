package com.example.tic_tac_toe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    Toolbar tl1;

    Button btn1,btn2;
    TextView t1;
    Intent mulNext;
    Intent singNext;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        mulNext=new Intent(MenuActivity.this,MainActivity.class);
        singNext=new Intent(MenuActivity.this,SingleActivity.class);

        btn1=findViewById(R.id.single);
        btn2=findViewById(R.id.multi);
        t1=findViewById(R.id.disp);
        tl1=findViewById(R.id.toolbar1);
        setSupportActionBar(tl1);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("TIC-TAC-TOE");
        }
        tl1.setSubtitle("SIMPLE");



        btn1.setOnClickListener(view-> single());
        btn2.setOnClickListener(view-> multiplayer());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId=item.getItemId();
        if(itemId==R.id.cdt){
             Toast.makeText(this,"Credit Goes to Md. Ali AKbor",Toast.LENGTH_LONG).show();
        } else if (itemId==R.id.stn) {
              Toast.makeText(this,"Comming Soon",Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }

    void  single(){
      //  Toast.makeText(this,"Comming Soon",Toast.LENGTH_SHORT).show();
        startActivity(singNext);

    }
    void multiplayer(){
        startActivity(mulNext);

    }
}