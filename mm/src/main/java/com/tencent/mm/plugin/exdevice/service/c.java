package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements ServiceConnection {
    public a rDx;
    public volatile boolean rDy;
    private List<Runnable> rDz = new LinkedList();

    public static abstract class a {
        public int dIe;

        public abstract void onServiceConnected();

        public a(int i2) {
            this.dIe = i2;
        }
    }

    public c() {
        AppMethodBeat.i(23639);
        AppMethodBeat.o(23639);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ArrayList arrayList;
        AppMethodBeat.i(23640);
        Log.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceConnected");
        x xVar = new x(h.a.w(iBinder));
        u.a(xVar);
        MMApplicationContext.isExdeviceProcess();
        xVar.a(com.tencent.mm.plugin.exdevice.c.a.cKe());
        xVar.b(com.tencent.mm.plugin.exdevice.model.a.cKp());
        if (!xVar.a(ad.cKX())) {
            Log.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
        }
        if (this.rDx != null) {
            this.rDx.onServiceConnected();
        }
        this.rDy = true;
        synchronized (this.rDz) {
            try {
                arrayList = new ArrayList(this.rDz);
                this.rDz.clear();
            } catch (Throwable th) {
                AppMethodBeat.o(23640);
                throw th;
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Runnable runnable = (Runnable) arrayList.get(i2);
            if (runnable != null) {
                runnable.run();
            }
        }
        arrayList.clear();
        AppMethodBeat.o(23640);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        AppMethodBeat.i(23641);
        Log.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
        this.rDy = false;
        u.a(null);
        MMApplicationContext.isExdeviceProcess();
        if (!bg.aVG() || bg.azj()) {
            Log.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
            AppMethodBeat.o(23641);
            return;
        }
        fc(MMApplicationContext.getContext());
        AppMethodBeat.o(23641);
    }

    public final void fc(Context context) {
        AppMethodBeat.i(23642);
        if (!d.fd(context)) {
            Log.i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
            AppMethodBeat.o(23642);
        } else if (com.tencent.mm.br.c.a(new Intent(context, ExDeviceService.class), this, "exdevice")) {
            Log.i("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice success");
            AppMethodBeat.o(23642);
        } else {
            Log.e("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice failed");
            AppMethodBeat.o(23642);
        }
    }

    public final boolean an(Runnable runnable) {
        AppMethodBeat.i(23643);
        if (runnable == null) {
            AppMethodBeat.o(23643);
            return false;
        }
        if (this.rDy) {
            runnable.run();
        } else {
            synchronized (this.rDz) {
                try {
                    this.rDz.add(runnable);
                } catch (Throwable th) {
                    AppMethodBeat.o(23643);
                    throw th;
                }
            }
        }
        AppMethodBeat.o(23643);
        return true;
    }
}
