package com.tencent.mm.modelmulti;

import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.jsapi.cr;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ctr;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.LinkedList;
import junit.framework.Assert;

public final class k extends q implements m {
    protected static int dML = 7;
    private static boolean jdb = false;
    private static int jde = 0;
    public String TAG;
    private i callback;
    private int errCode;
    private String errMsg;
    private int errType;
    private f.a hvh;
    private MTimerHandler iKj;
    private boolean jcC;
    private int jce;
    private long jcg;
    private boolean jch;
    public r jda;
    private boolean jdc;
    private MTimerHandler jdd;
    private int jdf;
    private boolean jdg;
    private String jdh;
    public v.b jdi;
    private long jdj;

    public k(int i2) {
        AppMethodBeat.i(132574);
        this.TAG = "MicroMsg.NetSceneSync";
        this.errType = 0;
        this.errCode = 0;
        this.errMsg = "";
        this.jda = null;
        this.jdc = false;
        this.jce = 0;
        this.iKj = null;
        this.jdd = null;
        this.jcg = -1;
        this.jch = false;
        this.jdg = false;
        this.jcC = false;
        this.jdh = "";
        this.jdi = null;
        this.jdj = 0;
        this.TAG += "[" + hashCode() + "]";
        Log.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", Integer.valueOf(i2), Util.getStack());
        this.jdh = MMStack.getCaller();
        this.hvh = new f.a();
        if (this.jda == null) {
            this.jda = new r();
        }
        this.jda.jeB = i2;
        g.aAi();
        if (g.aAh() != null && g.aAc()) {
            g.aAi();
            if (g.aAh().azQ() != null && !com.tencent.mm.kernel.a.azj()) {
                g.aAi();
                long nullAs = Util.nullAs((Long) g.aAh().azQ().get(8196, (Object) null), 0);
                if (nullAs != 0) {
                    g.aAi();
                    g.aAh().azQ().set(8196, (Object) 0L);
                    int i3 = (int) (nullAs | ((long) dML));
                    dML = i3;
                    dML = i3 & 95;
                }
            }
        }
        if (i2 == 1) {
            jdb = true;
        }
        if (i2 == 1010) {
            dML |= 16;
            jdb = true;
            this.jdf = 7;
        } else if (i2 == 1011) {
            dML |= 64;
            jdb = true;
            this.jdf = 7;
        } else if (i2 == 3) {
            dML |= TPMediaCodecProfileLevel.HEVCMainTierLevel52;
            jdb = true;
            this.jdf = 3;
            Log.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", Integer.valueOf(i2), Integer.valueOf(dML), Integer.valueOf(this.jdf));
        } else {
            this.jdf = i2;
        }
        if (jde == 0) {
            bdL();
        }
        AppMethodBeat.o(132574);
    }

    public k(final v.b bVar, int i2, long j2) {
        this(8);
        AppMethodBeat.i(132575);
        this.jdh = MMStack.getCaller();
        Log.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", Long.valueOf(bVar.getBufferSize()), Integer.valueOf(i2), Long.valueOf(j2));
        this.jce = i2;
        this.jcg = j2;
        this.iKj = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.modelmulti.k.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(132569);
                k.this.jch = true;
                a aVar = new a(bVar);
                e.INSTANCE.idkeyStat(99, 230, 1, false);
                k.this.onGYNetEnd(-1, 0, 0, "", aVar, null);
                AppMethodBeat.o(132569);
                return false;
            }
        }, false);
        if (jde == 0) {
            bdL();
        }
        AppMethodBeat.o(132575);
    }

    @Override // com.tencent.mm.ak.q
    public final boolean accept(q qVar) {
        boolean z = true;
        AppMethodBeat.i(132576);
        if (!(qVar instanceof k)) {
            AppMethodBeat.o(132576);
            return false;
        }
        k kVar = (k) qVar;
        if (kVar.jdc || !jdb) {
            AppMethodBeat.o(132576);
            return false;
        }
        Log.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", Long.valueOf(kVar.lastdispatch));
        if (Util.ticksToNow(kVar.lastdispatch) <= 360000) {
            z = false;
        }
        if (z) {
            Log.i(this.TAG, "summerworker NetSceneSync timeout");
            if (g.aAk().findTaskByRunTime(false, 0) != null) {
                Log.e(this.TAG, "summerworker worker is just blocked by task: " + g.aAk().dump(false, false));
                AppMethodBeat.o(132576);
                return false;
            }
        }
        AppMethodBeat.o(132576);
        return z;
    }

    @Override // com.tencent.mm.ak.q
    public final boolean uniqueInNetsceneQueue() {
        return true;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 100;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final boolean securityLimitCountReach() {
        int i2 = 1;
        AppMethodBeat.i(132577);
        boolean securityLimitCountReach = super.securityLimitCountReach();
        if (securityLimitCountReach) {
            e.INSTANCE.idkeyStat(99, 228, 1, false);
            e eVar = e.INSTANCE;
            Object[] objArr = new Object[9];
            objArr[0] = 0;
            objArr[1] = 0;
            objArr[2] = 0;
            objArr[3] = 0;
            objArr[4] = 0;
            objArr[5] = 0;
            objArr[6] = 0;
            if (!CrashReportFactory.foreground) {
                i2 = 2;
            }
            objArr[7] = Integer.valueOf(i2);
            objArr[8] = "9999";
            eVar.a(12063, objArr);
        }
        AppMethodBeat.o(132577);
        return securityLimitCountReach;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 138;
    }

    @Override // com.tencent.mm.ak.q
    public final void cancel() {
        AppMethodBeat.i(132578);
        super.cancel();
        e.INSTANCE.idkeyStat(99, 229, 1, false);
        this.jcC = true;
        AppMethodBeat.o(132578);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(132579);
        if (l.bdN()) {
            jde = 0;
            Log.e(this.TAG, "dkinit never do sync before init done");
            AppMethodBeat.o(132579);
            return -1;
        }
        this.callback = iVar;
        if (this.jda == null) {
            this.jda = new r();
        }
        this.jda.cQp = CrashReportFactory.foreground;
        if (this.jdd != null) {
            Log.i(this.TAG, "pushSyncRespHandler not null");
            prepareDispatcher(gVar);
            this.jdd.startTimer(0);
            AppMethodBeat.o(132579);
            return 0;
        } else if (jde > 0) {
            Log.w(this.TAG, "other sync is dealing with resp data :%d", Integer.valueOf(jde));
            AppMethodBeat.o(132579);
            return -1;
        } else if (this.iKj != null) {
            Log.i(this.TAG, "pusher not null");
            prepareDispatcher(gVar);
            this.iKj.startTimer(0);
            AppMethodBeat.o(132579);
            return 0;
        } else {
            a aVar = new a();
            ctr ctr = ((v.a) aVar.getReqObj()).KAg;
            if (this.jdf == 3) {
                ctr.Mza = 1;
            } else {
                ctr.Mza = 0;
            }
            this.jdf = this.jdg ? 6 : this.jdf;
            ctr.Leu = dML;
            g.aAi();
            byte[] decodeHexString = Util.decodeHexString(Util.nullAsNil((String) g.aAh().azQ().get(8195, new byte[0])));
            ctr.Lev = z.aC(decodeHexString);
            ctr.Scene = this.jdf;
            ctr.MyZ = new abo();
            ctr.KLO = d.ics;
            Log.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", Integer.valueOf(ctr.Leu), Integer.valueOf(ctr.Scene), ad.cK(decodeHexString));
            jdb = false;
            int dispatch = dispatch(gVar, aVar, this);
            AppMethodBeat.o(132579);
            return dispatch;
        }
    }

    private boolean bdL() {
        AppMethodBeat.i(132580);
        PInt pInt = new PInt();
        g.aAi();
        g.aAf();
        byte[] a2 = com.tencent.mm.booter.g.a(pInt, com.tencent.mm.kernel.a.getUin());
        String str = this.TAG;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(pInt.value);
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = Integer.valueOf(a2 != null ? a2.length : 0);
        Log.i(str, "dealWithRespData index:%d, hashcode:%d, buf.len:%d", objArr);
        jde = pInt.value;
        if (pInt.value == 0 || Util.isNullOrNil(a2)) {
            jde = 0;
            AppMethodBeat.o(132580);
            return false;
        }
        v.b bVar = new v.b();
        try {
            bVar.fromProtoBuf(a2);
            final a aVar = new a(bVar);
            this.jdd = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.modelmulti.k.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(132570);
                    k.this.jch = true;
                    e.INSTANCE.idkeyStat(99, 231, 1, false);
                    k.this.onGYNetEnd(-1, 0, 0, "", aVar, null);
                    AppMethodBeat.o(132570);
                    return false;
                }
            }, false);
            AppMethodBeat.o(132580);
            return true;
        } catch (Exception e2) {
            e.INSTANCE.idkeyStat(99, 226, 1, false);
            Log.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
            int i2 = jde;
            g.aAi();
            g.aAf();
            com.tencent.mm.booter.g.cq(i2, com.tencent.mm.kernel.a.getUin());
            jde = 0;
            AppMethodBeat.o(132580);
            return false;
        } catch (Error e3) {
            long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
            long j2 = Runtime.getRuntime().totalMemory() / 1000;
            Log.i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", Long.valueOf(freeMemory), Long.valueOf(j2), Long.valueOf(j2 - freeMemory));
            Assert.assertTrue("dealWithRespData error", false);
            AppMethodBeat.o(132580);
            return false;
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z;
        AppMethodBeat.i(132581);
        if (sVar == null || sVar.getType() != 138) {
            String str2 = this.TAG;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(sVar == null ? -2 : sVar.getType());
            Log.e(str2, "onGYNetEnd error type:%d", objArr);
            AppMethodBeat.o(132581);
            return;
        }
        v.b bVar = (v.b) sVar.getRespObj();
        String str3 = this.TAG;
        Object[] objArr2 = new Object[8];
        objArr2[0] = Integer.valueOf(i3);
        objArr2[1] = Integer.valueOf(i4);
        objArr2[2] = str;
        objArr2[3] = Long.valueOf(this.hvh.apr());
        objArr2[4] = Boolean.valueOf(this.jch);
        objArr2[5] = Integer.valueOf(bVar.KAh.Ley == null ? -1 : bVar.KAh.Ley.oTz);
        objArr2[6] = this.iKj;
        objArr2[7] = this.jdd;
        Log.i(str3, "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ", objArr2);
        boolean z2 = (bVar.KAh.Ley == null ? -1 : bVar.KAh.Ley.oTz) > 0;
        if (!bdM()) {
            e.INSTANCE.idkeyStat(99, z2 ? 221 : 218, 1, false);
        } else if (!CrashReportFactory.foreground) {
            e.INSTANCE.idkeyStat(99, z2 ? 220 : 217, 1, false);
        } else {
            e.INSTANCE.idkeyStat(99, z2 ? 219 : 216, 1, false);
        }
        this.iKj = null;
        this.jdc = true;
        if (i3 == 4 && i4 == -2006) {
            z = true;
            i3 = 0;
            i4 = 0;
            e.INSTANCE.idkeyStat(99, 227, 1, false);
        } else {
            z = false;
        }
        if (i3 == 0 && i4 == 0) {
            e.INSTANCE.idkeyStat(99, 233, 1, false);
            byte[] a2 = z.a(((v.a) sVar.getReqObj()).KAg.Lev);
            byte[] a3 = z.a(bVar.KAh.Lev);
            Log.i(this.TAG, "onGYNetEnd replace key:%b req :%s", Boolean.valueOf(z), ad.cK(a2));
            Log.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", Boolean.valueOf(z), ad.cK(a3));
            if (!z) {
                if (Util.isNullOrNil(a2)) {
                    g.aAi();
                    byte[] decodeHexString = Util.decodeHexString(Util.nullAsNil((String) g.aAh().azQ().get(8195, "")));
                    String str4 = this.TAG;
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = Integer.valueOf(decodeHexString == null ? -1 : decodeHexString.length);
                    objArr3[1] = Util.dumpHex(decodeHexString);
                    Log.d(str4, "dkpush userinfo key : %d[%s]", objArr3);
                    a2 = decodeHexString;
                }
                byte[] l = ad.l(a2, a3);
                if (l == null || l.length <= 0) {
                    Log.w(this.TAG, "merge key failed, use server side instead");
                    l = a3;
                }
                bVar.KAh.Lev = z.aC(l);
            }
            g.aAi();
            g.aAf().cU(bVar.KAh.oTW, bVar.KAh.Mzb);
            g.aAi();
            g.aAf();
            com.tencent.mm.kernel.a.qc(bVar.KAh.oTW);
            Assert.assertTrue(this.jdi == null);
            this.jdi = bVar;
            this.jdj = Util.nowMilliSecond();
            new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.modelmulti.k.AnonymousClass3 */
                private int jdm = 0;
                private long jdn = 0;
                private int jdo = 0;

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(132571);
                    c cVar = new c();
                    if (!g.aAc()) {
                        Log.e(k.this.TAG, "syncRespHandler acc is not ready STOP :%s", k.this.jdi);
                        k.this.jdi = null;
                        AppMethodBeat.o(132571);
                        return false;
                    } else if (k.this.jcC) {
                        cVar.dB(k.this);
                        k.this.jdi = null;
                        AppMethodBeat.o(132571);
                        return false;
                    } else if (k.this.jdi == null || k.this.jdi.KAh.Ley == null || k.this.jdi.KAh.Ley.oTA == null) {
                        Log.e(k.this.TAG, "syncRespHandler CmdList is null! Stop Processing :%s", k.this.jdi);
                        cVar.dB(k.this);
                        k.this.jdi = null;
                        AppMethodBeat.o(132571);
                        return false;
                    } else {
                        LinkedList<abn> linkedList = k.this.jdi.KAh.Ley.oTA;
                        cVar.dz(k.this);
                        this.jdo++;
                        long nowMilliSecond = Util.nowMilliSecond();
                        for (int i2 = 0; i2 < 5; i2++) {
                            if (this.jdm < linkedList.size()) {
                                Log.v(k.this.TAG, "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", Integer.valueOf(i2), Integer.valueOf(this.jdm), Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList.get(this.jdm).Lms), Integer.valueOf(linkedList.get(this.jdm).Lmt.getILen()));
                                linkedList.size();
                                if (!cVar.a(linkedList.get(this.jdm), false)) {
                                    Log.w(k.this.TAG, "DoCmd Failed index:%d", Integer.valueOf(this.jdm));
                                }
                                this.jdm++;
                            }
                            if (this.jdm >= linkedList.size()) {
                                this.jdn += Util.milliSecondsToNow(nowMilliSecond);
                                long milliSecondsToNow = Util.milliSecondsToNow(k.this.jdj);
                                Log.i(k.this.TAG, "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", Integer.valueOf(this.jdm), Integer.valueOf(linkedList.size()), Long.valueOf(milliSecondsToNow), Long.valueOf(this.jdn), Integer.valueOf(this.jdo), k.this.jdi);
                                k.this.a(k.this.jdi);
                                cVar.dA(k.this);
                                e.INSTANCE.idkeyStat(99, (long) Util.nullAsNil((Integer) e.a((int) this.jdn, new int[]{100, 300, 1000, 3000}, new Integer[]{240, Integer.valueOf((int) TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL), Integer.valueOf((int) TbsListener.ErrorCode.TPATCH_FAIL), Integer.valueOf((int) TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS), 236})), 1, false);
                                e.INSTANCE.idkeyStat(99, (long) Util.nullAsNil((Integer) e.a(linkedList.size(), new int[]{0, 1, 2, 3, 5, 10}, new Integer[]{Integer.valueOf((int) cr.CTRL_INDEX), 248, 247, 246, 245, 244, Integer.valueOf((int) com.tencent.mm.plugin.appbrand.jsapi.o.b.d.CTRL_INDEX)})), 1, false);
                                e.INSTANCE.idkeyStat(99, CrashReportFactory.foreground ? 241 : 242, 1, false);
                                e.INSTANCE.idkeyStat(99, (long) k.this.jdf, 1, false);
                                e.INSTANCE.idkeyStat(99, 0, 1, false);
                                e eVar = e.INSTANCE;
                                Object[] objArr = new Object[8];
                                objArr[0] = Integer.valueOf(linkedList.size());
                                objArr[1] = Long.valueOf(milliSecondsToNow);
                                objArr[2] = Integer.valueOf(k.this.jdf);
                                objArr[3] = Integer.valueOf(k.this.jdi.KAh.KZh);
                                objArr[4] = Long.valueOf(this.jdn);
                                objArr[5] = Integer.valueOf(this.jdo);
                                objArr[6] = k.this.jdh;
                                objArr[7] = Integer.valueOf(CrashReportFactory.foreground ? 1 : 2);
                                eVar.a(12063, objArr);
                                k.this.jdi = null;
                                AppMethodBeat.o(132571);
                                return false;
                            }
                            long milliSecondsToNow2 = Util.milliSecondsToNow(nowMilliSecond);
                            if (milliSecondsToNow2 > 500) {
                                Log.d(k.this.TAG, "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", Long.valueOf(milliSecondsToNow2), Integer.valueOf(i2), Integer.valueOf(this.jdm), k.this.jdi);
                                this.jdn += Util.milliSecondsToNow(nowMilliSecond);
                                AppMethodBeat.o(132571);
                                return true;
                            }
                        }
                        this.jdn += Util.milliSecondsToNow(nowMilliSecond);
                        AppMethodBeat.o(132571);
                        return true;
                    }
                }
            }, true).startTimer(50);
            AppMethodBeat.o(132581);
            return;
        }
        if (this.jdi != null) {
            Log.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
            this.errType = i3;
            this.errCode = i4;
            this.errMsg = str;
            ((v.b) sVar.getRespObj()).KAh.KZh = 0;
        } else {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        e.INSTANCE.idkeyStat(99, 232, 1, false);
        AppMethodBeat.o(132581);
    }

    /* access modifiers changed from: protected */
    public final void a(v.b bVar) {
        AppMethodBeat.i(132582);
        g.aAi();
        g.aAh().azQ().set(8195, Util.encodeHexString(z.a(bVar.KAh.Lev)));
        MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.aps()).edit().putString("notify_sync_key_keybuf", Util.encodeHexString(z.a(bVar.KAh.Lev))).commit();
        g.aAi();
        g.aAh().azQ().set(8196, Long.valueOf((long) bVar.KAh.KZh));
        boolean z = (bVar.KAh.KZh & dML) != 0 && !super.securityLimitCountReach();
        Log.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", Boolean.valueOf(z), Integer.valueOf(bVar.KAh.KZh), Integer.valueOf(dML), Boolean.valueOf(super.securityLimitCountReach()));
        if (!z && (bVar.KAh.KZh & 256) != 0) {
            wf wfVar = new wf();
            wfVar.ecp.sourceType = 1;
            EventCenter.instance.publish(wfVar);
        }
        if (!z && (bVar.KAh.KZh & TPMediaCodecProfileLevel.HEVCHighTierLevel6) != 0) {
            EventCenter.instance.publish(new oy());
        }
        if (!z && (bVar.KAh.KZh & TPMediaCodecProfileLevel.HEVCMainTierLevel62) != 0) {
            EventCenter.instance.publish(new id());
        }
        if (!z && (bVar.KAh.KZh & 32) != 0) {
            EventCenter.instance.publish(new at());
        }
        e.INSTANCE.idkeyStat(99, z ? 234 : 235, 1, false);
        Log.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", Integer.valueOf(bVar.KAh.KZh), Boolean.valueOf(this.jch), Boolean.valueOf(z), Boolean.valueOf(jdb), Integer.valueOf(this.jce), Boolean.valueOf(this.jdg), this.jdd);
        if (!this.jch && z) {
            this.jdg = true;
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(132582);
        } else if (jdb) {
            Log.i(this.TAG, "dkpush new notify pending, sync now");
            if (jde != 0) {
                int i2 = jde;
                g.aAi();
                g.aAf();
                com.tencent.mm.booter.g.cq(i2, com.tencent.mm.kernel.a.getUin());
            }
            jde = 0;
            this.jdd = null;
            jdb = false;
            this.jdg = true;
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(132582);
        } else if (this.jdd != null) {
            int i3 = jde;
            g.aAi();
            g.aAf();
            com.tencent.mm.booter.g.cq(i3, com.tencent.mm.kernel.a.getUin());
            this.jdd = null;
            bdL();
            doScene(dispatcher(), this.callback);
            AppMethodBeat.o(132582);
        } else {
            if ((this.jce & 1) > 0) {
                g.aAi();
                g.azz().a(new g(this.jcg, Util.decodeHexString(Util.nullAsNil((String) g.aAh().azQ().get(8195, (Object) null)))), 0);
            }
            Log.d(this.TAG, "sync or init end: reset selector : now = " + dML + " default = 7");
            dML = 7;
            this.callback.onSceneEnd(this.errType, this.errCode, this.errMsg, this);
            AppMethodBeat.o(132582);
        }
    }

    private boolean bdM() {
        AppMethodBeat.i(132583);
        try {
            boolean booleanValue = ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) MMApplicationContext.getContext().getSystemService("power"), new Object[0])).booleanValue();
            AppMethodBeat.o(132583);
            return booleanValue;
        } catch (Exception e2) {
            Log.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", Boolean.TRUE, Util.stackTraceToString(e2));
            AppMethodBeat.o(132583);
            return true;
        }
    }

    public static class a extends o {
        private final v.a jck;
        private final v.b jcl;
        private final boolean jcm;

        public a() {
            AppMethodBeat.i(132572);
            this.jck = new v.a();
            this.jcl = new v.b();
            this.jcm = false;
            AppMethodBeat.o(132572);
        }

        public a(v.b bVar) {
            AppMethodBeat.i(132573);
            this.jck = new v.a();
            this.jcl = bVar;
            this.jcm = true;
            AppMethodBeat.o(132573);
        }

        @Override // com.tencent.mm.ak.o
        public final l.d getReqObjImp() {
            return this.jck;
        }

        @Override // com.tencent.mm.network.s
        public final l.e getRespObj() {
            return this.jcl;
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return 138;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newsync";
        }

        @Override // com.tencent.mm.ak.o
        public final boolean getPush() {
            return this.jcm;
        }
    }
}
