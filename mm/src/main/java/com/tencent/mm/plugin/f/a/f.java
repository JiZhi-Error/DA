package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.List;

public final class f extends a {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.f.a.a
    public final List<a> ap(ca caVar) {
        AppMethodBeat.i(22734);
        if (caVar == null) {
            AppMethodBeat.o(22734);
            return null;
        }
        a aq = aq(caVar);
        String fullPath = s.getFullPath(caVar.field_imgPath);
        long boW = com.tencent.mm.vfs.s.boW(fullPath);
        aq.field_msgSubType = 10;
        aq.field_path = bxr(fullPath);
        aq.field_size = boW;
        Log.i("MicroMsg.VoiceMsgHandler", "%s create voice wx file index voice[%s]", info(), aq);
        ArrayList arrayList = new ArrayList();
        arrayList.add(aq);
        AppMethodBeat.o(22734);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.f.a.a
    public final String info() {
        AppMethodBeat.i(22735);
        String str = "voice_" + hashCode();
        AppMethodBeat.o(22735);
        return str;
    }
}
