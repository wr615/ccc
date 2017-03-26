package nyu.edu.parcelmanagement;

import android.content.Context;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by weiren on 2017/3/11.
 */

public class ParcelLab {
    private static ParcelLab sParcelLab;
    private List<Parcel> mParcels;

    public static ParcelLab get(Context context) throws ParseException {
        if (sParcelLab==null){
            sParcelLab=new ParcelLab(context);
        }
        return sParcelLab;
    }
    private ParcelLab(Context context) throws ParseException {
        mParcels=new ArrayList<>();
        for (int i=0;i<100;i++){
            Parcel parcel=new Parcel();
            parcel.setmAptNo("APT "+i);
            parcel.setmPicked(i%2==0);
            mParcels.add(parcel);
        }
    }
    public List<Parcel> getParcels(){
        return mParcels;
    }
    public  Parcel getParcel(UUID id){
        for (Parcel parcel:mParcels){
            if (parcel.getmId().equals(id))
                return parcel;
        }
        return null;
    }
}
