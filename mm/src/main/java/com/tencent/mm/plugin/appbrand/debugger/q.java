package com.tencent.mm.plugin.appbrand.debugger;

import android.webkit.ValueCallback;
import com.eclipsesource.v8.V8Inspector;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.s;
import com.tencent.mm.protocal.protobuf.eva;
import com.tencent.mm.protocal.protobuf.evb;
import com.tencent.mm.protocal.protobuf.evc;
import com.tencent.mm.protocal.protobuf.evd;
import com.tencent.mm.protocal.protobuf.eve;
import com.tencent.mm.protocal.protobuf.evf;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.protocal.protobuf.evj;
import com.tencent.mm.protocal.protobuf.evl;
import com.tencent.mm.protocal.protobuf.evn;
import com.tencent.mm.protocal.protobuf.evp;
import com.tencent.mm.protocal.protobuf.evq;
import com.tencent.mm.protocal.protobuf.evr;
import com.tencent.mm.protocal.protobuf.evt;
import com.tencent.mm.protocal.protobuf.ewc;
import com.tencent.mm.protocal.protobuf.ewd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;
import org.json.JSONArray;

public final class q {
    private static final Map<String, String[]> liH;
    m cBt;
    private LruCache<Integer, Long> liI = new LruCache<>(100);
    private boolean liJ = false;
    private long liK;
    private LinkedList<p> liL = new LinkedList<>();
    private final int liM = 5000;
    private int liN = 0;
    private long liO = 0;
    u liu;
    w lix;
    Timer mTimer;

    static /* synthetic */ void a(q qVar, LinkedList linkedList) {
        AppMethodBeat.i(147076);
        qVar.a((LinkedList<p>) linkedList, true);
        AppMethodBeat.o(147076);
    }

    static {
        AppMethodBeat.i(147077);
        HashMap hashMap = new HashMap();
        liH = hashMap;
        hashMap.put("publishHandler", new String[]{"String", "String", "String"});
        liH.put("invokeHandler", new String[]{"String", "String", "Number"});
        AppMethodBeat.o(147077);
    }

    public q() {
        AppMethodBeat.i(147049);
        V8Inspector.setServer(new V8Inspector.JsInspectorChannelServer() {
            /* class com.tencent.mm.plugin.appbrand.debugger.q.AnonymousClass1 */

            @Override // com.eclipsesource.v8.V8Inspector.JsInspectorChannelServer
            public final int sendData(long j2, String str) {
                AppMethodBeat.i(147046);
                q.a(q.this, j2, str);
                AppMethodBeat.o(147046);
                return 0;
            }

            @Override // com.eclipsesource.v8.V8Inspector.JsInspectorChannelServer
            public final int notify(long j2, long j3, String str) {
                return 0;
            }
        });
        AppMethodBeat.o(147049);
    }

    public final void a(u uVar, m mVar, w wVar) {
        this.liu = uVar;
        this.cBt = mVar;
        this.lix = wVar;
    }

    public static void a(evr evr) {
        AppMethodBeat.i(147050);
        evr.Nta = "WeixinJSCore";
        for (String str : liH.keySet()) {
            if (liH.get(str).length > 5) {
                Log.e("MicroMsg.RemoteDebugMsgMrg", "Interface method only support five arguments!");
            } else {
                evn evn = new evn();
                evn.Ntb = str;
                for (int i2 = 0; i2 < liH.get(str).length; i2++) {
                    evn.Ntc.add(liH.get(str)[i2]);
                }
                evr.Nts.add(evn);
            }
        }
        AppMethodBeat.o(147050);
    }

    private void a(evb evb) {
        String y;
        AppMethodBeat.i(147051);
        Log.i("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, method: %s, call_id %d", evb.Ntb, Integer.valueOf(evb.Ntd));
        String str = evb.Ntb;
        LinkedList<String> linkedList = evb.Ntc;
        if (!liH.containsKey(str)) {
            Log.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodWithArgs is null");
            AppMethodBeat.o(147051);
            return;
        }
        String[] strArr = liH.get(str);
        if (linkedList.size() < strArr.length) {
            Log.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface, methodArgValueList.size() < methodArgList.size()");
            AppMethodBeat.o(147051);
            return;
        }
        LinkedList linkedList2 = new LinkedList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if ("Number".equals(strArr[i2])) {
                linkedList2.add(Integer.valueOf(Util.getInt(linkedList.get(i2), 0)));
            } else if ("Boolean".equals(strArr[i2])) {
                linkedList2.add(Boolean.valueOf(linkedList.get(i2)));
            } else {
                linkedList2.add(linkedList.get(i2));
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 574772027:
                if (str.equals("publishHandler")) {
                    c2 = 0;
                    break;
                }
                break;
            case 810169266:
                if (str.equals("invokeHandler")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.cBt.lhP.b((String) String.class.cast(linkedList2.get(0)), (String) String.class.cast(linkedList2.get(1)), XV((String) String.class.cast(linkedList2.get(2))));
                y = null;
                break;
            case 1:
                y = this.cBt.lhP.y((String) String.class.cast(linkedList2.get(0)), (String) String.class.cast(linkedList2.get(1)), ((Integer) Integer.class.cast(linkedList2.get(2))).intValue());
                break;
            default:
                Log.w("MicroMsg.RemoteDebugMsgMrg", "onCallInterface callMethod is null");
                AppMethodBeat.o(147051);
                return;
        }
        String valueOf = y != null ? String.valueOf(y) : "";
        if (!Util.isNullOrNil(valueOf)) {
            ad(evb.Ntd, valueOf);
        }
        r.a(str, linkedList, currentTimeMillis, evb.computeSize(), valueOf == null ? 0 : valueOf.length());
        AppMethodBeat.o(147051);
    }

    public final void ad(int i2, String str) {
        AppMethodBeat.i(147052);
        evc evc = new evc();
        evc.Ntd = i2;
        evc.dNk = str;
        a(v.a(evc, this.cBt, "callInterfaceResult"));
        AppMethodBeat.o(147052);
    }

    private synchronized void bAP() {
        AppMethodBeat.i(147053);
        int i2 = 0;
        while (i2 < this.cBt.lij.size()) {
            int bAG = i2 == 0 ? this.cBt.bAG() : this.cBt.lij.get(i2 - 1).jlm;
            int i3 = this.cBt.lij.get(i2).jlm;
            if (bAG - i3 != 1) {
                dT(bAG + 1, i3 - 1);
            }
            i2++;
        }
        AppMethodBeat.o(147053);
    }

    public final void dT(int i2, int i3) {
        AppMethodBeat.i(147054);
        Log.i("MicroMsg.RemoteDebugMsgMrg", "sync minSeq %d, maxSeq %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 > i3) {
            AppMethodBeat.o(147054);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.liI.get(Integer.valueOf(i2)) == null || currentTimeMillis - this.liI.get(Integer.valueOf(i2)).longValue() >= 3000) {
            this.liI.put(Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
            ewd ewd = new ewd();
            ewd.Nty = this.cBt.lhQ;
            ewd.NtL = i2;
            ewd.NtM = i3;
            this.liu.a(v.a(1005, ewd));
            this.cBt.lia = System.currentTimeMillis();
            AppMethodBeat.o(147054);
            return;
        }
        Log.i("MicroMsg.RemoteDebugMsgMrg", "sync too fast!");
        AppMethodBeat.o(147054);
    }

    /* access modifiers changed from: package-private */
    public final void v(LinkedList<evg> linkedList) {
        byte[] bArr;
        AppMethodBeat.i(147055);
        if (Util.isNullOrNil(linkedList)) {
            Log.w("MicroMsg.RemoteDebugMsgMrg", "handleMsg list is null");
            AppMethodBeat.o(147055);
            return;
        }
        Iterator<evg> it = w(linkedList).iterator();
        while (it.hasNext()) {
            evg next = it.next();
            if (v.wl(next.MVo)) {
                bArr = s.T(next.LrK.zy);
            } else {
                bArr = next.LrK.zy;
            }
            String str = next.category;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1680221061:
                    if (str.equals("callInterface")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -217209181:
                    if (str.equals("evaluateJavascriptResult")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3441010:
                    if (str.equals("ping")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 52537216:
                    if (str.equals("chromeDevtools")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 95766211:
                    if (str.equals("domOp")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1319027697:
                    if (str.equals("breakpoint")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a((evb) new evb().parseFrom(bArr));
                    break;
                case 1:
                    a((evl) new evl().parseFrom(bArr));
                    break;
                case 2:
                    a((evp) new evp().parseFrom(bArr));
                    break;
                case 3:
                    a((eva) new eva().parseFrom(bArr));
                    break;
                case 4:
                    a((evj) new evj().parseFrom(bArr));
                    break;
                case 5:
                    a((evd) new evd().parseFrom(bArr));
                    break;
            }
        }
        Log.i("MicroMsg.RemoteDebugMsgMrg", "handleMsg size %d, ack %d", Integer.valueOf(linkedList.size()), Integer.valueOf(this.cBt.bAG()));
        this.cBt.wk(linkedList.size());
        bAP();
        AppMethodBeat.o(147055);
    }

    private synchronized LinkedList<evg> w(LinkedList<evg> linkedList) {
        LinkedList<evg> linkedList2;
        AppMethodBeat.i(147056);
        if (linkedList == null) {
            linkedList2 = null;
            AppMethodBeat.o(147056);
        } else {
            LinkedList<evg> linkedList3 = new LinkedList<>();
            LinkedList linkedList4 = new LinkedList();
            this.cBt.lij.addAll(linkedList);
            Collections.sort(this.cBt.lij, new Comparator<evg>() {
                /* class com.tencent.mm.plugin.appbrand.debugger.q.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(evg evg, evg evg2) {
                    evg evg3 = evg;
                    evg evg4 = evg2;
                    if (evg3 == null || evg4 == null) {
                        return 0;
                    }
                    return evg3.jlm - evg4.jlm;
                }
            });
            int bAG = this.cBt.bAG();
            Iterator<evg> it = this.cBt.lij.iterator();
            int i2 = bAG;
            while (it.hasNext()) {
                evg next = it.next();
                if (next != null) {
                    if (next.jlm > i2) {
                        if (next.jlm - i2 != 1) {
                            break;
                        }
                        linkedList3.add(next);
                        i2 = next.jlm;
                    } else {
                        linkedList4.add(next);
                    }
                }
            }
            this.cBt.wi(i2);
            this.cBt.lij.removeAll(linkedList3);
            this.cBt.lij.removeAll(linkedList4);
            Log.d("MicroMsg.RemoteDebugMsgMrg", "getHandleMsgList size: %d", Integer.valueOf(linkedList3.size()));
            AppMethodBeat.o(147056);
            linkedList2 = linkedList3;
        }
        return linkedList2;
    }

    private void a(eva eva) {
        AppMethodBeat.i(147057);
        if (this.cBt.bAI() == eva.NsZ) {
            AppMethodBeat.o(147057);
            return;
        }
        if (eva.NsZ) {
            this.cBt.gX(true);
        } else {
            this.cBt.gX(false);
        }
        this.lix.bAZ();
        this.lix.bBe();
        AppMethodBeat.o(147057);
    }

    private void a(evj evj) {
        AppMethodBeat.i(147058);
        Log.d("MicroMsg.RemoteDebugMsgMrg", "onDomOp");
        int componentId = this.cBt.lhP.NP().brh().getCurrentPage().getCurrentPageView().getComponentId();
        if (evj.Ntn != componentId) {
            Log.w("MicroMsg.RemoteDebugMsgMrg", "onDomOp id not current webViewId %d/%d", Integer.valueOf(evj.Ntn), Integer.valueOf(componentId));
            AppMethodBeat.o(147058);
            return;
        }
        this.cBt.lhP.b("remoteDebugCommand", evj.Ntm, null);
        AppMethodBeat.o(147058);
    }

    private static void a(evd evd) {
        AppMethodBeat.i(147059);
        V8Inspector.onReceiveData(evd.Nte, evd.MiI);
        AppMethodBeat.o(147059);
    }

    private void a(evp evp) {
        AppMethodBeat.i(147060);
        evq evq = new evq();
        evq.Ntr = evp.Ntr;
        evq.KFy = r.bAX();
        Log.i("MicroMsg.RemoteDebugMsgMrg", "onPing netType %d", Integer.valueOf(evq.KFy));
        a(v.a(evq, this.cBt, "pong"));
        AppMethodBeat.o(147060);
    }

    private void a(evl evl) {
        AppMethodBeat.i(147061);
        Log.i("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback %d", Integer.valueOf(evl.Nto));
        int i2 = evl.Nto;
        String str = evl.dNk;
        c remove = this.cBt.lik.remove(Integer.valueOf(i2));
        if (remove == null) {
            AppMethodBeat.o(147061);
            return;
        }
        ValueCallback<String> valueCallback = remove.lhF;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(str);
        }
        Log.d("MicroMsg.RemoteDebugMsgMrg", "onEvaluateCallback, callback id: " + i2 + " ret: " + str);
        r.a(remove, evl.computeSize());
        AppMethodBeat.o(147061);
    }

    public final void a(p pVar) {
        AppMethodBeat.i(147062);
        if (!this.cBt.bAK()) {
            synchronized (this.cBt.mLock) {
                try {
                    if (System.currentTimeMillis() - this.cBt.lhX <= 16 || this.liJ) {
                        this.liL.add(pVar);
                        bAQ();
                        return;
                    }
                } finally {
                    AppMethodBeat.o(147062);
                }
            }
        }
        LinkedList<p> linkedList = new LinkedList<>();
        linkedList.add(pVar);
        a(linkedList, true);
        AppMethodBeat.o(147062);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r0 = (int) (16 - (java.lang.System.currentTimeMillis() - r9.cBt.lhX));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r0 <= 0) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        com.tencent.mm.plugin.appbrand.utils.f.bZn().j(new com.tencent.mm.plugin.appbrand.debugger.q.AnonymousClass3(r9), (long) r0);
        com.tencent.matrix.trace.core.AppMethodBeat.o(147063);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        r0 = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bAQ() {
        /*
            r9 = this;
            r8 = 147063(0x23e77, float:2.06079E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
            long r0 = java.lang.System.currentTimeMillis()
            com.tencent.mm.plugin.appbrand.debugger.m r2 = r9.cBt
            java.lang.Object r2 = r2.mLock
            monitor-enter(r2)
            boolean r3 = r9.liJ     // Catch:{ all -> 0x0055 }
            if (r3 == 0) goto L_0x0022
            long r4 = r9.liK     // Catch:{ all -> 0x0055 }
            long r4 = r0 - r4
            r6 = 32
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0022
            monitor-exit(r2)     // Catch:{ all -> 0x0055 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
        L_0x0021:
            return
        L_0x0022:
            r9.liK = r0
            java.util.LinkedList<com.tencent.mm.plugin.appbrand.debugger.p> r0 = r9.liL
            boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)
            if (r0 == 0) goto L_0x0031
            monitor-exit(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
            goto L_0x0021
        L_0x0031:
            r0 = 1
            r9.liJ = r0
            monitor-exit(r2)
            r0 = 16
            long r2 = java.lang.System.currentTimeMillis()
            com.tencent.mm.plugin.appbrand.debugger.m r4 = r9.cBt
            long r4 = r4.lhX
            long r2 = r2 - r4
            long r0 = r0 - r2
            int r0 = (int) r0
            if (r0 <= 0) goto L_0x005b
        L_0x0044:
            com.tencent.mm.plugin.appbrand.ac.m$a r1 = com.tencent.mm.plugin.appbrand.utils.f.bZn()
            com.tencent.mm.plugin.appbrand.debugger.q$3 r2 = new com.tencent.mm.plugin.appbrand.debugger.q$3
            r2.<init>()
            long r4 = (long) r0
            r1.j(r2, r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
            goto L_0x0021
        L_0x0055:
            r0 = move-exception
            monitor-exit(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
            throw r0
        L_0x005b:
            r0 = 16
            goto L_0x0044
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.debugger.q.bAQ():void");
    }

    private synchronized void a(LinkedList<p> linkedList, boolean z) {
        AppMethodBeat.i(147064);
        a(linkedList, z, false);
        AppMethodBeat.o(147064);
    }

    private synchronized void a(LinkedList<p> linkedList, boolean z, boolean z2) {
        AppMethodBeat.i(147065);
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(147065);
        } else {
            evt evt = new evt();
            evt.Nty = this.cBt.lhQ;
            evt.Ntz = this.cBt.bAG();
            Iterator<p> it = linkedList.iterator();
            while (it.hasNext()) {
                evt.Ntp.add(it.next().liB);
            }
            evf a2 = v.a(1006, evt);
            if (!this.cBt.isBusy() || z2) {
                Log.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg size %d", Integer.valueOf(linkedList.size()));
                this.liu.a(a2);
            } else {
                Log.d("MicroMsg.RemoteDebugMsgMrg", "sendMsg busy");
            }
            if (z) {
                x(linkedList);
            }
            m mVar = this.cBt;
            mVar.lhX = System.currentTimeMillis();
            mVar.lhZ = System.currentTimeMillis();
            if (!this.cBt.isBusy()) {
                this.liN = 0;
            }
            l lVar = new l();
            lVar.size = a2.computeSize();
            lVar.lhG = System.currentTimeMillis();
            this.cBt.lii.put(a2.uuid, lVar);
            AppMethodBeat.o(147065);
        }
    }

    private synchronized void x(LinkedList<p> linkedList) {
        AppMethodBeat.i(147066);
        Log.d("MicroMsg.RemoteDebugMsgMrg", "addToSendingMsg");
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(147066);
        } else {
            this.cBt.lih.addAll(linkedList);
            AppMethodBeat.o(147066);
        }
    }

    public final synchronized void bAR() {
        int i2;
        int i3 = 0;
        synchronized (this) {
            AppMethodBeat.i(147067);
            if (this.cBt.isBusy()) {
                AppMethodBeat.o(147067);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                LinkedList<p> linkedList = new LinkedList<>();
                Iterator<p> it = this.cBt.lih.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    p next = it.next();
                    if (currentTimeMillis - next.lhG > 5000) {
                        next.lhG = System.currentTimeMillis();
                        linkedList.add(next);
                        i2 = next.liC + i3;
                        if (((long) i2) >= 65536 || linkedList.size() > 800) {
                            Log.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", Integer.valueOf(linkedList.size()));
                            a(linkedList, false);
                            linkedList.clear();
                        }
                    } else {
                        i2 = i3;
                    }
                    i3 = i2;
                }
                if (!Util.isNullOrNil(linkedList)) {
                    Log.i("MicroMsg.RemoteDebugMsgMrg", "try2ReSendMsg size %d", Integer.valueOf(linkedList.size()));
                    a(linkedList, false);
                }
                AppMethodBeat.o(147067);
            }
        }
    }

    public final synchronized boolean bAS() {
        boolean z;
        AppMethodBeat.i(147068);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.liO < ((long) this.liN)) {
            AppMethodBeat.o(147068);
            z = false;
        } else {
            this.liO = currentTimeMillis;
            if (this.liN < 5000) {
                this.liN += 1000;
            } else {
                this.liN = 2000;
            }
            LinkedList<p> linkedList = new LinkedList<>();
            Iterator<p> it = this.cBt.lih.iterator();
            while (true) {
                if (it.hasNext()) {
                    p next = it.next();
                    if (currentTimeMillis - next.lhG > 5000) {
                        next.lhG = System.currentTimeMillis();
                        linkedList.add(next);
                        a(linkedList, false, true);
                        AppMethodBeat.o(147068);
                        z = true;
                        break;
                    }
                } else if (this.cBt.lih.size() > 0) {
                    p pVar = this.cBt.lih.get(0);
                    pVar.lhG = System.currentTimeMillis();
                    linkedList.add(pVar);
                    a(linkedList, false, true);
                    AppMethodBeat.o(147068);
                    z = true;
                } else {
                    AppMethodBeat.o(147068);
                    z = false;
                }
            }
        }
        return z;
    }

    public final void quit() {
        AppMethodBeat.i(147069);
        Log.i("MicroMsg.RemoteDebugMsgMrg", "quit");
        ewc ewc = new ewc();
        ewc.Nty = this.cBt.lhQ;
        this.liu.a(v.a(1004, ewc));
        AppMethodBeat.o(147069);
    }

    /* access modifiers changed from: package-private */
    public final void bAT() {
        AppMethodBeat.i(147070);
        this.cBt.setStatus(4);
        this.liu.XX("quit");
        AppMethodBeat.o(147070);
    }

    public final synchronized void dU(int i2, int i3) {
        AppMethodBeat.i(147071);
        Log.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg with min max");
        LinkedList linkedList = new LinkedList();
        Iterator<p> it = this.cBt.lih.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next.liB == null) {
                linkedList.add(next);
            } else if (next.liB.jlm >= i2 && next.liB.jlm <= i3) {
                linkedList.add(next);
            }
        }
        this.cBt.lih.removeAll(linkedList);
        AppMethodBeat.o(147071);
    }

    public final synchronized void bAU() {
        AppMethodBeat.i(147072);
        Log.d("MicroMsg.RemoteDebugMsgMrg", "removeSendingMsg");
        LinkedList linkedList = new LinkedList();
        Iterator<p> it = this.cBt.lih.iterator();
        while (it.hasNext()) {
            p next = it.next();
            if (next.liB == null) {
                linkedList.add(next);
            } else if (next.liB.jlm <= this.cBt.bAH()) {
                linkedList.add(next);
            }
        }
        this.cBt.lih.removeAll(linkedList);
        AppMethodBeat.o(147072);
    }

    public final void bAV() {
        AppMethodBeat.i(147073);
        Log.i("MicroMsg.RemoteDebugMsgMrg", "onClose");
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        AppMethodBeat.o(147073);
    }

    private static int[] XV(String str) {
        AppMethodBeat.i(147074);
        int[] iArr = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(str);
            iArr = new int[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                iArr[i2] = jSONArray.getInt(i2);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.RemoteDebugMsgMrg", e2.getMessage());
        }
        AppMethodBeat.o(147074);
        return iArr;
    }

    static /* synthetic */ void a(q qVar, long j2, String str) {
        AppMethodBeat.i(147075);
        eve eve = new eve();
        eve.Nte = j2;
        eve.MiI = str;
        qVar.a(v.a(eve, qVar.cBt, "chromeDevtoolsResult"));
        AppMethodBeat.o(147075);
    }
}
