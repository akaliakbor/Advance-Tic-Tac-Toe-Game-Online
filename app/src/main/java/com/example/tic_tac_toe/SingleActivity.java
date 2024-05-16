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

public class SingleActivity extends AppCompatActivity {
    //int[][] arr={{0},{2,5,4},{}};
    int [] move =new int[10];
    int [] press=new int[10];
    Toolbar tl2;
    int i;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,restart;
    TextView sc,result;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9;
    int f=0,p1=0,p2=0;
    int cnt=0;
    int p=0;
    String ch="X";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState  ){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
/*
        for (i = 1; i < 10; i++) {
            move[i]=-1;

        }*/
        if(p==0){
            moveZero();
            p=1;
        }


        b1=findViewById(R.id.Cp_btn1);
        b2=findViewById(R.id.Cp_btn2);
        b3=findViewById(R.id.Cp_btn3);
        b4=findViewById(R.id.Cp_btn4);
        b5=findViewById(R.id.Cp_btn5);
        b6=findViewById(R.id.Cp_btn6);
        b7=findViewById(R.id.Cp_btn7);
        b8=findViewById(R.id.Cp_btn8);
        b9=findViewById(R.id.Cp_btn9);
        restart=findViewById(R.id.Cp_btn);
        sc=findViewById(R.id.Cp_sc);
        result=findViewById(R.id.CpResult);
        tl2=findViewById(R.id.toolbar2);

        setSupportActionBar(tl2);


        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Single Player");
        }

        b1.setOnClickListener(view -> {button(b1,1);cp_button(1);});
        b2.setOnClickListener(view -> {button(b2,2);cp_button(2);});
        b3.setOnClickListener(view -> {button(b3,3);cp_button(3);});
        b4.setOnClickListener(view -> {button(b4,4);cp_button(4);});
        b5.setOnClickListener(view -> {button(b5,5);cp_button(5);});
        b6.setOnClickListener(view -> {button(b6,6);cp_button(6);});
        b7.setOnClickListener(view -> {button(b7,7);cp_button(7);});
        b8.setOnClickListener(view -> {button(b8,8);cp_button(8);});
        b9.setOnClickListener(view -> {button(b9,9);cp_button(9);});
        restart.setOnClickListener(view -> gameOver());

    }
    void gameOver(){
     moveZero();
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
    void moveZero(){
        for (i = 1; i < 10; i++) {
            move[i]=-1;
        }
    }

    void check() {

        s1 = b1.getText().toString();
        s2 = b2.getText().toString();
        s3 = b3.getText().toString();
        s4 = b4.getText().toString();
        s5 = b5.getText().toString();
        s6 = b6.getText().toString();
        s7 = b7.getText().toString();
        s8 = b8.getText().toString();
        s9 = b9.getText().toString();

        if (s1 == s2 && s2 == s3 && s1 != "") {
            Toast.makeText(this, "the winner is " + s1, Toast.LENGTH_SHORT).show();
            f = 1;
            winner(s1);
        } else if (s1 == s4 && s4 == s7 && s1 != "") {
            Toast.makeText(this, "the winner is " + s1, Toast.LENGTH_SHORT).show();
            f = 1;
            winner(s1);
        } else if (s2 == s5 && s5 == s8 && s2 != "") {
            Toast.makeText(this, "the winner is " + s2, Toast.LENGTH_SHORT).show();
            f = 1;
            winner(s2);
        } else if (s3 == s6 && s6 == s9 && s3 != "") {
            Toast.makeText(this, "the winner is " + s3, Toast.LENGTH_SHORT).show();
            f = 1;
            winner(s3);
        } else if (s4 == s5 && s5 == s6 && s4 != "") {
            Toast.makeText(this, "the winner is " + s4, Toast.LENGTH_SHORT).show();
            f = 1;
            winner(s4);
        } else if (s7 == s8 && s8 == s9 && s7 != "") {
            Toast.makeText(this, "the winner is " + s7, Toast.LENGTH_SHORT).show();
            f = 1;
            winner(s7);
        } else if (s1 == s5 && s5 == s9 && s1 != "") {
            Toast.makeText(this, "the winner is " + s1, Toast.LENGTH_SHORT).show();
            f = 1;
            winner(s1);
        } else if (s3 == s5 && s5 == s7 && s3 != "") {
            Toast.makeText(this, "the winner is " + s3, Toast.LENGTH_SHORT).show();
            f = 1;
            winner(s3);
        } else if (cnt == 9) {
            Toast.makeText(this, "Draw Game", Toast.LENGTH_SHORT).show();
            result.setText("Game Is Drawn");
        }
    }
    void button(@NonNull Button b,int idx) {
        if (b.getText().toString() == "" && f == 0) {

            b.setText(ch);
            ch = "O";
            cnt = cnt + 1;
            move[idx]=1;
            press[idx]=1;
            check();

        }
    }
    void cp_button(int idx){
        if(press[idx]==1 && f==0) {
            cp_move();
            ch = "X";
            press[idx]=2;

            cnt = cnt + 1;
            check();
        }

    }
        void winner (String s){
            if (s == "X") {
                p1++;
                result.setText("Player 1 Is The Winner");
            }
            else {
                p2++;
                result.setText("Computer Is The Winner");
            }
        }
        void cp_move(){

        if(cp_win()==1){
          System.out.println("OK");
        }
        else if(player_block()==1){
            System.out.println("OK");
        }
        else{
            int[] ran=new int[10];
            ran[1]=-1;
            int rs=1;
            for(i=1;i<10;i++){
                if(move[i]==-1){
                    ran[rs]=i;
                    rs++;
                }
            }

            if(ran[1]!=-1) {
                rs = rs - 1;
                int b = (int) (Math.random() * (rs - 2) + 1);
                int pos = ran[b];

                if (pos == 1) {
                    move[1] = 0;
                    b1.setText(ch);
                } else if (pos == 2) {
                    move[2] = 0;
                    b2.setText(ch);
                } else if (pos == 3) {
                    move[3] = 0;
                    b3.setText(ch);
                } else if (pos == 4) {
                    move[4] = 0;
                    b4.setText(ch);
                } else if (pos == 5) {
                    move[5] = 0;
                    b5.setText(ch);
                } else if (pos == 6) {
                    move[6] = 0;
                    b6.setText(ch);
                }
                else if(pos==7){
                    move[7]=0;
                    b7.setText(ch);
                }
                else if(pos==8){
                    move[8]=0;
                    b8.setText(ch);
                }
                else if(pos==9){
                    move[9]=0;
                    b9.setText(ch);
                }



            }
        }


        }


        int cp_win(){
        if(move[1]==0 && move[2]==0 && move[3]==-1)
        {
            move[3]=0;
            b3.setText(ch);
            return 1;
        }
        else if(move[1]==0 && move[3]==0 && move[2]==-1)
        {
            move[2]=0;
            b2.setText(ch);
            return 1;
        }
        else if(move[2]==0 && move[3]==0 && move[1]==-1)
        {
            move[1]=0;
            b1.setText(ch);
            return 1;
        }
        else if(move[4]==0 && move[5]==0 && move[6]==-1)
        {
            move[6]=0;
            b6.setText(ch);
            return 1;
        }
        else if(move[4]==0 && move[6]==0 && move[5]==-1)
        {
            move[5]=0;
            b5.setText(ch);
            return 1;
        }
        else if(move[6]==0 && move[5]==0 && move[4]==-1)
        {
            move[4]=0;
            b4.setText(ch);
            return 1;
        }
        else if(move[7]==0 && move[8]==0 && move[9]==-1)
        {
            move[9]=0;
            b9.setText(ch);
            return 1;
        }
        else if(move[7]==0 && move[9]==0 && move[8]==-1)
        {
            move[8]=0;
            b8.setText(ch);
            return 1;
        }
        else if(move[8]==0 && move[9]==0 && move[7]==-1)
        {
            move[7]=0;
            b7.setText(ch);
            return 1;
        }
        else if(move[1]==0 && move[4]==0 && move[7]==-1)
        {
            move[7]=0;
            b7.setText(ch);
            return 1;
        }
        else if(move[1]==0 && move[7]==0 && move[4]==-1)
        {
            move[4]=0;
            b4.setText(ch);
            return 1;
        }
        else if(move[4]==0 && move[7]==0 && move[1]==-1)
        {
            move[1]=0;
            b1.setText(ch);
            return 1;
        }
        else if(move[2]==0 && move[5]==0 && move[8]==-1)
        {
            move[8]=0;
            b8.setText(ch);
            return 1;
        }
        else if(move[2]==0 && move[8]==0 && move[5]==-1)
        {
            move[5]=0;
            b5.setText(ch);
            return 1;
        }
        else if(move[5]==0 && move[8]==0 && move[2]==-1)
        {
            move[2]=0;
            b2.setText(ch);
            return 1;
        }
        else if(move[3]==0 && move[6]==0 && move[9]==-1)
        {
            move[9]=0;
            b9.setText(ch);
            return 1;
        }
        else if(move[3]==0 && move[9]==0 && move[6]==-1)
        {
            move[6]=0;
            b6.setText(ch);
            return 1;
        }
        else if(move[6]==0 && move[9]==0 && move[3]==-1)
        {
            move[3]=0;
            b3.setText(ch);
            return 1;
        }
        else if(move[1]==0 && move[5]==0 && move[9]==-1)
        {
            move[9]=0;
            b9.setText(ch);
            return 1;
        }
        else if(move[1]==0 && move[9]==0 && move[5]==-1)
        {
            move[5]=0;
            b5.setText(ch);
            return 1;
        }
        else if(move[5]==0 && move[9]==0 && move[1]==-1)
        {
            move[1]=0;
            b1.setText(ch);
            return 1;
        }
        else if(move[3]==0 && move[5]==0 && move[7]==-1)
        {
            move[7]=0;
            b7.setText(ch);
            return 1;
        }
        else if(move[3]==0 && move[7]==0 && move[5]==-1)
        {
            move[5]=0;
            b5.setText(ch);
            return 1;
        }
        else if(move[5]==0 && move[7]==0 && move[3]==-1)
        {
            move[3]=0;
            b3.setText(ch);
            return 1;
        }
        else{
            return 0;
        }
    }
    int player_block(){


        if(move[1]==1 && move[2]==1 && move[3]==-1)
        {
            move[3]=0;
            b3.setText(ch);
            return 1;
        }
        else if(move[1]==1 && move[3]==1 && move[2]==-1)
        {
            move[2]=0;
            b2.setText(ch);
            return 1;
        }
        else if(move[2]==1 && move[3]==1 && move[1]==-1)
        {
            move[1]=0;
            b1.setText(ch);
            return 1;
        }
        else if(move[4]==1 && move[5]==1 && move[6]==-1)
        {
            move[6]=0;
            b6.setText(ch);
            return 1;
        }
        else if(move[4]==1 && move[6]==1 && move[5]==-1)
        {
            move[5]=0;
            b5.setText(ch);
            return 1;
        }
        else if(move[6]==1 && move[5]==1 && move[4]==-1)
        {
            move[4]=0;
            b4.setText(ch);
            return 1;
        }
        else if(move[7]==1 && move[8]==1 && move[9]==-1)
        {
            move[9]=0;
            b9.setText(ch);
            return 1;
        }
        else if(move[7]==1 && move[9]==1 && move[8]==-1)
        {
            move[8]=0;
            b8.setText(ch);
            return 1;
        }
        else if(move[8]==1 && move[9]==1 && move[7]==-1)
        {
            move[7]=0;
            b7.setText(ch);
            return 1;
        }
        else if(move[1]==1 && move[4]==1 && move[7]==-1)
        {
            move[7]=0;
            b7.setText(ch);
            return 1;
        }
        else if(move[1]==1 && move[7]==1 && move[4]==-1)
        {
            move[4]=0;
            b4.setText(ch);
            return 1;
        }
        else if(move[4]==1 && move[7]==1 && move[1]==-1)
        {
            move[1]=0;
            b1.setText(ch);
            return 1;
        }
        else if(move[2]==1 && move[5]==1 && move[8]==-1)
        {
            move[8]=0;
            b8.setText(ch);
            return 1;
        }
        else if(move[2]==1 && move[8]==1 && move[5]==-1)
        {
            move[5]=0;
            b5.setText(ch);
            return 1;
        }
        else if(move[5]==1 && move[8]==1 && move[2]==-1)
        {
            move[2]=0;
            b2.setText(ch);
            return 1;
        }
        else if(move[3]==1 && move[6]==1 && move[9]==-1)
        {
            move[9]=0;
            b9.setText(ch);
            return 1;
        }
        else if(move[3]==1 && move[9]==1 && move[6]==-1)
        {
            move[6]=0;
            b6.setText(ch);
            return 1;
        }
        else if(move[6]==1 && move[9]==1 && move[3]==-1)
        {
            move[3]=0;
            b3.setText(ch);
            return 1;
        }
        else if(move[1]==1 && move[5]==1 && move[9]==-1)
        {
            move[9]=0;
            b9.setText(ch);
            return 1;
        }
        else if(move[1]==1 && move[9]==1 && move[5]==-1)
        {
            move[5]=0;
            b5.setText(ch);
            return 1;
        }
        else if(move[5]==1 && move[9]==1 && move[1]==-1)
        {
            move[1]=0;
            b1.setText(ch);
            return 1;
        }
        else if(move[3]==1 && move[5]==1 && move[7]==-1)
        {
            move[7]=0;
            b7.setText(ch);
            return 1;
        }
        else if(move[3]==1 && move[7]==1 && move[5]==-1)
        {
            move[5]=0;
            b5.setText(ch);
            return 1;
        }
        else if(move[5]==1 && move[7]==1 && move[3]==-1)
        {
            move[3]=0;
            b3.setText(ch);
            return 1;
        }
        else{
            return 0;
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