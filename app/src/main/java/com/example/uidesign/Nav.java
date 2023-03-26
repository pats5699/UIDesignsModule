package com.example.uidesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Nav extends RecyclerView.Adapter<Nav.ViewHolder>{

    private final ArrayList<String> values;
    private NavClick navClick;
    private Context context;
    private ViewHolder viewHolder;

    Nav(ArrayList<String> values, NavClick navClick, Context context) {
        this.values = values;
        this.navClick = navClick;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav, parent, false);

        this.viewHolder = new ViewHolder(view, navClick);

        return this.viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    void method(){
        viewHolder.animate();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Button exp, msg, so, st, ao;
        LinearLayout mainmenu;
        Animation fromtop, frombottom;
        ImageView userpicbig;
        TextView user, country;
        NavClick navClick;

        public ViewHolder(@NonNull View itemView, NavClick navClick) {
            super(itemView);

            userpicbig = (ImageView) itemView.findViewById(R.id.userpicbig);
            exp = (Button) itemView.findViewById(R.id.exp);
            msg = (Button) itemView.findViewById(R.id.msg);
            so = (Button) itemView.findViewById(R.id.so);
            st = (Button) itemView.findViewById(R.id.st);
            ao = (Button) itemView.findViewById(R.id.ao);

            user = (TextView) itemView.findViewById(R.id.user);
            country = (TextView) itemView.findViewById(R.id.country);

            fromtop = AnimationUtils.loadAnimation(context, R.anim.fromtop);
            frombottom = AnimationUtils.loadAnimation(context, R.anim.frombottom);


            this.navClick = navClick;

            exp.setOnClickListener(this);
            msg.setOnClickListener(this);
            so.setOnClickListener(this);
            st.setOnClickListener(this);
            ao.setOnClickListener(this);
        }

        void animate(){
            exp.startAnimation(frombottom);
            ao.startAnimation(frombottom);
            msg.startAnimation(frombottom);
            st.startAnimation(frombottom);
            so.startAnimation(frombottom);


            user.startAnimation(fromtop);
            country.startAnimation(fromtop);
            userpicbig.startAnimation(fromtop);
        }

        @Override
        public void onClick(View v) {
            navClick.onItemClick(v);

        }
    }


    public interface NavClick{
        void onItemClick(View v);
    }
}
