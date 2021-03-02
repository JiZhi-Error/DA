package com.tencent.liteav.network.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f916a;

    /* renamed from: b  reason: collision with root package name */
    public final int f917b;

    /* renamed from: c  reason: collision with root package name */
    public final int f918c;

    /* renamed from: d  reason: collision with root package name */
    public final long f919d;

    public e(String str, int i2, int i3, long j2) {
        AppMethodBeat.i(15431);
        this.f916a = str;
        this.f917b = i2;
        this.f918c = i3 < 600 ? 600 : i3;
        this.f919d = j2;
        AppMethodBeat.o(15431);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(15432);
        if (this == obj) {
            AppMethodBeat.o(15432);
            return true;
        } else if (obj == null || !(obj instanceof e)) {
            AppMethodBeat.o(15432);
            return false;
        } else {
            e eVar = (e) obj;
            if (this.f916a.equals(eVar.f916a) && this.f917b == eVar.f917b && this.f918c == eVar.f918c && this.f919d == eVar.f919d) {
                AppMethodBeat.o(15432);
                return true;
            }
            AppMethodBeat.o(15432);
            return false;
        }
    }

    public final boolean a() {
        return this.f917b == 5;
    }
}
