package com.facebook.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FragmentWrapper {
    private Fragment nativeFragment;
    private android.support.v4.app.Fragment supportFragment;

    public FragmentWrapper(android.support.v4.app.Fragment fragment) {
        AppMethodBeat.i(7671);
        Validate.notNull(fragment, "fragment");
        this.supportFragment = fragment;
        AppMethodBeat.o(7671);
    }

    public FragmentWrapper(Fragment fragment) {
        AppMethodBeat.i(7672);
        Validate.notNull(fragment, "fragment");
        this.nativeFragment = fragment;
        AppMethodBeat.o(7672);
    }

    public Fragment getNativeFragment() {
        return this.nativeFragment;
    }

    public android.support.v4.app.Fragment getSupportFragment() {
        return this.supportFragment;
    }

    public void startActivityForResult(Intent intent, int i2) {
        AppMethodBeat.i(7673);
        if (this.supportFragment != null) {
            this.supportFragment.startActivityForResult(intent, i2);
            AppMethodBeat.o(7673);
            return;
        }
        this.nativeFragment.startActivityForResult(intent, i2);
        AppMethodBeat.o(7673);
    }

    public final Activity getActivity() {
        AppMethodBeat.i(7674);
        if (this.supportFragment != null) {
            FragmentActivity activity = this.supportFragment.getActivity();
            AppMethodBeat.o(7674);
            return activity;
        }
        Activity activity2 = this.nativeFragment.getActivity();
        AppMethodBeat.o(7674);
        return activity2;
    }
}
