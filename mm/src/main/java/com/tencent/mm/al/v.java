package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.qh;
import com.tencent.mm.protocal.protobuf.qi;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class v extends q implements m {
    private i callback;
    private a iOR;
    private d rr;

    public static abstract class a<T extends com.tencent.mm.bw.a> implements i {
        private final T iOS;

        /* access modifiers changed from: protected */
        public abstract void e(T t);

        protected a(T t) {
            this.iOS = t;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            if (qVar != null && (qVar instanceof v)) {
                try {
                    this.iOS.parseFrom(((qi) ((d) qVar.getReqResp()).iLL.iLR).KXk.zy);
                } catch (Throwable th) {
                }
                e(this.iOS);
            }
        }
    }

    public v(String str, com.tencent.mm.bw.a aVar, a aVar2) {
        AppMethodBeat.i(212179);
        Log.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer username (%s) cmdid (%s)", str, 2);
        this.iOR = aVar2;
        d.a aVar3 = new d.a();
        aVar3.funcId = 1915;
        aVar3.uri = "/cgi-bin/mmocbiz-bin-new/biztransfer";
        aVar3.iLN = new qh();
        aVar3.iLO = new qi();
        aVar3.iLP = 0;
        aVar3.respCmdId = 0;
        this.rr = aVar3.aXF();
        qh qhVar = (qh) this.rr.iLK.iLR;
        qhVar.KXi = str;
        qhVar.KXj = 2;
        try {
            qhVar.KXk = b.cD(aVar.toByteArray());
            AppMethodBeat.o(212179);
        } catch (IOException e2) {
            RuntimeException runtimeException = new RuntimeException("bad cgi request", e2);
            AppMethodBeat.o(212179);
            throw runtimeException;
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(212180);
        Log.i("MicroMsg.NetSceneBiztransfer", "NetSceneBiztransfer onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.iOR != null) {
            this.iOR.onSceneEnd(i3, i4, str, this);
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(212180);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1915;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(212181);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(212181);
        return dispatch;
    }
}
