package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);
    

    /* renamed from: a  reason: collision with root package name */
    private int f1494a;

    static {
        AppMethodBeat.i(190410);
        AppMethodBeat.o(190410);
    }

    private d(int i2) {
        AppMethodBeat.i(190409);
        this.f1494a = i2;
        AppMethodBeat.o(190409);
    }

    public static d valueOf(String str) {
        AppMethodBeat.i(190408);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(190408);
        return dVar;
    }

    public final int a() {
        return this.f1494a;
    }

    public final String toString() {
        AppMethodBeat.i(190411);
        String str = "UUIDStatusCode:" + this.f1494a;
        AppMethodBeat.o(190411);
        return str;
    }
}
