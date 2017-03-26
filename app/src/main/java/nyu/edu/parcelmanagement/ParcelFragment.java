package nyu.edu.parcelmanagement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by weiren on 2017/3/11.
 */

public class ParcelFragment extends Fragment {
    private Parcel mParcel;
    private EditText mAptNoField;
    private EditText mArrivalDateField;
    private EditText mReceivedByField;
    private CheckBox mPickedCheckBox;
    private EditText mPickedByField;
    private EditText mPickedDateField;
    private static final String ARG_PARCEL_ID="parcel_id";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mParcel=new Parcel();
        UUID parcelId= (UUID) getArguments().getSerializable(ARG_PARCEL_ID);
        try {
            mParcel=ParcelLab.get(getActivity()).getParcel(parcelId);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frament_parcel,container,false);

        mAptNoField=(EditText)v.findViewById(R.id.apt_no);
        mAptNoField.setText(mParcel.getmAptNo());
        mAptNoField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mParcel.setmAptNo(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mArrivalDateField=(EditText)v.findViewById(R.id.arrival_date);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String sDate=sdf.format(mParcel.getmArrivalDate());
        mArrivalDateField.setText(sDate);

        mArrivalDateField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //mParcel.setmArrivalDate(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mReceivedByField=(EditText)v.findViewById(R.id.received_by);
        mReceivedByField.setText(mParcel.getReceivedBy());
        mReceivedByField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mParcel.setReceivedBy(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

            mPickedCheckBox=(CheckBox)v.findViewById(R.id.parcel_picked);
            mPickedCheckBox.setChecked(mParcel.ismPicked());
            mPickedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mParcel.setmPicked(isChecked);
            }
        });

            mPickedByField=(EditText)v.findViewById(R.id.picked_by);
            mPickedByField.setText(mParcel.getmPickedBy());
            mPickedByField.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    mParcel.setmPickedBy(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        return v;
    }

    public static ParcelFragment newInstance(UUID parcelId){
        Bundle args=new Bundle();
        args.putSerializable(ARG_PARCEL_ID,parcelId);
        ParcelFragment fragment=new ParcelFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
