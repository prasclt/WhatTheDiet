package com.microsoft.hack.whatthediet.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.hack.whatthediet.R;
import com.microsoft.hack.whatthediet.utils.Helper;

/**
 * Created by prmeno on 7/26/2016.
 */
public class LoadFoodMenuFragment extends Fragment {

    private TextView mTextViewHeader;
    private RecyclerView mRecyclerViewFoodMenu;
    private FloatingActionButton mFab;

    private Activity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_load_food_menu, container, false);

        mTextViewHeader = (TextView) rootView.findViewById(R.id.textViewHeader);
        mRecyclerViewFoodMenu = (RecyclerView) rootView.findViewById(R.id.recyclerViewFoodMenu);
        mFab = (FloatingActionButton) rootView.findViewById(R.id.fab);

        setListeners();
        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                // Handle successful scan
                Toast toast = Toast.makeText(mActivity, "Content:" + contents + " Format:" + format, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 25, 400);
                toast.show();
            } else if (resultCode == Activity.RESULT_CANCELED) {
                // Handle cancel
                Toast toast = Toast.makeText(mActivity, "Scan was Cancelled!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 25, 400);
                toast.show();


            }
        }
    }

    private void setListeners() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper.launchQRScanner(LoadFoodMenuFragment.this);
            }
        });
    }

    public static LoadFoodMenuFragment instantiate() {
        LoadFoodMenuFragment loadFoodMenuFragment = new LoadFoodMenuFragment();

        return loadFoodMenuFragment;
    }
}
