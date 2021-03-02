package com.tencent.mm.plugin.misc.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bt;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class b implements i, c, a {
    private static MTimerHandler timer = null;
    private static String zrh = "";
    private static String zri = "";
    private int iFe = 0;
    private int iFf = 0;
    private p iRt = new p.a() {
        /* class com.tencent.mm.plugin.misc.b.b.AnonymousClass2 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            boolean z = true;
            AppMethodBeat.i(127614);
            try {
                if (!b.eiY()) {
                    b.a(b.this, 0);
                    AppMethodBeat.o(127614);
                    return;
                }
                String aoA = b.this.zrj ? "" : q.aoA();
                Log.i("MicroMsg.SimcardService", "onNetworkChange imsi[%s]", aoA);
                if (b.this.zrj || aoA.equals(b.zrh)) {
                    String eiZ = b.eiZ();
                    if (!eiZ.equals(b.zri)) {
                        Log.i("MicroMsg.SimcardService", "clientIp change old[%s] new[%s]", b.zri, eiZ);
                        String unused = b.zri = eiZ;
                    } else {
                        z = false;
                    }
                } else {
                    Log.i("MicroMsg.SimcardService", "imsi change old[%s] new[%s]", b.zrh, aoA);
                    String unused2 = b.zrh = aoA;
                }
                if (z) {
                    b.this.zre = false;
                    b.this.zrf = 0;
                    b.this.Qs(2);
                    AppMethodBeat.o(127614);
                    return;
                }
                b.a(b.this, b.this.iFe);
                AppMethodBeat.o(127614);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SimcardService", e2, "", new Object[0]);
                AppMethodBeat.o(127614);
            }
        }
    };
    private int type = 0;
    private boolean zre = false;
    private long zrf = 0;
    private long zrg = 60;
    private boolean zrj = false;
    private final Map<Integer, Set<a.AbstractC1476a>> zrk = new HashMap();

    static /* synthetic */ void a(b bVar, int i2) {
        AppMethodBeat.i(127626);
        bVar.gY(i2, 1);
        AppMethodBeat.o(127626);
    }

    static /* synthetic */ boolean eiY() {
        AppMethodBeat.i(127625);
        boolean eiX = eiX();
        AppMethodBeat.o(127625);
        return eiX;
    }

    static /* synthetic */ String eiZ() {
        AppMethodBeat.i(127627);
        String Ph = Ph();
        AppMethodBeat.o(127627);
        return Ph;
    }

    public b() {
        boolean z = false;
        AppMethodBeat.i(127615);
        if (Build.VERSION.SDK_INT >= 29 || (Build.VERSION.SDK_INT >= 28 && Build.VERSION.PREVIEW_SDK_INT != 0)) {
            z = true;
        }
        this.zrj = z;
        AppMethodBeat.o(127615);
    }

    @Override // com.tencent.mm.plugin.misc.a.a
    public final void a(a.AbstractC1476a aVar) {
        AppMethodBeat.i(199071);
        if (aVar == null) {
            AppMethodBeat.o(199071);
            return;
        }
        if (!this.zrk.containsKey(2)) {
            this.zrk.put(2, new HashSet());
        }
        this.zrk.get(2).add(aVar);
        AppMethodBeat.o(199071);
    }

    @Override // com.tencent.mm.plugin.misc.a.a
    public final void b(a.AbstractC1476a aVar) {
        AppMethodBeat.i(199072);
        if (aVar == null) {
            AppMethodBeat.o(199072);
        } else if (!this.zrk.containsKey(2)) {
            AppMethodBeat.o(199072);
        } else {
            this.zrk.get(2).remove(aVar);
            AppMethodBeat.o(199072);
        }
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(127616);
        if (timer == null) {
            MTimerHandler mTimerHandler = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.misc.b.b.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(127613);
                    if (!g.aAf().azp()) {
                        Log.w("MicroMsg.SimcardService", "account not init.");
                        AppMethodBeat.o(127613);
                    } else {
                        Log.i("MicroMsg.SimcardService", "CheckMobileSIMType Timer");
                        if (b.this.zrf == 0) {
                            b.this.Qs(0);
                        } else {
                            b.this.Qs(3);
                        }
                        AppMethodBeat.o(127613);
                    }
                    return true;
                }
            }, true);
            timer = mTimerHandler;
            mTimerHandler.startTimer(30000);
        }
        g.azz().a(com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.e.CTRL_INDEX, this);
        g.aAg().a(this.iRt);
        AppMethodBeat.o(127616);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(127617);
        g.azz().b(com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.e.CTRL_INDEX, this);
        AppMethodBeat.o(127617);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(127618);
        timer.stopTimer();
        timer.startTimer(Util.MILLSECONDS_OF_DAY);
        if (i2 == 0 && i3 == 0) {
            bt btVar = (bt) qVar;
            this.zre = true;
            this.iFf = btVar.iFf;
            this.type = btVar.type;
            this.iFe = btVar.iFe;
            if (((long) btVar.iFg) < 60 || ((long) btVar.iFg) > 86400) {
                this.zrg = 28800;
            } else {
                this.zrg = (long) btVar.iFg;
            }
            Log.i("MicroMsg.SimcardService", "CheckMobileSIMTypeResp type[%d], productType[%d], businessFlag[%d] expiredTime[%d]", Integer.valueOf(this.type), Integer.valueOf(this.iFf), Integer.valueOf(this.iFe), Integer.valueOf(btVar.iFg));
            gY(this.iFe, 3);
            AppMethodBeat.o(127618);
            return;
        }
        this.zrg = 60;
        Log.e("MicroMsg.SimcardService", "CheckMobileSimType error:(" + i2 + "," + i3 + ")");
        gY(this.iFe, 2);
        AppMethodBeat.o(127618);
    }

    @Override // com.tencent.mm.plugin.misc.a.a
    public final int Qr(int i2) {
        AppMethodBeat.i(127619);
        if (eiX()) {
            Qs(1);
            if (2 == this.type) {
                AppMethodBeat.o(127619);
                return 0;
            } else if (!this.zre) {
                AppMethodBeat.o(127619);
                return 0;
            } else if ((this.iFe & i2) == 0) {
                AppMethodBeat.o(127619);
                return 2;
            } else {
                AppMethodBeat.o(127619);
                return 1;
            }
        } else if (NetStatusUtil.isMobile(MMApplicationContext.getContext()) || !this.zre) {
            AppMethodBeat.o(127619);
            return 2;
        } else if ((this.iFe & i2) == 0) {
            AppMethodBeat.o(127619);
            return 2;
        } else {
            AppMethodBeat.o(127619);
            return 3;
        }
    }

    @Override // com.tencent.mm.plugin.misc.a.a
    public final int eiV() {
        AppMethodBeat.i(127620);
        if (!eiX()) {
            AppMethodBeat.o(127620);
            return 0;
        }
        int i2 = this.iFf;
        AppMethodBeat.o(127620);
        return i2;
    }

    public final void Qs(int i2) {
        bt btVar;
        AppMethodBeat.i(127621);
        if (!eiX()) {
            AppMethodBeat.o(127621);
            return;
        }
        if (this.zrf != 0) {
            long nowSecond = Util.nowSecond();
            Log.i("MicroMsg.SimcardService", "CheckMobileSIMType scene[%d] cacheExpiredTime[%d] lastCheckMobileSIMTypeTime[%d] now[%d]", Integer.valueOf(i2), Long.valueOf(this.zrg), Long.valueOf(this.zrf), Long.valueOf(nowSecond));
            if (i2 != 2) {
                long j2 = (long) ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("NetInfoCheckMobileSimTypeCacheTime", 28800);
                if (j2 > this.zrg) {
                    j2 = this.zrg;
                }
                if (nowSecond - this.zrf < j2) {
                    AppMethodBeat.o(127621);
                    return;
                }
            } else if (nowSecond - this.zrf < 60) {
                AppMethodBeat.o(127621);
                return;
            }
        }
        this.zrf = Util.nowSecond();
        zri = Ph();
        Log.i("MicroMsg.SimcardService", "CheckMobileSIMType start");
        if (!this.zrj) {
            zrh = q.aoA();
            btVar = new bt(i2, zri, q.dr(true), zrh, null, null);
        } else {
            String aoK = q.aoK();
            String str = zri;
            String aoJ = q.aoJ();
            if (aoK == "") {
                aoK = null;
            }
            btVar = new bt(i2, str, null, null, aoJ, aoK);
        }
        g.azz().a(btVar, 0);
        AppMethodBeat.o(127621);
    }

    private void gY(int i2, int i3) {
        AppMethodBeat.i(199073);
        Log.i("MicroMsg.SimcardService", "NotifySimTypeChange flag[%d]", Integer.valueOf(i2));
        if (this.zrk == null) {
            AppMethodBeat.o(199073);
            return;
        }
        for (Map.Entry<Integer, Set<a.AbstractC1476a>> entry : this.zrk.entrySet()) {
            int i4 = (entry.getKey().intValue() & i2) == 0 ? 2 : 1;
            for (a.AbstractC1476a aVar : entry.getValue()) {
                aVar.gX(i4, i3);
            }
        }
        AppMethodBeat.o(199073);
    }

    private static boolean eiX() {
        AppMethodBeat.i(127623);
        if (!NetStatusUtil.isMobile(MMApplicationContext.getContext())) {
            AppMethodBeat.o(127623);
            return false;
        }
        int iSPCode = NetStatusUtil.getISPCode(MMApplicationContext.getContext());
        Log.i("MicroMsg.SimcardService", "isUnicomNetwork ispcode[%d]", Integer.valueOf(iSPCode));
        if (iSPCode == 46001 || iSPCode == 46006 || iSPCode == 46009) {
            AppMethodBeat.o(127623);
            return true;
        }
        AppMethodBeat.o(127623);
        return false;
    }

    private static String Ph() {
        AppMethodBeat.i(127624);
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement != null) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (nextElement2 != null && !nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet4Address)) {
                            if (Util.isNullOrNil(nextElement2.getHostAddress())) {
                                AppMethodBeat.o(127624);
                                return "127.0.0.1";
                            }
                            String hostAddress = nextElement2.getHostAddress();
                            AppMethodBeat.o(127624);
                            return hostAddress;
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(127624);
        return "127.0.0.1";
    }
}
