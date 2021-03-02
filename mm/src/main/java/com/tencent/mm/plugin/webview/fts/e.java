package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.record.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.webview.fts.c;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.clu;
import com.tencent.mm.protocal.protobuf.epb;
import com.tencent.mm.protocal.protobuf.exs;
import com.tencent.mm.protocal.protobuf.ext;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends q implements m {
    public c.g IOB;
    private int IOy;
    private i callback;
    public int dVL = -1;
    d rr;
    private int scene;

    public e(Map<String, Object> map, int i2, int i3) {
        AppMethodBeat.i(210835);
        d.a aVar = new d.a();
        aVar.iLN = new exs();
        aVar.iLO = new ext();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/weappsearchguide";
        aVar.funcId = 1866;
        this.rr = aVar.aXF();
        this.IOy = i3;
        this.scene = i2;
        chl clJ = ai.clJ();
        exs exs = (exs) this.rr.iLK.iLR;
        if (clJ != null) {
            exs.NuX = (double) clJ.LbD;
            exs.NuY = (double) clJ.LbC;
        }
        exs.NuZ = ai.ait();
        exs.IEj = ai.aft(3);
        exs.sessionId = ai.N(map, "statSessionId");
        exs.scene = ai.b(map, "scene", 0);
        String N = ai.N(map, "extReqParams");
        if (!Util.isNullOrNil(N)) {
            try {
                JSONArray jSONArray = new JSONArray(N);
                exs.Nva = new LinkedList<>();
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i4);
                    epb epb = new epb();
                    epb.key = jSONObject.optString("key", "");
                    epb.LmC = jSONObject.optLong("uintValue", 0);
                    epb.LmD = jSONObject.optString("textValue", "");
                    exs.Nva.push(epb);
                }
            } catch (Exception e2) {
            }
        }
        Log.i("MicroMsg.WebSearch.NetSceneWeAppSearchGuide", "weappsearchguide req, version = %d, sessionId = %s, scene = %d, extParam = %s", Integer.valueOf(exs.IEj), exs.sessionId, Integer.valueOf(exs.scene), N);
        AppMethodBeat.o(210835);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(77927);
        int type = this.rr.getType();
        AppMethodBeat.o(77927);
        return type;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(77928);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(77928);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(77929);
        Log.i("MicroMsg.WebSearch.NetSceneWeAppSearchGuide", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.IOB = new c.g(this.scene, (ext) this.rr.iLL.iLR, this.IOy);
        c.g gVar = this.IOB;
        clu clu = new clu();
        clu.Scene = gVar.scene;
        clu.MaZ = gVar.dNA;
        clu.Mrg = gVar.interval;
        clu.Mrf = gVar.IOr;
        clu.Mrh = gVar.IOy;
        byte[] bArr2 = null;
        try {
            bArr2 = clu.toByteArray();
        } catch (IOException e2) {
        }
        if (bArr2 != null) {
            o oVar = new o(b.aTb(), c.g.afO(gVar.scene));
            if (!oVar.heq().exists()) {
                oVar.heq().mkdirs();
            }
            if (oVar.exists()) {
                oVar.delete();
            }
            com.tencent.mm.vfs.s.f(aa.z(oVar.her()), bArr2, bArr2.length);
            Log.i("MicroMsg.WebSearch.FTSWebViewLogic", "SearchGuideCacheObj saved, scene:%d", Integer.valueOf(gVar.scene));
        } else {
            Log.w("MicroMsg.WebSearch.FTSWebViewLogic", "SearchGuideCacheObj toBytes fail, scene:%d!", Integer.valueOf(gVar.scene));
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(77929);
    }
}
