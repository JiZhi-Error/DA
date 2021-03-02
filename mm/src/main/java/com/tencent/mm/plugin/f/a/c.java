package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;

public final class c extends a {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.f.a.a
    public final List<a> ap(ca caVar) {
        k.b bVar;
        int i2;
        long j2 = 0;
        String str = null;
        AppMethodBeat.i(22728);
        if (caVar == null) {
            AppMethodBeat.o(22728);
            return null;
        }
        String processXml = Util.processXml(caVar.field_content);
        if (processXml != null) {
            bVar = k.b.HD(processXml);
        } else {
            bVar = null;
        }
        if (bVar == null) {
            Log.e("MicroMsg.AppMsgMsgHandler", "content is null");
            AppMethodBeat.o(22728);
            return null;
        }
        a aq = aq(caVar);
        switch (bVar.type) {
            case 2:
                com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(bVar.dCK);
                if (bdx != null) {
                    str = bdx.field_fileFullPath;
                    j2 = s.boW(str);
                }
                aq.field_msgSubType = 30;
                aq.field_path = bxr(str);
                aq.field_size = j2;
                i2 = 31;
                break;
            case 3:
            case 4:
            case 5:
            default:
                AppMethodBeat.o(22728);
                return null;
            case 6:
                com.tencent.mm.pluginsdk.model.app.c bdx2 = ao.cgO().bdx(bVar.dCK);
                if (bdx2 != null) {
                    str = bdx2.field_fileFullPath;
                    j2 = s.boW(str);
                }
                aq.field_msgSubType = 34;
                aq.field_path = bxr(str);
                aq.field_size = j2;
                i2 = 35;
                break;
            case 7:
                com.tencent.mm.pluginsdk.model.app.c bdx3 = ao.cgO().bdx(bVar.dCK);
                if (bdx3 != null) {
                    str = bdx3.field_fileFullPath;
                    j2 = s.boW(str);
                }
                aq.field_msgSubType = 32;
                aq.field_path = bxr(str);
                aq.field_size = j2;
                i2 = 33;
                break;
        }
        String R = q.bcR().R(caVar.field_imgPath, true);
        long boW = s.boW(R);
        a aq2 = aq(caVar);
        aq2.field_msgSubType = i2;
        aq2.field_path = bxr(R);
        aq2.field_size = boW;
        Log.i("MicroMsg.AppMsgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", info(), aq, aq2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(aq);
        arrayList.add(aq2);
        AppMethodBeat.o(22728);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.f.a.a
    public final String info() {
        AppMethodBeat.i(22729);
        String str = "AppMsg_" + hashCode();
        AppMethodBeat.o(22729);
        return str;
    }
}
