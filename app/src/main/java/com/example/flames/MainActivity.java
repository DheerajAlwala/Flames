package com.example.flames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText name1,name2,resultText;
    Button calculate;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name1=findViewById(R.id.name1);
        name2=findViewById(R.id.name2);
        calculate=findViewById(R.id.calculate);
        resultText=findViewById(R.id.result);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result=checkFlames(name1.getText().toString(),name2.getText().toString());
                resultText.setText(result.toString().toUpperCase());
            }
        });
    }

    private String checkFlames(String name1, String name2) {
        String result = null;
        StringBuffer s1=new StringBuffer(name1);
        StringBuffer s2=new StringBuffer(name2);
        char c,d,e='\0';
        for(int i=0;i<s1.length();i++)
        {
            c=s1.charAt(i);
            for(int j=0;j<s2.length();j++)
            {
                d=s2.charAt(j);
                if(c==d)
                {
                    s1.deleteCharAt(i);
                    s2.deleteCharAt(j);
                    i--;
                    j--;
                    break;
                }
            }
        }
        s1=s1.append(s2);
        int k=6,l=0;
        String s3="FLAMES";
        while(k>1)
        {
            for(int m=1;m<s1.length();m++)
            {
                if(s3.charAt(l)!='X')
                {
                    l++;
                    if(l==6)
                        l=0;
                }
                else
                {
                    l++;
                    if(l==6)
                        l=0;
                    m--;
                }
            }
            while(s3.charAt(l)=='X')
            {
                l++;
                if(l==6)
                    l=0;
            }
            s3=s3.substring(0,l)+"X"+s3.substring(l+1);
            k--;
        }
        for(int i=0;i<s3.length();i++)
        {
            if(s3.charAt(i)!='X')
                e=s3.charAt(i);
        }
        switch(e)
        {
            case 'F':result="Friends";
                break;
            case 'L':result="Love";
                break;
            case 'A':result="Affection";
                break;
            case 'M':result="Marriage";
                break;
            case 'E':result="Enemies";
                break;
            case 'S':result="Siblings";
                break;
            default :break;
        }
        return result;

    }

}
