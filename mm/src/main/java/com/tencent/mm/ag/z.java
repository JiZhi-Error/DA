package com.tencent.mm.ag;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface z {
    void B(Bundle bundle);

    void a(a aVar);

    boolean aSC();

    boolean aSD();

    boolean aSE();

    void b(a aVar);

    void c(a aVar);

    public enum a {
        del,
        trans,
        fav;

        public static a valueOf(String str) {
            AppMethodBeat.i(150134);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(150134);
            return aVar;
        }

        static {
            AppMethodBeat.i(150135);
            AppMethodBeat.o(150135);
        }
    }
}
