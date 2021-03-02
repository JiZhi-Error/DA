package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.aa;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends com.tencent.mm.ak.c<aa> {
    public c(int i2, int i3, int i4, String str, int i5, int i6, String str2) {
        AppMethodBeat.i(63372);
        d.a aVar = new d.a();
        z zVar = new z();
        zVar.limit = i2;
        zVar.offset = i3;
        zVar.type = i4;
        zVar.KCg = str;
        zVar.KCh = i5;
        zVar.KCi = i6;
        zVar.KCj = str2;
        aVar.iLN = zVar;
        aVar.iLO = new aa();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        aVar.funcId = 1676;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s, bill_id: %s, trans_id: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, str2);
        AppMethodBeat.o(63372);
    }

    public c(int i2, int i3, int i4) {
        AppMethodBeat.i(63373);
        d.a aVar = new d.a();
        z zVar = new z();
        zVar.limit = i2;
        zVar.offset = i3;
        zVar.type = i4;
        aVar.iLN = zVar;
        aVar.iLO = new aa();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        aVar.funcId = 1676;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(63373);
    }
}
