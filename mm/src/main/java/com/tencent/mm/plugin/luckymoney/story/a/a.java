package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends c<buh> {
    public String yZF;

    public a(String str, boolean z) {
        AppMethodBeat.i(163688);
        bug bug = new bug();
        d.a aVar = new d.a();
        aVar.iLN = bug;
        aVar.iLO = new buh();
        aVar.funcId = 3634;
        aVar.uri = "/cgi-bin/micromsg-bin/getredpacketstory";
        bug.iwu = str;
        if (!z) {
            aVar.timeout = 5000;
        }
        d aXF = aVar.aXF();
        aXF.setIsUserCmd(z);
        c(aXF);
        this.yZF = str;
        Log.i("MicroMsg.CgiRedPacketStoryInfo", "packet id: %s", str);
        AppMethodBeat.o(163688);
    }
}
