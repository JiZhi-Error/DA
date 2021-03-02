package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class e {
    public static final a Ufw = new a();

    static {
        AppMethodBeat.i(40736);
        AppMethodBeat.o(40736);
    }

    public static void a(StringBuffer stringBuffer, Object obj) {
        AppMethodBeat.i(40734);
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException("Cannot get the toString of a null identity");
            AppMethodBeat.o(40734);
            throw nullPointerException;
        }
        stringBuffer.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
        AppMethodBeat.o(40734);
    }

    public static String toString(Object obj) {
        AppMethodBeat.i(40735);
        if (obj == null) {
            AppMethodBeat.o(40735);
            return "";
        }
        String obj2 = obj.toString();
        AppMethodBeat.o(40735);
        return obj2;
    }

    public static class a implements Serializable {
        a() {
        }

        private Object readResolve() {
            return e.Ufw;
        }
    }
}
