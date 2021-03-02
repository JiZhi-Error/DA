package io.flutter.embedding.engine;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private static b SOl;
    private final Map<String, a> SOm = new HashMap();

    public static b hwG() {
        AppMethodBeat.i(10116);
        if (SOl == null) {
            SOl = new b();
        }
        b bVar = SOl;
        AppMethodBeat.o(10116);
        return bVar;
    }

    b() {
        AppMethodBeat.i(10117);
        AppMethodBeat.o(10117);
    }

    public final a bta(String str) {
        AppMethodBeat.i(10118);
        a aVar = this.SOm.get(str);
        AppMethodBeat.o(10118);
        return aVar;
    }

    public final void btb(String str) {
        AppMethodBeat.i(10119);
        this.SOm.remove(str);
        AppMethodBeat.o(10119);
    }
}
