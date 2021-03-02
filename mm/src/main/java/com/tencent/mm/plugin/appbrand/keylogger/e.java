package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e implements c {
    private static final Pattern mPj = Pattern.compile(String.format("%s(.*)%s", "<kLog>", "</kLog>"));
    c mPk = null;

    static {
        AppMethodBeat.i(221311);
        AppMethodBeat.o(221311);
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.c
    public final void g(String str, String str2, Object... objArr) {
        AppMethodBeat.i(221308);
        if (this.mPk == null) {
            AppMethodBeat.o(221308);
            return;
        }
        this.mPk.g(str, String.format("%s%s%s", "<kLog>", str2, "</kLog>"), objArr);
        AppMethodBeat.o(221308);
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.base.c
    public final List<String> V(String str, long j2) {
        AppMethodBeat.i(221309);
        if (this.mPk == null) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(221309);
            return arrayList;
        }
        List<String> V = this.mPk.V(str, j2);
        AppMethodBeat.o(221309);
        return V;
    }

    public static String abS(String str) {
        AppMethodBeat.i(221310);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(221310);
            return str;
        }
        Matcher matcher = mPj.matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            AppMethodBeat.o(221310);
            return group;
        }
        AppMethodBeat.o(221310);
        return null;
    }
}
