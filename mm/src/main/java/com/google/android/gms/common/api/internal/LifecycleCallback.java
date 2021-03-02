package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@KeepForSdk
public class LifecycleCallback {
    @KeepForSdk
    protected final LifecycleFragment mLifecycleFragment;

    @KeepForSdk
    protected LifecycleCallback(LifecycleFragment lifecycleFragment) {
        this.mLifecycleFragment = lifecycleFragment;
    }

    @Keep
    private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity lifecycleActivity) {
        AppMethodBeat.i(4504);
        IllegalStateException illegalStateException = new IllegalStateException("Method not available in SDK.");
        AppMethodBeat.o(4504);
        throw illegalStateException;
    }

    @KeepForSdk
    public static LifecycleFragment getFragment(Activity activity) {
        AppMethodBeat.i(4505);
        LifecycleFragment fragment = getFragment(new LifecycleActivity(activity));
        AppMethodBeat.o(4505);
        return fragment;
    }

    @KeepForSdk
    protected static LifecycleFragment getFragment(LifecycleActivity lifecycleActivity) {
        AppMethodBeat.i(4503);
        if (lifecycleActivity.zzbv()) {
            zzcc zza = zzcc.zza(lifecycleActivity.zzby());
            AppMethodBeat.o(4503);
            return zza;
        } else if (lifecycleActivity.zzbw()) {
            zzbr zzc = zzbr.zzc(lifecycleActivity.zzbx());
            AppMethodBeat.o(4503);
            return zzc;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get fragment for unexpected activity.");
            AppMethodBeat.o(4503);
            throw illegalArgumentException;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public final Activity getActivity() {
        AppMethodBeat.i(4506);
        Activity lifecycleActivity = this.mLifecycleFragment.getLifecycleActivity();
        AppMethodBeat.o(4506);
        return lifecycleActivity;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    @KeepForSdk
    public void onStop() {
    }
}
