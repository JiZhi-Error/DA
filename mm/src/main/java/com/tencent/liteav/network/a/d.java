package com.tencent.liteav.network.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f908a = new d(a.NO_NETWORK, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final d f909b = new d(a.WIFI, 0);

    /* renamed from: c  reason: collision with root package name */
    public final int f910c;

    /* renamed from: d  reason: collision with root package name */
    public final a f911d;

    static {
        AppMethodBeat.i(15433);
        AppMethodBeat.o(15433);
    }

    public d(a aVar, int i2) {
        this.f911d = aVar;
        this.f910c = i2;
    }

    public enum a {
        NO_NETWORK,
        WIFI,
        MOBILE;

        public static a valueOf(String str) {
            AppMethodBeat.i(15435);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(15435);
            return aVar;
        }

        static {
            AppMethodBeat.i(15436);
            AppMethodBeat.o(15436);
        }
    }
}
