package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface p {

    public enum a {
        NONE,
        UNKNOWN,
        MISSING_PARAMS,
        NO_SUCH_KEY,
        QUOTA_REACHED,
        MEMORY_ISSUE;

        public static a valueOf(String str) {
            AppMethodBeat.i(146953);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(146953);
            return aVar;
        }

        static {
            AppMethodBeat.i(146954);
            AppMethodBeat.o(146954);
        }
    }
}
