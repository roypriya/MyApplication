package learn;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

/**
 * Created by Rishabh on 2/13/2018.
 */

public class sportSwip extends PagerAdapter {

    private Context ctx;
    private LayoutInflater inflater;

    private int[] resources={
            R.drawable.chess,
            R.drawable.cricket,
            R.drawable.cycling,
            R.drawable.dirtbike,
            R.drawable.golf,
            R.drawable.americanfootball,
            R.drawable.tennis,
            R.drawable.swimming,
            R.drawable.volleyball,
            R.drawable.football,
            R.drawable.basketball,
            R.drawable.snooker
    };


    public sportSwip(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return resources.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       inflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View itemView=inflater.inflate(R.layout.custom_swip,container,false);
        ImageView imageView=(ImageView)itemView.findViewById(R.id.swip_image);
        Glide.with(ctx).load(resources[position]).into(imageView);
        container.addView(itemView);
        return itemView;
    }
}
