package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import java.util.Map;

public final class ck implements h {
    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        AppMethodBeat.i(20397);
        de deVar = aVar.heO;
        if (deVar == null) {
            Log.e("MicroMsg.SysNoticeMsgExtension", "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(20397);
        } else {
            try {
                Map<String, String> parseXml = XmlParser.parseXml("<root>" + deVar.KHn + "</root>", "root", null);
                int intValue = Integer.valueOf(parseXml.get(".root.newcount")).intValue();
                int intValue2 = Integer.valueOf(parseXml.get(".root.version")).intValue();
                bg.aVF();
                ao azQ = c.azQ();
                if (intValue2 == Util.nullAsNil((Integer) azQ.get(12305, (Object) null))) {
                    Log.i("MicroMsg.SysNoticeMsgExtension", "ignore new sys notice count, same version");
                    AppMethodBeat.o(20397);
                } else {
                    azQ.set(12304, Integer.valueOf(intValue));
                    azQ.set(12305, Integer.valueOf(intValue2));
                    AppMethodBeat.o(20397);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.SysNoticeMsgExtension", "exception:%s", Util.stackTraceToString(e2));
            }
        }
        return null;
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
    }
}
