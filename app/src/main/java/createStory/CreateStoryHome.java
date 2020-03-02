package createStory;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CreateStoryHome extends AppCompatActivity {
    private FloatingActionButton imagePicker;
    private ViewPager viewPager;
    int IMAGE_PICK_MULTIPLE=1;
    String encodedImage;
    private List<String> encodedImageList;
    private ImagePagerAdapter pagerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_story_home);
        imagePicker=findViewById(R.id.pickImage);
        viewPager=findViewById(R.id.slideViewPager);
        imagePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"),IMAGE_PICK_MULTIPLE);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        try {
            if (requestCode==IMAGE_PICK_MULTIPLE && resultCode==RESULT_OK && data!=null){
                //when an image is picked
                String[] fileColumnPath={MediaStore.Images.Media.DATA};
                encodedImageList=new ArrayList<>();

                //checking if image is picked or not

                if (data.getData()!=null){

                    //Get Image Path
                    Uri mImageUri=data.getData();

                    //Use cursor to move get through images
                    Cursor cursor=getContentResolver().query(mImageUri,fileColumnPath,null,null,null);
                    cursor.moveToFirst();
                    int columnIndex=cursor.getColumnIndex(fileColumnPath[0]);
                    encodedImage=cursor.getString(columnIndex);
                    cursor.close();
                    ArrayList<Uri> imageUris=new ArrayList<>();
                    imageUris.add(mImageUri);
                    pagerAdapter = new ImagePagerAdapter(getApplicationContext(),imageUris);
                    viewPager.setAdapter(pagerAdapter);


                }

                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        if (data.getClipData()!=null){
                            ClipData clipData=data.getClipData();
                            ArrayList<Uri> mImageUris=new ArrayList<>();
                            Log.v("LOG_TAG","Size of ClipData = "+clipData.getItemCount());
                            for (int i=0;i<clipData.getItemCount();i++){


                                ClipData.Item item=clipData.getItemAt(i);
                                Uri imageUri=item.getUri();
                                mImageUris.add(imageUri);

                                Cursor cursor=getContentResolver().query(imageUri,fileColumnPath,null,null,null);
                                cursor.moveToFirst();

                                int columnIndex=cursor.getColumnIndex(fileColumnPath[0]);
                                encodedImage=cursor.getString(columnIndex);
                                encodedImageList.add(encodedImage);
                                cursor.close();
                                pagerAdapter = new ImagePagerAdapter(getApplicationContext(),mImageUris);

                                viewPager.setAdapter(pagerAdapter);




                            }

                            Log.v("LOG_TAG","No of Selected Images "+ mImageUris.size());
                        }
                    }
                }
            }
            else {
                Toast.makeText(this, "You havent picked any Image", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onActivityResult(requestCode,requestCode,data);
    }

}
