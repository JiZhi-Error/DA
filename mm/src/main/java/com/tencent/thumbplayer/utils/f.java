package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class f<K, V> {
    public Map<K, V> map = new HashMap();

    public f() {
        AppMethodBeat.i(189634);
        AppMethodBeat.o(189634);
    }

    public final f<K, V> S(K k, V v) {
        AppMethodBeat.i(189635);
        this.map.put(k, v);
        AppMethodBeat.o(189635);
        return this;
    }
}
