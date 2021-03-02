package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.protocal.protobuf.dzr;
import com.tencent.mm.protocal.protobuf.eou;
import com.tencent.mm.protocal.protobuf.fau;
import com.tencent.mm.protocal.protobuf.fav;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f extends a implements m {
    private fav IDA;
    private int IDE;
    private v IDt;
    private fau IDz;
    private i callback;
    private d iUB;
    private int scene;

    /* JADX WARNING: Removed duplicated region for block: B:101:0x042c  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0454  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0457  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0306 A[SYNTHETIC, Splitter:B:71:0x0306] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0352 A[SYNTHETIC, Splitter:B:75:0x0352] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0370  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x03b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(com.tencent.mm.plugin.websearch.api.v r14) {
        /*
        // Method dump skipped, instructions count: 1135
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.fts.f.<init>(com.tencent.mm.plugin.websearch.api.v):void");
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        if (this.IDt.scene == 201 || this.IDt.IDQ == 1) {
            return 2676;
        }
        if (this.IDt.IDX == 1) {
            return 1011;
        }
        if (this.IDt.IDY) {
            return 4858;
        }
        return 719;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(77931);
        ar.kc(this.scene, 2);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(77931);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(77932);
        Log.i("MicroMsg.WebSearch.NetSceneWebSearch", "onGYNetEnd netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        boolean z = i3 == 0 && i4 == 0;
        if (i3 == 0 && i4 == 0) {
            this.IDA = (fav) this.iUB.iLL.iLR;
            if (this.IDA != null) {
                ah.a(this.IDt.scene, this.IDt.sessionId, this.IDt.dVO, this.IDt.rjq, this.IDt.offset, this.IDt.IDE == 1, this.IDt.dPI, z, this.IDt.dDv, this.IDt.businessType);
                Log.v("MicroMsg.WebSearch.NetSceneWebSearch", "return data\n%s", this.IDA.MaZ);
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            ar.aK(this.scene, i3, i4);
            AppMethodBeat.o(77932);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        ah.a(this.IDt.scene, this.IDt.sessionId, this.IDt.dVO, this.IDt.rjq, this.IDt.offset, this.IDt.IDE == 1, this.IDt.dPI, z, this.IDt.dDv, this.IDt.businessType);
        ar.aK(this.scene, i3, i4);
        AppMethodBeat.o(77932);
    }

    @Override // com.tencent.mm.plugin.websearch.api.a
    public final String fXC() {
        return this.IDA != null ? this.IDA.MaZ : "";
    }

    @Override // com.tencent.mm.plugin.websearch.api.a
    public final int fXD() {
        if (this.IDA != null) {
            return this.IDA.NwM;
        }
        return 0;
    }

    @Override // com.tencent.mm.plugin.websearch.api.a
    public final void by(LinkedList<eou> linkedList) {
        AppMethodBeat.i(77933);
        this.IDz.MUs = linkedList;
        dzr dzr = new dzr();
        dzr.MZn = linkedList.size();
        this.IDz.Nxd = dzr;
        AppMethodBeat.o(77933);
    }
}
