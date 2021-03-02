package com.tencent.mm.ipcinvoker.h;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements com.tencent.mm.ipcinvoker.h.a.a {
    @Override // com.tencent.mm.ipcinvoker.h.a.a
    public final void printLog(int i2, String str, String str2, Object... objArr) {
        AppMethodBeat.i(158834);
        if (i2 < 4) {
            AppMethodBeat.o(158834);
            return;
        }
        Log.println(i2, str, String.format(str2, objArr));
        AppMethodBeat.o(158834);
    }
}
