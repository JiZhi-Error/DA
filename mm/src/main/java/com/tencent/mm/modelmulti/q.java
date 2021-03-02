package com.tencent.mm.modelmulti;

import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.jsapi.cr;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ctr;
import com.tencent.mm.protocal.protobuf.cts;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class q {
    private static Boolean jee = null;
    public o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.modelmulti.q.AnonymousClass1 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(132586);
            Log.i("MicroMsg.SyncService", "SyncService onAppForeground %s", str);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!com.tencent.mm.kernel.a.azj()) {
                    q.this.tE(3);
                }
            }
            AppMethodBeat.o(132586);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
        }
    };
    private WakerLock glE = null;
    public Queue<c> jef = new LinkedList();
    public Queue<c> jeg = new LinkedList();
    private HashMap<c, Long> jeh = new HashMap<>();
    public c jei = null;
    private long jej = 0;

    /* access modifiers changed from: package-private */
    public interface b {
        boolean tF(int i2);
    }

    public interface c {
        boolean c(Queue<c> queue);
    }

    public q() {
        AppMethodBeat.i(132605);
        AppMethodBeat.o(132605);
    }

    static /* synthetic */ void S(String str, boolean z) {
        AppMethodBeat.i(132618);
        assertTrue(str, z);
        AppMethodBeat.o(132618);
    }

    static /* synthetic */ int a(q qVar, int i2, int i3) {
        AppMethodBeat.i(132626);
        int n = qVar.n(i2, i3, true);
        AppMethodBeat.o(132626);
        return n;
    }

    static /* synthetic */ void a(q qVar, String str) {
        AppMethodBeat.i(132622);
        qVar.Pm(str);
        AppMethodBeat.o(132622);
    }

    static /* synthetic */ boolean bdV() {
        AppMethodBeat.i(132625);
        boolean bdM = bdM();
        AppMethodBeat.o(132625);
        return bdM;
    }

    static /* synthetic */ void f(q qVar) {
        AppMethodBeat.i(132620);
        qVar.bdU();
        AppMethodBeat.o(132620);
    }

    private static boolean aSG() {
        AppMethodBeat.i(132606);
        if (com.tencent.mm.kernel.a.azj() || !g.aAc()) {
            AppMethodBeat.o(132606);
            return false;
        } else if (jee != null) {
            boolean booleanValue = jee.booleanValue();
            AppMethodBeat.o(132606);
            return booleanValue;
        } else {
            jee = Boolean.TRUE;
            AppMethodBeat.o(132606);
            return true;
        }
    }

    private static void assertTrue(String str, boolean z) {
        AppMethodBeat.i(132607);
        if (z) {
            AppMethodBeat.o(132607);
            return;
        }
        Log.e("MicroMsg.SyncService", "ASSERT now msg:%s", str);
        Assert.assertTrue(str, z);
        AppMethodBeat.o(132607);
    }

    public final int a(long j2, int i2, String str) {
        AppMethodBeat.i(132608);
        boolean aSG = aSG();
        Log.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s ", Boolean.valueOf(aSG), Long.valueOf(j2), Integer.valueOf(i2), str);
        int i3 = 0;
        if ((256 & j2) != 0) {
            EventCenter.instance.publish(new wf());
        }
        if ((2097152 & j2) != 0) {
            EventCenter.instance.publish(new oy());
        }
        if ((128 & j2) != 0) {
            EventCenter.instance.publish(new xd());
        }
        if ((16777216 & j2) != 0) {
            EventCenter.instance.publish(new id());
        }
        if ((32 & j2) != 0) {
            EventCenter.instance.publish(new at());
        }
        long j3 = -16777217 & j2 & -33 & -257 & -2097153 & 95;
        if (j3 != 0 && g.aAc()) {
            g.aAi();
            if (g.aAh().azQ() != null) {
                Log.i("MicroMsg.SyncService", "ContinueFlag:%s", Long.valueOf(j3));
                g.aAi();
                g.aAh().azQ().set(8196, Long.valueOf(j3));
                if (!aSG) {
                    k kVar = new k(i2);
                    i3 = kVar.hashCode();
                    Log.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", Integer.valueOf(i3));
                    g.aAi();
                    if (!g.aAg().hqi.a(kVar, 0)) {
                        Log.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", Integer.valueOf(i3));
                        i3 = 0;
                    }
                } else {
                    i3 = n(i2, 7, false);
                }
            }
        }
        if (!Util.isNullOrNil(str)) {
            ar arVar = new ar();
            arVar.dDD.type = 3;
            arVar.dDD.event = str;
            EventCenter.instance.publish(arVar);
        }
        AppMethodBeat.o(132608);
        return i3;
    }

    public final void a(v.b bVar, int i2, long j2) {
        AppMethodBeat.i(132609);
        boolean aSG = aSG();
        Log.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s", Boolean.valueOf(aSG), bVar, Integer.valueOf(i2), Long.valueOf(j2));
        if (!aSG) {
            g.aAi();
            g.aAg().hqi.a(new k(bVar, i2, j2), 0);
            AppMethodBeat.o(132609);
            return;
        }
        a(new f(bVar, i2, j2));
        AppMethodBeat.o(132609);
    }

    public final int tE(int i2) {
        AppMethodBeat.i(132610);
        boolean aSG = aSG();
        Log.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", Boolean.valueOf(aSG), Integer.valueOf(i2), Util.getStack());
        if (!aSG) {
            k kVar = new k(i2);
            g.aAi();
            g.aAg().hqi.a(kVar, 0);
            int hashCode = kVar.hashCode();
            AppMethodBeat.o(132610);
            return hashCode;
        }
        int n = n(i2, 7, false);
        AppMethodBeat.o(132610);
        return n;
    }

    private int n(int i2, int i3, boolean z) {
        AppMethodBeat.i(132611);
        e eVar = new e(i2, i3, z);
        a((c) eVar);
        int hashCode = eVar.hashCode();
        AppMethodBeat.o(132611);
        return hashCode;
    }

    private synchronized void Pm(String str) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(132612);
            Log.i("MicroMsg.SyncService", "wakelock tag:%s syncWakerLock:%s [%s]", str, this.glE, Util.getStack());
            if (this.glE == null) {
                this.glE = new WakerLock(MMApplicationContext.getContext(), "MicroMsg.SyncService", new WakerLock.IAutoUnlockCallback() {
                    /* class com.tencent.mm.modelmulti.q.AnonymousClass2 */

                    @Override // com.tencent.mars.comm.WakerLock.IAutoUnlockCallback
                    public final void autoUnlockCallback() {
                        AppMethodBeat.i(132587);
                        Log.e("MicroMsg.SyncService", "ERROR: %s auto unlock syncWakerLock", q.this.jei);
                        q.b(q.this.jei);
                        AppMethodBeat.o(132587);
                    }
                });
            }
            if (this.glE.isLocking()) {
                z = false;
            }
            assertTrue("lock", z);
            if (!CrashReportFactory.foreground) {
                this.glE.lock(30000, str);
            }
            AppMethodBeat.o(132612);
        }
    }

    private synchronized void bdU() {
        Object valueOf;
        AppMethodBeat.i(132613);
        if (this.glE == null || !this.glE.isLocking()) {
            Object[] objArr = new Object[2];
            if (this.glE == null) {
                valueOf = BuildConfig.COMMAND;
            } else {
                valueOf = Boolean.valueOf(this.glE.isLocking());
            }
            objArr[0] = valueOf;
            objArr[1] = Boolean.valueOf(CrashReportFactory.foreground);
            Log.w("MicroMsg.SyncService", "wakeUnlock syncWakerLock locking?:%s foreground:%s", objArr);
            AppMethodBeat.o(132613);
        } else {
            this.glE.unLock();
            AppMethodBeat.o(132613);
        }
    }

    private void a(final c cVar) {
        AppMethodBeat.i(132614);
        if (l.bdN()) {
            Log.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", cVar);
            AppMethodBeat.o(132614);
            return;
        }
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.modelmulti.q.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(132588);
                if (cVar != null) {
                    if (cVar instanceof f) {
                        q.this.jeg.add(cVar);
                    } else {
                        q.this.jef.add(cVar);
                    }
                }
                q.a(q.this, (c) null);
                AppMethodBeat.o(132588);
            }
        });
        AppMethodBeat.o(132614);
    }

    /* access modifiers changed from: package-private */
    public class d implements c {
        d() {
        }

        @Override // com.tencent.mm.modelmulti.q.c
        public final boolean c(Queue<c> queue) {
            AppMethodBeat.i(132593);
            PInt pInt = new PInt();
            g.aAi();
            g.aAf();
            byte[] a2 = com.tencent.mm.booter.g.a(pInt, com.tencent.mm.kernel.a.getUin());
            Object[] objArr = new Object[3];
            objArr[0] = this;
            objArr[1] = Integer.valueOf(pInt.value);
            objArr[2] = Integer.valueOf(a2 != null ? a2.length : -1);
            Log.i("MicroMsg.SyncService", "%s index:%d, buf.len:%d ", objArr);
            if (pInt.value == 0 || Util.isNullOrNil(a2)) {
                AppMethodBeat.o(132593);
                return false;
            }
            final int i2 = pInt.value;
            cts cts = null;
            try {
                v.b bVar = new v.b();
                bVar.fromProtoBuf(a2);
                cts = bVar.KAh;
            } catch (Exception e2) {
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 38, 1, false);
                Log.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed e[%s]", this, Integer.valueOf(i2), e2.getMessage());
                g.aAi();
                g.aAf();
                com.tencent.mm.booter.g.cq(i2, com.tencent.mm.kernel.a.getUin());
            } catch (Error e3) {
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 39, 1, false);
                long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
                long j2 = Runtime.getRuntime().totalMemory() / 1000;
                Log.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk] Error[%s]", this, Integer.valueOf(i2), Long.valueOf(freeMemory), Long.valueOf(j2), Long.valueOf(j2 - freeMemory), e3.getMessage());
                g.aAi();
                g.aAf();
                com.tencent.mm.booter.g.cq(i2, com.tencent.mm.kernel.a.getUin());
            }
            if (cts == null) {
                AppMethodBeat.o(132593);
                return false;
            }
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 20, 1, false);
            new a(q.this, this, true, cts, new b() {
                /* class com.tencent.mm.modelmulti.q.d.AnonymousClass1 */

                @Override // com.tencent.mm.modelmulti.q.b
                public final boolean tF(int i2) {
                    AppMethodBeat.i(132592);
                    Log.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", d.this, Integer.valueOf(i2));
                    int i3 = i2;
                    g.aAi();
                    g.aAf();
                    com.tencent.mm.booter.g.cq(i3, com.tencent.mm.kernel.a.getUin());
                    q.a(q.this, d.this);
                    AppMethodBeat.o(132592);
                    return true;
                }
            }, (byte) 0);
            AppMethodBeat.o(132593);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(132594);
            String str = "LightPush[" + hashCode() + "]";
            AppMethodBeat.o(132594);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public class f implements c {
        long iUm;
        int jce;
        cts jeo;

        public f(v.b bVar, int i2, long j2) {
            AppMethodBeat.i(132602);
            this.jeo = bVar == null ? null : bVar.KAh;
            this.iUm = j2;
            this.jce = i2;
            AppMethodBeat.o(132602);
        }

        @Override // com.tencent.mm.modelmulti.q.c
        public final boolean c(Queue<c> queue) {
            AppMethodBeat.i(132603);
            if (this.jeo == null) {
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 40, 1, false);
                Log.e("MicroMsg.SyncService", "%s run resp == null", this);
                AppMethodBeat.o(132603);
                return false;
            } else if (10018 == ac.jOC) {
                Log.e("MicroMsg.SyncService", "%s Give up for test", this);
                AppMethodBeat.o(132603);
                return false;
            } else {
                new a(q.this, this, true, this.jeo, new b() {
                    /* class com.tencent.mm.modelmulti.q.f.AnonymousClass1 */

                    @Override // com.tencent.mm.modelmulti.q.b
                    public final boolean tF(int i2) {
                        AppMethodBeat.i(132600);
                        Log.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", f.this, f.this.jeo, Integer.valueOf(f.this.jce), Long.valueOf(f.this.iUm));
                        if ((f.this.jce & 1) > 0) {
                            g.aAi();
                            g.azz().a(new g(f.this.iUm, Util.decodeHexString(Util.nullAsNil((String) g.aAh().azQ().get(8195, (Object) null)))), 0);
                        }
                        q.a(q.this, f.this);
                        AppMethodBeat.o(132600);
                        return true;
                    }
                }, (byte) 0);
                g.aAk().postToWorkerDelayed(new Runnable() {
                    /* class com.tencent.mm.modelmulti.q.f.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(132601);
                        Log.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag[%s]", f.this, Integer.valueOf(f.this.jeo.KZh));
                        g.aAi();
                        g.aAh().azQ().set(8196, Long.valueOf((long) f.this.jeo.KZh));
                        if ((f.this.jeo.KZh & 256) != 0) {
                            wf wfVar = new wf();
                            wfVar.ecp.sourceType = 2;
                            EventCenter.instance.publish(wfVar);
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 22, 1, false);
                            Log.i("MicroMsg.SyncService", "%s onFinishCmd publish SnsSyncEvent", f.this);
                        }
                        AppMethodBeat.o(132601);
                    }
                }, 100);
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 21, 1, false);
                AppMethodBeat.o(132603);
                return true;
            }
        }

        public final String toString() {
            AppMethodBeat.i(132604);
            String str = "NotifyData[" + hashCode() + "]";
            AppMethodBeat.o(132604);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public class e extends com.tencent.mm.ak.q implements c, m {
        int dML;
        private s iMO;
        i jeu;
        boolean jev;
        private boolean jew = false;
        int scene;

        @Override // com.tencent.mm.modelmulti.q.c
        public final boolean c(Queue<c> queue) {
            Object valueOf;
            AppMethodBeat.i(132596);
            Object[] objArr = new Object[5];
            objArr[0] = this;
            objArr[1] = Integer.valueOf(this.scene);
            objArr[2] = Integer.valueOf(this.dML);
            objArr[3] = Boolean.valueOf(this.jev);
            if (queue == null) {
                valueOf = BuildConfig.COMMAND;
            } else {
                valueOf = Integer.valueOf(queue.size());
            }
            objArr[4] = valueOf;
            Log.i("MicroMsg.SyncService", "%s begin run scene:%s selector:%s isContinue:%s List:%s", objArr);
            if (queue != null) {
                q.b(queue);
                boolean z = false;
                boolean z2 = false;
                while (!queue.isEmpty()) {
                    e eVar = (e) queue.poll();
                    this.dML |= eVar.dML;
                    if (eVar.scene == 3) {
                        z = true;
                    } else if (eVar.jev) {
                        z2 = true;
                    }
                    Log.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", this, Integer.valueOf(queue.size()), eVar, Integer.valueOf(eVar.scene), Integer.valueOf(eVar.dML), Boolean.valueOf(eVar.jev), Boolean.valueOf(z2), Boolean.valueOf(z));
                }
                if (z) {
                    this.scene = 3;
                } else if (z2) {
                    this.scene = 6;
                }
            }
            if (g.aAc() && !com.tencent.mm.kernel.a.azj()) {
                g.aAi();
                if (g.aAh() != null) {
                    g.aAi();
                    if (g.aAh().azQ() != null) {
                        g.aAi();
                        long nullAs = Util.nullAs((Long) g.aAh().azQ().get(8196, (Object) null), 0);
                        if (nullAs != 0) {
                            g.aAi();
                            g.aAh().azQ().set(8196, (Object) 0L);
                            this.dML = (int) (((long) this.dML) | nullAs);
                            this.dML &= 95;
                        }
                        int i2 = this.scene == 3 ? 1 : 0;
                        if (this.scene == 1010) {
                            this.dML |= 16;
                            this.scene = 7;
                        } else if (this.scene == 1011) {
                            this.dML |= 64;
                            this.scene = 7;
                        } else if (this.scene == 3) {
                            this.dML |= TPMediaCodecProfileLevel.HEVCMainTierLevel52;
                            this.scene = 3;
                        }
                        if (this.jev) {
                            this.scene = 6;
                        }
                        this.iMO = new k.a();
                        ctr ctr = ((v.a) this.iMO.getReqObj()).KAg;
                        ctr.Mza = i2;
                        ctr.Leu = this.dML;
                        ctr.Scene = this.scene;
                        g.aAi();
                        String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(8195, ""));
                        ctr.Lev = z.aC(Util.decodeHexString(nullAsNil));
                        ctr.MyZ = new abo();
                        ctr.KLO = com.tencent.mm.protocal.d.ics;
                        Log.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", this, Long.valueOf(nullAs), Integer.valueOf(ctr.Mza), Integer.valueOf(ctr.Leu), Integer.valueOf(this.scene), ctr.KLO);
                        Log.i("MicroMsg.SyncService", "%s Req synckey %s", this, ad.cK(Util.decodeHexString(nullAsNil)));
                        q.a(this);
                        g.aAi();
                        if (!g.aAg().hqi.a(this, 0)) {
                            com.tencent.mm.plugin.report.e.INSTANCE.a(11098, 3500, this.scene + ";" + CrashReportFactory.foreground + ";" + q.bdV());
                            Log.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", this);
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 41, 1, false);
                            AppMethodBeat.o(132596);
                            return false;
                        }
                        AppMethodBeat.o(132596);
                        return true;
                    }
                }
            }
            g.aAi();
            Log.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", this, Boolean.valueOf(g.aAc()), Boolean.valueOf(com.tencent.mm.kernel.a.azj()), g.aAh());
            AppMethodBeat.o(132596);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(132597);
            String str = "NetSync[" + hashCode() + "]";
            AppMethodBeat.o(132597);
            return str;
        }

        public e(int i2, int i3, boolean z) {
            this.scene = i2;
            this.dML = i3;
            this.jev = z;
        }

        @Override // com.tencent.mm.ak.q
        public final int getType() {
            return 138;
        }

        @Override // com.tencent.mm.ak.q
        public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
            AppMethodBeat.i(132598);
            this.jeu = iVar;
            int dispatch = dispatch(gVar, this.iMO, this);
            AppMethodBeat.o(132598);
            return dispatch;
        }

        @Override // com.tencent.mm.ak.q
        public final boolean needCheckCallback() {
            return false;
        }

        @Override // com.tencent.mm.network.m
        public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
            boolean z;
            int i5;
            AppMethodBeat.i(132599);
            if (sVar == null || sVar.getType() != 138) {
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 44, 1, false);
                Object[] objArr = new Object[2];
                objArr[0] = this;
                objArr[1] = Integer.valueOf(sVar == null ? -2 : sVar.getType());
                Log.e("MicroMsg.SyncService", "%s onGYNetEnd error type:%d", objArr);
                AppMethodBeat.o(132599);
            } else if (this.jew) {
                Log.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", this);
                AppMethodBeat.o(132599);
            } else {
                this.jew = true;
                q.S("Check rr failed.", sVar == this.iMO);
                if (i3 == 0 && i4 == 0) {
                    z = true;
                } else {
                    Log.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", this, Integer.valueOf(i3), Integer.valueOf(i4), str, sVar);
                    if (i3 == 4 && i4 == -2006) {
                        Log.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", this);
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 42, 1, false);
                        z = false;
                    } else {
                        com.tencent.mm.plugin.report.e.INSTANCE.a(11098, 3501, this.scene + ";" + i3 + ";" + i4 + ";" + CrashReportFactory.foreground + ";" + q.bdV());
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 43, 1, false);
                        this.jeu.onSceneEnd(i3, i4, str, this);
                        q.a(q.this, this);
                        AppMethodBeat.o(132599);
                        return;
                    }
                }
                final cts cts = ((v.b) sVar.getRespObj()).KAh;
                boolean z2 = WXHardCoderJNI.hcReceiveMsgEnable;
                int i6 = WXHardCoderJNI.hcReceiveMsgDelay;
                int i7 = WXHardCoderJNI.hcReceiveMsgCPU;
                int i8 = WXHardCoderJNI.hcReceiveMsgIO;
                if (WXHardCoderJNI.hcReceiveMsgThr) {
                    i5 = g.aAk().getProcessTid();
                } else {
                    i5 = 0;
                }
                final int startPerformance = WXHardCoderJNI.startPerformance(z2, i6, i7, i8, i5, WXHardCoderJNI.hcReceiveMsgTimeout, 201, WXHardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService");
                new a(q.this, this, z, cts, new b() {
                    /* class com.tencent.mm.modelmulti.q.e.AnonymousClass1 */

                    @Override // com.tencent.mm.modelmulti.q.b
                    public final boolean tF(int i2) {
                        AppMethodBeat.i(132595);
                        g.aAi();
                        g.aAh().azQ().set(8196, Long.valueOf((long) cts.KZh));
                        boolean z = (cts.KZh & e.this.dML) != 0;
                        Log.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s StorySyncKey:%s  NetSceneMinSync.this.selecto:%s", e.this, Integer.valueOf(cts.KZh), Boolean.valueOf(z), Integer.valueOf(cts.KZh & 256), Integer.valueOf(cts.KZh & 128), Integer.valueOf(e.this.dML));
                        if (!z) {
                            com.tencent.mm.plugin.zero.c cVar = new com.tencent.mm.plugin.zero.c();
                            e eVar = e.this;
                            if (cVar.JSf != null) {
                                cVar.JSf.dC(eVar);
                            }
                        }
                        if (!z && (cts.KZh & 256) != 0) {
                            wf wfVar = new wf();
                            wfVar.ecp.sourceType = 3;
                            EventCenter.instance.publish(wfVar);
                        }
                        if (!z && (cts.KZh & TPMediaCodecProfileLevel.HEVCHighTierLevel6) != 0) {
                            EventCenter.instance.publish(new oy());
                        }
                        if (!z && (cts.KZh & 128) != 0) {
                            EventCenter.instance.publish(new xd());
                        }
                        if (!z && (cts.KZh & TPMediaCodecProfileLevel.HEVCMainTierLevel62) != 0) {
                            EventCenter.instance.publish(new id());
                        }
                        if (!z && (cts.KZh & 32) != 0) {
                            EventCenter.instance.publish(new at());
                        }
                        if (z) {
                            if (i2 != 0 || !e.this.jev) {
                                q.a(q.this, e.this.scene, e.this.dML);
                            } else {
                                Log.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", e.this);
                            }
                        }
                        e.this.jeu.onSceneEnd(0, 0, "", e.this);
                        q.a(q.this, e.this);
                        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcReceiveMsgEnable, startPerformance);
                        AppMethodBeat.o(132595);
                        return true;
                    }
                }, (byte) 0);
                AppMethodBeat.o(132599);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class a {
        int jcB;
        boolean jen;
        cts jeo;
        b jep;
        c jeq;
        MTimerHandler jer;

        /* synthetic */ a(q qVar, c cVar, boolean z, cts cts, b bVar, byte b2) {
            this(cVar, z, cts, bVar);
        }

        private a(c cVar, boolean z, cts cts, b bVar) {
            AppMethodBeat.i(132591);
            this.jcB = 0;
            this.jen = false;
            this.jeo = null;
            this.jep = null;
            this.jer = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.modelmulti.q.a.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(132590);
                    if (g.aAc() && !com.tencent.mm.kernel.a.azj()) {
                        g.aAi();
                        if (g.aAh() != null) {
                            g.aAi();
                            if (g.aAh().azQ() != null) {
                                LinkedList<abn> linkedList = a.this.jeo.Ley.oTA;
                                com.tencent.mm.plugin.zero.c cVar = new com.tencent.mm.plugin.zero.c();
                                cVar.dz(a.this.jeq);
                                long nowMilliSecond = Util.nowMilliSecond();
                                while (a.this.jcB < linkedList.size()) {
                                    linkedList.size();
                                    if (!cVar.a(linkedList.get(a.this.jcB), false)) {
                                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 46, 1, false);
                                    }
                                    a.this.jcB++;
                                    long milliSecondsToNow = Util.milliSecondsToNow(nowMilliSecond);
                                    Log.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", a.this.jeq, Long.valueOf(milliSecondsToNow), Integer.valueOf(linkedList.size()), Integer.valueOf(a.this.jcB - 1));
                                    if (milliSecondsToNow >= 500) {
                                        break;
                                    }
                                }
                                cVar.dA(a.this.jeq);
                                if (a.this.jcB < linkedList.size()) {
                                    Log.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", a.this.jeq, Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), Integer.valueOf(linkedList.size()), Integer.valueOf(a.this.jcB - 1));
                                    AppMethodBeat.o(132590);
                                    return true;
                                }
                                q.a(a.this.jen, a.this.jeo, a.this.jeq);
                                a.this.jep.tF(linkedList.size());
                                AppMethodBeat.o(132590);
                                return false;
                            }
                        }
                    }
                    g.aAi();
                    Log.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", a.this.jeq, Boolean.valueOf(g.aAc()), Boolean.valueOf(com.tencent.mm.kernel.a.azj()), g.aAh());
                    a.this.jep.tF(0);
                    AppMethodBeat.o(132590);
                    return false;
                }
            }, true);
            this.jep = bVar;
            this.jeq = cVar;
            this.jen = z;
            this.jeo = cts;
            this.jcB = 0;
            q.S("", (this.jep == null || this.jeq == null) ? false : true);
            if (this.jeo == null) {
                q.S("resp Not null", false);
                Log.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", this.jeq);
                this.jep.tF(0);
                AppMethodBeat.o(132591);
                return;
            }
            if (g.aAc() && !com.tencent.mm.kernel.a.azj()) {
                g.aAi();
                if (g.aAh() != null) {
                    g.aAi();
                    if (g.aAh().azQ() != null) {
                        q.a(cts);
                        long j2 = (long) cts.Mzc;
                        j2 = String.valueOf(j2).length() == 10 ? j2 * 1000 : j2;
                        long currentTimeMillis = System.currentTimeMillis();
                        long j3 = currentTimeMillis - j2;
                        Log.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", Long.valueOf(currentTimeMillis), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j3 / 1000));
                        g.aAi();
                        g.aAh().azQ().set(ar.a.USERINFO_CLIENT_SERVER_DIFF_TIME_LONG, Long.valueOf(j3));
                        cl.Af(j2);
                        g.aAi();
                        g.aAf().cU(this.jeo.oTW, this.jeo.Mzb);
                        g.aAi();
                        g.aAf();
                        com.tencent.mm.kernel.a.qc(this.jeo.oTW);
                        if (this.jeo.Ley == null || this.jeo.Ley.oTA == null || this.jeo.Ley.oTA.size() <= 0) {
                            Log.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", this.jeq);
                            q.a(z, this.jeo, this.jeq);
                            this.jep.tF(0);
                            AppMethodBeat.o(132591);
                            return;
                        }
                        Log.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", this.jeq, Integer.valueOf(this.jeo.Ley.oTA.size()), Integer.valueOf(this.jeo.oTW), Integer.valueOf(this.jeo.Mzb));
                        this.jer.startTimer(50);
                        AppMethodBeat.o(132591);
                        return;
                    }
                }
            }
            g.aAi();
            Log.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", this.jeq, Boolean.valueOf(g.aAc()), Boolean.valueOf(com.tencent.mm.kernel.a.azj()), g.aAh());
            this.jep.tF(0);
            AppMethodBeat.o(132591);
        }
    }

    private static boolean bdM() {
        AppMethodBeat.i(132615);
        try {
            boolean booleanValue = ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) MMApplicationContext.getContext().getSystemService("power"), new Object[0])).booleanValue();
            AppMethodBeat.o(132615);
            return booleanValue;
        } catch (Exception e2) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 45, 1, false);
            Log.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", Boolean.TRUE, Util.stackTraceToString(e2));
            AppMethodBeat.o(132615);
            return true;
        }
    }

    static /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(132616);
        if (cVar == null) {
            com.tencent.mm.plugin.report.e.INSTANCE.a(11098, 3550, CrashReportFactory.foreground + ";" + bdM());
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 48, 1, false);
            AppMethodBeat.o(132616);
        } else if (cVar instanceof e) {
            com.tencent.mm.plugin.report.e.INSTANCE.a(11098, 3551, CrashReportFactory.foreground + ";" + bdM());
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 49, 1, false);
            AppMethodBeat.o(132616);
        } else if (cVar instanceof f) {
            com.tencent.mm.plugin.report.e.INSTANCE.a(11098, 3552, CrashReportFactory.foreground + ";" + bdM());
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 50, 1, false);
            AppMethodBeat.o(132616);
        } else if (cVar instanceof d) {
            com.tencent.mm.plugin.report.e.INSTANCE.a(11098, 3553, CrashReportFactory.foreground + ";" + bdM());
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 51, 1, false);
            AppMethodBeat.o(132616);
        } else {
            com.tencent.mm.plugin.report.e.INSTANCE.a(11098, 3554, CrashReportFactory.foreground + ";" + bdM());
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 52, 1, false);
            AppMethodBeat.o(132616);
        }
    }

    static /* synthetic */ void a(q qVar, final c cVar) {
        AppMethodBeat.i(132617);
        MMApplicationContext.getContext();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.modelmulti.q.AnonymousClass4 */

            public final void run() {
                boolean z = true;
                AppMethodBeat.i(132589);
                if (com.tencent.mm.kernel.a.azj() || !g.aAc()) {
                    Log.w("MicroMsg.SyncService", "begin to doLoop but MMCore account has not ready or MMCore is hold.");
                    AppMethodBeat.o(132589);
                    return;
                }
                if (cVar != null) {
                    Log.i("MicroMsg.SyncService", "finish proc:%s running:%s RunTime:%s ", cVar, q.this.jei, Long.valueOf(Util.milliSecondsToNow(q.this.jej)));
                    if (cVar != q.this.jei) {
                        for (c cVar : q.this.jeh.keySet()) {
                            Log.w("MicroMsg.SyncService", "check unfinish proc :%s timediff:%s", cVar, Long.valueOf(Util.milliSecondsToNow(((Long) q.this.jeh.get(cVar)).longValue())));
                        }
                        q.S("oldproc timeout, should in timeoutMap:" + cVar, Util.nullAs((Long) q.this.jeh.remove(cVar), -1) != -1);
                        AppMethodBeat.o(132589);
                        return;
                    }
                    q.a(cVar, q.this.jej);
                    q.this.jei = null;
                    q.this.jej = 0;
                    q.f(q.this);
                }
                if (q.this.jei != null) {
                    long milliSecondsToNow = Util.milliSecondsToNow(q.this.jej);
                    if (milliSecondsToNow > 90000) {
                        Log.w("MicroMsg.SyncService", "tryStart last proc:%s TIMEOUT:%s Run Next Now.", q.this.jei, Long.valueOf(milliSecondsToNow));
                        q.c(q.this.jei);
                        q.this.jeh.put(q.this.jei, Long.valueOf(q.this.jej));
                        q.this.jei = null;
                        q.this.jej = 0;
                        q.f(q.this);
                    } else {
                        Log.i("MicroMsg.SyncService", "tryStart last proc:%s running:%s ", q.this.jei, Long.valueOf(milliSecondsToNow));
                        AppMethodBeat.o(132589);
                        return;
                    }
                }
                com.tencent.mm.plugin.zero.b.b bVar = (com.tencent.mm.plugin.zero.b.b) g.af(com.tencent.mm.plugin.zero.b.b.class);
                if (bVar.glA().aWv()) {
                    Log.w("MicroMsg.SyncService", "Warning: Set SyncService Pause Now.");
                    bVar.glA().aWt();
                    AppMethodBeat.o(132589);
                } else if (bVar.glA().aWw()) {
                    Log.w("MicroMsg.SyncService", "Warning: SyncService is Paused.");
                    AppMethodBeat.o(132589);
                } else {
                    d dVar = new d();
                    if (dVar.c(null)) {
                        q.a(q.this, "LightPush");
                        q.this.jei = dVar;
                        q.this.jej = Util.nowMilliSecond();
                        AppMethodBeat.o(132589);
                        return;
                    }
                    while (!q.this.jeg.isEmpty()) {
                        c cVar2 = (c) q.this.jeg.poll();
                        Log.i("MicroMsg.SyncService", "tryStart check NotifyData ListSize:%s proc:%s", Integer.valueOf(q.this.jeg.size()), cVar2);
                        if (cVar2 != null && cVar2.c(null)) {
                            q.a(q.this, "NotifyData");
                            q.this.jei = cVar2;
                            q.this.jej = Util.nowMilliSecond();
                            AppMethodBeat.o(132589);
                            return;
                        }
                    }
                    if (!q.this.jef.isEmpty()) {
                        c cVar3 = (c) q.this.jef.poll();
                        Log.i("MicroMsg.SyncService", "tryStart check Sync ListSize:%s proc:%s", Integer.valueOf(q.this.jef.size()), cVar3);
                        if (cVar3 != null && cVar3.c(q.this.jef)) {
                            q.a(q.this, "NetSync");
                            q.this.jei = cVar3;
                            q.this.jej = Util.nowMilliSecond();
                            AppMethodBeat.o(132589);
                            return;
                        }
                    }
                    Log.i("MicroMsg.SyncService", "tryStart FINISH Check running:%s sync:%s notify:%s", q.this.jei, Integer.valueOf(q.this.jef.size()), Integer.valueOf(q.this.jeg.size()));
                    if (q.this.jei != null || !q.this.jef.isEmpty() || !q.this.jeg.isEmpty()) {
                        z = false;
                    }
                    q.S("", z);
                    AppMethodBeat.o(132589);
                }
            }
        });
        AppMethodBeat.o(132617);
    }

    static /* synthetic */ void a(c cVar, long j2) {
        AppMethodBeat.i(132619);
        if (cVar != null) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, (long) Util.nullAsNil((Integer) com.tencent.mm.plugin.report.e.a((int) Util.milliSecondsToNow(j2), new int[]{200, 500, 800, 1500, 3000, 5000, 10000, CommonUtils.MAX_TIMEOUT_MS, 60000, 90000}, new Integer[]{70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80})), 1, false);
        }
        AppMethodBeat.o(132619);
    }

    static /* synthetic */ void c(c cVar) {
        long j2;
        AppMethodBeat.i(132621);
        if (cVar instanceof e) {
            com.tencent.mm.plugin.report.e.INSTANCE.a(11098, 3571, CrashReportFactory.foreground + ";" + bdM());
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, CrashReportFactory.foreground ? 30 : 34, 1, false);
            AppMethodBeat.o(132621);
        } else if (cVar instanceof f) {
            com.tencent.mm.plugin.report.e.INSTANCE.a(11098, 3572, CrashReportFactory.foreground + ";" + bdM());
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, CrashReportFactory.foreground ? 31 : 35, 1, false);
            AppMethodBeat.o(132621);
        } else if (cVar instanceof d) {
            com.tencent.mm.plugin.report.e.INSTANCE.a(11098, 3573, CrashReportFactory.foreground + ";" + bdM());
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, CrashReportFactory.foreground ? 32 : 36, 1, false);
            AppMethodBeat.o(132621);
        } else {
            com.tencent.mm.plugin.report.e.INSTANCE.a(11098, 3574, CrashReportFactory.foreground + ";" + bdM());
            com.tencent.mm.plugin.report.e eVar = com.tencent.mm.plugin.report.e.INSTANCE;
            if (CrashReportFactory.foreground) {
                j2 = 33;
            } else {
                j2 = 37;
            }
            eVar.idkeyStat(99, j2, 1, false);
            AppMethodBeat.o(132621);
        }
    }

    static /* synthetic */ void b(Queue queue) {
        AppMethodBeat.i(132623);
        if (queue == null || queue.isEmpty()) {
            AppMethodBeat.o(132623);
            return;
        }
        if (queue.size() >= 5) {
            com.tencent.mm.plugin.report.e.INSTANCE.a(11098, 3590, queue.size() + ";" + CrashReportFactory.foreground + ";" + bdM());
        }
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, (long) Util.nullAsNil((Integer) com.tencent.mm.plugin.report.e.a(queue.size(), new int[]{1, 2, 3, 4, 5, 10}, new Integer[]{60, 61, 62, 63, 64, 65, 66})), 1, false);
        AppMethodBeat.o(132623);
    }

    static /* synthetic */ void a(e eVar) {
        long j2;
        AppMethodBeat.i(132624);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, (long) eVar.scene, 1, false);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 0, 1, false);
        com.tencent.mm.plugin.report.e eVar2 = com.tencent.mm.plugin.report.e.INSTANCE;
        if (CrashReportFactory.foreground) {
            j2 = 241;
        } else {
            j2 = 242;
        }
        eVar2.idkeyStat(99, j2, 1, false);
        AppMethodBeat.o(132624);
    }

    static /* synthetic */ void a(cts cts) {
        int i2;
        long j2;
        AppMethodBeat.i(132627);
        if (cts.Ley == null || cts.Ley.oTA == null || cts.Ley.oTA.size() <= 0) {
            i2 = 0;
        } else {
            i2 = cts.Ley.oTA.size();
        }
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, (long) Util.nullAsNil((Integer) com.tencent.mm.plugin.report.e.a(i2, new int[]{0, 1, 2, 3, 5, 10}, new Integer[]{Integer.valueOf((int) cr.CTRL_INDEX), 248, 247, 246, 245, 244, Integer.valueOf((int) com.tencent.mm.plugin.appbrand.jsapi.o.b.d.CTRL_INDEX)})), 1, false);
        if (!bdM()) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, i2 > 0 ? 221 : 218, 1, false);
            AppMethodBeat.o(132627);
        } else if (!CrashReportFactory.foreground) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, i2 > 0 ? 220 : 217, 1, false);
            AppMethodBeat.o(132627);
        } else {
            com.tencent.mm.plugin.report.e eVar = com.tencent.mm.plugin.report.e.INSTANCE;
            if (i2 > 0) {
                j2 = 219;
            } else {
                j2 = 216;
            }
            eVar.idkeyStat(99, j2, 1, false);
            AppMethodBeat.o(132627);
        }
    }

    static /* synthetic */ void a(boolean z, cts cts, c cVar) {
        AppMethodBeat.i(132628);
        g.aAi();
        byte[] decodeHexString = Util.decodeHexString(Util.nullAsNil((String) g.aAh().azQ().get(8195, "")));
        byte[] a2 = z.a(cts.Lev);
        Log.i("MicroMsg.SyncService", "processResp %s synckey req:%s  shouldMerge:%s", cVar, ad.cK(decodeHexString), Boolean.valueOf(z));
        Log.i("MicroMsg.SyncService", "processResp %s synckey resp:%s", cVar, ad.cK(a2));
        if (cts.Lev == null || cts.Lev.getILen() <= 0) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(99, 47, 1, false);
            AppMethodBeat.o(132628);
            return;
        }
        if (z) {
            byte[] l = ad.l(decodeHexString, a2);
            Log.i("MicroMsg.SyncService", "processResp %s synckey merge:%s", cVar, ad.cK(l));
            if (l == null || l.length <= 0) {
                l = a2;
            }
            cts.Lev = z.aC(l);
        }
        if (!Arrays.equals(decodeHexString, z.a(cts.Lev))) {
            g.aAi();
            g.aAh().azQ().set(8195, Util.encodeHexString(z.a(cts.Lev)));
            MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.aps()).edit().putString("notify_sync_key_keybuf", Util.encodeHexString(z.a(cts.Lev))).commit();
            AppMethodBeat.o(132628);
            return;
        }
        Log.i("MicroMsg.SyncService", "processResp %s  Sync Key Not change, not save", cVar);
        AppMethodBeat.o(132628);
    }
}
