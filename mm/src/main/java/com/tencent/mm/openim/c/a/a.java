package com.tencent.mm.openim.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.hc;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends c<hd> {
    public a(String str, String str2, String str3, LinkedList<String> linkedList) {
        AppMethodBeat.i(151261);
        Log.d("MicroMsg.CgiOpenImApproveAddRoomMember", "CgiOpenImApproveAddRoomMember() inviterusername%s, roomname:%s, ticket:%s, username:%s", str, str2, Util.secPrint(str3), linkedList);
        hc hcVar = new hc();
        hcVar.dHx = str3;
        hcVar.dOe = str2;
        cvt cvt = new cvt();
        cvt.userName = str;
        hcVar.KKL = cvt;
        LinkedList<cvt> linkedList2 = new LinkedList<>();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            cvt cvt2 = new cvt();
            cvt2.userName = it.next();
            linkedList2.add(cvt2);
        }
        hcVar.KKM = linkedList2;
        d.a aVar = new d.a();
        aVar.iLN = hcVar;
        aVar.iLO = new hd();
        aVar.uri = "/cgi-bin/micromsg-bin/approveaddopenimchatroommember";
        aVar.funcId = 941;
        c(aVar.aXF());
        AppMethodBeat.o(151261);
    }
}
