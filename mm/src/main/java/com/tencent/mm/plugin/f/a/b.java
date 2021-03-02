package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;

public final class b extends a {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.f.a.a
    public final List<a> ap(ca caVar) {
        k.b bVar;
        String str = null;
        AppMethodBeat.i(22726);
        if (caVar == null) {
            AppMethodBeat.o(22726);
            return null;
        }
        String processXml = Util.processXml(caVar.field_content);
        if (processXml != null) {
            bVar = k.b.HD(processXml);
        } else {
            bVar = null;
        }
        if (bVar == null) {
            Log.e("MicroMsg.AppMsgImgMsgHandler", "content is null");
            AppMethodBeat.o(22726);
            return null;
        }
        a aq = aq(caVar);
        c bdx = ao.cgO().bdx(bVar.dCK);
        long j2 = 0;
        if (bdx != null) {
            str = bdx.field_fileFullPath;
            j2 = s.boW(str);
        }
        aq.field_msgSubType = 30;
        aq.field_path = bxr(str);
        aq.field_size = j2;
        String R = q.bcR().R(caVar.field_imgPath, true);
        long boW = s.boW(R);
        a aq2 = aq(caVar);
        aq2.field_msgSubType = 31;
        aq2.field_path = bxr(R);
        aq2.field_size = boW;
        Log.i("MicroMsg.AppMsgImgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", info(), aq, aq2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(aq);
        arrayList.add(aq2);
        AppMethodBeat.o(22726);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.f.a.a
    public final String info() {
        AppMethodBeat.i(22727);
        String str = "AppMsgImg_" + hashCode();
        AppMethodBeat.o(22727);
        return str;
    }
}
