package com.tencent.mm.plugin.whatsnew.ui;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\u0016\u0010(\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tJ\t\u0010*\u001a\u00020+HÖ\u0001J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/Bubble;", "", "x", "", "y", "radius", "radians", "speed", "color", "", "(DDDDDI)V", "getColor", "()I", "setColor", "(I)V", "getRadians", "()D", "setRadians", "(D)V", "getRadius", "setRadius", "getSpeed", "setSpeed", "getX", "setX", "getY", "setY", "canRemove", "", "width", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "isInScreen", "height", "toString", "", "update", "", "deltaTs", "", "app_release"})
public final class a {
    double JOx;
    int color;
    double dxQ;
    double radius;
    double x;
    double y;

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r5.color == r6.color) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 230934(0x38616, float:3.23607E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x0046
            boolean r0 = r6 instanceof com.tencent.mm.plugin.whatsnew.ui.a
            if (r0 == 0) goto L_0x004b
            com.tencent.mm.plugin.whatsnew.ui.a r6 = (com.tencent.mm.plugin.whatsnew.ui.a) r6
            double r0 = r5.x
            double r2 = r6.x
            int r0 = java.lang.Double.compare(r0, r2)
            if (r0 != 0) goto L_0x004b
            double r0 = r5.y
            double r2 = r6.y
            int r0 = java.lang.Double.compare(r0, r2)
            if (r0 != 0) goto L_0x004b
            double r0 = r5.radius
            double r2 = r6.radius
            int r0 = java.lang.Double.compare(r0, r2)
            if (r0 != 0) goto L_0x004b
            double r0 = r5.JOx
            double r2 = r6.JOx
            int r0 = java.lang.Double.compare(r0, r2)
            if (r0 != 0) goto L_0x004b
            double r0 = r5.dxQ
            double r2 = r6.dxQ
            int r0 = java.lang.Double.compare(r0, r2)
            if (r0 != 0) goto L_0x004b
            int r0 = r5.color
            int r1 = r6.color
            if (r0 != r1) goto L_0x004b
        L_0x0046:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x004a:
            return r0
        L_0x004b:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.whatsnew.ui.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(230933);
        long doubleToLongBits = Double.doubleToLongBits(this.x);
        long doubleToLongBits2 = Double.doubleToLongBits(this.y);
        long doubleToLongBits3 = Double.doubleToLongBits(this.radius);
        long doubleToLongBits4 = Double.doubleToLongBits(this.JOx);
        long doubleToLongBits5 = Double.doubleToLongBits(this.dxQ);
        int i2 = (((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + this.color;
        AppMethodBeat.o(230933);
        return i2;
    }

    public final String toString() {
        AppMethodBeat.i(230932);
        String str = "Bubble(x=" + this.x + ", y=" + this.y + ", radius=" + this.radius + ", radians=" + this.JOx + ", speed=" + this.dxQ + ", color=" + this.color + ")";
        AppMethodBeat.o(230932);
        return str;
    }

    public a(double d2, double d3, double d4, double d5, double d6, int i2) {
        this.x = d2;
        this.y = d3;
        this.radius = d4;
        this.JOx = d5;
        this.dxQ = d6;
        this.color = i2;
    }
}
