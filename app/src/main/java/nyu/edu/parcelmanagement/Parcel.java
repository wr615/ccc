package nyu.edu.parcelmanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by weiren on 2017/3/11.
 */

public class Parcel {
    private UUID mId;
    private String mAptNo;
    private Date mArrivalDate;
    private String receivedBy;
    private boolean mPicked;
    private String mPickedBy;
    private Date mPickedDate;

    public Date getmArrivalDate() {
        return mArrivalDate;
    }

    public void setmArrivalDate(Date mArrivalDate) {
        this.mArrivalDate = mArrivalDate;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public String getmPickedBy() {
        return mPickedBy;
    }

    public void setmPickedBy(String mPickedBy) {
        this.mPickedBy = mPickedBy;
    }

    public Date getmPickedDate() {
        return mPickedDate;
    }

    public void setmPickedDate(Date mPickedDate) {
        this.mPickedDate = mPickedDate;
    }

    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public String getmAptNo() {
        return mAptNo;
    }

    public void setmAptNo(String mAptNo) {
        this.mAptNo = mAptNo;
    }



    public boolean ismPicked() {
        return mPicked;
    }

    public void setmPicked(boolean mPicked) {
        this.mPicked = mPicked;
    }

    public Parcel() throws ParseException {
        mId=UUID.randomUUID();
        mArrivalDate=new Date();
    }
}
