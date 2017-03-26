package nyu.edu.parcelmanagement;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class ParcelActivity extends SingleFragmentActivity {
    private static final String EXTRA_PARCEL_ID="edu.nyu.parcelmanagement.parcel_id";
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm=getSupportFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.fragment_container);
        if (fragment==null){
            fragment=new ParcelFragment();
            fm.beginTransaction()
                .add(R.id.fragment_container,fragment)
                .commit();
        }
    }*/
    public static Intent newIntent(Context packageContext, UUID parcelId ){
        Intent intent=new Intent(packageContext, ParcelActivity.class);
        intent.putExtra(EXTRA_PARCEL_ID,parcelId);
        return intent;
    }

    @Override
    protected  Fragment createFragment(){
        //return new ParcelFragment();
        UUID parcelId= (UUID) getIntent().getSerializableExtra(EXTRA_PARCEL_ID);
        return ParcelFragment.newInstance(parcelId);
    }
}
