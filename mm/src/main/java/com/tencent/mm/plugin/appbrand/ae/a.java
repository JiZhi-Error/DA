package com.tencent.mm.plugin.appbrand.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.d.d;

public interface a {
    void b(d dVar);

    public enum b {
        CLIENT,
        SERVER;

        public static b valueOf(String str) {
            AppMethodBeat.i(156602);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(156602);
            return bVar;
        }

        static {
            AppMethodBeat.i(156603);
            AppMethodBeat.o(156603);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ae.a$a  reason: collision with other inner class name */
    public enum EnumC0534a {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED;

        public static EnumC0534a valueOf(String str) {
            AppMethodBeat.i(156599);
            EnumC0534a aVar = (EnumC0534a) Enum.valueOf(EnumC0534a.class, str);
            AppMethodBeat.o(156599);
            return aVar;
        }

        static {
            AppMethodBeat.i(156600);
            AppMethodBeat.o(156600);
        }
    }
}
