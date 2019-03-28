package com.example.yash_pc.fitmeup;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class dietAdapter extends RecyclerView.Adapter <dietAdapter.dietviewholder>{
    String[] Name;
    String[] No;
    String[] gym;
    String[] experience;

    public dietAdapter(String[] Name,String[] No,String[] gym,String[] experience)
    {
        this.Name=Name;
        this.No=No;
        this.gym=gym;
        this.experience=experience;
    }

    @Override
    public dietviewholder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.diet_layout, viewGroup, false);
        return new dietviewholder(view);
    }

    @Override
    public void onBindViewHolder(dietviewholder dietviewholder, int i) {
        String name=Name[i];
        dietviewholder.tx1.setText(name);
        String no=No[i];
        dietviewholder.tx1.setText(no);
        String Gym=gym[i];
        dietviewholder.tx1.setText(Gym);
        String Experience=experience[i];
        dietviewholder.tx1.setText(Experience);


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class dietviewholder extends RecyclerView.ViewHolder{
        ImageView imgicon;
        TextView tx1,tx2,tx3,tx4;

        public dietviewholder(View itemView) {
            super(itemView);
            imgicon=(ImageView)itemView.findViewById(R.id.icon_only);
            tx1=(TextView)itemView.findViewById(R.id.tx1);
            tx2=(TextView)itemView.findViewById(R.id.tx2);
            tx3=(TextView)itemView.findViewById(R.id.tx3);
            tx4=(TextView)itemView.findViewById(R.id.tx4);
        }
    }
}
