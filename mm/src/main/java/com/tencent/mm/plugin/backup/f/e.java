package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.LinkedList;

public final class e implements l {
    @Override // com.tencent.mm.plugin.backup.f.l
    public final int a(String str, is isVar, ca caVar) {
        AppMethodBeat.i(21517);
        String str2 = isVar.KHn.MTo;
        if (str2 != null) {
            caVar.setContent(str2);
        }
        if (isVar.oUv == 50) {
            caVar.setStatus(6);
        }
        if (caVar.field_msgId == 0) {
            c.x(caVar);
        } else {
            d.cgP().cgQ().aSQ().b(isVar.Brn, caVar);
        }
        AppMethodBeat.o(21517);
        return 0;
    }

    @Override // com.tencent.mm.plugin.backup.f.l
    public final int a(is isVar, boolean z, ca caVar, String str, LinkedList<u> linkedList, HashMap<Long, h.a> hashMap, boolean z2, long j2) {
        AppMethodBeat.i(21516);
        if (caVar.field_content == null) {
            AppMethodBeat.o(21516);
            return 0;
        }
        int length = caVar.field_content.getBytes().length;
        AppMethodBeat.o(21516);
        return length;
    }
}
