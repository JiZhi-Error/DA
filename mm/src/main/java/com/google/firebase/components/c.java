package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final /* synthetic */ class c {
    @KeepForSdk
    public static Object a(b bVar, Class cls) {
        AppMethodBeat.i(4076);
        a A = bVar.A(cls);
        if (A == null) {
            AppMethodBeat.o(4076);
            return null;
        }
        Object obj = A.get();
        AppMethodBeat.o(4076);
        return obj;
    }
}
