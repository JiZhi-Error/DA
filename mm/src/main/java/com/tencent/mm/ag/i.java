package com.tencent.mm.ag;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.ecm;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Map;

public final class i extends f {
    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(20237);
        i iVar = new i();
        AppMethodBeat.o(20237);
        return iVar;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
        AppMethodBeat.i(20238);
        if (!Util.isNullOrNil(bVar.appId)) {
            String str2 = bVar.ean;
            eco eco = new eco();
            if (str2 != null) {
                try {
                    eco.parseFrom(Base64.decode(str2, 0));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", e2, "", new Object[0]);
                }
            }
            eco.NcJ = new ecm();
            eco.NcJ.xEN = bVar.appId;
            try {
                str2 = Base64.encodeToString(eco.toByteArray(), 0).replace("\n", "");
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", e3, "", new Object[0]);
            }
            bVar.ean = str2;
        }
        sb.append("<statextstr>" + Util.escapeStringForXml(bVar.ean) + "</statextstr>");
        AppMethodBeat.o(20238);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
    }
}
