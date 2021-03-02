package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.eaz;
import com.tencent.mm.protocal.protobuf.eba;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class x extends q implements m {
    private long DJb;
    public i callback;
    private int dJY;
    private d rr;
    private int scene = 0;

    public x(int i2, long j2, String str, int i3, List<String> list, int i4) {
        AppMethodBeat.i(95655);
        Log.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + i2 + " tagName " + str + " memberList " + list.size() + " scene " + i4);
        this.dJY = i2;
        this.DJb = j2;
        this.scene = i4;
        d.a aVar = new d.a();
        aVar.iLN = new eaz();
        aVar.iLO = new eba();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
        aVar.funcId = 291;
        aVar.iLP = 115;
        aVar.respCmdId = 1000000115;
        this.rr = aVar.aXF();
        eaz eaz = (eaz) this.rr.iLK.iLR;
        eaz.OpCode = i2;
        eaz.Nar = j2;
        eaz.xMo = str;
        eaz.oTz = i3;
        eaz.Scene = this.scene;
        LinkedList<dqi> linkedList = new LinkedList<>();
        for (String str2 : list) {
            linkedList.add(new dqi().bhy(str2));
        }
        eaz.oTA = linkedList;
        Log.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + eaz.toString());
        AppMethodBeat.o(95655);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(95656);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95656);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 291;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(95657);
        Log.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (i3 == 0 && i4 == 0) {
            eaw eaw = ((eba) ((d) sVar).iLL.iLR).Nat;
            Log.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + eaw.toString());
            com.tencent.mm.plugin.sns.storage.s JL = aj.faU().JL(eaw.Nar);
            JL.field_tagId = eaw.Nar;
            JL.field_tagName = Util.nullAs(eaw.xMo, "");
            switch (this.dJY) {
                case 1:
                case 2:
                case 3:
                    JL.field_count = eaw.oTz;
                    JL.gX(eaw.oTA);
                    break;
            }
            aj.faU().a(JL);
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(95657);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(95657);
    }
}
