package com.example.asus.iblteam;

import android.content.Context;
        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.bumptech.glide.Glide;

        import java.util.ArrayList;

public class IBLAdapter extends RecyclerView.Adapter<IBLAdapter.ViewHolder> {

    private Context context;
    private ArrayList<IBLModel> iblList;

    public IBLAdapter(Context context){
        this.context = context;
    }

    public ArrayList<IBLModel> getIBLList(){
        return iblList;
    }

    public void setIBLList(ArrayList<IBLModel> iblList){
        this.iblList = iblList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_list,viewGroup,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context).load(getIBLList().get(i).getThumbnail()).into(viewHolder.ivThumbail);
        viewHolder.tvTitle.setText(getIBLList().get(i).getTitle());
        viewHolder.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,IBLActivity.class);


                intent.putExtra("img_url", getIBLList().get(i).getThumbnail());
                intent.putExtra("title",getIBLList().get(i).getTitle());
                intent.putExtra("detail",getIBLList().get(i).getDetail());
                intent.putExtra("link",getIBLList().get(i).getLink());
                context.startActivity(intent);
            }
        });

        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String profile = "Liat lebih lengkap profile tim " +getIBLList().get(i).getTitle() +" di "  +getIBLList().get(i).getLink();
                intent.putExtra(Intent.EXTRA_TEXT,profile);
                context.startActivity(Intent.createChooser(intent,"Share Using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getIBLList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumbail;
        TextView tvTitle,tvLink;
        Button btnShow,btnShare;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbail = itemView.findViewById(R.id.iv_nblteam);
            tvTitle = itemView.findViewById(R.id.team_name);
            btnShow = itemView.findViewById(R.id.btn_lihat);
            btnShare = itemView.findViewById(R.id.btn_share);
            tvLink = itemView.findViewById(R.id.link_team);

        }
    }
}
