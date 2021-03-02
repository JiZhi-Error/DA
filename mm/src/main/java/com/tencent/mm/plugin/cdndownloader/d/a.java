package com.tencent.mm.plugin.cdndownloader.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.cdndownloader.a.a;
import com.tencent.mm.plugin.cdndownloader.a.b;
import com.tencent.mm.plugin.cdndownloader.e.b;
import com.tencent.mm.plugin.cdndownloader.f.c;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.cdndownloader.service.CDNDownloadServiceSlot;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.Set;

public final class a implements com.tencent.mm.ipcinvoker.wx_extension.c.a {
    private static a qmv;
    private static final Object qmy = new Object();
    private Context mContext = MMApplicationContext.getContext();
    private Set<CDNTaskInfo> qmA = new com.tencent.mm.plugin.cdndownloader.e.a(new b() {
        /* class com.tencent.mm.plugin.cdndownloader.d.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.cdndownloader.e.b
        public final void cyc() {
            AppMethodBeat.i(120723);
            Log.i("MicroMsg.CDNDownloadClient", "notify add");
            a.a(a.this);
            a.b(a.this);
            AppMethodBeat.o(120723);
        }

        @Override // com.tencent.mm.plugin.cdndownloader.e.b
        public final void remove() {
            AppMethodBeat.i(120724);
            Log.i("MicroMsg.CDNDownloadClient", "notify remove");
            if (a.this.qmA.size() == 0) {
                a.d(a.this);
                a.e(a.this);
            }
            AppMethodBeat.o(120724);
        }

        @Override // com.tencent.mm.plugin.cdndownloader.e.b
        public final void clear() {
            AppMethodBeat.i(120725);
            Log.i("MicroMsg.CDNDownloadClient", "notify clear");
            a.d(a.this);
            a.e(a.this);
            AppMethodBeat.o(120725);
        }
    });
    public b qmB;
    private ServiceConnection qmC = new ServiceConnection() {
        /* class com.tencent.mm.plugin.cdndownloader.d.a.AnonymousClass2 */

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(120726);
            Log.i("MicroMsg.CDNDownloadClient", "onServiceConnected");
            a.this.qmz = a.AbstractBinderC0919a.u(iBinder);
            a.f(a.this);
            a.g(a.this);
            try {
                synchronized (a.qmy) {
                    try {
                        a.qmy.notifyAll();
                    } finally {
                        AppMethodBeat.o(120726);
                    }
                }
            } catch (Exception e2) {
                AppMethodBeat.o(120726);
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(120727);
            Log.i("MicroMsg.CDNDownloadClient", "onServiceDisconnected");
            if (a.this.qmA.size() != 0) {
                for (CDNTaskInfo cDNTaskInfo : a.this.qmA) {
                    cDNTaskInfo.qmN = true;
                }
            }
            AppMethodBeat.o(120727);
        }
    };
    private MTimerHandler qmD = new MTimerHandler(p.ayg().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.cdndownloader.d.a.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(120728);
            Log.d("MicroMsg.CDNDownloadClient", "checkProcessTimer");
            if (a.this.qmA.size() == 0) {
                AppMethodBeat.o(120728);
                return false;
            }
            if (a.this.qmz != null) {
                try {
                    Log.d("MicroMsg.CDNDownloadClient", "checkActive");
                    a.this.qmz.cxW();
                } catch (RemoteException e2) {
                    Log.e("MicroMsg.CDNDownloadClient", "check process active false");
                    h.INSTANCE.idkeyStat(710, 3, 1, false);
                    if (a.i(a.this)) {
                        a.this.qmx = System.currentTimeMillis();
                        for (CDNTaskInfo cDNTaskInfo : a.this.qmA) {
                            cDNTaskInfo.qmN = true;
                        }
                        a.j(a.this);
                        AppMethodBeat.o(120728);
                        return true;
                    }
                    Log.i("MicroMsg.CDNDownloadClient", "dead twice in 1 min, something wrong must be happened");
                    h.INSTANCE.idkeyStat(710, 4, 1, false);
                    for (CDNTaskInfo cDNTaskInfo2 : a.this.qmA) {
                        a.this.qmB.g(cDNTaskInfo2.downloadUrl, 4, com.tencent.mm.plugin.downloader.a.a.qFo, null);
                    }
                    a.l(a.this);
                    AppMethodBeat.o(120728);
                    return false;
                }
            }
            AppMethodBeat.o(120728);
            return true;
        }
    }, true);
    private com.tencent.mm.plugin.cdndownloader.a.b qmE = new b.a() {
        /* class com.tencent.mm.plugin.cdndownloader.d.a.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.cdndownloader.a.b
        public final void f(String str, int i2, int i3, String str2) {
            AppMethodBeat.i(120729);
            Log.i("MicroMsg.CDNDownloadClient", "onDownloadStateChange, mediaId = %s, state = %d, errCode = %d, errMsg = %s", str, Integer.valueOf(i2), Integer.valueOf(i3), str2);
            if (i2 != 1) {
                a.a(a.this, new CDNTaskInfo(str));
            }
            if (a.this.qmB != null) {
                a.this.qmB.g(str, i2, i3, str2);
            }
            AppMethodBeat.o(120729);
        }

        @Override // com.tencent.mm.plugin.cdndownloader.a.b
        public final void w(String str, long j2, long j3) {
            AppMethodBeat.i(120730);
            Log.d("MicroMsg.CDNDownloadClient", "onDownloadProgressChange, mediaId = %s, receiveLen = %d, totalLen = %d", str, Long.valueOf(j2), Long.valueOf(j3));
            if (a.this.qmB != null) {
                a.this.qmB.x(str, j2, j3);
            }
            AppMethodBeat.o(120730);
        }
    };
    private p.a qmF = new p.a() {
        /* class com.tencent.mm.plugin.cdndownloader.d.a.AnonymousClass5 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(120731);
            a aVar = a.this;
            Log.i("MicroMsg.CDNDownloadClient", "notifyNetworkChange: ".concat(String.valueOf(i2)));
            if (aVar.qmz != null) {
                try {
                    aVar.qmz.EL(i2);
                    AppMethodBeat.o(120731);
                    return;
                } catch (RemoteException e2) {
                }
            }
            AppMethodBeat.o(120731);
        }
    };
    private long qmw = 0;
    private long qmx = 0;
    com.tencent.mm.plugin.cdndownloader.a.a qmz;

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(120744);
        aVar.cxU();
        AppMethodBeat.o(120744);
    }

    static /* synthetic */ void a(a aVar, CDNTaskInfo cDNTaskInfo) {
        AppMethodBeat.i(120753);
        aVar.d(cDNTaskInfo);
        AppMethodBeat.o(120753);
    }

    static /* synthetic */ void j(a aVar) {
        AppMethodBeat.i(120751);
        aVar.cyb();
        AppMethodBeat.o(120751);
    }

    public static synchronized a cya() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(120732);
            if (qmv == null) {
                qmv = new a();
            }
            aVar = qmv;
            AppMethodBeat.o(120732);
        }
        return aVar;
    }

    static {
        AppMethodBeat.i(120754);
        AppMethodBeat.o(120754);
    }

    public a() {
        AppMethodBeat.i(120733);
        g.aAi();
        g.aAg().a(this.qmF);
        cyb();
        AppMethodBeat.o(120733);
    }

    private synchronized void cyb() {
        AppMethodBeat.i(120734);
        try {
            Log.i("MicroMsg.CDNDownloadClient", "bindService: ".concat(String.valueOf(this.mContext.bindService(new Intent(this.mContext, CDNDownloadServiceSlot.class), this.qmC, 1))));
            AppMethodBeat.o(120734);
        } catch (Exception e2) {
            Log.e("MicroMsg.CDNDownloadClient", "bindService: " + e2.getMessage());
            AppMethodBeat.o(120734);
        }
    }

    public final synchronized int a(CDNTaskInfo cDNTaskInfo) {
        int i2 = -2;
        synchronized (this) {
            AppMethodBeat.i(120735);
            if (cDNTaskInfo == null || Util.isNullOrNil(cDNTaskInfo.downloadUrl)) {
                Log.w("MicroMsg.CDNDownloadClient", "addDownloadTask, info invalid");
                i2 = -1;
                AppMethodBeat.o(120735);
            } else {
                Log.i("MicroMsg.CDNDownloadClient", "addDownloadTask filePath:%s, url:%s", cDNTaskInfo.filePath, cDNTaskInfo.downloadUrl);
                if (this.qmA.contains(cDNTaskInfo)) {
                    Log.i("MicroMsg.CDNDownloadClient", "addDownloadTask, already in running");
                    AppMethodBeat.o(120735);
                } else {
                    CDNTaskState akt = akt(cDNTaskInfo.downloadUrl);
                    if (akt == null || akt.taskState != 104 || !s.YS(cDNTaskInfo.filePath)) {
                        if (this.qmz != null) {
                            try {
                                int a2 = this.qmz.a(cDNTaskInfo);
                                this.qmE.f(cDNTaskInfo.mediaId, 1, 0, "");
                                if (a2 == 0 || a2 == -2) {
                                    c(cDNTaskInfo);
                                }
                                AppMethodBeat.o(120735);
                                i2 = a2;
                            } catch (RemoteException e2) {
                                Log.e("MicroMsg.CDNDownloadClient", "addDownloadTask, " + e2.getMessage());
                            }
                        }
                        c(cDNTaskInfo);
                        cyb();
                        AppMethodBeat.o(120735);
                        i2 = 0;
                    } else {
                        Log.i("MicroMsg.CDNDownloadClient", "addDownloadTask, has download success");
                        AppMethodBeat.o(120735);
                        i2 = 1;
                    }
                }
            }
        }
        return i2;
    }

    public final synchronized boolean akr(String str) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(120736);
            Log.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask: ".concat(String.valueOf(str)));
            if (Util.isNullOrNil(str)) {
                Log.w("MicroMsg.CDNDownloadClient", "pauseDownloadTask, url invalid");
                AppMethodBeat.o(120736);
            } else {
                d(new CDNTaskInfo(str));
                if (this.qmz != null) {
                    try {
                        z = this.qmz.akr(str);
                        AppMethodBeat.o(120736);
                    } catch (RemoteException e2) {
                        Log.e("MicroMsg.CDNDownloadClient", "pauseDownloadTask, " + e2.getMessage());
                    }
                }
                Log.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask false, service interface is null");
                AppMethodBeat.o(120736);
            }
        }
        return z;
    }

    public final synchronized int b(CDNTaskInfo cDNTaskInfo) {
        int i2 = -2;
        synchronized (this) {
            AppMethodBeat.i(120737);
            if (cDNTaskInfo == null || Util.isNullOrNil(cDNTaskInfo.downloadUrl)) {
                Log.w("MicroMsg.CDNDownloadClient", "resumeDownloadTask, info invalid");
                i2 = -1;
                AppMethodBeat.o(120737);
            } else {
                Log.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask: " + cDNTaskInfo.downloadUrl);
                if (this.qmA.contains(cDNTaskInfo)) {
                    Log.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, already in running");
                    AppMethodBeat.o(120737);
                } else {
                    CDNTaskState akt = akt(cDNTaskInfo.downloadUrl);
                    if (akt == null || akt.taskState != 104 || !s.YS(cDNTaskInfo.filePath)) {
                        cDNTaskInfo.qmN = true;
                        if (this.qmz != null) {
                            try {
                                int b2 = this.qmz.b(cDNTaskInfo);
                                this.qmE.f(cDNTaskInfo.mediaId, 1, 0, "");
                                if (b2 == 0 || b2 == -2) {
                                    c(cDNTaskInfo);
                                }
                                AppMethodBeat.o(120737);
                                i2 = b2;
                            } catch (RemoteException e2) {
                                Log.e("MicroMsg.CDNDownloadClient", "resumeDownloadTask, " + e2.getMessage());
                            }
                        }
                        c(cDNTaskInfo);
                        cyb();
                        AppMethodBeat.o(120737);
                        i2 = 0;
                    } else {
                        Log.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask, has download success");
                        AppMethodBeat.o(120737);
                        i2 = 1;
                    }
                }
            }
        }
        return i2;
    }

    public final synchronized boolean aks(String str) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(120738);
            Log.i("MicroMsg.CDNDownloadClient", "removeDownloadTask: ".concat(String.valueOf(str)));
            if (Util.isNullOrNil(str)) {
                Log.w("MicroMsg.CDNDownloadClient", "removeDownloadTask, url invalid");
                AppMethodBeat.o(120738);
            } else {
                d(new CDNTaskInfo(str));
                if (this.qmz != null) {
                    try {
                        z = this.qmz.aks(str);
                        AppMethodBeat.o(120738);
                    } catch (RemoteException e2) {
                        Log.e("MicroMsg.CDNDownloadClient", "removeDownloadTask, " + e2.getMessage());
                    }
                }
                Log.i("MicroMsg.CDNDownloadClient", "removeDownloadTask false, service interface is null");
                AppMethodBeat.o(120738);
            }
        }
        return z;
    }

    public final synchronized CDNTaskState akt(String str) {
        com.tencent.mm.plugin.cdndownloader.f.a aVar;
        CDNTaskInfo cDNTaskInfo;
        CDNTaskState cDNTaskState = null;
        synchronized (this) {
            AppMethodBeat.i(120739);
            Log.i("MicroMsg.CDNDownloadClient", "queryDownloadTask: ".concat(String.valueOf(str)));
            if (Util.isNullOrNil(str)) {
                Log.w("MicroMsg.CDNDownloadClient", "queryDownloadTask, url invalid");
                AppMethodBeat.o(120739);
            } else {
                if (this.qmz != null) {
                    Log.d("MicroMsg.CDNDownloadClient", "queryDownloadTask service has connected");
                    try {
                        CDNTaskState akt = this.qmz.akt(str);
                        if (akt.taskState == 100 || akt.taskState == 101) {
                            if (!this.qmA.contains(new CDNTaskInfo(str))) {
                                c cxT = com.tencent.mm.plugin.cdndownloader.f.b.cxT();
                                if (cxT != null) {
                                    Cursor rawQuery = cxT.rawQuery(String.format("select * from %s where %s=%s", "CdnDownloadInfo", "downloadUrlHashCode", Integer.valueOf(str.hashCode())), new String[0]);
                                    if (rawQuery == null) {
                                        aVar = null;
                                    } else {
                                        com.tencent.mm.plugin.cdndownloader.f.a aVar2 = null;
                                        while (rawQuery.moveToNext()) {
                                            aVar2 = new com.tencent.mm.plugin.cdndownloader.f.a();
                                            aVar2.convertFrom(rawQuery);
                                        }
                                        rawQuery.close();
                                        aVar = aVar2;
                                    }
                                } else {
                                    aVar = null;
                                }
                                if (aVar != null) {
                                    cDNTaskInfo = new CDNTaskInfo(str);
                                    cDNTaskInfo.qmH = aVar.field_httpsUrl;
                                    cDNTaskInfo.mediaId = aVar.field_mediaId;
                                    cDNTaskInfo.filePath = aVar.field_filePath;
                                    cDNTaskInfo.qmI = aVar.field_verifyHeaders;
                                    cDNTaskInfo.qmL = aVar.field_allowMobileNetDownload.booleanValue();
                                    cDNTaskInfo.qmM = aVar.field_wifiAutoDownload.booleanValue();
                                    cDNTaskInfo.gqH = aVar.field_game_package_download.booleanValue();
                                    cDNTaskInfo.qmJ = 15;
                                    cDNTaskInfo.qmK = LocalCache.TIME_HOUR;
                                } else {
                                    cDNTaskInfo = null;
                                }
                                if (cDNTaskInfo != null) {
                                    this.qmA.add(cDNTaskInfo);
                                }
                            }
                        } else if (this.qmA.contains(new CDNTaskInfo(str))) {
                            akt.taskState = 101;
                        }
                        AppMethodBeat.o(120739);
                        cDNTaskState = akt;
                    } catch (RemoteException e2) {
                        Log.e("MicroMsg.CDNDownloadClient", "queryDownloadTask, " + e2.getMessage());
                    }
                }
                if (this.qmA.contains(new CDNTaskInfo(str))) {
                    cDNTaskState = new CDNTaskState();
                    cDNTaskState.taskState = 101;
                    AppMethodBeat.o(120739);
                } else {
                    AppMethodBeat.o(120739);
                }
            }
        }
        return cDNTaskState;
    }

    private void cxU() {
        AppMethodBeat.i(120740);
        if (this.qmz != null) {
            try {
                this.qmz.cxU();
                AppMethodBeat.o(120740);
                return;
            } catch (RemoteException e2) {
                Log.e("MicroMsg.CDNDownloadClient", "addIPCTaskMarker: ".concat(String.valueOf(e2)));
            }
        }
        AppMethodBeat.o(120740);
    }

    private void c(CDNTaskInfo cDNTaskInfo) {
        AppMethodBeat.i(120741);
        this.qmA.add(cDNTaskInfo);
        com.tencent.mm.plugin.cdndownloader.f.b.a(e(cDNTaskInfo));
        AppMethodBeat.o(120741);
    }

    private void d(CDNTaskInfo cDNTaskInfo) {
        AppMethodBeat.i(120742);
        this.qmA.remove(cDNTaskInfo);
        com.tencent.mm.plugin.cdndownloader.f.b.akv(cDNTaskInfo.downloadUrl);
        AppMethodBeat.o(120742);
    }

    private static com.tencent.mm.plugin.cdndownloader.f.a e(CDNTaskInfo cDNTaskInfo) {
        AppMethodBeat.i(120743);
        com.tencent.mm.plugin.cdndownloader.f.a aVar = new com.tencent.mm.plugin.cdndownloader.f.a();
        aVar.field_mediaId = cDNTaskInfo.mediaId;
        aVar.field_downloadUrlHashCode = cDNTaskInfo.downloadUrl.hashCode();
        aVar.field_downloadUrl = cDNTaskInfo.downloadUrl;
        aVar.field_httpsUrl = cDNTaskInfo.qmH;
        aVar.field_filePath = cDNTaskInfo.filePath;
        aVar.field_verifyHeaders = cDNTaskInfo.qmI;
        aVar.field_allowMobileNetDownload = Boolean.valueOf(cDNTaskInfo.qmL);
        aVar.field_wifiAutoDownload = Boolean.valueOf(cDNTaskInfo.qmM);
        aVar.field_game_package_download = Boolean.valueOf(cDNTaskInfo.gqH);
        AppMethodBeat.o(120743);
        return aVar;
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(120745);
        Log.i("MicroMsg.CDNDownloadClient", "startCheckProcessActiveTimer");
        aVar.qmD.startTimer(20000);
        AppMethodBeat.o(120745);
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(120746);
        if (aVar.qmz != null) {
            try {
                aVar.qmz.cxV();
            } catch (RemoteException e2) {
                Log.e("MicroMsg.CDNDownloadClient", "removeIPCTaskMarker: ".concat(String.valueOf(e2)));
            }
        }
        aVar.qmx = 0;
        AppMethodBeat.o(120746);
    }

    static /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(120747);
        Log.i("MicroMsg.CDNDownloadClient", "stopCheckProcessActiveTimer");
        aVar.qmD.stopTimer();
        AppMethodBeat.o(120747);
    }

    static /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(120748);
        try {
            Log.i("MicroMsg.CDNDownloadClient", "registerCallback");
            aVar.qmz.a(aVar.qmE);
            AppMethodBeat.o(120748);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.CDNDownloadClient", "registerCallback: " + e2.getMessage());
            AppMethodBeat.o(120748);
        }
    }

    static /* synthetic */ void g(a aVar) {
        AppMethodBeat.i(120749);
        Log.i("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected");
        if (aVar.qmA.size() > 0) {
            aVar.cxU();
        }
        for (CDNTaskInfo cDNTaskInfo : aVar.qmA) {
            Log.i("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected, url: %s, resume: %b", cDNTaskInfo.downloadUrl, Boolean.valueOf(cDNTaskInfo.qmN));
            try {
                if (cDNTaskInfo.qmN) {
                    aVar.qmz.b(cDNTaskInfo);
                } else {
                    aVar.qmz.a(cDNTaskInfo);
                }
                aVar.qmE.f(cDNTaskInfo.mediaId, 1, 0, "");
            } catch (RemoteException e2) {
                Log.e("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected: ".concat(String.valueOf(e2)));
                h.INSTANCE.idkeyStat(710, 0, 1, false);
            }
        }
        AppMethodBeat.o(120749);
    }

    static /* synthetic */ boolean i(a aVar) {
        AppMethodBeat.i(120750);
        if (System.currentTimeMillis() - aVar.qmx > 120000) {
            AppMethodBeat.o(120750);
            return true;
        }
        AppMethodBeat.o(120750);
        return false;
    }

    static /* synthetic */ void l(a aVar) {
        AppMethodBeat.i(120752);
        aVar.qmA.clear();
        c cxT = com.tencent.mm.plugin.cdndownloader.f.b.cxT();
        if (cxT != null) {
            cxT.execSQL("CdnDownloadInfo", String.format("delete from %s", "CdnDownloadInfo"));
        }
        AppMethodBeat.o(120752);
    }
}
