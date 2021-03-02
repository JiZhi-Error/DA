package com.tencent.mm.plugin.messenger.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.d.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class c extends e {
    @Override // com.tencent.mm.plugin.messenger.d.e
    public final String eiU() {
        return "tmpl_type_profilewithrevoke";
    }

    @Override // com.tencent.mm.plugin.messenger.d.e
    public final void b(Map<String, String> map, h.a aVar) {
        AppMethodBeat.i(194510);
        de deVar = aVar.heO;
        String a2 = z.a(deVar.KHl);
        ca aJ = ((l) g.af(l.class)).eiy().aJ(a2, deVar.Brn);
        String n = n(map, "link_history");
        if (Util.isNullOrNil(n)) {
            Log.e("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onReceivedImp head(LINK_TYPE_HISTORY) is null.(%s %s)", a2, Long.valueOf(aJ.field_msgSvrId));
            AppMethodBeat.o(194510);
            return;
        }
        ((v) g.af(v.class)).a(aJ.field_msgId, map, n);
        String nullAs = Util.nullAs(map.get(n + ".historyid"), "");
        aJ.CF(nullAs);
        ((l) g.af(l.class)).eiy().a(aJ.field_msgId, aJ);
        ((v) g.af(v.class)).aA(nullAs, aJ.field_msgId);
        Log.i("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onReceivedImp msgId:%s historyId:%s", Long.valueOf(aJ.field_msgId), nullAs);
        AppMethodBeat.o(194510);
    }

    @Override // com.tencent.mm.plugin.messenger.d.e
    public final void c(String str, Map<String, String> map, Bundle bundle) {
        AppMethodBeat.i(194511);
        if (Util.isNullOrNil(n(map, "link_history"))) {
            Log.e("MicroMsg.SysMsgTemp.HandlerProfileWithRevokeReceived", "onClickLinkImp head is null.");
            AppMethodBeat.o(194511);
            return;
        }
        AppMethodBeat.o(194511);
    }
}
