package com.example.kim.tabsfragments.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kim.tabsfragments.Model.tips;
import com.example.kim.tabsfragments.R;


import java.util.List;

public class RugbyAdapter extends ArrayAdapter<tips> {
    private List<tips> rugbyList;
    private  Context mCtx;
    private int lastPosition = -1;
    public RugbyAdapter (List<tips> P,Context c)


    {
        super(c , R.layout.  rugbytips,P);
        this.rugbyList=P;
        this.mCtx=c;
    }
    private static class ViewHolder {
        TextView time;
        TextView league;
        TextView match;
        TextView tip;
        TextView odd;
        TextView results;




    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        final View result;

        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater= LayoutInflater.from (mCtx  ) ;

            convertView= inflater.inflate (  R.layout.  rugbytips,null,true );
            holder= new ViewHolder();
            holder.time = (TextView) convertView.findViewById ( R.id.time);
            holder. league = (TextView) convertView.findViewById ( R.id.league);

            holder.match = (TextView) convertView.findViewById ( R.id.match);
            holder. odd = (TextView) convertView.findViewById ( R.id.odd);
            holder. tip = (TextView) convertView.findViewById ( R.id.tip);
            holder.results = (TextView) convertView.findViewById ( R.id.results);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mCtx,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        tips tips=rugbyList.get(position);
        holder.time.setText( tips.getTime () );
        holder.time.setText ( tips.getTime () );
        holder.league.setText ( tips.getLeague () );

        holder. match.setText ( tips.getMatch () );
        holder. tip.setText ( tips.getTip () );
        holder.odd.setText ( tips.getOdd () );
        holder.results.setText ( tips.getResults () );




        return convertView;
    }
}
