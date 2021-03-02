package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.bx;

public interface h extends g {
    public static final h nIG = new h() {
        /* class com.tencent.mm.plugin.appbrand.report.model.h.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.report.model.h
        public final a bUH() {
            return null;
        }

        @Override // com.tencent.mm.plugin.appbrand.report.model.h
        public final boolean aeN(String str) {
            return false;
        }

        @Override // com.tencent.mm.plugin.appbrand.report.model.h
        public final a s(ag agVar) {
            return null;
        }

        @Override // com.tencent.mm.plugin.appbrand.report.model.g
        public final void a(ag agVar, ag agVar2, bx bxVar) {
        }

        @Override // com.tencent.mm.plugin.appbrand.report.model.g
        public final void d(ag agVar) {
        }

        @Override // com.tencent.mm.plugin.appbrand.report.model.g
        public final void e(ag agVar) {
        }
    };

    boolean aeN(String str);

    a bUH();

    a s(ag agVar);

    public static class a {
        int dKv;
        public c nIH;
        public b nII;
        public String path;

        a(ag agVar) {
            AppMethodBeat.i(48118);
            this.dKv = agVar.hashCode();
            this.path = agVar.nna;
            AppMethodBeat.o(48118);
        }
    }

    public static class c {
        public String path;
        public int type;

        c(int i2, String str) {
            this.type = i2;
            this.path = str;
        }

        c(int i2) {
            this(i2, null);
        }
    }

    public static class b {
        public String path;

        b(String str) {
            this.path = str;
        }
    }
}
