package com.tencent.mm.ag;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.dlr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class g extends f {
    public String iwl;
    public String iwm;
    public String iwn;
    public String iwo;
    public String iwp;
    public String iwq;
    public String iwr;
    public String iws;
    public String iwt;
    public String iwu;
    public String iwv;
    public String iww;
    public boolean iwx;
    public int iwy;

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(169180);
        g gVar = new g();
        AppMethodBeat.o(169180);
        return gVar;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(169181);
        String nullAsNil = Util.nullAsNil(map.get(".msg.appmsg.wcpayinfo.coverinfo"));
        dlr dlr = new dlr();
        try {
            if (!Util.isNullOrNil(nullAsNil)) {
                dlr.parseFrom(Base64.decode(nullAsNil, 0));
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppContentRedPacketCoverInfoPiece", e2, "", new Object[0]);
        }
        this.iwl = dlr.iwl;
        this.iwm = dlr.iwm;
        this.iwn = dlr.iwn;
        this.iwo = dlr.iwo;
        this.iwp = dlr.iwp;
        this.iwq = dlr.iwq;
        this.iwr = dlr.iwr;
        this.iws = dlr.iws;
        this.iwt = dlr.iwt;
        this.iwu = dlr.iwu;
        this.iwv = dlr.iwv;
        this.iww = dlr.iww;
        this.iwx = dlr.iwx;
        this.iwy = dlr.iwy;
        AppMethodBeat.o(169181);
    }
}
