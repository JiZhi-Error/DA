package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.fau;
import com.tencent.mm.protocal.protobuf.fav;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.LinkedList;
import org.json.JSONArray;

public final class s extends q implements m {
    private fav IDA;
    private v IDt;
    private fau IDz = ((fau) this.iUB.iLK.iLR);
    private i callback;
    private d iUB;

    public s(v vVar) {
        AppMethodBeat.i(187832);
        this.IDt = vVar;
        d.a aVar = new d.a();
        aVar.funcId = 1161;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
        aVar.iLN = new fau();
        aVar.iLO = new fav();
        this.iUB = aVar.aXF();
        this.IDz.LPT = this.IDt.dDv;
        this.IDz.KZg = (long) this.IDt.businessType;
        this.IDz.NwV = ai.aft(6);
        this.IDz.MRb = this.IDt.IDE;
        this.IDz.MlQ = ai.clJ();
        this.IDz.Scene = this.IDt.scene;
        this.IDz.NwH = this.IDt.sessionId;
        this.IDz.MlR = ai.fYd();
        try {
            JSONArray jSONArray = new JSONArray((Collection) this.IDt.IDJ);
            this.IDz.NwZ = new LinkedList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.IDz.NwZ.add(URLDecoder.decode(jSONArray.getString(i2), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            }
            AppMethodBeat.o(187832);
        } catch (Exception e2) {
            b.printErrStackTrace("MicroMsg.WebSearch.NetSceneMMWebSuggest", e2, "decode json error", new Object[0]);
            AppMethodBeat.o(187832);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1161;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(187833);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(187833);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(187834);
        b.i("MicroMsg.WebSearch.NetSceneMMWebSuggest", "onGYNetEnd errType:%s errCode:%s errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.IDA = (fav) this.iUB.iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(187834);
    }

    public final fav fXM() {
        return this.IDA;
    }

    public final v fXN() {
        return this.IDt;
    }
}
