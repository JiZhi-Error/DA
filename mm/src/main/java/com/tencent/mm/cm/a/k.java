package com.tencent.mm.cm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class k {
    private float HkW = 1.2f;
    private int[] RgA = new int[10];
    private boolean RgB = false;
    private int Rgm = 0;
    private int Rgn = 6;
    private int Rgo = 0;
    private float Rgp = 1.2f;
    private boolean Rgq = false;
    private int Rgr = 0;
    private int Rgs = 0;
    private boolean Rgt = false;
    private int Rgu = 0;
    private ByteBuffer Rgv = ByteBuffer.allocate(6125);
    private ByteBuffer Rgw = ByteBuffer.allocate(6125);
    private float[] Rgx = new float[6];
    private ArrayList<n> Rgy = new ArrayList<>();
    private int[] Rgz = new int[10];
    private int blockSize = 35;

    public k() {
        AppMethodBeat.i(190273);
        AppMethodBeat.o(190273);
    }

    private void cI(float f2) {
        float f3 = 4.2f;
        AppMethodBeat.i(190274);
        if (this.Rgu == 6) {
            float[] fArr = this.Rgx;
            float f4 = 0.0f;
            for (float f5 : fArr) {
                f4 += f5;
            }
            float length = f4 / ((float) fArr.length);
            this.Rgu = 0;
            if (this.Rgm > 7200) {
                this.blockSize = 35;
                this.HkW = 1.2f;
                this.Rgp = 1.2f;
                this.Rgo = 0;
                this.Rgm = 0;
                this.Rgt = false;
                this.Rgu = 0;
                this.Rgn = 6;
                this.Rgy.clear();
                this.Rgv.clear();
                this.Rgw.clear();
            }
            if (Math.abs(length - this.Rgp) < 4.0f) {
                if (length <= 4.2f) {
                    f3 = length;
                }
                this.HkW = (f3 * 0.5f) + (this.Rgp * 0.5f);
            }
            this.Rgp = this.HkW;
            AppMethodBeat.o(190274);
            return;
        }
        this.Rgx[this.Rgu] = 2.0f * f2;
        this.Rgu++;
        AppMethodBeat.o(190274);
    }

    private static int a(ByteBuffer byteBuffer, int i2, int i3) {
        AppMethodBeat.i(190275);
        int i4 = byteBuffer.get(i3) & 255;
        int i5 = byteBuffer.get(i3 - 1) & 255;
        int i6 = byteBuffer.get(i3 - 2) & 255;
        int i7 = byteBuffer.get(i3 + 1) & 255;
        int i8 = byteBuffer.get(i3 + 2) & 255;
        int i9 = byteBuffer.get(i3 - i2) & 255;
        int i10 = byteBuffer.get(i3 - (i2 * 2)) & 255;
        int i11 = byteBuffer.get(i3 + i2) & 255;
        int i12 = byteBuffer.get((i2 * 2) + i3) & 255;
        int i13 = ((((i4 * 4) - (byteBuffer.get((i3 - i2) - 1) & 255)) - (byteBuffer.get((i3 - (i2 * 2)) - 2) & 255)) - (byteBuffer.get((i3 + i2) + 1) & 255)) - (byteBuffer.get(((i2 * 2) + i3) + 2) & 255);
        int i14 = (((i4 * 4) - (byteBuffer.get((i3 - i2) + 1) & 255)) - (byteBuffer.get((i3 - (i2 * 2)) + 2) & 255)) - (byteBuffer.get((i3 + i2) - 1) & 255);
        int abs = Math.abs(((((i4 * 4) - i5) - i6) - i9) - i10);
        int abs2 = Math.abs(((((i4 * 4) - i11) - i12) - i7) - i8) + abs + Math.abs(((((i4 * 4) - i5) - i6) - i7) - i8) + Math.abs(((((i4 * 4) - i9) - i10) - i11) - i12) + Math.abs(i13) + Math.abs(i14 - (byteBuffer.get(((i2 * 2) + i3) - 2) & 255)) + Math.abs(((((i4 * 4) - i9) - i10) - i7) - i8) + Math.abs(((((i4 * 4) - i5) - i6) - i11) - i12);
        AppMethodBeat.o(190275);
        return abs2;
    }

    private void a(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(190276);
        int i6 = this.blockSize / 5;
        for (int i7 = 0; i7 < i6; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                int i9 = i4 + (i7 * 5);
                int i10 = i3 + (i8 * 5);
                int i11 = i7 * 5;
                int i12 = i8 * 5;
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                float f5 = 0.0f;
                int i13 = i12 + 2 + ((i11 + 2) * this.blockSize) + (this.blockSize * i5 * this.blockSize);
                int a2 = a(byteBuffer, i2, i10 + 2 + ((i9 + 2) * i2));
                int a3 = a(this.Rgw, this.blockSize, i13);
                for (int i14 = 0; i14 < 5; i14++) {
                    for (int i15 = 0; i15 < 5; i15++) {
                        int i16 = i10 + i15 + ((i9 + i14) * i2);
                        int i17 = i12 + i15 + ((i11 + i14) * this.blockSize) + (this.blockSize * i5 * this.blockSize);
                        f3 += (float) byteBuffer.get(i16);
                        f5 += (float) this.Rgw.get(i17);
                        f2 += (float) (byteBuffer.get(i16) * byteBuffer.get(i16));
                        f4 += (float) (this.Rgw.get(i17) * this.Rgw.get(i17));
                    }
                }
                n nVar = new n(false, a2, (f2 / 25.0f) - ((f3 / 25.0f) * (f3 / 25.0f)));
                n nVar2 = new n(true, a3, ((f4 / 25.0f) - ((f5 / 25.0f) * (f5 / 25.0f))) / 2.0f);
                this.Rgy.add(nVar);
                this.Rgy.add(nVar2);
            }
        }
        AppMethodBeat.o(190276);
    }

    private static float bs(ArrayList<n> arrayList) {
        int i2;
        AppMethodBeat.i(190277);
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i3 = 16;
        int i4 = 0;
        int i5 = 0;
        if (arrayList == null || arrayList.size() < 16) {
            AppMethodBeat.o(190277);
            return 1.2f;
        }
        int i6 = 0;
        while (i6 < i3) {
            n nVar = arrayList.get(i6);
            boolean z = nVar.RgJ;
            float f4 = nVar.RgL;
            if (((double) f4) > 5.0d) {
                i3--;
                i2 = i5;
            } else if (!z) {
                f2 += f4;
                i4++;
                i2 = i5;
            } else {
                f3 += f4;
                i2 = i5 + 1;
            }
            i6++;
            i5 = i2;
        }
        float f5 = i4 != 0 ? f2 / ((float) i4) : 1.2f;
        float f6 = i5 != 0 ? f3 / ((float) i5) : 1.2f;
        if (i3 != 0) {
            float f7 = (((f6 / 2.0f) + (f5 / 3.5f)) * (((float) i4) / ((float) i3))) + ((((float) i5) / ((float) i3)) * ((f5 / 2.0f) + f6));
            AppMethodBeat.o(190277);
            return f7;
        }
        AppMethodBeat.o(190277);
        return 1.2f;
    }

    private void bt(ArrayList<n> arrayList) {
        AppMethodBeat.i(190278);
        Collections.sort(arrayList, new Comparator<Object>() {
            /* class com.tencent.mm.cm.a.k.AnonymousClass1 */

            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i2 = ((n) obj).RgK;
                int i3 = ((n) obj2).RgK;
                if (i3 < i2) {
                    return 1;
                }
                if (i2 < i3) {
                    return -1;
                }
                return 0;
            }
        });
        AppMethodBeat.o(190278);
    }

    private void lV(int i2, int i3) {
        AppMethodBeat.i(190279);
        int i4 = (i2 / 2) - this.blockSize;
        int i5 = (i3 / 3) - this.blockSize;
        int random = (int) (Math.random() * ((double) i4));
        this.Rgz[0] = (int) (Math.random() * ((double) i5));
        this.Rgz[1] = random;
        int random2 = (int) ((Math.random() * ((double) i4)) + ((double) (i2 / 2)));
        this.Rgz[2] = (int) (Math.random() * ((double) i5));
        this.Rgz[3] = random2;
        int random3 = (int) (Math.random() * ((double) (i4 * 2)));
        this.Rgz[4] = (int) ((Math.random() * ((double) i5)) + ((double) (i3 / 3)));
        this.Rgz[5] = random3;
        int random4 = (int) (Math.random() * ((double) i4));
        this.Rgz[6] = (int) ((Math.random() * ((double) i5)) + ((double) ((i3 * 2) / 3)));
        this.Rgz[7] = random4;
        int random5 = (int) ((Math.random() * ((double) i5)) + ((double) ((i3 * 2) / 3)));
        int random6 = (int) ((Math.random() * ((double) i4)) + ((double) (i2 / 2)));
        this.Rgz[8] = random5;
        this.Rgz[9] = random6;
        AppMethodBeat.o(190279);
    }

    public final int R(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(190280);
        int b2 = b(ByteBuffer.wrap(bArr), i2, i3);
        AppMethodBeat.o(190280);
        return b2;
    }

    public final int b(ByteBuffer byteBuffer, int i2, int i3) {
        AppMethodBeat.i(190281);
        if (byteBuffer == null || i2 == 0 || i3 == 0 || i2 < 320 || i3 < 100 || i2 > 1280 || i3 > 720) {
            AppMethodBeat.o(190281);
            return 4;
        }
        if (i2 != 0 && i2 == this.Rgr && i3 == this.Rgs) {
            this.RgB = false;
        } else {
            this.Rgr = i2;
            this.Rgs = i3;
            this.RgB = true;
            if (this.Rgw == null) {
                this.Rgw = ByteBuffer.allocate(this.blockSize * this.blockSize * 5);
            }
            if (this.Rgv == null) {
                this.Rgv = ByteBuffer.allocate(this.blockSize * this.blockSize * 5);
            }
        }
        o oVar = new o();
        int[] iArr = {0};
        lV(i2, i3);
        this.Rgm++;
        this.Rgt = this.Rgm % this.Rgn == 0;
        for (int i4 = 0; i4 < 5; i4++) {
            int i5 = this.RgA[i4 * 2];
            int i6 = this.RgA[(i4 * 2) + 1];
            int i7 = this.Rgz[i4 * 2];
            int i8 = this.Rgz[(i4 * 2) + 1];
            oVar.RgM[i4] = a(byteBuffer, i2, i3, i6, i5, i8, i7, iArr, i4);
            this.RgA[i4 * 2] = i7;
            this.RgA[(i4 * 2) + 1] = i8;
        }
        oVar.RgN.HkV = oVar.RgM[0].HkV + oVar.RgM[1].HkV + oVar.RgM[2].HkV + oVar.RgM[3].HkV + oVar.RgM[4].HkV;
        oVar.RgN.RgI = ((((oVar.RgM[0].RgI + oVar.RgM[1].RgI) + oVar.RgM[2].RgI) + oVar.RgM[3].RgI) + oVar.RgM[4].RgI) / 5.0f;
        oVar.RgN.RgH = ((((oVar.RgM[0].RgH + oVar.RgM[1].RgH) + oVar.RgM[2].RgH) + oVar.RgM[3].RgH) + oVar.RgM[4].RgH) / 5.0f;
        if (this.Rgt && !this.RgB) {
            bt(this.Rgy);
            float bs = bs(this.Rgy);
            this.Rgy.clear();
            cI(bs);
        }
        if (oVar.RgN.RgH > aC(this.HkW, oVar.RgN.RgI) * this.HkW * 2.0f || oVar.RgN.HkV >= 5) {
            this.Rgo = 0;
            AppMethodBeat.o(190281);
            return 5;
        } else if (this.Rgo > 3) {
            AppMethodBeat.o(190281);
            return 0;
        } else {
            this.Rgo++;
            AppMethodBeat.o(190281);
            return 4;
        }
    }

    private m a(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int i8) {
        int i9;
        AppMethodBeat.i(190282);
        m mVar = new m();
        if (i4 < 0 || i5 < 0 || i4 >= i2 || i5 >= i3) {
            mVar.HkV = 1;
            mVar.RgH = 255.0f;
        }
        int i10 = iArr[0];
        int i11 = 0;
        int i12 = 0;
        if (!this.RgB) {
            for (int i13 = 0; i13 < this.blockSize; i13++) {
                for (int i14 = 0; i14 < this.blockSize; i14++) {
                    int i15 = i4 + i14 + ((i5 + i13) * i2);
                    int i16 = i6 + i14 + ((i7 + i13) * i2);
                    int i17 = byteBuffer.get(i15) < 0 ? byteBuffer.get(i15) + 255 : byteBuffer.get(i15);
                    if (this.Rgv.get(i10) < 0) {
                        i9 = this.Rgv.get(i10) + 255;
                    } else {
                        i9 = this.Rgv.get(i10);
                    }
                    int abs = Math.abs(i9 - i17);
                    i11 += abs;
                    i12 += byteBuffer.get(i15);
                    this.Rgv.put(i10, byteBuffer.get(i16));
                    this.Rgw.put(i10, (byte) abs);
                    i10++;
                }
            }
        } else {
            for (int i18 = 0; i18 < this.blockSize; i18++) {
                for (int i19 = 0; i19 < this.blockSize; i19++) {
                    int abs2 = Math.abs(0);
                    this.Rgv.put(i10, byteBuffer.get(i6 + i19 + ((i7 + i18) * i2)));
                    this.Rgw.put(i10, (byte) abs2);
                    i10++;
                }
            }
        }
        iArr[0] = i10;
        mVar.RgH = ((float) i11) / ((float) (this.blockSize * this.blockSize));
        mVar.RgI = ((float) i12) / ((float) (this.blockSize * this.blockSize));
        mVar.RgI = mVar.RgI < 0.0f ? mVar.RgI + 255.0f : mVar.RgI;
        mVar.HkV = 0;
        if (this.Rgt && !this.RgB) {
            a(byteBuffer, i2, i4, i5, i8);
        }
        float aC = aC(this.HkW, mVar.RgI);
        if ((mVar.RgI < 100.0f && mVar.RgH > this.HkW * aC * 0.8f) || (mVar.RgI > 100.0f && (mVar.RgH > aC * this.HkW * 0.65f || mVar.RgI > 250.0f))) {
            mVar.HkV = 1;
        }
        AppMethodBeat.o(190282);
        return mVar;
    }

    private float aC(float f2, float f3) {
        float f4;
        if (f3 < 80.0f) {
            f4 = -0.5f;
        } else if (f3 < 120.0f) {
            f4 = 0.0f;
        } else {
            f4 = 0.5f;
        }
        if (this.Rgq) {
            f4 += 1.0f;
        }
        if (f2 < 0.8f) {
            return 5.0f - f4;
        }
        if (f2 < 1.5f) {
            return 4.5f - f4;
        }
        if (f2 < 2.4f) {
            return 4.0f - f4;
        }
        return 3.5f - f4;
    }

    public final float hff() {
        float f2 = 0.032f;
        float f3 = this.HkW * 0.016f;
        if (f3 <= 0.032f) {
            f2 = f3;
        }
        if (f2 < 0.016f) {
            return 0.016f;
        }
        return f2;
    }
}
