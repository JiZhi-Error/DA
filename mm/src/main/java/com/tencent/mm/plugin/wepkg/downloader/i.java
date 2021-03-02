package com.tencent.mm.plugin.wepkg.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aaz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class i {
    private static a JMJ;
    private static int qJw = -1;

    public static void cBn() {
        AppMethodBeat.i(110625);
        if (JMJ == null) {
            JMJ = new a((byte) 0);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            MMApplicationContext.getContext().registerReceiver(JMJ, intentFilter);
        } catch (Exception e2) {
        }
        Log.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader startListen");
        AppMethodBeat.o(110625);
    }

    public static void cBo() {
        AppMethodBeat.i(110626);
        if (JMJ != null) {
            try {
                MMApplicationContext.getContext().unregisterReceiver(JMJ);
            } catch (Exception e2) {
            }
        }
        JMJ = null;
        Log.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader stopListen");
        AppMethodBeat.o(110626);
    }

    static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(110624);
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.plugin.wepkg.downloader.i.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(200159);
                    synchronized (i.class) {
                        try {
                            if (!g.aAc() || com.tencent.mm.kernel.a.azj()) {
                                Log.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
                                return;
                            }
                            int netType = NetStatusUtil.getNetType(MMApplicationContext.getContext());
                            if (netType == i.qJw) {
                                AppMethodBeat.o(200159);
                                return;
                            }
                            int unused = i.qJw = netType;
                            Log.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = ".concat(String.valueOf(netType)));
                            if (netType == 0) {
                                boolean dSV = com.tencent.mm.plugin.game.commlib.a.dSV();
                                boolean z = Util.secondsToNow(Util.nullAsNil((Long) g.aAh().azQ().get(ar.a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, (Object) 0L))) > 1800;
                                if (!z) {
                                    Log.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", 1800L);
                                }
                                if (!dSV && z) {
                                    g.aAh().azQ().set(ar.a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, Long.valueOf(Util.nowSecond()));
                                    aaz aaz = new aaz();
                                    aaz.eif.dDe = 0;
                                    EventCenter.instance.publish(aaz);
                                }
                            } else {
                                d gkL = d.gkL();
                                if (!(gkL.JMi == null || gkL.JMi.size() == 0)) {
                                    Collection<c> values = gkL.JMi.values();
                                    ArrayList arrayList = new ArrayList();
                                    for (c cVar : values) {
                                        arrayList.add(cVar);
                                    }
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        c cVar2 = (c) it.next();
                                        if (cVar2.JLZ.JMC) {
                                            gkL.a(cVar2);
                                        }
                                    }
                                    arrayList.clear();
                                }
                            }
                            AppMethodBeat.o(200159);
                        } finally {
                            AppMethodBeat.o(200159);
                        }
                    }
                }
            });
            AppMethodBeat.o(110624);
        }
    }
}
