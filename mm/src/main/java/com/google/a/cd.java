package com.google.a;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class cd {
    private static final cd bZZ = new cd(0, new int[0], new Object[0], false);
    boolean bNd;
    private int bVY;
    private Object[] bYp;
    private int[] caa;
    private int count;

    public static cd HR() {
        return bZZ;
    }

    static cd a(cd cdVar, cd cdVar2) {
        int i2 = cdVar.count + cdVar2.count;
        int[] copyOf = Arrays.copyOf(cdVar.caa, i2);
        System.arraycopy(cdVar2.caa, 0, copyOf, cdVar.count, cdVar2.count);
        Object[] copyOf2 = Arrays.copyOf(cdVar.bYp, i2);
        System.arraycopy(cdVar2.bYp, 0, copyOf2, cdVar.count, cdVar2.count);
        return new cd(i2, copyOf, copyOf2, true);
    }

    private cd() {
        this(0, new int[8], new Object[8], true);
    }

    private cd(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.bVY = -1;
        this.count = i2;
        this.caa = iArr;
        this.bYp = objArr;
        this.bNd = z;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof cd)) {
            return false;
        }
        cd cdVar = (cd) obj;
        if (this.count == cdVar.count) {
            int[] iArr = this.caa;
            int[] iArr2 = cdVar.caa;
            int i2 = this.count;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    z = true;
                    break;
                } else if (iArr[i3] != iArr2[i3]) {
                    z = false;
                    break;
                } else {
                    i3++;
                }
            }
            if (z) {
                Object[] objArr = this.bYp;
                Object[] objArr2 = cdVar.bYp;
                int i4 = this.count;
                int i5 = 0;
                while (true) {
                    if (i5 >= i4) {
                        z2 = true;
                        break;
                    } else if (!objArr[i5].equals(objArr2[i5])) {
                        z2 = false;
                        break;
                    } else {
                        i5++;
                    }
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = 17;
        int i3 = (this.count + JsApiGetABTestConfig.CTRL_INDEX) * 31;
        int[] iArr = this.caa;
        int i4 = this.count;
        int i5 = 17;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = (i3 + i5) * 31;
        Object[] objArr = this.bYp;
        int i8 = this.count;
        for (int i9 = 0; i9 < i8; i9++) {
            i2 = (i2 * 31) + objArr[i9].hashCode();
        }
        return i7 + i2;
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.count; i3++) {
            ay.a(sb, i2, String.valueOf(cj.gY(this.caa[i3])), this.bYp[i3]);
        }
    }
}
