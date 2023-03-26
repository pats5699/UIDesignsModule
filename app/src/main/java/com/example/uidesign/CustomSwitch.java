package com.example.uidesign;

import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.SwitchCompat;


public class CustomSwitch {
    private RelativeLayout custom_switch;
    private SwitchCompat mswitch;

    public CustomSwitch(View view) {
        setType(view);
        setSwitchClick();
    }

    private void setType(View view) {
        custom_switch = view.findViewById(R.id.custom_switch);
        mswitch = view.findViewById(R.id.mswitch);
    }

    private void setSwitchClick() {
        custom_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSwitchValue();
            }
        });
    }

    private void setSwitchValue() {
        if (mswitch.isChecked()) {
            mswitch.setChecked(false);
        } else {
            mswitch.setChecked(true);
        }
    }

    public boolean getSwitchValue(){
        return mswitch.isChecked();
    }

    public void setDefault(boolean def){
        mswitch.setChecked(def);
    }
}