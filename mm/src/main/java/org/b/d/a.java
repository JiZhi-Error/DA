package org.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

public final class a {
    public final String Uib;
    public final String Uic;
    public final String Uid;
    public final h Uif;
    private final OutputStream Uig;
    public final String scope;

    public a(String str, String str2, String str3, h hVar, String str4, OutputStream outputStream) {
        this.Uib = str;
        this.Uic = str2;
        this.Uid = str3;
        this.Uif = hVar;
        this.scope = str4;
        this.Uig = outputStream;
    }

    public final boolean hQa() {
        return this.scope != null;
    }

    public final void log(String str) {
        AppMethodBeat.i(40544);
        if (this.Uig != null) {
            try {
                this.Uig.write((String.valueOf(str) + "\n").getBytes("UTF8"));
                AppMethodBeat.o(40544);
            } catch (Exception e2) {
                RuntimeException runtimeException = new RuntimeException("there were problems while writting to the debug stream", e2);
                AppMethodBeat.o(40544);
                throw runtimeException;
            }
        } else {
            AppMethodBeat.o(40544);
        }
    }
}
