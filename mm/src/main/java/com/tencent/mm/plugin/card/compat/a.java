package com.tencent.mm.plugin.card.compat;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.model.app.m;

public final class a implements com.tencent.mm.plugin.card.compat.a.a {
    @Override // com.tencent.mm.plugin.card.compat.a.a
    public final int a(k.b bVar, String str, String str2, String str3, byte[] bArr) {
        AppMethodBeat.i(22756);
        Pair<Integer, Long> a2 = m.a(bVar, str, str2, str3, (String) null, bArr);
        if (a2 != null) {
            int intValue = ((Integer) a2.first).intValue();
            AppMethodBeat.o(22756);
            return intValue;
        }
        int line = 0 - f.getLine();
        AppMethodBeat.o(22756);
        return line;
    }
}
