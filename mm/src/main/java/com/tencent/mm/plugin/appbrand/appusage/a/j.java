package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class j extends c<dob> {
    public j(long j2, LinkedList<akf> linkedList, LinkedList<aap> linkedList2, int i2, int i3, int i4, aat aat) {
        AppMethodBeat.i(44689);
        Log.i("MicroMsg.Recommend.CgiReportRecommendWxa", "sessionId:%d, action_scene:%d", Long.valueOf(j2), Integer.valueOf(i2));
        d.a aVar = new d.a();
        doa doa = new doa();
        doa.clK = j2;
        doa.MQT = linkedList;
        doa.MQW = linkedList2;
        doa.MQU = i2;
        doa.MQV = i3;
        doa.MQX = i4;
        doa.MaO = aat;
        aVar.iLN = doa;
        aVar.iLO = new dob();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportrecommendwxa";
        aVar.funcId = 2564;
        c(aVar.aXF());
        AppMethodBeat.o(44689);
    }
}
