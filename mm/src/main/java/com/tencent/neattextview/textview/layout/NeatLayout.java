package com.tencent.neattextview.textview.layout;

import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.a.a;

public class NeatLayout extends c {
    private int RBI = 0;

    private native int nComputeBreak(String str, float[] fArr, float[] fArr2, float f2, int[] iArr, float[] fArr3, float f3, boolean[] zArr, char[] cArr, float[] fArr4, char[] cArr2, float[] fArr5, boolean[] zArr2);

    static {
        AppMethodBeat.i(39759);
        System.loadLibrary("linebreak");
        AppMethodBeat.o(39759);
    }

    public NeatLayout(CharSequence charSequence, float[] fArr) {
        super(charSequence, fArr);
    }

    @Override // com.tencent.neattextview.textview.layout.c
    public final void a(TextPaint textPaint, float[] fArr, float f2, int i2, boolean z) {
        float f3;
        float f4;
        float f5;
        AppMethodBeat.i(192277);
        float round = (float) Math.round(textPaint.getTextSize() / 2.0f);
        float textSize = z ? textPaint.getTextSize() / 6.0f : 0.0f;
        int length = this.RAP.length();
        int[] iArr = new int[length];
        float[] fArr2 = new float[length];
        boolean[] zArr = new boolean[length];
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = fArr[i3] + round;
        }
        int nComputeBreak = nComputeBreak(this.RAP, this.RAR, fArr, f2 + round, iArr, fArr2, textSize, zArr, a.RAK, this.RAU, a.RAJ, this.RAT, this.RBq);
        this.RBI = nComputeBreak;
        float f6 = 0.0f;
        int i4 = 0;
        while (i4 < nComputeBreak && i4 < i2) {
            float f7 = fArr2[i4];
            if (i4 < fArr.length) {
                f5 = fArr[i4];
            } else {
                f5 = f2;
            }
            if (f6 < f7) {
                f6 = Math.min(f7, f5);
            }
            i4++;
        }
        int i5 = 0;
        int i6 = 0;
        while (i6 < nComputeBreak && i6 < i2) {
            int i7 = iArr[i6];
            boolean z2 = zArr[i6];
            int i8 = i7 - i5;
            float f8 = i6 < fArr.length ? fArr[i6] - round : f2;
            float f9 = 0.0f;
            float f10 = f8 - fArr2[i6];
            if (f10 > 0.0f) {
                f3 = f10 - 2.0f;
            } else {
                f3 = f10;
            }
            boolean z3 = f3 < 0.0f || Math.abs(f3) - 1.0f <= round;
            if (z3) {
                if (i7 - 1 >= 0 && this.RAQ[i7 - 1] == '\n') {
                    i8--;
                }
                for (int i9 = i5; i9 < i7; i9++) {
                    if (this.RAQ[i9] != '\n' && this.RAR[i9] == 0.0f) {
                        i8--;
                    }
                }
                f9 = f3 / ((float) (Math.max(2, i8) - 1));
            }
            float f11 = z3 ? f8 : fArr2[i6];
            char[] cArr = this.RAQ;
            float[] fArr3 = this.RAR;
            int size = this.RAX.size();
            if (z3) {
                f4 = f8;
            } else {
                f4 = f6;
            }
            a(cArr, i5, i7, f11, fArr3, size, f9, z2, textSize, f4);
            i6++;
            i5 = i7;
        }
        AppMethodBeat.o(192277);
    }

    @Override // com.tencent.neattextview.textview.layout.c, com.tencent.neattextview.textview.layout.a
    public final int hiG() {
        return this.RBI;
    }
}
