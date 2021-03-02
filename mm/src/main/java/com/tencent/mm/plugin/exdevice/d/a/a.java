package com.tencent.mm.plugin.exdevice.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.protocal.protobuf.adj;
import com.tencent.mm.protocal.protobuf.adk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public final class a extends com.tencent.mm.plugin.exdevice.b.a<adj, adk> {
    String appId;
    String dGL;
    String dGP;
    String rxP;
    private WeakReference<b<a>> rxQ;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* bridge */ /* synthetic */ void i(adj adj) {
        adj adj2 = adj;
        adj2.Lox = this.dGL;
        adj2.KLO = this.dGP;
        adj2.Loy = this.rxP;
        adj2.jfi = this.appId;
    }

    public a(String str, String str2, String str3, String str4, b<a> bVar) {
        AppMethodBeat.i(23175);
        this.dGL = Util.nullAsNil(str);
        this.dGP = Util.nullAsNil(str2);
        this.rxP = Util.nullAsNil(str3);
        this.appId = Util.nullAsNil(str4);
        this.rxQ = new WeakReference<>(bVar);
        AppMethodBeat.o(23175);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1799;
    }

    @Override // com.tencent.mm.plugin.exdevice.b.a, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23176);
        Log.d("MicroMsg.NetSceneConnectedRouter", "ap: connected router end. errType: %d, errCode: %d, errMsg: %s, resp: %s", Integer.valueOf(i3), Integer.valueOf(i4), str, sVar.toString());
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        b<a> bVar = this.rxQ.get();
        if (bVar != null) {
            bVar.a(i3, i4, str, this);
        }
        AppMethodBeat.o(23176);
    }

    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/mydevice/connectedrouter";
    }

    /* Return type fixed from 'com.tencent.mm.bw.a' to match base method */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* synthetic */ adk cKd() {
        AppMethodBeat.i(23177);
        adk adk = new adk();
        AppMethodBeat.o(23177);
        return adk;
    }

    /* Return type fixed from 'com.tencent.mm.bw.a' to match base method */
    @Override // com.tencent.mm.plugin.exdevice.b.a
    public final /* synthetic */ adj cKc() {
        AppMethodBeat.i(23178);
        adj adj = new adj();
        AppMethodBeat.o(23178);
        return adj;
    }
}
