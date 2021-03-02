package io.flutter.embedding.android;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    static final String crl = a.opaque.name();

    static {
        AppMethodBeat.i(215076);
        AppMethodBeat.o(215076);
    }

    public enum a {
        opaque,
        transparent;

        public static a valueOf(String str) {
            AppMethodBeat.i(215034);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(215034);
            return aVar;
        }

        static {
            AppMethodBeat.i(215035);
            AppMethodBeat.o(215035);
        }
    }
}
