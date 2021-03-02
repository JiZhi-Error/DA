package com.tencent.mm.plugin.voip.model;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Looper;
import android.widget.RemoteViews;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.b.f;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.widget.VoipForegroundService;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cgg;
import com.tencent.mm.protocal.protobuf.efv;
import com.tencent.mm.protocal.protobuf.epd;
import com.tencent.mm.protocal.protobuf.eto;
import com.tencent.mm.protocal.protobuf.etp;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.protocal.protobuf.eud;
import com.tencent.mm.protocal.protobuf.euk;
import com.tencent.mm.protocal.protobuf.euv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class u {
    private static final f<Integer, p.a> gAU = new c(5);
    private com.tencent.mm.network.p FPE;
    public String GUy;
    public v GYS;
    public com.tencent.mm.plugin.voip.a GYT;
    public boolean GYU;
    public boolean GYV;
    public boolean GYW;
    private long GYX;
    public Map<Integer, Long> GYY;
    public int GYZ;
    public long GZa;
    public long GZb;
    public volatile b GZc;
    private Point GZd;
    public boolean GZe;
    boolean GZf;
    boolean GZg;
    public boolean GZh;
    public boolean GZi;
    private boolean GZj;
    public ett GZk;
    public long GZl;
    public boolean GZm;
    private a.AbstractC1476a GZn;
    List<a> GZo;
    public HashMap<Long, Boolean> GZp;
    public boolean dya;
    public String talker;
    public MTimerHandler zNd;

    public class a {
        ett GZr;
        boolean cancelled;
    }

    static /* synthetic */ boolean hB(Context context) {
        AppMethodBeat.i(115154);
        boolean isAppOnForeground = isAppOnForeground(context);
        AppMethodBeat.o(115154);
        return isAppOnForeground;
    }

    public u() {
        AppMethodBeat.i(115113);
        this.dya = false;
        this.GYU = false;
        this.GYV = false;
        this.GYW = false;
        this.talker = null;
        this.GYX = 0;
        this.GYY = new HashMap();
        this.GYZ = -1;
        this.GZa = 0;
        this.GZb = 0;
        this.GZe = false;
        this.GZf = false;
        this.GZg = false;
        this.GZh = false;
        this.GZi = false;
        this.GZj = false;
        this.GZk = null;
        this.GZl = 0;
        this.GUy = null;
        this.GZm = false;
        this.FPE = new p.a() {
            /* class com.tencent.mm.plugin.voip.model.u.AnonymousClass1 */

            @Override // com.tencent.mm.network.p
            public final void onNetworkChange(int i2) {
                AppMethodBeat.i(115109);
                Log.d("MicroMsg.Voip.VoipService", "network status change from ".concat(String.valueOf(i2)));
                if (u.this.dya && i2 == 4) {
                    l lVar = u.this.GYS.GSZ;
                    if (lVar.GWg == 0) {
                        lVar.GWg = lVar.GVV.Hau;
                    }
                    int netType = e.getNetType(MMApplicationContext.getContext());
                    if (netType != lVar.GWg) {
                        e.Logi("MicroMsg.Voip.VoipContext", "steve: onVoipLocalNetTypeChange: local network type change from " + lVar.GWg + " to " + netType);
                        try {
                            byte[] bArr = new byte[4];
                            bArr[0] = (byte) netType;
                            int appCmd = lVar.GVV.setAppCmd(301, bArr, 4);
                            if (appCmd < 0) {
                                e.Logi("MicroMsg.Voip.VoipContext", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetLocalNetType] update local network type" + netType + "fail:" + appCmd + ", [roomid=" + lVar.GVV.ypO + ", roomkey=" + lVar.GVV.ypH + "]");
                            }
                            epd epd = new epd();
                            epd.NmY = 3;
                            epd.NmZ = new com.tencent.mm.bw.b(bArr, 0, 1);
                            lVar.GVV.SendRUDP(epd.toByteArray(), epd.toByteArray().length);
                        } catch (Exception e2) {
                            e.Logi("MicroMsg.Voip.VoipContext", "onVoipLocalNetTypeChange Error");
                        }
                        lVar.GWg = netType;
                    }
                    u.this.GYS.fIz();
                }
                AppMethodBeat.o(115109);
            }
        };
        this.GZn = new a.AbstractC1476a() {
            /* class com.tencent.mm.plugin.voip.model.u.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.misc.a.a.AbstractC1476a
            public final void gX(int i2, int i3) {
                int handleCommand;
                AppMethodBeat.i(235666);
                Log.d("MicroMsg.Voip.VoipService", "simtype " + i2 + " reason " + i3);
                if (i3 == 3 && i2 == 1 && (handleCommand = u.this.GYS.GSZ.GVV.handleCommand(2, null, 0)) < 0) {
                    e.Loge("MicroMsg.Voip.VoipService", "v2protocal handlecommand failed ret:".concat(String.valueOf(handleCommand)));
                }
                AppMethodBeat.o(235666);
            }
        };
        this.zNd = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.voip.model.u.AnonymousClass4 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(235668);
                Log.v("MicroMsg.Voip.VoipService", "voip repeat check is foreground");
                if (u.this.GZk == null) {
                    u.this.GZl = 0;
                    u.this.zNd.stopTimer();
                    AppMethodBeat.o(235668);
                    return false;
                } else if (u.hB(MMApplicationContext.getContext())) {
                    u.this.aN(u.this.GZk.LsZ, u.this.GZk.Lta);
                    Log.i("MicroMsg.Voip.VoipService", "steve:voip callin in mRepeatCheckHandler, roomid:%d, roomkey:%s, time:%d", Integer.valueOf(u.this.GZk.LsZ), Long.valueOf(u.this.GZk.Lta), Integer.valueOf(u.this.GZk.CreateTime));
                    u.this.c(u.this.GZk);
                    u.this.GZk = null;
                    u.this.GZl = 0;
                    u.this.zNd.stopTimer();
                    h.INSTANCE.idkeyStat(500, 5, 1, false);
                    AppMethodBeat.o(235668);
                    return false;
                } else if (System.currentTimeMillis() - u.this.GZl < Util.MILLSECONDS_OF_MINUTE) {
                    AppMethodBeat.o(235668);
                    return true;
                } else {
                    u.this.GZk = null;
                    u.this.GZl = 0;
                    u.this.zNd.stopTimer();
                    AppMethodBeat.o(235668);
                    return false;
                }
            }
        }, true);
        this.GZo = null;
        this.GZp = new HashMap<>();
        this.GYS = new v();
        this.dya = false;
        this.GYU = false;
        this.GYV = false;
        this.talker = null;
        this.GYW = false;
        this.GUy = null;
        g.aAg().a(this.FPE);
        ((com.tencent.mm.plugin.misc.a.a) g.af(com.tencent.mm.plugin.misc.a.a.class)).a(this.GZn);
        AppMethodBeat.o(115113);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(115114);
        this.GYS.stop();
        this.GYS = null;
        this.GYW = false;
        g.aAg().b(this.FPE);
        ((com.tencent.mm.plugin.misc.a.a) g.af(com.tencent.mm.plugin.misc.a.a.class)).b(this.GZn);
        super.finalize();
        AppMethodBeat.o(115114);
    }

    public final void d(boolean z, boolean z2, String str) {
        AppMethodBeat.i(115115);
        Log.i("MicroMsg.Voip.VoipService", "setCalling " + z + "  videoCall " + z2 + "username " + str);
        this.dya = z;
        if (z2) {
            this.GYU = z;
            this.GYS.GSZ.GVV.HaK = 0;
        } else {
            this.GYS.GSZ.GVV.HaK = 1;
            this.GYV = z;
        }
        this.talker = str;
        this.GYS.GSZ.GVV.Hcw.jHj = str;
        AppMethodBeat.o(115115);
    }

    public final void aG(boolean z, boolean z2) {
        AppMethodBeat.i(115116);
        this.GZh = z;
        this.GZi = z2;
        Log.d("MicroMsg.Voip.VoipService", "isMinimize: %b, miniOnlyHideVoip: %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        AppMethodBeat.o(115116);
    }

    public final void bL(Context context, String str) {
        AppMethodBeat.i(115117);
        Log.i("MicroMsg.Voip.VoipService", "startVoiceCall, toUser:".concat(String.valueOf(str)));
        if (Util.isNullOrNil(str) || (System.currentTimeMillis() - this.GYX < 2000 && System.currentTimeMillis() - this.GYX > 0)) {
            AppMethodBeat.o(115117);
        } else if (System.currentTimeMillis() - this.GZa >= this.GZb || System.currentTimeMillis() - this.GZa <= 0) {
            this.GYX = System.currentTimeMillis();
            if (((l) g.af(l.class)).aSN().Kn(str) == null) {
                AppMethodBeat.o(115117);
                return;
            }
            a(context, str, this.GYS.GSZ.GVV.ypH, true, false, false);
            fHR();
            AppMethodBeat.o(115117);
        } else {
            Log.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
            com.tencent.mm.ui.base.h.a(context, (int) R.string.i4a, (int) R.string.i58, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(115117);
        }
    }

    public final void bM(Context context, String str) {
        AppMethodBeat.i(115118);
        Log.i("MicroMsg.Voip.VoipService", "startVideoCall, toUser:".concat(String.valueOf(str)));
        if (Util.isNullOrNil(str) || (System.currentTimeMillis() - this.GYX < 2000 && System.currentTimeMillis() - this.GYX > 0)) {
            AppMethodBeat.o(115118);
        } else if (System.currentTimeMillis() - this.GZa >= this.GZb || System.currentTimeMillis() - this.GZa <= 0) {
            this.GYX = System.currentTimeMillis();
            if (((l) g.af(l.class)).aSN().Kn(str) == null) {
                AppMethodBeat.o(115118);
                return;
            }
            a(context, str, this.GYS.GSZ.GVV.ypH, true, true, false);
            fHR();
            AppMethodBeat.o(115118);
        } else {
            Log.i("MicroMsg.Voip.VoipService", "fail! cuz overloadInterval fail!");
            com.tencent.mm.ui.base.h.a(context, (int) R.string.i4a, (int) R.string.i58, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(115118);
        }
    }

    private static void fHR() {
        AppMethodBeat.i(115119);
        zj zjVar = new zj();
        zjVar.efx.dKy = 7;
        EventCenter.instance.publish(zjVar);
        AppMethodBeat.o(115119);
    }

    private int b(ett ett) {
        int i2;
        int i3;
        int i4 = -1;
        boolean z = true;
        AppMethodBeat.i(115120);
        String aTY = z.aTY();
        if (ett != null) {
            String str = ett.NqS;
            int i5 = ett.NqJ;
            Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] being called! roomid:%d, myname:%s, remoteInviteName:%s,myInviteName:%s, calltype:%d, working:%b, dialing:%b, isSimulCall:%b", Integer.valueOf(ett.LsZ), aTY, str, this.GYS.GZH, Integer.valueOf(i5), Boolean.valueOf(this.GYS.fGt()), Boolean.valueOf(this.GYS.GSZ.fGr()), Boolean.valueOf(this.GYS.GZE));
            if (this.GYS.fGt() && this.GYS.GSZ != null && this.GYS.GSZ.fGr() && !this.GYS.GZE) {
                String str2 = this.GYS.GZH;
                if (str == null || str2 == null) {
                    Log.e("MicroMsg.Voip.VoipService", "steve:[simucall] name null! myname:%s, remoteInviteName:%s, myInviteName:%s", aTY, str, str2);
                    AppMethodBeat.o(115120);
                } else {
                    boolean equals = str2.equals(str);
                    Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]  mutualCalling:%s", Boolean.valueOf(equals));
                    if (equals) {
                        this.GYS.GZE = true;
                        int compareTo = str2.compareTo(aTY);
                        boolean contains = str2.contains("@");
                        if (compareTo < 0 || contains) {
                            i4 = 1;
                        } else {
                            i4 = 2;
                        }
                        this.GYS.GSZ.GVV.Hcx |= 2;
                        if (this.GYT.fEZ()) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        if (i5 == 1 || i2 == 1) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (this.GYT.fEZ() && i3 == 1) {
                            Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]audio room, close camera first! myInviteType:%d, finalRoomType:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                            this.GYS.GZt = false;
                            fIg();
                            this.GYS.GSZ.GVW.acQ(1);
                        }
                        ett.NqJ = i3;
                        this.GYS.GZF = i3;
                        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]myInviteName:%s, mutualCalling:%s,caller:%d,myInviteType:%d,finalType:%d", str2, Boolean.valueOf(equals), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3));
                        if (i4 == 2) {
                            Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] i'm callee, cancel my previous invite!");
                            this.GYS.GZG = true;
                            if (!(this.GYS.GSZ.GVV == null || this.GYS.GSZ.GVV.roomId == 0 || this.GYS.GSZ.GVV.ypH == 0 || this.GYS.GSZ.GVV.roomId == ett.LsZ)) {
                                b(this.GYS.GSZ.GVV.roomId, this.GYS.GSZ.GVV.ypH, i2);
                            }
                            if (i3 != 0) {
                                z = false;
                            }
                            this.GYT.wQ(z);
                        } else {
                            this.GYS.GZG = false;
                            Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] i'm caller, do NOT answer others' invite!");
                        }
                    } else {
                        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall] myInviteName:%s, mutualCalling:%s", str2, Boolean.valueOf(equals));
                    }
                }
            }
            if (this.GYS.GZE) {
                ett.NqJ = this.GYS.GZF;
            }
            AppMethodBeat.o(115120);
        } else {
            AppMethodBeat.o(115120);
        }
        return i4;
    }

    public final void aN(final int i2, final long j2) {
        AppMethodBeat.i(115121);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.voip.model.u.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(235667);
                Log.i("MicroMsg.Voip.VoipService", "onDelayInvite, roomId:%s, roomKey:%s", Integer.valueOf(i2), Long.valueOf(j2));
                if (!com.tencent.mm.n.g.apP() && !u.hB(MMApplicationContext.getContext())) {
                    Log.i("MicroMsg.Voip.VoipService", "background now and notification Is closed.");
                    AppMethodBeat.o(235667);
                } else if (u.this.GYS.fIq()) {
                    Log.i("MicroMsg.Voip.VoipService", "room is ready, ingore the msg and ack busy");
                    if (!(u.this.GYS.GSZ.GVV.roomId == i2 || u.this.GYS.GSZ.GVV.ypH == j2)) {
                        Log.i("MicroMsg.Voip.VoipService", "not match current room id and roomkey: %s %s %s %s", Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(u.this.GYS.GSZ.GVV.roomId), Long.valueOf(u.this.GYS.GSZ.GVV.ypH));
                        u.this.GYS.a(i2, j2, 2, null, null, u.this.talker);
                    }
                    AppMethodBeat.o(235667);
                } else {
                    new com.tencent.mm.plugin.voip.model.a.e(i2, j2, "").fII();
                    Log.i("MicroMsg.Voip.VoipService", "onDelayInvite, send getroominfo cgi done! roomId:%d, roomKey:%s", Integer.valueOf(i2), Long.valueOf(j2));
                    if (!u.this.GZm) {
                        e.c(i2, j2, 1, 2);
                        u.this.GZm = true;
                    }
                    AppMethodBeat.o(235667);
                }
            }
        });
        AppMethodBeat.o(115121);
    }

    public final void c(ett ett) {
        AppMethodBeat.i(115122);
        if (this.GYS.GSZ.GVV.Hcx != 0) {
            Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall already processed, return! VoipGetRoomInfoResp roomid:%d, roomType:%d, mProtocol.roomId:%d, iSimulCallStatus:%d ", Integer.valueOf(ett.LsZ), Integer.valueOf(ett.NqJ), Integer.valueOf(this.GYS.GSZ.GVV.roomId), Integer.valueOf(this.GYS.GSZ.GVV.Hcx));
            AppMethodBeat.o(115122);
            return;
        }
        int i2 = ett.NqJ;
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_newsimulcall_switch, false);
        Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin bNewSimulCallSwitch:%b ", Boolean.valueOf(a2));
        int i3 = -1;
        if (a2) {
            i3 = b(ett);
        }
        if (i3 == 1) {
            this.GYS.a(ett.LsZ, ett.Lta, 5, null, null, ett.NqS);
            Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall caller send ack roomid:%d, finalRoomType:%d, orgRoomType:%d ", Integer.valueOf(ett.LsZ), Integer.valueOf(ett.NqJ), Integer.valueOf(i2));
            h.INSTANCE.a(11525, true, true, Integer.valueOf(ett.LsZ), Long.valueOf(ett.Lta), Integer.valueOf(i2), 6, Integer.valueOf(e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(115122);
        } else if (com.tencent.mm.n.g.apP() || isAppOnForeground(MMApplicationContext.getContext())) {
            String str = ett.NqS;
            String aTY = z.aTY();
            int i4 = ett.NqJ;
            Log.i("MicroMsg.Voip.VoipService", "doTaskCallin self:%s talker:%s type:%d roomid:%d, roomkey:%s, time:%d", aTY, str, Integer.valueOf(i4), Integer.valueOf(ett.LsZ), Long.valueOf(ett.Lta), Integer.valueOf(ett.CreateTime));
            if (this.GYS.fGt() && !this.GYS.GZE) {
                this.GYS.a(ett.LsZ, ett.Lta, 2, null, null, str);
                Log.i("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because voip busy:roomid " + ett.LsZ);
                h.INSTANCE.a(11525, true, true, Integer.valueOf(ett.LsZ), Long.valueOf(ett.Lta), Integer.valueOf(ett.NqJ), 2, Integer.valueOf(e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()));
                h.INSTANCE.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGu()), 7);
                e.adG(0);
                AppMethodBeat.o(115122);
            } else if (v.fIs()) {
                this.GYS.a(ett.LsZ, ett.Lta, 3, null, null, str);
                Log.e("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because telephone busy:roomid " + ett.LsZ);
                h.INSTANCE.a(11525, true, true, Integer.valueOf(ett.LsZ), Long.valueOf(ett.Lta), Integer.valueOf(ett.NqJ), 3, Integer.valueOf(e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()));
                h.INSTANCE.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGu()), 7);
                e.adG(0);
                AppMethodBeat.o(115122);
            } else {
                this.GYS.fIt();
                if (this.GYS.GZG) {
                    if (this.GYS.GSZ.GVV.roomId != ett.LsZ) {
                        this.GYS.GSZ.GVv = true;
                        this.GYS.GSZ.GVx = false;
                        this.GYS.GSZ.GVw = false;
                        this.GYS.GSZ.GVV.Hbk = 0;
                        this.GYS.GSZ.GVV.Hbj = 0;
                        this.GYS.GSZ.setStatus(3);
                        this.GYS.GSZ.GVV.roomId = ett.LsZ;
                        this.GYS.GSZ.GVV.ypH = ett.Lta;
                        this.GYS.GSZ.GVV.ypO = 1;
                        this.GYS.GSZ.GVW.acS(i4);
                    }
                    Log.i("MicroMsg.Voip.VoipService", "steve:[simucall]doTaskCallin simulcall auto-accept! mProtocol.roomId=%d, roomInfo.roomId=%d", Integer.valueOf(this.GYS.GSZ.GVV.roomId), Integer.valueOf(ett.LsZ));
                    AppMethodBeat.o(115122);
                } else if (!this.GYS.a(ett)) {
                    Log.e("MicroMsg.Voip.VoipService", "doTaskCallin setInviteContent failed!");
                    h.INSTANCE.a(11525, true, true, Integer.valueOf(ett.LsZ), Long.valueOf(ett.Lta), Integer.valueOf(ett.NqJ), 5, Integer.valueOf(e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()));
                    h.INSTANCE.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGu()), 7);
                    e.adG(0);
                    AppMethodBeat.o(115122);
                } else {
                    Context context = MMApplicationContext.getContext();
                    if (((l) g.af(l.class)).aSN().Kn(str) == null) {
                        this.GYS.a(ett.LsZ, ett.Lta, 4, null, null, str);
                        Log.d("MicroMsg.Voip.VoipService", "doTaskCallin invite ignor because talker nil:roomid " + ett.LsZ);
                        h.INSTANCE.a(11525, true, true, Integer.valueOf(ett.LsZ), Long.valueOf(ett.Lta), Integer.valueOf(ett.NqJ), 4, Integer.valueOf(e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()));
                        h.INSTANCE.a(11526, true, true, Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGu()), 7);
                        e.adG(0);
                        AppMethodBeat.o(115122);
                        return;
                    }
                    if (1 == i4 || i4 == 0) {
                        try {
                            a(context, str, this.GYS.GSZ.GVV.ypH, false, i4 == 0, true);
                            if (this.GYS != null) {
                                this.GYS.ads(ett.LsZ);
                            }
                            Log.d("MicroMsg.Voip.VoipService", "doTaskCallin invite startActivity VideoActivity");
                        } catch (Exception e2) {
                            e.adG(2);
                        }
                    }
                    this.GYS.a(ett.LsZ, ett.Lta, 1, this.GYS.GSZ.GVV.field_peerId, this.GYS.GSZ.GVV.field_capInfo, str);
                    h.INSTANCE.a(11525, true, true, Integer.valueOf(ett.LsZ), Long.valueOf(ett.Lta), Integer.valueOf(ett.NqJ), 1, Integer.valueOf(e.getNetType(MMApplicationContext.getContext())), Long.valueOf(System.currentTimeMillis()));
                    AppMethodBeat.o(115122);
                }
            }
        } else {
            Log.i("MicroMsg.Voip.VoipService", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
            if (this.GZk == null && this.zNd.stopped()) {
                Log.i("MicroMsg.Voip.VoipService", "voipGetRoomInfoResp is null and time is stopped.");
                this.GZk = ett;
                this.zNd.startTimer(2000);
                this.GZl = System.currentTimeMillis();
                Log.i("MicroMsg.Voip.VoipService", "steve:voip roominfo stored!! roomid:%d, roomkey:%s, time:%d", Integer.valueOf(this.GZk.LsZ), Long.valueOf(this.GZk.Lta), Integer.valueOf(this.GZk.CreateTime));
                h.INSTANCE.idkeyStat(500, 4, 1, false);
                e.adG(0);
            }
            AppMethodBeat.o(115122);
        }
    }

    public final void adm(int i2) {
        int i3 = 1;
        AppMethodBeat.i(115123);
        if (this.GZo == null || this.GZo.isEmpty()) {
            AppMethodBeat.o(115123);
            return;
        }
        for (a aVar : this.GZo) {
            if (!(aVar == null || aVar.GZr == null)) {
                this.GZp.put(Long.valueOf(this.GYS.GSZ.GVV.ypH), Boolean.TRUE);
                if (aVar.GZr.LsZ == i2) {
                    aVar.cancelled = true;
                    String str = this.GYS.toUser;
                    String str2 = this.GYS.GZt ? ca.OqC : ca.OqB;
                    if (!this.GYS.GZs) {
                        i3 = 0;
                    }
                    s.c(str, str2, i3, 4, MMApplicationContext.getContext().getString(R.string.i14));
                    AppMethodBeat.o(115123);
                    return;
                }
            }
        }
        AppMethodBeat.o(115123);
    }

    static {
        AppMethodBeat.i(115155);
        AppMethodBeat.o(115155);
    }

    public static p.a aUy(String str) {
        AppMethodBeat.i(115124);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(115124);
            return null;
        }
        int hashCode = str.hashCode();
        p.a aVar = gAU.get(Integer.valueOf(hashCode));
        if (aVar != null) {
            AppMethodBeat.o(115124);
            return aVar;
        }
        p.a aVar2 = new p.a();
        if (!aVar2.parse(str)) {
            AppMethodBeat.o(115124);
            return null;
        }
        gAU.x(Integer.valueOf(hashCode), aVar2);
        AppMethodBeat.o(115124);
        return aVar2;
    }

    private static Map<Integer, Long> cl(byte[] bArr) {
        AppMethodBeat.i(115125);
        if (Util.isNullOrNil(bArr)) {
            AppMethodBeat.o(115125);
            return null;
        }
        try {
            efv efv = (efv) new efv().parseFrom(bArr);
            if (efv == null) {
                AppMethodBeat.o(115125);
                return null;
            }
            Log.d("MicroMsg.Voip.VoipService", "dkpush : keyCount:" + efv.MXU);
            LinkedList<cgg> linkedList = efv.MXV;
            if (linkedList.size() != efv.MXU) {
                AppMethodBeat.o(115125);
                return null;
            }
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < efv.MXU; i2++) {
                hashMap.put(Integer.valueOf(linkedList.get(i2).Cya), Long.valueOf(Util.MAX_32BIT_VALUE & ((long) linkedList.get(i2).MlT)));
            }
            if (hashMap.size() != efv.MXU) {
                AppMethodBeat.o(115125);
                return null;
            }
            AppMethodBeat.o(115125);
            return hashMap;
        } catch (Exception e2) {
            AppMethodBeat.o(115125);
            return null;
        }
    }

    private static byte[] aW(Map<Integer, Long> map) {
        AppMethodBeat.i(115126);
        efv efv = new efv();
        LinkedList<cgg> linkedList = new LinkedList<>();
        for (Integer num : map.keySet()) {
            cgg cgg = new cgg();
            cgg.Cya = num.intValue();
            cgg.MlT = map.get(num).intValue();
            linkedList.push(cgg);
        }
        efv.MXV = linkedList;
        efv.MXU = linkedList.size();
        try {
            byte[] byteArray = efv.toByteArray();
            AppMethodBeat.o(115126);
            return byteArray;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.Voip.VoipService", e2, "", new Object[0]);
            AppMethodBeat.o(115126);
            return null;
        }
    }

    private static String cm(byte[] bArr) {
        AppMethodBeat.i(115127);
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(hexString));
            }
            str = str + hexString.toUpperCase();
        }
        AppMethodBeat.o(115127);
        return str;
    }

    public final int b(byte[] bArr, int i2, long j2) {
        long j3;
        long j4;
        SKBuiltinBuffer_t sKBuiltinBuffer_t;
        euk euk;
        eud eud;
        euv euv;
        AppMethodBeat.i(115128);
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        Log.i("MicroMsg.Voip.VoipService", "__parse voip notify begin");
        Map<Integer, Long> cl = cl(this.GYS.GSZ.GVZ);
        if (cl == null) {
            Log.i("MicroMsg.Voip.VoipService", "local voipsynckey buff nil");
            j3 = 0;
        } else {
            long j10 = 0;
            for (Integer num : cl.keySet()) {
                Long l = cl.get(num);
                switch (num.intValue()) {
                    case 1:
                        j5 = l.longValue();
                        break;
                    case 2:
                        j6 = l.longValue();
                        break;
                    case 3:
                        j10 = l.longValue();
                        break;
                    default:
                        Log.i("MicroMsg.Voip.VoipService", "parse local voipsynckey:" + num.intValue() + ",value:" + l);
                        break;
                }
            }
            j3 = j10;
        }
        Log.i("MicroMsg.Voip.VoipService", "local voip synckey: statuskey:" + j5 + " relayData key:" + j6 + " connectingStatusKey:" + j3);
        try {
            etp etp = (etp) new etp().parseFrom(bArr);
            int i3 = 0;
            while (i3 < etp.NqL.size()) {
                eto eto = etp.NqL.get(i3);
                Log.i("MicroMsg.Voip.VoipService", "__parse voip notify, item cmdid:" + eto.Lms);
                if (eto.Lms == 1) {
                    try {
                        euv = (euv) new euv().parseFrom(eto.KMS.getBufferToBytes());
                    } catch (IOException e2) {
                        Log.i("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                        Log.printErrStackTrace("MicroMsg.Voip.VoipService", e2, "", new Object[0]);
                        euv = null;
                    }
                    if (euv != null) {
                        Log.i("MicroMsg.Voip.VoipService", "voip notify status:" + euv.oTW);
                        if (j7 < ((long) eto.Cya)) {
                            j7 = (long) eto.Cya;
                        }
                        if (((long) eto.Cya) > j5) {
                            Log.i("MicroMsg.Voip.VoipService", "voiop notify status key[" + eto.Cya + "] > local status key[" + j5 + "] status[" + euv.oTW + "]");
                            this.GYS.GSZ.GVY.a(euv, 1);
                            j4 = j9;
                        }
                    } else {
                        Log.i("MicroMsg.Voip.VoipService", "parse Voip notify status item fail");
                    }
                    j4 = j9;
                } else if (eto.Lms == 2) {
                    try {
                        euk = (euk) new euk().parseFrom(eto.KMS.getBufferToBytes());
                    } catch (IOException e3) {
                        Log.i("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                        Log.printErrStackTrace("MicroMsg.Voip.VoipService", e3, "", new Object[0]);
                        euk = null;
                    }
                    if (euk != null) {
                        Log.i("MicroMsg.Voip.VoipService", "notify relay data type:" + euk.oUv);
                        if (j8 < ((long) eto.Cya)) {
                            j8 = (long) eto.Cya;
                        }
                        if (((long) eto.Cya) > j6) {
                            Log.i("MicroMsg.Voip.VoipService", "notify relaydata key:[" + eto.Cya + "] > local relaydata key[" + j6 + "]");
                            if (euk.oUv == 5) {
                                this.GYS.GSZ.GVY.a(euk);
                                j4 = j9;
                            } else if (euk.oUv == 1) {
                                this.GYS.GSZ.GVY.b(euk);
                                j4 = j9;
                            } else if (euk.oUv == 6) {
                                try {
                                    eud = (eud) new eud().parseFrom(euk.KMS.getBuffer().toByteArray());
                                } catch (IOException e4) {
                                    Log.printErrStackTrace("MicroMsg.Voip.VoipService", e4, "", new Object[0]);
                                    eud = null;
                                }
                                if (eud != null) {
                                    this.GYS.GSZ.GVY.a(eud);
                                }
                                j4 = j9;
                            } else {
                                Log.i("MicroMsg.Voip.VoipService", "notify relaydata unknown type:" + euk.oUv);
                                j4 = j9;
                            }
                        } else {
                            Log.i("MicroMsg.Voip.VoipService", "notify relaydata item key[" + eto.Cya + "] <=local relaydatakey[" + j6 + "]");
                            j4 = j9;
                        }
                    } else {
                        Log.i("MicroMsg.Voip.VoipService", "parse Voip notify relaydata item fail");
                        j4 = j9;
                    }
                } else {
                    if (eto.Lms == 3) {
                        try {
                            sKBuiltinBuffer_t = new SKBuiltinBuffer_t().parseFrom(eto.KMS.getBufferToBytes());
                        } catch (IOException e5) {
                            Log.printErrStackTrace("MicroMsg.Voip.VoipService", e5, "", new Object[0]);
                            sKBuiltinBuffer_t = null;
                        }
                        if (sKBuiltinBuffer_t != null) {
                            if (j9 < ((long) eto.Cya)) {
                                j4 = (long) eto.Cya;
                            } else {
                                j4 = j9;
                            }
                            if (((long) eto.Cya) > j3) {
                                Log.i("MicroMsg.Voip.VoipService", "notify connectingStatkey[" + eto.Cya + "]> local connectingstatus key[" + j3 + "]");
                                this.GYS.GSZ.GVY.c(sKBuiltinBuffer_t);
                                if (this.GZk != null && (e.co(sKBuiltinBuffer_t.getBuffer().toByteArray()) & 255) == 1) {
                                    this.GZk.NqJ = 1;
                                }
                            }
                        }
                    }
                    j4 = j9;
                }
                i3++;
                j9 = j4;
            }
            if (j7 <= j5) {
                j7 = j5;
            }
            if (j8 <= j6) {
                j8 = j6;
            }
            if (j9 <= j3) {
                j9 = j3;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(1, Long.valueOf(j7));
            hashMap.put(2, Long.valueOf(j8));
            hashMap.put(3, Long.valueOf(j9));
            byte[] aW = aW(hashMap);
            if (i2 == this.GYS.GSZ.GVV.roomId && j2 == this.GYS.GSZ.GVV.ypH) {
                this.GYS.GSZ.GVZ = aW;
                Log.i("MicroMsg.Voip.VoipService", "voipNotify:ext notify data new keys:" + j7 + ", " + j8 + ", " + j9);
            }
            Log.i("MicroMsg.Voip.VoipService", "__parse voip notify end");
            AppMethodBeat.o(115128);
            return 0;
        } catch (Exception e6) {
            Log.printErrStackTrace("MicroMsg.Voip.VoipService", e6, "", new Object[0]);
            Log.i("MicroMsg.Voip.VoipService", "parse voip extNotifyData fail extNotifyData size " + bArr.length + " first byte " + cm(bArr));
            AppMethodBeat.o(115128);
            return 0;
        }
    }

    public static byte[] ae(byte[] bArr, int i2) {
        byte[] bArr2 = new byte[i2];
        for (int i3 = 12; i3 < i2 + 12; i3++) {
            bArr2[i3 - 12] = bArr[i3];
        }
        return bArr2;
    }

    public final void a(Context context, x xVar) {
        AppMethodBeat.i(235670);
        this.GYS.a(context, xVar);
        AppMethodBeat.o(235670);
    }

    public final void b(Context context, x xVar) {
        AppMethodBeat.i(235671);
        this.GYS.b(context, xVar);
        AppMethodBeat.o(235671);
    }

    public final int aUz(String str) {
        AppMethodBeat.i(235672);
        int fU = this.GYS.fU(str, 1);
        AppMethodBeat.o(235672);
        return fU;
    }

    public final int aUA(String str) {
        AppMethodBeat.i(235673);
        int fU = this.GYS.fU(str, 0);
        AppMethodBeat.o(235673);
        return fU;
    }

    public final int aH(boolean z, boolean z2) {
        AppMethodBeat.i(115129);
        int aH = this.GYS.aH(z, z2);
        AppMethodBeat.o(115129);
        return aH;
    }

    public final int fHS() {
        AppMethodBeat.i(235674);
        this.GYS.fHS();
        AppMethodBeat.o(235674);
        return 0;
    }

    public final int fHT() {
        AppMethodBeat.i(235675);
        this.GYS.fHT();
        AppMethodBeat.o(235675);
        return 0;
    }

    public final void adf(int i2) {
        AppMethodBeat.i(115130);
        this.GYS.adf(i2);
        AppMethodBeat.o(115130);
    }

    public final int fHU() {
        return this.GYS.GSZ.GVV.roomId;
    }

    public final long fHV() {
        return this.GYS.GSZ.GVV.ypH;
    }

    public final long fGu() {
        AppMethodBeat.i(260040);
        long fGu = this.GYS.GSZ.fGu();
        AppMethodBeat.o(260040);
        return fGu;
    }

    public final int b(int i2, long j2, int i3) {
        AppMethodBeat.i(115132);
        int c2 = this.GYS.c(i2, j2, i3);
        AppMethodBeat.o(115132);
        return c2;
    }

    public final void fHW() {
        AppMethodBeat.i(235677);
        n nVar = this.GYS.GSZ.GVX;
        if (nVar.qrH != null) {
            nVar.qrH.de(true);
        }
        AppMethodBeat.o(235677);
    }

    public final void fHX() {
        AppMethodBeat.i(235678);
        n nVar = this.GYS.GSZ.GVX;
        if (nVar.qrH != null) {
            nVar.qrH.de(false);
        }
        AppMethodBeat.o(235678);
    }

    public final int bhV() {
        AppMethodBeat.i(185953);
        n nVar = this.GYS.GSZ.GVX;
        if (nVar.GWB != null) {
            int bhV = nVar.GWB.bhV();
            AppMethodBeat.o(185953);
            return bhV;
        }
        AppMethodBeat.o(185953);
        return 0;
    }

    public final void adn(int i2) {
        AppMethodBeat.i(115134);
        Log.d("MicroMsg.Voip.VoipService", "devin: camera errcode: %d", Integer.valueOf(i2));
        this.GYS.adn(i2);
        AppMethodBeat.o(115134);
    }

    public final void fHY() {
        AppMethodBeat.i(115135);
        Log.d("MicroMsg.Voip.VoipService", "devin: setCallResult: %d", 1);
        this.GYS.GSZ.GVV.Hcw.GXo = 1;
        AppMethodBeat.o(115135);
    }

    public final int a(byte[] bArr, int i2, int i3, int i4, int i5, int[] iArr, boolean z) {
        boolean z2;
        AppMethodBeat.i(115136);
        n nVar = this.GYS.GSZ.GVX;
        if ((!z) && (nVar.qrL == n.qrK)) {
            AppMethodBeat.o(115136);
            return -1;
        } else if (!nVar.GSZ.GVV.fIZ()) {
            AppMethodBeat.o(115136);
            return -1;
        } else {
            int videoEncodeToLocal = nVar.GSZ.GVV.videoEncodeToLocal(bArr, i2, i4, i5, i3, 0, 75, iArr);
            AppMethodBeat.o(115136);
            return videoEncodeToLocal;
        }
    }

    public final int a(byte[] bArr, int i2, int i3, int i4, int i5, byte[] bArr2, int i6, int i7, int i8, int i9) {
        AppMethodBeat.i(235679);
        n nVar = this.GYS.GSZ.GVX;
        if (nVar.qrL == n.qrK) {
            AppMethodBeat.o(235679);
            return -1;
        } else if (!nVar.GSZ.GVV.fIZ()) {
            AppMethodBeat.o(235679);
            return -1;
        } else if (!nVar.GSZ.fGz()) {
            AppMethodBeat.o(235679);
            return -2;
        } else {
            int videoRorate90D = nVar.GSZ.GVV.videoRorate90D(bArr, i2, i3, i4, i5, bArr2, i6, i7, i8, i9);
            AppMethodBeat.o(235679);
            return videoRorate90D;
        }
    }

    public final int c(byte[] bArr, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(235680);
        int c2 = this.GYS.c(bArr, i2, i3, i4, i5);
        AppMethodBeat.o(235680);
        return c2;
    }

    public final void fHZ() {
        AppMethodBeat.i(235681);
        n nVar = this.GYS.GSZ.GVX;
        if (nVar.GSZ == null || nVar.GSZ.GVV == null) {
            com.tencent.mm.plugin.voip.b.c cVar = com.tencent.mm.plugin.voip.b.c.HgQ;
            com.tencent.mm.plugin.voip.b.c.clear();
            AppMethodBeat.o(235681);
            return;
        }
        byte[] bArr = new byte[4];
        if (nVar.GSZ.GVV.setAppCmd(n.GTO, bArr, 4) >= 0) {
            int byteArrayToInt = Util.byteArrayToInt(bArr);
            int i2 = byteArrayToInt >> 16;
            int i3 = byteArrayToInt & 65535;
            if (!v2protocal.Haq && (i2 >= 1280 || i3 >= 1280)) {
                i2 >>= 1;
                i3 >>= 1;
            }
            com.tencent.mm.plugin.voip.b.c cVar2 = com.tencent.mm.plugin.voip.b.c.HgQ;
            com.tencent.mm.plugin.voip.b.c.ec(i2, i3);
        }
        AppMethodBeat.o(235681);
    }

    public final int c(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(235682);
        int c2 = this.GYS.c(byteBuffer, i2, i3, i4, i5, i6);
        AppMethodBeat.o(235682);
        return c2;
    }

    public final int jB(int i2, int i3) {
        n nVar = this.GYS.GSZ.GVX;
        nVar.GSZ.GVV.HbN = i2;
        nVar.GSZ.GVV.HbO = i3;
        return 0;
    }

    public final int fIc() {
        return this.GYS.GSZ.GVX.GSZ.GVV.field_sendVideoLen;
    }

    public final int fId() {
        return this.GYS.GSZ.GVX.GSZ.GVV.field_recvVideoLen;
    }

    public final byte[] fIe() {
        return this.GYS.GSZ.GVV.HbP;
    }

    public final boolean wS(boolean z) {
        AppMethodBeat.i(115137);
        n nVar = this.GYS.GSZ.GVX;
        if (nVar.GWB != null) {
            boolean wS = nVar.GWB.wS(z);
            AppMethodBeat.o(115137);
            return wS;
        }
        AppMethodBeat.o(115137);
        return false;
    }

    public final int xd(boolean z) {
        int appCmd;
        AppMethodBeat.i(115138);
        l lVar = this.GYS.GSZ;
        if (z) {
            appCmd = lVar.GVV.setAppCmd(412);
        } else {
            appCmd = lVar.GVV.setAppCmd(413);
        }
        if (appCmd < 0) {
            e.Loge("MicroMsg.Voip.VoipContext", "voipContext tryMuteMicrophone ret:".concat(String.valueOf(appCmd)));
        }
        AppMethodBeat.o(115138);
        return appCmd;
    }

    public final int xe(boolean z) {
        int appCmd;
        AppMethodBeat.i(115139);
        l lVar = this.GYS.GSZ;
        if (z) {
            appCmd = lVar.GVV.setAppCmd(401);
        } else {
            appCmd = lVar.GVV.setAppCmd(402);
        }
        if (appCmd < 0) {
            e.Logi("MicroMsg.Voip.VoipContext", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(appCmd)));
        }
        AppMethodBeat.o(115139);
        return appCmd;
    }

    public final void bk(int i2, boolean z) {
        AppMethodBeat.i(115140);
        v vVar = this.GYS;
        if (vVar.qtg != null) {
            vVar.qtg.bl(i2, z);
        }
        AppMethodBeat.o(115140);
    }

    public final void ado(int i2) {
        AppMethodBeat.i(115141);
        v vVar = this.GYS;
        if (vVar.qtg != null) {
            vVar.qtg.g(R.raw.close_lower_volume, false, i2);
        }
        AppMethodBeat.o(115141);
    }

    public final void stopRing() {
        AppMethodBeat.i(260041);
        this.GYS.stopRing();
        AppMethodBeat.o(260041);
    }

    public final boolean czl() {
        AppMethodBeat.i(260042);
        boolean czl = this.GYS.czl();
        AppMethodBeat.o(260042);
        return czl;
    }

    public final void xf(boolean z) {
        AppMethodBeat.i(235685);
        v vVar = this.GYS;
        if (vVar.qtg != null) {
            vVar.qtg.xw(z);
        }
        AppMethodBeat.o(235685);
    }

    public final void unRegister() {
        AppMethodBeat.i(115142);
        Log.i("MicroMsg.Voip.VoipService", "unRegister and remove all notification and voip foreground service");
        this.GYW = false;
        fIh();
        enB();
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        AppMethodBeat.o(115142);
    }

    public final void enB() {
        AppMethodBeat.i(162308);
        this.GZc = null;
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(41);
        AppMethodBeat.o(162308);
    }

    public final boolean fIf() {
        boolean z = false;
        AppMethodBeat.i(115143);
        try {
            if (!(this.GYS.GSZ.GVV == null || (this.GYS.GSZ.GVV.Hbp & 8) == 0)) {
                z = true;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.Voip.VoipService", "steve:cannot get CPU usage! error: " + e2.getMessage());
        }
        AppMethodBeat.o(115143);
        return z;
    }

    public final void a(Context context, String str, long j2, boolean z, boolean z2, boolean z3) {
        Context context2;
        String string;
        AppMethodBeat.i(235686);
        if (context == null) {
            context2 = MMApplicationContext.getContext();
        } else {
            context2 = context;
        }
        this.GYS.toUser = str;
        this.GYS.GZs = z;
        this.GYS.GZt = z2;
        enB();
        long currentTimeMillis = System.currentTimeMillis();
        kv kvVar = new kv();
        kvVar.dPV.dPY = false;
        kvVar.dPV.dPX = currentTimeMillis;
        kvVar.dPV.dPW = context2;
        EventCenter.instance.publish(kvVar);
        Log.printInfoStack("MicroMsg.Voip.VoipService", "start VideoActivity in foreground,%s", Boolean.valueOf(AppForegroundDelegate.INSTANCE.cPB));
        boolean z4 = d.oF(28) || Build.VERSION.CODENAME.equals("Q");
        RemoteViews remoteViews = null;
        Intent intent = new Intent(context2, VideoActivity.class);
        intent.putExtra("Voip_User", str);
        intent.putExtra("Voip_Outcall", z);
        intent.putExtra("Voip_VideoCall", z2);
        intent.putExtra("Voip_LastPage_Hash", currentTimeMillis);
        intent.putExtra("Voip_CallRoomKey", j2);
        String str2 = "";
        if (!z && z4 && !AppForegroundDelegate.INSTANCE.cPB) {
            this.GZc = new b(z2, str, z3, j2);
            String displayName = aa.getDisplayName(((l) g.af(l.class)).aSN().Kn(intent.getStringExtra("Voip_User")).field_username);
            remoteViews = new RemoteViews(MMApplicationContext.getPackageName(), (int) R.layout.c6z);
            remoteViews.setTextViewText(R.id.g2e, displayName);
            if (intent.getBooleanExtra("Voip_VideoCall", true)) {
                string = MMApplicationContext.getResources().getString(R.string.i36);
                remoteViews.setTextViewText(R.id.g2f, string);
                remoteViews.setImageViewResource(R.id.g2_, R.drawable.bvf);
            } else {
                string = MMApplicationContext.getResources().getString(R.string.i35);
                remoteViews.setTextViewText(R.id.g2f, string);
                remoteViews.setImageViewResource(R.id.g2_, R.drawable.bvg);
            }
            remoteViews.setImageViewResource(R.id.jlo, R.drawable.bvl);
            str2 = displayName + string;
        }
        if (z3) {
            intent.setFlags(603979776);
            intent.addFlags(268435456);
        }
        if (remoteViews == null) {
            e(str, z2, j2);
            com.tencent.mm.plugin.voip.b.d dVar = com.tencent.mm.plugin.voip.b.d.HgU;
            com.tencent.mm.plugin.voip.b.d.fJV();
        } else {
            com.tencent.mm.plugin.voip.b.d dVar2 = com.tencent.mm.plugin.voip.b.d.HgU;
            com.tencent.mm.plugin.voip.b.d.fJU();
        }
        com.tencent.mm.util.a.a(context2, intent, remoteViews, str2, VideoActivity.class.getCanonicalName(), com.tencent.mm.bq.a.glD());
        AppMethodBeat.o(235686);
    }

    public final void fIg() {
        AppMethodBeat.i(235687);
        b bVar = this.GZc;
        if (bVar != null) {
            Log.i("MicroMsg.Voip.VoipService", "resetFullscreenIntent ");
            String str = this.GYS.toUser;
            boolean z = this.GYS.GZs;
            boolean z2 = this.GYS.GZt;
            long j2 = bVar.ypH;
            enB();
            a(MMApplicationContext.getContext(), str, j2, z, z2, true);
            AppMethodBeat.o(235687);
            return;
        }
        Log.i("MicroMsg.Voip.VoipService", "do not need voip resume");
        AppMethodBeat.o(235687);
    }

    public final void e(String str, boolean z, long j2) {
        boolean z2;
        AppMethodBeat.i(235688);
        Log.printInfoStack("MicroMsg.Voip.VoipService", "bindVoipForegroundIfNeed", new Object[0]);
        if (d.oD(26) && !this.GZj) {
            q qVar = q.GXY;
            q.fHa();
            Intent intent = new Intent();
            intent.putExtra("isRecalled", false);
            intent.putExtra("Voip_User", str);
            intent.putExtra("Voip_CallRoomKey", j2);
            intent.putExtra("Voip_VideoCall", z);
            intent.setClass(MMApplicationContext.getContext(), VoipForegroundService.class);
            try {
                MMApplicationContext.getContext().startService(intent);
                z2 = true;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Voip.VoipService", e2, "using start service to bindVoipForegroundIfNeed error: %s", e2.getMessage());
                try {
                    MMApplicationContext.getContext().startForegroundService(intent);
                    q qVar2 = q.GXY;
                    q.fHc();
                    z2 = false;
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.Voip.VoipService", e3, "using start foreground service to bindVoipForegroundIfNeed error: %s", e3.getMessage());
                    z2 = false;
                }
            }
            if (z2) {
                this.GZj = true;
                q qVar3 = q.GXY;
                q.fHb();
            }
        }
        AppMethodBeat.o(235688);
    }

    private void fIh() {
        boolean z;
        AppMethodBeat.i(115146);
        Log.printInfoStack("MicroMsg.Voip.VoipService", "unbindVoiceServiceIfNeed", new Object[0]);
        if (d.oD(26)) {
            try {
                Intent intent = new Intent();
                intent.setClass(MMApplicationContext.getContext(), VoipForegroundService.class);
                MMApplicationContext.getContext().stopService(intent);
                q qVar = q.GXY;
                q.fHg();
                z = true;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Voip.VoipService", e2, "unBind vidoeforeground error: %s", e2.getMessage());
                z = false;
            }
            if (z) {
                this.GZj = false;
            }
        }
        AppMethodBeat.o(115146);
    }

    public final void fIi() {
        AppMethodBeat.i(235689);
        this.GYT = null;
        this.GZd = null;
        this.GZe = false;
        this.GZg = false;
        this.GZf = false;
        this.GZm = false;
        com.tencent.mm.plugin.voip.c.fFh().rX(true);
        AppMethodBeat.o(235689);
    }

    public final void adp(int i2) {
        AppMethodBeat.i(235690);
        k kVar = k.GVq;
        k.a(this.GYS.GSZ.GVV, i2);
        this.GYS.GSZ.GVV.fIQ();
        AppMethodBeat.o(235690);
    }

    public static float xg(boolean z) {
        byte[] bArr;
        AppMethodBeat.i(115148);
        float f2 = 0.74766356f;
        try {
            u fFg = com.tencent.mm.plugin.voip.c.fFg();
            if (z) {
                bArr = fFg.GYS.GSZ.GVV.field_capInfo;
            } else {
                bArr = fFg.GYS.GSZ.GVV.Hay;
            }
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                if (wrap.getInt() > 65535) {
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                }
                wrap.getShort();
                wrap.getShort();
                float f3 = ((float) wrap.getInt()) / 100.0f;
                if (f3 != 0.0f) {
                    f2 = f3;
                }
                Log.d("MicroMsg.Voip.VoipService", "use rate: %s, changed: %s", Float.valueOf(f2), Boolean.valueOf(z));
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.Voip.VoipService", "update failed: " + e2.getMessage());
        }
        AppMethodBeat.o(115148);
        return f2;
    }

    public final void fIj() {
        AppMethodBeat.i(115149);
        this.GYS.GZL.startTimer(1000);
        AppMethodBeat.o(115149);
    }

    private static boolean isAppOnForeground(Context context) {
        AppMethodBeat.i(115150);
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningTasks(1);
        if (runningTasks != null && !runningTasks.isEmpty()) {
            ComponentName componentName = runningTasks.get(0).topActivity;
            Log.d("MicroMsg.Voip.VoipService", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                Log.i("MicroMsg.Voip.VoipService", "is in backGround.");
                AppMethodBeat.o(115150);
                return false;
            }
        }
        if (((KeyguardManager) MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            AppMethodBeat.o(115150);
            return false;
        }
        Log.i("MicroMsg.Voip.VoipService", "is in foreGround.");
        AppMethodBeat.o(115150);
        return true;
    }

    public final void adh(int i2) {
        AppMethodBeat.i(115151);
        this.GYS.GSZ.adh(i2);
        AppMethodBeat.o(115151);
    }

    public final void adq(int i2) {
        AppMethodBeat.i(235691);
        this.GYS.adq(i2);
        AppMethodBeat.o(235691);
    }

    public final int fIk() {
        return this.GYS.GSZ.GVV.HaJ;
    }

    public final void fIl() {
        AppMethodBeat.i(115152);
        this.GYS.GSZ.GVX.fGP();
        AppMethodBeat.o(115152);
    }

    public final void ry(boolean z) {
        AppMethodBeat.i(115153);
        Log.printInfoStack("MicroMsg.Voip.VoipService", "setEngineHeadsetPlugged, %s", Boolean.valueOf(z));
        byte[] bArr = new byte[1];
        bArr[0] = (byte) (z ? 1 : 0);
        this.GYS.GSZ.GVV.setAppCmd(425, bArr, 1);
        if (z) {
            if (com.tencent.mm.plugin.audio.c.a.cdW()) {
                this.GYS.GSZ.GVV.setAppCmd(JsApiQueryDownloadTask.CTRL_INDEX, bArr, 1);
            }
            if (com.tencent.mm.plugin.audio.c.a.ceb()) {
                this.GYS.GSZ.GVV.setAppCmd(JsApiInstallDownloadTask.CTRL_INDEX, bArr, 1);
                AppMethodBeat.o(115153);
                return;
            }
        } else {
            this.GYS.GSZ.GVV.setAppCmd(JsApiQueryDownloadTask.CTRL_INDEX, bArr, 1);
            this.GYS.GSZ.GVV.setAppCmd(JsApiInstallDownloadTask.CTRL_INDEX, bArr, 1);
        }
        AppMethodBeat.o(115153);
    }

    public final boolean fIm() {
        AppMethodBeat.i(235692);
        boolean fHP = this.GYS.GSZ.GWj.fHP();
        AppMethodBeat.o(235692);
        return fHP;
    }

    public final void fIn() {
        AppMethodBeat.i(235693);
        this.GYS.GSZ.GWj = new VoipScoreState();
        AppMethodBeat.o(235693);
    }

    public final VoipScoreState fIo() {
        return this.GYS.GSZ.GWj;
    }

    public class b {
        public boolean GZs = false;
        public boolean GZt;
        private boolean GZu;
        public String toUser;
        public long ypH;

        public b(boolean z, String str, boolean z2, long j2) {
            this.GZt = z;
            this.toUser = str;
            this.GZu = z2;
            this.ypH = j2;
        }
    }

    public static boolean fIa() {
        return v2protocal.Haq;
    }

    public static boolean fIb() {
        return v2protocal.Har;
    }
}
