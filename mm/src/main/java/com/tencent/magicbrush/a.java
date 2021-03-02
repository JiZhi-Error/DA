package com.tencent.magicbrush;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/magicbrush/FpsInfo;", "", "()V", "fps", "", "exceedFps", "(FF)V", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "lib-magicbrush-nano_release"})
public final class a {
    public float cKu;
    public float cKv;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (java.lang.Float.compare(r3.cKv, r4.cKv) == 0) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 140079(0x2232f, float:1.96292E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0022
            boolean r0 = r4 instanceof com.tencent.magicbrush.a
            if (r0 == 0) goto L_0x0027
            com.tencent.magicbrush.a r4 = (com.tencent.magicbrush.a) r4
            float r0 = r3.cKu
            float r1 = r4.cKu
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 != 0) goto L_0x0027
            float r0 = r3.cKv
            float r1 = r4.cKv
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 != 0) goto L_0x0027
        L_0x0022:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0026:
            return r0
        L_0x0027:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.magicbrush.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(140078);
        int floatToIntBits = (Float.floatToIntBits(this.cKu) * 31) + Float.floatToIntBits(this.cKv);
        AppMethodBeat.o(140078);
        return floatToIntBits;
    }

    private a() {
        this.cKu = 0.0f;
        this.cKv = 0.0f;
    }

    public a(byte b2) {
        this();
    }

    public final String toString() {
        AppMethodBeat.i(140077);
        Locale locale = Locale.ENGLISH;
        p.g(locale, "Locale.ENGLISH");
        String format = String.format(locale, "fps(%.2f, %.2f)", Arrays.copyOf(new Object[]{Float.valueOf(this.cKu), Float.valueOf(this.cKv)}, 2));
        p.g(format, "java.lang.String.format(locale, this, *args)");
        AppMethodBeat.o(140077);
        return format;
    }
}
