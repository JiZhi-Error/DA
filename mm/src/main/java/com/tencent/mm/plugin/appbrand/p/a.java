package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;

public interface a {

    /* renamed from: com.tencent.mm.plugin.appbrand.p.a$a  reason: collision with other inner class name */
    public interface AbstractC0766a {
        void b(c cVar);
    }

    public interface b {
        void a(d dVar);
    }

    void a(String str, b bVar);

    void a(String str, b bVar, AbstractC0766a aVar);

    String acN(String str);

    boolean bPn();

    public enum d {
        OK,
        FAIL,
        CANCEL,
        MODULE_NOT_FOUND;

        public static d valueOf(String str) {
            AppMethodBeat.i(134930);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(134930);
            return dVar;
        }

        static {
            AppMethodBeat.i(134931);
            AppMethodBeat.o(134931);
        }
    }

    public static class c implements a {
        @Override // com.tencent.mm.plugin.appbrand.p.a
        public final boolean bPn() {
            return false;
        }

        @Override // com.tencent.mm.plugin.appbrand.p.a
        public final String acN(String str) {
            return ModulePkgInfo.MAIN_MODULE_NAME;
        }

        @Override // com.tencent.mm.plugin.appbrand.p.a
        public final void a(String str, b bVar, AbstractC0766a aVar) {
            AppMethodBeat.i(219353);
            a(str, bVar);
            AppMethodBeat.o(219353);
        }

        @Override // com.tencent.mm.plugin.appbrand.p.a
        public void a(String str, b bVar) {
            AppMethodBeat.i(176556);
            if (bVar != null) {
                bVar.a(d.OK);
            }
            AppMethodBeat.o(176556);
        }
    }
}
