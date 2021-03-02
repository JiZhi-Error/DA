package com.tencent.mm.live.core.core.trtc.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

public abstract class BaseSettingFragmentDialog extends DialogFragment {
    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    @Override // android.support.v4.app.Fragment, android.support.v4.app.DialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 0);
    }

    @Override // android.support.v4.app.Fragment, android.support.v4.app.DialogFragment
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            window.setAttributes(attributes);
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.getWindow().setLayout((int) (((double) displayMetrics.widthPixels) * 0.9d), (int) (((double) displayMetrics.heightPixels) * 0.8d));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(getLayoutId(), viewGroup, false);
    }
}
