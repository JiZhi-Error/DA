package com.google.b.a;

import com.google.b.b.b;
import com.google.b.c;
import com.google.b.g;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.util.Map;

public final class a implements g {
    private static final Charset ccd = Charset.forName(KindaConfigCacheStg.SAVE_CHARSET);

    static {
        AppMethodBeat.i(12256);
        AppMethodBeat.o(12256);
    }

    @Override // com.google.b.g
    public final b a(String str, com.google.b.a aVar, int i2, int i3, Map<c, ?> map) {
        AppMethodBeat.i(12254);
        Charset charset = ccd;
        int i4 = 33;
        int i5 = 0;
        if (map != null) {
            if (map.containsKey(c.CHARACTER_SET)) {
                charset = Charset.forName(map.get(c.CHARACTER_SET).toString());
            }
            if (map.containsKey(c.ERROR_CORRECTION)) {
                i4 = Integer.parseInt(map.get(c.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(c.AZTEC_LAYERS)) {
                i5 = Integer.parseInt(map.get(c.AZTEC_LAYERS).toString());
            }
        }
        if (aVar != com.google.b.a.AZTEC) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(12254);
            throw illegalArgumentException;
        }
        b a2 = a(com.google.b.a.a.c.w(str.getBytes(charset), i4, i5), i2, i3);
        AppMethodBeat.o(12254);
        return a2;
    }

    private static b a(com.google.b.a.a.a aVar, int i2, int i3) {
        AppMethodBeat.i(12255);
        b bVar = aVar.cch;
        if (bVar == null) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(12255);
            throw illegalStateException;
        }
        int i4 = bVar.width;
        int i5 = bVar.height;
        int max = Math.max(i2, i4);
        int max2 = Math.max(i3, i5);
        int min = Math.min(max / i4, max2 / i5);
        int i6 = (max - (i4 * min)) / 2;
        b bVar2 = new b(max, max2);
        int i7 = (max2 - (i5 * min)) / 2;
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = i6;
            int i10 = 0;
            while (i10 < i4) {
                if (bVar.bI(i10, i8)) {
                    bVar2.p(i9, i7, min, min);
                }
                i10++;
                i9 += min;
            }
            i7 += min;
        }
        AppMethodBeat.o(12255);
        return bVar2;
    }
}
