package org.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public final class d implements c {
    private a UiJ = new a();

    public d() {
        AppMethodBeat.i(40570);
        AppMethodBeat.o(40570);
    }

    @Override // org.b.f.c
    public final String getNonce() {
        AppMethodBeat.i(40571);
        String valueOf = String.valueOf(hQp().longValue() + ((long) new Random().nextInt()));
        AppMethodBeat.o(40571);
        return valueOf;
    }

    @Override // org.b.f.c
    public final String hQo() {
        AppMethodBeat.i(40572);
        String valueOf = String.valueOf(hQp());
        AppMethodBeat.o(40572);
        return valueOf;
    }

    static class a {
        a() {
        }
    }

    private static Long hQp() {
        AppMethodBeat.i(40573);
        Long valueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        AppMethodBeat.o(40573);
        return valueOf;
    }
}
