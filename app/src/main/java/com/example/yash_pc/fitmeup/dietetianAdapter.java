package com.example.yash_pc.fitmeup;

import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.List;

public abstract class dietetianAdapter extends RecyclerView.Adapter<dietetianAdapter.ViewHolder>  {
    private List<dietetian> dietetianList;
    private Activity activity;

    public dietetianAdapter(Activity activity, List<dietetian> dietetianList) {
        this.dietetianList = dietetianList;
        this.activity = activity;
    }

    @Override
    public dietetianAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        //inflate your layout and pass it to view holder
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.diet_layout, viewGroup, false);
        dietetianAdapter.ViewHolder viewHolder = new dietetianAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(dietetianAdapter.ViewHolder viewHolder, int position) {

        //setting data to view holder elements
        viewHolder.Name1.setText(dietetianList.get(position).getName1(position));
        viewHolder.No.setText(dietetianList.get(position).getNo(position));
        viewHolder.gym.setText(dietetianList.get(position).getGym(position));
        viewHolder.experience.setText(dietetianList.get(position).getExperience(position));


        //set on click listener for each element
        viewHolder.container.setOnClickListener(onClickListener(position));
    }

    private void setDataToView(TextView name, TextView no,TextView gym,TextView experience, int position) {
        name.setText(dietetianList.get(position).getName1(position));
        no.setText(dietetianList.get(position).getNo(position));
        gym.setText(dietetianList.get(position).getGym(position));
        experience.setText(dietetianList.get(position).getExperience(position));

    }

    @Override
    public int getItemCount() {
        return (null != dietetianList ? dietetianList.size() : 0);
    }

    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.diet_layout);
                dialog.setTitle("Position " + position);
                dialog.setCancelable(true); // dismiss when touching outside Dialog

                // set the custom dialog components - texts and image
                TextView name = (TextView) dialog.findViewById(R.id.tx1);
                TextView no = (TextView) dialog.findViewById(R.id.tx2);
                TextView gym = (TextView) dialog.findViewById(R.id.tx3);
                TextView experience = (TextView) dialog.findViewById(R.id.tx4);

                setDataToView(name,no,gym,experience,position);

                dialog.show();
            }
        };
    }

    public abstract View getView(int position, View convertView, ViewGroup parent);

    /**
     * View holder to display each RecylerView item
     */
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Name1;
        public TextView No;
        public TextView gym;
        public TextView experience;
        private ImageView imageView;
        private View container;

        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView2);
            Name1= (TextView) view.findViewById(R.id.tx1);
            No = (TextView) view.findViewById(R.id.tx2);
            gym= (TextView) view.findViewById(R.id.tx3);
            experience= (TextView) view.findViewById(R.id.tx4);
            container = view.findViewById(R.id.card_view);
        }
    }
}

