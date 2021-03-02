package com.tencent.mm.plugin.qqmail.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.qqmail.d.ao;
import com.tencent.mm.plugin.qqmail.d.ap;
import com.tencent.mm.vfs.o;

public final class a extends q implements m {
    public String Btw;
    private i callback;
    public String filePath;
    public d iUB;

    public a(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(198650);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/xmmailbroker/mb_createuploadurl";
        this.filePath = str;
        o oVar = new o(str);
        ao aoVar = new ao();
        g.aAf();
        aoVar.uin = (long) com.tencent.mm.kernel.a.getUin();
        aoVar.name = oVar.getName();
        aoVar.size = i2;
        aoVar.Btb = str2;
        aoVar.md5 = str3;
        this.Btw = str2;
        aVar.iLN = aoVar;
        aVar.iLO = new ap();
        this.iUB = aVar.aXF();
        AppMethodBeat.o(198650);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 11665;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(198651);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(198651);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(198652);
        b.i("MicroMsg.Mail.NetSceneCreateUploadUrl", "errType:%s errCode%s errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(198652);
    }
}
