package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.w.c;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;

public final class a extends q implements m {
    private i callback;
    public int dKp;
    private d rr;

    public a(int i2, String str, String str2, float f2, float f3, int i3, int i4, String str3, String str4) {
        AppMethodBeat.i(27619);
        d.a aVar = new d.a();
        aVar.iLN = new ame();
        aVar.iLO = new amf();
        aVar.uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ame ame = (ame) this.rr.iLK.iLR;
        this.dKp = i2;
        ame.OpCode = i2;
        ame.LuS = str;
        ame.Bri = str2;
        ame.LbC = f3;
        ame.LbD = f2;
        ame.LuT = i3;
        if (!Util.isNullOrNil(str3)) {
            ame.LuU = str3;
        }
        if (!Util.isNullOrNil(str4)) {
            ame.LuV = str4;
        }
        ame.LuW = i4;
        Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", Integer.valueOf(i2), str2, Float.valueOf(f3), Float.valueOf(f2), Integer.valueOf(i3), str3, str4, Integer.valueOf(i4));
        o.a(2007, f3, f2, i3);
        AppMethodBeat.o(27619);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(27620);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(27620);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        amf eFS;
        LinkedList<amg> linkedList;
        AppMethodBeat.i(27621);
        Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (!(this.dKp != 0 || (eFS = eFS()) == null || (linkedList = eFS.KGQ) == null)) {
            long currentTimeMillis = System.currentTimeMillis();
            int size = linkedList.size();
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < size; i5++) {
                amg amg = linkedList.get(i5);
                com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
                if (!Util.isNullOrNil(amg.UserName)) {
                    iVar.username = amg.UserName;
                } else {
                    iVar.username = amg.LuX;
                }
                Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", amg.UserName, amg.SmallImgUrl);
                iVar.iKW = amg.SmallImgUrl;
                iVar.fv(true);
                arrayList.add(iVar);
            }
            p.aYB().av(arrayList);
            Log.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", new StringBuilder().append(System.currentTimeMillis() - currentTimeMillis).toString());
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(27621);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return c.b.CTRL_INDEX;
    }

    public final amf eFS() {
        return (amf) this.rr.iLL.iLR;
    }
}
