package com.danikula.videocache.headers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class EmptyHeadersInjector implements HeaderInjector {
    @Override // com.danikula.videocache.headers.HeaderInjector
    public Map<String, String> addHeaders(String str) {
        AppMethodBeat.i(223215);
        HashMap hashMap = new HashMap();
        AppMethodBeat.o(223215);
        return hashMap;
    }
}
