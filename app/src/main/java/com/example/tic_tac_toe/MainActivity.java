package com.example.tic_tac_toe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar tl3;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,restart;
    TextView  sc,result;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9;
    int f=0,p1=0,p2=0;
    int cnt=0;
    String ch="X";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        b4=findViewById(R.id.btn4);
        b5=findViewById(R.id.btn5);
        b6=findViewById(R.id.btn6);
        b7=findViewById(R.id.btn7);
        b8=findViewById(R.id.btn8);
        b9=findViewById(R.id.btn9);
        restart=findViewById(R.id.btn);
        sc=findViewById(R.id.sc);
        result=findViewById(R.id.result);
        tl3=findViewById(R.id.toolbar3);

        setSupportActionBar(tl3);


        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Multi Player");
        }

        b1.setOnClickListener(view -> button(b1));
        b2.setOnClickListener(view -> button(b2));
        b3.setOnClickListener(view -> button(b3));
        b4.setOnClickListener(view -> button(b4));
        b5.setOnClickListener(view -> button(b5));
        b6.setOnClickListener(view -> button(b6));
        b7.setOnClickListener(view -> button(b7));
        b8.setOnClickListener(view -> button(b8));
        b9.setOnClickListener(view -> button(b9));
        restart.setOnClickListener(view -> gameOver());



    }
    void gameOver(){
        cnt=0;
        f=0;
        ch="X";
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        result.setText("");
        sc.setText("Score  X->"+p1+"       O->"+p2);
    }
    void check(){

        s1=b1.getText().toString();
        s2=b2.getText().toString();
        s3=b3.getText().toString();
        s4=b4.getText().toString();
        s5=b5.getText().toString();
        s6=b6.getText().toString();
        s7=b7.getText().toString();
        s8=b8.getText().toString();
        s9=b9.getText().toString();

        if(s1==s2 && s2==s3 && s1!=""){
            Toast.makeText(this,"the winner is "+s1,Toast.LENGTH_SHORT).show();
            f=1;
            winner(s1);
        }
        else if(s1==s4 && s4==s7 && s1!=""){
            Toast.makeText(this,"the winner is "+s1,Toast.LENGTH_SHORT).show();
            f=1;
            winner(s1);
        }
        else if(s2==s5 && s5==s8 && s2!=""){
            Toast.makeText(this,"the winner is "+s2,Toast.LENGTH_SHORT).show();
            f=1;
            winner(s2);
        }
        else if(s3==s6 && s6==s9 && s3!=""){
            Toast.makeText(this,"the winner is "+s3,Toast.LENGTH_SHORT).show();
            f=1;
            winner(s3);
        }
        else if(s4==s5 && s5==s6 && s4!=""){
            Toast.makeText(this,"the winner is "+s4,Toast.LENGTH_SHORT).show();
            f=1;
            winner(s4);
        }
        else if(s7==s8 && s8==s9 && s7!=""){
            Toast.makeText(this,"the winner is "+s7,Toast.LENGTH_SHORT).show();
            f=1;
            winner(s7);
        }
        else if(s1==s5 && s5==s9 && s1!=""){
            Toast.makeText(this,"the winner is "+s1,Toast.LENGTH_SHORT).show();
            f=1;
            winner(s1);
        }
        else if(s3==s5 && s5==s7 && s3!=""){
            Toast.makeText(this,"the winner is "+s3,Toast.LENGTH_SHORT).show();
            f=1;
            winner(s3);
        }
        else if(cnt==9){
            Toast.makeText(this,"Draw Game",Toast.LENGTH_SHORT).show();
            result.setText("Game Is Drawn");
        }




    }
   void button(@NonNull Button b){
        if(b.getText().toString()=="" && f==0) {
            b.setText(ch);
            if(ch=="X") {
                ch = "O";
            }
            else {
                ch="X";
            }
            cnt++;
            check();
        }


    }
    void winner(String s){
        if(s=="X"){
            p1++;
            result.setText("Player 1 Is The Winner");
        }
        else{
            p2++;
            result.setText("Player 2 Is The Winner");
        }
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
            Toast.makeText(this,"Credit Goes to Md. Ali Akbor",Toast.LENGTH_LONG).show();
        } else if (itemId==R.id.stn) {
            Toast.makeText(this,"Comming Soon",Toast.LENGTH_SHORT).show();

        }
        else if(itemId==android.R.id.home){
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}