package com.tencent.mm.plugin.downloader.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.g.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.commlib.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static BroadcastReceiver qJv = null;
    private static int qJw = -1;

    public static void cBn() {
        AppMethodBeat.i(89071);
        if (qJv == null) {
            qJv = new C0945a((byte) 0);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            MMApplicationContext.getContext().registerReceiver(qJv, intentFilter);
            AppMethodBeat.o(89071);
        } catch (Exception e2) {
            Log.e("MicroMsg.Downloader.NetWorkManager", e2.getMessage());
            AppMethodBeat.o(89071);
        }
    }

    public static void cBo() {
        AppMethodBeat.i(89072);
        if (qJv != null) {
            try {
                MMApplicationContext.getContext().unregisterReceiver(qJv);
            } catch (Exception e2) {
                Log.e("MicroMsg.Downloader.NetWorkManager", e2.getMessage());
            }
        }
        qJv = null;
        AppMethodBeat.o(89072);
    }

    /* renamed from: com.tencent.mm.plugin.downloader.e.a$a  reason: collision with other inner class name */
    static class C0945a extends BroadcastReceiver {
        private C0945a() {
        }

        /* synthetic */ C0945a(byte b2) {
            this();
        }

        public final void onReceive(final Context context, Intent intent) {
            AppMethodBeat.i(89070);
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.plugin.downloader.e.a.C0945a.AnonymousClass1 */

                public final void run() {
                    LinkedList linkedList;
                    AppMethodBeat.i(89069);
                    if (!g.aAc() || com.tencent.mm.kernel.a.azj()) {
                        Log.e("MicroMsg.Downloader.NetWorkManager", "acc has not ready");
                        AppMethodBeat.o(89069);
                        return;
                    }
                    int netType = NetStatusUtil.getNetType(MMApplicationContext.getContext());
                    if (netType == a.qJw) {
                        AppMethodBeat.o(89069);
                        return;
                    }
                    int unused = a.qJw = netType;
                    Log.i("MicroMsg.Downloader.NetWorkManager", "onNetStateChange, netState = ".concat(String.valueOf(netType)));
                    if (!NetStatusUtil.isConnected(context)) {
                        Log.w("MicroMsg.Downloader.NetWorkManager", "network is not connected");
                        AppMethodBeat.o(89069);
                    } else if (NetStatusUtil.isWifi(netType)) {
                        b aSU = d.aSU();
                        if (aSU == null) {
                            linkedList = null;
                        } else {
                            Log.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf("select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1")));
                            Cursor rawQuery = aSU.rawQuery("select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1", new String[0]);
                            linkedList = new LinkedList();
                            if (rawQuery != null) {
                                while (rawQuery.moveToNext()) {
                                    com.tencent.mm.plugin.downloader.g.a aVar = new com.tencent.mm.plugin.downloader.g.a();
                                    aVar.convertFrom(rawQuery);
                                    linkedList.add(aVar);
                                }
                                rawQuery.close();
                            }
                        }
                        if (linkedList != null) {
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                com.tencent.mm.plugin.downloader.g.a aVar2 = (com.tencent.mm.plugin.downloader.g.a) it.next();
                                Log.i("MicroMsg.Downloader.NetWorkManager", "resumeTask, appId = %s, state = %d", aVar2.field_appId, Integer.valueOf(aVar2.field_status));
                                if (d.alf(aVar2.field_downloadUrl)) {
                                    Log.i("MicroMsg.Downloader.NetWorkManager", "hasDuplicatedTask");
                                    d.alc(aVar2.field_downloadUrl);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(710, 26, 1, false);
                                } else if (aVar2.field_status == 2) {
                                    f cBv = f.cBv();
                                    long j2 = aVar2.field_downloadId;
                                    com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
                                    if (Cw == null || Cw.field_downloaderType != 3) {
                                        com.tencent.mm.plugin.downloader.h.a cBz = cBv.cBz();
                                        com.tencent.mm.plugin.downloader.g.a Cw2 = d.Cw(j2);
                                        if (Cw2 != null) {
                                            Cw2.field_downloadType = 2;
                                            d.e(Cw2);
                                        }
                                        com.tencent.mm.plugin.downloader.f.a.p(j2, 14);
                                        cBz.n(j2, true);
                                    } else {
                                        com.tencent.mm.plugin.downloader.model.b cBA = cBv.cBA();
                                        com.tencent.mm.plugin.downloader.g.a Cw3 = d.Cw(j2);
                                        if (Cw3 != null) {
                                            Cw3.field_downloadType = 2;
                                            d.e(Cw3);
                                        }
                                        com.tencent.mm.plugin.downloader.f.a.p(j2, 14);
                                        cBA.n(j2, true);
                                    }
                                } else if (aVar2.field_status == 0 && aVar2.field_reserveInWifi) {
                                    f cBv2 = f.cBv();
                                    if (aVar2.field_downloaderType == 3) {
                                        cBv2.cBA().a(aVar2);
                                    } else {
                                        cBv2.cBw().a(aVar2);
                                    }
                                }
                            }
                        }
                        com.tencent.mm.plugin.game.commlib.c.a.dTf().a("download_resume", new a.AbstractC1395a() {
                            /* class com.tencent.mm.plugin.downloader.e.a.C0945a.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.game.commlib.c.a.AbstractC1395a
                            public final void cBm() {
                                AppMethodBeat.i(192272);
                                h.RTc.aX(new Runnable() {
                                    /* class com.tencent.mm.plugin.downloader.e.a.C0945a.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(192271);
                                        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                                            com.tencent.mm.plugin.downloader.model.a.cBp();
                                        }
                                        AppMethodBeat.o(192271);
                                    }
                                });
                                AppMethodBeat.o(192272);
                            }
                        });
                        AppMethodBeat.o(89069);
                    } else {
                        LinkedList<com.tencent.mm.plugin.downloader.g.a> cBs = d.cBs();
                        if (cBs != null) {
                            Iterator<com.tencent.mm.plugin.downloader.g.a> it2 = cBs.iterator();
                            while (it2.hasNext()) {
                                com.tencent.mm.plugin.downloader.g.a next = it2.next();
                                Log.i("MicroMsg.Downloader.NetWorkManager", "pauseTask, appId: " + next.field_appId);
                                f cBv3 = f.cBv();
                                long j3 = next.field_downloadId;
                                com.tencent.mm.plugin.downloader.g.a Cw4 = d.Cw(j3);
                                if (Cw4 == null || Cw4.field_downloaderType != 3) {
                                    com.tencent.mm.plugin.downloader.h.a cBz2 = cBv3.cBz();
                                    com.tencent.mm.plugin.downloader.g.a Cw5 = d.Cw(j3);
                                    if (Cw5 != null) {
                                        Cw5.field_downloadType = 2;
                                        d.e(Cw5);
                                    }
                                    com.tencent.mm.plugin.downloader.f.a.p(j3, 13);
                                    cBz2.Cp(j3);
                                } else {
                                    cBv3.cBA().Cs(j3);
                                }
                            }
                        }
                        AppMethodBeat.o(89069);
                    }
                }
            });
            AppMethodBeat.o(89070);
        }
    }
}
