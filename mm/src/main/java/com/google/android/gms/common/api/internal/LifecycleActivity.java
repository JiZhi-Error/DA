package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public class LifecycleActivity {
    private final Object zzkz;

    public LifecycleActivity(Activity activity) {
        AppMethodBeat.i(4502);
        Preconditions.checkNotNull(activity, "Activity must not be null");
        this.zzkz = activity;
        AppMethodBeat.o(4502);
    }

    public final boolean zzbv() {
        return this.zzkz instanceof FragmentActivity;
    }

    public final boolean zzbw() {
        return this.zzkz instanceof Activity;
    }

    public final Activity zzbx() {
        return (Activity) this.zzkz;
    }

    public final FragmentActivity zzby() {
        return (FragmentActivity) this.zzkz;
    }
}
