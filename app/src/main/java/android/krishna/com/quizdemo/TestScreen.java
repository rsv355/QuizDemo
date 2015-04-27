package android.krishna.com.quizdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class TestScreen extends ActionBarActivity {

    private ArrayList<String> Questions = new ArrayList<String>();

    private ArrayList<String> Answer1 = new ArrayList<String>();
    private ArrayList<String> Answer2 = new ArrayList<String>();
    private ArrayList<String> Answer3 = new ArrayList<String>();

    private TextView txtSecond,txtMinute,txtHour;
    int counter=0;
    RadioButton optA,optB,optC,optD;
    Button btnPrevious,btnNext;
    public static HashMap<Integer,String> optionlist = new HashMap<Integer,String>();
    public static ArrayList<String> selectoptionlist=new ArrayList<String>();

    TextView txtQuestion,txtOptA,txtOptB,txtOptC,txtOptD,txtno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        intit();


        btnPrevious = (Button)findViewById(R.id.btnPrevious);
        btnNext = (Button)findViewById(R.id.btnNext);

        txtSecond= (TextView) findViewById(R.id.txtSecond);
        txtMinute= (TextView) findViewById(R.id.txtMinute);
        txtHour= (TextView) findViewById(R.id.txtHour);

        txtno = (TextView) findViewById(R.id.txtQno);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        txtOptA = (TextView) findViewById(R.id.txtOptA);
        txtOptB = (TextView) findViewById(R.id.txtOptB);
        txtOptC = (TextView) findViewById(R.id.txtOptC);
        txtOptD = (TextView) findViewById(R.id.txtOptD);

        optA = (RadioButton) findViewById(R.id.a);
        optB = (RadioButton) findViewById(R.id.b);
        optC = (RadioButton) findViewById(R.id.c);
        optD = (RadioButton) findViewById(R.id.d);



        optionlist = new HashMap<Integer,String>();
        setclock();

    }


    private void setclock(){
//3600000
        //120000

        //1 min = 60000
        new CountDownTimer(60000* 2, 1000) {

            public void onTick(long millisUntilFinished) {
                txtSecond.setText(String.format("%02d", ((millisUntilFinished/1000) % 60)));
                txtMinute.setText(String.format("%02d", ((millisUntilFinished/1000) % 3600) / 60));
                txtHour.setText(String.format("%02d", (millisUntilFinished/1000) / 3600));
            }
            public void onFinish() {
              //  processFinish();

            }
        }.start();
    }


private void intit(){
    Questions.add("What is god?");
    Questions.add("What is your name?");
    Questions.add("How old are you?");
    // Questions.add("If you are dyeing, than which wish you want to full fill?");
    // Questions.add("what is the abbreviation of MAC?");

    Answer1.add("Human");
    Answer1.add("Stone");
    Answer1.add("Inspiration");
    Answer1.add("Inspiration");

    Answer2.add("Krishna");
    Answer2.add("Shawn");
    Answer2.add("Niki");
    Answer2.add("Rinku");

    Answer3.add("26");
    Answer3.add("28");
    Answer3.add("21");
    Answer3.add("22");
}

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(TestScreen.this);
        alertDialog.setTitle("Warning");

        // Setting Dialog Message
        alertDialog.setMessage("Would you like to cancel this test ?\nCurrent test data will be lost!!!");

        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {

                Intent i = new Intent(TestScreen.this,MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);


            }
        });

        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to invoke NO event

            }
        });

        // Showing Alert Message
        alertDialog.show();



    }


//end of main class
}
