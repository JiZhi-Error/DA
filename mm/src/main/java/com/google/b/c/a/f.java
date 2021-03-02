package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class f implements g {
    f() {
    }

    @Override // com.google.b.c.a.g
    public final void a(h hVar) {
        boolean z = true;
        AppMethodBeat.i(12359);
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.In()) {
                break;
            }
            char Im = hVar.Im();
            if (Im >= ' ' && Im <= '?') {
                sb.append(Im);
            } else if (Im < '@' || Im > '^') {
                j.k(Im);
            } else {
                sb.append((char) (Im - '@'));
            }
            hVar.pos++;
            if (sb.length() >= 4) {
                hVar.cs(w(sb));
                sb.delete(0, 4);
                if (j.b(hVar.msg, hVar.pos, 4) != 4) {
                    hVar.cdF = 0;
                    break;
                }
            }
        }
        sb.append((char) 31);
        try {
            int length = sb.length();
            if (length != 0) {
                if (length == 1) {
                    hVar.Iq();
                    int length2 = hVar.cdG.cdP - hVar.cdE.length();
                    if (hVar.Ip() == 0 && length2 <= 2) {
                        hVar.cdF = 0;
                        AppMethodBeat.o(12359);
                        return;
                    }
                }
                if (length > 4) {
                    IllegalStateException illegalStateException = new IllegalStateException("Count must not exceed 4");
                    AppMethodBeat.o(12359);
                    throw illegalStateException;
                }
                int i2 = length - 1;
                String w = w(sb);
                if (!(!hVar.In()) || i2 > 2) {
                    z = false;
                }
                if (i2 <= 2) {
                    hVar.hi(hVar.cdE.length() + i2);
                    if (hVar.cdG.cdP - hVar.cdE.length() >= 3) {
                        hVar.hi(hVar.cdE.length() + w.length());
                        z = false;
                    }
                }
                if (z) {
                    hVar.cdG = null;
                    hVar.pos -= i2;
                } else {
                    hVar.cs(w);
                }
                hVar.cdF = 0;
                AppMethodBeat.o(12359);
            }
        } finally {
            hVar.cdF = 0;
            AppMethodBeat.o(12359);
        }
    }

    private static String w(CharSequence charSequence) {
        char c2;
        char c3 = 0;
        AppMethodBeat.i(12360);
        int length = charSequence.length() + 0;
        if (length == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("StringBuilder must not be empty");
            AppMethodBeat.o(12360);
            throw illegalStateException;
        }
        char charAt = charSequence.charAt(0);
        char charAt2 = length >= 2 ? charSequence.charAt(1) : 0;
        if (length >= 3) {
            c2 = charSequence.charAt(2);
        } else {
            c2 = 0;
        }
        if (length >= 4) {
            c3 = charSequence.charAt(3);
        }
        int i2 = c3 + (c2 << 6) + (charAt2 << '\f') + (charAt << 18);
        char c4 = (char) ((i2 >> 8) & 255);
        char c5 = (char) (i2 & 255);
        StringBuilder sb = new StringBuilder(3);
        sb.append((char) ((i2 >> 16) & 255));
        if (length >= 2) {
            sb.append(c4);
        }
        if (length >= 3) {
            sb.append(c5);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(12360);
        return sb2;
    }
}
