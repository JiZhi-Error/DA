package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class n extends c {
    n() {
    }

    @Override // com.google.b.c.a.c
    public final int Ij() {
        return 3;
    }

    @Override // com.google.b.c.a.g, com.google.b.c.a.c
    public final void a(h hVar) {
        AppMethodBeat.i(12287);
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.In()) {
                break;
            }
            char Im = hVar.Im();
            hVar.pos++;
            a(Im, sb);
            if (sb.length() % 3 == 0) {
                a(hVar, sb);
                int b2 = j.b(hVar.msg, hVar.pos, 3);
                if (b2 != 3) {
                    hVar.cdF = b2;
                    break;
                }
            }
        }
        b(hVar, sb);
        AppMethodBeat.o(12287);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.b.c.a.c
    public final int a(char c2, StringBuilder sb) {
        AppMethodBeat.i(12288);
        if (c2 == '\r') {
            sb.append((char) 0);
        } else if (c2 == '*') {
            sb.append((char) 1);
        } else if (c2 == '>') {
            sb.append((char) 2);
        } else if (c2 == ' ') {
            sb.append((char) 3);
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
        } else if (c2 < 'A' || c2 > 'Z') {
            j.k(c2);
        } else {
            sb.append((char) ((c2 - 'A') + 14));
        }
        AppMethodBeat.o(12288);
        return 1;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.b.c.a.c
    public final void b(h hVar, StringBuilder sb) {
        AppMethodBeat.i(12289);
        hVar.Iq();
        int length = hVar.cdG.cdP - hVar.cdE.length();
        hVar.pos -= sb.length();
        if (hVar.Ip() > 1 || length > 1 || hVar.Ip() != length) {
            hVar.g(254);
        }
        if (hVar.cdF < 0) {
            hVar.cdF = 0;
        }
        AppMethodBeat.o(12289);
    }
}
