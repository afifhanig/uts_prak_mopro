package com.example.fluks77.uts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RVadapter extends RecyclerView.Adapter<RVadapter.ViewHolder> {

    private ArrayList<String> mGambar = new ArrayList<>();
    private ArrayList<String> mNamaP = new ArrayList<>();
    private ArrayList<String> mPosP = new ArrayList<>();
    private ArrayList<String> mNatP = new ArrayList<>();
    private Context mContext;

    public RVadapter(Context mContext, ArrayList<String> mGambar, ArrayList<String> mNamaP, ArrayList<String> mPosP, ArrayList<String> mNatP) {
        this.mGambar = mGambar;
        this.mNamaP = mNamaP;
        this.mPosP = mPosP;
        this.mNatP = mNatP;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listplayer, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mGambar.get(position))
                .into(holder.image);

        holder.player.setText(mNamaP.get(position));
        holder.posisition.setText(mPosP.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mNamaP.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, Detail.class);
                intent.putExtra("picture", mGambar.get(position));
                intent.putExtra("Nama", mNamaP.get(position));
                intent.putExtra("Posisi", mPosP.get(position));
                intent.putExtra("Nasional", mNatP.get(position));
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mNamaP.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView player;
        TextView posisition;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.foto_pemain);
            player = itemView.findViewById(R.id.nama_pemain);
            posisition = itemView.findViewById(R.id.posisi_pemain);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
