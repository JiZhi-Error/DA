package org.apache.commons.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.apache.commons.b.b;

public final class a {
    private static volatile b UgO = b.UgR;
    private final StringBuffer UgP;
    private final b UgQ;
    private final Object object;

    public a(Object obj, b bVar) {
        this(obj, bVar, (byte) 0);
    }

    private a(Object obj, b bVar, byte b2) {
        AppMethodBeat.i(40695);
        bVar = bVar == null ? UgO : bVar;
        StringBuffer stringBuffer = new StringBuffer(512);
        this.UgP = stringBuffer;
        this.UgQ = bVar;
        this.object = obj;
        if (obj != null) {
            if (bVar.UgY && obj != null) {
                b.gD(obj);
                if (bVar.UgZ) {
                    stringBuffer.append(b.bE(obj.getClass()));
                } else {
                    stringBuffer.append(obj.getClass().getName());
                }
            }
            if (bVar.Uha && obj != null) {
                b.gD(obj);
                stringBuffer.append('@');
                stringBuffer.append(Integer.toHexString(System.identityHashCode(obj)));
            }
            stringBuffer.append(bVar.But);
            if (bVar.Uhc) {
                bVar.c(stringBuffer);
            }
        }
        AppMethodBeat.o(40695);
    }

    public final a gB(Object obj) {
        AppMethodBeat.i(40696);
        this.UgQ.b(this.UgP, obj);
        AppMethodBeat.o(40696);
        return this;
    }

    public final String toString() {
        boolean z = false;
        AppMethodBeat.i(40697);
        if (this.object == null) {
            this.UgP.append(this.UgQ.Uhk);
        } else {
            b bVar = this.UgQ;
            StringBuffer stringBuffer = this.UgP;
            Object obj = this.object;
            if (!bVar.Uhd) {
                int length = stringBuffer.length();
                int length2 = bVar.Uhe.length();
                if (length > 0 && length2 > 0 && length >= length2) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            z = true;
                            break;
                        } else if (stringBuffer.charAt((length - 1) - i2) != bVar.Uhe.charAt((length2 - 1) - i2)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z) {
                        stringBuffer.setLength(length - length2);
                    }
                }
            }
            stringBuffer.append(bVar.Buu);
            b.gE(obj);
        }
        String stringBuffer2 = this.UgP.toString();
        AppMethodBeat.o(40697);
        return stringBuffer2;
    }
}
