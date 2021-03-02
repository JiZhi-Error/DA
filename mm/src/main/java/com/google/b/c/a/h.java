package com.google.b.c.a;

import com.google.b.b;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

/* access modifiers changed from: package-private */
public final class h {
    l cdB;
    b cdC;
    b cdD;
    final StringBuilder cdE;
    int cdF;
    k cdG;
    int cdH;
    final String msg;
    int pos;

    h(String str) {
        AppMethodBeat.i(12272);
        byte[] bytes = str.getBytes(Charset.forName(KindaConfigCacheStg.SAVE_CHARSET));
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = (char) (bytes[i2] & 255);
            if (c2 != '?' || str.charAt(i2) == '?') {
                sb.append(c2);
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
                AppMethodBeat.o(12272);
                throw illegalArgumentException;
            }
        }
        this.msg = sb.toString();
        this.cdB = l.FORCE_NONE;
        this.cdE = new StringBuilder(str.length());
        this.cdF = -1;
        AppMethodBeat.o(12272);
    }

    public final char Im() {
        AppMethodBeat.i(12273);
        char charAt = this.msg.charAt(this.pos);
        AppMethodBeat.o(12273);
        return charAt;
    }

    public final void cs(String str) {
        AppMethodBeat.i(12274);
        this.cdE.append(str);
        AppMethodBeat.o(12274);
    }

    public final void g(char c2) {
        AppMethodBeat.i(12275);
        this.cdE.append(c2);
        AppMethodBeat.o(12275);
    }

    public final boolean In() {
        AppMethodBeat.i(12276);
        if (this.pos < Io()) {
            AppMethodBeat.o(12276);
            return true;
        }
        AppMethodBeat.o(12276);
        return false;
    }

    private int Io() {
        AppMethodBeat.i(12277);
        int length = this.msg.length() - this.cdH;
        AppMethodBeat.o(12277);
        return length;
    }

    public final int Ip() {
        AppMethodBeat.i(12278);
        int Io = Io() - this.pos;
        AppMethodBeat.o(12278);
        return Io;
    }

    public final void hi(int i2) {
        AppMethodBeat.i(12280);
        if (this.cdG == null || i2 > this.cdG.cdP) {
            this.cdG = k.a(i2, this.cdB, this.cdC, this.cdD);
        }
        AppMethodBeat.o(12280);
    }

    public final void Iq() {
        AppMethodBeat.i(12279);
        hi(this.cdE.length());
        AppMethodBeat.o(12279);
    }
}
