package nyu.edu.parcelmanagement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

/**
 * Created by weiren on 2017/3/21.
 */

public class ParcelPagerActivity extends AppCompatActivity{
    private static final String EXTRA_PARCEL_ID="edu.nyu.parcelmanagement.parcel_id";

    private ViewPager mViewPager;
    private List<Parcel> mParcels;

    public static Intent newIntent(Context packageContext, UUID parcelId){
        Intent intent=new Intent(packageContext, ParcelPagerActivity.class);
        intent.putExtra(EXTRA_PARCEL_ID,parcelId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcel_pager);

        UUID parcelId= (UUID) getIntent().getSerializableExtra(EXTRA_PARCEL_ID);

        mViewPager= (ViewPager) findViewById(R.id.parcel_view_pager);
        try {
            mParcels=ParcelLab.get(this).getParcels();
            FragmentManager fragmentManager=getSupportFragmentManager();
            mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
                @Override
                public Fragment getItem(int position) {
                    Parcel parcel=mParcels.get(position);
                    return ParcelFragment.newInstance(parcel.getmId());
                }

                @Override
                public int getCount() {
                    return mParcels.size();
                }
            });
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i=0;i<mParcels.size();i++){
            if(mParcels.get(i).getmId().equals(parcelId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
