package com.tencent.mm.aa.a;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class c extends q implements m {
    private i heq;
    private a<c> hpf;
    private final d rr;

    public interface a<T extends q> {
        void a(int i2, int i3, String str, T t);
    }

    public c(String str, LinkedList<String> linkedList, String str2, String str3, a<c> aVar) {
        this(str, linkedList, 0, str2, str3, 0, -1, aVar);
    }

    public c(String str, LinkedList<String> linkedList, int i2, String str2, String str3, int i3, int i4, a<c> aVar) {
        this(str, linkedList, i2, str2, str3, i3, i4);
        this.hpf = aVar;
    }

    private c(String str, LinkedList<String> linkedList, int i2, String str2, String str3, int i3, int i4) {
        AppMethodBeat.i(150097);
        Log.i("MicroMsg.webview.NetSceneJSLogin", "NetSceneJSLogin doScene appId [%s], loginType [%d], url [%s], state [%s], versionType [%d], extScene [%d]", str, Integer.valueOf(i2), str2, str3, Integer.valueOf(i3), Integer.valueOf(i4));
        d.a aVar = new d.a();
        aVar.iLN = new ces();
        aVar.iLO = new cet();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-login";
        aVar.funcId = TXLiteAVCode.EVT_LOCAL_RECORD_RESULT;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ces ces = (ces) this.rr.iLK.iLR;
        ces.jfi = str;
        ces.MjX = linkedList;
        ces.Mkk = i2;
        ces.Url = str2;
        ces.Mkl = str3;
        ces.MjZ = i3;
        if (i4 > 0) {
            ces.Mka = new fdg();
            ces.Mka.scene = i4;
        }
        AppMethodBeat.o(150097);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150098);
        Log.i("MicroMsg.webview.NetSceneJSLogin", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.heq != null) {
            this.heq.onSceneEnd(i3, i4, str, this);
        }
        if (this.hpf != null) {
            this.hpf.a(i3, i4, str, this);
        }
        AppMethodBeat.o(150098);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TXLiteAVCode.EVT_LOCAL_RECORD_RESULT;
    }

    public final ces ayL() {
        if (this.rr == null) {
            return null;
        }
        return (ces) this.rr.iLK.iLR;
    }

    public final cet ayM() {
        return (cet) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150099);
        Log.i("MicroMsg.webview.NetSceneJSLogin", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150099);
        return dispatch;
    }
}
