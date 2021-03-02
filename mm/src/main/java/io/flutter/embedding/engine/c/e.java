package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.o;
import java.util.HashMap;

public final class e {
    public a SQc;
    private final k.c SQd = new k.c() {
        /* class io.flutter.embedding.engine.c.e.AnonymousClass1 */

        @Override // io.flutter.plugin.a.k.c
        public final void a(j jVar, k.d dVar) {
            AppMethodBeat.i(214999);
            if (e.this.SQc == null) {
                AppMethodBeat.o(214999);
                return;
            }
            String str = jVar.method;
            new StringBuilder("Received '").append(str).append("' message.");
            io.flutter.a.hwd();
            char c2 = 65535;
            try {
                switch (str.hashCode()) {
                    case -1307105544:
                        if (str.equals("activateSystemCursor")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        try {
                            e.this.SQc.btg((String) ((HashMap) jVar.SxX).get("kind"));
                            dVar.ba(Boolean.TRUE);
                            break;
                        } catch (Exception e2) {
                            dVar.b("error", "Error when setting cursors: " + e2.getMessage(), null);
                            AppMethodBeat.o(214999);
                            return;
                        }
                }
                AppMethodBeat.o(214999);
            } catch (Exception e3) {
                dVar.b("error", "Unhandled error: " + e3.getMessage(), null);
                AppMethodBeat.o(214999);
            }
        }
    };
    public final k bbv;

    public interface a {
        void btg(String str);
    }

    public e(DartExecutor dartExecutor) {
        AppMethodBeat.i(214987);
        this.bbv = new k(dartExecutor, "flutter/mousecursor", o.SSr);
        this.bbv.a(this.SQd);
        AppMethodBeat.o(214987);
    }
}
