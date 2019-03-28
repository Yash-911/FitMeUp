package com.example.yash_pc.fitmeup;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FriendArrayList extends ArrayAdapter<Friend> {
    private Activity context;
    private List<Friend> friendList;

    public FriendArrayList(Activity context, List<Friend> friendList){
        super(context,R.layout.item_recycler,friendList);
        this.context=context;
        this.friendList=friendList;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.item_recycler,null,true);
        TextView textname=(TextView)listViewItem.findViewById(R.id.name);
        TextView textjob=(TextView)listViewItem.findViewById(R.id.job);
        Friend friend=friendList.get(position);
        textname.setText(friend.getName());
        textjob.setText(friend.getJob());
        return listViewItem;
    }
}
