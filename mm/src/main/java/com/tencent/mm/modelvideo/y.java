package com.tencent.mm.modelvideo;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.s;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class y {
    public static String jsU = null;

    public static class a implements i, t.a {
        private static int jrr = 0;
        Queue<String> dAA = new LinkedList();
        Queue<String> dAB = new LinkedList();
        Map<String, f.a> dAC = new HashMap();
        boolean dAD = false;
        private boolean dAE = false;
        int dAF = 0;
        private long dAG = 0;
        f.a dAI = new f.a();
        private MTimerHandler dAJ = null;
        MMHandler jsV;
        boolean jsW = false;
        private List<w> jsX = new ArrayList();
        Queue<String> jsY = new LinkedList();
        Queue<String> jsZ = new LinkedList();
        private VideoTransPara jsd = null;
        private VideoTransPara jse = null;
        d jta = null;
        g jtb = null;
        ConcurrentHashMap<String, WeakReference<t.a>> jtc = new ConcurrentHashMap<>();
        private boolean running = false;

        static /* synthetic */ int aYz() {
            int i2 = jrr;
            jrr = i2 + 1;
            return i2;
        }

        static /* synthetic */ int bhI() {
            int i2 = jrr;
            jrr = i2 - 1;
            return i2;
        }

        static /* synthetic */ int f(a aVar) {
            int i2 = aVar.dAF;
            aVar.dAF = i2 - 1;
            return i2;
        }

        static /* synthetic */ void k(a aVar) {
            AppMethodBeat.i(127055);
            aVar.aax();
            AppMethodBeat.o(127055);
        }

        public a() {
            AppMethodBeat.i(127042);
            g.azz().a(149, this);
            g.azz().a(150, this);
            o.bhj().a(this, Looper.getMainLooper());
            this.jsW = true;
            com.tencent.f.j.a bqt = com.tencent.f.j.a.bqt("VideoService_runThread");
            this.jsV = new MMHandler(bqt);
            this.dAJ = new MTimerHandler(bqt, (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.modelvideo.y.a.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(127035);
                    a.a(a.this);
                    AppMethodBeat.o(127035);
                    return false;
                }

                public final String toString() {
                    AppMethodBeat.i(127036);
                    String str = super.toString() + "|scenePusher";
                    AppMethodBeat.o(127036);
                    return str;
                }
            }, false);
            Log.i("MicroMsg.VideoService", "create VideoService, start video send thread");
            AppMethodBeat.o(127042);
        }

        public final void a(w wVar) {
            AppMethodBeat.i(127043);
            Log.printInfoStack("MicroMsg.VideoService", "addVideoMsgSendCallback %s", wVar);
            if (!(wVar == null || this.jsX == null || this.jsX.contains(wVar))) {
                this.jsX.add(wVar);
            }
            AppMethodBeat.o(127043);
        }

        public final void b(w wVar) {
            AppMethodBeat.i(127044);
            if (!(wVar == null || this.jsX == null)) {
                this.jsX.remove(wVar);
            }
            AppMethodBeat.o(127044);
        }

        private boolean bhF() {
            AppMethodBeat.i(127045);
            long currentTicks = Util.currentTicks();
            if (o.bhj() == null) {
                Log.e("MicroMsg.VideoService", "error, video info storage is null!!");
                AppMethodBeat.o(127045);
                return false;
            }
            try {
                t bhj = o.bhj();
                LinkedList<String> linkedList = new LinkedList();
                Iterator<t.c> it = t.d.iYu.iterator();
                while (it.hasNext()) {
                    linkedList.addAll(bhj.Qt(it.next().table));
                }
                List<String> bhC = o.bhj().bhC();
                List<String> bhD = o.bhj().bhD();
                Log.d("MicroMsg.VideoService", "getNeedRunInfo needSendList size: " + linkedList.size());
                for (String str : linkedList) {
                    if (this.dAC.containsKey(str)) {
                        Log.d("MicroMsg.VideoService", "need sendList File is Already running:".concat(String.valueOf(str)));
                    } else {
                        this.dAA.offer(str);
                        this.dAC.put(str, null);
                    }
                }
                Log.d("MicroMsg.VideoService", "getNeedRunInfo needRecvList size: " + bhC.size());
                for (String str2 : bhC) {
                    if (this.dAC.containsKey(str2)) {
                        Log.d("MicroMsg.VideoService", "need recvList File is Already running:".concat(String.valueOf(str2)));
                    } else {
                        this.dAB.offer(str2);
                        this.dAC.put(str2, null);
                    }
                }
                Log.d("MicroMsg.VideoService", "getNeedRunInfo online video list size: " + bhD.size());
                for (String str3 : bhD) {
                    if (this.dAC.containsKey(str3)) {
                        Log.d("MicroMsg.VideoService", "online videoList File is Already running:".concat(String.valueOf(str3)));
                    } else {
                        this.jsY.offer(str3);
                        this.dAC.put(str3, null);
                    }
                }
                Log.i("MicroMsg.VideoService", "GetNeedRun cost time[%d] procing[%d] [recv:%d, online:%d, send:%d ]", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(this.dAC.size()), Integer.valueOf(this.dAB.size()), Integer.valueOf(this.jsY.size()), Integer.valueOf(this.dAA.size()));
                if (this.dAB.size() + this.dAA.size() + this.jsY.size() != 0) {
                    AppMethodBeat.o(127045);
                    return true;
                }
                AppMethodBeat.o(127045);
                return false;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VideoService", e2, "getNeedRunInfo error: %s", e2.getMessage());
                AppMethodBeat.o(127045);
                return false;
            }
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(final int i2, final int i3, String str, final q qVar) {
            AppMethodBeat.i(127046);
            if (!this.jsW || this.jsV == null) {
                Log.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
                AppMethodBeat.o(127046);
                return;
            }
            this.jsV.post(new Runnable() {
                /* class com.tencent.mm.modelvideo.y.a.AnonymousClass2 */

                public final void run() {
                    int i2;
                    String str;
                    AppMethodBeat.i(127037);
                    a.aYz();
                    if (qVar.getType() == 150) {
                        a.this.dAD = false;
                        String str2 = ((d) qVar).fileName;
                        y.jsU = str2;
                        int i3 = ((d) qVar).retCode;
                        a.this.jta = null;
                        i2 = i3;
                        str = str2;
                    } else if (qVar.getType() == 149) {
                        a.this.dAE = false;
                        a.this.jtb = null;
                        if (qVar instanceof g) {
                            String str3 = ((g) qVar).fileName;
                            i2 = ((g) qVar).retCode;
                            str = str3;
                        } else if (qVar instanceof h) {
                            i2 = 0;
                            str = ((h) qVar).fileName;
                        } else {
                            i2 = 0;
                            str = null;
                        }
                    } else {
                        Log.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + qVar.getType());
                        a.bhI();
                        AppMethodBeat.o(127037);
                        return;
                    }
                    long j2 = 0;
                    if (!(str == null || a.this.dAC.get(str) == null)) {
                        j2 = a.this.dAC.get(str).apr();
                        a.this.dAC.remove(str);
                    }
                    Log.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + qVar.getType() + " errtype:" + i2 + " errCode:" + i3 + " retCode:" + i2 + " file:" + str + " time:" + j2);
                    if (i2 == 3 && i2 != 0) {
                        a.f(a.this);
                    } else if (i2 != 0) {
                        a.this.dAF = 0;
                    }
                    Log.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + a.jrr + " stop:" + a.this.dAF + " running:" + a.this.running + " recving:" + a.this.dAD + " sending:" + a.this.dAE);
                    if (a.this.dAF > 0) {
                        a.a(a.this);
                    } else if (!a.this.dAE && !a.this.dAD) {
                        a.k(a.this);
                    }
                    a.bhI();
                    AppMethodBeat.o(127037);
                }

                public final String toString() {
                    AppMethodBeat.i(127038);
                    String str = super.toString() + "|onSceneEnd";
                    AppMethodBeat.o(127038);
                    return str;
                }
            });
            AppMethodBeat.o(127046);
        }

        private void aax() {
            AppMethodBeat.i(127047);
            this.dAC.clear();
            this.dAA.clear();
            this.dAB.clear();
            this.jsY.clear();
            this.jsZ.clear();
            this.dAE = false;
            this.dAD = false;
            this.running = false;
            Log.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.dAI.apr());
            AppMethodBeat.o(127047);
        }

        public final void run() {
            AppMethodBeat.i(127048);
            if (!this.jsW || this.jsV == null) {
                Log.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
                AppMethodBeat.o(127048);
                return;
            }
            this.jsV.post(new Runnable() {
                /* class com.tencent.mm.modelvideo.y.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(127039);
                    long currentTimeMillis = System.currentTimeMillis() - a.this.dAG;
                    Log.d("MicroMsg.VideoService", "Try Run service runningFlag:" + a.this.running + " timeWait:" + currentTimeMillis + " sending:" + a.this.dAE + " recving:" + a.this.dAD);
                    if (a.this.running) {
                        if (currentTimeMillis < Util.MILLSECONDS_OF_MINUTE) {
                            AppMethodBeat.o(127039);
                            return;
                        }
                        Log.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + a.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + a.this.dAE + " recving:" + a.this.dAD);
                    }
                    a.this.dAF = 3;
                    a.this.running = true;
                    a.this.dAE = false;
                    a.this.dAD = false;
                    a.this.jtb = null;
                    a.this.jta = null;
                    a.this.dAI.gLm = SystemClock.elapsedRealtime();
                    a.this.dAJ.startTimer(10);
                    AppMethodBeat.o(127039);
                }

                public final String toString() {
                    AppMethodBeat.i(127040);
                    String str = super.toString() + "|run";
                    AppMethodBeat.o(127040);
                    return str;
                }
            });
            AppMethodBeat.o(127048);
        }

        public final boolean bhG() {
            boolean z;
            AppMethodBeat.i(127049);
            if (this.jta != null) {
                g.azz().a(this.jta);
                z = true;
                this.running = false;
            } else {
                z = false;
            }
            this.dAC.clear();
            this.dAA.clear();
            this.dAB.clear();
            this.jsY.clear();
            this.jsZ.clear();
            AppMethodBeat.o(127049);
            return z;
        }

        public final void bhH() {
            AppMethodBeat.i(127050);
            g.azz().a(this.jta);
            aax();
            AppMethodBeat.o(127050);
        }

        public final void QV(String str) {
            AppMethodBeat.i(127051);
            this.dAC.remove(str);
            AppMethodBeat.o(127051);
        }

        public final void a(final String str, t.a aVar) {
            AppMethodBeat.i(127052);
            this.jtc.put(str, new WeakReference<>(aVar));
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.modelvideo.y.a.AnonymousClass4 */
                final /* synthetic */ int jte = 3;

                public final void run() {
                    AppMethodBeat.i(127041);
                    u.aA(str, this.jte);
                    s QN = u.QN(str);
                    if (!(QN == null || QN.status == 199)) {
                        if (QN.bhx()) {
                            Log.i("MicroMsg.VideoService", "start complete online video");
                            u.QT(str);
                            AppMethodBeat.o(127041);
                            return;
                        }
                        Log.i("MicroMsg.VideoService", "start complete offline video");
                        u.QI(str);
                    }
                    AppMethodBeat.o(127041);
                }
            });
            AppMethodBeat.o(127052);
        }

        @Override // com.tencent.mm.modelvideo.t.a
        public final void a(t.a.C0460a aVar) {
            t.a aVar2;
            AppMethodBeat.i(127053);
            WeakReference<t.a> weakReference = this.jtc.get(aVar.fileName);
            if (!(weakReference == null || (aVar2 = weakReference.get()) == null)) {
                aVar2.a(aVar);
            }
            s QN = u.QN(aVar.fileName);
            if (QN != null && QN.status == 199) {
                this.jtc.remove(aVar.fileName);
            }
            AppMethodBeat.o(127053);
        }

        static /* synthetic */ void a(a aVar) {
            s QN;
            boolean z = false;
            AppMethodBeat.i(127054);
            Log.i("MicroMsg.VideoService", "tryStartNetscene");
            aVar.dAG = System.currentTimeMillis();
            if ((!aVar.dAD && aVar.dAB.size() + aVar.jsY.size() == 0) || (!aVar.dAE && aVar.dAA.size() == 0)) {
                aVar.bhF();
            }
            boolean z2 = aVar.jsZ.size() == 0 || !e.bbn();
            if (aVar.dAD || aVar.dAB.size() + aVar.jsY.size() != 0 || !z2 || aVar.dAE || aVar.dAA.size() != 0) {
                if (!aVar.dAD && (aVar.dAB.size() > 0 || aVar.jsY.size() > 0 || !z2)) {
                    if (aVar.jsY.size() > 0) {
                        String poll = aVar.jsY.poll();
                        Log.i("MicroMsg.VideoService", "Start Recv :".concat(String.valueOf(poll)));
                        if (!Util.isNullOrNil(poll)) {
                            aVar.dAC.put(poll, new f.a());
                            aVar.dAD = true;
                            Assert.assertTrue("sceneDown should null", aVar.jta == null);
                            if (!(!((b) g.af(b.class)).a(b.a.clicfg_update_mpvideo, true) || (QN = u.QN(poll)) == null || QN.status == 112)) {
                                QN.status = 112;
                                u.f(QN);
                            }
                            aVar.jta = new d(poll, true);
                            g.azz().a(aVar.jta, 0);
                        }
                    }
                    if (!aVar.dAD && aVar.dAB.size() > 0) {
                        String poll2 = aVar.dAB.poll();
                        Log.i("MicroMsg.VideoService", "Start Recv :".concat(String.valueOf(poll2)));
                        if (poll2 != null) {
                            aVar.dAC.put(poll2, new f.a());
                            aVar.dAD = true;
                            Assert.assertTrue("sceneDown should null", aVar.jta == null);
                            aVar.jta = new d(poll2);
                            g.azz().a(aVar.jta, 0);
                        }
                    }
                }
                if (!aVar.dAE && aVar.dAA.size() > 0) {
                    String poll3 = aVar.dAA.poll();
                    Log.i("MicroMsg.VideoService", "Start Send :".concat(String.valueOf(poll3)));
                    if (poll3 != null) {
                        s QN2 = u.QN(poll3);
                        if (QN2 != null) {
                            Log.i("MicroMsg.VideoService", "Start Send, f: %s, videoFormat: %s", poll3, Integer.valueOf(QN2.videoFormat));
                        }
                        aVar.dAC.put(poll3, new f.a());
                        aVar.dAE = true;
                        if (aVar.jtb == null) {
                            z = true;
                        }
                        Assert.assertTrue("sceneUp should null", z);
                        if (aVar.jsX != null && aVar.jsX.size() > 0) {
                            for (w wVar : aVar.jsX) {
                                wVar.Qk(poll3);
                            }
                        }
                        s bcY = s.bcY();
                        bcY.fileName = poll3;
                        bcY.jdR = 1;
                        o.b bdQ = bcY.bdQ();
                        aVar.jtb = (g) bdQ.jdJ;
                        bdQ.execute();
                    }
                }
                AppMethodBeat.o(127054);
                return;
            }
            aVar.aax();
            Log.d("MicroMsg.VideoService", "No Data Any More , Stop Service");
            AppMethodBeat.o(127054);
        }
    }
}
