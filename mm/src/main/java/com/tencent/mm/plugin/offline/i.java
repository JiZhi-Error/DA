package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.offline.a.f;
import com.tencent.mm.plugin.offline.a.h;
import com.tencent.mm.plugin.offline.a.l;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.ArrayList;

public final class i implements com.tencent.mm.ak.i {
    private boolean AIE = false;
    private boolean AIF = false;
    private int AIG = 10;
    private int AIH = 0;
    private String AII = "";
    a AIJ;
    private m AIK;
    public b AIL = new b(this, (byte) 0);
    int AIM = 14400000;
    MTimerHandler AIN = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.offline.i.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            long j2;
            AppMethodBeat.i(66239);
            if (!g.aAc()) {
                i.this.AIN.startTimer((long) i.this.AIM);
                AppMethodBeat.o(66239);
            } else {
                i.this.hE(5, 5);
                MTimerHandler mTimerHandler = i.this.AIN;
                i iVar = i.this;
                long eAF = (long) com.tencent.mm.plugin.offline.c.a.eAF();
                if (eAF <= 0) {
                    j2 = (long) iVar.AIM;
                } else {
                    Log.i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:".concat(String.valueOf(eAF)));
                    j2 = 1000 * eAF;
                }
                mTimerHandler.startTimer(j2);
                AppMethodBeat.o(66239);
            }
            return false;
        }
    }, false);
    public MMHandler mHandler = new MMHandler();

    public interface a {
        void ezg();
    }

    public i() {
        long j2 = 1;
        AppMethodBeat.i(66242);
        try {
            com.tencent.mm.wallet_core.c.b.hhj().init(MMApplicationContext.getContext());
        } catch (Exception e2) {
            Log.e("MicroMsg.OfflineTokensMgr", "NO MPERMISSION for READ_PHONE_STATE:%s.", e2);
        }
        g.aAi();
        g.aAg().hqi.a(385, this);
        k.ezn();
        String TX = k.TX(196649);
        if (TextUtils.isEmpty(TX) || !com.tencent.mm.plugin.offline.c.a.isNumeric(TX)) {
            Log.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        } else {
            String eAt = com.tencent.mm.plugin.offline.c.a.eAt();
            Log.i("MicroMsg.OfflineTokensMgr", "genInitInterval: token is not over update interval,lastUpdate is ".concat(String.valueOf(eAt)));
            long longValue = Long.valueOf(TX).longValue();
            if (TextUtils.isEmpty(eAt)) {
                Log.i("MicroMsg.OfflineTokensMgr", "genInitInterval lastUpdate is empty, update token");
            } else {
                long longValue2 = Long.valueOf(eAt).longValue();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                Log.i("MicroMsg.OfflineTokensMgr", "genInitInterval token is not over update interval,curTime = " + currentTimeMillis + ";");
                j2 = longValue - (currentTimeMillis - longValue2);
            }
        }
        Log.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=".concat(String.valueOf(j2)));
        this.AIN.startTimer(j2 * 1000);
        AppMethodBeat.o(66242);
    }

    public static int ezm() {
        AppMethodBeat.i(66243);
        k.ezn();
        String TX = k.TX(196617);
        com.tencent.mm.wallet_core.c.b.hhj();
        int bpl = com.tencent.mm.wallet_core.c.b.bpl(TX);
        Log.i("MicroMsg.OfflineTokensMgr", "offline tokens count:".concat(String.valueOf(bpl)));
        AppMethodBeat.o(66243);
        return bpl;
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(i iVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(66241);
            Log.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
            if (!g.aAf().azp()) {
                Log.w("MicroMsg.OfflineTokensMgr", "account not init.");
                AppMethodBeat.o(66241);
                return;
            }
            i.this.hF(6, 6);
            AppMethodBeat.o(66241);
        }
    }

    public final void hE(int i2, int i3) {
        AppMethodBeat.i(66244);
        if (!NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext()) || !com.tencent.mm.plugin.offline.c.a.eAj()) {
            AppMethodBeat.o(66244);
            return;
        }
        Log.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
        hF(i2, i3);
        AppMethodBeat.o(66244);
    }

    public final boolean sx(boolean z) {
        AppMethodBeat.i(66245);
        if (!com.tencent.mm.plugin.offline.c.a.eAj()) {
            Log.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
            AppMethodBeat.o(66245);
            return false;
        } else if (ezm() < k.AIY) {
            Log.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", Integer.valueOf(k.AIY));
            com.tencent.mm.wallet_core.c.b.hhj();
            int lastError = com.tencent.mm.wallet_core.c.b.getLastError();
            if (lastError != 0) {
                Log.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + lastError + ", don't  doNetSceneToken");
                AppMethodBeat.o(66245);
                return false;
            }
            Log.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
            if (z) {
                TV(9);
            } else {
                TV(2);
            }
            AppMethodBeat.o(66245);
            return true;
        } else if (com.tencent.mm.plugin.offline.c.a.eAG()) {
            Log.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
            if (z) {
                hF(5, 9);
            } else {
                hF(5, 5);
            }
            AppMethodBeat.o(66245);
            return true;
        } else if (!com.tencent.mm.plugin.offline.c.a.eAD()) {
            Log.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
            if (z) {
                hF(3, 9);
            } else {
                hF(3, 3);
            }
            AppMethodBeat.o(66245);
            return true;
        } else {
            AppMethodBeat.o(66245);
            return false;
        }
    }

    public final void TV(int i2) {
        AppMethodBeat.i(66246);
        if (ezm() > 2) {
            this.mHandler.postDelayed(new Runnable(2, i2) {
                /* class com.tencent.mm.plugin.offline.i.AnonymousClass2 */
                final /* synthetic */ int AIP = 2;
                final /* synthetic */ int AIQ;

                {
                    this.AIQ = r4;
                }

                public final void run() {
                    AppMethodBeat.i(66240);
                    i.this.hF(this.AIP, this.AIQ);
                    AppMethodBeat.o(66240);
                }
            }, 3000);
            AppMethodBeat.o(66246);
            return;
        }
        hF(2, i2);
        AppMethodBeat.o(66246);
    }

    public final void hF(int i2, int i3) {
        AppMethodBeat.i(66247);
        if (this.AIE) {
            AppMethodBeat.o(66247);
            return;
        }
        this.AIE = true;
        m mVar = new m(new StringBuilder().append(System.currentTimeMillis() / 1000).toString(), i2, i3);
        g.aAi();
        g.aAg().hqi.a(mVar, 0);
        TW(i2);
        AppMethodBeat.o(66247);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        int i4 = 6;
        AppMethodBeat.i(66248);
        if ((qVar instanceof h) || (qVar instanceof f)) {
            ArrayList<IDKey> arrayList = new ArrayList<>();
            if (qVar instanceof m) {
                IDKey iDKey = new IDKey();
                iDKey.SetID(c.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(2);
                arrayList.add(iDKey);
                if (!(i2 == 0 && i3 == 0)) {
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(c.CTRL_INDEX);
                    iDKey2.SetValue(1);
                    iDKey2.SetKey(3);
                    arrayList.add(iDKey2);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.b(arrayList, true);
            }
            if ((qVar instanceof f) && ((i2 == 0 && i3 == 0) || i2 != 0)) {
                Log.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (this.AIK != null) {
                    boolean ezs = this.AIK.ezs();
                    this.AIK = null;
                    if (ezs && this.AIJ != null) {
                        this.AIJ.ezg();
                    }
                }
            }
            if (i2 == 0 && i3 == 0) {
                if (qVar instanceof m) {
                    this.AIH = 0;
                    this.AIE = false;
                    this.mHandler.removeCallbacks(this.AIL);
                    this.AIK = (m) qVar;
                    String str2 = this.AIK.AJO;
                    k.ezn();
                    f fVar = new f(str2, k.TX(196617));
                    g.aAi();
                    g.aAg().hqi.a(fVar, 0);
                    AppMethodBeat.o(66248);
                    return;
                } else if (qVar instanceof l) {
                    this.AIF = false;
                    this.AII = ((l) qVar).AII;
                    if (this.AIJ != null) {
                        this.AIJ.ezg();
                    }
                    AppMethodBeat.o(66248);
                    return;
                } else if (qVar instanceof f) {
                    AppMethodBeat.o(66248);
                    return;
                }
            } else if (qVar instanceof m) {
                Log.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
                this.AIH++;
                this.AIE = false;
                if (i3 == 411) {
                    Log.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
                    com.tencent.mm.plugin.offline.c.a.eAw();
                    AppMethodBeat.o(66248);
                    return;
                }
                if (this.AIH < this.AIG) {
                    this.mHandler.removeCallbacks(this.AIL);
                    int i5 = this.AIH - 1;
                    if (i5 <= 6) {
                        i4 = i5;
                    }
                    this.mHandler.postDelayed(this.AIL, (long) (((int) Math.pow(2.0d, (double) i4)) * 60 * 1000));
                }
                AppMethodBeat.o(66248);
                return;
            } else if (qVar instanceof l) {
                this.AIF = false;
                AppMethodBeat.o(66248);
                return;
            } else if (qVar instanceof f) {
                this.AIK = null;
            }
            AppMethodBeat.o(66248);
            return;
        }
        AppMethodBeat.o(66248);
    }

    private static void TW(int i2) {
        int i3;
        int i4 = 0;
        AppMethodBeat.i(66249);
        boolean isAppOnForeground = com.tencent.mm.plugin.offline.c.a.isAppOnForeground(MMApplicationContext.getContext());
        boolean isNetworkConnected = NetStatusUtil.isNetworkConnected(MMApplicationContext.getContext());
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[6];
        objArr[0] = 4;
        objArr[1] = Integer.valueOf(isAppOnForeground ? 0 : 1);
        if (isNetworkConnected) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = 0;
        objArr[4] = Integer.valueOf(i2);
        if (k.AIX) {
            i4 = 1;
        }
        objArr[5] = Integer.valueOf(i4);
        hVar.a(14163, objArr);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(c.CTRL_INDEX);
        iDKey.SetValue(1);
        iDKey.SetKey(isNetworkConnected ? 36 : 37);
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(c.CTRL_INDEX);
        iDKey2.SetValue(1);
        iDKey2.SetKey(isAppOnForeground ? 38 : 39);
        arrayList.add(iDKey2);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(c.CTRL_INDEX);
        iDKey3.SetValue(1);
        iDKey3.SetKey(k.AIX ? 40 : 41);
        arrayList.add(iDKey3);
        if (i2 == 2) {
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(c.CTRL_INDEX);
            iDKey4.SetValue(1);
            iDKey4.SetKey(k.AIX ? 42 : 43);
            arrayList.add(iDKey4);
            IDKey iDKey5 = new IDKey();
            iDKey5.SetID(c.CTRL_INDEX);
            iDKey5.SetValue(1);
            iDKey5.SetKey(isAppOnForeground ? 44 : 45);
            arrayList.add(iDKey5);
            IDKey iDKey6 = new IDKey();
            iDKey6.SetID(c.CTRL_INDEX);
            iDKey6.SetValue(1);
            iDKey6.SetKey(isNetworkConnected ? 46 : 47);
            arrayList.add(iDKey6);
        } else if (i2 == 6) {
            IDKey iDKey7 = new IDKey();
            iDKey7.SetID(c.CTRL_INDEX);
            iDKey7.SetValue(1);
            iDKey7.SetKey(k.AIX ? 48 : 49);
            arrayList.add(iDKey7);
            IDKey iDKey8 = new IDKey();
            iDKey8.SetID(c.CTRL_INDEX);
            iDKey8.SetValue(1);
            iDKey8.SetKey(isAppOnForeground ? 50 : 51);
            arrayList.add(iDKey8);
            IDKey iDKey9 = new IDKey();
            iDKey9.SetID(c.CTRL_INDEX);
            iDKey9.SetValue(1);
            iDKey9.SetKey(isNetworkConnected ? 52 : 53);
            arrayList.add(iDKey9);
        } else if (i2 == 6) {
            IDKey iDKey10 = new IDKey();
            iDKey10.SetID(c.CTRL_INDEX);
            iDKey10.SetValue(1);
            iDKey10.SetKey(isAppOnForeground ? 54 : 55);
            arrayList.add(iDKey10);
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.b(arrayList, true);
        AppMethodBeat.o(66249);
    }
}
