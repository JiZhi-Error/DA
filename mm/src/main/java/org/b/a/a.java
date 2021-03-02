package org.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import org.b.b.b;
import org.b.d.h;
import org.b.g.d;

public final class a {
    public String Uib;
    public String Uic;
    public String Uid = "oob";
    public org.b.a.a.a Uie;
    public h Uif = h.Header;
    public OutputStream Uig = null;
    public String scope;

    public static org.b.a.a.a bH(Class<? extends org.b.a.a.a> cls) {
        AppMethodBeat.i(40502);
        d.j(cls, "Api class cannot be null");
        try {
            org.b.a.a.a aVar = (org.b.a.a.a) cls.newInstance();
            AppMethodBeat.o(40502);
            return aVar;
        } catch (Exception e2) {
            b bVar = new b("Error while creating the Api object", e2);
            AppMethodBeat.o(40502);
            throw bVar;
        }
    }
}
