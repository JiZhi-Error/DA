package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.protocal.protobuf.al;
import com.tencent.mm.protocal.protobuf.bhp;
import com.tencent.mm.protocal.protobuf.bhq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends q implements m {
    private com.tencent.mm.ak.i callback;
    LinkedList<String> pnD = new LinkedList<>();
    private final d rr;

    public i() {
        String obj;
        AppMethodBeat.i(5577);
        d.a aVar = new d.a();
        aVar.iLN = new bhp();
        aVar.iLO = new bhq();
        aVar.uri = "/cgi-bin/micromsg-bin/getapplist";
        aVar.funcId = 387;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bhp bhp = (bhp) this.rr.iLK.iLR;
        g.aAi();
        Object obj2 = g.aAh().azQ().get(196610, (Object) null);
        Object[] objArr = new Object[2];
        objArr[0] = 196610;
        if (obj2 == null) {
            obj = BuildConfig.COMMAND;
        } else {
            obj = obj2.toString();
        }
        objArr[1] = obj;
        Log.i("MicroMsg.BrandService.BrandServiceApplication", "get config, key[%d], value[%s]", objArr);
        bhp.LSe = Util.nullAs((Integer) obj2, 0);
        Log.i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", Integer.valueOf(bhp.LSe));
        AppMethodBeat.o(5577);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(5578);
        Log.w("MicroMsg.BrandService.NetSceneGetAppList", "on scene end code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            bhq bhq = (bhq) this.rr.iLL.iLR;
            Log.i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", Integer.valueOf(bhq.LSe), Integer.valueOf(bhq.oTz));
            b.k(196610, Integer.valueOf(bhq.LSe));
            Iterator<al> it = bhq.oTA.iterator();
            while (it.hasNext()) {
                this.pnD.add(it.next().UserName);
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(5578);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 387;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(5579);
        this.callback = iVar;
        Log.i("MicroMsg.BrandService.NetSceneGetAppList", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(5579);
        return dispatch;
    }
}
