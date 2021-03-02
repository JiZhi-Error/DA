package com.tencent.mm.remoteservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class d {
    List<Runnable> NCB = new LinkedList();
    c NCC;
    private Context context;
    private ServiceConnection qmC = new ServiceConnection() {
        /* class com.tencent.mm.remoteservice.d.AnonymousClass1 */

        public final void onServiceDisconnected(ComponentName componentName) {
            d.this.NCC = null;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(152747);
            d.this.NCC = c.a.L(iBinder);
            Runnable[] runnableArr = (Runnable[]) d.this.NCB.toArray(new Runnable[d.this.NCB.size()]);
            for (Runnable runnable : runnableArr) {
                if (runnable != null) {
                    runnable.run();
                }
            }
            d.this.NCB.clear();
            AppMethodBeat.o(152747);
        }
    };

    public d(Context context2) {
        AppMethodBeat.i(152748);
        this.context = context2 instanceof Activity ? MMApplicationContext.getContext() : context2;
        AppMethodBeat.o(152748);
    }

    public final void connect(Runnable runnable) {
        AppMethodBeat.i(152749);
        new StringBuilder("RemoteServiceProxy construct, thread id:").append(Thread.currentThread().getId());
        if (isConnected()) {
            runnable.run();
            AppMethodBeat.o(152749);
        } else if (this.context == null) {
            AppMethodBeat.o(152749);
        } else {
            this.NCB.add(runnable);
            this.context.bindService(new Intent(this.context, RemoteService.class), this.qmC, 1);
            AppMethodBeat.o(152749);
        }
    }

    public final boolean isConnected() {
        AppMethodBeat.i(152750);
        if (this.NCC == null || !this.NCC.asBinder().isBinderAlive()) {
            AppMethodBeat.o(152750);
            return false;
        }
        AppMethodBeat.o(152750);
        return true;
    }

    public final void release() {
        AppMethodBeat.i(152751);
        if (!(this.NCC == null || this.qmC == null)) {
            this.context.unbindService(this.qmC);
            this.NCC = null;
        }
        this.context = null;
        AppMethodBeat.o(152751);
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar, String str, Bundle bundle) {
        AppMethodBeat.i(152752);
        if (isConnected()) {
            try {
                this.NCC.a(bVar.getClass().getName(), str, bundle, bVar);
                AppMethodBeat.o(152752);
                return;
            } catch (RemoteException e2) {
                Log.e("MicroMsg.RemoteServiceProxy", "exception:%s", Util.stackTraceToString(e2));
            }
        }
        AppMethodBeat.o(152752);
    }
}
