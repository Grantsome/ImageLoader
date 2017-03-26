package com.grantsome.imageloader;

import android.support.v4.app.Fragment;

public class MainActivity extends SuperFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }


}
