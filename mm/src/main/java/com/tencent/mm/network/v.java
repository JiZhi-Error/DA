package com.tencent.mm.network;

import android.content.SharedPreferences;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mars.Mars;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.network.a;
import com.tencent.mm.network.h;
import com.tencent.mm.network.l;
import com.tencent.mm.network.t;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.protobuf.C2396if;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class v extends h.a implements a.b, g {
    public static String jEd = "";
    public MMHandler handler;
    byte[] hqn;
    int jEe = 0;
    private long jEf = 0;
    private long jEg = 0;
    private long jEh = 0;
    private WakerLock jEi = null;
    public a jEj;
    a jEk;
    private b jEl;
    long jEm = 0;
    int jEn = -1;
    private an jEo;
    private u jEp;
    private i jEq;
    j jEr;
    private long jEs = 0;
    int jjY = 0;

    static /* synthetic */ void a(v vVar, int i2, int i3, String str) {
        AppMethodBeat.i(132842);
        vVar.l(i2, i3, str);
        AppMethodBeat.o(132842);
    }

    /* access modifiers changed from: package-private */
    public static class a extends l.a implements n {
        private v glb;
        private WakerLock jEP;
        private int jEQ = 0;

        public a(v vVar, WakerLock wakerLock) {
            this.glb = vVar;
            this.jEP = wakerLock;
        }

        @Override // com.tencent.mm.network.l
        public final void a(final t tVar, final int i2, final int i3, final String str) {
            AppMethodBeat.i(132789);
            this.jEP.lock(1000, "MMAutoAuth.IOnAutoAuth.onAutoAuth");
            new SyncTask<Object>() {
                /* class com.tencent.mm.network.v.a.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.SyncTask
                public final Object run() {
                    AppMethodBeat.i(132788);
                    try {
                        v.a(a.this.glb, tVar, str);
                    } catch (RemoteException e2) {
                        Log.e("MicroMsg.MMAutoAuth", "exception:%s", Util.stackTraceToString(e2));
                    }
                    AppMethodBeat.o(132788);
                    return null;
                }
            }.exec(this.glb.handler);
            AppMethodBeat.o(132789);
        }

        @Override // com.tencent.mm.network.n
        public final void a(int i2, int i3, int i4, String str, t tVar, byte[] bArr) {
            AppMethodBeat.i(132790);
            if (tVar.getType() == 252 || tVar.getType() == 701) {
                Log.d("MicroMsg.MMAutoAuth", "summerauth IOnAutoAuth onGYNetEnd manual auth");
                if (tVar.aZp().getRetCode() != 0 || i3 != 0) {
                    e.INSTANCE.idkeyStat(148, -102 == i4 ? 30 : 29, 1, false);
                } else if (tVar.aZq() == 2) {
                    e.INSTANCE.idkeyStat(148, 28, 1, false);
                    this.jEQ++;
                    if (this.jEQ > 1) {
                        Log.w("MicroMsg.MMAutoAuth", "summerauth manualLoginDecodeFailedTry beyond 1 no more try!");
                        v.a(this.glb, i3, i4, "auth_decode_failed_" + Util.nullAs(str, ""));
                    } else {
                        tVar.a(this, 0, 0);
                    }
                } else {
                    this.jEQ = 0;
                    tVar.a(this, i3, i4, str);
                }
            }
            if (tVar.aZp().getRetCode() == 0 && i3 == 0) {
                tVar.a(this, i3, i4, str);
                AppMethodBeat.o(132790);
            } else if (-102 == i4) {
                this.glb.jEn = i2;
                tVar.a(this.glb.jEj, this.glb.jEl, 0, 0);
                AppMethodBeat.o(132790);
            } else {
                if (-301 == i4) {
                    tVar.a(this, i3, i4, str);
                } else if (-105 == i4) {
                    tVar.a(this, i3, i4, str);
                } else if (-17 == i4) {
                    tVar.a(this, i3, i4, str);
                }
                v.a(this.glb, i3, i4, "autoauth_errmsg_" + Util.nullAs(str, ""));
                AppMethodBeat.o(132790);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class b extends l.a implements n {
        private v glb;
        private WakerLock jEP;

        public b(v vVar, WakerLock wakerLock) {
            this.glb = vVar;
            this.jEP = wakerLock;
        }

        @Override // com.tencent.mm.network.l
        public final void a(final t tVar, final int i2, final int i3, String str) {
            AppMethodBeat.i(132792);
            this.jEP.lock(1000, "MMAutoAuth.IOnGetCert.onAutoAuth");
            new SyncTask<Object>() {
                /* class com.tencent.mm.network.v.b.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.SyncTask
                public final Object run() {
                    AppMethodBeat.i(132791);
                    try {
                        v.a(b.this.glb, tVar);
                    } catch (RemoteException e2) {
                        Log.e("MicroMsg.MMAutoAuth", "exception:%s", Util.stackTraceToString(e2));
                    }
                    AppMethodBeat.o(132791);
                    return null;
                }
            }.exec(this.glb.handler);
            AppMethodBeat.o(132792);
        }

        @Override // com.tencent.mm.network.n
        public final void a(int i2, int i3, int i4, String str, t tVar, byte[] bArr) {
        }
    }

    public v(MMHandler mMHandler) {
        AppMethodBeat.i(132793);
        this.handler = mMHandler == null ? new MMHandler() : mMHandler;
        this.jEj = new a(this);
        this.jEi = new WakerLock(af.getContext(), "MicroMsg.MMAutoAuth");
        this.jEk = new a(this, this.jEi);
        this.jEl = new b(this, this.jEi);
        this.jEo = new an(ar.NSe + "autoauth.cfg");
        AppMethodBeat.o(132793);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(132794);
        reset();
        super.finalize();
        AppMethodBeat.o(132794);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void cancel(final int i2) {
        AppMethodBeat.i(132795);
        this.jEi.lock(1000, String.format("MMAutoAuth.cancel,%d", Integer.valueOf(i2)));
        new SyncTask<Object>() {
            /* class com.tencent.mm.network.v.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final Object run() {
                AppMethodBeat.i(132772);
                try {
                    v.ux(i2);
                } catch (RemoteException e2) {
                    Log.e("MicroMsg.MMAutoAuth", "exception:%s", Util.stackTraceToString(e2));
                }
                AppMethodBeat.o(132772);
                return null;
            }
        }.exec(this.handler);
        AppMethodBeat.o(132795);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final boolean aYT() {
        return this.jEe < 5;
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final String getNetworkServerIp() {
        AppMethodBeat.i(132796);
        String networkServerIp = MMLogic.getNetworkServerIp();
        AppMethodBeat.o(132796);
        return networkServerIp;
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final String[] getIPsString(boolean z) {
        AppMethodBeat.i(132797);
        String[] iPsString = MMLogic.getIPsString(z);
        AppMethodBeat.o(132797);
        return iPsString;
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void reset() {
        AppMethodBeat.i(132798);
        this.jEi.lock(1000, "MMAutoAuth.reset");
        new SyncTask<Object>() {
            /* class com.tencent.mm.network.v.AnonymousClass8 */

            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final Object run() {
                AppMethodBeat.i(132779);
                v.d(v.this);
                AppMethodBeat.o(132779);
                return null;
            }
        }.exec(this.handler);
        AppMethodBeat.o(132798);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final synchronized int a(final t tVar, final n nVar) {
        int intValue;
        AppMethodBeat.i(132799);
        this.jEi.lock(1000, "MMAutoAuth.send");
        intValue = ((Integer) new SyncTask<Integer>(-1) {
            /* class com.tencent.mm.network.v.AnonymousClass9 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Integer run() {
                AppMethodBeat.i(132781);
                Integer bjO = bjO();
                AppMethodBeat.o(132781);
                return bjO;
            }

            private Integer bjO() {
                AppMethodBeat.i(132780);
                try {
                    Integer valueOf = Integer.valueOf(v.a(v.this, tVar, nVar));
                    AppMethodBeat.o(132780);
                    return valueOf;
                } catch (RemoteException e2) {
                    Log.e("MicroMsg.MMAutoAuth", "exception:%s", Util.stackTraceToString(e2));
                    v.d(v.this);
                    AppMethodBeat.o(132780);
                    return -1;
                }
            }
        }.exec(this.handler)).intValue();
        AppMethodBeat.o(132799);
        return intValue;
    }

    private int b(t tVar, n nVar) {
        AppMethodBeat.i(132800);
        if (af.bkm().bjZ()) {
            AppMethodBeat.o(132800);
            return -1;
        }
        com.tencent.mm.protocal.h aZo = tVar.aZo();
        a aVar = new a(this);
        aVar.setUsername(aZo.getUserName());
        int a2 = af.bkm().a(tVar, nVar, aVar, 0);
        if (a2 < 0) {
            Log.e("MicroMsg.MMAutoAuth", "auth: net.send err");
        } else {
            Log.i("MicroMsg.MMAutoAuth", "auth: netid=".concat(String.valueOf(a2)));
        }
        AppMethodBeat.o(132800);
        return a2;
    }

    public final boolean bjL() {
        AppMethodBeat.i(132801);
        if (90000 >= SystemClock.elapsedRealtime() - this.jEg) {
            Log.w("MicroMsg.MMAutoAuth", "auto limit lastSessionTimeout=%d, curtime=%d", Long.valueOf(this.jEg), Long.valueOf(SystemClock.elapsedRealtime()));
            AppMethodBeat.o(132801);
            return false;
        }
        this.jEg = SystemClock.elapsedRealtime();
        this.jEj.a(new byte[0], new byte[0], new byte[0], this.jEj.getUin());
        this.jEj.aZf();
        AppMethodBeat.o(132801);
        return true;
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void fy(final boolean z) {
        AppMethodBeat.i(132802);
        new SyncTask<Object>(-1) {
            /* class com.tencent.mm.network.v.AnonymousClass10 */

            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final Object run() {
                AppMethodBeat.i(132782);
                Mars.onForeground(z);
                com.tencent.mm.ap.a.fE(z);
                CrashReportFactory.setForeground(z);
                AppMethodBeat.o(132782);
                return null;
            }
        }.exec(this.handler);
        AppMethodBeat.o(132802);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void a(boolean z, String str, String str2, final int[] iArr, final int[] iArr2, int i2, int i3, String str3, String str4) {
        AppMethodBeat.i(132803);
        this.jEi.lock(1000, "MMAutoAuth.setIDCHostInfo");
        List<o> bgd = o.bgd(str2);
        List<o> bgd2 = o.bgd(str);
        Object[] objArr = new Object[7];
        objArr[0] = str3;
        objArr[1] = str;
        objArr[2] = Integer.valueOf(bgd2.size());
        objArr[3] = str4;
        objArr[4] = str2;
        objArr[5] = Integer.valueOf(bgd.size());
        objArr[6] = z ? "!!!!!CHANGE IDC NOW" : "false";
        Log.d("MicroMsg.MMAutoAuth", "dkidc setIDCHostInfo short:[%s][%s](%d) long:[%s][%s](%d) reset:%s", objArr);
        final HashMap hashMap = new HashMap();
        for (o oVar : bgd) {
            ArrayList arrayList = (ArrayList) hashMap.get(oVar.host);
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(oVar.host, arrayList);
            }
            arrayList.add(oVar.yFq);
        }
        final HashMap hashMap2 = new HashMap();
        for (o oVar2 : bgd2) {
            ArrayList arrayList2 = (ArrayList) hashMap2.get(oVar2.host);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                hashMap2.put(oVar2.host, arrayList2);
            }
            arrayList2.add(oVar2.yFq);
        }
        new SyncTask<Object>(-1) {
            /* class com.tencent.mm.network.v.AnonymousClass11 */

            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final Object run() {
                AppMethodBeat.i(132783);
                hashMap.entrySet().iterator();
                try {
                    MMLogic.saveAuthLongList(hashMap, iArr2);
                } catch (Throwable th) {
                    MMLogic.saveAuthLongList(hashMap, iArr2);
                }
                hashMap2.entrySet().iterator();
                MMLogic.saveAuthShortList(hashMap2, iArr);
                Mars.onNetworkChange();
                AppMethodBeat.o(132783);
                return null;
            }
        }.exec(this.handler);
        AppMethodBeat.o(132803);
    }

    @Override // com.tencent.mm.network.h
    public final void d(final String str, final String str2, final String str3, final String str4) {
        AppMethodBeat.i(132804);
        this.jEi.lock(1000, "MMAutoAuth.setFixedHost");
        Log.i("MicroMsg.MMAutoAuth", "dkidc setFixedHost debug short:%s:%s long:%s:%s", str, str2, str3, str4);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str3)) {
            Log.w("MicroMsg.MMAutoAuth", "dkidc setFixedHost FAILED ! check assist");
            AppMethodBeat.o(132804);
            return;
        }
        new SyncTask<Object>(-1) {
            /* class com.tencent.mm.network.v.AnonymousClass12 */

            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final Object run() {
                AppMethodBeat.i(132784);
                MMLogic.setDebugIP(str, str2, str3, str4);
                Mars.onNetworkChange();
                AppMethodBeat.o(132784);
                return null;
            }
        }.exec(this.handler);
        AppMethodBeat.o(132804);
    }

    @Override // com.tencent.mm.network.h
    public final void setNewDnsDebugHost(final String str, final String str2) {
        AppMethodBeat.i(132805);
        if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2)) {
            new SyncTask<Object>() {
                /* class com.tencent.mm.network.v.AnonymousClass13 */

                @Override // com.tencent.mm.sdk.platformtools.SyncTask
                public final Object run() {
                    AppMethodBeat.i(132785);
                    MMLogic.setNewDnsDebugHost(str, str2);
                    AppMethodBeat.o(132785);
                    return null;
                }
            }.exec(this.handler);
            AppMethodBeat.o(132805);
            return;
        }
        Log.d("MicroMsg.MMAutoAuth", "setNewDnsDebugHost FAILED ! check assist");
        AppMethodBeat.o(132805);
    }

    @Override // com.tencent.mm.network.h
    public final void bjx() {
        AppMethodBeat.i(132806);
        this.jEi.lock(1000, "MMAutoAuth.forceUpdateHostCache");
        new SyncTask<Object>(-1) {
            /* class com.tencent.mm.network.v.AnonymousClass15 */

            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final Object run() {
                AppMethodBeat.i(132787);
                v.this.jEf = 0;
                Mars.onNetworkChange();
                AppMethodBeat.o(132787);
                return null;
            }
        }.exec(this.handler);
        AppMethodBeat.o(132806);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void MH(final String str) {
        AppMethodBeat.i(132807);
        this.jEi.lock(1000, "MMAutoAuth.ipxxStatistics");
        new SyncTask<Object>() {
            /* class com.tencent.mm.network.v.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final Object run() {
                AppMethodBeat.i(132773);
                Log.appenderFlush();
                IPxxLogic.onIPxx(str, 0);
                AppMethodBeat.o(132773);
                return null;
            }
        }.exec(this.handler);
        AppMethodBeat.o(132807);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void a(com.tencent.mm.network.a.b bVar) {
        AppMethodBeat.i(132808);
        af.bkh().jFR = bVar;
        AppMethodBeat.o(132808);
    }

    @Override // com.tencent.mm.network.h
    public final k bjy() {
        AppMethodBeat.i(132809);
        ah bki = af.bki();
        AppMethodBeat.o(132809);
        return bki;
    }

    /* access modifiers changed from: package-private */
    public final boolean RT(String str) {
        AppMethodBeat.i(132810);
        if (10001 == ac.jOC && ac.jOD > 0) {
            ac.jOD = 0;
            bjL();
        }
        Log.i("MicroMsg.MMAutoAuth", "summerdiz makeSureAuth host[%s]", str);
        if (this.jEj.RN(str)) {
            Log.i("MicroMsg.MMAutoAuth", "axauth axsession exist");
            AppMethodBeat.o(132810);
            return true;
        }
        if (this.jEj.MG(str)) {
            Log.w("MicroMsg.MMAutoAuth", "axauth the host [%s] is axhost but no axsessionkey", str);
            e.INSTANCE.idkeyStat(148, 139, 1, false);
            if (af.bkm().bjY()) {
                Log.w("MicroMsg.MMAutoAuth", "NetsceneAxAuth already has axauth cmd");
                AppMethodBeat.o(132810);
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (46000 < elapsedRealtime - this.jEs || this.jEs <= 0) {
                this.jEs = SystemClock.elapsedRealtime();
                bjL();
                e.INSTANCE.idkeyStat(148, 140, 1, false);
            } else {
                Log.w("MicroMsg.MMAutoAuth", "axauth time limit, last time [%d], current time is [%d]", Long.valueOf(this.jEs), Long.valueOf(elapsedRealtime));
                AppMethodBeat.o(132810);
                return false;
            }
        }
        if (this.jEj.aZb()) {
            Log.d("MicroMsg.MMAutoAuth", "make sure auth isLogin");
            AppMethodBeat.o(132810);
            return true;
        } else if (af.bkm().bjZ()) {
            Log.i("MicroMsg.MMAutoAuth", "makeSureAuth hasAuthCmd ret false");
            AppMethodBeat.o(132810);
            return false;
        } else if (this.jEn != -1) {
            Log.w("MicroMsg.MMAutoAuth", "makeSureAuth auto limit now is getting cert, ret false");
            AppMethodBeat.o(132810);
            return false;
        } else {
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (str != null && str.length() > 0 && 30000 >= elapsedRealtime2 - this.jEf && this.jEf > 0) {
                Log.w("MicroMsg.MMAutoAuth", "makeSureAuth auto limit lastAutoAuthtime=%d, curtime=%d, return false", Long.valueOf(this.jEf), Long.valueOf(elapsedRealtime2));
                AppMethodBeat.o(132810);
                return false;
            } else if (MMApplicationContext.getContext().getSharedPreferences("auth_hold_prefs", 0).getBoolean("auth_ishold", false)) {
                Log.i("MicroMsg.MMAutoAuth", "makeSureAuth AUTH_HOLD_KEY hold ret false");
                if (!af.bkm().bka()) {
                    Log.e("MicroMsg.MMAutoAuth", "sendImp hit push hold, pid:%d, stack[%s]", Integer.valueOf(Process.myPid()), Util.getStack());
                    af.bkj().post(new Runnable() {
                        /* class com.tencent.mm.network.v.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(132774);
                            Log.i("MicroMsg.MMAutoAuth", "makeSureAuth AUTH_HOLD_KEY hold  clearTaskAndCallback");
                            af.bkm().m(4, -100, MMApplicationContext.getContext().getString(R.string.ev6));
                            AppMethodBeat.o(132774);
                        }
                    });
                }
                AppMethodBeat.o(132810);
                return false;
            } else {
                Log.d("MicroMsg.MMAutoAuth", "make sure auth");
                t gc = af.bkm().gc(bjN());
                if (gc != null) {
                    try {
                        if (!(gc instanceof t.a)) {
                            this.jEf = SystemClock.elapsedRealtime();
                            Log.i("MicroMsg.MMAutoAuth", "makeSureAuth rest lastAutoAuthTime[%d]", Long.valueOf(this.jEf));
                            a(gc, 3, 3);
                        } else if (30000 < elapsedRealtime2 - this.jEh || this.jEh <= 0) {
                            Log.i("MicroMsg.MMAutoAuth", "makeSureAuth session time out in push_notify mode, send broast to mm");
                            this.jEh = SystemClock.elapsedRealtime();
                            af.bkn().j(5, null);
                        } else {
                            Log.i("MicroMsg.MMAutoAuth", "makeSureAuth session time out in push_notify mode, but hit limit");
                            AppMethodBeat.o(132810);
                            return false;
                        }
                    } catch (RemoteException e2) {
                        Log.e("MicroMsg.MMAutoAuth", "makeSureAuth exception:%s", Util.stackTraceToString(e2));
                    }
                } else {
                    Log.i("MicroMsg.MMAutoAuth", "makeSureAuth getAutoAuthRR is null");
                }
                Log.i("MicroMsg.MMAutoAuth", "makeSureAuth at last ret false");
                AppMethodBeat.o(132810);
                return false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void l(int i2, int i3, String str) {
        int i4;
        int i5;
        int i6 = -3;
        AppMethodBeat.i(132811);
        Log.i("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail inErrType=" + i2 + ", inErrCode=" + i3 + ", errMsg=" + str + " stack=" + Util.getStack());
        if (i2 == 4 && (i3 == -106 || i3 == -3 || i3 == -5)) {
            Log.e("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail autoauth errCode %s should be transfer to MM_ERR_AUTH_ANOTHERPLACE", Integer.valueOf(i3));
            i4 = -100;
        } else {
            i4 = i3;
        }
        if (i2 == 5 && i3 == -13) {
            Log.e("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail autoauth should not be return MM_ERR_SESSIONTIMEOUT trans to MM_ERR_PASSWORD");
            e.INSTANCE.idkeyStat(148, 42, 1, false);
            i5 = 4;
        } else {
            i6 = i4;
            i5 = i2;
        }
        if ((i5 == 6 && i3 == -10001) || (i5 == 5 && i3 != -13)) {
            Log.e("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp");
            SharedPreferences aVK = bi.aVK();
            String string = aVK.getString("_auth_key", "");
            String string2 = aVK.getString("server_id", "");
            if (Util.isNullOrNil(string) && Util.isNullOrNil(string2)) {
                Log.e("MicroMsg.MMAutoAuth", "summerauth handleAutoAuthFail autoauth ENCODE ERROR check sp aak and cookie null logout");
                i6 = -104;
                e.INSTANCE.idkeyStat(148, 52, 1, false);
                i5 = 4;
            }
        }
        af.bkm().m(i5, i6, str);
        if (i5 == 4 && (i6 == -100 || i6 == -2023 || i6 == -205 || i6 == -213)) {
            MMApplicationContext.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().putBoolean("auth_ishold", true).commit();
            reset();
        }
        AppMethodBeat.o(132811);
    }

    /* access modifiers changed from: package-private */
    public final boolean o(String str, String str2, int i2) {
        AppMethodBeat.i(132812);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(str == null ? -1 : str.length());
        objArr[1] = Integer.valueOf(i2);
        Log.i("MicroMsg.MMAutoAuth", "summerauths saveAAKAndCookieToSp aak[%s] uin[%s]", objArr);
        MMApplicationContext.getContext().getSharedPreferences("auth_hold_prefs", 0).edit().remove("auth_ishold").commit();
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", g.aps());
        boolean z = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
        int i3 = sharedPreferences.getInt("key_auth_update_version", 0);
        int i4 = sharedPreferences.getInt("_auth_uin", 0);
        String string = sharedPreferences.getString("_auth_key", "");
        String string2 = sharedPreferences.getString("server_id", "");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("key_auth_info_prefs_created", true);
        edit.putInt("key_auth_update_version", d.KyO);
        edit.putInt("_auth_uin", i2);
        edit.putString("_auth_key", str);
        edit.putString("server_id", str2);
        if (!edit.commit()) {
            Log.e("MicroMsg.MMAutoAuth", "summerauth save aak & id commit failed 1th!");
            e.INSTANCE.idkeyStat(148, 36, 1, false);
            if (!edit.commit()) {
                Log.e("MicroMsg.MMAutoAuth", "summerauth save aak & id commit failed 2nd!");
                e.INSTANCE.idkeyStat(148, 37, 1, false);
                Log.e("MicroMsg.MMAutoAuth", "summerauth save aak & id commit failed 2th so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", Boolean.valueOf(z), Boolean.valueOf(sharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Boolean.TRUE, Integer.valueOf(i3), Integer.valueOf(sharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(d.KyO), Integer.valueOf(i4), Integer.valueOf(sharedPreferences.getInt("_auth_uin", 0)), Integer.valueOf(i2), string, sharedPreferences.getString("_auth_key", ""), str, string2, sharedPreferences.getString("server_id", ""), str2);
                Log.appenderFlush();
                AppMethodBeat.o(132812);
                return false;
            }
        }
        boolean z2 = sharedPreferences.getBoolean("key_auth_info_prefs_created", false);
        int i5 = sharedPreferences.getInt("key_auth_update_version", 0);
        int i6 = sharedPreferences.getInt("_auth_uin", 0);
        String string3 = sharedPreferences.getString("_auth_key", "");
        String string4 = sharedPreferences.getString("server_id", "");
        if (!z2 || i5 != d.KyO || i6 != i2 || !string3.equals(str) || !string4.equals(str2)) {
            Log.e("MicroMsg.MMAutoAuth", "summerauth save aak & id commit failed check not equal so ret false old vs new vs input create[%b, %b, %b] version[%d, %d, %d], uin[%d, %d, %d], aak[%s, %s, %s], cookie[%s, %s, %s]", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.TRUE, Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(d.KyO), Integer.valueOf(i4), Integer.valueOf(i6), Integer.valueOf(i2), string, string3, str, string2, string4, str2);
            Log.appenderFlush();
            AppMethodBeat.o(132812);
            return false;
        }
        this.jEo.lockWrite();
        this.jEo.set(1, Integer.valueOf(d.KyO));
        this.jEo.set(2, Integer.valueOf(i2));
        this.jEo.set(3, str);
        this.jEo.set(4, str2);
        this.jEo.gBF();
        Object[] objArr2 = new Object[20];
        objArr2[0] = Boolean.valueOf(z);
        objArr2[1] = Boolean.valueOf(z2);
        objArr2[2] = Boolean.TRUE;
        objArr2[3] = Boolean.valueOf(!this.jEo.NRJ);
        objArr2[4] = Integer.valueOf(i3);
        objArr2[5] = Integer.valueOf(i5);
        objArr2[6] = Integer.valueOf(d.KyO);
        objArr2[7] = (Integer) this.jEo.get(1);
        objArr2[8] = Integer.valueOf(i4);
        objArr2[9] = Integer.valueOf(i6);
        objArr2[10] = Integer.valueOf(i2);
        objArr2[11] = (Integer) this.jEo.get(2);
        objArr2[12] = string;
        objArr2[13] = string3;
        objArr2[14] = str;
        objArr2[15] = (String) this.jEo.get(3);
        objArr2[16] = string2;
        objArr2[17] = string4;
        objArr2[18] = str2;
        objArr2[19] = (String) this.jEo.get(4);
        Log.i("MicroMsg.MMAutoAuth", "summerauth save aak & id ok old vs new vs input[%b, %b, %b, %b] version[%d, %d, %d. %d], uin[%d, %d, %d, %d], aak[%s, %s, %s, %s], cookie[%s, %s, %s, %s]", objArr2);
        AppMethodBeat.o(132812);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar, int i2, int i3) {
        AppMethodBeat.i(132813);
        tVar.a(this.jEk, i2, i3);
        AppMethodBeat.o(132813);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void a(ab abVar) {
        AppMethodBeat.i(132814);
        af.bkm().bkb();
        AppMethodBeat.o(132814);
    }

    public final byte[] bjM() {
        int length;
        AppMethodBeat.i(132815);
        if (!this.jEj.aZb()) {
            AppMethodBeat.o(132815);
            return null;
        }
        aa.a aVar = new aa.a();
        aVar.setUin(this.jEj.getUin());
        aVar.jcK = Util.decodeHexString(MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", g.aps()).getString("notify_sync_key_keybuf", ""));
        aVar.netType = com.tencent.mm.protocal.a.getNetType(MMApplicationContext.getContext());
        aVar.KzG = com.tencent.mm.protocal.a.gtq();
        MMLogic.NetworkIdInfo networkId = MMLogic.getNetworkId("synccheck");
        if (networkId == null || networkId.networkId == null) {
            Log.w("MicroMsg.MMAutoAuth", "network id is empty");
        } else {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(networkId.networkId.length);
            if (networkId.ctx == null) {
                length = 0;
            } else {
                length = networkId.ctx.length;
            }
            objArr[1] = Integer.valueOf(length);
            Log.i("MicroMsg.MMAutoAuth", "getnetworkid, id length: %d, ctx length %d,", objArr);
            aVar.networkId = networkId.networkId;
            if (networkId.ctx != null) {
                aVar.ctx = networkId.ctx;
                aVar.KAr = networkId.ctx.length;
            } else {
                aVar.KAr = 0;
            }
        }
        try {
            byte[] protoBuf = aVar.toProtoBuf();
            this.hqn = aVar.hqn;
            AppMethodBeat.o(132815);
            return protoBuf;
        } catch (Exception e2) {
            Log.e("MicroMsg.MMAutoAuth", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132815);
            return null;
        }
    }

    public static void aA(byte[] bArr) {
        String str;
        boolean z = false;
        AppMethodBeat.i(197104);
        if (bArr == null || bArr.length == 0) {
            Log.w("MicroMsg.MMAutoAuth", "synccheck response is empty");
            AppMethodBeat.o(197104);
            return;
        }
        aa.b bVar = new aa.b();
        try {
            bVar.fromProtoBuf(bArr);
            if (bVar.networkId != null) {
                byte[] bArr2 = bVar.networkId;
                byte[] bArr3 = bVar.ctx;
                if (bArr2[0] == 0 && bArr2[10] == 0 && bArr2[20] == 0 && bArr2[30] == 0) {
                    z = true;
                }
                if (bArr2 != null) {
                    Log.i("MicroMsg.MMAutoAuth", "networkid " + bArr2.length);
                } else {
                    Log.i("MicroMsg.MMAutoAuth", "networkid is null");
                }
                if (bArr3 != null) {
                    Log.i("MicroMsg.MMAutoAuth", "ctx " + bArr3.length);
                } else {
                    Log.i("MicroMsg.MMAutoAuth", "ctx is null");
                }
                if (z) {
                    str = "empty";
                } else {
                    str = new String(bArr2);
                }
                MMLogic.setNetworkId("synccheck", str, new String(bArr3), bVar.KAu);
            }
            AppMethodBeat.o(197104);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMAutoAuth", "newsync parse failed " + e2.getLocalizedMessage());
            AppMethodBeat.o(197104);
        }
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final int getHostByName(String str, List<String> list) {
        AppMethodBeat.i(132816);
        int hostByName = MMLogic.getHostByName(str, list);
        AppMethodBeat.o(132816);
        return hostByName;
    }

    @Override // com.tencent.mm.network.h
    public final int a(boolean z, List<String> list) {
        AppMethodBeat.i(132817);
        int snsIpsForScene = MMLogic.getSnsIpsForScene(list, z);
        AppMethodBeat.o(132817);
        return snsIpsForScene;
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final int a(String str, boolean z, List<String> list) {
        AppMethodBeat.i(132818);
        int snsIpsForSceneWithHostName = MMLogic.getSnsIpsForSceneWithHostName(list, str, z);
        AppMethodBeat.o(132818);
        return snsIpsForSceneWithHostName;
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final String getIspId() {
        AppMethodBeat.i(132819);
        String ispId = MMLogic.getIspId();
        AppMethodBeat.o(132819);
        return ispId;
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void setHostInfo(final String[] strArr, final String[] strArr2, final int[] iArr) {
        AppMethodBeat.i(132820);
        this.jEi.lock(1000, "MMAutoAuth.setHostInfo");
        if (strArr2 != null && strArr2.length > 0) {
            this.jEj.jDw.clear();
            for (String str : strArr2) {
                this.jEj.ax(str.getBytes());
            }
        }
        new SyncTask<Object>() {
            /* class com.tencent.mm.network.v.AnonymousClass4 */

            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final Object run() {
                AppMethodBeat.i(132775);
                MMLogic.setHostInfo(strArr, strArr2, iArr);
                AppMethodBeat.o(132775);
                return null;
            }
        }.exec(this.handler);
        AppMethodBeat.o(132820);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void addHostInfo(final String[] strArr, final String[] strArr2, final int[] iArr) {
        AppMethodBeat.i(132821);
        this.jEi.lock(1000, "MMAutoAuth.addHostInfo");
        new SyncTask<Object>() {
            /* class com.tencent.mm.network.v.AnonymousClass5 */

            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final Object run() {
                AppMethodBeat.i(132776);
                Log.i("MicroMsg.MMAutoAuth", "add host size [%d]", Integer.valueOf(strArr.length));
                MMLogic.addHostInfo(strArr, strArr2, iArr);
                AppMethodBeat.o(132776);
                return null;
            }
        }.exec(this.handler);
        AppMethodBeat.o(132821);
    }

    @Override // com.tencent.mm.network.h
    public final int i(int i2, byte[] bArr) {
        AppMethodBeat.i(132822);
        int k = ak.bkr().k(i2, bArr);
        AppMethodBeat.o(132822);
        return k;
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void a(final int i2, final String str, final int i3, final boolean z) {
        AppMethodBeat.i(132823);
        this.jEi.lock(1000, "MMAutoAuth.logUtil");
        new SyncTask<Object>() {
            /* class com.tencent.mm.network.v.AnonymousClass6 */

            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final Object run() {
                AppMethodBeat.i(132777);
                if (i2 == 3) {
                    Date date = new Date();
                    date.setTime(Util.nowMilliSecond() - (Util.MILLSECONDS_OF_DAY * ((long) i3)));
                    MMLogic.uploadFile(com.tencent.mm.loader.j.b.aKL() + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt", str, "");
                } else if (i2 == 2) {
                    Log.appenderFlush();
                    MMLogic.uploadLog(new int[]{i3}, z, str, "");
                } else {
                    Log.appenderFlush();
                }
                AppMethodBeat.o(132777);
                return null;
            }
        }.exec(this.handler);
        AppMethodBeat.o(132823);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void d(final String str, final long j2, final String str2) {
        AppMethodBeat.i(132824);
        new SyncTask<Object>() {
            /* class com.tencent.mm.network.v.AnonymousClass7 */

            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final Object run() {
                AppMethodBeat.i(132778);
                try {
                    v.this.jEi.lock(2000, "MMAutoAuth.uploadFile");
                    IPxxLogic.uploadFile(str, 0, j2, str2);
                    Log.i("MicroMsg.MMAutoAuth", "[+] uploadFile triggered, path: %s", str);
                    v.this.jEi.unLock();
                    AppMethodBeat.o(132778);
                    return null;
                } catch (Throwable th) {
                    v.this.jEi.unLock();
                    AppMethodBeat.o(132778);
                    throw th;
                }
            }
        }.exec(this.handler);
        AppMethodBeat.o(132824);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void setSignallingStrategy(long j2, long j3) {
        AppMethodBeat.i(132825);
        StnLogic.setSignallingStrategy(j2, j3);
        AppMethodBeat.o(132825);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void keepSignalling() {
        AppMethodBeat.i(132826);
        StnLogic.keepSignalling();
        AppMethodBeat.o(132826);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void stopSignalling() {
        AppMethodBeat.i(132827);
        StnLogic.stopSignalling();
        AppMethodBeat.o(132827);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void a(q qVar) {
        AppMethodBeat.i(132828);
        af.bko().jFt = qVar;
        AppMethodBeat.o(132828);
    }

    @Override // com.tencent.mm.network.h
    public final void a(u uVar) {
        this.jEp = uVar;
    }

    public final boolean bjN() {
        boolean z = false;
        AppMethodBeat.i(132829);
        if (this.jEp == null) {
            AppMethodBeat.o(132829);
        } else {
            try {
                z = this.jEp.check();
                AppMethodBeat.o(132829);
            } catch (Exception e2) {
                AppMethodBeat.o(132829);
            }
        }
        return z;
    }

    @Override // com.tencent.mm.network.h
    public final void a(i iVar) {
        this.jEq = iVar;
    }

    public final void uw(int i2) {
        AppMethodBeat.i(132830);
        if (this.jEq == null) {
            AppMethodBeat.o(132830);
            return;
        }
        try {
            this.jEq.iM(i2);
            AppMethodBeat.o(132830);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.MMAutoAuth", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(132830);
        }
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void reportFailIp(String str) {
        AppMethodBeat.i(132831);
        MMLogic.reportFailIp(str);
        AppMethodBeat.o(132831);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void reportV6Status(boolean z) {
        AppMethodBeat.i(176847);
        MMLogic.reportV6Status(z);
        AppMethodBeat.o(176847);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void forceUseV6(boolean z) {
        AppMethodBeat.i(176848);
        MMLogic.forceUseV6(z);
        AppMethodBeat.o(176848);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void switchProcessActiveState(boolean z) {
        AppMethodBeat.i(197105);
        MMLogic.switchProcessActiveState(z);
        AppMethodBeat.o(197105);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void setDebugHost(String str) {
        AppMethodBeat.i(197106);
        MMLogic.setDebugHost(str);
        AppMethodBeat.o(197106);
    }

    @Override // com.tencent.mm.network.h
    public final void bK(String str, String str2) {
        AppMethodBeat.i(197107);
        if (this.jEj != null) {
            a.bK(str, str2);
            AppMethodBeat.o(197107);
            return;
        }
        Log.w("MicroMsg.MMAutoAuth", "accinfo is empty");
        AppMethodBeat.o(197107);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final String[] aZl() {
        AppMethodBeat.i(197108);
        if (this.jEj != null) {
            String[] aZl = a.aZl();
            AppMethodBeat.o(197108);
            return aZl;
        }
        Log.w("MicroMsg.MMAutoAuth", "accinfo is empty");
        String[] strArr = new String[2];
        AppMethodBeat.o(197108);
        return strArr;
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void MI(String str) {
        AppMethodBeat.i(132832);
        Log.e("MicroMsg.MMAutoAuth", "killPush %s", str);
        AppMethodBeat.o(132832);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void fz(boolean z) {
        AppMethodBeat.i(132833);
        if (EventCenter.instance == null) {
            Log.w("MicroMsg.MMAutoAuth", "loginevent but eventpool null, event:".concat(String.valueOf(z)));
            AppMethodBeat.o(132833);
            return;
        }
        AppMethodBeat.o(132833);
    }

    @Override // com.tencent.mm.network.g
    public final k aZi() {
        return null;
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void fA(boolean z) {
        AppMethodBeat.i(132834);
        LocaleUtil.initLanguage(MMApplicationContext.getContext());
        AppMethodBeat.o(132834);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void fB(boolean z) {
        AppMethodBeat.i(132835);
        Log.d("MicroMsg.MMAutoAuth", "summer setMMTLS enable[%b]", Boolean.valueOf(z));
        MMLogic.setMmtlsCtrlInfo(z);
        AppMethodBeat.o(132835);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void aZj() {
        AppMethodBeat.i(132836);
        StnLogic.makesureLongLinkConnected();
        AppMethodBeat.o(132836);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void aZk() {
        AppMethodBeat.i(132837);
        StnLogic.startNetworkAnalysis();
        AppMethodBeat.o(132837);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void a(j jVar) {
        this.jEr = jVar;
    }

    /* access modifiers changed from: package-private */
    public final void aB(byte[] bArr) {
        ctc ctc;
        AppMethodBeat.i(132838);
        Log.i("MicroMsg.MMAutoAuth", "autoauth parseHostInfo");
        if (bArr == null) {
            AppMethodBeat.o(132838);
            return;
        }
        ell ell = new ell();
        try {
            ell.parseFrom(bArr);
            int i2 = ell.Nkx;
            if (!((i2 & 4) == 0 || (ctc = ell.NkA) == null)) {
                Log.i("MicroMsg.MMAutoAuth", "autoauth start to parse main hostlist");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                a(arrayList, arrayList2, arrayList3, ctc.KQj);
                String[] strArr = new String[arrayList.size()];
                String[] strArr2 = new String[arrayList2.size()];
                int[] iArr = new int[arrayList3.size()];
                arrayList.toArray(strArr);
                arrayList2.toArray(strArr2);
                Iterator it = arrayList3.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    iArr[i3] = ((Integer) arrayList3.get(((Integer) it.next()).intValue())).intValue();
                    i3++;
                }
                Log.i("MicroMsg.MMAutoAuth", "after parse main host list size [%d]", Integer.valueOf(strArr.length));
                setHostInfo(strArr, strArr2, iArr);
            }
            if ((i2 & 8) != 0) {
                Log.i("MicroMsg.MMAutoAuth", "autoauth start to parse ax hostlist");
                b(ell.NkB);
            }
            AppMethodBeat.o(132838);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMAutoAuth", e2.getLocalizedMessage());
            AppMethodBeat.o(132838);
        }
    }

    private void b(ig igVar) {
        int i2 = 0;
        AppMethodBeat.i(132839);
        if (igVar == null || igVar.oTz == 0 || igVar.oTA == null || igVar.oTA.size() == 0) {
            Log.w("MicroMsg.MMAutoAuth", "ax host list is null");
            AppMethodBeat.o(132839);
            return;
        }
        Log.i("MicroMsg.MMAutoAuth", "ax host list size [%d]", Integer.valueOf(igVar.oTz));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        LinkedList<C2396if> linkedList = igVar.oTA;
        if (linkedList != null) {
            Iterator<C2396if> it = linkedList.iterator();
            while (it.hasNext()) {
                a(arrayList, arrayList2, arrayList3, it.next().KMp);
            }
        }
        Log.i("MicroMsg.MMAutoAuth", "after parse ax host list size [%d]", Integer.valueOf(arrayList.size()));
        if (arrayList.size() > 0) {
            String[] strArr = new String[arrayList.size()];
            String[] strArr2 = new String[arrayList2.size()];
            int[] iArr = new int[arrayList3.size()];
            arrayList.toArray(strArr);
            arrayList2.toArray(strArr2);
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                iArr[i2] = ((Integer) arrayList3.get(((Integer) it2.next()).intValue())).intValue();
                i2++;
            }
            addHostInfo(strArr, strArr2, iArr);
        }
        AppMethodBeat.o(132839);
    }

    private static void a(List<String> list, List<String> list2, List<Integer> list3, ccb ccb) {
        AppMethodBeat.i(132840);
        if (ccb == null || ccb.oTA == null || ccb.oTA.size() == 0) {
            Log.w("MicroMsg.MMAutoAuth", "host list size is zero");
            AppMethodBeat.o(132840);
            return;
        }
        Log.i("MicroMsg.MMAutoAuth", "autoauth parse hostlist size [%d]", Integer.valueOf(ccb.oTA.size()));
        Iterator<cca> it = ccb.oTA.iterator();
        while (it.hasNext()) {
            cca next = it.next();
            Log.i("MicroMsg.MMAutoAuth", "parse hostlist host org:%s sub:%s", next.MhX, next.MhY);
            list.add(next.MhX);
            list2.add(next.MhY);
            list3.add(Integer.valueOf(next.MhZ));
        }
        AppMethodBeat.o(132840);
    }

    @Override // com.tencent.mm.network.g, com.tencent.mm.network.h
    public final void MJ(String str) {
        jEd = str;
    }

    @Override // com.tencent.mm.network.h
    public final /* bridge */ /* synthetic */ f bjw() {
        return this.jEj;
    }

    @Override // com.tencent.mm.network.g
    public final /* bridge */ /* synthetic */ e aZh() {
        return this.jEj;
    }

    static /* synthetic */ void a(v vVar, t tVar, String str) {
        AppMethodBeat.i(132841);
        Log.d("MicroMsg.MMAutoAuth", "account info updated:" + vVar.jEj);
        Log.i("MicroMsg.MMAutoAuth", "oreh doAutoAuth ticket:%s, login:%b", str, Boolean.valueOf(vVar.jEj.aZb()));
        Log.appenderFlush();
        if (!vVar.jEj.aZb() && !af.bkm().bjZ() && af.bkm().a(tVar, vVar.jEk, vVar.jEj, 1) < 0) {
            vVar.l(3, -1, "");
        }
        AppMethodBeat.o(132841);
    }

    static /* synthetic */ void a(v vVar, t tVar) {
        AppMethodBeat.i(132843);
        Log.d("MicroMsg.MMAutoAuth", "dkcert doGetCert");
        if (Util.MILLSECONDS_OF_MINUTE >= SystemClock.elapsedRealtime() - vVar.jEm) {
            Log.w("MicroMsg.MMAutoAuth", "getcert lastGetCertSucTime=%d, curtime=%d", Long.valueOf(vVar.jEm), Long.valueOf(SystemClock.elapsedRealtime()));
            vVar.l(3, -1, "");
            AppMethodBeat.o(132843);
            return;
        }
        if (af.bkm().a(tVar, vVar.jEl, vVar.jEj, 0) < 0) {
            vVar.l(3, -1, "");
        }
        AppMethodBeat.o(132843);
    }

    static /* synthetic */ void ux(int i2) {
        int i3 = 0;
        AppMethodBeat.i(132844);
        Log.i("MicroMsg.MMAutoAuth", "cancel: netid=".concat(String.valueOf(i2)));
        if (i2 < 0) {
            Log.e("MicroMsg.MMAutoAuth", "error netid < 0, ".concat(String.valueOf(i2)));
            AppMethodBeat.o(132844);
            return;
        }
        ae bkm = af.bkm();
        Log.i("MicroMsg.MMNativeNetTaskAdapter", "stopTask netId=".concat(String.valueOf(i2)));
        if (i2 < 0 || i2 >= 100) {
            AppMethodBeat.o(132844);
            return;
        }
        synchronized (bkm.jFA) {
            try {
                if (bkm.jFA[i2] != null) {
                    i3 = bkm.jFA[i2].taskId;
                }
            } finally {
                AppMethodBeat.o(132844);
            }
        }
        if (i3 != 0) {
            StnLogic.stopTask(i3);
        }
        synchronized (bkm.jFA) {
            try {
                if (bkm.jFA[i2] != null) {
                    try {
                        Log.i("MicroMsg.MMNativeNetTaskAdapter", "mmcgi stopTask outQueue: netId:%d hash:%d type:%d", Integer.valueOf(i3), Integer.valueOf(bkm.jFA[i2].jFE.getType()), Integer.valueOf(bkm.jFA[i2].jFE.getMMReqRespHash()));
                        bkm.jFA[i2] = null;
                    } catch (RemoteException e2) {
                        Log.e("MicroMsg.MMNativeNetTaskAdapter", "exception:%s", Util.stackTraceToString(e2));
                    }
                }
            } finally {
                AppMethodBeat.o(132844);
            }
        }
    }

    static /* synthetic */ void d(v vVar) {
        AppMethodBeat.i(132845);
        vVar.jEe = 0;
        vVar.jEf = 0;
        vVar.jEg = 0;
        af.bkm().reset();
        AppMethodBeat.o(132845);
    }

    static /* synthetic */ int a(v vVar, t tVar, n nVar) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(132846);
        Log.i("MicroMsg.MMAutoAuth", "dkcgi sendImp rr.type:%d callback:%d", Integer.valueOf(tVar.getType()), Integer.valueOf(nVar.hashCode()));
        switch (tVar.getType()) {
            case 126:
                tVar.getType();
                a aVar = new a(vVar);
                aVar.setUsername(tVar.aZo().getUserName());
                i2 = af.bkm().a(tVar, nVar, aVar, 0);
                if (i2 >= 0) {
                    Log.i("MicroMsg.MMAutoAuth", "register: netid=".concat(String.valueOf(i2)));
                    break;
                } else {
                    Log.e("MicroMsg.MMAutoAuth", "register: net.send err");
                    break;
                }
            case 252:
                int b2 = vVar.b(tVar, nVar);
                Log.i("MicroMsg.MMAutoAuth", "summerauths MMFunc_SecManualAuth netId[%s]", Integer.valueOf(b2));
                i2 = b2;
                break;
            case 701:
                i2 = vVar.b(tVar, nVar);
                break;
            default:
                tVar.aZo().setUin(vVar.jEj.getUin());
                ae bkm = af.bkm();
                a aVar2 = vVar.jEj;
                if (!tVar.getIsUserCmd()) {
                    i3 = 0;
                }
                i2 = bkm.a(tVar, nVar, aVar2, i3);
                if (i2 < 0) {
                    Log.e("MicroMsg.MMAutoAuth", "nonauth: in queue err");
                    break;
                }
                break;
        }
        AppMethodBeat.o(132846);
        return i2;
    }
}
