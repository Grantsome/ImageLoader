package com.grantsome.imageloader;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by tom on 2017/3/22.
 */

public class MainFragment extends Fragment {

    private ImageView mImageView;

    private List<ResultBean> mResultBeanList;

    private ImageJson mImageJson;

    private String CacheName = "ImageDate";

    private Handler handler = new Handler();

    private ImageAdapter mImageAdapter = new ImageAdapter();

    private GridView mGridView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.INTERNET}, 1);
        }
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fagment, container, false);
        String url = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/1000/1";
        HttpConnnect(url);
        mGridView = (GridView) view.findViewById(R.id.grid_view);
        mGridView.setAdapter(mImageAdapter);
        return view;
    }

    private void HttpConnnect(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (HttpUtil.isNetWorkConntected(getActivity())) {
                    URL mURL = null;
                    try {
                        mURL = new URL(url);
                        getDate(mURL);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    String json = PreUtil.getStringFromDefault(getActivity(), CacheName, "");
                    try {
                        JSONObject jsonObject = new JSONObject(json);
                        parseJsonToImageJson(jsonObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    private void getDate(URL url) {
        try {
            HttpURLConnection mHttpConnection = (HttpURLConnection) url.openConnection();
            mHttpConnection.setRequestMethod("GET");
            mHttpConnection.setConnectTimeout(150000);
            mHttpConnection.setReadTimeout(150000);
            mHttpConnection.setUseCaches(true);
            mHttpConnection.setDoInput(true);
            Log.d("MainFragment","这里执行");
            if(mHttpConnection.getResponseCode()==200) {
                InputStream mInputStream = mHttpConnection.getInputStream();
                String response = getStringFromInputStream(mInputStream);
                Log.d("MainFragment", "response = " + response.toString());
                PreUtil.putStringToDefault(getActivity(), CacheName, response);
                parseJsonToImageJson(response);
            }else {
                Log.d("MainFragment","请求错误");
            }
            //mHttpConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getStringFromInputStream(InputStream inputStream) throws Exception{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(buffer))!=-1){
            byteArrayOutputStream.write(buffer,0,len);
        }
        inputStream.close();
        Log.d("MainFragment","inputStream关闭");
        String response = byteArrayOutputStream.toString();
        byteArrayOutputStream.close();
        return response;
    }

    private void parseJsonToImageJson(String response) {
        Gson gson = new Gson();
        mImageJson = gson.fromJson(response, ImageJson.class);
        mResultBeanList = mImageJson.getResults();
        handler.post(new Runnable() {
            @Override
            public void run() {
                List<ResultBean> resultList = mResultBeanList;
                ResultBean resultBean = new ResultBean();
                //向storiesList里面加入数据
                resultList.add(0, resultBean);
                //把storiesList里面的数据加入到Adapter的方法里面。
                mImageAdapter.addList(resultList);
            }
        });
    }
}