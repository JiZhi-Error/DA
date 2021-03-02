package com.tencent.mm.plugin.appbrand.g.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c.b.d;
import com.tencent.mm.plugin.appbrand.g.c.d;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private boolean enable;
    private String lkC;
    private int lkD;
    Map<String, com.tencent.mm.plugin.appbrand.g.c.b.c> lkE;
    Map<String, com.tencent.mm.plugin.appbrand.g.c.b.c> lkF;
    private a lkG;

    public interface a {
        boolean b(d dVar);
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    public static class b {
        private static c lkM = new c((byte) 0);

        static {
            AppMethodBeat.i(158964);
            AppMethodBeat.o(158964);
        }
    }

    private c() {
        AppMethodBeat.i(158965);
        this.enable = false;
        this.lkG = new a() {
            /* class com.tencent.mm.plugin.appbrand.g.c.c.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.appbrand.g.c.c.a
            public final boolean b(d dVar) {
                AppMethodBeat.i(158963);
                synchronized (a.class) {
                    try {
                        String str = dVar.llp.get("SID");
                        com.tencent.mm.plugin.appbrand.g.c.b.c cVar = null;
                        String str2 = dVar.llo;
                        char c2 = 65535;
                        switch (str2.hashCode()) {
                            case -2006516997:
                                if (str2.equals("avtEvent")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case -1725405015:
                                if (str2.equals("rdcEvent")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                cVar = c.this.lkE.get(str);
                                break;
                            case 1:
                                cVar = c.this.lkF.get(str);
                                break;
                        }
                        if (cVar == null || cVar.lln == null) {
                            AppMethodBeat.o(158963);
                            return true;
                        }
                        return cVar.lln.a(dVar);
                    } finally {
                        AppMethodBeat.o(158963);
                    }
                }
            }
        };
        this.lkE = new HashMap();
        this.lkF = new HashMap();
        AppMethodBeat.o(158965);
    }

    public static c bBw() {
        AppMethodBeat.i(260037);
        c cVar = b.lkM;
        AppMethodBeat.o(260037);
        return cVar;
    }

    public final boolean enable() {
        AppMethodBeat.i(158967);
        this.enable = true;
        d dVar = d.c.lkO;
        dVar.lkG = this.lkG;
        dVar.start();
        this.lkC = dVar.ip;
        this.lkD = dVar.port;
        AppMethodBeat.o(158967);
        return true;
    }

    public final boolean disable() {
        AppMethodBeat.i(158968);
        this.enable = false;
        d dVar = d.c.lkO;
        dVar.lkG = null;
        dVar.stop();
        this.lkE.clear();
        this.lkF.clear();
        AppMethodBeat.o(158968);
        return true;
    }

    public final String Yc(String str) {
        AppMethodBeat.i(158969);
        String str2 = HttpWrapperBase.PROTOCAL_HTTP + this.lkC + ":" + this.lkD + str;
        AppMethodBeat.o(158969);
        return str2;
    }
}
