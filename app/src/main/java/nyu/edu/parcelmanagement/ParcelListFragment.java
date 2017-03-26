package nyu.edu.parcelmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.util.List;

/**
 * Created by weiren on 2017/3/11.
 */
public class ParcelListFragment extends Fragment {
    private RecyclerView mParcelRecylerView;
    private ParcelAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_parcel_list,container,false);
        mParcelRecylerView= (RecyclerView) view.findViewById(R.id.parcel_recycler_view);
        mParcelRecylerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        try {
            updateUI();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        try {
            updateUI();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private void updateUI() throws ParseException {
        ParcelLab parcelLab=ParcelLab.get(getActivity());
        List<Parcel> parcels=parcelLab.getParcels();

        if(mAdapter==null){
            mAdapter=new ParcelAdapter(parcels);
            mParcelRecylerView.setAdapter(mAdapter);
        }
        else
            mAdapter.notifyDataSetChanged();
    }

    private class ParcelHolder extends RecyclerView.ViewHolder
                    implements View.OnClickListener{
        private TextView mAptNoTextView;
        private TextView mArrivalDateTextView;
        private Parcel mParcel;
        private ImageView mPickedImageView;

        public ParcelHolder(LayoutInflater inflater,ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_parcel,parent,false));
            mAptNoTextView= (TextView) itemView.findViewById(R.id.parcel_aptno);
            mArrivalDateTextView= (TextView) itemView.findViewById(R.id.parcel_arrivaldate);
            mPickedImageView= (ImageView) itemView.findViewById(R.id.parcel_picked);
            itemView.setOnClickListener(this);
        }

        public void bind(Parcel parcel){
            mParcel=parcel;
            mAptNoTextView.setText(mParcel.getmAptNo());
            mArrivalDateTextView.setText(mParcel.getmArrivalDate().toString());
            mPickedImageView.setVisibility(parcel.ismPicked()?View.VISIBLE:View.GONE);
        }

        @Override
        public void onClick(View v) {
            //Toast.makeText(getActivity(),mParcel.getmAptNo()+" clicked", Toast.LENGTH_SHORT).show();
            //Intent intent=new Intent(getActivity(),ParcelActivity.class);
            //Intent intent=ParcelActivity.newIntent(getActivity(),mParcel.getmId());
            Intent intent=ParcelPagerActivity.newIntent(getActivity(),mParcel.getmId());
            startActivity(intent);
        }
    }

    private class ParcelAdapter extends RecyclerView.Adapter<ParcelHolder>{
        private List<Parcel> mParcels;

        public ParcelAdapter(List<Parcel> parcels){
            mParcels=parcels;
        }
        @Override
        public ParcelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            return new ParcelHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(ParcelHolder holder, int position) {
            Parcel parcel=mParcels.get(position);
            holder.bind(parcel);
        }

        @Override
        public int getItemCount() {
            return mParcels.size();
        }
    }
}
