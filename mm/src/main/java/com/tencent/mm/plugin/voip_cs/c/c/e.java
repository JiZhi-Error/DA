package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends q implements m {
    private i callback;
    public d rr;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x053e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e(long r12, long r14) {
        /*
        // Method dump skipped, instructions count: 1353
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip_cs.c.c.e.<init>(long, long):void");
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(125435);
        Log.i("MicroMsg.NetSceneVoipCSReport", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(125435);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 312;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(125436);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(125436);
        return dispatch;
    }
}
