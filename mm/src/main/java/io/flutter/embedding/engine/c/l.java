package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.b;
import io.flutter.plugin.a.f;
import java.util.HashMap;

public final class l {
    public final b<Object> SPQ;

    public l(DartExecutor dartExecutor) {
        AppMethodBeat.i(10235);
        this.SPQ = new b<>(dartExecutor, "flutter/system", f.SSk);
        AppMethodBeat.o(10235);
    }

    public final void hxj() {
        AppMethodBeat.i(10236);
        a.hwd();
        HashMap hashMap = new HashMap(1);
        hashMap.put("type", "memoryPressure");
        this.SPQ.eN(hashMap);
        AppMethodBeat.o(10236);
    }
}
