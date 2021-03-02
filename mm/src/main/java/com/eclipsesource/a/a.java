package com.eclipsesource.a;

import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.io.IOException;

public final class a {
    public static final h aZC = new c(BuildConfig.COMMAND);
    public static final h aZD = new c(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    public static final h aZE = new c("false");

    static {
        AppMethodBeat.i(74683);
        AppMethodBeat.o(74683);
    }

    public static h dA(int i2) {
        AppMethodBeat.i(74676);
        d dVar = new d(Integer.toString(i2, 10));
        AppMethodBeat.o(74676);
        return dVar;
    }

    public static h s(long j2) {
        AppMethodBeat.i(74677);
        d dVar = new d(Long.toString(j2, 10));
        AppMethodBeat.o(74677);
        return dVar;
    }

    public static h ab(float f2) {
        AppMethodBeat.i(74678);
        if (Float.isInfinite(f2) || Float.isNaN(f2)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
            AppMethodBeat.o(74678);
            throw illegalArgumentException;
        }
        d dVar = new d(aS(Float.toString(f2)));
        AppMethodBeat.o(74678);
        return dVar;
    }

    public static h d(double d2) {
        AppMethodBeat.i(74679);
        if (Double.isInfinite(d2) || Double.isNaN(d2)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
            AppMethodBeat.o(74679);
            throw illegalArgumentException;
        }
        d dVar = new d(aS(Double.toString(d2)));
        AppMethodBeat.o(74679);
        return dVar;
    }

    public static h aQ(String str) {
        AppMethodBeat.i(74680);
        if (str == null) {
            h hVar = aZC;
            AppMethodBeat.o(74680);
            return hVar;
        }
        g gVar = new g(str);
        AppMethodBeat.o(74680);
        return gVar;
    }

    public static h aL(boolean z) {
        return z ? aZD : aZE;
    }

    public static h aR(String str) {
        AppMethodBeat.i(74681);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("string is null");
            AppMethodBeat.o(74681);
            throw nullPointerException;
        }
        try {
            f fVar = new f(str);
            fVar.sy();
            fVar.sx();
            h sj = fVar.sj();
            fVar.sx();
            if (!fVar.sF()) {
                j aW = fVar.aW("Unexpected character");
                AppMethodBeat.o(74681);
                throw aW;
            }
            AppMethodBeat.o(74681);
            return sj;
        } catch (IOException e2) {
            RuntimeException runtimeException = new RuntimeException(e2);
            AppMethodBeat.o(74681);
            throw runtimeException;
        }
    }

    private static String aS(String str) {
        AppMethodBeat.i(74682);
        if (str.endsWith(".0")) {
            String substring = str.substring(0, str.length() - 2);
            AppMethodBeat.o(74682);
            return substring;
        }
        AppMethodBeat.o(74682);
        return str;
    }
}
