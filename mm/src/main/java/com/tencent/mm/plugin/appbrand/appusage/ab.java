package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.ems;
import com.tencent.mm.protocal.protobuf.emt;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public final class ab extends c<emt> {
    private final String cym;
    private final ems kVP;
    private final d kVQ;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.ak.c
    public final /* synthetic */ void a(int i2, int i3, String str, emt emt, q qVar) {
        AppMethodBeat.i(44642);
        Log.i("MicroMsg.AppBrand.CgiUpdateWxaUsageRecord", "onCgiBack, req [scene %d, background %b, versionType %d, recordType %d, op %d, username %s]resp [errType %d, errCode %d, errMsg %s, resp %s]", Integer.valueOf(this.kVP.scene), Integer.valueOf(this.kVP.NkO), Integer.valueOf(this.kVP.KXC), Integer.valueOf(this.kVP.NkP), Integer.valueOf(this.kVP.NkQ), this.kVP.username, Integer.valueOf(i2), Integer.valueOf(i3), str, emt);
        AppMethodBeat.o(44642);
    }

    ab(int i2, boolean z, int i3, int i4, String str, int i5, String str2) {
        AppMethodBeat.i(44640);
        this.cym = str2;
        d.a aVar = new d.a();
        ems ems = new ems();
        ems.scene = i2 == 0 ? 1000 : i2;
        ems.NkO = z ? 1 : 0;
        ems.KXC = i3;
        ems.NkP = 2;
        ems.NkQ = i4;
        ems.username = str;
        ems.bDZ = i5;
        ems.session_id = str2;
        this.kVP = ems;
        aVar.iLN = ems;
        aVar.iLO = new emt();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
        aVar.funcId = 1149;
        d aXF = aVar.aXF();
        this.kVQ = aXF;
        c(aXF);
        AppMethodBeat.o(44640);
    }

    static ab br(String str, int i2) {
        AppMethodBeat.i(44641);
        ab abVar = new ab(1001, false, i2, 2, str, 1, null);
        AppMethodBeat.o(44641);
        return abVar;
    }
}
