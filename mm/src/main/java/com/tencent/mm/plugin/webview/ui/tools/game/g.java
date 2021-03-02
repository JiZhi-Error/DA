package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;

public final class g {
    private static HashMap<String, g> Jrl = new HashMap<>();
    public long JqU;
    public long JqV;
    public long JqW;
    public long JqX;
    public long JqY;
    public long JqZ;
    public long Jra;
    public long Jrb;
    public long Jrc;
    public long Jrd;
    public long Jre;
    public long Jrf;
    public long Jrg;
    public long Jrh;
    public long Jri;
    public long Jrj;
    public long Jrk;
    public long nOC;
    public long startTime;
    public String url;

    static {
        AppMethodBeat.i(80894);
        AppMethodBeat.o(80894);
    }

    public static g baJ(String str) {
        AppMethodBeat.i(80878);
        if (Jrl.containsKey(str)) {
            Jrl.remove(str);
        }
        g gVar = new g();
        gVar.url = str;
        Jrl.put(str, gVar);
        AppMethodBeat.o(80878);
        return gVar;
    }

    public static g baK(String str) {
        AppMethodBeat.i(80879);
        if (Jrl.containsKey(str)) {
            g gVar = Jrl.get(str);
            AppMethodBeat.o(80879);
            return gVar;
        }
        g gVar2 = new g();
        gVar2.url = str;
        Jrl.put(str, gVar2);
        AppMethodBeat.o(80879);
        return gVar2;
    }

    public static g baL(String str) {
        AppMethodBeat.i(80880);
        g gVar = Jrl.get(str);
        AppMethodBeat.o(80880);
        return gVar;
    }

    public static g baM(String str) {
        AppMethodBeat.i(80881);
        g remove = Jrl.remove(str);
        AppMethodBeat.o(80881);
        return remove;
    }

    public static void bB(String str, long j2) {
        AppMethodBeat.i(182714);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(182714);
            return;
        }
        if (!ghg()) {
            c(9, str, j2);
        } else if (baL(str) != null) {
            baL(str).JqU = j2;
            try {
                com.tencent.mm.game.report.api.a.hhr.a(6, URLEncoder.encode(str), "", 0);
                AppMethodBeat.o(182714);
                return;
            } catch (Exception e2) {
                AppMethodBeat.o(182714);
                return;
            }
        }
        AppMethodBeat.o(182714);
    }

    public static void bC(String str, long j2) {
        AppMethodBeat.i(80882);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(80882);
            return;
        }
        if (!ghg()) {
            c(1, str, j2);
        } else if (baL(str) != null) {
            baL(str).startTime = j2;
            AppMethodBeat.o(80882);
            return;
        }
        AppMethodBeat.o(80882);
    }

    public static void bD(String str, long j2) {
        AppMethodBeat.i(80883);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(80883);
            return;
        }
        if (!ghg()) {
            c(2, str, j2);
        } else if (baL(str) != null) {
            baL(str).JqV = j2;
            AppMethodBeat.o(80883);
            return;
        }
        AppMethodBeat.o(80883);
    }

    public static void bE(String str, long j2) {
        AppMethodBeat.i(80884);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(80884);
            return;
        }
        if (!ghg()) {
            c(3, str, j2);
        } else if (baL(str) != null) {
            baL(str).JqW = j2;
            AppMethodBeat.o(80884);
            return;
        }
        AppMethodBeat.o(80884);
    }

    public static void bF(String str, long j2) {
        AppMethodBeat.i(80885);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(80885);
            return;
        }
        if (!ghg()) {
            c(4, str, j2);
        } else if (baL(str) != null) {
            baL(str).JqX = j2;
            AppMethodBeat.o(80885);
            return;
        }
        AppMethodBeat.o(80885);
    }

    public static void bG(String str, long j2) {
        AppMethodBeat.i(80886);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(80886);
            return;
        }
        if (!ghg()) {
            c(5, str, j2);
        } else if (baL(str) != null) {
            baL(str).JqY = j2;
            AppMethodBeat.o(80886);
            return;
        }
        AppMethodBeat.o(80886);
    }

    public static void bH(String str, long j2) {
        AppMethodBeat.i(80887);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(80887);
            return;
        }
        if (!ghg()) {
            c(6, str, j2);
        } else if (baL(str) != null) {
            baL(str).JqZ = j2;
            AppMethodBeat.o(80887);
            return;
        }
        AppMethodBeat.o(80887);
    }

    public static void bI(String str, long j2) {
        AppMethodBeat.i(80888);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(80888);
            return;
        }
        if (!ghg()) {
            c(7, str, j2);
        } else if (baL(str) != null) {
            baL(str).Jra = j2;
            AppMethodBeat.o(80888);
            return;
        }
        AppMethodBeat.o(80888);
    }

    public static void bJ(String str, long j2) {
        AppMethodBeat.i(80889);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(80889);
            return;
        }
        if (!ghg()) {
            c(8, str, j2);
        } else if (baL(str) != null) {
            baL(str).Jrb = j2;
            AppMethodBeat.o(80889);
            return;
        }
        AppMethodBeat.o(80889);
    }

    public static void bK(String str, long j2) {
        AppMethodBeat.i(80890);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(80890);
            return;
        }
        if (!ghg()) {
            c(10, str, j2);
        } else if (baL(str) != null) {
            baL(str).Jrc = j2;
            AppMethodBeat.o(80890);
            return;
        }
        AppMethodBeat.o(80890);
    }

    public static void bL(String str, long j2) {
        AppMethodBeat.i(211315);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(211315);
        } else if (ghg()) {
            g baL = baL(str);
            if (baL != null) {
                baL.Jrd = j2;
                baL.Jrh = j2;
            }
            AppMethodBeat.o(211315);
        } else {
            c(11, str, j2);
            AppMethodBeat.o(211315);
        }
    }

    private static Bundle b(int i2, String str, long j2) {
        AppMethodBeat.i(80891);
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        bundle.putString("url", str);
        bundle.putLong("time", j2);
        AppMethodBeat.o(80891);
        return bundle;
    }

    public static class a implements b<Bundle, Bundle> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(80877);
            Bundle bundle2 = bundle;
            int i2 = bundle2.getInt("type");
            String string = bundle2.getString("url");
            long j2 = bundle2.getLong("time", System.currentTimeMillis());
            switch (i2) {
                case 1:
                    g.bC(string, j2);
                    AppMethodBeat.o(80877);
                    return;
                case 2:
                    g.bD(string, j2);
                    AppMethodBeat.o(80877);
                    return;
                case 3:
                    g.bE(string, j2);
                    AppMethodBeat.o(80877);
                    return;
                case 4:
                    g.bF(string, j2);
                    AppMethodBeat.o(80877);
                    return;
                case 5:
                    g.bG(string, j2);
                    AppMethodBeat.o(80877);
                    return;
                case 6:
                    g.bH(string, j2);
                    AppMethodBeat.o(80877);
                    return;
                case 7:
                    g.bI(string, j2);
                    AppMethodBeat.o(80877);
                    return;
                case 8:
                    g.bJ(string, j2);
                    AppMethodBeat.o(80877);
                    return;
                case 9:
                    g.bB(string, j2);
                    AppMethodBeat.o(80877);
                    return;
                case 10:
                    g.bK(string, j2);
                    AppMethodBeat.o(80877);
                    return;
                case 11:
                    g.bL(string, j2);
                    break;
            }
            AppMethodBeat.o(80877);
        }
    }

    private static boolean ghg() {
        AppMethodBeat.i(80892);
        if (MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
            AppMethodBeat.o(80892);
            return true;
        }
        AppMethodBeat.o(80892);
        return false;
    }

    private static void c(int i2, String str, long j2) {
        AppMethodBeat.i(80893);
        ToolsProcessIPCService.a(b(i2, str, j2), a.class, null);
        AppMethodBeat.o(80893);
    }
}
