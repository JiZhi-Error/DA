package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a<RequestType extends com.tencent.mm.bw.a, ResponseType extends com.tencent.mm.bw.a> extends q implements m {
    private i heq;
    protected d rxs;

    /* access modifiers changed from: protected */
    public abstract RequestType cKc();

    /* access modifiers changed from: protected */
    public abstract ResponseType cKd();

    /* access modifiers changed from: protected */
    public abstract String getUri();

    /* access modifiers changed from: protected */
    public void i(RequestType requesttype) {
    }

    public final ResponseType cgq() {
        if (this.rxs == null || this.rxs.iLL.iLR == null) {
            return null;
        }
        return (ResponseType) this.rxs.iLL.iLR;
    }

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        Log.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.heq != null) {
            this.heq.onSceneEnd(i3, i4, str, this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.tencent.mm.plugin.exdevice.b.a<RequestType extends com.tencent.mm.bw.a, ResponseType extends com.tencent.mm.bw.a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        this.heq = iVar;
        if (this.rxs == null) {
            d.a aVar = new d.a();
            aVar.funcId = getType();
            aVar.uri = getUri();
            aVar.iLN = cKc();
            aVar.iLO = cKd();
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            this.rxs = aVar.aXF();
            i(this.rxs.iLK.iLR);
        }
        return dispatch(gVar, this.rxs, this);
    }
}
