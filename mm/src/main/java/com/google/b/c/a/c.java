package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class c implements g {
    c() {
    }

    public int Ij() {
        return 1;
    }

    @Override // com.google.b.c.a.g
    public void a(h hVar) {
        int b2;
        AppMethodBeat.i(12354);
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.In()) {
                break;
            }
            char Im = hVar.Im();
            hVar.pos++;
            int a2 = a(Im, sb);
            int length = ((sb.length() / 3) << 1) + hVar.cdE.length();
            hVar.hi(length);
            int i2 = hVar.cdG.cdP - length;
            if (hVar.In()) {
                if (sb.length() % 3 == 0 && (b2 = j.b(hVar.msg, hVar.pos, Ij())) != Ij()) {
                    hVar.cdF = b2;
                    break;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (i2 < 2 || i2 > 2)) {
                    a2 = a(hVar, sb, sb2, a2);
                }
                while (sb.length() % 3 == 1 && ((a2 <= 3 && i2 != 1) || a2 > 3)) {
                    a2 = a(hVar, sb, sb2, a2);
                }
            }
        }
        b(hVar, sb);
        AppMethodBeat.o(12354);
    }

    private int a(h hVar, StringBuilder sb, StringBuilder sb2, int i2) {
        AppMethodBeat.i(12355);
        int length = sb.length();
        sb.delete(length - i2, length);
        hVar.pos--;
        int a2 = a(hVar.Im(), sb2);
        hVar.cdG = null;
        AppMethodBeat.o(12355);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public void b(h hVar, StringBuilder sb) {
        AppMethodBeat.i(12357);
        int length = sb.length() % 3;
        int length2 = ((sb.length() / 3) << 1) + hVar.cdE.length();
        hVar.hi(length2);
        int i2 = hVar.cdG.cdP - length2;
        if (length == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                a(hVar, sb);
            }
            if (hVar.In()) {
                hVar.g(254);
            }
        } else if (i2 == 1 && length == 1) {
            while (sb.length() >= 3) {
                a(hVar, sb);
            }
            if (hVar.In()) {
                hVar.g(254);
            }
            hVar.pos--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                a(hVar, sb);
            }
            if (i2 > 0 || hVar.In()) {
                hVar.g(254);
            }
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Unexpected case. Please report!");
            AppMethodBeat.o(12357);
            throw illegalStateException;
        }
        hVar.cdF = 0;
        AppMethodBeat.o(12357);
    }

    /* access modifiers changed from: package-private */
    public int a(char c2, StringBuilder sb) {
        AppMethodBeat.i(12358);
        if (c2 == ' ') {
            sb.append((char) 3);
            AppMethodBeat.o(12358);
            return 1;
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            AppMethodBeat.o(12358);
            return 1;
        } else if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) ((c2 - 'A') + 14));
            AppMethodBeat.o(12358);
            return 1;
        } else if (c2 >= 0 && c2 <= 31) {
            sb.append((char) 0);
            sb.append(c2);
            AppMethodBeat.o(12358);
            return 2;
        } else if (c2 >= '!' && c2 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c2 - '!'));
            AppMethodBeat.o(12358);
            return 2;
        } else if (c2 >= ':' && c2 <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c2 - ':') + 15));
            AppMethodBeat.o(12358);
            return 2;
        } else if (c2 >= '[' && c2 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c2 - '[') + 22));
            AppMethodBeat.o(12358);
            return 2;
        } else if (c2 >= '`' && c2 <= 127) {
            sb.append((char) 2);
            sb.append((char) (c2 - '`'));
            AppMethodBeat.o(12358);
            return 2;
        } else if (c2 >= 128) {
            sb.append("\u0001\u001e");
            int a2 = a((char) (c2 - 128), sb) + 2;
            AppMethodBeat.o(12358);
            return a2;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal character: ".concat(String.valueOf(c2)));
            AppMethodBeat.o(12358);
            throw illegalArgumentException;
        }
    }

    static void a(h hVar, StringBuilder sb) {
        AppMethodBeat.i(12356);
        int charAt = (sb.charAt(0) * 1600) + (sb.charAt(1) * '(') + sb.charAt(2) + 1;
        hVar.cs(new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)}));
        sb.delete(0, 3);
        AppMethodBeat.o(12356);
    }
}
