package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.a.b;
import com.tencent.mm.plugin.voip.model.a.d;
import com.tencent.mm.plugin.voip.model.a.i;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ck;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class v implements l.a {
    private static int GZx = -1;
    private static int GZy = 20;
    private static int lOO = -1;
    public l GSZ = m.fGM();
    private int GZA;
    ScheduledExecutorService GZB = Executors.newScheduledThreadPool(1);
    ScheduledFuture<?> GZC;
    private WifiInfo GZD;
    public boolean GZE = false;
    public int GZF = 0;
    public boolean GZG = false;
    public String GZH = null;
    private a GZI;
    private MTimerHandler GZJ = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voip.model.v.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(115156);
            if (v.this.GSZ.GVV.Hav == 1 && v.this.GSZ.fGr()) {
                e.Logi("MicroMsg.Voip.VoipServiceEx", "call timeout!");
                v.this.GSZ.GVV.Hcw.GXc = 101;
                h.INSTANCE.a(11521, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 4, Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()));
                v.this.adr(4);
                v.this.GSZ.GVW.fFR();
            }
            AppMethodBeat.o(115156);
            return false;
        }
    }, false);
    private byte[] GZK = new byte[500];
    MTimerHandler GZL = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voip.model.v.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(115157);
            v.this.GSZ.GWd++;
            if (v.this.GSZ.GVV.roomId == 0) {
                e.Loge("MicroMsg.Voip.VoipServiceEx", f.apq() + "double link switch roomId == 0 ");
                v.this.GZL.stopTimer();
            } else {
                v.this.GSZ.GVV.app2EngineDataEx(v.this.GSZ.GVV.HbN, v.this.GSZ.GVV.HbO, v.this.GSZ.GVV.HbP, 0, 0);
                if (!v.this.GSZ.GWc && 1 == v.this.GSZ.GVV.field_mGetValidSample) {
                    v.this.GSZ.GWc = true;
                    v.this.GSZ.GWe = v.this.GSZ.GWd;
                }
                if (1 == v.this.GSZ.GVI) {
                    v.this.GSZ.GVI = 15;
                }
                if (true == v.this.GSZ.GWc && v.this.GSZ.GWd - v.this.GSZ.GWe == v.this.GSZ.GVI && (v.this.GSZ.GVV.HbE & 1) == 0) {
                    v.this.GSZ.GWe = v.this.GSZ.GWd;
                    int isDCSameLan = v.this.GSZ.GVV.isDCSameLan();
                    int currentConnType = v.this.GSZ.GVV.getCurrentConnType();
                    if (1 == isDCSameLan && 1 == currentConnType) {
                        e.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  In the Same LAN, isDCSameLan = ".concat(String.valueOf(isDCSameLan)));
                        v.this.GSZ.GWd++;
                        AppMethodBeat.o(115157);
                        return true;
                    }
                    int i2 = v.this.GSZ.GVV.getcurstrategy();
                    int isRelayConnReady = v.this.GSZ.GVV.isRelayConnReady();
                    int isDCReady = v.this.GSZ.GVV.isDCReady();
                    int i3 = v.this.GSZ.GVI - 3;
                    if (i3 > 15) {
                        i3 = 15;
                    }
                    v.this.GSZ.GVV.app2EngineLinkQualityEx(i3, v.this.GZK);
                    new d(v.this.GSZ.GVV.roomId, v.this.GSZ.GVV.ypH, v.this.GSZ.GVV.ypO, currentConnType, isRelayConnReady, isDCReady, i2, v.this.GZK, v.this.GSZ.GVV.field_realLinkQualityInfoBuffLen).fII();
                    v.this.GSZ.GVV.HbG++;
                    e.Logi("MicroMsg.Voip.VoipServiceEx", "zhengxue[DOUBLELINK]  doubleLinkSwitchReportStatus " + v.this.GSZ.GVI + " isFirstValidSampleSet " + v.this.GSZ.GWc + " mGetValidSample " + v.this.GSZ.GVV.field_mGetValidSample + "mDoubleLinkSwitchReqCnt " + v.this.GSZ.GVV.HbG + "mTimerCounter " + v.this.GSZ.GWd + "mLastSwitchTimer " + v.this.GSZ.GWe);
                }
            }
            AppMethodBeat.o(115157);
            return true;
        }
    }, true);
    private MTimerHandler GZM = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voip.model.v.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            boolean z;
            AppMethodBeat.i(115158);
            if (v.this.GSZ.GVV.roomId == 0) {
                e.Loge("MicroMsg.Voip.VoipServiceEx", f.apq() + " roomId == 0 ");
                v.this.GZM.stopTimer();
            } else {
                if (v.this.GSZ.mStatus >= 5) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    new com.tencent.mm.plugin.voip.model.a.f(v.this.GSZ.GVV.roomId, v.this.GSZ.GVV.ypH, v.this.GSZ.GWk).fII();
                }
            }
            AppMethodBeat.o(115158);
            return true;
        }
    }, true);
    private MTimerHandler GZN = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voip.model.v.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(115159);
            Log.i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
            if (3 == v.this.GSZ.mStatus && v.this.GZw != 0 && v.this.GZw == v.this.GSZ.GVV.roomId) {
                v.this.GZw = 0;
                v.this.GSZ.K(5, -9000, "");
            }
            AppMethodBeat.o(115159);
            return false;
        }
    }, true);
    boolean GZs = false;
    public boolean GZt = false;
    private Object GZv = new Object();
    private int GZw = 0;
    public String GZz;
    private WifiManager cnK;
    com.tencent.mm.plugin.voip.video.e qtg;
    public String toUser = null;

    static /* synthetic */ int f(v vVar) {
        int i2 = vVar.GZA;
        vVar.GZA = i2 + 1;
        return i2;
    }

    public final void a(Context context, x xVar) {
        AppMethodBeat.i(235694);
        this.GSZ.owO = context;
        this.GSZ.GVW = xVar;
        e.Logd("MicroMsg.Voip.VoipServiceEx", "attach ui........");
        e.fKc();
        AppMethodBeat.o(235694);
    }

    public final void b(Context context, x xVar) {
        AppMethodBeat.i(235695);
        if (context == this.GSZ.owO && xVar == this.GSZ.GVW) {
            this.GSZ.owO = null;
            this.GSZ.GVW = x.GZW;
            e.Logd("MicroMsg.Voip.VoipServiceEx", "detach ui........");
            e.flushLogFile();
            AppMethodBeat.o(235695);
            return;
        }
        e.Logd("MicroMsg.Voip.VoipServiceEx", "cannot detach other's ui.");
        AppMethodBeat.o(235695);
    }

    public v() {
        AppMethodBeat.i(115162);
        this.GSZ.a(this);
        this.qtg = new com.tencent.mm.plugin.voip.video.e(MMApplicationContext.getContext());
        this.GZE = false;
        this.GZF = 0;
        this.GZG = false;
        this.GZH = null;
        AppMethodBeat.o(115162);
    }

    public final void stop() {
        AppMethodBeat.i(115163);
        Log.i("MicroMsg.Voip.VoipServiceEx", "stop");
        reset();
        this.GSZ.a((l.a) null);
        AppMethodBeat.o(115163);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(115164);
        stop();
        super.finalize();
        AppMethodBeat.o(115164);
    }

    private void reset() {
        AppMethodBeat.i(115165);
        Log.d("MicroMsg.Voip.VoipServiceEx", "reset");
        this.toUser = null;
        this.GZt = false;
        this.GZs = false;
        this.GSZ.reset();
        this.GZM.stopTimer();
        this.GZJ.stopTimer();
        this.GZL.stopTimer();
        this.GZN.stopTimer();
        if (this.GZI != null) {
            this.GZI.cancel();
        }
        if (this.GZC != null) {
            this.GZC.cancel(false);
            this.GZC = null;
        }
        this.GZw = 0;
        c.fFg().unRegister();
        c.fFg().GUy = null;
        this.GZE = false;
        this.GZF = 0;
        this.GZG = false;
        this.GZH = null;
        AppMethodBeat.o(115165);
    }

    private void fIp() {
        AppMethodBeat.i(115166);
        Log.d("MicroMsg.Voip.VoipServiceEx", "reset");
        this.GZM.stopTimer();
        this.GZJ.stopTimer();
        this.GZL.stopTimer();
        this.GZN.stopTimer();
        this.GZw = 0;
        AppMethodBeat.o(115166);
    }

    public final void adn(int i2) {
        AppMethodBeat.i(115167);
        this.GSZ.ada(i2);
        AppMethodBeat.o(115167);
    }

    public final boolean fIq() {
        AppMethodBeat.i(115168);
        Log.i("MicroMsg.Voip.VoipServiceEx", "isRoomReady, roomId: " + this.GSZ.GVV.roomId);
        if (this.GSZ.GVV.roomId == 0 || fIr()) {
            AppMethodBeat.o(115168);
            return false;
        }
        AppMethodBeat.o(115168);
        return true;
    }

    private boolean fIr() {
        AppMethodBeat.i(115169);
        boolean z = false;
        if (this.GSZ != null) {
            z = this.GSZ.fGr();
        }
        AppMethodBeat.o(115169);
        return z;
    }

    public final boolean fGt() {
        AppMethodBeat.i(115170);
        if (this.GSZ.fGt()) {
            AppMethodBeat.o(115170);
            return true;
        }
        AppMethodBeat.o(115170);
        return false;
    }

    public static boolean fIs() {
        AppMethodBeat.i(115171);
        if (((TelephonyManager) MMApplicationContext.getContext().getSystemService("phone")).getCallState() != 0) {
            AppMethodBeat.o(115171);
            return true;
        }
        AppMethodBeat.o(115171);
        return false;
    }

    public final void fIt() {
        AppMethodBeat.i(115172);
        if (this.GSZ.fGt()) {
            e.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.GSZ.mStatus);
        }
        e.Loge("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + ck.getFingerprint());
        this.GSZ.fGo();
        fIp();
        ae.DV(g.aAh().azR().gEu());
        AppMethodBeat.o(115172);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.voip.model.l.a
    public final void K(int i2, int i3, String str) {
        AppMethodBeat.i(115173);
        Log.i("MicroMsg.Voip.VoipServiceEx", "onFinishVoIP finishType: ".concat(String.valueOf(i2)));
        switch (i2) {
            case 1:
                this.GSZ.GVW.onError(i3, str);
                fIy();
                break;
            case 4:
                this.GSZ.GVW.onReject();
                fIy();
                AppMethodBeat.o(115173);
                return;
            case 5:
                this.GSZ.GVW.fFR();
                fIy();
                AppMethodBeat.o(115173);
                return;
            case 6:
                this.GSZ.GVW.wW(true);
                fIy();
                AppMethodBeat.o(115173);
                return;
        }
        AppMethodBeat.o(115173);
    }

    public final int fU(String str, int i2) {
        AppMethodBeat.i(115174);
        Log.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", str, 0, Integer.valueOf(i2));
        if (Util.isNullOrNil(str)) {
            e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
            AppMethodBeat.o(115174);
            return -1;
        } else if (this.GSZ.fGt()) {
            e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
            AppMethodBeat.o(115174);
            return -1;
        } else {
            this.GZH = str;
            this.GSZ.GVV.Hav = 1;
            this.GSZ.GVV.haD = str;
            e.Logd("MicroMsg.Voip.VoipServiceEx", f.apq() + "call username:" + str);
            if (this.GSZ.GVV.fIZ()) {
                e.Loge("MicroMsg.Voip.VoipServiceEx", f.apq() + "v2protocal already init.");
                this.GSZ.GVV.xh(false);
                this.GSZ.GVV.reset();
            }
            if (this.GSZ.GVV.ftD() < 0) {
                e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                AppMethodBeat.o(115174);
                return -1;
            }
            if (this.GSZ.GVV.Hcz != null) {
                this.GSZ.GVV.Hcz.GSZ = this.GSZ;
            }
            if (v2protocal.HcA != null) {
                v2protocal.HcA.a(this.GSZ);
            }
            this.GZM.startTimer(50000);
            this.GSZ.GVV.ypJ = (int) System.currentTimeMillis();
            LinkedList<csu> linkedList = new LinkedList<>();
            this.GSZ.bu(linkedList);
            this.GSZ.GVV.Hbg = "invite:" + this.GSZ.GVV.Hbb + ":" + this.GSZ.GVV.Hbc;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            new com.tencent.mm.plugin.voip.model.a.g(arrayList, this.GSZ.GVV.field_peerId, this.GSZ.GVV.field_capInfo, this.GSZ.GVV.netType, i2, this.GSZ.GVV.ypJ, linkedList).fII();
            this.GSZ.setStatus(2);
            this.GSZ.GVX.qrL = 1;
            this.GZJ.startTimer(Util.MILLSECONDS_OF_MINUTE);
            this.GSZ.GVV.Hcw.GXH = System.currentTimeMillis();
            this.GSZ.GVV.Hcw.beginTime = System.currentTimeMillis();
            this.GSZ.GVV.Hcw.GXn = i2;
            Log.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.GSZ.GVV.Hcw.GXn);
            this.GSZ.elV();
            AppMethodBeat.o(115174);
            return 0;
        }
    }

    public final int fIu() {
        AppMethodBeat.i(115175);
        Log.i("MicroMsg.Voip.VoipServiceEx", "cancelCall, roomId:" + this.GSZ.GVV.roomId);
        if (this.GSZ.GVV.roomId == 0 && this.GSZ.GVV.ypJ == 0) {
            reset();
            AppMethodBeat.o(115175);
            return -1;
        }
        this.GSZ.GVV.Hcw.GXc = this.GSZ.fGq();
        this.GSZ.GVV.Hcw.GXo = 3;
        if (this.GSZ.mStatus < 6) {
            this.GSZ.GVV.Hcw.GXq = 1;
        }
        h.INSTANCE.a(11521, true, true, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 1, Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()));
        int adr = adr(1);
        AppMethodBeat.o(115175);
        return adr;
    }

    public final int fIv() {
        AppMethodBeat.i(235696);
        Log.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + this.GSZ.GVV.roomId);
        if (this.GSZ.GVV.roomId == 0) {
            AppMethodBeat.o(235696);
            return -1;
        }
        this.GSZ.GVV.Hcw.GXc = 102;
        this.GSZ.GVV.Hcw.GXo = 6;
        if (c.fFg().GYT != null) {
            this.GSZ.GVV.Hcw.GXN = c.fFg().GYT.fFe();
            this.GSZ.GVV.Hcw.GUE = c.fFg().GYT.fFc() / 1000;
            this.GSZ.GVV.Hcw.GUF = c.fFg().GYT.fFd() / 1000;
        }
        h.INSTANCE.a(11521, true, true, Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), 3, Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()));
        int adr = adr(3);
        AppMethodBeat.o(235696);
        return adr;
    }

    public final int adr(int i2) {
        AppMethodBeat.i(115176);
        if (!this.GSZ.fGt()) {
            e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
            AppMethodBeat.o(115176);
            return -1;
        }
        Log.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d, cancelType:%d", Integer.valueOf(this.GSZ.GVV.roomId), Integer.valueOf(this.GSZ.GVV.Hat), Integer.valueOf(this.GSZ.GVV.ypJ), Integer.valueOf(i2));
        synchronized (this.GZv) {
            try {
                if (this.GSZ.GVV.roomId == 0 && this.GSZ.GVV.ypJ == 0) {
                    e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
                    return -1;
                }
                if (this.GSZ.GVV.fIZ()) {
                    this.GSZ.GVV.xh(true);
                    new com.tencent.mm.plugin.voip.model.a.c(this.GSZ.GVV.roomId, this.GSZ.GVV.ypH, this.GSZ.GVV.haD, "", this.GSZ.GVV.ypJ, i2).fII();
                }
                o oVar = this.GSZ.GVV.Hcw;
                oVar.GXx = (int) (System.currentTimeMillis() - oVar.GXH);
                e.Logd("MicroMsg.VoipDailReport", "devin:cancelInvite:" + oVar.GXx);
                if (this.GSZ.GVV.HaM == 0 && this.GSZ.GVV.HaN == 0) {
                    this.GSZ.fGp();
                }
                this.GSZ.adc(this.qtg.fKX());
                this.GSZ.GVV.Hcw.GXM = this.GSZ.GVW.fFU();
                if (c.fFg().GYT != null) {
                    this.GSZ.GVV.Hcw.GXN = c.fFg().GYT.fFe();
                    this.GSZ.GVV.Hcw.GUE = c.fFg().GYT.fFc() / 1000;
                    this.GSZ.GVV.Hcw.GUF = c.fFg().GYT.fFd() / 1000;
                }
                String fJc = v2protocal.fJc();
                String fJd = this.GSZ.GVV.fJd();
                String fJi = this.GSZ.GVV.fJi();
                String fIV = this.GSZ.GVV.fIV();
                String fIX = this.GSZ.GVV.fIX();
                String[] fJe = this.GSZ.GVV.fJe();
                String[] fJf = this.GSZ.GVV.fJf();
                String[] fJg = this.GSZ.GVV.fJg();
                String[] fJh = this.GSZ.GVV.fJh();
                if (fJd.length() > 0) {
                    new com.tencent.mm.plugin.voip.model.a.l(fJc, fJd, fIV, fJi, fIX, fJe, fJf, fJg, fJh).fII();
                }
                this.GSZ.fGn();
                reset();
                this.GSZ.GVV.roomId = 0;
                this.GSZ.GVV.ypJ = 0;
                AppMethodBeat.o(115176);
                return 0;
            } finally {
                AppMethodBeat.o(115176);
            }
        }
    }

    public final int c(int i2, long j2, int i3) {
        AppMethodBeat.i(115177);
        if (!this.GSZ.fGt()) {
            e.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall]Failed to cancel call ,as not in calling.");
            AppMethodBeat.o(115177);
            return -1;
        }
        Log.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] try to cancel my invite due to Simulcall(callee), roomId:%s, roomKey:%s, roomType:%d, msgID:%d, inviteId:%d", Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(this.GSZ.GVV.Hat), Integer.valueOf(this.GSZ.GVV.ypJ));
        synchronized (this.GZv) {
            if (i2 != 0) {
                try {
                    if (this.GSZ.GVV.ypJ != 0) {
                        new com.tencent.mm.plugin.voip.model.a.c(i2, j2, this.GSZ.GVV.haD, "", this.GSZ.GVV.ypJ, 2).fII();
                        h.INSTANCE.a(11521, true, true, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), 2, Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()));
                        Log.i("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] voipcancelinvite sent!");
                        return 0;
                    }
                } finally {
                    AppMethodBeat.o(115177);
                }
            }
            e.Loge("MicroMsg.Voip.VoipServiceEx", "steve:[simucall] Failed to cancel call with roomid = 0 and inviteId = 0 ");
            AppMethodBeat.o(115177);
            return -1;
        }
    }

    public final boolean a(ett ett) {
        boolean z;
        AppMethodBeat.i(115178);
        if (this.GSZ.fGt()) {
            e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to setInviteContent during calling, status =" + this.GSZ.mStatus);
            AppMethodBeat.o(115178);
            return false;
        } else if (ett == null) {
            AppMethodBeat.o(115178);
            return false;
        } else {
            this.GSZ.GVV.Hcw.GXn = ett.NqJ;
            Log.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.GSZ.GVV.Hcw.GXn);
            if (this.GSZ.GVV.fIZ()) {
                e.Logw("MicroMsg.Voip.VoipServiceEx", f.apq() + "v2protocal already init.");
                this.GSZ.GVV.xh(false);
                this.GSZ.GVV.reset();
            }
            this.GSZ.a(ett);
            boolean isAnchorLiving = ((aj) g.ah(aj.class)).isAnchorLiving();
            if (m.fKH() || com.tencent.mm.q.a.att() || m.fKJ() || com.tencent.mm.q.a.atu() || isAnchorLiving) {
                Log.e("MicroMsg.Voip.VoipServiceEx", "setInviteContent, reject, pstn/multitak/f2f talking");
                if (m.fKH() || com.tencent.mm.q.a.atu() || isAnchorLiving) {
                    a(ett.LsZ, ett.Lta, 2, null, null, ett.NqS);
                } else {
                    fIw();
                    if (ett.NqJ == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    s.c(ett.NqS, z ? ca.OqC : ca.OqB, 0, 6, MMApplicationContext.getContext().getString(R.string.i1c));
                }
                AppMethodBeat.o(115178);
                return false;
            } else if (this.GSZ.GVV.ftD() < 0) {
                e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                AppMethodBeat.o(115178);
                return false;
            } else {
                if (v2protocal.HcA != null) {
                    v2protocal.HcA.a(this.GSZ);
                }
                h.INSTANCE.a(11524, true, true, Integer.valueOf(ett.LsZ), Long.valueOf(ett.Lta), Integer.valueOf(ett.NqJ), 0, Long.valueOf(System.currentTimeMillis()));
                if (!this.GZE) {
                    this.GSZ.GVW.fFO();
                }
                AppMethodBeat.o(115178);
                return true;
            }
        }
    }

    public final int aH(boolean z, boolean z2) {
        AppMethodBeat.i(115179);
        fIB();
        if (!this.GZN.stopped()) {
            this.GZN.stopTimer();
        }
        this.GSZ.GVV.Hcw.fGU();
        Log.i("MicroMsg.Voip.VoipServiceEx", "accept onlyAudio:".concat(String.valueOf(z)));
        if (!this.GSZ.fGs()) {
            e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with calling, status =" + this.GSZ.mStatus);
            AppMethodBeat.o(115179);
            return -1;
        } else if (this.GSZ.GVV.roomId == 0) {
            e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to accept with roomid = 0. ");
            AppMethodBeat.o(115179);
            return -1;
        } else {
            LinkedList<csu> linkedList = new LinkedList<>();
            this.GSZ.bu(linkedList);
            this.GSZ.GVV.Hbg += "|answer:" + this.GSZ.GVV.Hbb + ":" + this.GSZ.GVV.Hbc;
            e.Logd("MicroMsg.Voip.VoipServiceEx", f.apq() + "accept invite, roomid:" + this.GSZ.GVV.roomId + " nic list size:" + linkedList.size());
            this.GZM.startTimer(50000);
            this.GSZ.GVV.Hcw.fGV();
            new b(1, this.GSZ.GVV.netType, this.GSZ.GVV.roomId, this.GSZ.GVV.field_peerId, this.GSZ.GVV.field_capInfo, this.GSZ.GVV.ypH, z, z2, linkedList).fII();
            this.GSZ.setStatus(4);
            this.GSZ.GVX.qrL = 1;
            this.GSZ.dWM = true;
            AppMethodBeat.o(115179);
            return 0;
        }
    }

    public final int fIw() {
        AppMethodBeat.i(115180);
        Log.i("MicroMsg.Voip.VoipServiceEx", "reject");
        if (!this.GSZ.fGs()) {
            e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.GSZ.mStatus);
            AppMethodBeat.o(115180);
            return -1;
        }
        synchronized (this.GZv) {
            try {
                if (this.GSZ.GVV.roomId == 0) {
                    e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
                    return -1;
                }
                this.GSZ.GVV.Hcw.fGV();
                e.Logd("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.GSZ.mStatus + " roomid:" + this.GSZ.GVV.roomId);
                new b(2, this.GSZ.GVV.netType, this.GSZ.GVV.roomId, new byte[0], new byte[0], this.GSZ.GVV.ypH, false, false, null).fII();
                if (this.GSZ.GVV.HaM == 0 && this.GSZ.GVV.HaN == 0) {
                    this.GSZ.fGp();
                }
                this.GSZ.adc(this.qtg.fKX());
                this.GSZ.GVV.Hcw.GXM = this.GSZ.GVW.fFU();
                if (c.fFg().GYT != null) {
                    this.GSZ.GVV.Hcw.GXN = c.fFg().GYT.fFe();
                    this.GSZ.GVV.Hcw.GUE = c.fFg().GYT.fFc() / 1000;
                    this.GSZ.GVV.Hcw.GUF = c.fFg().GYT.fFd() / 1000;
                }
                if (this.GSZ.GVV.fIZ()) {
                    this.GSZ.GVV.xh(true);
                }
                String fJc = v2protocal.fJc();
                String fJd = this.GSZ.GVV.fJd();
                String fJi = this.GSZ.GVV.fJi();
                String fIV = this.GSZ.GVV.fIV();
                String fIX = this.GSZ.GVV.fIX();
                String[] fJe = this.GSZ.GVV.fJe();
                String[] fJf = this.GSZ.GVV.fJf();
                String[] fJg = this.GSZ.GVV.fJg();
                String[] fJh = this.GSZ.GVV.fJh();
                e.Logd("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
                if (fJd.length() > 0) {
                    e.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
                    new com.tencent.mm.plugin.voip.model.a.l(fJc, fJd, fIV, fJi, fIX, fJe, fJf, fJg, fJh).fII();
                } else {
                    e.Logd("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
                }
                this.GSZ.fGn();
                reset();
                this.GSZ.GVV.roomId = 0;
                AppMethodBeat.o(115180);
                return 0;
            } finally {
                AppMethodBeat.o(115180);
            }
        }
    }

    public final int fIx() {
        AppMethodBeat.i(115181);
        Log.i("MicroMsg.Voip.VoipServiceEx", "hangUp");
        if (this.GSZ.GVV.roomId == 0) {
            this.GSZ.GVX.fGO();
            this.GSZ.elW();
            reset();
            AppMethodBeat.o(115181);
            return 0;
        }
        this.GSZ.GVV.Hcw.GXc = this.GSZ.fGq();
        int fIy = fIy();
        AppMethodBeat.o(115181);
        return fIy;
    }

    public final int fHS() {
        AppMethodBeat.i(235697);
        Log.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
        if (this.GSZ.GVV.roomId == 0) {
            this.GSZ.GVX.fGO();
            reset();
            AppMethodBeat.o(235697);
            return 0;
        }
        this.GSZ.GVV.Hcw.GXc = 109;
        this.GSZ.GVV.Hcw.GXu = 4;
        int fIy = fIy();
        AppMethodBeat.o(235697);
        return fIy;
    }

    public final int fIy() {
        AppMethodBeat.i(115182);
        e.Logi("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.GSZ.mStatus + " roomid:" + this.GSZ.GVV.roomId + ",threadid = " + Thread.currentThread().getId());
        this.GSZ.GVX.fGO();
        this.GSZ.elW();
        if (this.GSZ.GVV.Hcw.GXm == 1) {
            o oVar = this.GSZ.GVV.Hcw;
            if (oVar.GXD == 0) {
                oVar.GXw = 0;
            } else {
                oVar.GXw = (int) ((System.currentTimeMillis() - oVar.GXD) / 1000);
            }
            if (oVar.GXw < 0) {
                oVar.GXw = 0;
                e.Loge("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
            }
            e.Logi("MicroMsg.VoipDailReport", "devin:endTalk:" + oVar.GXw);
        }
        synchronized (this.GZv) {
            try {
                int i2 = this.GSZ.GVV.Hcw.GXo;
                if (this.GSZ.GVV.roomId != 0 || 8 == i2 || 9 == i2 || 10 == i2 || 11 == i2 || 12 == i2 || 99 == i2) {
                    e.Logi("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
                    if (this.GSZ.GVV.fIZ()) {
                        this.GSZ.GVV.xh(true);
                        new i(this.GSZ.GVV.roomId, this.GSZ.GVV.ypH, "").fII();
                        e.Loge("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
                    }
                    this.GSZ.GVV.Hcw.GXM = this.GSZ.GVW.fFU();
                    if (c.fFg().GYT != null) {
                        this.GSZ.GVV.Hcw.GXN = c.fFg().GYT.fFe();
                        this.GSZ.GVV.Hcw.GUE = c.fFg().GYT.fFc() / 1000;
                        this.GSZ.GVV.Hcw.GUF = c.fFg().GYT.fFd() / 1000;
                    }
                    this.GSZ.adc(this.qtg.fKX());
                    String fJc = v2protocal.fJc();
                    String fJd = this.GSZ.GVV.fJd();
                    String fJi = this.GSZ.GVV.fJi();
                    String fIV = this.GSZ.GVV.fIV();
                    String fIX = this.GSZ.GVV.fIX();
                    String[] fJe = this.GSZ.GVV.fJe();
                    String[] fJf = this.GSZ.GVV.fJf();
                    String[] fJg = this.GSZ.GVV.fJg();
                    String[] fJh = this.GSZ.GVV.fJh();
                    if (fJd.length() > 0) {
                        new com.tencent.mm.plugin.voip.model.a.l(fJc, fJd, fIV, fJi, fIX, fJe, fJf, fJg, fJh).fII();
                        e.Loge("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
                    }
                } else {
                    e.Loge("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
                }
                this.GSZ.fGn();
                reset();
                this.GSZ.GVV.roomId = 0;
                e.Logd("MicroMsg.Voip.VoipServiceEx", "hangUp over");
            } finally {
                AppMethodBeat.o(115182);
            }
        }
        return 0;
    }

    public final int fHT() {
        AppMethodBeat.i(115183);
        Log.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
        if (!this.GSZ.fGs()) {
            e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.GSZ.mStatus);
            AppMethodBeat.o(115183);
            return -1;
        }
        synchronized (this.GZv) {
            try {
                if (this.GSZ.GVV.roomId == 0) {
                    e.Loge("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
                    return -1;
                }
                new b(3, this.GSZ.GVV.netType, this.GSZ.GVV.roomId, new byte[0], new byte[0], this.GSZ.GVV.ypH, false, false, null).fII();
                reset();
                this.GSZ.GVV.roomId = 0;
                AppMethodBeat.o(115183);
                return 0;
            } finally {
                AppMethodBeat.o(115183);
            }
        }
    }

    public final void a(int i2, long j2, int i3, byte[] bArr, byte[] bArr2, String str) {
        AppMethodBeat.i(115184);
        e.Logi("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + i2 + "  roomKey " + j2 + " status " + i3);
        if (!(i2 == 0 || j2 == 0)) {
            LinkedList<csu> linkedList = new LinkedList<>();
            this.GSZ.bu(linkedList);
            this.GSZ.GVV.Hbg = "ack:" + this.GSZ.GVV.Hbb + ":" + this.GSZ.GVV.Hbc;
            new com.tencent.mm.plugin.voip.model.a.a(i2, j2, i3, bArr, bArr2, str, linkedList).fII();
        }
        this.GSZ.elV();
        AppMethodBeat.o(115184);
    }

    public final void fIz() {
        AppMethodBeat.i(115185);
        LinkedList<csu> linkedList = new LinkedList<>();
        this.GSZ.GVV.bv(linkedList);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < linkedList.size(); i4++) {
            if (linkedList.get(i4).Loh == 5) {
                i2++;
            }
            if (linkedList.get(i4).Loh == 4) {
                i3++;
            }
        }
        this.GSZ.GVV.Hbg += "|redirect:" + i3 + ":" + i2;
        new com.tencent.mm.plugin.voip.model.a.h(this.GSZ.GVV.roomId, this.GSZ.GVV.ypH, this.GSZ.GVV.ypO, 0, 0, null, linkedList).fII();
        AppMethodBeat.o(115185);
    }

    public final int setNetSignalValue(int i2, int i3) {
        AppMethodBeat.i(115186);
        int netSignalValue = this.GSZ.GVV.setNetSignalValue(i2, i3);
        AppMethodBeat.o(115186);
        return netSignalValue;
    }

    public final void adf(int i2) {
        AppMethodBeat.i(115187);
        this.GSZ.adf(i2);
        AppMethodBeat.o(115187);
    }

    public final int c(byte[] bArr, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(235698);
        int b2 = this.GSZ.GVX.b(bArr, i2, i3, i4, i5);
        AppMethodBeat.o(235698);
        return b2;
    }

    public final int c(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(235699);
        int b2 = this.GSZ.GVX.b(byteBuffer, i2, i3, i4, i5, i6);
        AppMethodBeat.o(235699);
        return b2;
    }

    public final void fIA() {
        AppMethodBeat.i(115193);
        if (this.qtg != null) {
            this.qtg.a(R.raw.close_lower_volume, false, 0, false);
        }
        AppMethodBeat.o(115193);
    }

    public final void stopRing() {
        AppMethodBeat.i(115194);
        if (this.qtg != null) {
            this.qtg.stop();
        }
        AppMethodBeat.o(115194);
    }

    public final boolean czl() {
        AppMethodBeat.i(115195);
        if (this.qtg != null) {
            boolean YZ = this.qtg.YZ();
            AppMethodBeat.o(115195);
            return YZ;
        }
        AppMethodBeat.o(115195);
        return true;
    }

    public final void ads(int i2) {
        AppMethodBeat.i(115196);
        this.GZw = i2;
        if (!this.GZN.stopped()) {
            this.GZN.stopTimer();
        }
        this.GZN.startTimer(70000);
        AppMethodBeat.o(115196);
    }

    public final void fIB() {
        AppMethodBeat.i(115197);
        if (this.GZJ != null) {
            e.Logi("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
            this.GZJ.stopTimer();
            this.GZJ.startTimer(Util.MILLSECONDS_OF_MINUTE);
        }
        AppMethodBeat.o(115197);
    }

    private void fIC() {
        AppMethodBeat.i(235700);
        final TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bl(new PhoneStateListener() {
                /* class com.tencent.mm.plugin.voip.model.v.AnonymousClass5 */

                public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                    int i2 = 100;
                    AppMethodBeat.i(115160);
                    super.onSignalStrengthsChanged(signalStrength);
                    String[] split = signalStrength.toString().split(" ");
                    if (telephonyManager.getNetworkType() == 13) {
                        if (split != null && split.length >= 10) {
                            int unused = v.GZx = Util.getInt(split[9], -141) + 140;
                        }
                        v.this.GZz = "LTE";
                    } else {
                        int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                        if (!signalStrength.isGsm() || gsmSignalStrength != 99) {
                            int unused2 = v.GZx = (int) (((float) gsmSignalStrength) * 3.2258065f);
                        } else {
                            int unused3 = v.GZx = -1;
                        }
                    }
                    if (v.GZx <= 100) {
                        i2 = v.GZx;
                    }
                    int unused4 = v.GZx = i2;
                    int unused5 = v.GZx = v.GZx < 0 ? 0 : v.GZx;
                    v.f(v.this);
                    AppMethodBeat.o(115160);
                }
            });
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/voip/model/VoipServiceEx", "VOIPmoileSignalStrength", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/voip/model/VoipServiceEx", "VOIPmoileSignalStrength", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        }
        AppMethodBeat.o(235700);
    }

    /* access modifiers changed from: package-private */
    public class a extends TimerTask {
        a() {
        }

        public final void run() {
            int i2 = 10;
            AppMethodBeat.i(115161);
            if (v.this.cnK != null) {
                v.this.GZD = v.this.cnK.getConnectionInfo();
            }
            if (v.this.GZD == null || v.this.GZD.getBSSID() == null || v.this.cnK == null) {
                int unused = v.lOO = -1;
            } else {
                WifiManager unused2 = v.this.cnK;
                int unused3 = v.lOO = WifiManager.calculateSignalLevel(v.this.GZD.getRssi(), 10);
                if (v.lOO <= 10) {
                    i2 = v.lOO;
                }
                int unused4 = v.lOO = i2;
                int unused5 = v.lOO = v.lOO < 0 ? 0 : v.lOO;
                v.lOO *= 10;
            }
            if (v.lOO == -1) {
                if (v.this.GZA <= 1) {
                    int unused6 = v.GZx = -1;
                }
                v.this.setNetSignalValue(1, v.GZx);
                AppMethodBeat.o(115161);
                return;
            }
            v.this.setNetSignalValue(2, v.lOO);
            AppMethodBeat.o(115161);
        }
    }

    private void fID() {
        AppMethodBeat.i(235701);
        this.cnK = (WifiManager) MMApplicationContext.getContext().getApplicationContext().getSystemService("wifi");
        if (this.GZI != null) {
            this.GZI.cancel();
        }
        this.GZI = new a();
        this.GZC = this.GZB.scheduleAtFixedRate(this.GZI, 0, (long) GZy, TimeUnit.SECONDS);
        AppMethodBeat.o(235701);
    }

    public final void adq(int i2) {
        AppMethodBeat.i(235702);
        this.cnK = null;
        this.GZD = null;
        this.GZA = 0;
        if (i2 > 0) {
            GZy = i2;
        }
        fID();
        fIC();
        AppMethodBeat.o(235702);
    }
}
