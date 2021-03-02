package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.core.c.c;

public final class h implements c {
    @Override // com.tencent.soter.core.c.c
    public final void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(130844);
        Log.v(str, str2, objArr);
        AppMethodBeat.o(130844);
    }

    @Override // com.tencent.soter.core.c.c
    public final void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(130845);
        Log.d(str, str2, objArr);
        AppMethodBeat.o(130845);
    }

    @Override // com.tencent.soter.core.c.c
    public final void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(130846);
        Log.i(str, str2, objArr);
        AppMethodBeat.o(130846);
    }

    @Override // com.tencent.soter.core.c.c
    public final void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(130847);
        Log.w(str, str2, objArr);
        AppMethodBeat.o(130847);
    }

    @Override // com.tencent.soter.core.c.c
    public final void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(130848);
        Log.e(str, str2, objArr);
        AppMethodBeat.o(130848);
    }

    @Override // com.tencent.soter.core.c.c
    public final void a(String str, Throwable th, String str2) {
        AppMethodBeat.i(130849);
        Log.printErrStackTrace(str, th, str2, new Object[0]);
        AppMethodBeat.o(130849);
    }
}
