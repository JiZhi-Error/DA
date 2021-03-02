package com.tencent.mm.plugin.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.h;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.Map;

public final class a implements g {
    public final q plo = new q() {
        /* class com.tencent.mm.plugin.box.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
            String str2;
            AppMethodBeat.i(196182);
            if (str.equals("functionmsg") && (str2 = map.get(".sysmsg.functionmsg.businessid")) != null && str2.equals("20002") && aVar.iMa != null) {
                final byte[] byteArray = ((g.b) aVar.iMa).iLT.KZo.toByteArray();
                String ckW = c.ckW();
                if (s.YS(ckW)) {
                    s.deleteFile(ckW);
                }
                s.bpa(ckW);
                s.f(ckW, byteArray, byteArray.length);
                Log.i("MicroMsg.WebSearch.BlackWhiteWordsMsgExtension", "[onNewXmlReceived] bytesLen: %s", Integer.valueOf(byteArray.length));
                com.tencent.f.h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.plugin.box.a.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(196181);
                        c.ba(byteArray);
                        c.kh(false);
                        c.aho(c.ki(false));
                        AppMethodBeat.o(196181);
                    }
                }, "box.HotWordSearchModel");
            }
            AppMethodBeat.o(196182);
        }
    };

    public a() {
        AppMethodBeat.i(196183);
        AppMethodBeat.o(196183);
    }

    @Override // com.tencent.mm.ak.g
    public final int atz() {
        return -1;
    }

    @Override // com.tencent.mm.ak.g
    public final int atA() {
        return 20002;
    }

    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        return null;
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
    }
}
