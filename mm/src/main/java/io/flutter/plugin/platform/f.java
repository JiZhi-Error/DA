package io.flutter.plugin.platform;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class f implements e {
    private final Map<String, d> STi = new HashMap();

    f() {
        AppMethodBeat.i(9893);
        AppMethodBeat.o(9893);
    }

    @Override // io.flutter.plugin.platform.e
    public final boolean a(String str, d dVar) {
        AppMethodBeat.i(214883);
        if (this.STi.containsKey(str)) {
            AppMethodBeat.o(214883);
            return false;
        }
        this.STi.put(str, dVar);
        AppMethodBeat.o(214883);
        return true;
    }

    public final d bts(String str) {
        AppMethodBeat.i(214884);
        d dVar = this.STi.get(str);
        AppMethodBeat.o(214884);
        return dVar;
    }
}
