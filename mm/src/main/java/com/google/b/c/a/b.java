package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.cr;

/* access modifiers changed from: package-private */
public final class b implements g {
    b() {
    }

    @Override // com.google.b.c.a.g
    public final void a(h hVar) {
        AppMethodBeat.i(12384);
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!hVar.In()) {
                break;
            }
            sb.append(hVar.Im());
            hVar.pos++;
            int b2 = j.b(hVar.msg, hVar.pos, 5);
            if (b2 != 5) {
                hVar.cdF = b2;
                break;
            }
        }
        int length = sb.length() - 1;
        int length2 = hVar.cdE.length() + length + 1;
        hVar.hi(length2);
        boolean z = hVar.cdG.cdP - length2 > 0;
        if (hVar.In() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / 250) + cr.CTRL_INDEX));
                sb.insert(1, (char) (length % 250));
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
                AppMethodBeat.o(12384);
                throw illegalStateException;
            }
        }
        int length3 = sb.length();
        for (int i2 = 0; i2 < length3; i2++) {
            int charAt = sb.charAt(i2) + (((hVar.cdE.length() + 1) * 149) % 255) + 1;
            if (charAt > 255) {
                charAt -= 256;
            }
            hVar.g((char) charAt);
        }
        AppMethodBeat.o(12384);
    }
}
