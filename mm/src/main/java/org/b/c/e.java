package org.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.b.d.c;
import org.b.g.d;

public final class e implements d {
    @Override // org.b.c.d
    public final String a(c cVar) {
        AppMethodBeat.i(40506);
        d.j(cVar, "Cannot extract a header from a null object");
        if (cVar.Uik == null || cVar.Uik.size() <= 0) {
            org.b.b.c cVar2 = new org.b.b.c(cVar);
            AppMethodBeat.o(40506);
            throw cVar2;
        }
        Map<String, String> map = cVar.Uik;
        StringBuffer stringBuffer = new StringBuffer(map.size() * 20);
        stringBuffer.append("OAuth ");
        for (String str : map.keySet()) {
            if (stringBuffer.length() > 6) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(String.format("%s=\"%s\"", str, org.b.g.c.encode(map.get(str))));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(40506);
        return stringBuffer2;
    }
}
