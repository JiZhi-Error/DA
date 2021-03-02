package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzp implements Cloneable {
    private static final zzq zzhe = new zzq();
    private int mSize;
    private boolean zzhf;
    private int[] zzhg;
    private zzq[] zzhh;

    static {
        AppMethodBeat.i(100741);
        AppMethodBeat.o(100741);
    }

    zzp() {
        this(10);
    }

    private zzp(int i2) {
        AppMethodBeat.i(100735);
        this.zzhf = false;
        int idealIntArraySize = idealIntArraySize(i2);
        this.zzhg = new int[idealIntArraySize];
        this.zzhh = new zzq[idealIntArraySize];
        this.mSize = 0;
        AppMethodBeat.o(100735);
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

    private final int zzq(int i2) {
        int i3 = 0;
        int i4 = this.mSize - 1;
        while (i3 <= i4) {
            int i5 = (i3 + i4) >>> 1;
            int i6 = this.zzhg[i5];
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
        AppMethodBeat.i(100740);
        int i2 = this.mSize;
        zzp zzp = new zzp(i2);
        System.arraycopy(this.zzhg, 0, zzp.zzhg, 0, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.zzhh[i3] != null) {
                zzp.zzhh[i3] = (zzq) this.zzhh[i3].clone();
            }
        }
        zzp.mSize = i2;
        AppMethodBeat.o(100740);
        return zzp;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(100738);
        if (obj == this) {
            AppMethodBeat.o(100738);
            return true;
        } else if (!(obj instanceof zzp)) {
            AppMethodBeat.o(100738);
            return false;
        } else {
            zzp zzp = (zzp) obj;
            if (this.mSize != zzp.mSize) {
                AppMethodBeat.o(100738);
                return false;
            }
            int[] iArr = this.zzhg;
            int[] iArr2 = zzp.zzhg;
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
                zzq[] zzqArr = this.zzhh;
                zzq[] zzqArr2 = zzp.zzhh;
                int i4 = this.mSize;
                int i5 = 0;
                while (true) {
                    if (i5 >= i4) {
                        z2 = true;
                        break;
                    } else if (!zzqArr[i5].equals(zzqArr2[i5])) {
                        z2 = false;
                        break;
                    } else {
                        i5++;
                    }
                }
                if (z2) {
                    AppMethodBeat.o(100738);
                    return true;
                }
            }
            AppMethodBeat.o(100738);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(100739);
        int i2 = 17;
        for (int i3 = 0; i3 < this.mSize; i3++) {
            i2 = (((i2 * 31) + this.zzhg[i3]) * 31) + this.zzhh[i3].hashCode();
        }
        AppMethodBeat.o(100739);
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
    public final void zza(int i2, zzq zzq) {
        AppMethodBeat.i(100737);
        int zzq2 = zzq(i2);
        if (zzq2 >= 0) {
            this.zzhh[zzq2] = zzq;
            AppMethodBeat.o(100737);
            return;
        }
        int i3 = zzq2 ^ -1;
        if (i3 >= this.mSize || this.zzhh[i3] != zzhe) {
            if (this.mSize >= this.zzhg.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzq[] zzqArr = new zzq[idealIntArraySize];
                System.arraycopy(this.zzhg, 0, iArr, 0, this.zzhg.length);
                System.arraycopy(this.zzhh, 0, zzqArr, 0, this.zzhh.length);
                this.zzhg = iArr;
                this.zzhh = zzqArr;
            }
            if (this.mSize - i3 != 0) {
                int[] iArr2 = this.zzhg;
                System.arraycopy(iArr2, i3, iArr2, i3 + 1, this.mSize - i3);
                zzq[] zzqArr2 = this.zzhh;
                System.arraycopy(zzqArr2, i3, zzqArr2, i3 + 1, this.mSize - i3);
            }
            this.zzhg[i3] = i2;
            this.zzhh[i3] = zzq;
            this.mSize++;
            AppMethodBeat.o(100737);
            return;
        }
        this.zzhg[i3] = i2;
        this.zzhh[i3] = zzq;
        AppMethodBeat.o(100737);
    }

    /* access modifiers changed from: package-private */
    public final zzq zzo(int i2) {
        AppMethodBeat.i(100736);
        int zzq = zzq(i2);
        if (zzq < 0 || this.zzhh[zzq] == zzhe) {
            AppMethodBeat.o(100736);
            return null;
        }
        zzq zzq2 = this.zzhh[zzq];
        AppMethodBeat.o(100736);
        return zzq2;
    }

    /* access modifiers changed from: package-private */
    public final zzq zzp(int i2) {
        return this.zzhh[i2];
    }
}
