package com.bumptech.glide.load.c;

import com.bumptech.glide.load.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Map;

public interface h {
    @Deprecated
    public static final h aJW = new h() {
        /* class com.bumptech.glide.load.c.h.AnonymousClass1 */

        @Override // com.bumptech.glide.load.c.h
        public final Map<String, String> getHeaders() {
            AppMethodBeat.i(77244);
            Map<String, String> emptyMap = Collections.emptyMap();
            AppMethodBeat.o(77244);
            return emptyMap;
        }
    };
    public static final h aJX;

    Map<String, String> getHeaders();

    static {
        j.a aVar = new j.a();
        aVar.aKb = true;
        aJX = new j(aVar.headers);
    }
}
