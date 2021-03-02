package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

public final class t {
    public static final t pDu = new t();

    static {
        AppMethodBeat.i(6737);
        AppMethodBeat.o(6737);
    }

    private t() {
    }

    public static final String aF(int i2, String str) {
        AppMethodBeat.i(6733);
        p.h(str, "uid");
        String str2 = b.coS() + i2 + '_' + str + ".html";
        Log.i(u.TAG, "genTmplPath() tmplPath:".concat(String.valueOf(str2)));
        AppMethodBeat.o(6733);
        return str2;
    }

    public static /* synthetic */ String aG(int i2, String str) {
        AppMethodBeat.i(6735);
        String u = u(i2, str, "index.html");
        AppMethodBeat.o(6735);
        return u;
    }

    public static final String u(int i2, String str, String str2) {
        AppMethodBeat.i(6734);
        p.h(str, "uid");
        p.h(str2, "file");
        String str3 = b.coS() + i2 + '_' + str + '/' + str2;
        Log.i(u.TAG, "genTmplPath() tmplPath:".concat(String.valueOf(str3)));
        AppMethodBeat.o(6734);
        return str3;
    }

    public static final String aH(int i2, String str) {
        AppMethodBeat.i(6736);
        p.h(str, "uid");
        String str2 = b.coS() + i2 + '_' + str + ".fd";
        Log.i(u.TAG, "genTmplPath() genTmplFDPath:".concat(String.valueOf(str2)));
        AppMethodBeat.o(6736);
        return str2;
    }
}
