package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.protocal.protobuf.xu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d extends q implements m {
    private final c BGu;
    private i callback;
    private com.tencent.mm.ak.d rr;

    public d(c cVar, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(9459);
        d.a aVar = new d.a();
        aVar.iLN = new xt();
        aVar.iLO = new xu();
        aVar.uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
        aVar.funcId = 728;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.BGu = cVar;
        xt xtVar = (xt) this.rr.iLK.iLR;
        xtVar.LbJ = str;
        xtVar.KMg = cVar.field_totalLen;
        xtVar.xuB = str2;
        xtVar.xuz = str3;
        xtVar.KMh = str4;
        xtVar.xNH = str5;
        xtVar.xNG = (String) g.aAh().azQ().get(2, "");
        xtVar.KKA = a.gpO;
        Log.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", Util.secPrint(xtVar.LbJ), xtVar.xuB, xtVar.xuz, xtVar.KMh, Long.valueOf(xtVar.KMg), Integer.valueOf(xtVar.KKA), Util.getStack());
        AppMethodBeat.o(9459);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 728;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(9460);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(9460);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(9461);
        Log.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            xu xuVar = (xu) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
            this.BGu.field_signature = xuVar.keb;
            this.BGu.field_fakeAeskey = xuVar.LiS;
            this.BGu.field_fakeSignature = xuVar.LiT;
            Log.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", Util.secPrint(this.BGu.field_signature), Util.secPrint(this.BGu.field_fakeAeskey), Util.secPrint(this.BGu.field_fakeSignature), Boolean.valueOf(com.tencent.mm.plugin.r.a.cgO().a(this.BGu, new String[0])));
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(9461);
    }

    public final String getMediaId() {
        if (this.BGu != null) {
            return this.BGu.field_mediaSvrId;
        }
        return "";
    }
}
