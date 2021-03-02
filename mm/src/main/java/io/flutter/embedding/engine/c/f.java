package io.flutter.embedding.engine.c;

import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.g;
import io.flutter.plugin.a.k;

public final class f {
    public final k bbv;

    public f(DartExecutor dartExecutor) {
        AppMethodBeat.i(10237);
        this.bbv = new k(dartExecutor, "flutter/navigation", g.SSl);
        AppMethodBeat.o(10237);
    }

    public final void setInitialRoute(String str) {
        AppMethodBeat.i(10238);
        new StringBuilder("Sending message to set initial route to '").append(str).append("'");
        a.hwd();
        this.bbv.a("setInitialRoute", str, null);
        AppMethodBeat.o(10238);
    }

    public final void dLr() {
        AppMethodBeat.i(Task.EXTRAS_LIMIT_BYTES);
        a.hwd();
        this.bbv.a("popRoute", null, null);
        AppMethodBeat.o(Task.EXTRAS_LIMIT_BYTES);
    }
}
