package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GooglePlayServicesUpdatedReceiver extends BroadcastReceiver {
    private Context mContext;
    private final Callback zzkt;

    public static abstract class Callback {
        public abstract void zzv();
    }

    public GooglePlayServicesUpdatedReceiver(Callback callback) {
        this.zzkt = callback;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(11129);
        Uri data = intent.getData();
        String str = null;
        if (data != null) {
            str = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(str)) {
            this.zzkt.zzv();
            unregister();
        }
        AppMethodBeat.o(11129);
    }

    public final synchronized void unregister() {
        AppMethodBeat.i(11128);
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this);
        }
        this.mContext = null;
        AppMethodBeat.o(11128);
    }

    public final void zzc(Context context) {
        this.mContext = context;
    }
}
