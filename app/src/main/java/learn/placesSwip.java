package learn;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class placesSwip extends PagerAdapter {

    private int[] resources={
            R.drawable.bank,
            R.drawable.busstation,
            R.drawable.library,
            R.drawable.policestation,
            R.drawable.school,
            R.drawable.publicplaces,
            R.drawable.park,
            R.drawable.postoffice,
            R.drawable.restraunt,
            R.drawable.supermarket,
            R.drawable.hotel};


    private Context ctx;
    private LayoutInflater layoutInflater;

    public placesSwip(Context c){
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


