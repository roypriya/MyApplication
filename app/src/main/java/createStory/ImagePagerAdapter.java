package createStory;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImagePagerAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Uri> imageList;
    public ImagePagerAdapter(Context context, ArrayList<Uri> imageList) {
        this.context = context;
        this.imageList = imageList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d("Image Uri", String.valueOf(imageList.size()));
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((LinearLayout)o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView  = layoutInflater.inflate(R.layout.create_slide,container,false);
        ImageView imageView = itemView.findViewById(R.id.slideImage);
//        Picasso.get().load(imageList.get(position)).into(imageView);
        Glide.with(context).load(imageList.get(position)).into(imageView);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
