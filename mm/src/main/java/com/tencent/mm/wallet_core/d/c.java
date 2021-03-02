package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.d.d;

public abstract class c<T extends d> implements i {
    public i Rux;
    T Ruy;
    public int rtType;

    /* access modifiers changed from: protected */
    public abstract void a(d dVar);

    public abstract boolean a(int i2, int i3, T t);

    public final void fib() {
        Log.i("MicroMsg.IDelayQueryOrder", "onDestory rtType %s", Integer.valueOf(this.rtType));
        g.aAi();
        g.aAg().hqi.b(this.rtType, this);
    }

    public final void b(d dVar) {
        Log.i("MicroMsg.IDelayQueryOrder", "doScene rtType %s", Integer.valueOf(this.rtType));
        g.aAi();
        g.aAg().hqi.a(this.rtType, this);
        a(dVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.tencent.mm.wallet_core.d.c<T extends com.tencent.mm.wallet_core.d.d> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        Log.d("MicroMsg.IDelayQueryOrder", "errType: %d, errCode: %d, errMsg: %s scene %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar);
        if ((qVar instanceof d) && !a(i2, i3, (d) qVar) && this.Rux != null && this.Ruy != null && (this.Ruy instanceof q)) {
            this.Rux.onSceneEnd(i2, i3, str, (q) this.Ruy);
        }
    }
}
