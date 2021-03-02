package com.tencent.mm.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class a extends q implements m {
    private i heq;
    private AbstractC0240a<a> hpd;
    private final d rr;

    /* renamed from: com.tencent.mm.aa.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0240a<T extends q> {
        void a(int i2, int i3, String str, T t);
    }

    public a(String str, LinkedList<String> linkedList, AbstractC0240a<a> aVar) {
        this(str, linkedList, 0, -1, aVar);
    }

    public a(String str, LinkedList<String> linkedList, int i2, int i3, AbstractC0240a<a> aVar) {
        this(str, linkedList, i2, i3);
        this.hpd = aVar;
    }

    private a(String str, LinkedList<String> linkedList, int i2, int i3) {
        AppMethodBeat.i(150091);
        Log.i("MicroMsg.webview.NetSceneJSAuthorize", "NetSceneJSLogin doScene appId [%s], versionType [%d], extScene[%d]", str, Integer.valueOf(i2), Integer.valueOf(i3));
        d.a aVar = new d.a();
        aVar.iLN = new ceo();
        aVar.iLO = new cep();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        aVar.funcId = 1157;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ceo ceo = (ceo) this.rr.iLK.iLR;
        if (i3 > 0) {
            ceo.Mka = new fdg();
            ceo.Mka.scene = i3;
        }
        ceo.jfi = str;
        ceo.MjX = linkedList;
        ceo.MjZ = i2;
        AppMethodBeat.o(150091);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150092);
        Log.i("MicroMsg.webview.NetSceneJSAuthorize", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.heq != null) {
            this.heq.onSceneEnd(i3, i4, str, this);
        }
        if (this.hpd != null) {
            this.hpd.a(i3, i4, str, this);
        }
        AppMethodBeat.o(150092);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1157;
    }

    public final ceo ayH() {
        if (this.rr == null) {
            return null;
        }
        return (ceo) this.rr.iLK.iLR;
    }

    public final cep ayI() {
        return (cep) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150093);
        Log.i("MicroMsg.webview.NetSceneJSAuthorize", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150093);
        return dispatch;
    }
}
