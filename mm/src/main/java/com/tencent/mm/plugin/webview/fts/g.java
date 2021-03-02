package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.b;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.protocal.protobuf.fau;
import com.tencent.mm.protocal.protobuf.fav;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.LinkedList;
import org.json.JSONArray;

public final class g extends b implements m {
    private fav IDA;
    private v IDt;
    private i callback;
    private d iUB;

    public g(v vVar) {
        AppMethodBeat.i(77934);
        this.IDt = vVar;
        this.Nv = vVar.dDv;
        this.mScene = vVar.scene;
        this.IDq = vVar.dVL;
        if (!Util.isNullOrNil(vVar.dDv)) {
            Log.i("MicroMsg.WebSearch.NetSceneWebSuggest", "Constructors: query=%s", vVar.dDv);
            d.a aVar = new d.a();
            if (vVar.scene == 201 || vVar.IDQ == 1) {
                aVar.funcId = 1747;
                aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_weappsuggestion";
            } else {
                aVar.funcId = 1161;
                aVar.uri = "/cgi-bin/mmsearch-bin/searchsuggestion";
            }
            aVar.iLN = new fau();
            aVar.iLO = new fav();
            this.iUB = aVar.aXF();
            fau fau = (fau) this.iUB.iLK.iLR;
            fau.LPT = vVar.dDv;
            fau.KZg = (long) vVar.businessType;
            fau.NwV = ai.aft(0);
            fau.MRb = vVar.IDE;
            fau.MlQ = ai.clJ();
            fau.Scene = vVar.scene;
            fau.NwH = vVar.sessionId;
            fau.MlR = ai.fYd();
            if (vVar.IDS != null) {
                try {
                    fau.Nxc = new com.tencent.mm.bw.b(vVar.IDS.toByteArray());
                } catch (Exception e2) {
                }
            }
            if (vVar.IDR != null) {
                try {
                    fau.Nxb = new com.tencent.mm.bw.b(vVar.IDR.toByteArray());
                } catch (IOException e3) {
                }
            }
            try {
                JSONArray jSONArray = new JSONArray((Collection) vVar.IDJ);
                fau.NwZ = new LinkedList<>();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    fau.NwZ.add(URLDecoder.decode(jSONArray.getString(i2), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                }
            } catch (Exception e4) {
                Log.printErrStackTrace("MicroMsg.WebSearch.NetSceneWebSuggest", e4, "decode json error", new Object[0]);
            }
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(vVar.businessType);
            objArr[1] = Boolean.valueOf(fau.MlQ != null);
            objArr[2] = Integer.valueOf(vVar.scene);
            objArr[3] = Integer.valueOf(vVar.businessType);
            objArr[4] = Integer.valueOf(vVar.IDE);
            objArr[5] = Integer.valueOf(vVar.dVL);
            Log.i("MicroMsg.WebSearch.NetSceneWebSuggest", "businessTypeList is %d | contains location = %b | scene=%d | businessType=%d | isHomePage=%b | webViewId=%d", objArr);
            AppMethodBeat.o(77934);
            return;
        }
        Log.e("MicroMsg.WebSearch.NetSceneWebSuggest", "keyword is unavailable");
        AppMethodBeat.o(77934);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(77935);
        Log.i("MicroMsg.WebSearch.NetSceneWebSuggest", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.IDA = (fav) this.iUB.iLL.iLR;
            if (this.IDA != null) {
                Log.v("MicroMsg.WebSearch.NetSceneWebSuggest", "return data\n%s", this.IDA.MaZ);
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(77935);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(77935);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1161;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(77936);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(77936);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.websearch.api.b
    public final String fXC() {
        return this.IDA != null ? this.IDA.MaZ : "";
    }
}
