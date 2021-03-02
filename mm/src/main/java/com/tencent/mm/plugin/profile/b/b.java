package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b extends q implements m {
    public String BcV;
    private i callback;
    private final d rr;

    public b(String str, String str2) {
        AppMethodBeat.i(26904);
        this.BcV = str;
        d.a aVar = new d.a();
        aVar.iLN = new bys();
        aVar.iLO = new byt();
        aVar.uri = "/cgi-bin/micromsg-bin/getwburl";
        aVar.funcId = 205;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bys bys = (bys) this.rr.iLK.iLR;
        bys.UserName = str2;
        bg.aVF();
        String nullAsNil = Util.nullAsNil((String) c.azQ().get(46, (Object) null));
        bys.KLh = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(nullAsNil));
        bg.aVF();
        String nullAsNil2 = Util.nullAsNil((String) c.azQ().get(72, (Object) null));
        bys.LRA = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(nullAsNil2));
        Log.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + str + ", a2=" + nullAsNil + " , newa2:" + nullAsNil2);
        AppMethodBeat.o(26904);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 205;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(26905);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(26905);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(26906);
        Log.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", Integer.valueOf(i3), Integer.valueOf(i4), getURL());
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(26906);
    }

    public final String getURL() {
        return ((byt) this.rr.iLL.iLR).URL;
    }
}
