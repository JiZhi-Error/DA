package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.r;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class p extends r implements m {
    static String sQc = null;
    protected i callback = null;

    /* access modifiers changed from: package-private */
    public abstract void ary(String str);

    /* access modifiers changed from: package-private */
    public abstract void c(int i2, int i3, String str, s sVar);

    /* access modifiers changed from: package-private */
    public abstract int f(g gVar);

    /* access modifiers changed from: protected */
    public abstract ctc f(s sVar);

    protected static String bbG() {
        return sQc;
    }

    public static void arz(String str) {
        sQc = str;
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        this.callback = iVar;
        if (Util.isNullOrNil(sQc)) {
            return getType();
        }
        Log.i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", sQc);
        ary(sQc);
        return f(gVar);
    }

    @Override // com.tencent.mm.ak.r
    public final qy b(s sVar) {
        ctc f2 = f(sVar);
        if (f2 != null) {
            return f2.KQk;
        }
        return null;
    }

    @Override // com.tencent.mm.ak.r
    public final ctb c(s sVar) {
        ctc f2 = f(sVar);
        if (f2 != null) {
            return f2.KQl;
        }
        return null;
    }

    @Override // com.tencent.mm.ak.r
    public final ccb d(s sVar) {
        ctc f2 = f(sVar);
        if (f2 != null) {
            return f2.KQj;
        }
        return null;
    }

    @Override // com.tencent.mm.ak.r
    public final void aYP() {
        if (this.callback != null) {
            this.callback.onSceneEnd(3, -1, "", this);
        }
    }

    @Override // com.tencent.mm.ak.r
    public final i aYQ() {
        return this.callback;
    }

    @Override // com.tencent.mm.ak.r
    public final void a(int i2, int i3, String str, s sVar) {
        Log.i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 4 && i3 == -102) {
            final int i4 = sVar.getReqObj().getRsaInfo().ver;
            Log.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.facedetect.b.p.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(103619);
                    new com.tencent.mm.modelsimple.m().doScene(p.this.dispatcher(), new i() {
                        /* class com.tencent.mm.plugin.facedetect.b.p.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(103618);
                            Log.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
                            if (i2 == 0 && i3 == 0) {
                                p.this.f(p.this.dispatcher());
                                AppMethodBeat.o(103618);
                                return;
                            }
                            Log.e("MicroMsg.NetSceneFaceRsaBase", "hy: do scene err in rsa when get cert. clear ticket");
                            String unused = p.sQc = null;
                            p.this.ary(p.bbG());
                            p.this.callback.onSceneEnd(i2, i3, "", p.this);
                            AppMethodBeat.o(103618);
                        }
                    });
                    AppMethodBeat.o(103619);
                }
            });
            return;
        }
        c(i2, i3, str, sVar);
    }
}
