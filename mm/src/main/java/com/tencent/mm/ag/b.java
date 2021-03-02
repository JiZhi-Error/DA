package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class b extends f {
    public String dXf;
    public String ivA;
    public String ivB;
    public String ivC;
    public String ivD;
    public String ivE;
    public String ivF;
    public String ivG;
    public String ivH;
    public String ivI;
    public String ivJ;
    public String ivK;
    public String ivL;
    public String ivM;
    public String ivN;
    public String ivr;
    public String ivs;
    public String ivt;
    public String ivu;
    public String ivv;
    public String ivw;
    public String ivx;
    public String ivy;
    public String ivz;
    public String zpO;
    public String zpP;
    public String zpQ;
    public String zph;

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(20227);
        b bVar = new b();
        AppMethodBeat.o(20227);
        return bVar;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(20228);
        if (bVar.type == 2002 || bVar.type == 2003) {
            this.ivr = c(map, "templateid");
            this.ivs = c(map, "senderurl");
            this.ivt = c(map, "sendernativeurl");
            this.ivu = c(map, "receiverurl");
            this.ivv = c(map, "receivernativeurl");
            this.ivw = c(map, "iconurl");
            this.ivx = c(map, "miniiconurl");
            this.ivy = c(map, "backgroundurl");
            this.ivz = c(map, "backgroundname");
            this.ivA = c(map, "backgroundcolor");
            this.ivB = c(map, "receivertitle");
            this.ivC = c(map, "sendertitle");
            this.ivD = c(map, "titlecolor");
            this.zph = c(map, "titlecolordark");
            this.ivE = c(map, "senderscenetext");
            this.ivF = c(map, "receiverscenetext");
            this.ivG = c(map, "senderdes");
            this.ivH = c(map, "receiverdes");
            this.ivI = c(map, "descolor");
            this.zpO = c(map, "descolordark");
            this.zpQ = c(map, "scenetextcolor");
            this.zpP = c(map, "scenetextcolordark");
            this.ivJ = c(map, "sceneid");
            this.dXf = c(map, "paymsgid");
            this.ivK = c(map, "senderbackgroundname");
            this.ivL = c(map, "senderbackgroundurl");
            this.ivM = c(map, "receiverbackgroundname");
            this.ivN = c(map, "receiverbackgroundurl");
        }
        AppMethodBeat.o(20228);
    }

    private static String c(Map<String, String> map, String str) {
        AppMethodBeat.i(20229);
        String nullAsNil = Util.nullAsNil(map.get(".msg.appmsg.wcpaythirdinfo.".concat(String.valueOf(str))));
        AppMethodBeat.o(20229);
        return nullAsNil;
    }
}
