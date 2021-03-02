package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzaca implements Cloneable {
    private static final zzacb zzbxa = new zzacb();
    private int mSize;
    private boolean zzbxb;
    private int[] zzbxc;
    private zzacb[] zzbxd;

    static {
        AppMethodBeat.i(40283);
        AppMethodBeat.o(40283);
    }

    zzaca() {
        this(10);
    }

    private zzaca(int i2) {
        AppMethodBeat.i(40277);
        this.zzbxb = false;
        int idealIntArraySize = idealIntArraySize(i2);
        this.zzbxc = new int[idealIntArraySize];
        this.zzbxd = new zzacb[idealIntArraySize];
        this.mSize = 0;
        AppMethodBeat.o(40277);
    }

    private static int idealIntArraySize(int i2) {
        int i3 = i2 << 2;
        int i4 = 4;
        while (true) {
            if (i4 >= 32) {
                break;
            } else if (i3 <= (1 << i4) - 12) {
                i3 = (1 << i4) - 12;
                break;
            } else {
                i4++;
            }
        }
        return i3 / 4;
    }

    private final int zzav(int i2) {
        int i3 = 0;
        int i4 = this.mSize - 1;
        while (i3 <= i4) {
            int i5 = (i3 + i4) >>> 1;
            int i6 = this.zzbxc[i5];
            if (i6 < i2) {
                i3 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return i3 ^ -1;
    }

    @Override // java.lang.Object
    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(40282);
        int i2 = this.mSize;
        zzaca zzaca = new zzaca(i2);
        System.arraycopy(this.zzbxc, 0, zzaca.zzbxc, 0, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.zzbxd[i3] != null) {
                zzaca.zzbxd[i3] = (zzacb) this.zzbxd[i3].clone();
            }
        }
        zzaca.mSize = i2;
        AppMethodBeat.o(40282);
        return zzaca;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(40280);
        if (obj == this) {
            AppMethodBeat.o(40280);
            return true;
        } else if (!(obj instanceof zzaca)) {
            AppMethodBeat.o(40280);
            return false;
        } else {
            zzaca zzaca = (zzaca) obj;
            if (this.mSize != zzaca.mSize) {
                AppMethodBeat.o(40280);
                return false;
            }
            int[] iArr = this.zzbxc;
            int[] iArr2 = zzaca.zzbxc;
            int i2 = this.mSize;
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
                zzacb[] zzacbArr = this.zzbxd;
                zzacb[] zzacbArr2 = zzaca.zzbxd;
                int i4 = this.mSize;
                int i5 = 0;
                while (true) {
                    if (i5 >= i4) {
                        z2 = true;
                        break;
                    } else if (!zzacbArr[i5].equals(zzacbArr2[i5])) {
                        z2 = false;
                        break;
                    } else {
                        i5++;
                    }
                }
                if (z2) {
                    AppMethodBeat.o(40280);
                    return true;
                }
            }
            AppMethodBeat.o(40280);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(40281);
        int i2 = 17;
        for (int i3 = 0; i3 < this.mSize; i3++) {
            i2 = (((i2 * 31) + this.zzbxc[i3]) * 31) + this.zzbxd[i3].hashCode();
        }
        AppMethodBeat.o(40281);
        return i2;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        return this.mSize;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i2, zzacb zzacb) {
        AppMethodBeat.i(40279);
        int zzav = zzav(i2);
        if (zzav >= 0) {
            this.zzbxd[zzav] = zzacb;
            AppMethodBeat.o(40279);
            return;
        }
        int i3 = zzav ^ -1;
        if (i3 >= this.mSize || this.zzbxd[i3] != zzbxa) {
            if (this.mSize >= this.zzbxc.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzacb[] zzacbArr = new zzacb[idealIntArraySize];
                System.arraycopy(this.zzbxc, 0, iArr, 0, this.zzbxc.length);
                System.arraycopy(this.zzbxd, 0, zzacbArr, 0, this.zzbxd.length);
                this.zzbxc = iArr;
                this.zzbxd = zzacbArr;
            }
            if (this.mSize - i3 != 0) {
                int[] iArr2 = this.zzbxc;
                System.arraycopy(iArr2, i3, iArr2, i3 + 1, this.mSize - i3);
                zzacb[] zzacbArr2 = this.zzbxd;
                System.arraycopy(zzacbArr2, i3, zzacbArr2, i3 + 1, this.mSize - i3);
            }
            this.zzbxc[i3] = i2;
            this.zzbxd[i3] = zzacb;
            this.mSize++;
            AppMethodBeat.o(40279);
            return;
        }
        this.zzbxc[i3] = i2;
        this.zzbxd[i3] = zzacb;
        AppMethodBeat.o(40279);
    }

    /* access modifiers changed from: package-private */
    public final zzacb zzat(int i2) {
        AppMethodBeat.i(40278);
        int zzav = zzav(i2);
        if (zzav < 0 || this.zzbxd[zzav] == zzbxa) {
            AppMethodBeat.o(40278);
            return null;
        }
        zzacb zzacb = this.zzbxd[zzav];
        AppMethodBeat.o(40278);
        return zzacb;
    }

    /* access modifiers changed from: package-private */
    public final zzacb zzau(int i2) {
        return this.zzbxd[i2];
    }
}
