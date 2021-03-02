package com.tencent.map.tools.sheet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.map.tools.internal.q;
import com.tencent.map.tools.internal.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SheetNetworkStateMonitor extends BroadcastReceiver {
    private final String TAG = SheetNetworkStateMonitor.class.getSimpleName();
    private Context context;
    private boolean mStarted;
    private Handler mhandler;

    public SheetNetworkStateMonitor(Context context2) {
        AppMethodBeat.i(180965);
        this.context = context2;
        AppMethodBeat.o(180965);
    }

    public void startup(Handler handler) {
        AppMethodBeat.i(180966);
        if (this.mStarted) {
            AppMethodBeat.o(180966);
            return;
        }
        this.mStarted = true;
        this.mhandler = handler;
        listenNetworkState(handler);
        AppMethodBeat.o(180966);
    }

    public void shutdown() {
        AppMethodBeat.i(180967);
        if (!this.mStarted) {
            AppMethodBeat.o(180967);
            return;
        }
        this.mStarted = false;
        try {
            this.context.unregisterReceiver(this);
            AppMethodBeat.o(180967);
        } catch (Exception e2) {
            AppMethodBeat.o(180967);
        }
    }

    private void listenNetworkState(Handler handler) {
        AppMethodBeat.i(180968);
        try {
            this.context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, handler);
            AppMethodBeat.o(180968);
        } catch (Exception e2) {
            AppMethodBeat.o(180968);
        }
    }

    public void onReceive(Context context2, Intent intent) {
        AppMethodBeat.i(180969);
        if (intent == null) {
            AppMethodBeat.o(180969);
            return;
        }
        try {
            if (intent.getBooleanExtra("noConnectivity", false)) {
                q.a(this.mhandler, 10010, 0);
                AppMethodBeat.o(180969);
            } else if (x.f(context2)) {
                q.a(this.mhandler, 10009, 0);
                AppMethodBeat.o(180969);
            } else {
                q.a(this.mhandler, 10008, 0);
                AppMethodBeat.o(180969);
            }
        } catch (Exception e2) {
            AppMethodBeat.o(180969);
        }
    }
}
