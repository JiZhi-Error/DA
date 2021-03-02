package com.tencent.liteav.basic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f460a;

    /* renamed from: b  reason: collision with root package name */
    public int f461b;

    public d() {
    }

    public d(int i2, int i3) {
        this.f460a = i2;
        this.f461b = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.f460a == this.f460a && dVar.f461b == this.f461b;
    }

    public int hashCode() {
        return (this.f460a * 32713) + this.f461b;
    }

    public String toString() {
        AppMethodBeat.i(222088);
        String str = "Size(" + this.f460a + ", " + this.f461b + ")";
        AppMethodBeat.o(222088);
        return str;
    }
}
