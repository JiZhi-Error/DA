package com.tencent.mm.compatible.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;

public final class a {

    /* renamed from: com.tencent.mm.compatible.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0298a {
        void run();
    }

    public static boolean a(int i2, AbstractC0298a aVar) {
        AppMethodBeat.i(157475);
        if (d.oD(i2)) {
            aVar.run();
            AppMethodBeat.o(157475);
            return true;
        }
        AppMethodBeat.o(157475);
        return false;
    }
}
