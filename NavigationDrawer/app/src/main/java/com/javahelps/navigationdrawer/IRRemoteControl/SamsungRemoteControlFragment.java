package com.javahelps.navigationdrawer.IRRemoteControl;

import com.javahelps.navigationdrawer.ButtonValue;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.util.SparseArray;
import android.widget.Button;
import android.widget.ImageButton;
import android.hardware.ConsumerIrManager;
import android.widget.TextView;
import android.widget.Toast;

import com.javahelps.navigationdrawer.OnFragmentInteractionListener;
import com.javahelps.navigationdrawer.R;

import org.w3c.dom.Text;


public class SamsungRemoteControlFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ImageButton buttonPower;
    ImageButton buttonChannelDown;
    SparseArray<String> irData;
    ConsumerIrManager mCir;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SamsungRemoteControlFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SamsungRemoteControlFragment newInstance(String param1, String param2) {
        SamsungRemoteControlFragment fragment = new SamsungRemoteControlFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    public SamsungRemoteControlFragment() {
        // Required empty public constructor
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
        View InputFragmentView = inflater.inflate(R.layout.fragment_samsungremotecontrol, container, false);
       // buttonPower = (ImageButton) InputFragmentView.findViewById(R.id.buttonPower);
        //buttonChannelDown = (ImageButton) InputFragmentView.findViewById(R.id.buttonChannelDown);


        //InputFragmentView.findViewById(R.id.buttonPower).setOnClickListener(cameraListener);
        //InputFragmentView.findViewById(R.id.buttonChannelDown).setOnClickListener(cameraListener);

        irData = new SparseArray<String>();
        irData.put(R.id.buttonPower,hex2dec(ButtonValue.SAMSUNG_POWER.getKey().toString()));
        irData.put(R.id.buttonChannel1,hex2dec(ButtonValue.SAMSUNG_CHANNEL1.getKey().toString()));
        irData.put(R.id.buttonChannel2,hex2dec(ButtonValue.SAMSUNG_CHANNEL2.getKey().toString()));
        irData.put(R.id.buttonChannel3,hex2dec(ButtonValue.SAMSUNG_CHANNEL3.getKey().toString()));
        irData.put(R.id.buttonChannel4,hex2dec(ButtonValue.SAMSUNG_CHANNEL4.getKey().toString()));
        irData.put(R.id.buttonChannel5,hex2dec(ButtonValue.SAMSUNG_CHANNEL5.getKey().toString()));
        irData.put(R.id.buttonChannel6,hex2dec(ButtonValue.SAMSUNG_CHANNEL6.getKey().toString()));
        irData.put(R.id.buttonChannel7,hex2dec(ButtonValue.SAMSUNG_CHANNEL7.getKey().toString()));
        irData.put(R.id.buttonChannel8,hex2dec(ButtonValue.SAMSUNG_CHANNEL8.getKey().toString()));
        irData.put(R.id.buttonChannel9,hex2dec(ButtonValue.SAMSUNG_CHANNEL9.getKey().toString()));
        irData.put(R.id.buttonChannel0,hex2dec(ButtonValue.SAMSUNG_CHANNEL9.getKey().toString()));
        irData.put(R.id.buttonPower,hex2dec(ButtonValue.SAMSUNG_POWER.getKey().toString()));
        irData.put(R.id.buttonEnter,hex2dec(ButtonValue.SAMSUNG_ENTER.getKey().toString()));
        irData.put(R.id.buttonChannelUp,hex2dec(ButtonValue.SAMSUNG_CHANNELUP.getKey().toString()));
        irData.put(R.id.buttonChannelDown,hex2dec(ButtonValue.SAMSUNG_CHANNELDOWN.getKey().toString()));
        irData.put(R.id.buttonVolumeUp,hex2dec(ButtonValue.SAMSUNG_VOLUMEUP.getKey().toString()));
        irData.put(R.id.buttonVolumeDown,hex2dec(ButtonValue.SAMSUNG_VOLUMEDOWN.getKey().toString()));
        irData.put(R.id.buttonMenu,hex2dec(ButtonValue.SAMSUNG_MENU.getKey().toString()));
        irData.put(R.id.buttonChannelDown,hex2dec(ButtonValue.SAMSUNG_CHANNELDOWN.getKey().toString()));
        irData.put(R.id.buttonChannelUp,hex2dec(ButtonValue.SAMSUNG_CHANNELUP.getKey().toString()));
        irData.put(R.id.buttonChannelDown,hex2dec(ButtonValue.SAMSUNG_CHANNELDOWN.getKey().toString()));

        irData.put(
                R.id.buttonChannelDown,
                hex2dec(ButtonValue.SAMSUNG_CHANNELDOWN.getKey().toString()));

        mCir = (ConsumerIrManager) getActivity().getApplicationContext().getSystemService(Context.CONSUMER_IR_SERVICE);
        return InputFragmentView;
    }

    public void onViewCreated(View view, Bundle savedinstanceState)
    {
        //Set what to do when clicked
        OnClickListener cameraListener = new OnClickListener(){
            public void onClick(View v){
                irSend(v);
            }
        };
        // For each imaggebutton in the viewgroup add the onclicklistener
        ViewGroup group = (ViewGroup)getView().findViewById(R.id.samsung_remote_layout);
        View v;
        for (int i = 0; i < group.getChildCount(); i++) {
            v = group.getChildAt(i);
                if(v instanceof ImageButton) {
                    v.setOnClickListener(cameraListener);
                }
            }
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
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public void irSend(View view) {
        String data = irData.get(view.getId());
        if (data != null) {
            String values[] = data.split(",");
            int[] pattern = new int[values.length - 1];
            for (int i = 0; i < pattern.length; i++) {
                pattern[i] = Integer.parseInt(values[i + 1]);
            }
            mCir.transmit(Integer.parseInt(values[0]), pattern);
            Log.v("Verstuurd","IRCODE");
        }
    }

    protected String hex2dec(String irData) {
        List<String> list = new ArrayList<String>(Arrays.asList(irData
                .split(" ")));
        list.remove(0); // dummy
        int frequency = Integer.parseInt(list.remove(0), 16); // frequency
        list.remove(0); // seq1
        list.remove(0); // seq2
        for (int i = 0; i < list.size(); i++) {
            list.set(i, Integer.toString(Integer.parseInt(list.get(i), 16)));
        }
        frequency = (int) (1000000 / (frequency * 0.241246));
        list.add(0, Integer.toString(frequency));irData = "";
        for (String s : list) {
            irData += s + ",";
        }
        return irData;
    }
}
