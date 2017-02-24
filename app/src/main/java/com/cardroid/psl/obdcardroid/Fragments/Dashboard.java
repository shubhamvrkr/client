package com.cardroid.psl.obdcardroid.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cardroid.psl.obdcardroid.MainActivity;
import com.cardroid.psl.obdcardroid.MockClasses.DashboardObj;
import com.cardroid.psl.obdcardroid.R;

import java.util.ArrayList;
import java.util.List;
import com.cardroid.psl.obdcardroid.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Dashboard.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Dashboard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Dashboard extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RelativeLayout rpmtile,ecttile,loadtile,maptile,stfttile,ltfttile,batteryvoltagetile,duedatetile;
    TextView rpmtitle,ectitile,loadtitle,maptitle,stfttitle,ltfttitle,batteryvoltagetitle,duedatetitle;
    List<DashboardObj> list = new ArrayList<DashboardObj>();
    private int counter = 0;
    private OnFragmentInteractionListener mListener;

    public Dashboard() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Dashboard.
     */
    // TODO: Rename and change types and number of parameters

    public static Dashboard newInstance(String param1, String param2) {
        Dashboard fragment = new Dashboard();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initialize(view);
        list = MainActivity.getData();
        if(list.isEmpty()){
            setDashboardTiles();
        }else{


        }

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public void initialize(View view){

        rpmtile = (RelativeLayout) view.findViewById(R.id.rpmtile);
        ecttile = (RelativeLayout) view.findViewById(R.id.ecttile);
        loadtile = (RelativeLayout) view.findViewById(R.id.loadtile);
        maptile = (RelativeLayout) view.findViewById(R.id.maptile);
        stfttile = (RelativeLayout) view.findViewById(R.id.stfttile);
        ltfttile = (RelativeLayout) view.findViewById(R.id.ltfttile);
        batteryvoltagetile = (RelativeLayout) view.findViewById(R.id.batteryvoltagetile);
        duedatetile = (RelativeLayout) view.findViewById(R.id.duedatetile);


        rpmtitle =(TextView) view.findViewById(R.id.rpmtitile);
        ectitile = (TextView) view.findViewById(R.id.ecttitile);
        loadtitle = (TextView) view.findViewById(R.id.loadtitile);
        maptitle = (TextView) view.findViewById(R.id.maptitile);
        stfttitle = (TextView) view.findViewById(R.id.stfttitile);
        ltfttitle = (TextView) view.findViewById(R.id.ltfttitle);
        batteryvoltagetitle = (TextView) view.findViewById(R.id.batterylifetitle);
        duedatetitle = (TextView) view.findViewById(R.id.duedatetitle);


    }
    public void setDashboardTiles(){




    }
}
