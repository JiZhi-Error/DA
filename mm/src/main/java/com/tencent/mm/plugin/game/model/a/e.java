package com.tencent.mm.plugin.game.model.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.jb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.model.a.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public class e {
    private static o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.game.model.a.e.AnonymousClass1 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(41673);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!com.tencent.mm.kernel.a.azj()) {
                    jb jbVar = new jb();
                    jbVar.dNJ.dDe = 2;
                    EventCenter.instance.publish(jbVar);
                }
            }
            AppMethodBeat.o(41673);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(41674);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!com.tencent.mm.kernel.a.azj()) {
                    jb jbVar = new jb();
                    jbVar.dNJ.dDe = 1;
                    EventCenter.instance.publish(jbVar);
                }
            }
            AppMethodBeat.o(41674);
        }
    };
    private static int qJw = -1;
    private static b xIl;
    private static a xIm;
    private static c xIn;
    private static IListener xIo = new IListener<jb>() {
        /* class com.tencent.mm.plugin.game.model.a.e.AnonymousClass2 */

        {
            AppMethodBeat.i(161131);
            this.__eventId = jb.class.getName().hashCode();
            AppMethodBeat.o(161131);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jb jbVar) {
            AppMethodBeat.i(41676);
            boolean a2 = a(jbVar);
            AppMethodBeat.o(41676);
            return a2;
        }

        private static boolean a(jb jbVar) {
            com.tencent.mm.plugin.downloader.g.a alb;
            AppMethodBeat.i(41675);
            switch (jbVar.dNJ.dDe) {
                case 2:
                    if (Util.secondsToNow(Util.nullAsNil((Long) g.aAh().azQ().get(ar.a.USERINFO_GAME_SILENT_DOWNLOAD_TIME_LONG, (Object) 0L))) > 600) {
                        g.aAh().azQ().set(ar.a.USERINFO_GAME_SILENT_DOWNLOAD_TIME_LONG, Long.valueOf(Util.nowSecond()));
                        h.a.dWd().pP(false);
                        break;
                    }
                    break;
                case 3:
                    String str = jbVar.dNJ.dNI;
                    if (!Util.isNullOrNil(str)) {
                        d dVar = new d();
                        dVar.field_appId = str;
                        ((f) g.af(f.class)).dSM().delete(dVar, new String[0]);
                        Log.i("MicroMsg.GameSilentDownloadListener", "delete silent download, appid:%s", str);
                        break;
                    } else {
                        Log.i("MicroMsg.GameSilentDownloadStorage", "deleteAllItem ret:%b", Boolean.valueOf(((f) g.af(f.class)).dSM().execSQL("GameSilentDownload", String.format("delete from %s", "GameSilentDownload"))));
                        break;
                    }
                case 4:
                    String str2 = jbVar.dNJ.dNI;
                    if (!Util.isNullOrNil(str2) && (alb = d.alb(str2)) != null) {
                        com.tencent.mm.plugin.downloader.model.f.cBv().Cn(alb.field_downloadId);
                        d.Cx(alb.field_downloadId);
                        Log.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "delete downloadInfo in DB. appId:%s", str2);
                        break;
                    }
            }
            AppMethodBeat.o(41675);
            return false;
        }
    };
    private static IListener xIp = new IListener<ja>() {
        /* class com.tencent.mm.plugin.game.model.a.e.AnonymousClass3 */

        {
            AppMethodBeat.i(161132);
            this.__eventId = ja.class.getName().hashCode();
            AppMethodBeat.o(161132);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ja jaVar) {
            AppMethodBeat.i(41677);
            String str = jaVar.dNH.dNI;
            if (Util.isNullOrNil(str)) {
                Log.i("MicroMsg.GameSilentDownloadListener", "GameSilentDownloadEvent, appid is null!");
                AppMethodBeat.o(41677);
            } else {
                f.ap(str, 7, 0);
                d dVar = new d();
                dVar.field_appId = str;
                Log.i("MicroMsg.GameSilentDownloadListener", "cancel silentDownloadTask, appid:%s, ret:%b", str, Boolean.valueOf(((f) g.af(f.class)).dSM().delete(dVar, new String[0])));
                AppMethodBeat.o(41677);
            }
            return false;
        }
    };

    static {
        AppMethodBeat.i(41682);
        AppMethodBeat.o(41682);
    }

    public static void cBo() {
        AppMethodBeat.i(41681);
        appForegroundListener.dead();
        if (xIl != null) {
            try {
                MMApplicationContext.getContext().unregisterReceiver(xIl);
            } catch (Exception e2) {
                Log.i("MicroMsg.GameSilentDownloadListener", "unregisterNetChange err:%s", e2.getMessage());
            }
            xIl = null;
        }
        if (xIm != null) {
            try {
                MMApplicationContext.getContext().unregisterReceiver(xIm);
            } catch (Exception e3) {
                Log.i("MicroMsg.GameSilentDownloadListener", "unregisterBatteryChange err:%s", e3.getMessage());
            }
            xIm = null;
        }
        EventCenter.instance.removeListener(xIo);
        EventCenter.instance.removeListener(xIp);
        if (xIn != null) {
            com.tencent.mm.plugin.downloader.model.f.cBv();
            c.b(xIn);
            xIn = null;
        }
        AppMethodBeat.o(41681);
    }

    static class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(41679);
            com.tencent.f.h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.plugin.game.model.a.e.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(204181);
                    synchronized (e.class) {
                        try {
                            if (!g.aAc() || com.tencent.mm.kernel.a.azj()) {
                                Log.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
                                return;
                            }
                            int netType = NetStatusUtil.getNetType(MMApplicationContext.getContext());
                            if (netType == e.qJw) {
                                AppMethodBeat.o(204181);
                                return;
                            }
                            int unused = e.qJw = netType;
                            if (netType == 0) {
                                Log.i("MicroMsg.GameSilentDownloadListener", "netStateChange, netState = %s, checkDownload", Integer.valueOf(netType));
                                h.a.dWd().pP(false);
                            } else {
                                Log.i("MicroMsg.GameSilentDownloadListener", "netStateChange, netState = %s, pauseDownload", Integer.valueOf(netType));
                                h.a.dWd();
                                h.pauseDownload();
                            }
                            AppMethodBeat.o(204181);
                        } finally {
                            AppMethodBeat.o(204181);
                        }
                    }
                }
            });
            AppMethodBeat.o(41679);
        }
    }

    static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(41678);
            if (!g.aAc() || com.tencent.mm.kernel.a.azj()) {
                Log.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
                AppMethodBeat.o(41678);
            } else if (intent == null) {
                AppMethodBeat.o(41678);
            } else if ("android.intent.action.BATTERY_OKAY".equals(intent.getAction())) {
                Log.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_OKAY, checkDownload");
                h.a.dWd().pP(true);
                AppMethodBeat.o(41678);
            } else {
                if ("android.intent.action.BATTERY_LOW".equals(intent.getAction())) {
                    Log.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_LOW, pauseDownload");
                    h.a.dWd();
                    h.pauseDownload();
                }
                AppMethodBeat.o(41678);
            }
        }
    }

    public static void cBn() {
        AppMethodBeat.i(41680);
        try {
            if (xIl == null) {
                xIl = new b((byte) 0);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            MMApplicationContext.getContext().registerReceiver(xIl, intentFilter);
        } catch (Exception e2) {
            Log.i("MicroMsg.GameSilentDownloadListener", "registerNetChange err:%s", e2.getMessage());
        }
        try {
            if (xIm == null) {
                xIm = new a((byte) 0);
            }
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.BATTERY_OKAY");
            intentFilter2.addAction("android.intent.action.BATTERY_LOW");
            MMApplicationContext.getContext().registerReceiver(xIm, intentFilter2);
        } catch (Exception e3) {
            Log.i("MicroMsg.GameSilentDownloadListener", "registerBatteryChange err:%s", e3.getMessage());
        }
        appForegroundListener.alive();
        EventCenter.instance.addListener(xIo);
        EventCenter.instance.addListener(xIp);
        if (xIn == null) {
            xIn = new c();
        }
        com.tencent.mm.plugin.downloader.model.f.cBv();
        c.a(xIn);
        AppMethodBeat.o(41680);
    }
}
