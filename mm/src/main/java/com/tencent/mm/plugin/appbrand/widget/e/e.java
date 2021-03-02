package com.tencent.mm.plugin.appbrand.widget.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    public final double x;
    public final double y;

    public e(double d2, double d3) {
        this.x = d2;
        this.y = d3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        if (this.x == ((e) obj).x && this.y == ((e) obj).y) {
            return true;
        }
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(146598);
        String str = "Point{x=" + this.x + ", y=" + this.y + '}';
        AppMethodBeat.o(146598);
        return str;
    }
}
