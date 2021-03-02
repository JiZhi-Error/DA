package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.f.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;

public final class e extends a {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.f.a.a
    public final List<a> ap(ca caVar) {
        AppMethodBeat.i(22732);
        if (caVar == null) {
            AppMethodBeat.o(22732);
            return null;
        }
        o.bhj();
        String Qw = t.Qw(caVar.field_imgPath);
        long boW = s.boW(Qw);
        a aq = aq(caVar);
        aq.field_msgSubType = 1;
        aq.field_path = bxr(Qw);
        aq.field_size = boW;
        o.bhj();
        String Qx = t.Qx(caVar.field_imgPath);
        long boW2 = s.boW(Qx);
        a aq2 = aq(caVar);
        aq2.field_msgSubType = 2;
        aq2.field_path = bxr(Qx);
        aq2.field_size = boW2;
        if (caVar.cWK()) {
            aq2.field_path = k.b.aD(caVar.field_content, caVar.field_reserved).thumburl;
        }
        Log.i("MicroMsg.VideoMsgHandler", "%s create video wx file index video[%s] thumb[%s]", info(), aq, aq2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(aq);
        arrayList.add(aq2);
        AppMethodBeat.o(22732);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.f.a.a
    public final String info() {
        AppMethodBeat.i(22733);
        String str = "video_" + hashCode();
        AppMethodBeat.o(22733);
        return str;
    }
}
