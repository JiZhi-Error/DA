package com.tencent.tbs.one.impl.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e<T> {

    /* renamed from: a  reason: collision with root package name */
    public a f2728a;

    /* renamed from: b  reason: collision with root package name */
    public T f2729b;

    /* renamed from: c  reason: collision with root package name */
    public Object f2730c;

    public enum a {
        EXISTING,
        BUILTIN,
        LOCAL,
        SHARING,
        ONLINE,
        EXTENSION,
        SDCARD_FILE;

        static {
            AppMethodBeat.i(174131);
            AppMethodBeat.o(174131);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(174130);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(174130);
            return aVar;
        }
    }

    public static <T> e<T> a(a aVar, T t) {
        AppMethodBeat.i(174071);
        e<T> eVar = new e<>();
        eVar.f2728a = aVar;
        eVar.f2729b = t;
        AppMethodBeat.o(174071);
        return eVar;
    }
}
