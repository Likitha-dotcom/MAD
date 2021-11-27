package com.example.fragments_lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    First frag1;
    second frag2;
    Button button;
    int showingfrag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);

        frag1=new First();
        frag2=new second();

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.cl,frag1);
        fragmentTransaction.commit();
        showingfrag=1;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                if(showingfrag==1){
                    fragmentTransaction.replace(R.id.cl,frag2);
                    fragmentTransaction.commit();
                    showingfrag=2;
                }
                else{
                    fragmentTransaction.replace(R.id.cl,frag1);
                    fragmentTransaction.commit();
                    showingfrag=1;
                }

            }
        });
    }



}