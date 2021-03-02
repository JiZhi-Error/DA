package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.b.a;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.afm;
import com.tencent.mm.protocal.protobuf.afn;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public final class h extends a<afm, afn> {
    private final WeakReference<b<h>> rxQ;
    String username;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* bridge */ /* synthetic */ void i(afm afm) {
        afm.Lqo = this.username;
    }

    public h(String str, b<h> bVar) {
        AppMethodBeat.i(23518);
        this.username = str;
        this.rxQ = new WeakReference<>(bVar);
        AppMethodBeat.o(23518);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1792;
    }

    @Override // com.tencent.mm.plugin.exdevice.b.a, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23519);
        Log.d("MicroMsg.NetSceneDelFollow", "hy: del follow end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        if (i3 == 0 && i4 == 0) {
            ad.cKN().anE(this.username);
        }
        b<h> bVar = this.rxQ.get();
        if (bVar != null) {
            bVar.a(i3, i4, str, this);
        }
        AppMethodBeat.o(23519);
    }

    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/delfollow";
    }

    /* Return type fixed from 'com.tencent.mm.bw.a' to match base method */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* synthetic */ afn cKd() {
        AppMethodBeat.i(23520);
        afn afn = new afn();
        AppMethodBeat.o(23520);
        return afn;
    }

    /* Return type fixed from 'com.tencent.mm.bw.a' to match base method */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* synthetic */ afm cKc() {
        AppMethodBeat.i(23521);
        afm afm = new afm();
        AppMethodBeat.o(23521);
        return afm;
    }
}
