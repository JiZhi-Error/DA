package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;

public class e extends q implements m {
    private i heq;
    private a<e> nhz;
    public final d rr;

    public interface a<T extends q> {
        void a(int i2, int i3, String str, T t);
    }

    public e(String str, String str2, String str3, int i2, int i3, int i4, int i5, boolean z, a<e> aVar) {
        this(str, str2, str3, i2, i3, i4, i5, z);
        this.nhz = aVar;
    }

    public e(String str, String str2, String str3, int i2, int i3, int i4, int i5, a<e> aVar) {
        this(str, str2, str3, i2, i3, i4, i5, false);
        this.nhz = aVar;
    }

    private e(String str, String str2, String str3, int i2, int i3, int i4, int i5, boolean z) {
        AppMethodBeat.i(227220);
        Log.i("MicroMsg.webview.NetSceneJSOperateWxData", "<init> hash[%d] appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]", Integer.valueOf(hashCode()), str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5));
        this.rr = id(z).aXF();
        ceu ceu = (ceu) this.rr.iLK.iLR;
        ceu.jfi = str;
        ceu.oTm = new b(str2.getBytes() == null ? new byte[0] : str2.getBytes());
        ceu.Mkp = str3;
        ceu.MjZ = i2;
        ceu.MjY = i4;
        ceu.Lqj = i3;
        if (i5 > 0) {
            ceu.Mka = new fdg();
            ceu.Mka.scene = i5;
        }
        AppMethodBeat.o(227220);
    }

    /* access modifiers changed from: protected */
    public d.a id(boolean z) {
        AppMethodBeat.i(227221);
        d.a id = f.id(z);
        AppMethodBeat.o(227221);
        return id;
    }

    public final void yB(int i2) {
        AppMethodBeat.i(47755);
        ceu ceu = (ceu) this.rr.iLK.iLR;
        if (ceu.Mka == null) {
            ceu.Mka = new fdg();
        }
        ceu.Mka.NyS = i2;
        AppMethodBeat.o(47755);
    }

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(47756);
        Log.i("MicroMsg.webview.NetSceneJSOperateWxData", "onGYNetEnd, hash[%d] errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(hashCode()), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.heq != null) {
            this.heq.onSceneEnd(i3, i4, str, this);
        }
        if (this.nhz != null) {
            this.nhz.a(i3, i4, str, this);
        }
        AppMethodBeat.o(47756);
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return 1133;
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        AppMethodBeat.i(47757);
        Log.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene hash=%d, funcid=%d", Integer.valueOf(hashCode()), Integer.valueOf(this.rr.getType()));
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(47757);
        return dispatch;
    }
}
