package com.google.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class b {
    final a cdu;
    final int[] cdv;

    b(a aVar, int[] iArr) {
        AppMethodBeat.i(12266);
        if (iArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(12266);
            throw illegalArgumentException;
        }
        this.cdu = aVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.cdv = iArr;
            AppMethodBeat.o(12266);
            return;
        }
        int i2 = 1;
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.cdv = new int[]{0};
            AppMethodBeat.o(12266);
            return;
        }
        this.cdv = new int[(length - i2)];
        System.arraycopy(iArr, i2, this.cdv, 0, this.cdv.length);
        AppMethodBeat.o(12266);
    }

    /* access modifiers changed from: package-private */
    public final boolean isZero() {
        return this.cdv[0] == 0;
    }

    private int hf(int i2) {
        return this.cdv[(this.cdv.length - 1) - i2];
    }

    private b a(b bVar) {
        int[] iArr;
        int[] iArr2;
        AppMethodBeat.i(12267);
        if (!this.cdu.equals(bVar.cdu)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            AppMethodBeat.o(12267);
            throw illegalArgumentException;
        } else if (isZero()) {
            AppMethodBeat.o(12267);
            return bVar;
        } else if (bVar.isZero()) {
            AppMethodBeat.o(12267);
            return this;
        } else {
            int[] iArr3 = this.cdv;
            int[] iArr4 = bVar.cdv;
            if (iArr3.length > iArr4.length) {
                iArr = iArr4;
                iArr2 = iArr3;
            } else {
                iArr = iArr3;
                iArr2 = iArr4;
            }
            int[] iArr5 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr5, 0, length);
            for (int i2 = length; i2 < iArr2.length; i2++) {
                iArr5[i2] = a.bJ(iArr[i2 - length], iArr2[i2]);
            }
            b bVar2 = new b(this.cdu, iArr5);
            AppMethodBeat.o(12267);
            return bVar2;
        }
    }

    /* access modifiers changed from: package-private */
    public final b bL(int i2, int i3) {
        AppMethodBeat.i(12268);
        if (i2 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(12268);
            throw illegalArgumentException;
        } else if (i3 == 0) {
            b bVar = this.cdu.cdq;
            AppMethodBeat.o(12268);
            return bVar;
        } else {
            int length = this.cdv.length;
            int[] iArr = new int[(length + i2)];
            for (int i4 = 0; i4 < length; i4++) {
                iArr[i4] = this.cdu.bK(this.cdv[i4], i3);
            }
            b bVar2 = new b(this.cdu, iArr);
            AppMethodBeat.o(12268);
            return bVar2;
        }
    }

    /* access modifiers changed from: package-private */
    public final b[] b(b bVar) {
        b bVar2;
        AppMethodBeat.i(12269);
        if (!this.cdu.equals(bVar.cdu)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            AppMethodBeat.o(12269);
            throw illegalArgumentException;
        } else if (bVar.isZero()) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Divide by 0");
            AppMethodBeat.o(12269);
            throw illegalArgumentException2;
        } else {
            b bVar3 = this.cdu.cdq;
            int hf = bVar.hf(bVar.cdv.length - 1);
            a aVar = this.cdu;
            if (hf == 0) {
                ArithmeticException arithmeticException = new ArithmeticException();
                AppMethodBeat.o(12269);
                throw arithmeticException;
            }
            int i2 = aVar.cdo[(aVar.size - aVar.cdp[hf]) - 1];
            b bVar4 = this;
            b bVar5 = bVar3;
            while (bVar4.cdv.length - 1 >= bVar.cdv.length - 1 && !bVar4.isZero()) {
                int length = (bVar4.cdv.length - 1) - (bVar.cdv.length - 1);
                int bK = this.cdu.bK(bVar4.hf(bVar4.cdv.length - 1), i2);
                b bL = bVar.bL(length, bK);
                a aVar2 = this.cdu;
                if (length < 0) {
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
                    AppMethodBeat.o(12269);
                    throw illegalArgumentException3;
                }
                if (bK == 0) {
                    bVar2 = aVar2.cdq;
                } else {
                    int[] iArr = new int[(length + 1)];
                    iArr[0] = bK;
                    bVar2 = new b(aVar2, iArr);
                }
                bVar5 = bVar5.a(bVar2);
                bVar4 = bVar4.a(bL);
            }
            b[] bVarArr = {bVar5, bVar4};
            AppMethodBeat.o(12269);
            return bVarArr;
        }
    }

    public final String toString() {
        AppMethodBeat.i(12270);
        StringBuilder sb = new StringBuilder((this.cdv.length - 1) * 8);
        for (int length = this.cdv.length - 1; length >= 0; length--) {
            int hf = hf(length);
            if (hf != 0) {
                if (hf < 0) {
                    sb.append(" - ");
                    hf = -hf;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (length == 0 || hf != 1) {
                    a aVar = this.cdu;
                    if (hf == 0) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                        AppMethodBeat.o(12270);
                        throw illegalArgumentException;
                    }
                    int i2 = aVar.cdp[hf];
                    if (i2 == 0) {
                        sb.append('1');
                    } else if (i2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(i2);
                    }
                }
                if (length != 0) {
                    if (length == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(length);
                    }
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(12270);
        return sb2;
    }
}
