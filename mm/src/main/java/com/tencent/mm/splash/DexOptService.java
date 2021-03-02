package com.tencent.mm.splash;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public class DexOptService extends Service {
    private Handler NLw;
    private volatile boolean NLx = false;
    private Handler NLy = new Handler() {
        /* class com.tencent.mm.splash.DexOptService.AnonymousClass1 */

        public final void handleMessage(Message message) {
            AppMethodBeat.i(40606);
            h.c("WxSplash.DexOptService", "dexopt process quit.", new Object[0]);
            DexOptService.this.stopSelf();
            AppMethodBeat.o(40606);
        }
    };
    private volatile Throwable NLz;
    private HandlerThread mHandlerThread = new HandlerThread("DexOpt-Thread");

    public DexOptService() {
        AppMethodBeat.i(40608);
        AppMethodBeat.o(40608);
    }

    static /* synthetic */ boolean b(DexOptService dexOptService) {
        AppMethodBeat.i(40614);
        boolean gyg = dexOptService.gyg();
        AppMethodBeat.o(40614);
        return gyg;
    }

    public void onCreate() {
        AppMethodBeat.i(40609);
        h.c("WxSplash.DexOptService", "onCreate", new Object[0]);
        super.onCreate();
        this.mHandlerThread.start();
        this.NLw = new Handler(this.mHandlerThread.getLooper()) {
            /* class com.tencent.mm.splash.DexOptService.AnonymousClass2 */

            public final void handleMessage(Message message) {
                AppMethodBeat.i(40607);
                if (DexOptService.this.NLx) {
                    h.c("WxSplash.DexOptService", "dex opt progressing.", new Object[0]);
                    AppMethodBeat.o(40607);
                    return;
                }
                DexOptService.this.NLx = true;
                if (DexOptService.b(DexOptService.this)) {
                    DexOptService.access$200();
                } else {
                    DexOptService.access$300();
                    DexOptService.c(DexOptService.this);
                }
                DexOptService.VV();
                DexOptService.this.NLx = false;
                AppMethodBeat.o(40607);
            }
        };
        AppMethodBeat.o(40609);
    }

    private boolean gyg() {
        boolean z;
        AppMethodBeat.i(40610);
        h.c("WxSplash.DexOptService", "doDexOpt start", new Object[0]);
        try {
            z = h.NLF.bR(getApplicationContext());
        } catch (Throwable th) {
            this.NLz = th;
            z = false;
        }
        h.c("WxSplash.DexOptService", "schedule to quit", new Object[0]);
        this.NLy.removeCallbacksAndMessages(null);
        this.NLy.sendEmptyMessageDelayed(0, 120000);
        h.c("WxSplash.DexOptService", "doDexOpt done, result %s", Boolean.valueOf(z));
        AppMethodBeat.o(40610);
        return z;
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(40611);
        this.NLw.sendEmptyMessage(0);
        h.c("WxSplash.DexOptService", "onStartCommand", new Object[0]);
        int onStartCommand = super.onStartCommand(intent, i2, i3);
        AppMethodBeat.o(40611);
        return onStartCommand;
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(40612);
        h.c("WxSplash.DexOptService", "onBind", new Object[0]);
        AppMethodBeat.o(40612);
        return null;
    }

    public void onDestroy() {
        AppMethodBeat.i(40613);
        h.c("WxSplash.DexOptService", "onDestroy", new Object[0]);
        super.onDestroy();
        AppMethodBeat.o(40613);
    }

    static /* synthetic */ void access$200() {
        AppMethodBeat.i(40615);
        o oVar = new o(a.gya() + "/DexOpt_Failed");
        if (oVar.exists()) {
            h.c("WxSplash.DexOptService", "remove failed file %s result %s", oVar, Boolean.valueOf(oVar.delete()));
        }
        h.c("WxSplash.DexOptService", "removeFailedFile", new Object[0]);
        AppMethodBeat.o(40615);
    }

    static /* synthetic */ void access$300() {
        AppMethodBeat.i(40616);
        String gya = a.gya();
        o oVar = new o(gya);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        o oVar2 = new o(gya + "/DexOpt_Failed");
        if (oVar2.exists()) {
            oVar2.delete();
        }
        try {
            oVar2.createNewFile();
            h.c("WxSplash.DexOptService", "addFailedFile", new Object[0]);
            AppMethodBeat.o(40616);
        } catch (IOException e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(40616);
            throw runtimeException;
        }
    }

    static /* synthetic */ void c(DexOptService dexOptService) {
        AppMethodBeat.i(40617);
        if (dexOptService.NLz != null) {
            RuntimeException runtimeException = new RuntimeException(dexOptService.NLz);
            AppMethodBeat.o(40617);
            throw runtimeException;
        }
        AppMethodBeat.o(40617);
    }

    static /* synthetic */ void VV() {
        AppMethodBeat.i(40618);
        o oVar = new o(a.gya());
        if (oVar.exists()) {
            o[] het = oVar.het();
            for (o oVar2 : het) {
                if (oVar2.exists() && oVar2.getName().startsWith("DexOpt_Request")) {
                    boolean delete = oVar2.delete();
                    h.c("WxSplash.DexOptService", "remove temp file %s result %s", oVar2, Boolean.valueOf(delete));
                    if (!delete) {
                        RuntimeException runtimeException = new RuntimeException("remove temp file failed");
                        AppMethodBeat.o(40618);
                        throw runtimeException;
                    }
                }
            }
            h.c("WxSplash.DexOptService", "removeDexOptTempFiles", new Object[0]);
        }
        AppMethodBeat.o(40618);
    }
}
