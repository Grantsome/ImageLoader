package com.grantsome.imageloader;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by tom on 2017/3/22.
 */

public class MainFragment extends Fragment {

    private ImageLoader mImageLoader;

    private ImageView mImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.INTERNET},1);
        }
        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.main_fagment,container,false);
        mImageView = (ImageView) view.findViewById(R.id.iv);
        String url = "https://pic4.zhimg.com//v2-fb17ef8809e9631bbcb8608f014f9edf.jpg";
        mImageLoader = ImageLoader.get(getActivity(),url,mImageView);
        Log.d("MainActivity","ImageLoader");
        return view;
    }

}
