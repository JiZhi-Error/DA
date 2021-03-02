package com.tencent.mm.plugin.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.j.c;

public class PluginFace extends f implements a {
    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-facedetect";
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(103571);
        Log.i("MicroMsg.PluginFace", "hy: starting execute.");
        if (gVar.aBb()) {
            com.tencent.mm.vending.g.g.hdG().d(new a()).a(new d.a<c<Integer, String>>() {
                /* class com.tencent.mm.plugin.facedetect.PluginFace.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.g.d.a
                public final /* synthetic */ void cn(c<Integer, String> cVar) {
                    AppMethodBeat.i(103570);
                    c<Integer, String> cVar2 = cVar;
                    if (cVar2 != null) {
                        int nullAs = Util.nullAs((Integer) cVar2.get(0), -1);
                        Log.e("MicroMsg.PluginFace", "hy: onInterrupt errCode: %d, errMsg: %s", Integer.valueOf(nullAs), Util.nullAs((String) cVar2.get(1), "unknown"));
                        AppMethodBeat.o(103570);
                        return;
                    }
                    Log.e("MicroMsg.PluginFace", "hy: null in on interrupt");
                    AppMethodBeat.o(103570);
                }
            });
        }
        AppMethodBeat.o(103571);
    }

    public static boolean isEnabled() {
        AppMethodBeat.i(103572);
        boolean cMr = com.tencent.mm.plugin.expansions.a.cMr();
        AppMethodBeat.o(103572);
        return cMr;
    }
}
