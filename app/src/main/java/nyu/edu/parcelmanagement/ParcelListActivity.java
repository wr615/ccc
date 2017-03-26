package nyu.edu.parcelmanagement;

import android.support.v4.app.Fragment;

/**
 * Created by weiren on 2017/3/11.
 */

public class ParcelListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new ParcelListFragment();
    }
}
