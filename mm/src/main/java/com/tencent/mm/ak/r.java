package com.tencent.mm.ak;

import com.tencent.mm.model.bh;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class r extends q implements m {
    protected int iMt = 3;
    private boolean iMu = false;

    public abstract void a(int i2, int i3, String str, s sVar);

    public abstract void aYP();

    public abstract i aYQ();

    public abstract qy b(s sVar);

    public abstract ctb c(s sVar);

    public abstract ccb d(s sVar);

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        if (i3 == 4 && i4 == -301) {
            Log.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", Integer.valueOf(this.iMt));
            if (sVar != null) {
                Log.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
                bh.a(true, b(sVar), c(sVar), d(sVar));
            }
            this.iMt--;
            if (this.iMt <= 0) {
                aYP();
                this.iMu = false;
                return;
            }
            Log.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
            doScene(dispatcher(), aYQ());
            return;
        }
        a(i3, i4, str, sVar);
    }
}
