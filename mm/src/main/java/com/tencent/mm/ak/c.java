package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public class c<_Resp extends dpc> implements com.tencent.mm.vending.e.a {
    public boolean iLA = false;
    b<_Resp> iLx = new b<>(this);
    private f<a<_Resp>> iLy;
    AtomicBoolean iLz = new AtomicBoolean(false);
    protected d rr;

    public static class a<T extends dpc> {
        public q dGJ;
        public int errCode;
        public String errMsg;
        public int errType;
        public T iLC;
        public c iLD;

        public static <T extends dpc> a<T> a(int i2, int i3, String str, T t, q qVar, c cVar) {
            AppMethodBeat.i(182910);
            a<T> aVar = new a<>();
            aVar.errType = i2;
            aVar.errCode = i3;
            aVar.errMsg = str;
            aVar.iLC = t;
            aVar.dGJ = qVar;
            aVar.iLD = cVar;
            if (cVar != null) {
                cVar.a(i2, i3, str, t, qVar);
            }
            AppMethodBeat.o(182910);
            return aVar;
        }
    }

    public void cancel() {
        AppMethodBeat.i(182915);
        if (this.iLz.compareAndSet(false, true)) {
            Object[] objArr = new Object[1];
            objArr[0] = (this.iLx == null || this.iLx.iLF == null) ? "" : Integer.valueOf(this.iLx.iLF.getType());
            Log.i("MicroMsg.Cgi", "[cancel] cgi=%s", objArr);
            if (this.iLx != null) {
                this.iLx.a(null);
                aa.a(this.iLx);
            }
            f<a<_Resp>> fVar = this.iLy;
            if (fVar != null) {
                fVar.Dv(true);
            }
        }
        AppMethodBeat.o(182915);
    }

    public c() {
        AppMethodBeat.i(182916);
        AppMethodBeat.o(182916);
    }

    public final d aYG() {
        return this.rr;
    }

    public final void c(d dVar) {
        this.rr = dVar;
        this.iLx.iLF = dVar;
    }

    public final c<_Resp> aYH() {
        this.iLA = true;
        return this;
    }

    public synchronized f<a<_Resp>> aYI() {
        f<a<_Resp>> fVar;
        AppMethodBeat.i(182917);
        Assert.assertNotNull("You should set a CommReqResp!", this.rr);
        Assert.assertTrue("RunCgi NetSceneQueue not ready!", aa.aZx());
        fVar = null;
        if (this.iLy == null) {
            fVar = new f<a<_Resp>>() {
                /* class com.tencent.mm.ak.c.AnonymousClass2 */

                @Override // com.tencent.mm.co.f, com.tencent.mm.vending.g.c, com.tencent.mm.vending.g.e
                public final /* synthetic */ com.tencent.mm.vending.g.c b(com.tencent.mm.vending.e.b bVar) {
                    AppMethodBeat.i(182908);
                    f a2 = a(bVar);
                    AppMethodBeat.o(182908);
                    return a2;
                }

                @Override // com.tencent.mm.co.f
                public final f a(com.tencent.mm.vending.e.b bVar) {
                    AppMethodBeat.i(182907);
                    bVar.keep(c.this);
                    f a2 = super.a(bVar);
                    AppMethodBeat.o(182907);
                    return a2;
                }
            }.b(new c.a<a<_Resp>>() {
                /* class com.tencent.mm.ak.c.AnonymousClass1 */

                @Override // com.tencent.mm.vending.g.c.a
                public final /* synthetic */ Object call() {
                    AppMethodBeat.i(182909);
                    if (c.this.iLz.get()) {
                        b<_Resp> bVar = c.this.iLx;
                        Object[] objArr = new Object[1];
                        objArr[0] = (bVar == null || bVar.iLF == null) ? "" : Integer.valueOf(bVar.iLF.getType());
                        Log.w("MicroMsg.Cgi", "[call] has cancel. cgi=%s", objArr);
                    } else {
                        com.tencent.mm.vending.g.b hdH = g.hdH();
                        c.this.iLx.a(hdH);
                        if (!aa.iNn.azA().a(c.this.iLx, 0)) {
                            Log.e("MicroMsg.Cgi", "RunCgi doScene failed!");
                            g.b(hdH);
                        }
                    }
                    AppMethodBeat.o(182909);
                    return null;
                }
            });
            this.iLy = fVar;
        }
        AppMethodBeat.o(182917);
        return fVar;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, String str, _Resp _resp, q qVar) {
    }

    /* access modifiers changed from: package-private */
    public static class b<_Resp extends dpc> extends q {
        i heq = null;
        final q iLE = this;
        d iLF;
        WeakReference<com.tencent.mm.vending.g.b> iLG;
        c iLH;
        private m iLI = new m() {
            /* class com.tencent.mm.ak.c.b.AnonymousClass1 */

            @Override // com.tencent.mm.network.m
            public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
                AppMethodBeat.i(182911);
                if (b.this.iLH.iLz.get()) {
                    Object[] objArr = new Object[1];
                    objArr[0] = (b.this.iLH.iLx == null || b.this.iLH.iLx.iLF == null) ? "" : Integer.valueOf(b.this.iLH.iLx.iLF.getType());
                    Log.w("MicroMsg.Cgi", "[onGYNetEnd] has cancel. cgi=%s", objArr);
                    b.this.heq.onSceneEnd(i3, i4, str, b.this.iLE);
                    AppMethodBeat.o(182911);
                    return;
                }
                g.a(b.this.iLG.get(), a.a(i3, i4, str, (dpc) b.this.iLF.iLL.iLR, b.this, b.this.iLH));
                b.this.heq.onSceneEnd(i3, i4, str, b.this.iLE);
                Log.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(b.this.iLE.hashCode()), Integer.valueOf(b.this.getType()), Long.valueOf(Util.nowMilliSecond() - b.this.mStartTime), Integer.valueOf(i3), Integer.valueOf(i4), str);
                AppMethodBeat.o(182911);
            }
        };
        final long mStartTime = Util.nowMilliSecond();

        public b(c cVar) {
            AppMethodBeat.i(182912);
            this.iLH = cVar;
            AppMethodBeat.o(182912);
        }

        public final void a(com.tencent.mm.vending.g.b bVar) {
            AppMethodBeat.i(197058);
            this.iLG = new WeakReference<>(bVar);
            AppMethodBeat.o(197058);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ak.q
        public final int securityLimitCount() {
            return 1;
        }

        @Override // com.tencent.mm.ak.q
        public final int getType() {
            AppMethodBeat.i(182913);
            int type = this.iLF.getType();
            AppMethodBeat.o(182913);
            return type;
        }

        @Override // com.tencent.mm.ak.q
        public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
            AppMethodBeat.i(182914);
            this.heq = iVar;
            int dispatch = dispatch(gVar, this.iLF, this.iLI);
            Log.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", Integer.valueOf(this.iLE.hashCode()), Integer.valueOf(getType()), Integer.valueOf(dispatch), Long.valueOf(Util.nowMilliSecond() - this.mStartTime));
            if (dispatch < 0) {
                g.a(this.iLG.get(), a.a(3, -1, "", (dpc) this.iLF.iLL.iLR, this, this.iLH));
            }
            AppMethodBeat.o(182914);
            return dispatch;
        }
    }

    @Override // com.tencent.mm.vending.e.a
    public void dead() {
        AppMethodBeat.i(197059);
        b<_Resp> bVar = this.iLx;
        Object[] objArr = new Object[1];
        objArr[0] = (bVar == null || bVar.iLF == null) ? "" : Integer.valueOf(bVar.iLF.getType());
        Log.i("MicroMsg.Cgi", "[afterDead] cgi=%s", objArr);
        if (!this.iLA) {
            Object[] objArr2 = new Object[1];
            objArr2[0] = (bVar == null || bVar.iLF == null) ? "" : Integer.valueOf(bVar.iLF.getType());
            Log.i("MicroMsg.Cgi", "[cancelAfterDead] do cancel of cgi=%s", objArr2);
            cancel();
        }
        this.iLy = null;
        AppMethodBeat.o(197059);
    }
}
