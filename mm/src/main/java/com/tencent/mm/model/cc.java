package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import junit.framework.Assert;

public final class cc implements h {
    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        boolean z = true;
        AppMethodBeat.i(20393);
        de deVar = aVar.heO;
        Assert.assertTrue(deVar != null);
        if (deVar.KHn == null) {
            z = false;
        }
        Assert.assertTrue(z);
        String str = XmlParser.parseXml(z.a(deVar.KHn), "tips", null).get(".tips.tip.url");
        Log.v("MicroMsg.SoftwareMsgExtension", "url:".concat(String.valueOf(str)));
        bg.aVF();
        c.azQ().set(12308, str);
        AppMethodBeat.o(20393);
        return null;
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
    }
}
