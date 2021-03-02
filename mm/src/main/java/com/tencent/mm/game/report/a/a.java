package com.tencent.mm.game.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.net.URLEncoder;

public final class a implements b {
    @Override // com.tencent.mm.game.report.a.b
    public final String a(b.a aVar, String str) {
        AppMethodBeat.i(108267);
        String a2 = ((b) g.af(b.class)).a(aVar, str);
        if (!a2.equals(str)) {
            com.tencent.mm.game.report.api.a.hhr.a(2, aVar.name(), Fg(a2), 0);
        }
        Log.i("MicroMsg.GameExptManager", "key: %s, result: %s", aVar.name(), a2);
        AppMethodBeat.o(108267);
        return a2;
    }

    @Override // com.tencent.mm.game.report.a.b
    public final int a(b.a aVar, int i2) {
        AppMethodBeat.i(108268);
        int a2 = ((b) g.af(b.class)).a(aVar, i2);
        com.tencent.mm.game.report.api.a.hhr.a(2, aVar.name(), String.valueOf(a2), 0);
        Log.i("MicroMsg.GameExptManager", "key: %s, result: %d", aVar.name(), Integer.valueOf(a2));
        AppMethodBeat.o(108268);
        return a2;
    }

    @Override // com.tencent.mm.game.report.a.b
    public final boolean a(b.a aVar, boolean z) {
        AppMethodBeat.i(190324);
        boolean a2 = ((b) g.af(b.class)).a(aVar, z);
        com.tencent.mm.game.report.api.a.hhr.a(2, aVar.name(), String.valueOf(a2), 0);
        Log.i("MicroMsg.GameExptManager", "key: %s, result: %b", aVar.name(), Boolean.valueOf(a2));
        AppMethodBeat.o(190324);
        return a2;
    }

    private static String Fg(String str) {
        AppMethodBeat.i(108270);
        try {
            str = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            AppMethodBeat.o(108270);
        } catch (Exception e2) {
            AppMethodBeat.o(108270);
        }
        return str;
    }
}
