package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yx;
import com.tencent.mm.protocal.protobuf.yy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e extends q implements m {
    private a BGv;
    private i callback;
    private d rr;

    public interface a {
        void ax(String str, int i2, int i3);
    }

    public e(String str, String str2, String str3, int i2, a aVar) {
        AppMethodBeat.i(9462);
        d.a aVar2 = new d.a();
        aVar2.iLN = new yx();
        aVar2.iLO = new yy();
        aVar2.uri = "/cgi-bin/micromsg-bin/checkmd5";
        aVar2.funcId = 939;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        this.rr = aVar2.aXF();
        yx yxVar = (yx) this.rr.iLK.iLR;
        yxVar.fileid = str;
        yxVar.md5 = str2;
        yxVar.LaE = str3;
        yxVar.LjY = i2;
        this.BGv = aVar;
        Log.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", yxVar.fileid, yxVar.md5, yxVar.LaE, Integer.valueOf(yxVar.LjY), Util.getStack());
        AppMethodBeat.o(9462);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 939;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(9463);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(9463);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        a aVar;
        String str2;
        a aVar2;
        AppMethodBeat.i(9464);
        Log.i("MicroMsg.NetSceneCheckMd5", "summersafecdn onGYNetEnd [%d, %d, %s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        if (this.BGv != null) {
            if (i3 == 0 && i4 == 0) {
                yy yyVar = (yy) ((d) sVar).iLL.iLR;
                a aVar3 = this.BGv;
                if (yyVar != null) {
                    str2 = yyVar.aeskey;
                    aVar = aVar3;
                    aVar.ax(str2, i3, i4);
                } else {
                    aVar2 = aVar3;
                }
            } else {
                aVar2 = this.BGv;
            }
            str2 = "";
            aVar = aVar2;
            aVar.ax(str2, i3, i4);
        }
        AppMethodBeat.o(9464);
    }
}
