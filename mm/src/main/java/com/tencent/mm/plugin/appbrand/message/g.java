package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.d;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.protocal.protobuf.bwl;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.protocal.protobuf.dxt;
import com.tencent.mm.protocal.protobuf.elo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class g implements m {
    private static Map<String, Object> ngu = new HashMap();
    private static Map<String, List<a>> ngv = new HashMap();

    static {
        AppMethodBeat.i(47740);
        AppMethodBeat.o(47740);
    }

    @Override // com.tencent.mm.modelappbrand.m
    public final c Lq(String str) {
        AppMethodBeat.i(47733);
        d buI = n.buI();
        if (buI == null) {
            Log.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null");
            AppMethodBeat.o(47733);
            return null;
        } else if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WxaUpdateableMsgService", "shareKey is null, return");
            AppMethodBeat.o(47733);
            return null;
        } else {
            int hashCode = str.hashCode();
            c cVar = new c();
            cVar.field_shareKeyHash = hashCode;
            if (!buI.get(cVar, "shareKeyHash")) {
                Log.e("MicroMsg.WxaUpdateableMsgStorage", "WxaUpdateableMsg is null");
                cVar = null;
            }
            if (cVar == null) {
                Log.e("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, wxaUpdateableMsg is null", str, Integer.valueOf(str.hashCode()));
                AppMethodBeat.o(47733);
                return null;
            }
            Log.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d status:%s", str, Integer.valueOf(str.hashCode()), Integer.valueOf(cVar.field_btnState));
            AppMethodBeat.o(47733);
            return cVar;
        }
    }

    @Override // com.tencent.mm.modelappbrand.m
    public final boolean ao(String str, int i2) {
        boolean update;
        AppMethodBeat.i(47734);
        d buI = n.buI();
        if (buI == null) {
            Log.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
            AppMethodBeat.o(47734);
            return false;
        }
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
            update = false;
        } else {
            c cVar = new c();
            cVar.field_shareKeyHash = str.hashCode();
            boolean z = buI.get(cVar, new String[0]);
            cVar.field_btnState = i2;
            update = z ? buI.update(cVar, new String[0]) : buI.insert(cVar);
        }
        Log.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, btnState:%d isOk:%b", str, Integer.valueOf(str.hashCode()), Integer.valueOf(i2), Boolean.valueOf(update));
        if (update) {
            ngu.get(str);
        }
        AppMethodBeat.o(47734);
        return update;
    }

    @Override // com.tencent.mm.modelappbrand.m
    public final boolean a(String str, String str2, String str3, int i2, int i3) {
        boolean update;
        AppMethodBeat.i(47735);
        d buI = n.buI();
        if (buI == null) {
            Log.e("MicroMsg.WxaUpdateableMsgService", "wxaUpdateableMsgStorage is null, err");
            AppMethodBeat.o(47735);
            return false;
        }
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WxaUpdateableMsgStorage", "shareKey is null, err");
            update = false;
        } else {
            c cVar = new c();
            cVar.field_shareKeyHash = str.hashCode();
            boolean z = buI.get(cVar, new String[0]);
            cVar.field_updatePeroid = i2;
            cVar.field_msgState = i3;
            cVar.field_content = str2;
            cVar.field_contentColor = str3;
            update = z ? buI.update(cVar, new String[0]) : buI.insert(cVar);
        }
        Log.d("MicroMsg.WxaUpdateableMsgService", "shareKey:%s, shareKeyHash:%d, content:%s contentColor:%s isOk:%b", str, Integer.valueOf(str.hashCode()), str2, str3, Boolean.valueOf(update));
        AppMethodBeat.o(47735);
        return update;
    }

    @Override // com.tencent.mm.modelappbrand.m
    public final synchronized void a(String str, String str2, String str3, int i2, m.a aVar) {
        AppMethodBeat.i(47736);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.WxaUpdateableMsgService", "token appId or shareKey is null, return");
            AppMethodBeat.o(47736);
        } else {
            List<a> list = ngv.get(str);
            if (list == null) {
                Log.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange token:%s", str);
                list = new ArrayList<>();
                ngv.put(str, list);
            }
            Log.i("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKeyHash:%d", Integer.valueOf(str3.hashCode()));
            Log.d("MicroMsg.WxaUpdateableMsgService", "addOnUpdatbleMsgInfoChange shareKey:%s", str3);
            a aVar2 = new a((byte) 0);
            aVar2.appId = str2;
            aVar2.cyr = str3;
            aVar2.ngw = i2;
            aVar2.ngx = aVar;
            if (Util.isNullOrNil(aVar2.appId) || Util.isNullOrNil(aVar2.cyr)) {
                Log.w("MicroMsg.WxaUpdateableMsgService", "appId or shareKey is null, return");
            } else {
                b bVar = b.INSTANCE;
                Log.d("MicroMsg.WxaUpdateableMsgService", "[addWorker]getUpdatableMsgWorkerList size:%d", Integer.valueOf(bVar.ngz.size()));
                bVar.ngz.put(Integer.valueOf(aVar2.cyr.hashCode()), aVar2);
            }
            list.add(aVar2);
            AppMethodBeat.o(47736);
        }
    }

    @Override // com.tencent.mm.modelappbrand.m
    public final synchronized void Lr(String str) {
        AppMethodBeat.i(47737);
        Log.i("MicroMsg.WxaUpdateableMsgService", "removeOnUpdatbleMsgInfoChange token:%s", str);
        List<a> list = ngv.get(str);
        if (list == null) {
            Log.w("MicroMsg.WxaUpdateableMsgService", "[removeOnUpdatbleMsgInfoChange]getUpdatableMsgWorkers is null, err");
            AppMethodBeat.o(47737);
        } else {
            for (a aVar : list) {
                b bVar = b.INSTANCE;
                Log.d("MicroMsg.WxaUpdateableMsgService", "[removeWorker]getUpdatableMsgWorkerList size:%d", Integer.valueOf(bVar.ngz.size()));
                bVar.ngz.remove(Integer.valueOf(aVar.cyr.hashCode()));
            }
            ngv.remove(str);
            AppMethodBeat.o(47737);
        }
    }

    @Override // com.tencent.mm.modelappbrand.m
    public final void aXM() {
        AppMethodBeat.i(47738);
        Log.i("MicroMsg.WxaUpdateableMsgService", "startUpdatbleMsgInfoChange");
        b.INSTANCE.start();
        AppMethodBeat.o(47738);
    }

    @Override // com.tencent.mm.modelappbrand.m
    public final void aXN() {
        AppMethodBeat.i(47739);
        Log.i("MicroMsg.WxaUpdateableMsgService", "stopOnUpdatbleMsgInfoChange");
        b.INSTANCE.stop();
        AppMethodBeat.o(47739);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public String appId;
        public String cyr;
        public long lastUpdateTime;
        public int ngw;
        public m.a ngx;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final boolean bPk() {
            AppMethodBeat.i(47718);
            if (this.ngw < 0) {
                AppMethodBeat.o(47718);
                return false;
            } else if (this.ngw == 0) {
                if (bPl() > 10000) {
                    AppMethodBeat.o(47718);
                    return true;
                }
                AppMethodBeat.o(47718);
                return false;
            } else if (bPl() > ((long) this.ngw) * 1000) {
                AppMethodBeat.o(47718);
                return true;
            } else {
                AppMethodBeat.o(47718);
                return false;
            }
        }

        private long bPl() {
            AppMethodBeat.i(47719);
            long currentTimeMillis = System.currentTimeMillis() - this.lastUpdateTime;
            Log.d("MicroMsg.WxaUpdateableMsgService", "consumeTime:%d", Long.valueOf(currentTimeMillis));
            AppMethodBeat.o(47719);
            return currentTimeMillis;
        }
    }

    public enum b {
        INSTANCE;
        
        private AtomicBoolean dxi = new AtomicBoolean(true);
        private Runnable ngA = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.message.g.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(47720);
                LinkedList<dxt> linkedList = new LinkedList<>();
                for (a aVar : b.this.ngz.values()) {
                    if (aVar.bPk()) {
                        dxt dxt = new dxt();
                        dxt.MXx = aVar.cyr;
                        dxt.dNI = aVar.appId;
                        linkedList.add(dxt);
                    }
                }
                b bVar = b.this;
                if (linkedList.size() <= 0) {
                    Log.d("MicroMsg.WxaUpdateableMsgService", "shareKeyInfoList is null, return");
                    bVar.bPm();
                    AppMethodBeat.o(47720);
                    return;
                }
                Log.d("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg shareKeyInfoList.size:%d", Integer.valueOf(linkedList.size()));
                d.a aVar2 = new d.a();
                aVar2.funcId = 2954;
                aVar2.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getupdatablemsginfo";
                bwl bwl = new bwl();
                bwl.Mci = linkedList;
                aVar2.iLN = bwl;
                aVar2.iLO = new bwm();
                aa.a(aVar2.aXF(), new aa.a() {
                    /* class com.tencent.mm.plugin.appbrand.message.g.b.AnonymousClass2 */

                    @Override // com.tencent.mm.ak.aa.a
                    public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                        AppMethodBeat.i(47721);
                        bwm bwm = (bwm) dVar.iLL.iLR;
                        Log.i("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                        if (i2 == 0 && i3 == 0 && bwm.Mcj != null && bwm.Mcj.size() > 0) {
                            Log.i("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg response.updatable_msg_list.size:%d", Integer.valueOf(bwm.Mcj.size()));
                            b.a(b.this, bwm);
                            b.a(bwm);
                            b.b(b.this, bwm);
                            b.b(b.this);
                        }
                        AppMethodBeat.o(47721);
                        return 0;
                    }
                });
                AppMethodBeat.o(47720);
            }
        };
        Map<Integer, a> ngz = new ConcurrentHashMap();

        private b(String str) {
            AppMethodBeat.i(47724);
            AppMethodBeat.o(47724);
        }

        static /* synthetic */ void b(b bVar) {
            AppMethodBeat.i(47731);
            bVar.bPm();
            AppMethodBeat.o(47731);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(47723);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(47723);
            return bVar;
        }

        static {
            AppMethodBeat.i(47732);
            AppMethodBeat.o(47732);
        }

        public final synchronized void start() {
            AppMethodBeat.i(47725);
            this.dxi.set(false);
            bPm();
            AppMethodBeat.o(47725);
        }

        public final synchronized void stop() {
            AppMethodBeat.i(47726);
            this.dxi.set(true);
            AppMethodBeat.o(47726);
        }

        /* access modifiers changed from: package-private */
        public final synchronized void bPm() {
            long j2;
            boolean z = false;
            boolean z2 = true;
            synchronized (this) {
                AppMethodBeat.i(47727);
                com.tencent.mm.kernel.g.aAk();
                MMHandlerThread.removeRunnable(this.ngA);
                if (this.dxi.get()) {
                    Log.d("MicroMsg.WxaUpdateableMsgService", "isPause, not sendUpdatableMsgRequest");
                    AppMethodBeat.o(47727);
                } else if (this.ngz.size() <= 0) {
                    Log.d("MicroMsg.WxaUpdateableMsgService", "sGetUpdatableMsgWorkerMap is empty, not sendUpdatableMsgRequest");
                    AppMethodBeat.o(47727);
                } else {
                    long j3 = MAlarmHandler.NEXT_FIRE_INTERVAL;
                    Iterator<a> it = this.ngz.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            j2 = j3;
                            z2 = z;
                            break;
                        }
                        a next = it.next();
                        if (next.bPk()) {
                            j2 = 0;
                            break;
                        } else if (next.ngw >= 0) {
                            j3 = Math.min((long) next.ngw, j3);
                            z = true;
                        }
                    }
                    Log.d("MicroMsg.WxaUpdateableMsgService", "needUpdate:%b minDelayTime:%d", Boolean.valueOf(z2), Long.valueOf(j2));
                    if (!z2) {
                        AppMethodBeat.o(47727);
                    } else {
                        com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(this.ngA, j2 * 1000);
                        AppMethodBeat.o(47727);
                    }
                }
            }
        }

        static /* synthetic */ void a(b bVar, bwm bwm) {
            AppMethodBeat.i(47728);
            Iterator<elo> it = bwm.Mcj.iterator();
            while (it.hasNext()) {
                elo next = it.next();
                if (next.MXv != 0) {
                    a aVar = bVar.ngz.get(Integer.valueOf(next.MXx.hashCode()));
                    if (aVar == null) {
                        Log.d("MicroMsg.WxaUpdateableMsgService", "share_key:%s getUpdatableMsgWorkers is null", next.MXx);
                        AppMethodBeat.o(47728);
                        return;
                    }
                    aVar.ngw = next.MXv;
                    aVar.lastUpdateTime = System.currentTimeMillis();
                }
            }
            AppMethodBeat.o(47728);
        }

        static /* synthetic */ void a(bwm bwm) {
            AppMethodBeat.i(47729);
            Iterator<elo> it = bwm.Mcj.iterator();
            while (it.hasNext()) {
                elo next = it.next();
                ((m) com.tencent.mm.kernel.g.af(m.class)).a(next.MXx, next.content, next.MXr, next.MXv, next.state);
            }
            AppMethodBeat.o(47729);
        }

        static /* synthetic */ void b(b bVar, bwm bwm) {
            AppMethodBeat.i(47730);
            Iterator<elo> it = bwm.Mcj.iterator();
            while (it.hasNext()) {
                elo next = it.next();
                a aVar = bVar.ngz.get(Integer.valueOf(next.MXx.hashCode()));
                if (aVar == null) {
                    Log.d("MicroMsg.WxaUpdateableMsgService", "share_key:%s getUpdatableMsgWorkers is null", next.MXx);
                    AppMethodBeat.o(47730);
                    return;
                }
                Log.d("MicroMsg.WxaUpdateableMsgService", "updatableMsgInfo.share_key:%s update %s updatePeriod:%d state:%d", next.MXx, next.content, Integer.valueOf(next.MXv), Integer.valueOf(next.state));
                if (aVar.ngx != null) {
                    aVar.ngx.a(next.MXx, next);
                }
            }
            AppMethodBeat.o(47730);
        }
    }
}
