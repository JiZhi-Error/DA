package com.tencent.tencentmap.mapsdk.vector.compat.utils.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final double f2826a;

    /* renamed from: b  reason: collision with root package name */
    public final double f2827b;

    /* renamed from: c  reason: collision with root package name */
    public final double f2828c;

    /* renamed from: d  reason: collision with root package name */
    public final double f2829d;

    /* renamed from: e  reason: collision with root package name */
    public final double f2830e;

    /* renamed from: f  reason: collision with root package name */
    public final double f2831f;

    public a(double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(199642);
        this.f2826a = d2;
        this.f2827b = d4;
        this.f2828c = d3;
        this.f2829d = d5;
        this.f2830e = (d2 + d3) / 2.0d;
        this.f2831f = (d4 + d5) / 2.0d;
        AppMethodBeat.o(199642);
    }

    public boolean a(double d2, double d3) {
        return this.f2826a <= d2 && d2 <= this.f2828c && this.f2827b <= d3 && d3 <= this.f2829d;
    }

    public boolean a(b bVar) {
        AppMethodBeat.i(199643);
        boolean a2 = a(bVar.f2832a, bVar.f2833b);
        AppMethodBeat.o(199643);
        return a2;
    }

    public boolean a(double d2, double d3, double d4, double d5) {
        return d2 < this.f2828c && this.f2826a < d3 && d4 < this.f2829d && this.f2827b < d5;
    }

    public boolean a(a aVar) {
        AppMethodBeat.i(199644);
        boolean a2 = a(aVar.f2826a, aVar.f2828c, aVar.f2827b, aVar.f2829d);
        AppMethodBeat.o(199644);
        return a2;
    }

    public boolean b(a aVar) {
        return aVar.f2826a >= this.f2826a && aVar.f2828c <= this.f2828c && aVar.f2827b >= this.f2827b && aVar.f2829d <= this.f2829d;
    }
}
