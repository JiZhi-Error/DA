package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlinx.a.z;

public final class d {
    private static final String TZA = "    ";
    private static final String TZB = "type";
    private static final d TZC = new d(false, false, false, false, false, false, false, null, false, null, null, 2047);
    private static final d TZD = new d(true, false, false, false, true, false, false, TZA, false, TZB, null, 1024);
    public static final a TZE = new a((byte) 0);
    public final z TYe;
    public final boolean TZq;
    public final boolean TZr;
    public final boolean TZs;
    public final boolean TZt;
    public final boolean TZu;
    public final boolean TZv;
    public final boolean TZw;
    public final String TZx;
    public final boolean TZy;
    public final String TZz;

    public d() {
        this(false, false, false, false, false, false, false, null, false, null, null, 2047);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        if (kotlin.g.b.p.j(r3.TYe, r4.TYe) != false) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.a.c.d.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        int i3 = 1;
        AppMethodBeat.i(225643);
        boolean z = this.TZq;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = i4 * 31;
        boolean z2 = this.TZr;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i8 + i7) * 31;
        boolean z3 = this.TZs;
        if (z3) {
            z3 = true;
        }
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = (i12 + i11) * 31;
        boolean z4 = this.TZt;
        if (z4) {
            z4 = true;
        }
        int i16 = z4 ? 1 : 0;
        int i17 = z4 ? 1 : 0;
        int i18 = z4 ? 1 : 0;
        int i19 = (i16 + i15) * 31;
        boolean z5 = this.TZu;
        if (z5) {
            z5 = true;
        }
        int i20 = z5 ? 1 : 0;
        int i21 = z5 ? 1 : 0;
        int i22 = z5 ? 1 : 0;
        int i23 = (i20 + i19) * 31;
        boolean z6 = this.TZv;
        if (z6) {
            z6 = true;
        }
        int i24 = z6 ? 1 : 0;
        int i25 = z6 ? 1 : 0;
        int i26 = z6 ? 1 : 0;
        int i27 = (i24 + i23) * 31;
        boolean z7 = this.TZw;
        if (z7) {
            z7 = true;
        }
        int i28 = z7 ? 1 : 0;
        int i29 = z7 ? 1 : 0;
        int i30 = z7 ? 1 : 0;
        int i31 = (i28 + i27) * 31;
        String str = this.TZx;
        int hashCode = ((str != null ? str.hashCode() : 0) + i31) * 31;
        boolean z8 = this.TZy;
        if (!z8) {
            i3 = z8 ? 1 : 0;
        }
        int i32 = (hashCode + i3) * 31;
        String str2 = this.TZz;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + i32) * 31;
        z zVar = this.TYe;
        if (zVar != null) {
            i2 = zVar.hashCode();
        }
        int i33 = hashCode2 + i2;
        AppMethodBeat.o(225643);
        return i33;
    }

    public final String toString() {
        AppMethodBeat.i(225642);
        String str = "JsonConfiguration(encodeDefaults=" + this.TZq + ", ignoreUnknownKeys=" + this.TZr + ", isLenient=" + this.TZs + ", serializeSpecialFloatingPointValues=" + this.TZt + ", allowStructuredMapKeys=" + this.TZu + ", prettyPrint=" + this.TZv + ", unquotedPrint=" + this.TZw + ", indent=" + this.TZx + ", useArrayPolymorphism=" + this.TZy + ", classDiscriminator=" + this.TZz + ", updateMode=" + this.TYe + ")";
        AppMethodBeat.o(225642);
        return str;
    }

    private d(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, boolean z8, String str2, z zVar) {
        p.h(str, "indent");
        p.h(str2, "classDiscriminator");
        p.h(zVar, "updateMode");
        AppMethodBeat.i(225639);
        this.TZq = z;
        this.TZr = z2;
        this.TZs = z3;
        this.TZt = z4;
        this.TZu = z5;
        this.TZv = z6;
        this.TZw = z7;
        this.TZx = str;
        this.TZy = z8;
        this.TZz = str2;
        this.TYe = zVar;
        if (this.TZy && !p.j(this.TZz, TZB)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
            AppMethodBeat.o(225639);
            throw illegalArgumentException;
        } else if (this.TZv || p.j(this.TZx, TZA)) {
            AppMethodBeat.o(225639);
        } else {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
            AppMethodBeat.o(225639);
            throw illegalArgumentException2;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ d(boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, java.lang.String r21, boolean r22, java.lang.String r23, kotlinx.a.z r24, int r25) {
        /*
        // Method dump skipped, instructions count: 114
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.a.c.d.<init>(boolean, boolean, boolean, boolean, boolean, boolean, boolean, java.lang.String, boolean, java.lang.String, kotlinx.a.z, int):void");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(225641);
        AppMethodBeat.o(225641);
    }
}
