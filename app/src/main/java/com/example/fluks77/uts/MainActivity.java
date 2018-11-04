package com.example.fluks77.uts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mPic = new ArrayList<>();
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mPos = new ArrayList<>();
    private ArrayList<String> mNation = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTheimage();
    }

    private void initTheimage(){
        mPic.add("https://short-biography.com/wp-content/uploads/david-de-gea/David-de-Gea.jpg");
        mName.add("David De Gea");
        mPos.add("Goal Keeper");
        mNation.add("Spanyol");

        mPic.add("https://tmssl.akamaized.net/images/portrait/originals/183288-1469631475.jpg");
        mName.add("Luke Shaw");
        mPos.add("Left Back");
        mNation.add("England");

        mPic.add("https://tmssl.akamaized.net/images/portrait/originals/103427-1470219479.jpg");
        mName.add("Chris Smalling");
        mPos.add("Center Back");
        mNation.add("England");

        mPic.add("https://www.manutd.com/AssetPicker/images/0/0/10/244/718040/775205331GP857_Man_Utd_selects1536050204114.jpg");
        mName.add("Victor Lindelof");
        mPos.add("Center Back");
        mNation.add("Swedia");

        mPic.add("https://tmssl.akamaized.net/images/portrait/originals/33544-1484662583.jpg");
        mName.add("Antonio Valencia");
        mPos.add("Right Back");
        mNation.add("Ekuador");

        mPic.add("https://tmssl.akamaized.net/images/portrait/originals/74683-1498839702.jpg");
        mName.add("Nemanja Matic");
        mPos.add("Defensive Midfielder");
        mNation.add("Serbia");

        mPic.add("https://i.pinimg.com/originals/cd/29/78/cd2978629e0a50f4a99d7f7e73155d96.jpg");
        mName.add("Paul Pogba");
        mPos.add("Attacking Midfielder");
        mNation.add("France");

        mPic.add("https://upload.wikimedia.org/wikipedia/commons/d/dd/Fellaini_2018_2_%28cropped%29.jpg");
        mName.add("Marouane Fellaini");
        mPos.add("Defensive Midfielder");
        mNation.add("Belgia");

        mPic.add("https://pbs.twimg.com/media/Dh-9jSHXUAE6Rc3.jpg");
        mName.add("Anthony Martial");
        mPos.add("Left Winger");
        mNation.add("France");

        mPic.add("https://i.pinimg.com/originals/14/d5/a9/14d5a94e4fec5b4f347764bcd87ef820.jpg");
        mName.add("Marcus Rashford");
        mPos.add("Right Winger");
        mNation.add("England");

        mPic.add("https://cdn.idntimes.com/content-images/post/20180619/15f6485f953bc510bd4f0d874fcbe039.jpg");
        mName.add("Romelu Lukaku");
        mPos.add("Center Forward");
        mNation.add("Belgia");

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RVadapter adapter = new RVadapter(this, mPic, mName, mPos, mNation );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.myprof){
            startActivity(new Intent(this, SelfProfile.class));
        }
        return true;
    }
}
