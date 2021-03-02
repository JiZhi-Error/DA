package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class m extends c {
    m() {
    }

    @Override // com.google.b.c.a.c
    public final int Ij() {
        return 2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.b.c.a.c
    public final int a(char c2, StringBuilder sb) {
        AppMethodBeat.i(12236);
        if (c2 == ' ') {
            sb.append((char) 3);
            AppMethodBeat.o(12236);
            return 1;
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            AppMethodBeat.o(12236);
            return 1;
        } else if (c2 >= 'a' && c2 <= 'z') {
            sb.append((char) ((c2 - 'a') + 14));
            AppMethodBeat.o(12236);
            return 1;
        } else if (c2 >= 0 && c2 <= 31) {
            sb.append((char) 0);
            sb.append(c2);
            AppMethodBeat.o(12236);
            return 2;
        } else if (c2 >= '!' && c2 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c2 - '!'));
            AppMethodBeat.o(12236);
            return 2;
        } else if (c2 >= ':' && c2 <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c2 - ':') + 15));
            AppMethodBeat.o(12236);
            return 2;
        } else if (c2 >= '[' && c2 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c2 - '[') + 22));
            AppMethodBeat.o(12236);
            return 2;
        } else if (c2 == '`') {
            sb.append((char) 2);
            sb.append((char) (c2 - '`'));
            AppMethodBeat.o(12236);
            return 2;
        } else if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) 2);
            sb.append((char) ((c2 - 'A') + 1));
            AppMethodBeat.o(12236);
            return 2;
        } else if (c2 >= '{' && c2 <= 127) {
            sb.append((char) 2);
            sb.append((char) ((c2 - '{') + 27));
            AppMethodBeat.o(12236);
            return 2;
        } else if (c2 >= 128) {
            sb.append("\u0001\u001e");
            int a2 = a((char) (c2 - 128), sb) + 2;
            AppMethodBeat.o(12236);
            return a2;
        } else {
            j.k(c2);
            AppMethodBeat.o(12236);
            return -1;
        }
    }
}
