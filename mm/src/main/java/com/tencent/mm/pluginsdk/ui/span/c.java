package com.tencent.mm.pluginsdk.ui.span;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public static c KqA = new c();
    public int Kqx;
    public int Kqy;
    public a Kqz;

    static {
        AppMethodBeat.i(152264);
        AppMethodBeat.o(152264);
    }

    public final void bff(String str) {
        AppMethodBeat.i(152262);
        if (this.Kqz == null) {
            this.Kqz = new a(this, (byte) 0);
        }
        char[] charArray = str.toUpperCase().toCharArray();
        a aVar = this.Kqz;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c2 = charArray[i2];
            this.Kqx++;
            int i3 = c2 <= '9' ? c2 - '0' : (c2 - 'A') + 10;
            if (aVar.KqB == null) {
                aVar.KqB = new a[36];
                this.Kqy += 36;
            }
            if (aVar.KqB[i3] == null) {
                aVar.KqB[i3] = new a(this, (byte) 0);
                this.Kqy++;
            }
            aVar = aVar.KqB[i3];
            if (i2 == charArray.length - 1) {
                aVar.wXs = true;
            }
        }
        AppMethodBeat.o(152262);
    }

    public final boolean bfg(String str) {
        AppMethodBeat.i(152263);
        if (this.Kqz == null) {
            AppMethodBeat.o(152263);
            return false;
        }
        a aVar = this.Kqz;
        char[] charArray = str.toUpperCase().toCharArray();
        for (char c2 : charArray) {
            int i2 = c2 <= '9' ? c2 - '0' : (c2 - 'A') + 10;
            if (aVar == null || aVar.KqB == null) {
                AppMethodBeat.o(152263);
                return false;
            }
            aVar = aVar.KqB[i2];
        }
        if (aVar != null) {
            boolean z = aVar.wXs;
            AppMethodBeat.o(152263);
            return z;
        }
        AppMethodBeat.o(152263);
        return false;
    }

    /* access modifiers changed from: package-private */
    public class a {
        a[] KqB;
        boolean wXs;

        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }
    }
}
