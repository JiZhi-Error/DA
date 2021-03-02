package com.tencent.mm.plugin.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.plugin.emoji.sync.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public final class BKGLoaderManager implements d {
    int Mr;
    public boolean mIsForeground = false;
    int mNetWorkType = -1;
    boolean rdA = false;
    boolean rdB = false;
    public boolean rdC = false;
    public boolean rdD = false;
    private boolean rdE = false;
    private boolean rdF = false;
    private c rdG = null;
    private b rdH;
    private Vector<c> rdI = new Vector<>();
    private Vector<c> rdJ = new Vector<>();
    private Vector<c> rdK = new Vector<>();
    private Set<Object> rdL = new HashSet();
    public ConnectivityReceiver rdM;
    long rdN = 0;
    long rdO = 0;
    MTimerHandler rdP = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(108753);
            if (BKGLoaderManager.this.rdA || BKGLoaderManager.this.rdB || BKGLoaderManager.this.rdC) {
                long uidTxBytes = TrafficStats.getUidTxBytes(BKGLoaderManager.this.Mr);
                long uidRxBytes = TrafficStats.getUidRxBytes(BKGLoaderManager.this.Mr);
                long j2 = (uidTxBytes - BKGLoaderManager.this.rdN) + (uidRxBytes - BKGLoaderManager.this.rdO);
                Log.d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + (j2 / 1024));
                if (j2 <= 20480) {
                    BKGLoaderManager.this.cGC();
                } else {
                    BKGLoaderManager.this.rdN = uidTxBytes;
                    BKGLoaderManager.this.rdO = uidRxBytes;
                    BKGLoaderManager.this.rdP.startTimer(1000);
                }
            }
            AppMethodBeat.o(108753);
            return false;
        }
    }, false);
    public IListener rdQ = new IListener<d>() {
        /* class com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.AnonymousClass2 */

        {
            AppMethodBeat.i(161084);
            this.__eventId = d.class.getName().hashCode();
            AppMethodBeat.o(161084);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(d dVar) {
            AppMethodBeat.i(108754);
            d dVar2 = dVar;
            if ((dVar2 instanceof d) && !dVar2.dBP.dBQ) {
                BKGLoaderManager.this.cGC();
            }
            AppMethodBeat.o(108754);
            return false;
        }
    };
    public IListener rdR = new IListener<dm>() {
        /* class com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.AnonymousClass3 */

        {
            AppMethodBeat.i(161085);
            this.__eventId = dm.class.getName().hashCode();
            AppMethodBeat.o(161085);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dm dmVar) {
            AppMethodBeat.i(108755);
            dm dmVar2 = dmVar;
            if ((dmVar2 instanceof dm) && !Util.isNullOrNil(dmVar2.dGw.md5)) {
                BKGLoaderManager.this.m(dmVar2.dGw.md5, dmVar2.dGw.dDe, dmVar2.dGw.success);
            }
            AppMethodBeat.o(108755);
            return false;
        }
    };
    private int rdx = 0;
    private int rdy = 0;
    private boolean rdz = false;

    public BKGLoaderManager(b bVar) {
        AppMethodBeat.i(108757);
        this.rdH = bVar;
        this.Mr = Process.myUid();
        this.mNetWorkType = NetStatusUtil.getNetType(MMApplicationContext.getContext());
        AppMethodBeat.o(108757);
    }

    public final void dh(List<c> list) {
        AppMethodBeat.i(108759);
        if (this.rdJ == null) {
            this.rdJ = new Vector<>();
        }
        if (list.size() > 0) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = list.get(i2);
                if (cVar == null || this.rdJ.contains(cVar)) {
                    Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", cVar.getKey());
                } else {
                    this.rdJ.add(cVar);
                }
            }
        }
        AppMethodBeat.o(108759);
    }

    public final synchronized void di(List<c> list) {
        AppMethodBeat.i(108760);
        if (this.rdK == null) {
            this.rdK = new Vector<>();
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = list.get(i2);
                if (this.rdG != null && this.rdG.equals(cVar)) {
                    Object[] objArr = new Object[1];
                    objArr[0] = cVar == null ? "task is null" : cVar.getKey();
                    Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] currentTask equals task is has exist:%s", objArr);
                } else if (cVar == null || this.rdK.contains(cVar)) {
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = cVar == null ? "task is null" : cVar.getKey();
                    Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", objArr2);
                } else {
                    this.rdK.add(cVar);
                }
            }
        }
        AppMethodBeat.o(108760);
    }

    public final synchronized void cGB() {
        AppMethodBeat.i(108761);
        if (this.rdI != null) {
            this.rdI.clear();
        }
        if (this.rdJ != null) {
            this.rdJ.clear();
        }
        if (this.rdK != null) {
            this.rdK.clear();
        }
        this.rdz = false;
        AppMethodBeat.o(108761);
    }

    public final synchronized void cGD() {
        AppMethodBeat.i(108763);
        this.rdA = false;
        this.rdB = false;
        this.rdz = false;
        cGE();
        if (this.rdG != null) {
            this.rdG.cancel();
        }
        AppMethodBeat.o(108763);
    }

    public final void cGE() {
        AppMethodBeat.i(108764);
        if (this.rdL != null && this.rdL.size() > 0) {
            Iterator<Object> it = this.rdL.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.o(108764);
    }

    @Override // com.tencent.mm.plugin.emoji.sync.d
    public final void amU(String str) {
        AppMethodBeat.i(108765);
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", str);
        AppMethodBeat.o(108765);
    }

    @Override // com.tencent.mm.plugin.emoji.sync.d
    public final synchronized void m(String str, int i2, boolean z) {
        ArrayList<EmojiInfo> EQ;
        AppMethodBeat.i(108766);
        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", str, Boolean.valueOf(z));
        if (this.rdG == null || Util.isNullOrNil(str)) {
            Log.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
            AppMethodBeat.o(108766);
        } else {
            if (this.rdI.contains(this.rdG)) {
                this.rdI.remove(this.rdG);
            } else if (this.rdJ.contains(this.rdG)) {
                this.rdJ.remove(this.rdG);
            } else if (this.rdK.contains(this.rdG)) {
                this.rdK.remove(this.rdG);
            }
            if (z) {
                if (!(i2 == 2 || this.rdL == null || this.rdL.size() <= 0)) {
                    Iterator<Object> it = this.rdL.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                if ((this.rdG instanceof a) && (EQ = j.auL().EQ(((a) this.rdG).rcD)) != null) {
                    long j2 = 0;
                    for (EmojiInfo emojiInfo : EQ) {
                        j2 = s.boW(emojiInfo.hYx()) + j2;
                    }
                    Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "download size is %s", Long.valueOf(j2));
                    EmojiSyncManager.zl(j2);
                }
            } else {
                Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
            }
            if (i2 == 2) {
                this.rdP.startTimer(5000);
                AppMethodBeat.o(108766);
            } else {
                this.rdP.startTimer(1000);
                AppMethodBeat.o(108766);
            }
        }
    }

    public static boolean cGF() {
        AppMethodBeat.i(108767);
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null) {
                boolean isConnected = networkInfo.isConnected();
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                if (uptimeMillis2 >= 1000) {
                    Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[isWifi] cost:%s", Long.valueOf(uptimeMillis2));
                }
                AppMethodBeat.o(108767);
                return isConnected;
            }
            long uptimeMillis3 = SystemClock.uptimeMillis() - uptimeMillis;
            if (uptimeMillis3 >= 1000) {
                Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[isWifi] cost:%s", Long.valueOf(uptimeMillis3));
            }
            AppMethodBeat.o(108767);
            return false;
        } catch (Throwable th) {
            long uptimeMillis4 = SystemClock.uptimeMillis() - uptimeMillis;
            if (uptimeMillis4 >= 1000) {
                Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[isWifi] cost:%s", Long.valueOf(uptimeMillis4));
            }
            AppMethodBeat.o(108767);
            throw th;
        }
    }

    static boolean cFE() {
        AppMethodBeat.i(108768);
        if (NetStatusUtil.is3G(MMApplicationContext.getContext()) || NetStatusUtil.is4G(MMApplicationContext.getContext()) || NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            AppMethodBeat.o(108768);
            return true;
        }
        AppMethodBeat.o(108768);
        return false;
    }

    public final class ConnectivityReceiver extends BroadcastReceiver {
        public ConnectivityReceiver() {
        }

        public final void onReceive(final Context context, Intent intent) {
            AppMethodBeat.i(108756);
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.ConnectivityReceiver.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(240155);
                    int netType = NetStatusUtil.getNetType(context);
                    if (BKGLoaderManager.this.mNetWorkType == netType) {
                        AppMethodBeat.o(240155);
                        return;
                    }
                    Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", Integer.valueOf(netType));
                    if (BKGLoaderManager.cFE()) {
                        BKGLoaderManager.this.cGD();
                    } else if (BKGLoaderManager.cGF()) {
                        BKGLoaderManager.this.cGC();
                    } else if (!NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
                        BKGLoaderManager.this.cGD();
                    } else {
                        BKGLoaderManager.this.cGE();
                    }
                    BKGLoaderManager.this.mNetWorkType = netType;
                    AppMethodBeat.o(240155);
                }
            });
            AppMethodBeat.o(108756);
        }
    }

    public final synchronized void cGC() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(108762);
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext()) || EmojiSyncManager.awm()) {
                z = true;
            }
            if (z || this.rdz) {
                if (this.rdI != null && this.rdI.size() > 0) {
                    this.rdF = e.apo();
                    this.rdA = true;
                    this.rdB = false;
                    this.rdD = false;
                    this.rdC = false;
                    if (!this.rdF) {
                        this.rdG = this.rdI.remove(0);
                        this.rdG.a(this);
                        this.rdH.rdv.execute(this.rdG);
                        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", this.rdG.getKey(), Integer.valueOf(this.rdI.size()));
                    } else {
                        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
                    }
                    cGE();
                } else if (this.rdJ == null || this.rdJ.size() <= 0) {
                    Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
                    if (this.rdI == null || this.rdI.size() <= 0) {
                        if (this.rdA && this.mIsForeground) {
                            this.rdD = true;
                        }
                        this.rdA = false;
                    }
                    if (this.rdJ == null || this.rdJ.size() <= 0) {
                        if (this.rdB && this.mIsForeground) {
                            this.rdE = true;
                        }
                        this.rdB = false;
                    }
                    if ((this.rdI == null || this.rdI.size() <= 0) && ((this.rdJ == null || this.rdJ.size() <= 0) && ((this.rdA || this.rdB) && this.mIsForeground))) {
                        this.rdB = false;
                        this.rdA = false;
                    }
                    this.rdz = false;
                    cGE();
                } else {
                    this.rdB = true;
                    this.rdA = false;
                    this.rdE = false;
                    this.rdC = false;
                    this.rdG = this.rdJ.remove(0);
                    this.rdG.a(this);
                    this.rdH.rdv.execute(this.rdG);
                    Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", this.rdG.getKey(), Integer.valueOf(this.rdJ.size()));
                    cGE();
                }
                if (!this.rdB && !this.rdA) {
                    if (this.rdK == null || this.rdK.size() <= 0) {
                        this.rdC = false;
                        AppMethodBeat.o(108762);
                    } else {
                        this.rdC = true;
                        this.rdG = this.rdK.remove(0);
                        this.rdG.a(this);
                        this.rdH.rdv.execute(this.rdG);
                        Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", this.rdG.getKey(), Integer.valueOf(this.rdK.size()));
                        AppMethodBeat.o(108762);
                    }
                }
                AppMethodBeat.o(108762);
            } else if (cFE()) {
                Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
                this.rdA = false;
                this.rdB = false;
                this.rdD = false;
                this.rdC = false;
                cGE();
                AppMethodBeat.o(108762);
            } else {
                Log.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
                AppMethodBeat.o(108762);
            }
        }
    }
}
