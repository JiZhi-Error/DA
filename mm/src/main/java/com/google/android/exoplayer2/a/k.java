package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class k {
    float bdN;
    final int bgE;
    private final int bgF;
    private final int bgG;
    final int bgH = (this.bgG * 2);
    private final short[] bgI = new short[this.bgH];
    private int bgJ = this.bgH;
    short[] bgK;
    private int bgL;
    short[] bgM;
    private int bgN;
    private short[] bgO;
    private int bgP;
    private int bgQ;
    int bgR;
    int bgS;
    int bgT;
    int bgU;
    private int bgV;
    private int bgW;
    private int bgX;
    private int bgY;
    float pitch;
    private final int sampleRate;

    public k(int i2, int i3) {
        AppMethodBeat.i(91833);
        this.sampleRate = i2;
        this.bgE = i3;
        this.bgF = i2 / 400;
        this.bgG = i2 / 65;
        this.bgK = new short[(this.bgH * i3)];
        this.bgL = this.bgH;
        this.bgM = new short[(this.bgH * i3)];
        this.bgN = this.bgH;
        this.bgO = new short[(this.bgH * i3)];
        this.bgP = 0;
        this.bgQ = 0;
        this.bgV = 0;
        this.bdN = 1.0f;
        this.pitch = 1.0f;
        AppMethodBeat.o(91833);
    }

    private void dI(int i2) {
        AppMethodBeat.i(91834);
        if (this.bgS + i2 > this.bgL) {
            this.bgL += (this.bgL / 2) + i2;
            this.bgM = Arrays.copyOf(this.bgM, this.bgL * this.bgE);
        }
        AppMethodBeat.o(91834);
    }

    /* access modifiers changed from: package-private */
    public final void dJ(int i2) {
        AppMethodBeat.i(91835);
        if (this.bgR + i2 > this.bgJ) {
            this.bgJ += (this.bgJ / 2) + i2;
            this.bgK = Arrays.copyOf(this.bgK, this.bgJ * this.bgE);
        }
        AppMethodBeat.o(91835);
    }

    private void a(short[] sArr, int i2, int i3) {
        AppMethodBeat.i(91836);
        dI(i3);
        System.arraycopy(sArr, this.bgE * i2, this.bgM, this.bgS * this.bgE, this.bgE * i3);
        this.bgS += i3;
        AppMethodBeat.o(91836);
    }

    private void b(short[] sArr, int i2, int i3) {
        int i4 = this.bgH / i3;
        int i5 = this.bgE * i3;
        int i6 = i2 * this.bgE;
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.bgI[i7] = (short) (i8 / i5);
        }
    }

    private int a(short[] sArr, int i2, int i3, int i4) {
        AppMethodBeat.i(91837);
        int i5 = 0;
        int i6 = 255;
        int i7 = 1;
        int i8 = 0;
        int i9 = i2 * this.bgE;
        int i10 = i3;
        while (i10 <= i4) {
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                i11 += Math.abs(sArr[i9 + i12] - sArr[(i9 + i10) + i12]);
            }
            if (i11 * i5 < i7 * i10) {
                i7 = i11;
                i5 = i10;
            }
            if (i11 * i6 > i8 * i10) {
                i6 = i10;
            } else {
                i11 = i8;
            }
            i10++;
            i8 = i11;
        }
        this.bgX = i7 / i5;
        this.bgY = i8 / i6;
        AppMethodBeat.o(91837);
        return i5;
    }

    /* access modifiers changed from: package-private */
    public final void ub() {
        int i2;
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        AppMethodBeat.i(91838);
        int i8 = this.bgS;
        float f2 = this.bdN / this.pitch;
        if (((double) f2) <= 1.00001d && ((double) f2) >= 0.99999d) {
            a(this.bgK, 0, this.bgR);
            this.bgR = 0;
        } else if (this.bgR >= this.bgH) {
            int i9 = this.bgR;
            int i10 = 0;
            do {
                if (this.bgU > 0) {
                    int min = Math.min(this.bgH, this.bgU);
                    a(this.bgK, i10, min);
                    this.bgU -= min;
                    i10 += min;
                } else {
                    short[] sArr = this.bgK;
                    int i11 = this.sampleRate > 4000 ? this.sampleRate / 4000 : 1;
                    if (this.bgE == 1 && i11 == 1) {
                        i2 = a(sArr, i10, this.bgF, this.bgG);
                    } else {
                        b(sArr, i10, i11);
                        int a2 = a(this.bgI, 0, this.bgF / i11, this.bgG / i11);
                        if (i11 != 1) {
                            int i12 = a2 * i11;
                            int i13 = i12 - (i11 * 4);
                            int i14 = i12 + (i11 * 4);
                            if (i13 < this.bgF) {
                                i3 = this.bgF;
                            } else {
                                i3 = i13;
                            }
                            if (i14 > this.bgG) {
                                i4 = this.bgG;
                            } else {
                                i4 = i14;
                            }
                            if (this.bgE == 1) {
                                i2 = a(sArr, i10, i3, i4);
                            } else {
                                b(sArr, i10, 1);
                                i2 = a(this.bgI, 0, i3, i4);
                            }
                        } else {
                            i2 = a2;
                        }
                    }
                    int i15 = this.bgX;
                    int i16 = this.bgY;
                    if (i15 == 0 || this.bgV == 0) {
                        z = false;
                    } else if (i16 > i15 * 3) {
                        z = false;
                    } else if (i15 * 2 <= this.bgW * 3) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        i5 = this.bgV;
                    } else {
                        i5 = i2;
                    }
                    this.bgW = this.bgX;
                    this.bgV = i2;
                    if (((double) f2) > 1.0d) {
                        short[] sArr2 = this.bgK;
                        if (f2 >= 2.0f) {
                            i7 = (int) (((float) i5) / (f2 - 1.0f));
                        } else {
                            this.bgU = (int) ((((float) i5) * (2.0f - f2)) / (f2 - 1.0f));
                            i7 = i5;
                        }
                        dI(i7);
                        a(i7, this.bgE, this.bgM, this.bgS, sArr2, i10, sArr2, i10 + i5);
                        this.bgS += i7;
                        i10 += i7 + i5;
                    } else {
                        short[] sArr3 = this.bgK;
                        if (f2 < 0.5f) {
                            i6 = (int) ((((float) i5) * f2) / (1.0f - f2));
                        } else {
                            this.bgU = (int) ((((float) i5) * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
                            i6 = i5;
                        }
                        dI(i5 + i6);
                        System.arraycopy(sArr3, this.bgE * i10, this.bgM, this.bgS * this.bgE, this.bgE * i5);
                        a(i6, this.bgE, this.bgM, this.bgS + i5, sArr3, i10 + i5, sArr3, i10);
                        this.bgS += i5 + i6;
                        i10 += i6;
                    }
                }
            } while (this.bgH + i10 <= i9);
            int i17 = this.bgR - i10;
            System.arraycopy(this.bgK, this.bgE * i10, this.bgK, 0, this.bgE * i17);
            this.bgR = i17;
        }
        if (this.pitch != 1.0f) {
            float f3 = this.pitch;
            if (this.bgS != i8) {
                int i18 = (int) (((float) this.sampleRate) / f3);
                int i19 = this.sampleRate;
                while (true) {
                    if (i18 <= 16384 && i19 <= 16384) {
                        break;
                    }
                    i18 /= 2;
                    i19 /= 2;
                }
                int i20 = this.bgS - i8;
                if (this.bgT + i20 > this.bgN) {
                    this.bgN += (this.bgN / 2) + i20;
                    this.bgO = Arrays.copyOf(this.bgO, this.bgN * this.bgE);
                }
                System.arraycopy(this.bgM, this.bgE * i8, this.bgO, this.bgT * this.bgE, this.bgE * i20);
                this.bgS = i8;
                this.bgT = i20 + this.bgT;
                for (int i21 = 0; i21 < this.bgT - 1; i21++) {
                    while ((this.bgP + 1) * i18 > this.bgQ * i19) {
                        dI(1);
                        for (int i22 = 0; i22 < this.bgE; i22++) {
                            short[] sArr4 = this.bgO;
                            int i23 = (this.bgE * i21) + i22;
                            short s = sArr4[i23];
                            short s2 = sArr4[i23 + this.bgE];
                            int i24 = (this.bgP + 1) * i18;
                            int i25 = i24 - (this.bgQ * i19);
                            int i26 = i24 - (this.bgP * i18);
                            this.bgM[(this.bgS * this.bgE) + i22] = (short) (((s2 * (i26 - i25)) + (s * i25)) / i26);
                        }
                        this.bgQ++;
                        this.bgS++;
                    }
                    this.bgP++;
                    if (this.bgP == i19) {
                        this.bgP = 0;
                        a.checkState(this.bgQ == i18);
                        this.bgQ = 0;
                    }
                }
                int i27 = this.bgT - 1;
                if (i27 != 0) {
                    System.arraycopy(this.bgO, this.bgE * i27, this.bgO, 0, (this.bgT - i27) * this.bgE);
                    this.bgT -= i27;
                }
            }
        }
        AppMethodBeat.o(91838);
    }

    private static void a(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i4 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i5 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i8] = (short) (((sArr2[i10] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                i8 += i3;
                i10 += i3;
                i9 += i3;
            }
        }
    }
}
