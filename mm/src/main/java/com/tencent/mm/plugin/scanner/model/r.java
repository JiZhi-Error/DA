package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.sdk.platformtools.Util;

public final class r {
    public static String a(Context context, n.a aVar) {
        AppMethodBeat.i(51634);
        k.b bVar = new k.b();
        bVar.appId = Wu(aVar.field_functionType);
        bVar.title = aVar.field_title;
        bVar.description = aVar.field_source;
        bVar.type = 10;
        bVar.url = aVar.field_shareurl;
        bVar.action = "";
        bVar.appName = n.am(context, aVar.field_type);
        bVar.thumburl = aVar.field_thumburl;
        bVar.ixg = aVar.field_type;
        bVar.ixh = n.c(aVar);
        String a2 = k.b.a(bVar, null, null);
        AppMethodBeat.o(51634);
        return a2;
    }

    public static String Wu(int i2) {
        if (i2 != 4 && i2 == 3) {
            return "wx482a4001c37e2b74";
        }
        return "wxfbc915ff7c30e335";
    }

    public static n.a fn(String str, int i2) {
        AppMethodBeat.i(51635);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(51635);
            return null;
        }
        int aMS = n.aMS(str);
        if (aMS == 3) {
            n.a fp = n.fp(str, i2);
            AppMethodBeat.o(51635);
            return fp;
        } else if (aMS == 4) {
            n.a aMT = n.aMT(str);
            AppMethodBeat.o(51635);
            return aMT;
        } else {
            AppMethodBeat.o(51635);
            return null;
        }
    }
}
