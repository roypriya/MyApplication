package learn;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class transportSwip extends PagerAdapter {
    private int[] resources={
            R.drawable.ambulance,
            R.drawable.autorickshaw,
            R.drawable.boat,
            R.drawable.bus,
            R.drawable.cycle,
            R.drawable.firetruck,
            R.drawable.helicopter,
            R.drawable.horsecart,
            R.drawable.jeep,
            R.drawable.motorbike,
            R.drawable.motorboat,
            R.drawable.scooter,
            R.drawable.ship,
            R.drawable.taxi,
            R.drawable.train};


    private Context ctx;
    private LayoutInflater layoutInflater;

    public transportSwip(Context c){
        ctx=c;
    }

    @Override
    public int getCount() {
        return resources.length;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=layoutInflater.inflate(R.layout.custom_swip,container,false);
        ImageView imageView=(ImageView) itemView.findViewById(R.id.swip_image);
        //imageView.setImageResource(resources[position]);
        Glide.with(ctx).load(resources[position]).into(imageView);
        container.addView(itemView);
        return itemView;

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }


    }


