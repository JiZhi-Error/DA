package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class c extends f {
    public int dYz = 0;

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(152374);
        c cVar = new c();
        cVar.dYz = this.dYz;
        AppMethodBeat.o(152374);
        return cVar;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
        AppMethodBeat.i(152375);
        sb.append("<directshare>").append(this.dYz).append("</directshare>");
        AppMethodBeat.o(152375);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(152376);
        String str = map.get(".msg.appmsg.directshare");
        if (!Util.isNullOrNil(str)) {
            this.dYz = Util.safeParseInt(str);
        }
        AppMethodBeat.o(152376);
    }
}
