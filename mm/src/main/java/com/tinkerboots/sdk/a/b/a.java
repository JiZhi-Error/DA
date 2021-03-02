package com.tinkerboots.sdk.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {
    public final com.tinkerboots.sdk.a.c.a SKG;

    private a(com.tinkerboots.sdk.a.c.a aVar) {
        this.SKG = aVar;
    }

    public static a hwa() {
        AppMethodBeat.i(3438);
        C2239a aVar = new C2239a();
        aVar.SKG = new com.tinkerboots.sdk.a.c.a();
        if (aVar.SKG == null) {
            RuntimeException runtimeException = new RuntimeException("You need init conditions property");
            AppMethodBeat.o(3438);
            throw runtimeException;
        }
        a aVar2 = new a(aVar.SKG);
        AppMethodBeat.o(3438);
        return aVar2;
    }

    public final com.tinkerboots.sdk.a.c.a on(String str, String str2) {
        AppMethodBeat.i(3439);
        com.tinkerboots.sdk.a.c.a oo = this.SKG.oo(str, str2);
        AppMethodBeat.o(3439);
        return oo;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tinkerboots.sdk.a.b.a$a  reason: collision with other inner class name */
    public static class C2239a {
        com.tinkerboots.sdk.a.c.a SKG;

        C2239a() {
        }
    }
}
