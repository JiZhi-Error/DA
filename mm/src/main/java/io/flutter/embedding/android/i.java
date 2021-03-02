package io.flutter.embedding.android;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum i {
    surface,
    texture,
    image;

    public static i valueOf(String str) {
        AppMethodBeat.i(215037);
        i iVar = (i) Enum.valueOf(i.class, str);
        AppMethodBeat.o(215037);
        return iVar;
    }

    static {
        AppMethodBeat.i(215038);
        AppMethodBeat.o(215038);
    }
}
