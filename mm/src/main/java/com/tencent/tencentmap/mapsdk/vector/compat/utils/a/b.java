package com.tencent.tencentmap.mapsdk.vector.compat.utils.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final double f2832a;

    /* renamed from: b  reason: collision with root package name */
    public final double f2833b;

    public b(double d2, double d3) {
        this.f2832a = d2;
        this.f2833b = d3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (this.f2832a == ((b) obj).f2832a && this.f2833b == ((b) obj).f2833b) {
            return true;
        }
        return false;
    }

    public String toString() {
        AppMethodBeat.i(199645);
        String str = "Point{x=" + this.f2832a + ", y=" + this.f2833b + '}';
        AppMethodBeat.o(199645);
        return str;
    }
}
