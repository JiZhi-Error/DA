package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.s;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sandbox.updater.k;
import com.tencent.mm.sandbox.updater.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.service.MMService;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
@k
public class UpdaterService extends MMService {
    private static UpdaterService NGa = null;
    static final long NGc = 1800000;
    Map<Integer, a> NGb = new HashMap();
    private MTimerHandler NGd = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.sandbox.updater.UpdaterService.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(32798);
            if (!UpdaterService.a(UpdaterService.this)) {
                AppMethodBeat.o(32798);
                return true;
            }
            AppMethodBeat.o(32798);
            return false;
        }
    }, true);
    private a NGe = null;
    private boolean cQp = false;

    public UpdaterService() {
        AppMethodBeat.i(32801);
        AppMethodBeat.o(32801);
    }

    static /* synthetic */ boolean a(UpdaterService updaterService) {
        AppMethodBeat.i(32809);
        boolean gwB = updaterService.gwB();
        AppMethodBeat.o(32809);
        return gwB;
    }

    public static void fK() {
        AppMethodBeat.i(32802);
        Log.i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
        if (NGa != null) {
            NGa.gwB();
        }
        AppMethodBeat.o(32802);
    }

    public static UpdaterService gwA() {
        return NGa;
    }

    @Override // com.tencent.mm.service.MMService
    public final String getTag() {
        return "MicroMsg.UpdaterService";
    }

    @Override // com.tencent.mm.service.MMService
    public final void onCreate() {
        AppMethodBeat.i(32803);
        super.onCreate();
        Log.i("MicroMsg.UpdaterService", "onCreate");
        c.q(hashCode(), this);
        NGa = this;
        this.NGb.put(0, k.a.NFZ);
        this.NGb.put(1, e.gwh());
        this.NGb.put(2, e.gwh());
        this.NGb.put(4, l.a.NGg);
        this.NGb.put(5, l.a.NGg);
        MMActivity.initLanguage(MMApplicationContext.getContext());
        this.NGd.startTimer(NGc);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.NGe = new a();
        this.NJZ.registerReceiver(this.NGe, intentFilter);
        AppMethodBeat.o(32803);
    }

    @Override // com.tencent.mm.service.MMService
    public final void onStart(Intent intent, int i2) {
        AppMethodBeat.i(32804);
        Log.i("MicroMsg.UpdaterService", "onStart intent = %s", intent);
        o(intent);
        AppMethodBeat.o(32804);
    }

    @Override // com.tencent.mm.service.MMService
    public final int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(32805);
        Log.i("MicroMsg.UpdaterService", "onStartCommand intent = %s", intent);
        if (intent != null) {
            if (intent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
                Log.i("MicroMsg.UpdaterService", "runServiceInForground");
                PendingIntent service = PendingIntent.getService(MMApplicationContext.getContext(), 0, new Intent(), 0);
                s.c g2 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i("updater service running forground").i(System.currentTimeMillis()).f("Updater Service").g("updater service running forground");
                g2.Hv = service;
                startForeground(0, g2.build());
                this.cQp = true;
            } else if (Build.VERSION.SDK_INT < 18 && !this.cQp) {
                startForeground(TXLiteAVCode.ERR_CAMERA_NOT_AUTHORIZED, new Notification());
                this.cQp = true;
            }
        }
        o(intent);
        AppMethodBeat.o(32805);
        return 2;
    }

    @Override // com.tencent.mm.service.MMService
    public final void onDestroy() {
        AppMethodBeat.i(32806);
        Log.i("MicroMsg.UpdaterService", "onDestroy");
        this.NGd.stopTimer();
        if (this.NGe != null) {
            try {
                this.NJZ.unregisterReceiver(this.NGe);
            } catch (Exception e2) {
                Log.e("MicroMsg.UpdaterService", "unregisterReceiver(UpdaterService.ConnectivityReceiver) exception = %s", e2.getMessage());
            }
        }
        if (this.cQp) {
            gxF();
        }
        for (a aVar : this.NGb.values()) {
            aVar.onDestroy();
        }
        this.NGb.clear();
        NGa = null;
        c.r(hashCode(), this);
        super.onDestroy();
        AppMethodBeat.o(32806);
    }

    @Override // com.tencent.mm.service.MMService
    public final IBinder akL() {
        return null;
    }

    private void o(Intent intent) {
        AppMethodBeat.i(32807);
        if (intent == null) {
            AppMethodBeat.o(32807);
            return;
        }
        int intExtra = intent.getIntExtra("intent_extra_download_type", 0);
        Log.i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", Integer.valueOf(intExtra));
        a aVar = this.NGb.get(Integer.valueOf(intExtra));
        if (aVar != null) {
            boolean bu = aVar.bu(intent);
            Log.i("MicroMsg.UpdaterService", "handleCommand ret = %b", Boolean.valueOf(bu));
            if (!bu) {
                gwB();
            }
        }
        AppMethodBeat.o(32807);
    }

    private boolean gwB() {
        AppMethodBeat.i(32808);
        if (this.NGb.size() > 0) {
            for (a aVar : this.NGb.values()) {
                if (aVar.isBusy()) {
                    Log.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
                    AppMethodBeat.o(32808);
                    return false;
                }
            }
        }
        Log.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.sandbox.updater.UpdaterService.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(32799);
                if (UpdaterService.this.NGb.size() > 0) {
                    for (a aVar : UpdaterService.this.NGb.values()) {
                        if (aVar.isBusy()) {
                            Log.i("MicroMsg.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
                            AppMethodBeat.o(32799);
                            return;
                        }
                    }
                }
                if (!x.a.gmI()) {
                    UpdaterService.this.stopSelf();
                    AppMethodBeat.o(32799);
                    return;
                }
                Log.i("TBSDownloadMgr", "is still busy");
                AppMethodBeat.o(32799);
            }
        }, 10000);
        AppMethodBeat.o(32808);
        return true;
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    static final class a extends BroadcastReceiver {
        a() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(32800);
            if (UpdaterService.gwA() != null) {
                UpdaterService gwA = UpdaterService.gwA();
                boolean isWifi = NetStatusUtil.isWifi(context);
                if (gwA.NGb.size() > 0) {
                    for (a aVar : gwA.NGb.values()) {
                        aVar.Ay(isWifi);
                    }
                }
            }
            AppMethodBeat.o(32800);
        }
    }
}
