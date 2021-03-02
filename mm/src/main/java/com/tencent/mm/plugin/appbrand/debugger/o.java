package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.util.Pair;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.n;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.debugger.w;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.networking.c;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.plugin.appbrand.s.k;
import com.tencent.mm.protocal.protobuf.bum;
import com.tencent.mm.protocal.protobuf.bun;
import com.tencent.mm.protocal.protobuf.evf;
import com.tencent.mm.protocal.protobuf.evh;
import com.tencent.mm.protocal.protobuf.evk;
import com.tencent.mm.protocal.protobuf.evm;
import com.tencent.mm.protocal.protobuf.evo;
import com.tencent.mm.protocal.protobuf.evr;
import com.tencent.mm.protocal.protobuf.evu;
import com.tencent.mm.protocal.protobuf.evv;
import com.tencent.mm.protocal.protobuf.evw;
import com.tencent.mm.protocal.protobuf.evx;
import com.tencent.mm.protocal.protobuf.evy;
import com.tencent.mm.protocal.protobuf.evz;
import com.tencent.mm.protocal.protobuf.ewa;
import com.tencent.mm.protocal.protobuf.ewb;
import com.tencent.mm.protocal.protobuf.ewe;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public final class o implements i {
    private m cBt;
    public String lit;
    private u liu;
    private q liv = new q();
    private d liw;
    public w lix;
    k.b liy = new k.b() {
        /* class com.tencent.mm.plugin.appbrand.debugger.o.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.appbrand.s.k.b
        public final void bAN() {
            AppMethodBeat.i(147016);
            Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketOpen");
            o.this.cBt.lhZ = System.currentTimeMillis();
            o.this.cBt.lil = 0;
            if (!Util.isNullOrNil(o.this.cBt.bAF())) {
                o.a(o.this);
            }
            q qVar = o.this.liv;
            qVar.bAV();
            qVar.mTimer = new Timer();
            qVar.mTimer.schedule(new TimerTask() {
                /* class com.tencent.mm.plugin.appbrand.debugger.q.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(147048);
                    if (!q.this.cBt.isBusy() || !q.this.bAS()) {
                        q.this.bAR();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - q.this.cBt.lhZ >= 10000) {
                            q qVar = q.this;
                            evw evw = new evw();
                            evw.Nty = qVar.cBt.lhQ;
                            evw.Ntz = qVar.cBt.bAG();
                            qVar.liu.a(v.a(1001, evw));
                        }
                        if (q.this.cBt.isReady() && currentTimeMillis - q.this.cBt.lia >= 30000) {
                            q.this.dT(q.this.cBt.bAG(), Integer.MAX_VALUE);
                        }
                    } else {
                        Log.i("MicroMsg.RemoteDebugMsgMrg", "testServer");
                    }
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.debugger.w.AnonymousClass7 */

                        public final void run() {
                            AppMethodBeat.i(147110);
                            w.h(w.this);
                            w.j(w.this);
                            AppMethodBeat.o(147110);
                        }
                    });
                    AppMethodBeat.o(147048);
                }
            }, 100, 1000);
            AppMethodBeat.o(147016);
        }

        @Override // com.tencent.mm.plugin.appbrand.s.k.b
        public final void XT(String str) {
            AppMethodBeat.i(147017);
            Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketError message:%s ", str);
            o.this.lix.Ya(str);
            AppMethodBeat.o(147017);
        }

        @Override // com.tencent.mm.plugin.appbrand.s.k.b
        public final void bAO() {
            AppMethodBeat.i(147018);
            o.this.cBt.lhZ = System.currentTimeMillis();
            AppMethodBeat.o(147018);
        }

        @Override // com.tencent.mm.plugin.appbrand.s.k.b
        public final void k(ByteBuffer byteBuffer) {
            AppMethodBeat.i(147019);
            o.this.cBt.lhZ = System.currentTimeMillis();
            try {
                evf evf = (evf) new evf().parseFrom(com.tencent.mm.plugin.appbrand.ac.d.p(byteBuffer));
                if (evf.LrK == null) {
                    Log.w("MicroMsg.RemoteDebugJsEngine", "dataFormat.data is null");
                    AppMethodBeat.o(147019);
                    return;
                }
                byte[] bArr = evf.LrK.zy;
                switch (evf.EX) {
                    case 1001:
                        v.a(o.this.cBt, evf, ((evx) new evx().parseFrom(bArr)).NtA, o.this.lix, o.this.liv);
                        o.this.cBt.lhZ = System.currentTimeMillis();
                        break;
                    case 1002:
                        o.a(o.this, (ewb) new ewb().parseFrom(bArr), evf);
                        break;
                    case 1003:
                        if (v.a(o.this.cBt, evf, ((evz) new evz().parseFrom(bArr)).NtA, o.this.lix, o.this.liv)) {
                            o.b(o.this);
                            break;
                        }
                        break;
                    case 1004:
                        if (!o.this.liw.isRunning()) {
                            q qVar = o.this.liv;
                            Log.i("MicroMsg.RemoteDebugMsgMrg", "onQuitSilent");
                            qVar.bAT();
                            w wVar = qVar.lix;
                            wVar.setVisibility(8);
                            if (wVar.getParent() instanceof ViewGroup) {
                                ((ViewGroup) wVar.getParent()).removeView(wVar);
                                wVar.removeAllViews();
                            }
                            wVar.lja = null;
                            break;
                        } else {
                            q qVar2 = o.this.liv;
                            Log.i("MicroMsg.RemoteDebugMsgMrg", "onQuit");
                            qVar2.bAT();
                            w wVar2 = qVar2.lix;
                            wVar2.bBf();
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.debugger.w.AnonymousClass6 */

                                public final void run() {
                                    AppMethodBeat.i(147109);
                                    w.i(w.this);
                                    AppMethodBeat.o(147109);
                                }
                            });
                            break;
                        }
                    case 1005:
                        ewe ewe = (ewe) new ewe().parseFrom(bArr);
                        q qVar3 = o.this.liv;
                        Log.d("MicroMsg.RemoteDebugMsgMrg", "onSync");
                        if (v.a(qVar3.cBt, evf, ewe.NtA, qVar3.lix, qVar3)) {
                            qVar3.v(ewe.Ntp);
                            qVar3.cBt.wj(ewe.NtN);
                            qVar3.bAU();
                            break;
                        }
                        break;
                    case 1006:
                        evu evu = (evu) new evu().parseFrom(bArr);
                        q qVar4 = o.this.liv;
                        if (v.a(qVar4.cBt, evf, evu.NtA, qVar4.lix, qVar4)) {
                            Log.d("MicroMsg.RemoteDebugMsgMrg", "onSendMsgResult %d/%d", Integer.valueOf(evu.NtB), Integer.valueOf(evu.NtC));
                            qVar4.cBt.dS(evu.NtB, evu.NtC);
                            qVar4.dU(evu.NtB, evu.NtC);
                        }
                        r.a(evf, o.this.cBt.lii.get(evf.uuid));
                        break;
                    case 2006:
                        o.this.liv.v(((evm) new evm().parseFrom(bArr)).Ntp);
                        break;
                    case 3001:
                        o.g(o.this);
                        break;
                    case 3002:
                        o.this.cBt.setStatus(4);
                        o.this.liv.quit();
                        break;
                }
                Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketMessage cmd: %d", Integer.valueOf(evf.EX));
                AppMethodBeat.o(147019);
            } catch (Throwable th) {
                Log.e("MicroMsg.RemoteDebugJsEngine", "onSocketMessage %s", android.util.Log.getStackTraceString(th));
                AppMethodBeat.o(147019);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.s.k.b
        public final void ae(int i2, String str) {
            boolean z = true;
            AppMethodBeat.i(147020);
            Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketClose code:%d reason:%s ", Integer.valueOf(i2), str);
            m mVar = o.this.cBt;
            if (mVar.isQuit() || ((long) mVar.lil) >= 10) {
                z = false;
            }
            if (z) {
                m.bZn().j(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.debugger.o.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(147015);
                        o.h(o.this);
                        AppMethodBeat.o(147015);
                    }
                }, 1000);
                o.this.cBt.lil++;
            }
            o.this.liv.bAV();
            o.this.cBt.lhZ = System.currentTimeMillis();
            o.this.lix.bBf();
            o.this.cBt.setStatus(5);
            o.this.lix.Ya(str);
            AppMethodBeat.o(147020);
        }

        @Override // com.tencent.mm.plugin.appbrand.s.k.b
        public final void XU(String str) {
            AppMethodBeat.i(147021);
            Log.i("MicroMsg.RemoteDebugJsEngine", "onSocketConnectFail reason:%s ", str);
            AppMethodBeat.o(147021);
        }
    };
    private Activity mContext;

    static /* synthetic */ void g(o oVar) {
        AppMethodBeat.i(258174);
        oVar.onReady();
        AppMethodBeat.o(258174);
    }

    static /* synthetic */ void h(o oVar) {
        AppMethodBeat.i(258175);
        oVar.connect();
        AppMethodBeat.o(258175);
    }

    public o() {
        AppMethodBeat.i(147025);
        EventCenter.instance.add(new IListener<n>() {
            /* class com.tencent.mm.plugin.appbrand.debugger.o.AnonymousClass4 */

            {
                AppMethodBeat.i(160993);
                this.__eventId = n.class.getName().hashCode();
                AppMethodBeat.o(160993);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(n nVar) {
                AppMethodBeat.i(147024);
                boolean a2 = a(nVar);
                AppMethodBeat.o(147024);
                return a2;
            }

            private boolean a(n nVar) {
                AppMethodBeat.i(147023);
                if (nVar == null || nVar.dCn == null || nVar.dCn.dCq == null) {
                    AppMethodBeat.o(147023);
                } else {
                    evo evo = new evo();
                    evo.dCo = nVar.dCn.dCo;
                    evo.dCp = nVar.dCn.dCp;
                    evo.Ntq = nVar.dCn.dCq.toString();
                    evo.timestamp = System.currentTimeMillis();
                    o.this.a(v.a(evo, o.this.cBt, "networkDebugAPI"));
                    AppMethodBeat.o(147023);
                }
                return true;
            }
        });
        AppMethodBeat.o(147025);
    }

    public final void a(m mVar) {
        AppMethodBeat.i(147026);
        this.cBt = mVar;
        this.liw = this.cBt.lhP;
        this.mContext = (Activity) this.liw.getContext();
        this.lix = new w(this.mContext, this.cBt, new w.a() {
            /* class com.tencent.mm.plugin.appbrand.debugger.o.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.debugger.w.a
            public final void bAM() {
                AppMethodBeat.i(147014);
                o.this.destroy();
                h.a(o.this.liw.getAppId(), h.d.CLOSE);
                if (o.this.liw.NP() != null) {
                    o.this.liw.NP().finish();
                }
                AppMethodBeat.o(147014);
            }
        });
        this.lix.T(this.liw.NP());
        connect();
        if (Util.isNullOrNil(this.cBt.bAF())) {
            bAL();
        }
        AppMethodBeat.o(147026);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void addJavascriptInterface(Object obj, String str) {
    }

    @Override // com.tencent.mm.plugin.appbrand.m.o
    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(147027);
        if (this.cBt == null) {
            if (valueCallback != null) {
                valueCallback.onReceiveValue("FATAL");
            }
            AppMethodBeat.o(147027);
        } else if (this.cBt.bAI()) {
            AppMethodBeat.o(147027);
        } else if (!this.cBt.isReady()) {
            this.cBt.lig.add(new Pair<>(str, valueCallback));
            this.lit = null;
            AppMethodBeat.o(147027);
        } else {
            evk evk = new evk();
            evk.Nto = this.cBt.lib.incrementAndGet();
            evk.script = str;
            this.liv.a(v.a(evk, this.cBt, "evaluateJavascript"));
            int i2 = evk.Nto;
            c cVar = new c();
            if (!Util.isNullOrNil(this.lit)) {
                cVar.event = this.lit;
                this.lit = null;
            } else {
                cVar.event = r.XW(str);
            }
            cVar.lhG = System.currentTimeMillis();
            cVar.size = str.length();
            cVar.lhF = valueCallback;
            this.cBt.lik.put(Integer.valueOf(i2), cVar);
            AppMethodBeat.o(147027);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(147028);
        evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(147028);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void a(URL url, String str, String str2, int i2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(147029);
        evaluateJavascript(str3, valueCallback);
        AppMethodBeat.o(147029);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void setJsExceptionHandler(com.tencent.mm.plugin.appbrand.m.h hVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void destroy() {
        AppMethodBeat.i(147030);
        this.liv.quit();
        this.liv.bAV();
        AppMethodBeat.o(147030);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final <T extends j> T R(Class<T> cls) {
        return null;
    }

    private void connect() {
        AppMethodBeat.i(147031);
        if (this.liu == null) {
            this.liu = new u((a) this.liw.av(a.class));
            this.liv.a(this.liu, this.cBt, this.lix);
        }
        if (this.cBt.bAK()) {
            this.liu.a("ws://localhost:" + this.cBt.lhV.lir, this.liy);
            AppMethodBeat.o(147031);
            return;
        }
        this.liu.a("wss://wxagame.weixin.qq.com/remote/", this.liy);
        AppMethodBeat.o(147031);
    }

    private void onReady() {
        AppMethodBeat.i(147032);
        Log.i("MicroMsg.RemoteDebugJsEngine", "onReady");
        this.cBt.setStatus(3);
        Log.i("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
        Iterator<Pair<String, ValueCallback<String>>> it = this.cBt.lig.iterator();
        while (it.hasNext()) {
            Pair<String, ValueCallback<String>> next = it.next();
            evaluateJavascript((String) next.first, (ValueCallback) next.second);
        }
        this.cBt.lig.clear();
        this.liv.dT(this.cBt.bAG(), Integer.MAX_VALUE);
        this.lix.bBf();
        AppMethodBeat.o(147032);
    }

    public final void ad(int i2, String str) {
        AppMethodBeat.i(147033);
        this.liv.ad(i2, str);
        AppMethodBeat.o(147033);
    }

    public final void a(p pVar) {
        AppMethodBeat.i(147034);
        this.liv.a(pVar);
        AppMethodBeat.o(147034);
    }

    private void bAL() {
        AppMethodBeat.i(147035);
        Log.i("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
        bum bum = new bum();
        this.liw.getAppId();
        ((c) this.liw.M(c.class)).a("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", bum, bun.class).c(new com.tencent.mm.vending.c.a<Object, bun>() {
            /* class com.tencent.mm.plugin.appbrand.debugger.o.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(bun bun) {
                AppMethodBeat.i(147022);
                bun bun2 = bun;
                if (bun2 == null) {
                    Log.e("MicroMsg.RemoteDebugJsEngine", "getsubbusinessinfo cgi failed, null response");
                } else if (bun2.BaseResponse.Ret != 0) {
                    Log.e("MicroMsg.RemoteDebugJsEngine", "getsubbusinessinfo cgi failed, errCode = %d, errMsg = %s, rr.resp = %b", Integer.valueOf(bun2.BaseResponse.Ret), bun2.BaseResponse.ErrMsg, Boolean.FALSE);
                } else {
                    o.this.cBt.XS(bun2.MaV);
                    Log.i("MicroMsg.RemoteDebugJsEngine", "loginTicket %s", bun2.MaV);
                    if (o.this.liu.isOpen()) {
                        o.a(o.this);
                    }
                }
                AppMethodBeat.o(147022);
                return null;
            }
        });
        AppMethodBeat.o(147035);
    }

    static /* synthetic */ void a(o oVar) {
        AppMethodBeat.i(147036);
        Log.i("MicroMsg.RemoteDebugJsEngine", "login");
        oVar.cBt.setStatus(1);
        ewa ewa = new ewa();
        ewa.Nty = oVar.cBt.lhQ;
        ewa.MaV = oVar.cBt.bAF();
        oVar.liu.a(v.a(1002, ewa));
        AppMethodBeat.o(147036);
    }

    static /* synthetic */ void a(o oVar, ewb ewb, evf evf) {
        AppMethodBeat.i(258173);
        if (v.a(oVar.cBt, evf, ewb.NtA, oVar.lix, oVar.liv)) {
            Log.i("MicroMsg.RemoteDebugJsEngine", "onLogin");
            if (ewb.NtK == null) {
                Log.e("MicroMsg.RemoteDebugJsEngine", "onLogin room info is null");
                AppMethodBeat.o(258173);
                return;
            } else if (ewb.NtK.Ntt) {
                oVar.cBt.lhU = ewb.NtK;
                oVar.onReady();
                AppMethodBeat.o(258173);
                return;
            } else {
                Log.i("MicroMsg.RemoteDebugJsEngine", "joinRoom");
                oVar.cBt.setStatus(2);
                evy evy = new evy();
                evy.Nty = oVar.cBt.lhQ;
                evy.KDQ = oVar.cBt.lhV.roomId;
                evy.username = "";
                evy.NtJ = oVar.cBt.lhV.lio;
                oVar.liu.a(v.a(1003, evy));
            }
        }
        AppMethodBeat.o(258173);
    }

    static /* synthetic */ void b(o oVar) {
        AppMethodBeat.i(147037);
        ICommLibReader bqZ = oVar.liw.bqZ();
        evv evv = new evv();
        evh evh = new evh();
        evv.NtE = evh;
        j jVar = (j) oVar.liw.S(j.class);
        if (jVar != null) {
            evv.NtF = jVar.Mh();
        }
        evv.NtH = oVar.liw.NP().OM().leE.md5;
        evv.NtI = 1;
        String UM = oVar.liw.bqZ().UM("WAService.js");
        if (!Util.isNullOrNil(UM)) {
            evv.NtG = g.getMessageDigest(UM.getBytes());
        }
        evh.Ntj = bqZ.bvd();
        evh.LnW = com.tencent.mm.protocal.d.KyJ;
        evh.Ntg = com.tencent.mm.protocal.d.DEVICE_NAME;
        evh.Nti = ChannelUtil.formatVersion(oVar.mContext, BuildInfo.CLIENT_VERSION_INT);
        evh.Nth = com.tencent.mm.protocal.d.KyM;
        evh.Ntk = oVar.mContext.getResources().getDisplayMetrics().density;
        evh.KGp = ((float) oVar.mContext.getResources().getDisplayMetrics().widthPixels) / evh.Ntk;
        if (!(oVar.liw.ax(com.tencent.luggage.sdk.b.a.c.class) == null || ((com.tencent.luggage.sdk.b.a.c) oVar.liw.ax(com.tencent.luggage.sdk.b.a.c.class)).nmX == null)) {
            evh.Ntl = ((com.tencent.luggage.sdk.b.a.c) oVar.liw.ax(com.tencent.luggage.sdk.b.a.c.class)).nmX.getUserAgentString();
        }
        evr evr = new evr();
        q.a(evr);
        evv.NtD = evr;
        oVar.liv.a(v.a(evv, oVar.cBt, "setupContext"));
        Log.d("MicroMsg.RemoteDebugJsEngine", "setupContext %s/%s/%d, %s", evv.NtG, evv.NtH, Integer.valueOf(evh.Ntj), evh.Ntl);
        AppMethodBeat.o(147037);
    }
}
