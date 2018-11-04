package com.example.fluks77.uts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getIncIntent();
    }

    private void getIncIntent(){
        if (getIntent().hasExtra("picture")&&getIntent().hasExtra("Nama")&&getIntent().hasExtra("Posisi")&&getIntent().hasExtra("Nasional")){
            String img = getIntent().getStringExtra("picture");
            String Nm = getIntent().getStringExtra("Nama");
            String Ps = getIntent().getStringExtra("Posisi");
            String Ns = getIntent().getStringExtra("Nasional");

            setAll(img, Nm, Ps, Ns);
        }
    }

    private void setAll(String img, String Nm, String Ps, String Ns){
        TextView pl_name = findViewById(R.id.playernm);
        pl_name.setText(Nm);
        TextView pl_pos = findViewById(R.id.playerps);
        pl_pos.setText(Ps);
        TextView pl_nas = findViewById(R.id.playersnation);
        pl_nas.setText(Ns);

        ImageView imgView = findViewById(R.id.pic);
        Glide.with(this)
                .asBitmap()
                .load(img)
                .into(imgView);


    }
}
