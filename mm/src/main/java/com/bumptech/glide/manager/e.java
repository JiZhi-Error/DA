package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.g.j;
import com.bumptech.glide.manager.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e implements c {
    final c.a aMo;
    boolean aMp;
    private final BroadcastReceiver aMq = new BroadcastReceiver() {
        /* class com.bumptech.glide.manager.e.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(77547);
            boolean z = e.this.aMp;
            e.this.aMp = e.isConnected(context);
            if (z != e.this.aMp) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    new StringBuilder("connectivity changed, isConnected: ").append(e.this.aMp);
                }
                e.this.aMo.aE(e.this.aMp);
            }
            AppMethodBeat.o(77547);
        }
    };
    private final Context context;
    private boolean isRegistered;

    e(Context context2, c.a aVar) {
        AppMethodBeat.i(77548);
        this.context = context2.getApplicationContext();
        this.aMo = aVar;
        AppMethodBeat.o(77548);
    }

    @SuppressLint({"MissingPermission"})
    static boolean isConnected(Context context2) {
        AppMethodBeat.i(77549);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) j.checkNotNull((ConnectivityManager) context2.getSystemService("connectivity"), "Argument must not be null")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                AppMethodBeat.o(77549);
                return false;
            }
            AppMethodBeat.o(77549);
            return true;
        } catch (RuntimeException e2) {
            Log.isLoggable("ConnectivityMonitor", 5);
            AppMethodBeat.o(77549);
            return true;
        }
    }

    @Override // com.bumptech.glide.manager.i
    public final void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public final void onStart() {
        AppMethodBeat.i(77550);
        if (!this.isRegistered) {
            this.aMp = isConnected(this.context);
            try {
                this.context.registerReceiver(this.aMq, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.isRegistered = true;
                AppMethodBeat.o(77550);
                return;
            } catch (SecurityException e2) {
                Log.isLoggable("ConnectivityMonitor", 5);
            }
        }
        AppMethodBeat.o(77550);
    }

    @Override // com.bumptech.glide.manager.i
    public final void onStop() {
        AppMethodBeat.i(77551);
        if (this.isRegistered) {
            this.context.unregisterReceiver(this.aMq);
            this.isRegistered = false;
        }
        AppMethodBeat.o(77551);
    }
}
