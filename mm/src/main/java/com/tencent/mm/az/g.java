package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class g extends a {
    public g(Map<String, String> map, ca caVar) {
        super(map, caVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.az.a
    public final boolean aTA() {
        AppMethodBeat.i(194530);
        if (this.values == null) {
            Log.e("MicroMsg.FinderChatSystemaNewXmlMsg", "[parseXml] values == null ");
            AppMethodBeat.o(194530);
        } else {
            Log.i("MicroMsg.FinderChatSystemaNewXmlMsg", "[parseXml] type:%s, values size:%s", Util.nullAsNil(this.TYPE), Integer.valueOf(this.values.size()));
            if (this.values.containsKey(".sysmsg.SysMsgContent")) {
                this.jfG = Util.nullAsNil((String) this.values.get(".sysmsg.SysMsgContent"));
            }
            Log.i("MicroMsg.FinderChatSystemaNewXmlMsg", "appText = " + this.jfG);
            AppMethodBeat.o(194530);
        }
        return false;
    }
}
