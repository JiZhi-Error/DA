package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.o;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.protocal.protobuf.ctk;
import com.tencent.mm.protocal.u;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class f extends q implements m {
    i callback;
    f.a hvh;
    private final MTimerHandler iKj = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.modelmulti.f.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            boolean z;
            int i2;
            final a peek;
            boolean z2;
            AppMethodBeat.i(132550);
            if (!g.aAc() || com.tencent.mm.kernel.a.azj()) {
                Log.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
                AppMethodBeat.o(132550);
                return false;
            } else if (f.this.jcC) {
                Log.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", Integer.valueOf(f.this.hashCode()));
                AppMethodBeat.o(132550);
                return false;
            } else if (f.this.iWn.isEmpty()) {
                Log.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
                AppMethodBeat.o(132550);
                return false;
            } else {
                Log.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", Integer.valueOf(f.this.hashCode()), Long.valueOf(f.this.hvh.apr()), Integer.valueOf(f.this.iWn.size()), Integer.valueOf(f.this.jcy), Boolean.valueOf(f.this.jcz), Integer.valueOf(f.this.jcB), Integer.valueOf(f.this.jcA));
                g.aAi();
                long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
                c cVar = new c();
                cVar.dz("NetSceneInit");
                int i3 = f.this.jcz ? 40 : 10;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z = true;
                        break;
                    }
                    peek = f.this.iWn.peek();
                    if (peek.jcH != Integer.MAX_VALUE) {
                        LinkedList<abn> linkedList = peek.jcG.Mym;
                        if (linkedList == null || linkedList.size() <= peek.iWC) {
                            break;
                        }
                        linkedList.size();
                        if (!cVar.a(linkedList.get(peek.iWC), true)) {
                            break;
                        }
                        peek.iWC++;
                        f.this.jcB++;
                        i4++;
                    } else {
                        if (peek.jcG == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        Assert.assertTrue("in Queue tail , resp should be null", z2);
                        g.aAi();
                        String str = (String) g.aAh().azQ().get(8198, (Object) null);
                        g.aAi();
                        g.aAh().azQ().set(8195, str);
                        MMApplicationContext.getContext().getSharedPreferences("notify_sync_pref", com.tencent.mm.compatible.util.g.aps()).edit().putString("notify_sync_key_keybuf", str).commit();
                        g.aAi();
                        g.aAh().azQ().set(8197, "");
                        g.aAi();
                        g.aAh().azQ().set(8198, "");
                        g.aAi();
                        g.aAh().azQ().set(15, (Object) 1);
                        g.aAi();
                        g.aAh().azQ().gBI();
                        Log.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", Integer.valueOf(f.this.hashCode()), Long.valueOf(f.this.hvh.apr()), Integer.valueOf(f.this.jcy), Integer.valueOf(f.this.jcA), Integer.valueOf(peek.errType), Integer.valueOf(peek.errCode));
                        g.aAk().postToWorker(new Runnable() {
                            /* class com.tencent.mm.modelmulti.f.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(132549);
                                f.this.callback.onSceneEnd(peek.errType, peek.errCode, peek.errMsg, f.this);
                                AppMethodBeat.o(132549);
                            }
                        });
                        z = false;
                    }
                }
                f.this.iWn.poll();
                g.aAi();
                g.aAh().azQ().set(8197, Util.encodeHexString(z.a(peek.jcG.Myi)));
                g.aAi();
                g.aAh().azQ().set(8198, Util.encodeHexString(z.a(peek.jcG.Myj)));
                g.aAi();
                g.aAh().azQ().set(16, (Object) 0);
                Log.i("MicroMsg.NetSceneInit.dkInit", "ContinueFlag:%s, cur[%s], max[%s]", Long.valueOf((long) peek.jcG.KZh), Util.encodeHexString(z.a(peek.jcG.Myi)), Util.encodeHexString(z.a(peek.jcG.Myj)));
                g.aAi();
                g.aAh().azQ().set(8196, Long.valueOf((long) peek.jcG.KZh));
                g.aAi();
                g.aAh().azQ().gBI();
                z = true;
                cVar.dA("NetSceneInit");
                g.aAi();
                g.aAh().hqK.endTransaction(beginTransaction);
                f fVar = f.this;
                if (fVar.jcw == null) {
                    Log.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progressRef is null");
                } else {
                    j jVar = fVar.jcw.get();
                    if (jVar == null) {
                        Log.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
                    } else {
                        int i5 = fVar.jcy > 50 ? 50 : fVar.jcy;
                        float f2 = 1.0f;
                        if (!fVar.jcz) {
                            i2 = i5;
                        } else {
                            f2 = ((float) fVar.jcB) / ((float) fVar.jcA);
                            if (f2 > 1.0f) {
                                f2 = 1.0f;
                            }
                            i2 = (int) ((((float) (100 - i5)) * f2) + ((float) i5));
                        }
                        Log.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", Integer.valueOf(fVar.jcB), Integer.valueOf(fVar.jcA), Float.valueOf(f2), Integer.valueOf(i5));
                        jVar.a(i2, 100, fVar);
                    }
                }
                AppMethodBeat.o(132550);
                return z;
            }
        }
    }, true);
    final Queue<a> iWn = new LinkedList();
    int jcA = 0;
    int jcB = 0;
    boolean jcC = false;
    private StringBuilder jcf = new StringBuilder();
    WeakReference<j> jcw = null;
    final ctj jcx = new ctj();
    int jcy = 0;
    boolean jcz = false;
    private int retryCount = 3;

    public f(j jVar) {
        AppMethodBeat.i(132552);
        Log.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", Integer.valueOf(hashCode()), Util.getStack());
        this.jcf.append("stack:" + Util.getStack() + " time:" + Util.nowSecond());
        this.jcw = new WeakReference<>(jVar);
        AppMethodBeat.o(132552);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(132553);
        this.hvh = new f.a();
        this.callback = iVar;
        ctj ctj = this.jcx;
        g.aAi();
        ctj.UserName = (String) g.aAh().azQ().get(2, (Object) null);
        Assert.assertTrue("by DK: req.UserName is null", !Util.isNullOrNil(this.jcx.UserName));
        this.jcx.rBI = LocaleUtil.getApplicationLanguage();
        int a2 = a(gVar, null, null);
        AppMethodBeat.o(132553);
        return a2;
    }

    private int a(com.tencent.mm.network.g gVar, SKBuiltinBuffer_t sKBuiltinBuffer_t, SKBuiltinBuffer_t sKBuiltinBuffer_t2) {
        AppMethodBeat.i(132554);
        this.jcf.append(" lastd:" + this.lastdispatch + " dotime:" + Util.nowSecond() + " net:" + NetStatusUtil.getNetType(MMApplicationContext.getContext()));
        b bVar = new b();
        if (sKBuiltinBuffer_t == null) {
            g.aAi();
            sKBuiltinBuffer_t = z.aC(Util.decodeHexString(Util.nullAsNil((String) g.aAh().azQ().get(8197, (Object) null))));
        }
        if (sKBuiltinBuffer_t2 == null) {
            g.aAi();
            sKBuiltinBuffer_t2 = z.aC(Util.decodeHexString(Util.nullAsNil((String) g.aAh().azQ().get(8198, (Object) null))));
        }
        g.aAi();
        if (Util.nullAsNil((Integer) g.aAh().azQ().get(16, (Object) null)) == 0 || (sKBuiltinBuffer_t != null && sKBuiltinBuffer_t.getILen() > 0)) {
            g.aAi();
            if (Util.nullAsNil((String) g.aAh().azQ().get(8195, (Object) null)).length() <= 0) {
                bVar.getReqObj().setSceneStatus(3);
            } else {
                bVar.getReqObj().setSceneStatus(4);
            }
        } else {
            bVar.getReqObj().setSceneStatus(7);
        }
        this.jcx.Myi = sKBuiltinBuffer_t;
        this.jcx.Myj = sKBuiltinBuffer_t2;
        ((u.a) bVar.getReqObj()).KAe = this.jcx;
        Log.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", Integer.valueOf(hashCode()), Long.valueOf(this.hvh.apr()), Integer.valueOf(this.jcy), this.jcx.UserName, this.jcx.rBI, Integer.valueOf(bVar.getReqObj().getSceneStatus()), Util.encodeHexString(z.a(sKBuiltinBuffer_t)), Util.encodeHexString(z.a(sKBuiltinBuffer_t2)));
        this.jcy++;
        int dispatch = dispatch(gVar, bVar, this);
        AppMethodBeat.o(132554);
        return dispatch;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00d6, code lost:
        if (a(dispatcher(), null, null) == -1) goto L_0x00d8;
     */
    @Override // com.tencent.mm.network.m
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onGYNetEnd(int r9, int r10, int r11, java.lang.String r12, com.tencent.mm.network.s r13, byte[] r14) {
        /*
        // Method dump skipped, instructions count: 467
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelmulti.f.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void");
    }

    @Override // com.tencent.mm.ak.q
    public final boolean uniqueInNetsceneQueue() {
        return true;
    }

    @Override // com.tencent.mm.ak.q
    public final void cancel() {
        AppMethodBeat.i(132556);
        Log.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", Util.getStack());
        super.cancel();
        this.jcC = true;
        AppMethodBeat.o(132556);
    }

    /* access modifiers changed from: package-private */
    public class a {
        int errCode;
        String errMsg;
        int errType;
        int iWC = 0;
        ctk jcG;
        int jcH = 0;

        a() {
        }
    }

    private void a(int i2, int i3, int i4, String str, ctk ctk) {
        AppMethodBeat.i(132557);
        a aVar = new a();
        aVar.jcH = i2;
        aVar.errCode = i4;
        aVar.errType = i3;
        aVar.errMsg = str;
        aVar.jcG = ctk;
        this.iWn.add(aVar);
        if (this.iKj.stopped()) {
            this.iKj.startTimer(50);
        }
        AppMethodBeat.o(132557);
    }

    @Override // com.tencent.mm.ak.q
    public final String getInfo() {
        AppMethodBeat.i(132558);
        String sb = this.jcf.toString();
        AppMethodBeat.o(132558);
        return sb;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 500;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final boolean securityLimitCountReach() {
        AppMethodBeat.i(132559);
        boolean securityLimitCountReach = super.securityLimitCountReach();
        AppMethodBeat.o(132559);
        return securityLimitCountReach;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX;
    }

    public static class b extends o {
        private final u.a jcI = new u.a();
        private final u.b jcJ = new u.b();

        public b() {
            AppMethodBeat.i(132551);
            AppMethodBeat.o(132551);
        }

        @Override // com.tencent.mm.ak.o
        public final l.d getReqObjImp() {
            return this.jcI;
        }

        @Override // com.tencent.mm.network.s
        public final l.e getRespObj() {
            return this.jcJ;
        }

        @Override // com.tencent.mm.network.s
        public final int getType() {
            return com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX;
        }

        @Override // com.tencent.mm.network.s
        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newinit";
        }
    }
}
