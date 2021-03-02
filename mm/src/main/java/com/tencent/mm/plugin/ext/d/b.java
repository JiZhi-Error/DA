package com.tencent.mm.plugin.ext.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {

    /* renamed from: com.tencent.mm.plugin.ext.d.b$b  reason: collision with other inner class name */
    public enum EnumC1032b {
        BLACK,
        WHITE,
        NONE;

        public static EnumC1032b valueOf(String str) {
            AppMethodBeat.i(24472);
            EnumC1032b bVar = (EnumC1032b) Enum.valueOf(EnumC1032b.class, str);
            AppMethodBeat.o(24472);
            return bVar;
        }

        static {
            AppMethodBeat.i(24473);
            AppMethodBeat.o(24473);
        }
    }

    /* access modifiers changed from: package-private */
    public enum a {
        PREFIX,
        SUBDOMAIN,
        DOMAIN;

        public static a valueOf(String str) {
            AppMethodBeat.i(24469);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(24469);
            return aVar;
        }

        static {
            AppMethodBeat.i(24470);
            AppMethodBeat.o(24470);
        }
    }
}
